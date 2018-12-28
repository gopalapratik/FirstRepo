
package pageobjects.cap;

import java.util.List;
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

import utilities.ExcelUtilities;

public class SearchCustBusinessUnit {

	WebDriver driver;
    WebDriverWait wait;

	public SearchCustBusinessUnit(WebDriver driver)
	{
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(this.driver, 15);
		//PageFactory.initElements( driver, this);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	
	@FindBy(xpath="//a[contains(text(),'17')]")
	public WebElement Cust;
	
	@FindBy(linkText="Business Unit")
	public WebElement BU;
	
	@FindBy(xpath="//*[contains(text(),'PERSONAL DETAILS')]")
	public WebElement PD;
	
	@FindBy(xpath="//*[contains(text(),'LEVEL 2 UNIT')]")
	public WebElement Level2;
	
	@FindBy(xpath="//*[contains(text(),'LEVEL 3 UNIT')]")
	public WebElement Level3;
	
	@FindBy(xpath="//*[contains(text(),'BUSINESS UNIT')]")
	public WebElement BUText;
	
	@FindBy(linkText="Amend")
	public WebElement Amnd;

   @FindBy(xpath="//*[@class='Field2']//*[text()='Section']")
   public WebElement Level2Section;
   
   @FindBy(xpath="//*[@class='Field3']//*[text()='Staff ID']")
   public WebElement Level2StaffID;
   
   @FindBy(xpath="//*[@class='Field3']//*[text()='Staff Name']")
   public WebElement Level2SName;
   
   @FindBy(xpath="//*[@class='Field3']//*[text()='Mobile']")
   public WebElement Level2Mobile;
   
   @FindBy(xpath="//*[@class='Field2']//*[text()='Area']")
   public WebElement Level3Area;
   
   @FindBy(xpath="//*[@class='Field3']//*[text()='Staff ID']")
   public WebElement Level3StaffID;
   
   @FindBy(xpath="//*[@class='Field3']//*[text()='Staff Name']")
   public WebElement Level3SName;
   
   @FindBy(xpath="//*[@class='Field3']//*[text()='Mobile']")
   public WebElement Level3Mobile;
   
   @FindBy(xpath="//*[@class='Field2']//*[text()='Region']")
   public WebElement Level4Region;
   
   @FindBy(xpath="//*[@class='Field3']//*[text()='Staff ID']")
   public WebElement Level4StaffID;
   
   @FindBy(xpath="//*[@class='Field3']//*[text()='Staff Name']")
   public WebElement Level4SName;
   
   @FindBy(xpath="//*[@class='Field3']//*[text()='Mobile']")
   public WebElement Level4Mobile;
   
   @FindBy(xpath="//*[@class='Field']//*[text()='Territory']")
   public WebElement BUTerritory;
   
   @FindBy(xpath="//*[@class='Field3']//*[text()='Staff ID']")
   public WebElement BUStaffID;
   
   @FindBy(xpath="//*[@class='Field3']//*[text()='Staff Name']")
   public WebElement BUSName;
   
   @FindBy(xpath="//*[@class='Field3']//*[text()='Mobile']")
   public WebElement BUMobile;
	
   
	
	
	////implementation////////
	
	
	public SearchCustBusinessUnit custclick()
	{
		Cust.click();
		return new SearchCustBusinessUnit(driver);
	}
	public SearchCustBusinessUnit BUnit()
	{
		BU.click();
		return new SearchCustBusinessUnit(driver);
	}
	public String ProD()
	{
		return PD.getText();
	
	}
	public String LevelTwo()
	{
		return Level2.getText();
	
	}
	public String LevelThree()
	{
		return Level3.getText();
	
	}
	public String BusUnit()
	{
		return BUText.getText();
	
	}
	public boolean AmendButton()
	{
		return Amnd.isDisplayed();
	}
	
	////Level 2/////
	public String L2Section()
	{
		return Level2Section.getText();
	
	}
	public String L2Details()
	{
		String L2 = Level2StaffID.getText()+" "+Level2SName.getText()+" "+Level2Mobile.getText();
		return L2;
	
	}
	
	////Level 3/////
	public String L3Area()
	{
		return Level3Area.getText();
	
	}
	public String L3Details()
	{
		String L3 = Level3StaffID.getText()+" "+Level3SName.getText()+" "+Level3Mobile.getText();
		return L3;
	
	}
	
	
	////Level 4/////
	public String L4Region()
	{
		return Level4Region.getText();
	
	}
	public String L4Details()
	{
		String L4 = Level4StaffID.getText()+" "+Level4SName.getText()+" "+Level4Mobile.getText();
		return L4;
	
	}
	/////BU////////
	public String BUTer()
	{
		return BUTerritory.getText();
	
	}
	public String BUdetails()
	{
		String Bu = BUStaffID.getText()+" "+BUSName.getText()+" "+BUMobile.getText();
		return Bu;
	
	}
	
}