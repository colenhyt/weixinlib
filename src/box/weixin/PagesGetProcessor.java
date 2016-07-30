package box.weixin;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.ProxyPool;
import us.codecraft.webmagic.proxy.SimpleProxyPool;
import easyshop.html.HTMLInfoSupplier;
import es.download.flow.DownloadContext;
import es.util.FileUtil;
import es.util.string.StringHelper;

public class PagesGetProcessor implements PageProcessor{
	protected Logger  log = Logger.getLogger(getClass());
	int queryCount;
	public String startUrl;
	String sitekey;
	private String pagesPath;
	HTMLInfoSupplier infoSupp = new HTMLInfoSupplier();
	private List<String> otherUrls = new ArrayList<String>();
	String urlPath;
	private Site site;
	private IProcessCallback callback = null;

	public PagesGetProcessor(String pagePath,String sitekey,List<String> urls){
		this(pagePath,sitekey,urls,null);
	}

	public PagesGetProcessor(String pagePath,String sitekey,List<String> urls,IProcessCallback _callback){
		
		queryCount = urls.size();
		
		startUrl = urls.get(0);
		
		callback = _callback;
		
		for (int i=1;i<urls.size();i++){
			otherUrls.add(urls.get(i));
		}
		
		pagesPath = pagePath+sitekey;
			
		site = new Site();
		String userAgent = DownloadContext.getSpiderContext().getUserAgent();
		site.addHeader("User-Agent", userAgent);
		Set<Integer> codes = new HashSet<Integer>();
		codes.add(200);
		codes.add(404);
		List<String[]> httpProxyList = new ArrayList<String[]>();
		String[] ss = new String[4];
		ss[0] = null;
		ss[1] = null;
		ss[2] = "42.159.251.84";
		ss[3] = "333";
		httpProxyList.add(ss);
		SimpleProxyPool proxyPool = new SimpleProxyPool(userAgent,"/");
		//使用代理:
		if (proxyPool.getIdleNum()>0)
			site.setHttpProxyPool(proxyPool);
//		site.setHttpProxyPool(httpProxyList, false);
		site.setAcceptStatCode(codes);
		site.addStartUrl(startUrl);		
	}
	
	public static void main(String[] args) {
		List<String> urls = new ArrayList<String>();
		urls.add("https://news.baidu.com");
//		urls.add("http://mp.weixin.qq.com/s?timestamp=1469172587&src=3&ver=1&signature=BPww-x2-tVgeWbZykaSLAzAgidakIWiK3cFtEwCuUeuP7wC7kx9kyUJQs3xplgeyc0cq6KHspkdu7DoEqWgdtLW1*qJku0drRIaruSOcQCXu0Jkw7Vzjy3IMW47FjJeWeiFFCMpMJoT*bPPnGkrltGGCrCaGKsJbhjaku7SYmtw=");
		
		PagesGetProcessor process = new PagesGetProcessor("data/articles2/","leijun2",urls);
		try {
		Spider.create(process).run();
		}catch (Exception e){
			//
			if (e instanceof ConnectException){
				System.out.println("aaa");
			}
		}
	}

	@Override
	public void process(Page page) {
		
		String pageContent = page.getRawText();
		String charset = page.getCharset();
		if (page.getCharset().equalsIgnoreCase("gbk")||page.getCharset().equalsIgnoreCase("gb2312")){
			pageContent = StringHelper.gbk2utf8(page.getRawText());
			charset = "utf-8";
		}
		 
		//保存网页:
		String fileName = page.getRequest().getUrl().hashCode()+".html";
		String pagePath = pagesPath +"/"+fileName;
		FileUtil.writeFile(pagePath, pageContent,charset);
		
		 if (otherUrls.size()>0){
			page.addTargetRequests(otherUrls);	
			otherUrls.clear();
		 }
		
		 queryCount--;
		 if (queryCount<=0){
			 if (callback!=null)
				 callback.onProcessCallback(sitekey);
		 }
		
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
	}

	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

}
