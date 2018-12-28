package pageobjects.cap;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetupBulkCustomerTransfer {
	
	
	WebDriver driver;
    WebDriverWait wait;
    boolean result;

	public SetupBulkCustomerTransfer(WebDriver driver)
	{
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(this.driver, 15);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	
	/**** Locators and Method Implementation for 'Setup Bulk Customer Transfer Request' screen *****/    
 
	/*
	 customerLink : Contains Customer Link locator
	 */
	@FindBy(linkText="Customer")
	public WebElement customerLink;
	
	/*
	 customerLink : Contains Setup Bulk Customer Transfer Link locator
	 */
	@FindBy(linkText="Setup Bulk Customer Transfer")
	public WebElement setupBulkCustomerTransferLink;
	
	/*
	 setupBulkCustomerHeader : Contains 'Setup Bulk customer header' text calendar locator
	 */
	@FindBy(xpath="//td[@class='selected']/b")
	public WebElement screenHeader;
	
	/*
	 sourceTerritoryTextBox : Contains Source Territory TextBox locator
	 */
	@FindBy(id="territoryName")
	public WebElement sourceTerritoryTextBox;
	
	/*
	 sourceTerritorySearchButton : Contains Source Territory search button locator
	 */
	@FindBy(xpath="//input[@id='territoryName']/../a")
	public WebElement sourceTerritorySearchButton;
	
	/*
	 destinationTerritoryTextBox : Contains Destination Territory TextBox locator
	 */
	@FindBy(id="territoryName1")
	public WebElement destinationTerritoryTextBox;
	
	/*
	 destinationTerritoryTextBox : Contains Destination Territory TextBox locator
	 */
	@FindBy(xpath="//input[@id='territoryName1']/../a")
	public WebElement destinationTerritorySearchButton;
	
	/*
	 effectiveDateTextBox : Contains Effective Date TextBox locator
	 */
	@FindBy(id="effectiveDate")
	public WebElement effectiveDateTextBox;
	
	/*
	 effectiveDateCalendarButton : Contains Effective Date calendar Button locator
	 */
	@FindBy(id="btStartDate")
	public WebElement effectiveDateCalendarButton;
	
	/*
	 effectiveDateCalender : Contains 'Effective Date' calendar locator
	 */
	@FindBy(xpath="//div[@class='calendar']")
	public WebElement effectiveDateCalendar;
	
	/*
	 nextMonthArrowButton : Contains 'Effective Date' calendar's Next month arrow button locator
	 */
	@FindBy(xpath="//td[@ttip='Next month (hold for menu)']")
	public WebElement nextMonthArrowButton;
	
	/*
	 mondayDate : Contains 'Effective Date' calendar's Monday date locator
	 */
	@FindBy(xpath="//div[@class='calendar']/table/tbody/tr[contains(@class,'daysrow')][3]/td[3]")
	public WebElement mondayDate;
	
	/*
	 submitRequestButton : Contains 'Submit' Request locator
	 */
	@FindBy(linkText="Submit Request")
	public WebElement submitRequestButton;
	
	/*
	 resetButton : Contains 'Reset' button locator
	 */
	@FindBy(linkText="Reset")
	public WebElement resetButton;
	
	/*
	 addCustomersToListButton : Contains 'Add Customers to List' button locator
	 */
	@FindBy(linkText="Add Customers to List")
	public WebElement addCustomersToListButton;
	
	/*
	 addCustomersToListButton : Contains 'Remove Customers from List' button locator
	 */
	@FindBy(linkText="Remove Customers from List")
	public WebElement removeCustomersFromListButton;
	
	/*
	 errorMessage : Contains 'Error Message' locator
	 */
	@FindBy(id="error")
    public WebElement errorMessage;
	
	//Method Implementations
	
	public SetupBulkCustomerTransfer clickOnCustomerLink() {
		customerLink.click();
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public SetupBulkCustomerTransfer clickOnSetupBulkCustomerTransferLink() {
		setupBulkCustomerTransferLink.click();
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public String getScreenHeaderText() {
		
		return screenHeader.getText();
		
	}
	
	public SetupBulkCustomerTransfer enterSourceTerritory(String strSourceTerritory) {
		sourceTerritoryTextBox.sendKeys(strSourceTerritory);
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public String getSourceTerritory() {
		
		return sourceTerritoryTextBox.getAttribute("value");
	}
	
	public SetupBulkCustomerTransfer clickOnSourceTerritorySearchButton() {
		sourceTerritorySearchButton.click();
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public SetupBulkCustomerTransfer enterDestinationTerritory(String strDestrinationTerritory) {
		destinationTerritoryTextBox.sendKeys(strDestrinationTerritory);
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public SetupBulkCustomerTransfer clickOnDestinationTerritorySearchButton() {
		destinationTerritorySearchButton.click();
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public SetupBulkCustomerTransfer enterEffectiveDate(String strEffectiveDate) {
		
		effectiveDateTextBox.sendKeys(strEffectiveDate);
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public String getEffectiveDate() {
		
		return effectiveDateTextBox.getAttribute("value");
		
	}
	
    public Boolean isEffectiveDateDisplayed() {
		
		return effectiveDateTextBox.isDisplayed();
		
	}
	
	public SetupBulkCustomerTransfer clickOnEffectiveDateCalendarButton() {
		effectiveDateCalendarButton.click();
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public String isEffectiveDateCalendarIsDisplayed() {
		
		result = effectiveDateCalendar.isDisplayed();
		return String.valueOf(result);
	}
	
	public SetupBulkCustomerTransfer clickOnNextMonthArrowButton() {
		nextMonthArrowButton.click();
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public SetupBulkCustomerTransfer clickOnMondayDate() {
		mondayDate.click();
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public SetupBulkCustomerTransfer clickOnSubmitRequestButton() {
		submitRequestButton.click();
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public SetupBulkCustomerTransfer clickOnResetButton() {
		resetButton.click();
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public SetupBulkCustomerTransfer clickOnAddCustomerToListButton() {
		addCustomersToListButton.click();
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public SetupBulkCustomerTransfer clickOnRemoveCustomerFromListButton() {
		removeCustomersFromListButton.click();
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public String getErrorMessage()
    {
    	return errorMessage.getText();
    }
	
	/**** Locators and Method Implementation for 'Search Customer' screen *****/ 
	
	/*
	 customerIDTextBox : Contains Customer ID TextBox locator
	 */
	@FindBy(id="customerCode")
	public WebElement customerIDTextBox;
	
	/*
	 customerStatusDropDown : Contains Customer Status Dropdown locator
	 */
	@FindBy(id="status")
	public WebElement customerStatusDropDown;
	
	/*
	 firstNameTextBox : Contains first name TextBox locator
	 */
	@FindBy(id="firstName")
	public WebElement firstNameTextBox;
	
	/*
	 lastNameTextBox : Contains last name TextBox locator
	 */
	@FindBy(id="lastName")
	public WebElement lastNameTextBox;
	
	/*
	 searchButton : Contains Search button locator
	 */
	@FindBy(linkText="Search")
	public WebElement searchButton;
	
	/*
	 acceptButton : Contains Accept button locator
	 */
	@FindBy(linkText="Accept")
	public WebElement acceptButton;
	
	/*
	 closeButton : Contains Close button locator
	 */
	@FindBy(linkText="Close")
	public WebElement closeButton;
	
	/*
	 customerListCheckBox : Contains Customer List CheckBox locator
	 */
	@FindBy(xpath="//input[@name='customerList']")
	public WebElement customerListCheckBox;
	
	/*
	 customerID : Contains Customer ID under customer search table locator
	 */
	@FindBy(xpath="//div[@id='tbl-container']/table/tbody/tr/td[2]")
	public WebElement customerID;
	
	/*
	 customerID : Contains Customer ID under customer search table locator
	 */
	@FindBy(xpath="//input[@name='selectAll']")
	public WebElement selectAllCheckBox;
	
	
	
	//Method Implementation 
	
	public SetupBulkCustomerTransfer enterCustomerID(String strCustomerID) {
		
		customerIDTextBox.sendKeys(strCustomerID);
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public SetupBulkCustomerTransfer enterFirstName(String strFirstName) {
		
		firstNameTextBox.sendKeys(strFirstName);
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public SetupBulkCustomerTransfer enterLastName(String strLastName) {
		
		lastNameTextBox.sendKeys(strLastName);
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public SetupBulkCustomerTransfer clickOnSearchButton() {
		searchButton.click();
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public SetupBulkCustomerTransfer clickOnAcceptButton() {
		acceptButton.click();
		return new SetupBulkCustomerTransfer(driver);
	}

	public SetupBulkCustomerTransfer clickOnCloseButton() {
		closeButton.click();
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public SetupBulkCustomerTransfer clickOnCustomerCheckBox() {
		customerListCheckBox.click();
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public String getCustomerIDOfChechBox() {
		
		return customerListCheckBox.getAttribute("value");
	}
	
    public String getCustomerID() {
		
		return customerID.getText();
	}
    
    public Boolean isCustomerIDDisplayed() {
		
		return customerID.isDisplayed();
	}
    
    public SetupBulkCustomerTransfer clickOnSelectAllCheckBox() {
    	selectAllCheckBox.click();
		return new SetupBulkCustomerTransfer(driver);
	}
    
    public List<WebElement> getListOfCustomerIDs() {
    	
    	List<WebElement> listOfCustomerIDs = driver.findElements(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[2]"));
    	
		return listOfCustomerIDs;
    }
    
   public Boolean isSpecifiedCustomerIDDisplayed(String strCustomerID) {
		
		result = driver.findElement(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[@text='"+strCustomerID+"']")).isDisplayed();
		return result;
		}
    
    public SetupBulkCustomerTransfer selectCustomerCheckBoxOfSpecifiedCustomerID(String strCustomerID) {
		
		driver.findElement(By.xpath("//input[@id='"+strCustomerID+"']")).click();
		return new SetupBulkCustomerTransfer(driver);
	}
    
    public String getCustomerNameOfSpecifiedCustomerID(String strCustomerID) {
		
		return driver.findElement(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[@text='"+strCustomerID+"']/../td[3]")).getText();
	}
    
    public String getCustomerStatusOfSpecifiedCustomerID(String strCustomerID) {
		
		return driver.findElement(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[@text='"+strCustomerID+"']/../td[4]")).getText();
	}
	
	
	
	/**** Locators and Method Implementation for 'Search Territory' screen *****/ 
	
	/*
	 sourceTerritoryTextBox : Contains Source Territory TextBox locator
	 */
	@FindBy(id="territoryName")
	public WebElement territoryTextBox;
	
	/*
	 territoryName : Contains Territory Name locators on Search Territory Screen
	 */
	@FindBy(xpath="//div[@id='tbl-container']/table/tbody/tr/td/table/tbody/tr/td[2]")
	public WebElement territoryName;
	
	/*
	 newSearchButton : Contains 'New Search' button locator
	 */
	@FindBy(linkText="New Search")
	public WebElement newSearchButton;
	
	
	//Method Implementation
	
	public SetupBulkCustomerTransfer enterTerritory(String strTerritory) {
		territoryTextBox.clear();
		territoryTextBox.sendKeys(strTerritory);
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public String getTerritoryName() {
		
		return territoryName.getText();
	}
	
    public Boolean isTerritoryNameDisplayed(long inSec) throws InterruptedException {
    Thread.sleep(inSec);	
	return result = territoryName.isDisplayed();
	
		
	}
	
	public SetupBulkCustomerTransfer clickOnNewSearchButton() {
		newSearchButton.click();
		return new SetupBulkCustomerTransfer(driver);
	}
	
	/*
	 clickOnTerritoryRadioButton(String strTerritoryName) : This method is used to click on mentioned Territory radio button
	 */
	public SetupBulkCustomerTransfer clickOnTerritoryRadioButton(String strTerritoryName) {
		driver.findElement(By.xpath("//input[@value='"+strTerritoryName+"']")).click();
		return new SetupBulkCustomerTransfer(driver);
	}
	
	public String getSecondTerritoryName() {
		
		return driver.findElement(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td/table/tbody/tr[2]/td[2]")).getText();
	}
		
}
