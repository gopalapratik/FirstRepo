
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

public class SetupProduct {

	WebDriver driver;
    WebDriverWait wait;
    public static String FirNme;
    public static String LastNme;
    public static String Asiigned;
    public static String PIdentifierText="AutoTest"+CommonFunctions.InsertTime();
    
	public SetupProduct(WebDriver driver)
	{
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(this.driver, 15);
		//PageFactory.initElements( driver, this);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	@FindBy(linkText="Product")
	public WebElement Product;
	
	@FindBy(linkText="Setup Product")
	public WebElement SetProduct;
	//
	@FindBy(name="identifier")
	public WebElement PIdentifier;
	
	@FindBy(name="description")
	public WebElement PDescription;
	
	@FindBy(id="productType")
	public WebElement PType;
	
	@FindBy(name="status")
	public WebElement PStatus;
	
	@FindBy(name="term")
	public WebElement PTerm;
	
	@FindBy(id="termTypeComboID")
	public WebElement PTermType;
	
	@FindBy(name="interestRate")
	public WebElement PIntRate;
	
	@FindBy(name="apr")
	public WebElement PAPR;
	
	@FindBy(name="granularity")
	public WebElement PGranularity;
	
	@FindBy(name="minAge")
	public WebElement PMinAge;
	
	@FindBy(name="maxAge")
	public WebElement PMaxAge;
	
	@FindBy(name="minLoan")
	public WebElement PMinLoan;
	
	@FindBy(name="maxLoan")
	public WebElement PMaxLoan;
	
	@FindBy(name="minRenewalLoan")
	public WebElement PMinRenewalLoan;
	
	@FindBy(name="maxRenewalLoan")
	public WebElement PNAxRenewalLoan;
	
	@FindBy(linkText="Save")
	public WebElement Save;
	
	@FindBy(id="error")
	public WebElement ErrorMSG;
	
	@FindBy(xpath="/HTML/BODY/TABLE/TBODY/TR[2]/TD/FORM[1]/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[1]/TD[1]/TABLE/TBODY/TR[4]/TD[3]")
	public WebElement PTypeList;
	

	
	
	
	
	
	public SetupProduct ProductLink() {
		Product.click();
		return new SetupProduct(driver);
	}
	
	public SetupProduct SetuProduct() {
		SetProduct.click();
		return new SetupProduct(driver);
	}
	
	public SetupProduct setPIdentifier()
	{
		//PIdentifierText="AutoTest"+CommonFunctions.InsertTime();
		PIdentifier.sendKeys(PIdentifierText);
		return new SetupProduct(driver);
	}
	
	public SetupProduct setPDescription(String product)
	{
		product="AutoTest"+CommonFunctions.InsertTime();
		PDescription.sendKeys(product);
		return new SetupProduct(driver);
	}
	public SetupProduct setPType(String product)
	{
		PType.sendKeys(product);
//		Select se = new Select(PType);
//		se.selectByVisibleText(product);
		return new SetupProduct(driver);
	}
	public SetupProduct setPStatus(String product)
	{
		Select se = new Select(PStatus);
		se.selectByVisibleText(product);
		return new SetupProduct(driver);
	}
	public SetupProduct setPTerm(String product)
	{
		PTerm.sendKeys(product);
		return new SetupProduct(driver);
	}
	public SetupProduct setPTermTyper(String product)
	{
		Select se = new Select(PTermType);
		se.selectByVisibleText(product);
		return new SetupProduct(driver);
	}
	public SetupProduct setPIntRate(String product)
	{
		PIntRate.sendKeys(product);
		return new SetupProduct(driver);
	}
	public SetupProduct setPAPR(String product)
	{
		PAPR.sendKeys(product);
		return new SetupProduct(driver);
	}
	public SetupProduct setPGranularity(String product)
	{
		PGranularity.sendKeys(product);
		return new SetupProduct(driver);
	}
	public SetupProduct setPMinAge(String product)
	{
		PMinAge.sendKeys(product);
		return new SetupProduct(driver);
	}
	public SetupProduct setPMaxAge(String product)
	{
		PMaxAge.sendKeys(product);
		return new SetupProduct(driver);
	}
	public SetupProduct setPMinLoan(String product)
	{
		PMinLoan.sendKeys(product);
		return new SetupProduct(driver);
	}
	public SetupProduct setPMaxLoan(String product)
	{
		PMaxLoan.sendKeys(product);
		return new SetupProduct(driver);
	}
	public SetupProduct setPMinRenewalLoan(String product)
	{
		PMinRenewalLoan.sendKeys(product);
		return new SetupProduct(driver);
	}
	public SetupProduct setPNAxRenewalLoan(String product)
	{
		PNAxRenewalLoan.sendKeys(product);
		return new SetupProduct(driver);
	}
	public SetupProduct SaveButton() {
		Save.click();
		return new SetupProduct(driver);
	}
	public String Result() {
		return ErrorMSG.getText();
		 
	}
	
		
		
}
	