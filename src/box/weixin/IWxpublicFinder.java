package box.weixin;

import java.util.List;

import org.openqa.selenium.WebDriver;

import box.weixin.model.Wxpublic;

public interface IWxpublicFinder {

	List<Wxpublic> findWxpublics(WebDriver driver);
}
