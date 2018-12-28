package pageobjects.map;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import browsersetup.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class MAPRecycleCash extends BaseClass {

	public MAPRecycleCash(AndroidDriver androiddriver) {
		setAndroidDriver(androiddriver);
		PageFactory.initElements(new AjaxElementLocatorFactory(getAndroidDriver(), 60), this);
	}

	@FindBy(xpath = "//input[@id='recycle-amout']")
	WebElement recycleAmout;
	
	@FindBy(xpath = "//select[@ng-model='reff.val']")
	WebElement  Recipient;
	
	@FindBy(xpath = "//a[@id='confirm-recycle-cash-button']")
	WebElement  confirmRecycleCashButton;
	
	@FindBy(xpath = "//div[@class='modal-backdrop active']//button[@id='accept-recycle-cash-confirmation-modal']")
	public WebElement RecycleConfirmmodalbutton;
	
	@FindBy(xpath = "//div[@class='modal-backdrop active']//button[@id='close-recycle-cash-confirmation-modal-2']")
	public WebElement RecycleCancelmodalbutton;
	
	public MAPRecycleCash enterRecycleAmount(String amount) throws InterruptedException
	{
		System.out.println("Amount "+amount);
		//recycleAmout.clear();
		Thread.sleep(2000);
		recycleAmout.sendKeys(amount);
		Thread.sleep(2000);
		getAndroidDriver().hideKeyboard();
		return new MAPRecycleCash(getAndroidDriver());
	}
	
	public String VerifyRecycleAmountLimit()
	{
		System.out.println("Class Atribute Name"+ recycleAmout.getAttribute("class"));
			return recycleAmout.getAttribute("class");
	}
	
	public MAPRecycleCash selectRecipient(String recipent)
	{
		Select S1= new Select(Recipient);
		S1.selectByVisibleText(recipent);
		return new MAPRecycleCash(getAndroidDriver());
	}
	
	public MAPRecycleCash ClickConfirmRecycleCashButton()
	{
		confirmRecycleCashButton.click();
		return new MAPRecycleCash(getAndroidDriver());
	}
	
	public MAPRecycleCash ClickRecycleConfirmmodalButton()
	{
		RecycleConfirmmodalbutton.click();
		return new MAPRecycleCash(getAndroidDriver());
	}
	
	public MAPRecycleCash ClickRecycleCancelmodalbutton()
	{
		RecycleCancelmodalbutton.click();
		return new MAPRecycleCash(getAndroidDriver());
	}
}
