package pageobjects.map;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browsersetup.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class MAPSynchronization extends BaseClass {

	public MAPSynchronization(AndroidDriver androiddriver) {
		setAndroidDriver(androiddriver);
		PageFactory.initElements(new AjaxElementLocatorFactory(getAndroidDriver(), 240), this);
	}

	@FindBy(xpath = "//a[@id='on-click-sync-now-button']")
	public WebElement syncNow;
	
	@FindBy(xpath = "//p[contains(text(),'Synchronizing, please wait ...')]")
	public WebElement syncWait;
	
	@FindBy(xpath = "//button[@id='syncronization-button']")
	public WebElement synHamburger;
	
	public MAPSynchronization clickSynchronization()
	{
		syncNow.click();
		return new MAPSynchronization(getAndroidDriver());
	}
	
	public MAPSynchronization clickSynHamburger()
	{
		synHamburger.click();
		return new MAPSynchronization(getAndroidDriver());
	}
}
