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

import utilities.ExcelUtilities;

public class SearchBusinessUnit {
	WebDriverWait wait;
	WebDriver driver;
	public SearchBusinessUnit(WebDriver driver)
	{
		this.driver=driver;
		this.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		 wait = new WebDriverWait(this.driver, 15);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	@FindBy(linkText="Organisation")
	public WebElement Organisation;
	
	@FindBy(linkText="Search Business Unit")
	public WebElement SearchBU;
	
	@FindBy(id="buBean.businessUnitTypeId")
	public WebElement UType;
	
	@FindBy(id="buBean.name")
	public WebElement UName;
	
	@FindBy(id="buBean.status")
	public WebElement Status;
	
	@FindBy(id="buBean.parentBuId")
	public WebElement PBunit;
	
	@FindBy(id="buBean.staffId")
	public WebElement SID;
	
	@FindBy(id="buBean.staffName")
	public WebElement SNAme;
	
	@FindBy(linkText="Search")
	public WebElement Search;
	
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR/TD[1]/TABLE/TBODY/TR[1]/TH/B")
	public WebElement Header;
	
	
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR/TD[1]/TABLE/TBODY/TR[3]/TD[2]")
	public WebElement RUnitName;
	
	@FindBy(linkText="Clear Search")
	public WebElement ClearSearch;
	
	
	
	
	public SearchBusinessUnit OrgLink()
	{
		Organisation.click();
		return new SearchBusinessUnit(driver);
	}
	public SearchBusinessUnit SearchBULink()
	{
		SearchBU.click();
		return new SearchBusinessUnit(driver);
	}
	public SearchBusinessUnit UnitType(String UT)
	{
		Select select = new Select(UType);
		select.selectByVisibleText(UT);
		// UType.sendKeys(UT);
		return new SearchBusinessUnit(driver);
		
	}
	public SearchBusinessUnit UnitName(String UN)
	{
		UName.sendKeys(UN);
		return new SearchBusinessUnit(driver);
		
	}
	public SearchBusinessUnit BUStatus(String ST)
	{
		System.out.println("instatus");
		Status.click();
		Select select = new Select(Status);
		select.selectByVisibleText(ST);
		//Status.sendKeys(ST);
		return new SearchBusinessUnit(driver);
		
	}
	public SearchBusinessUnit PBusunit(String PB)
	{
		PBunit.click();
		Select select = new Select(PBunit);
		select.selectByVisibleText(PB);
		//PBunit.sendKeys(PB);
		return new SearchBusinessUnit(driver);
		
	}
	public SearchBusinessUnit StaffID(String SD)
	{
		SID.sendKeys(SD);
		return new SearchBusinessUnit(driver);
		
	}
	public SearchBusinessUnit StaffName(String SN)
	{
		SNAme.sendKeys(SN);
		return new SearchBusinessUnit(driver);
		
	}
	public SearchBusinessUnit SearchLink()
	{
		Search.click();
		return new SearchBusinessUnit(driver);
	}
	
	public SearchBusinessUnit BUSearchClick(String excldata)
	{
		String text= "'"+excldata+"'";
		System.out.println(text);
		String text1 = "//*[contains(text(),"+text+")]";	
		driver.findElement(By.xpath(text1)).click();
		return new SearchBusinessUnit(driver);
	}
	public String HeaderDetails()
	{
		return Header.getText();
		
	}
	public String ResUnitName()
	{
		return RUnitName.getText();
		
	}
	public SearchBusinessUnit ClearSearchLink()
	{
		ClearSearch.click();
		return new SearchBusinessUnit(driver);
		
	}
	public String UnitTypeClear()
	{
		Select select = new Select(UType);
		String clear = select.getFirstSelectedOption().getText();
		// UType.sendKeys(UT);
		return clear;
		
	}
	
}

