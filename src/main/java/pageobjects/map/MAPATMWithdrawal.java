package pageobjects.map;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import browsersetup.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class MAPATMWithdrawal extends BaseClass {

	String table="//table[@class='pure-table table-customer-details']/tbody/tr";
	public MAPATMWithdrawal(AndroidDriver androiddriver) {
		setAndroidDriver(androiddriver);
		PageFactory.initElements(new AjaxElementLocatorFactory(getAndroidDriver(), 60), this);
	}

	//@FindBy(xpath = "//button[@id='atm-withdrawal-hambuger-button']")
	@FindBy(xpath = "//button[contains(@id,'atm-withdrawal')]")
	public WebElement ATMWithdrawalHamburger;
	
	@FindBy(xpath = "//input[@id='withdraw-amout']")
	public WebElement withdrawalAmmount;
	
	@FindBy(xpath = "//select[@ng-model='withdrawal.UFcard']")
	public WebElement fromCard;
	
	@FindBy(xpath = "//a[@id='confirm-ATM-withdrawal-button']")
	public WebElement confirmATMwithdrawalbutton;
	
	@FindBy(xpath = "//button[@id='confirm-atm-modal-button']")
	public WebElement confirmatmmodalbutton;
	
	@FindBy(xpath = "//button[@id='cancel-atm-modal-button-2']")
	public WebElement cancelatmmodalbutton2;
	
	@FindBy(xpath = "//div[contains(text(),'Amount')]//following-sibling::div")
	WebElement ATMWithdrawalAmount;
	
	@FindBy(xpath = "//span[contains(@class,'withdrawal-alert')]")
	WebElement withdrawalAlert;
	
	@FindBy(xpath = "//a[@id='on-click-today-atm-button']")
	WebElement todaysATMWithdrawals ;
	
	@FindBy(xpath = "//a[@id='confirm-atm-withdrawal-adjustment']")
	WebElement confirmAtmWithdrawalAdjustment ;
	
	@FindBy(xpath = "//a[@id='on-click-atm-button-2']")
	WebElement cancelAtmWithdrawalAdjustment ;
	
	//@FindBy(xpath = "//button[contains(@class,'modal-confirm-button')]")
	//@FindBy(xpath = "/html/body/div[5]/div[2]/ion-modal-view/div/button[2]")
	@FindBy(xpath = "//div[@class='modal-backdrop active']//button[contains(@class,'modal-confirm-button')]")
	public WebElement Adjustmentconfirmatmmodalbutton;
	
	@FindBy(xpath = "//div[@class='modal-backdrop active']//button[contains(@class,'modal-cancel-button')]")
	public WebElement AdjustmentCancelatmmodalbutton;
	
	@FindBy(xpath = "//div[@class='today-atm-title']")
	public WebElement todayAtmTitle;
	
	@FindBy(xpath = "//p[@ng-show='correctAmount2']")
	WebElement adjustmentWithdrawalAlert;
	
	public MAPATMWithdrawal clickATMwithdrawalHamburger()
	{
		ATMWithdrawalHamburger.click();
		return new MAPATMWithdrawal(getAndroidDriver());
	}
	
	public MAPATMWithdrawal enterWithdrawalAmmount(String ammount)
	{
		withdrawalAmmount.sendKeys(ammount);
		return new MAPATMWithdrawal(getAndroidDriver());
	}
	
	public MAPATMWithdrawal selectFromCard(String card)
	{
		Select s1= new Select(fromCard);
		s1.selectByVisibleText(card);
		return new MAPATMWithdrawal(getAndroidDriver());
	}
	
	public MAPATMWithdrawal clickConfirmATMwithdrawalbutton()
	{
		confirmATMwithdrawalbutton.click();
		return new MAPATMWithdrawal(getAndroidDriver());
	}
	
	public MAPATMWithdrawal clickConfirmatmmodalbutton()
	{
		confirmatmmodalbutton.click();
		return new MAPATMWithdrawal(getAndroidDriver());
	}
	
	public MAPATMWithdrawal clickCancelatmmodalbutton2()
	{
		cancelatmmodalbutton2.click();
		return new MAPATMWithdrawal(getAndroidDriver());
	}
	
	public String verifyATMWithdrawalAmount()
	{
		return ATMWithdrawalAmount.getText();
	}
	
	public String verifyATMWithdrawalAlert()
	{
		return withdrawalAlert.getText();
	}
	
	public MAPATMWithdrawal clickTodaysATMWithdrawals()
	{
		todaysATMWithdrawals.click();
		return new MAPATMWithdrawal(getAndroidDriver());
	}
	
	public MAPATMWithdrawal enterAdjustmentAmmount(String Amount)
	{
		// List<WebElement> size=(List<WebElement>) getAndroidDriver().findElement(By.xpath(table));
		// size.size();
		//WebElement AdjustmentAmount=getAndroidDriver().findElement(By.xpath(table+"["+size.size()+"]//input[@ng-model='wd.amount']"));
		List<WebElement> rows = getAndroidDriver().findElements(By.xpath("//tr[contains(@ng-repeat,'wd in todayWithdrawals')]")); 
		System.out.println("row size "+rows.size()); 
		WebElement AdjustmentAmount=getAndroidDriver().findElement(By.xpath(table+"["+String.valueOf(rows.size())+"]//input[@ng-model='wd.amount']"));
		AdjustmentAmount.clear();
		AdjustmentAmount.sendKeys(Amount);
		getAndroidDriver().hideKeyboard();
		return new MAPATMWithdrawal(getAndroidDriver());
	}
	
	public String verifyAdjustmentAmmount()
	{
		List<WebElement> rows = getAndroidDriver().findElements(By.xpath("//tr[contains(@ng-repeat,'wd in todayWithdrawals')]")); 
		System.out.println("row size "+rows.size()); 
		WebElement AdjustmentAmount=getAndroidDriver().findElement(By.xpath(table+"["+String.valueOf(rows.size())+"]//input[@ng-model='wd.amount']"));
		
		return AdjustmentAmount.getText();
	}
	
	public MAPATMWithdrawal selectAdjustmentCard(String Card)
	{
		List<WebElement> rows = getAndroidDriver().findElements(By.xpath("//tr[contains(@ng-repeat,'wd in todayWithdrawals')]")); 
		System.out.println("row size "+rows.size()); 
		WebElement AdjustmentCard=getAndroidDriver().findElement(By.xpath(table+"["+String.valueOf(rows.size())+"]//select[contains(@dir,'rtl')]"));
		Select s1= new Select(AdjustmentCard);
		s1.selectByValue(Card);
		return new MAPATMWithdrawal(getAndroidDriver());
	}
	
	public MAPATMWithdrawal clickConfirmAtmWithdrawalAdjustment()
	{
		confirmAtmWithdrawalAdjustment.click();
		return new MAPATMWithdrawal(getAndroidDriver());
	}
	
	public MAPATMWithdrawal clickCancelAtmWithdrawalAdjustment()
	{
		cancelAtmWithdrawalAdjustment.click();
		return new MAPATMWithdrawal(getAndroidDriver());
	}
	
	public MAPATMWithdrawal clickAdjustmentconfirmatmmodalbutton()
	{
		/*if(Adjustmentconfirmatmmodalbutton.isDisplayed())
		{*/
		Adjustmentconfirmatmmodalbutton.click();
		//}
		return new MAPATMWithdrawal(getAndroidDriver());
	}
	
	public MAPATMWithdrawal clickAdjustmentCancelatmmodalbutton()
	{
		AdjustmentCancelatmmodalbutton.click();
		return new MAPATMWithdrawal(getAndroidDriver());
	}
	
	public String verifyTodayAtmTitle()
	{
		return todayAtmTitle.getText();
	}
	
	public String verifyAdjustmentWithdrawalAlert()
	{
		return adjustmentWithdrawalAlert.getText();
	}
}
