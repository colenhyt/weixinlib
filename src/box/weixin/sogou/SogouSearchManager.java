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
import org.openqa.selenium.firefox.FirefoxProfile;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.proxy.SimpleProxyPool;
import box.weixin.IProcessCallback;
import box.weixin.PagesGetProcessor;
import box.weixin.WxpublicPageParser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import es.download.flow.DownloadContext;
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
	private SimpleProxyPool proxyPool;

	public static void main(String[] args){
		SogouSearchManager.getInstance().init();
//		SogouSearchManager.getInstance().process();
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
		
		boolean success = fetchPage(word);
       
		if (!success){
			log.warn("could not fetch page for :"+word);
			return;			
		}
       
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
	
	public boolean fetchPage(String word){
		 driver.get("http://weixin.sogou.com/weixin?type=1&query="+word);
	     driver.manage().window().maximize();

	     String source = driver.getPageSource();
	     //切换代理IP
	     if (source.indexOf("频繁超时")>0){
	    	 
	    	 return fetchPage(word);
	     }
        List<WebElement> items = driver.findElements(By.cssSelector("div[class='results mt7']"));
		 
		return false;
	}
	
	public void init(){
	      System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\iexplore.exe");
	      
	      String userAgent = DownloadContext.getSpiderContext().getUserAgent();
	     // proxyPool = new SimpleProxyPool(true,userAgent);
	      
	      FirefoxProfile profile = new FirefoxProfile();
	      
	      //自动代理配置
//	      profile.setPreference("network.proxy.type", 2);
//	      profile.setPreference("network.proxy.autoconfig_url", "http://proxy.myweb.com:8083"); //
	      
	      //手工代理:
	      profile.setPreference("network.proxy.type", 1);
	      //http proxy:
	      profile.setPreference("network.proxy.http", "101.201.235.141");
	      profile.setPreference("network.proxy.http_port", 11);//8000
	      
	      //socket proxy
//	      profile.setPreference("network.proxy.socks","58.222.254.1");
//	      profile.setPreference("network.proxy.socks_port", 312);
//	      profile.setPreference("network.proxy.ssl","58.222.254.1");
//	      profile.setPreference("network.proxy.ssl_port", 312);
	      
	      driver = new FirefoxDriver(profile);
	      driver.get("http://news.baidu.com");
	      log.warn(driver.getTitle());
	}
}
