package box.weixin;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import box.weixin.model.Wxpublic;

public class WxpublicPageParser {
	
	public boolean parse(WebDriver wxpubDriver){
		if (this.articleUrls==null)
			this.articleUrls = new ArrayList<String>();
		else
			this.articleUrls.clear();
		
        List<WebElement> ea = wxpubDriver.findElements(By.cssSelector("h4[class='weui_media_title']"));
        for (WebElement item2:ea){
        	String url = "http://mp.weixin.qq.com"+item2.getAttribute("hrefs");
        	this.articleUrls.add(url);

        }		
		return this.articleUrls.size()>0;
	}
	
	public boolean parse(Document doc){
		return false;
	}
	
	public Wxpublic getWxpublic() {
		return wxpublic;
	}
	public void setWxpublic(Wxpublic wxpublic) {
		this.wxpublic = wxpublic;
	}
	public List<String> getArticleUrls() {
		return articleUrls;
	}
	public void setArticleUrls(List<String> articleUrls) {
		this.articleUrls = articleUrls;
	}
	Wxpublic wxpublic;
	List<String> articleUrls;

}
