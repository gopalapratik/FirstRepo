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
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchBulkCustomerTransfer {
	
	
	WebDriver driver;
    WebDriverWait wait;
    boolean result;

	public SearchBulkCustomerTransfer(WebDriver driver)
	{
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(this.driver, 15);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	
	/**** Locators and Method Implementation for 'Search Bulk Customer Transfer' screen *****/    
	
	/*
	 customerLink : Contains Customer Link locator
	 */
	@FindBy(linkText="Customer")
	public WebElement customerLink;
	
	/*
	 customerLink : Contains Setup Bulk Customer Transfer Link locator
	 */
	@FindBy(linkText="Search Bulk Customer Transfer")
	public WebElement searchBulkCustomerTransferLink;
	
	/*
	 searchBulkCustomerHeader : Contains 'Search Bulk customer header' text locator
	 */
	@FindBy(xpath="//td[@class='selected']/b")
	public WebElement screenHeader;
	
	/*
	 sourceTerritoryTextBox : Contains 'Source Territory' TextBox locator
	 */
	@FindBy(id="sourceTerritory")
	public WebElement sourceTerritoryTextBox;
	
	/*
	 destinationTerritoryTextBox : Contains 'Destination Territory' TextBox locator
	 */
	@FindBy(id="destinationTerritory")
	public WebElement destinationTerritoryTextBox;
	
	/*
	 requestedByStaffID : Contains 'Requested By Staff ID' TextBox locator
	 */
	@FindBy(id="requestedByStaffId")
	public WebElement requestedByStaffID;
	
	/*
	 requestStatusDropDown : Contains 'Requested Status' dropdown locator
	 */
	@FindBy(id="requestStatus")
	public WebElement requestStatusDropDown;
	
	/*
	 fromDateTextBox : Contains 'From Date' TextBox  locator
	 */
	@FindBy(id="fromDate")
	public WebElement fromDateTextBox;
	
	/*
	 fromDateCalendarButton : Contains From Date calendar Button locator
	 */
	@FindBy(id="btFromtDate")
	public WebElement fromDateCalendarButton;
	
	/*
	 toDateTextBox : Contains 'To Date' TextBox  locator
	 */
	@FindBy(id="toDate")
	public WebElement toDateTextBox;
	
	/*
	 toDateCalendarButton : Contains To Date calendar Button locator
	 */
	@FindBy(id="btToDate")
	public WebElement toDateCalendarButton;
	
	/*
	 transferRequestIdTextBox : Contains 'Transfer Request Id' TextBox  locator
	 */
	@FindBy(id="transferRequestId")
	public WebElement transferRequestIdTextBox;
	
	/*
	 searchButton : Contains 'Search' button locator
	 */
	@FindBy(linkText="Search")
	public WebElement searchButton;
	
	/*
	 clearSearchButton : Contains 'Clear Search' button locator
	 */
	@FindBy(linkText="Clear Search")
	public WebElement clearSearchButton;
	
	/*
	 cancelTransferRequestButton : Contains 'Cancel Transfer Request' button locator
	 */
	@FindBy(linkText="Cancel Transfer Request")
	public WebElement cancelTransferRequestButton;
	
	/*
	 errorMessage : Contains 'Error Message' locator
	 */
	@FindBy(id="error")
   public WebElement errorMessage;
	
	/*
	 transferRequestID : Contains 'Transfer Request ID' locator under Search Bulk customer screen 
	 */
	@FindBy(xpath="//div[@id='tbl-container']/table/tbody/tr/td[2]/a/u")
    public WebElement transferRequestID;
	
	/*
	 peginationTextBox : Contains 'Pagination Textbox' locator
	 */
	@FindBy(id="jumpToPage")
    public WebElement peginationTextBox;
	
	//Method Implementation 
	
	public SearchBulkCustomerTransfer clickOnCustomerLink() {
		customerLink.click();
		return new SearchBulkCustomerTransfer(driver);
	}
	
	public SearchBulkCustomerTransfer clickOnSearchBulkCustomerTransferLink() {
		searchBulkCustomerTransferLink.click();
		return new SearchBulkCustomerTransfer(driver);
	}

	public String getScreenHeaderText() {
		
		return screenHeader.getText();
		
	}
	
	public SearchBulkCustomerTransfer enterSourceTerritory(String strSourceTerritory) {
		
		sourceTerritoryTextBox.sendKeys(strSourceTerritory);
		return new SearchBulkCustomerTransfer(driver);
	}
	
	public SearchBulkCustomerTransfer enterDestinationTerritory(String strDestinationTerritory) {
		destinationTerritoryTextBox.sendKeys(strDestinationTerritory);
		return new SearchBulkCustomerTransfer(driver);
	}
	
	public SearchBulkCustomerTransfer enterRequestByStaffID(String strRequestedByStaffID) {
		
		requestedByStaffID.sendKeys(strRequestedByStaffID);
		return new SearchBulkCustomerTransfer(driver);
	}
	
	public SearchBulkCustomerTransfer enterFromDate(String strFromDate) {
		fromDateTextBox.sendKeys(strFromDate);
		return new SearchBulkCustomerTransfer(driver);
	}
	
	public SearchBulkCustomerTransfer clickOnFromDateCalendarButton() {
		fromDateCalendarButton.click();
		return new SearchBulkCustomerTransfer(driver);
	}
	
	public SearchBulkCustomerTransfer enterToDate(String strToDate) {
		toDateTextBox.sendKeys(strToDate);
		return new SearchBulkCustomerTransfer(driver);
	}
	
	public SearchBulkCustomerTransfer clickOnToDateCalendarButton() {
		toDateCalendarButton.click();
		return new SearchBulkCustomerTransfer(driver);
	}
	
	public SearchBulkCustomerTransfer enterTransferRequestID(String strTransferRequestId) {
		
		transferRequestIdTextBox.sendKeys(strTransferRequestId);
		return new SearchBulkCustomerTransfer(driver);
	}
	
	public SearchBulkCustomerTransfer clickOnSearchButton() {
		searchButton.click();
		return new SearchBulkCustomerTransfer(driver);
	}
	
	public SearchBulkCustomerTransfer clickOnClearSearchButton() {
		clearSearchButton.click();
		return new SearchBulkCustomerTransfer(driver);
	}
	
	public SearchBulkCustomerTransfer clickOnClearTransferRequestButton() {
		cancelTransferRequestButton.click();
		return new SearchBulkCustomerTransfer(driver);
	}
	
	public String getErrorMessage()
    {
    	return errorMessage.getText();
    }
	
	public String getTransferRequestIDName()
    {
    	return transferRequestID.getText();
    }
	
	public Boolean isPeginationDisplayed() {
		
		return peginationTextBox.isDisplayed();
	}
	
	/*
	 isTransferRequestIDDisplayed(String strTransferRequestID): This method is used to check mentioned Transfer Request ID is displayed or not
	 */
    public Boolean isTransferRequestIDDisplayed(String strTransferRequestID) {
		
		result = driver.findElement(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[2]/a[contains(@href,'javascript:doView("+strTransferRequestID+");')]")).isDisplayed();
		return result;
	}
	
    /*
	 selectTransferRequestID(String strTransferRequestID): This method is used to select mentioned Transfer Request ID
	 */
	public SearchBulkCustomerTransfer selectTransferRequestID(String strTransferRequestID) {
		
		driver.findElement(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[2]/a[contains(@href,'javascript:doView("+strTransferRequestID+");')]")).click();
		return new SearchBulkCustomerTransfer(driver);
	}
	
	/*
	 selectTransferRequestIDCheckBox(String strTransferRequestID): This method is used to select mentioned Transfer Request ID Check box
	 */
    public SearchBulkCustomerTransfer selectTransferRequestIDCheckBox(String strTransferRequestID) {
		
		driver.findElement(By.xpath("//input[@id='"+strTransferRequestID+"']")).click();
		return new SearchBulkCustomerTransfer(driver);
	}
    
    /*
	 getDisableCheckBoxStatus(String strTransferRequestID): This method is used to get Disable Checkbox status of mentioned Transfer Request ID
	 */
    public String getDisableCheckBoxStatus(String strTransferRequestID) {
		
	   return driver.findElement(By.xpath("//input[@id='"+strTransferRequestID+"']")).getAttribute("disabled");

	}
    
    
    /*
	 getSourceTerritoryOfSpecificTransferID(String strTransferRequestID): This method is used to get Source Territory of mentioned Transfer Request ID
	 */
    public String getSourceTerritoryOfSpecificTransferID(String strTransferRequestID) {
		
		return driver.findElement(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[2]/a[contains(@href,'javascript:doView("+strTransferRequestID+");')]/../../td[3]")).getText();
	}
   
    /*
	 getDestinationTerritoryOfSpecificTransferID(String strTransferRequestID): This method is used to get Destination Territory of mentioned Transfer Request ID
	 */
   public String getDestinationTerritoryOfSpecificTransferID(String strTransferRequestID) {
		
		return driver.findElement(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[2]/a[contains(@href,'javascript:doView("+strTransferRequestID+");')]/../../td[4]")).getText();
	}
   
   /*
	 getEffectiveDateOfSpecificTransferID(String strTransferRequestID): This method is used to get Effective Date of mentioned Transfer Request ID
	 */
   public String getEffectiveDateOfSpecificTransferID(String strTransferRequestID) {
		
		return driver.findElement(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[2]/a[contains(@href,'javascript:doView("+strTransferRequestID+");')]/../../td[5]")).getText();
	}
   
   /*
	 getStatusOfSpecificTransferID(String strTransferRequestID): This method is used to get Status of mentioned Transfer Request ID
	 */
   public String getStatusOfSpecificTransferID(String strTransferRequestID) {
		
		return driver.findElement(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[2]/a[contains(@href,'javascript:doView("+strTransferRequestID+");')]/../../td[6]")).getText();
	}
   
   /*
	 getTotalCustomersOfSpecificTransferID(String strTransferRequestID): This method is used to get Total Customer count of mentioned Transfer Request ID
	 */
   public String getTotalCustomersOfSpecificTransferID(String strTransferRequestID) {
		
		return driver.findElement(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[2]/a[contains(@href,'javascript:doView("+strTransferRequestID+");')]/../../td[7]")).getText();
	}
    
	
   /**** Locators and Method Implementation for 'View Bulk Customer Transfer Request' screen *****/   
   
   
    /*
	 viewBulkCustomerTransferHeader : Contains 'View Bulk Customer Transfer' text locator
	 */
	@FindBy(xpath="//td[@class='selected']/b")
	public WebElement viewBulkCustomerTransferHeader;
	
	/*
	 viewtTrasferRequestIDTextBox : Contains 'Transfer Request ID' TextBox locator on "View Bulk Customer Transfer"
	 */
	@FindBy(id="transferRequestId")
	public WebElement viewtTrasferRequestIDTextBox;
	
	/*
	 viewtRequestStatus : Contains 'Request Status' TextBox locator on "View Bulk Customer Transfer"
	 */
	@FindBy(id="requestStatus")
	public WebElement viewtRequestStatus;
	
	/*
	 viewSourceTerritoryTextBox : Contains 'Source Territory' TextBox locator on "View Bulk Customer Transfer"
	 */
	@FindBy(id="sourceTerritory")
	public WebElement viewSourceTerritoryTextBox;
	
	/*
	 viewDestinationTerritoryTextBox : Contains 'Destination Territory' TextBox locator on "View Bulk Customer Transfer"
	 */
	@FindBy(id="destinationTerritory")
	public WebElement viewDestinationTerritoryTextBox;
	
	/*
	 viewEffectiveDate : Contains 'Effective Date' TextBox locator on "View Bulk Customer Transfer"
	 */
	@FindBy(id="effectiveDate")
	public WebElement viewEffectiveDate;
	
	/*
	 viewTotalCustomerCount : Contains 'Total Customer' TextBox locator on "View Bulk Customer Transfer"
	 */
	@FindBy(id="totalCustomer")
	public WebElement viewTotalCustomerCount;
   
	/*
	 amendButton : Contains 'Amend' button locator
	 */
	@FindBy(linkText="Amend")
	public WebElement amendButton;
	
	/*
	 cancelRequestButton : Contains 'Cancel Request' button locator
	 */
	@FindBy(linkText="Cancel Request")
	public WebElement cancelRequestButton;
	
	/*
	 cancelButton : Contains 'Cancel' button locator
	 */
	@FindBy(linkText="Cancel")
	public WebElement cancelButton;
	
	/*
	 customerID : Contains 'Customer ID' locator on 'View Bulk Customer' screen
	 */
	@FindBy(xpath="//div[@id='tbl-container']/table/tbody/tr/td[2]")
	public WebElement customerID;
	
	
	
	//Method Implementation 
	
	public String getViewBulkCustomerHeaderText() {
		
		return viewBulkCustomerTransferHeader.getText();
	}
	
    public String getTransferRequestID() {
		
		return viewtTrasferRequestIDTextBox.getAttribute("value");
	}
    
    public String getRequestStatus() {
		
		return viewtRequestStatus.getText();
	}
    
    public String getSourceTerritory() {
		
		return viewSourceTerritoryTextBox.getAttribute("value");
	}
    
    public String getDisableStatusOfSourceTerritory() {
 		
		return viewSourceTerritoryTextBox.getAttribute("disabled");
	}
    
    public String getDestinationTerritory() {
		
		return viewDestinationTerritoryTextBox.getAttribute("value");
	}
    
    public SearchBulkCustomerTransfer setAmendDestinationTerritory(String strDestinationTerittoey) {
		
    	viewDestinationTerritoryTextBox.sendKeys(Keys.BACK_SPACE);
    	viewDestinationTerritoryTextBox.sendKeys(Keys.BACK_SPACE);
    	viewDestinationTerritoryTextBox.sendKeys(Keys.BACK_SPACE);
    	viewDestinationTerritoryTextBox.sendKeys(Keys.BACK_SPACE);
  		viewDestinationTerritoryTextBox.sendKeys(strDestinationTerittoey);
  		return new SearchBulkCustomerTransfer(driver);
    }
    public String getEffectiveDate() {
		
		return viewEffectiveDate.getAttribute("value");
	}
    
    public String getTotalCustomerCount() {
		
		return viewTotalCustomerCount.getAttribute("value");
	}
	
    public SearchBulkCustomerTransfer clickOnAmendButton() {
    	amendButton.click();
		return new SearchBulkCustomerTransfer(driver);
	}
	
    public SearchBulkCustomerTransfer clickOnCancelRequestButton() {
    	cancelRequestButton.click();
		return new SearchBulkCustomerTransfer(driver);
	}
    
    public SearchBulkCustomerTransfer clickOnCancelButton() {
    	cancelButton.click();
		return new SearchBulkCustomerTransfer(driver);
	}
    
    public String getCustomerID() {
    	
    	return customerID.getText();
    }
    
    public List<WebElement> getCustomerIDList() {
    	
		List<WebElement> listOfCustomerId = driver.findElements(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[2]"));
		return listOfCustomerId;
	}
	
	/*
	 isSpecifiedCustomerID_Displayed(String strCustomerID) : This method is used to check mentioned Customer ID is displayed or not
	 */
	public Boolean isSpecifiedCustomerID_Displayed(String strCustomerID) {
		
		result = driver.findElement(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[contains(text(),'"+strCustomerID+"')]")).isDisplayed();
		return result;
    }
	
	/*
	 getCustomerID(String strCustomerID) : This method is used to get Customer ID
	 */
	 public String getCustomerID(String strCustomerID) {
			
			return driver.findElement(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[contains(text(),'"+strCustomerID+"')]")).getText();
	}
	 
	 /*
	 getCustomerNameFromCustomerID(String strCustomerID) : This method is used to get Customer Name of mentioned Customer ID
	 */
	 public String getCustomerNameFromCustomerID(String strCustomerID) {
			
			return driver.findElement(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[contains(text(),'"+strCustomerID+"')]/../td[3]")).getText();
	}
	 
	 /*
	 getCustomerStatusFromCustomerID(String strCustomerID) : This method is used to get Customer Status of mentioned Customer ID
	 */
	 public String getCustomerStatusFromCustomerID(String strCustomerID) {
			
			return driver.findElement(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[contains(text(),'"+strCustomerID+"')]/../td[4]")).getText();
	}
	 
	 /*
	 getTransferStatusFromCustomerID(String strCustomerID) : This method is used to get Transfer Status of mentioned Customer ID
	 */
	 public String getTransferStatusFromCustomerID(String strCustomerID) {
			
			return driver.findElement(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[contains(text(),'"+strCustomerID+"')]/../td[5]")).getText();
	}
   
	 /**** Locators and Method Implementation for 'Amend Bulk Customer Transfer Request' screen *****/  
	 
	 
	 // Transfer Request ID, Source Territory, Effective Date , Status, Destination Territory, 
	 //Total Customer,Cancel button,All elements under Customer Included for transfer --> Locators are same as View Bulk customer transfer screen
	 
	 /*
	 submitRequestButton : Contains 'Submit Request' button locator
	 */
	@FindBy(linkText="Submit Request")
	public WebElement submitRequestButton;
	
	/*
	 closeButton : Contains Close button locator
	 */
	@FindBy(linkText="Close")
	public WebElement closeButton;
	
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
 	 acceptButton : Contains Accept button locator
	 */
	 @FindBy(linkText="Accept")
	 public WebElement acceptButton;
	 
	 /*
	 destinationTerritoryTextBox : Contains Destination Territory TextBox locator
	 */
	@FindBy(xpath="//input[@id='destinationTerritory']/../a")
	public WebElement destinationTerritorySearchButton;
	

	//Method Implementation
	/*
	 selectCustomerIDCheckBox(String strCustomerID): This method is used to select mentioned Transfer Request ID Check box
	 */
   public SearchBulkCustomerTransfer selectCustomerIDCheckBox(String strCustomerID) {
		
		driver.findElement(By.xpath("//input[@id='"+strCustomerID+"']")).click();
		return new SearchBulkCustomerTransfer(driver);
	}
   
   public SearchBulkCustomerTransfer clickOnSubmitRequestButton() {
	   submitRequestButton.click();
		return new SearchBulkCustomerTransfer(driver);
	}
   
   public SearchBulkCustomerTransfer clickOnAddCustomerToListButton() {
		addCustomersToListButton.click();
		return new SearchBulkCustomerTransfer(driver);
	}
	 
   public SearchBulkCustomerTransfer clickOnRemoveCustomerFromListButton() {
		removeCustomersFromListButton.click();
		return new SearchBulkCustomerTransfer(driver);
	}
   
   public List<WebElement> getListOfCustomerIDs() {
   	
   	List<WebElement> listOfCustomerIDs = driver.findElements(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[2]"));
   	
		return listOfCustomerIDs;
   }
   
   public SearchBulkCustomerTransfer clickOnAcceptButton() {
		acceptButton.click();
		return new SearchBulkCustomerTransfer(driver);
	}
	 
   public SearchBulkCustomerTransfer clickOnDestinationTerritorySearchButton() {
		destinationTerritorySearchButton.click();
		return new SearchBulkCustomerTransfer(driver);
	}
	 
   public SearchBulkCustomerTransfer clickOnCloseButton() {
		closeButton.click();
		return new SearchBulkCustomerTransfer(driver);
	}
	 
	 
	 
	
 
}
