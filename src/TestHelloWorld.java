import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestHelloWorld {

	public void testIE(){
	      System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\iexplore.exe"); 
//	    	WebDriver driver = new InternetExplorerDriver();		
	}
	
	public void testChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Chrome\\chrome.exe"); 
        
//      ChromeDriverService service = new ChromeDriverService.Builder()
//
//      .usingDriverExecutable(new File("C:\\e\\download\\sele\\Selenium ChromeDriver 2.22\\chromedriver_win32\\chromedriver.exe"))
//                      .usingAnyFreePort().build();
//              service.start();        
//     WebDriver driver = new RemoteWebDriver(service.getUrl(),
//             DesiredCapabilities.chrome());		
//      WebDriver driver = new ChromeDriver();
	}
	
	public static void testWeixin(WebDriver driver){
        driver.get("http://weixin.sogou.com/weixin?type=1&query=%E5%86%B7%E5%85%94");
        
        driver.manage().window().maximize();
        
        List<WebElement> items = driver.findElements(By.cssSelector("div[class='wx-rb bg-blue wx-rb_v1 _item']"));
        String pburl = null;
        WebElement ee =null;
        for (WebElement item:items){
//        	WebElement a = item.findElement(By.cssSelector("a[class='blue']"));
//        	pburl = a.getAttribute("href");
        	item.click();
            String curr = driver.getWindowHandle();
            Set<String> windows = driver.getWindowHandles();
            for (String win:windows){
            	if (win.equalsIgnoreCase(curr)) continue;
                WebDriver dd = driver.switchTo().window(win);
                System.out.println(dd.getTitle()+","+dd.getCurrentUrl());
                List<WebElement> ea = dd.findElements(By.cssSelector("h4[class='weui_media_title']"));
                for (WebElement item2:ea){
                	String url = "http://mp.weixin.qq.com"+item2.getAttribute("hrefs");
                	dd.get(url);
                    System.out.println("aaa "+dd.getTitle()+","+dd.getCurrentUrl());

                }
            }
        	break;
        }
	}
	
	public static void test36kr(WebDriver driver){
        driver.get("http://36kr.com");
		System.out.println(driver.getPageSource());
	}
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); 
       
        //如果火狐浏览器没有默认安装在C盘，需要制定其路径
      WebDriver driver = new FirefoxDriver();
      
      TestHelloWorld.test36kr(driver);

        

    }

}