
package pageobjects.cap;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.CommonFunctions;

import org.openqa.selenium.Alert;

import utilities.ExcelUtilities;

public class SetupCustomer {

	WebDriver driver;
    WebDriverWait wait;
    public static String Firstname="AutoFirst"+CommonFunctions.InsertTime();
    public static String Lastname="AutoLast"+CommonFunctions.InsertTime();
	public SetupCustomer(WebDriver driver)
	{
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(this.driver, 15);
		//PageFactory.initElements( driver, this);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

	@FindBy(linkText="Setup Customer")
	public WebElement CustSetUp;
	
	@FindBy(xpath="/html/body/a/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[3]/td[3]")
	public WebElement CustID;
	
	@FindBy(xpath="/html/body/a/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[4]/td[3]")
	public WebElement Status;
	
	@FindBy(id="territoryName")
	public WebElement TTName;
	
	@FindBy(name="customer.firstName")
	public WebElement FName;
	
	@FindBy(name="customer.lastName")
	public WebElement LName;
	
	@FindBy(id="corresFlatNo")
	public WebElement FlatNo;
	
	@FindBy(id="corresHouseNo")
	public WebElement HNo;
	
	@FindBy(id="corresAddress1")
	public WebElement HName;
	
	@FindBy(id="corresAddress2")
	public WebElement SName;
	
	@FindBy(id="corresPostCode")
	public WebElement PostCode;
	
	@FindBy(name="customer.homePhone")
	public WebElement Tel;
	
	@FindBy(name="customer.mobilePhone")
	public WebElement Mob;
	
	@FindBy(linkText="Save")
	public WebElement save;
	
	@FindBy(id="txtAppDate")
	public WebElement date;
	
	
	
	
	
	@FindBy(linkText="Continue")
	public WebElement Continue;
	
	@FindBy(id="error")
	public WebElement Msg;
	
	@FindBy(xpath="//td[contains(text(),'Customer ID')]//following-sibling::td[contains(@class,'Field')]")
	public WebElement CustIDNew;
	
	@FindBy(xpath="//*[@name='customerCode']")
	public WebElement CustIDNewgen;
	
	
	
	
	
	
	public SetupCustomer CustomerSetup()
	{
		CustSetUp.click();
		return new SetupCustomer(driver);
	}
	public String CustomerID()
	{
		return CustID.getText();
		
	}
	public String Customerstatus()
	{
		return Status.getText();
		
	}
	public SetupCustomer SetTT(String tt)
	{
		TTName.sendKeys(tt);
		return new SetupCustomer(driver);
		
	}
	////
	public SetupCustomer SetFisrtName()
	{
		FName.sendKeys(Firstname);
		//FName.sendKeys(FN);
		return new SetupCustomer(driver);
		
	}
	public SetupCustomer SetLastName()
	{
		LName.sendKeys(Lastname);
		return new SetupCustomer(driver);
		
	}
	public SetupCustomer Setfaltno(String Fno)
	{
		FlatNo.sendKeys(Fno);
		return new SetupCustomer(driver);
		
	}
	public SetupCustomer SetHNO(String Hnum)
	{
		HNo.sendKeys(Hnum);
		return new SetupCustomer(driver);
		
	}
	public SetupCustomer setHname(String HouseName)
	{
		HName.sendKeys(HouseName);
		return new SetupCustomer(driver);
		
	}
	public SetupCustomer SetSName(String SN)
	{
		SName.sendKeys(SN);
		return new SetupCustomer(driver);
		
	}
	public SetupCustomer SetPC(String PostC)
	{
		PostCode.sendKeys(PostC);
		return new SetupCustomer(driver);
		
	}
	public SetupCustomer SetTel(String telephone)
	{
		Tel.sendKeys(telephone);
		return new SetupCustomer(driver);
		
	}
	public SetupCustomer Setmob(String mobile)
	{
		Mob.sendKeys(mobile);
		return new SetupCustomer(driver);
		
	}
	public SetupCustomer ContinueButton()
	{
		Continue.click();
		return new SetupCustomer(driver);
	}
	public SetupCustomer SaveButton()
	{
		save.sendKeys(Keys.ENTER);
		return new SetupCustomer(driver);
	}
	public String Message()
	{
		return Msg.getText();
		
	}
	public SetupCustomer Alert() throws InterruptedException
	{
		
		Thread.sleep(2000);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
		    if(!windowHandle.equals(parentWindow))
		   {	
		    	
		    	
		    	
		     driver.switchTo().window(windowHandle);
		     System.out.println("IN CHILLD1");
		     driver.getTitle();
		     System.out.println(driver.getTitle());
		     driver.findElement(By.id("txtDob")).sendKeys("22/07/1990");
		     driver.findElement(By.linkText("Save")).click();
		     Thread.sleep(10000);
		   }
		}
		driver.switchTo().window(parentWindow);
		return new SetupCustomer(driver);
		
	}
	public SetupCustomer windowcustomerlist() throws InterruptedException
	{
		
		Thread.sleep(2000);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
		    if(driver.switchTo().window(windowHandle).getTitle().equals("Customer list matched to file"))
		   {	
		     driver.switchTo().window(windowHandle);
		     System.out.println("IN CHILLD1");
		     driver.getTitle();
		     System.out.println(driver.getTitle());
		    // driver.findElement(By.id("txtDob")).sendKeys("22/07/1990");
		     driver.findElement(By.linkText("Accept New Customer")).click();
		   }
		}
		driver.switchTo().window(parentWindow);
		return new SetupCustomer(driver);
		
	}
	public SetupCustomer date()
	{
		String e =date.getText();
		for(int i = 0; i<=10; i++)
		{
		if(e.equals(null))
		{}
		else
		{date.sendKeys(Keys.BACK_SPACE);}}
		//Wages.clear();
		
		
		//Mob.clear();
		return new SetupCustomer(driver);
		
	}
	public String CustIDNewText()
	{
		return CustIDNew.getText();
		
	}
	public String CustIDNewgenText()
	{
		return CustIDNewgen.getAttribute("value");
		
	}
}