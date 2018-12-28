
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import helpers.CommonFunctions;
import utilities.ExcelUtilities;

public class ProductPartnerList {

	WebDriver driver;
    WebDriverWait wait;
    public static String FirNme;
    public static String LastNme;
    public static String Asiigned;
    public static String AddPref=CommonFunctions.InsertTime();
    
	public ProductPartnerList(WebDriver driver)
	{
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(this.driver, 15);
		//PageFactory.initElements( driver, this);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	@FindBy(linkText="Product Partner List")
	public WebElement partnerlist;
	
	@FindBy(xpath="//*[contains(text(),'39002')]")
	public WebElement PartnrID;
	
	// add prefixes verify
	@FindBy(xpath="//*[contains(text(),'CommonFunctions.InsertTime()')]")
	public WebElement PrefixId;
	
	
	@FindBy(xpath="/HTML/BODY/FORM/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[2]/TD[2]/TABLE/TBODY/TR/TD[2]/B")
	public WebElement PLHeader;
	
	@FindBy(xpath="/HTML/BODY/TABLE/TBODY/TR[2]/TD/FORM/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR/TD[1]/TABLE/TBODY/TR[1]/TH/B")
	public WebElement PLIDHeader;
	
	@FindBy(linkText="Amend")
	public WebElement Amend;
	
	@FindBy(id="bean.identifierLength")
	public WebElement Identifier;
	
	@FindBy(linkText="Save")
	public WebElement Save;
	
	@FindBy(id="addPrefix")
	public WebElement Add;
	
	@FindBy(id="column0")
	public WebElement AddPrefix;
	
	@FindBy(id="column1")
	public WebElement AddPrefixChk;
	
	@FindBy(xpath="//TABLE[@id='tableContent']/TBODY/TR[1]/TD[1]")
	public WebElement ResultPrefix;
	
	@FindBy(xpath="//*[@id='tableContent']/tbody/tr[1]/td[3]/input[1]")
	public WebElement Select;
	
	@FindBy(id="delete")
	public WebElement Delete;
	
	
	
	//TABLE[@id='tableContent']/TBODY/TR[4]/TD[1]/A
	public ProductPartnerList PartnerlistClick()
	{
		partnerlist.click();
		return new ProductPartnerList(driver);
	}
	public ProductPartnerList PartnrIDClick()
	{
		PartnrID.click();
		return new ProductPartnerList(driver);
	}
	
	public String PListHeader()
	{
		return PLHeader.getText();
		
	}
	public String PListIDHeader()
	{
		return PLIDHeader.getText();
		
	}
	public ProductPartnerList AmendButton()
	{
		Amend.click();
		return new ProductPartnerList(driver);
	}
	public ProductPartnerList setIdentifier()
	{
		String getval =Identifier.getAttribute("value");
		System.out.println("value of textbox "+Identifier.getAttribute("value"));
		Identifier.sendKeys(Keys.BACK_SPACE);
		String val=String.valueOf(Integer.valueOf(getval)+1);
		//System.out.println(val);
		Identifier.sendKeys(val);
		return new ProductPartnerList(driver);
	}
	public ProductPartnerList SaveButton()
	{
		Save.click();
		return new ProductPartnerList(driver);
	}
	public ProductPartnerList AddButton()
	{
		Add.click();
		return new ProductPartnerList(driver);
	}
	
	public ProductPartnerList setAddPrefix()
	{
		System.out.println(AddPref);
		AddPrefix.sendKeys(AddPref);
		return new ProductPartnerList(driver);
	}
	public ProductPartnerList AddPrefixCheck()
	{
		AddPrefixChk.click();
		return new ProductPartnerList(driver);
	}
	public String PrefixExpected()
	{
		// Changing some data
		 String Prefixid=null;
		List<WebElement> elements= driver.findElements(By.xpath("//TABLE[@id='tableContent']/TBODY/TR/TD"));
		 System.out.println(elements.size());
		 for(int i=0;i<elements.size()-1;i++) {
			 if(elements.get(i).getText().equals(AddPref.toString()))
			 {
				Prefixid=elements.get(i).getText();
				 break;
			 }
		 }
		 return Prefixid;
	
	}
	public ProductPartnerList SelectChk()
	{
		Select.click();
		return new ProductPartnerList(driver);
	}
	public ProductPartnerList DeleteButton()
	{
		Delete.click();
		return new ProductPartnerList(driver);
	}
	

	
	
}