
package pageobjects.cap;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.CommonFunctions;
import utilities.ExcelUtilities;

public class SetupBusinessUnit {
	WebDriverWait wait;
	WebDriver driver;
	public static String BUNAme="AutoTestBU"+CommonFunctions.InsertTime();
	public static String setBUNAme="AutoTestBUuit"+CommonFunctions.InsertTime();
	public static String Increment;
	public SetupBusinessUnit(WebDriver driver)
	{
		this.driver=driver;
		this.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		 wait = new WebDriverWait(this.driver, 15);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	@FindBy(linkText="Setup Business Unit")
	public WebElement SetUp;
	
	@FindBy(name="buBean.name")
	public WebElement BUName;
	
	@FindBy(id="buTypeID")
	public WebElement UnitID;
	
	@FindBy(id="costCentreCode")
	public WebElement CntrCode;
	
	@FindBy(id="buStartDateStr")
	public WebElement Date;
	
	@FindBy(id="parentBUId")
	public WebElement Punit;
	
	@FindBy(id="caisStatus")
	public WebElement CStatus;
	
	@FindBy(id="postCode")
	public WebElement Pcode;
	
	@FindBy(linkText="Save")
	public WebElement Save;
	
	@FindBy(id="flatNo")
	public WebElement FlatNo;
	
	@FindBy(id="houseNo")
	public WebElement HouseNO;
	
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR/TD[1]/TABLE/TBODY/TR[3]/TD[2]")
	public WebElement RUnitName;
	
	@FindBy(linkText="Amend")
	public WebElement Amend;
	
	
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR/TD[1]/TABLE/TBODY/TR[6]/TD[2]")
	public WebElement CostCenterCodeRes;
	
	@FindBy(linkText="Add Staff")
	public WebElement AddStaff;
	
	
	
	
	
	public SetupBusinessUnit SetUpLink()
	{
		SetUp.click();
		return new SetupBusinessUnit(driver);
	}
	public SetupBusinessUnit setBUName1()
	{
		
		BUName.sendKeys(setBUNAme);
		return new SetupBusinessUnit(driver);
	}
	public SetupBusinessUnit setBUName()
	{
		
		BUName.sendKeys(BUNAme);
		return new SetupBusinessUnit(driver);
	}
	public SetupBusinessUnit setUnitID(String setup1) throws InterruptedException
	{
		UnitID.click();
		Select select = new Select(UnitID);
		//System.out.println(setup1);
		//Thread.sleep(5000);
		select.selectByVisibleText(setup1);
		//System.out.println(setup1);
		//Thread.sleep(5000);
		return new SetupBusinessUnit(driver);
	}
	public SetupBusinessUnit setCntrCode(String setup) throws InterruptedException
	{
		Thread.sleep(2000);
		CntrCode.sendKeys(setup);
		return new SetupBusinessUnit(driver);
	}
	public SetupBusinessUnit setStartDate() throws InterruptedException
	{
		Thread.sleep(2000);
		Date.sendKeys(CommonFunctions.NowDate());
		return new SetupBusinessUnit(driver);
	}
	public SetupBusinessUnit setPunit(String setup)
	{
		Punit.click();
		Select select = new Select(Punit);
		select.selectByVisibleText(setup);
		return new SetupBusinessUnit(driver);
	}
	public SetupBusinessUnit setCStatus(String setup)
	{
		CStatus.click();
		Select select = new Select(CStatus);
		select.selectByVisibleText(setup);
		return new SetupBusinessUnit(driver);
	}
	public SetupBusinessUnit setPostCode(String setup)
	{
		Pcode.sendKeys(setup);
		return new SetupBusinessUnit(driver);
	}
	public SetupBusinessUnit setFlatNo(String setup)
	{
		FlatNo.sendKeys(setup);
		return new SetupBusinessUnit(driver);
	}
	public SetupBusinessUnit setHouseNO(String setup)
	{
		HouseNO.sendKeys(setup);
		return new SetupBusinessUnit(driver);
	}
	
	public String ResUnitName()
	{
		return RUnitName.getText();
	}
	public SetupBusinessUnit SaveLink()
	{
		Save.click();
		return new SetupBusinessUnit(driver);
	}
	public SetupBusinessUnit AmendLink()
	{
		Amend.click();
		return new SetupBusinessUnit(driver);
	}
	public SetupBusinessUnit Incr()
	{
		String ccode = CntrCode.getAttribute("value");
		for(int i=0;i<=ccode.length();i++)
		{
			CntrCode.sendKeys(Keys.BACK_SPACE); 
		}
		Increment = String.valueOf(Integer.valueOf(ccode)+1) ;
		CntrCode.sendKeys(Increment);
		return new SetupBusinessUnit(driver);
		 
	}
	public String CostCenterCodeResult()
	{
		return CostCenterCodeRes.getText();
		
	}
	public SearchStaffPage SwitchWindow() throws InterruptedException
	{
		AddStaff.click();
		Thread.sleep(2000);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
		    if(!windowHandle.equals(parentWindow))
		   {
		    	
		     driver.switchTo().window(windowHandle);
		     System.out.println("IN CHILLD");
		     driver.getTitle();
		
		   
		    driver.findElement(By.name("staffIdCriteria")).sendKeys("1");
		    driver.findElement(By.linkText("Search")).click();
		    driver.findElement(By.name("buStaffBean.staffId")).click();
		    driver.findElement(By.linkText("Apply")).click();
//		     //driver.quit();
//		     driver.close(); //closing child window
		    System.out.println("OUT CHILLD");
		     driver.switchTo().window(parentWindow); //cntrl to parent window
		    }
		   
		}
		return new SearchStaffPage(driver);
	}
	
	
}