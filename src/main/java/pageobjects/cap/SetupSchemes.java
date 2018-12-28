
package pageobjects.cap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.CommonFunctions;
import utilities.ExcelUtilities;

public class SetupSchemes {
	WebDriverWait wait;
	WebDriver driver;
	public static String ScehemeName="AutoTest"+CommonFunctions.InsertTime();
	public SetupSchemes(WebDriver driver)
	{
		this.driver=driver;
		this.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		 wait = new WebDriverWait(this.driver, 15);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	@FindBy(linkText="Setup Schemes")
	public WebElement SetupScheme;
	
	@FindBy(name="schemeName")
	public WebElement Name;
	
	@FindBy(name="debitBean[1]")
	public WebElement ExsCusmrBand1;
	
	@FindBy(name="debitBean[2]")
	public WebElement ExsCusmrBand2;
	
	@FindBy(name="debitBean[3]")
	public WebElement ExsCusmrBand3;
	
	@FindBy(name="debitBean[4]")
	public WebElement ExsCusmrBand4;
	
	@FindBy(name="maxSaleBean[0]")
	public WebElement MaxSAles1;
	
	@FindBy(name="maxSaleBean[1]")
	public WebElement MaxSAles2;
	
	@FindBy(name="maxSaleBean[2]")
	public WebElement MaxSAles3;
	
	@FindBy(name="maxSaleBean[3]")
	public WebElement MaxSAles4;
	
	@FindBy(name="maxSaleBean[4]")
	public WebElement MaxSAles5;
	
	@FindBy(name="newMaxSale")
	public WebElement NewMAx;
	
	@FindBy(name="maxBalanceBean[0]")
	public WebElement MaxBal1;
	
	@FindBy(name="maxBalanceBean[1]")
	public WebElement MaxBal2;
	
	@FindBy(name="maxBalanceBean[2]")
	public WebElement MaxBal3;
	
	@FindBy(name="maxBalanceBean[3]")
	public WebElement MaxBal4;
	
	@FindBy(name="maxBalanceBean[4]")
	public WebElement MaxBal5;
	
	@FindBy(name="newMaxBalance")
	public WebElement NewMAxBAl;
	
	@FindBy(linkText="Save")
	public WebElement Save;
	
	@FindBy(xpath="/HTML/BODY/FORM/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[1]/TD[2]/B/FONT")
	public WebElement Msg;
	
	
	
	
	
	
	
	
	
	public SetupSchemes SetupSchemesLink()
	{
		SetupScheme.click();
		return new SetupSchemes(driver);
	}
	public SetupSchemes SetName()
	{
		Name.sendKeys(ScehemeName);
		return new SetupSchemes(driver);
	}
	
	
	public SetupSchemes SetExsCusmrBand1(String val)
	{
		ExsCusmrBand1.sendKeys(val);
		return new SetupSchemes(driver);
	}
	public SetupSchemes SetExsCusmrBand2(String val)
	{
		ExsCusmrBand2.sendKeys(val);
		return new SetupSchemes(driver);
	}
	public SetupSchemes SetExsCusmrBand3(String val)
	{
		ExsCusmrBand3.sendKeys(val);
		return new SetupSchemes(driver);
	}
	public SetupSchemes SetExsCusmrBand4(String val)
	{
		ExsCusmrBand4.sendKeys(val);
		return new SetupSchemes(driver);
	}
	public SetupSchemes SetMaxSAles1(String val)
	{
		MaxSAles1.sendKeys(val);
		return new SetupSchemes(driver);
	}
	public SetupSchemes SetMaxSAles2(String val1)
	{
		System.out.println("in 2");
		MaxSAles2.sendKeys(val1);
		return new SetupSchemes(driver);
	}
	public SetupSchemes SetMaxSAles3(String val)
	{
		MaxSAles3.sendKeys(val);
		return new SetupSchemes(driver);
	}
	public SetupSchemes SetMaxSAles4(String val)
	{
		MaxSAles4.sendKeys(val);
		return new SetupSchemes(driver);
	}
	public SetupSchemes SetMaxSAles5(String val)
	{
		MaxSAles5.sendKeys(val);
		return new SetupSchemes(driver);
	}
	public SetupSchemes SetNewMAx(String val)
	{
		NewMAx.sendKeys(val);
		return new SetupSchemes(driver);
	}
	public SetupSchemes SetMaxBal1(String val)
	{
		MaxBal1.sendKeys(val);
		return new SetupSchemes(driver);
	}
	public SetupSchemes SetMaxBal2(String val)
	{
		MaxBal2.sendKeys(val);
		return new SetupSchemes(driver);
	}
	public SetupSchemes SetMaxBal3(String val)
	{
		MaxBal3.sendKeys(val);
		return new SetupSchemes(driver);
	}
	public SetupSchemes SetMaxBal4(String val)
	{
		MaxBal4.sendKeys(val);
		return new SetupSchemes(driver);
	}
	public SetupSchemes SetMaxBal5(String val)
	{
		MaxBal5.sendKeys(val);
		return new SetupSchemes(driver);
	}
	public SetupSchemes SetNewMAxBAl(String val)
	{
		NewMAxBAl.sendKeys(val);
		return new SetupSchemes(driver);
	}
	
	public SetupSchemes SaveLink()
	{
		Save.click();
		return new SetupSchemes(driver);
	}
	
	public String message()
	{
		return Msg.getText();
		
	}
	
	

	
}