package box.weixin.sogou;

import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import us.codecraft.webmagic.Spider;
import box.weixin.IProcessCallback;
import box.weixin.PagesGetProcessor;
import box.weixin.WxpublicPageParser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import es.util.FileUtil;
import es.util.url.URLStrHelper;


public class SogouSearchManager implements IProcessCallback{
	protected Logger  log = Logger.getLogger(getClass()); 
	private static SogouSearchManager uniqueInstance = null;
	Queue<String> pbs = new LinkedBlockingQueue<String>();
	private WxpublicPageParser pbPageParser = new WxpublicPageParser();
	private WebDriver driver ;
	public JSONObject cfgObj;
	private String articlePath;

	public static void main(String[] args){
		SogouSearchManager.getInstance().init();
		SogouSearchManager.getInstance().process();
	}
	
	public static SogouSearchManager getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new SogouSearchManager();
		}
		return uniqueInstance;
	}
	
	public SogouSearchManager(){
		String path = "src/";
		String cfgstr = FileUtil.readFile(path + "config.properties");
		cfgObj = JSON.parseObject(cfgstr);
		String rpath = cfgObj.getString("rootPath");
		
		articlePath = rpath+"articles/";
		
		String content = FileUtil.readFile(rpath+"source.pbs");
		List<String> pblist = (List<String>)JSON.parse(content);
		for (String pb:pblist){
			pbs.add(pb);
		}
		
	}
	
	public void process(){
		if (pbs.size()<=0){
			log.warn("no public to search");
			return;
		}
		
		String word = pbs.poll();
		pbs.peek();
		word = URLStrHelper.toUtf8String(word);
       driver.get("http://weixin.sogou.com/weixin?type=1&query="+word);
       
       driver.manage().window().maximize();
       
   	try {
       
        List<WebElement> items = driver.findElements(By.cssSelector("div[class='results mt7']"));
        for (WebElement item:items){
	        	WebElement a = item.findElement(By.cssSelector("label[name='em_weixinhao']"));
	        	String pbname = a.getText();
        	if (pbname==null||!pbname.trim().equalsIgnoreCase(word)) continue;
        	
        	WebElement divE = item.findElement(By.cssSelector("div[class='wx-rb bg-blue wx-rb_v1 _item']"));
            String mainWinHandle = driver.getWindowHandle();
            divE.click();
				Thread.sleep(1000);
            Set<String> windows = driver.getWindowHandles();
            for (String win:windows){
            	if (win.equalsIgnoreCase(mainWinHandle)) continue;
                WebDriver wxpubDriver = driver.switchTo().window(win);
                System.out.println(wxpubDriver.getTitle()+","+wxpubDriver.getCurrentUrl());
                boolean parsed = pbPageParser.parse(wxpubDriver);
                wxpubDriver.close();
                if (!parsed){
                	log.warn("could not parse pb page ");
                	continue;
                }
                List<String> urls = pbPageParser.getArticleUrls();
                PagesGetProcessor processor = new PagesGetProcessor(articlePath,pbname,urls,this);
                Spider.create(processor).runAsync();
            }
        	break;
        }		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void onProcessCallback(String wxpublic){
		process();
	}
	
	public void init(){
	      System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\iexplore.exe"); 
	      driver = new FirefoxDriver();
	}
}
