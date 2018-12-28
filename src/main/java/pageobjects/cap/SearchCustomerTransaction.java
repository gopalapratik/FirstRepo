
package pageobjects.cap;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageobjects.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.graphbuilder.math.func.LgFunction;
//import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ExcelUtilities;


public class SearchCustomerTransaction {
	
	WebDriver driver;
   // WebDriverWait wait;
    String parentHandle =null;
    
    public SearchCustomerTransaction(WebDriver driver)
    {
    	this.driver = driver;
    	this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    	new WebDriverWait(this.driver, 15);
    	PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }
   // WebDriverWait wait = new WebDriverWait(driver, 120);
    @FindBy(xpath="//DIV[@id='tbl-container']/TABLE/TBODY/TR[1]/TD[2]")
    public WebElement ExisACC;
    
    @FindBy(xpath="//DIV[@id='tbl-container']/TABLE/TBODY/TR[1]/TD[2]")
    public WebElement NewACC;
    
    @FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE[1]/TBODY/TR[1]/TD[1]/TABLE/TBODY/TR[3]/TD[2]")
    public WebElement PcustID;
    
    @FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE[1]/TBODY/TR[1]/TD[1]/TABLE/TBODY/TR[4]/TD[1]")
    public WebElement PStatus;
    
    @FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE[1]/TBODY/TR[1]/TD[1]/TABLE/TBODY/TR[5]/TD")
    public WebElement PName;
    
    @FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE[1]/TBODY/TR[1]/TD[1]/TABLE/TBODY/TR[9]/TD")
    public WebElement PAddress;
   
    @FindBy(name="transactionType")
	public WebElement Trxn;
    
    @FindBy(name="productTypeId")
	public WebElement ProdType;
   

    @FindBy(name="productId1")
   	public WebElement Prod;
    
    @FindBy(name="saleValue1")
   	public WebElement SaleVal; 
    
   	@FindBy(name="accountBean.agreeFormNoCom")
   	public WebElement AggNum;
   	
   	@FindBy(name="strSaleDate1")
   	public WebElement SalDate;
   	
   	@FindBy(name="transactionType")
   	public WebElement TrxnType;
   	
   	@FindBy(xpath="//a[contains(text(),'17')]")
	public WebElement CustLink;
   	
 	@FindBy(xpath="//a[contains(text(),'90')]")
	public WebElement CustomerLink;
   	
   	@FindBy(name="custPaymentBean.strAmount")
	public WebElement PayValue;
  // Change By Rajesh for Data Issue 
   	@FindBy(name="custPaymentBean.strPaymentDate")
	public WebElement TranDate;
   	
   //	@FindBy(id="25")
   	@FindBy(xpath="//TABLE[@id='tbl']/TBODY/TR[2]/TD[1]")
   	//@CacheLookup
	public WebElement PaymentAcc;
   	
   	///////////////////////////////
   	
   	@FindBy(xpath="//TABLE[@id='tbl']/TBODY/TR[1]/TD[3]")
	public WebElement StatementAccount;
   	
   	
	@FindBy(xpath="//TABLE[@id='tbl']/TBODY/TR[1]/TD[6]")
	public WebElement CreditValue;
   	
   	
   	
   	//////////////////////
   	
   	
   	
   	@FindBy(linkText="Allocate Payment")
	public WebElement allo;
  
   	@FindBy(xpath="//DIV[@id='tbl-container']/TABLE/THEAD/TR")
	public WebElement ListOfTitle;
   	
   	@FindBy(id="custPaymentBean.paymentType")
	public WebElement PaymentType;
   	
   	@FindBy(id="custPaymentBean.chequeId")
	public WebElement Cheque;
   	
   	/*
   	 WebElement transactionTypeDropDown : Holds Transaction Type dropdown element locator
   	 */
   	@FindBy(xpath="//select[@name='transactionType']")
   	public WebElement transactionTypeDropDown;
   	
	/*
  	 WebElement paymentType : Holds Payment Type dropdown element locator
  	 */
   	@FindBy(xpath="//select[@id='custPaymentBean.paymentType']")
   	public WebElement paymentTypeDropdown;
   	
   	
   	
	@FindBy(xpath="//input[@name='cpaPayCheck']")
   	public WebElement CPAPayment;
   	
	@FindBy(xpath="//select[@name='collectedBy']")
   	public WebElement CollectedBy;
   	
   	
   	
   	
   	
   	
   	/*
 	 WebElement paymentType : Holds Collect By dropdown element locator
 	 */
  	@FindBy(id="collectedById")
  	public WebElement collectByDropdown;
  	
  	
	@FindBy(id="eventType")
  	public WebElement LogTypeDropdown;
	
	@FindBy(id="eventReason")
  	public WebElement EventReasonDropdown;
	
	@FindBy(xpath="//select[@name='accountList']")
  	public WebElement SelectAccount;
	
	@FindBy(xpath="//select[@name='LetterType']")
  	public WebElement SelectLetter;
	
	
	@FindBy(xpath="//input[@id='submitRequest']")
  	public WebElement StatementSubmitButton;
	
	

	@FindBy(xpath="//select[@id='LetterAction']")
  	public WebElement SelectPDF;
	
	
	@FindBy(linkText="Save")
  	public WebElement EventLogSaveButton;
  	
  	
  	/*
	 WebElement paymentType : Holds 'On Behalf of agent' dropdown element locator
	 */
 	@FindBy(id="debitAgentId")
 	public WebElement onBehalfOfAgentDropdown;
 	
 	@FindBy(xpath="//input[@id='spilitfromtd1']//preceding-sibling:td[3]")
 	public WebElement outstandingIntrestAmount;
 	
 	@FindBy(xpath="//input[@name='submit']")
 	public WebElement SubmitQuery;
 	
 	
 	
 	/*elements for Realex Payment gateway windows*/
   	
 	/*
	 WebElement paymentDeatilsHeader : Holds 'Payment Details' header element locator
	 */
 	@FindBy(xpath="//span[@text='Payment Details']")
 	public WebElement paymentDeatilsHeader;
 	
 	/*
	 WebElement cardNumberTextBox : Holds 'Card Number' textbox element locator
	 */
 	@FindBy(id="pas_ccnum")
 	public WebElement cardNumberTextBox ;
 	
 	/*
	 WebElement expiryMonthTextBox : Holds 'Expiry month' textbox element locator
	 */
 	@FindBy(id="pas_ccmonth")
 	public WebElement expiryMonthTextBox ;
 	
 	/*
	 WebElement expiryYearTextBox : Holds 'Expiry year' textbox element locator
	 */
	@FindBy(id="pas_ccyear")
	public WebElement expiryYearTextBox ;
	
	/*
	 WebElement securityCodeTextBox : Holds 'Security Code' textbox element locator
	 */
	@FindBy(id="pas_cccvc")
	public WebElement securityCodeTextBox ;
	
	/*
	 WebElement cardholderNameTextBox : Holds 'Cardholder Name' textbox element locator
	 */
	@FindBy(id="pas_ccname")
	public WebElement cardholderNameTextBox ;
	
	@FindBy(id="eventDesc")
	public WebElement EventLogTextBox ;
	
	@FindBy(id="eventLogs")
	public WebElement LogNotesTextBox ;
	
	/*
	 WebElement cardholderNameTextBox : Holds 'Pay Now' button element locator
	 */
	@FindBy(id="rxp-primary-btn")
	public WebElement payNowButton ;
	
	public SearchCustomer Errordisplay() {
		String id = driver.findElement(By.xpath("//div[@id='error']/b[contains(text(),'This payment has been declined')]")).getText();
		System.out.println("Error Message"+id);
		return new SearchCustomer(driver);
	}
	
	
	
	@FindBy(xpath="//input[@value='Pay Now']")
	public WebElement CardButton ;
	
	
	//input[@value='Pay Now']
 	
 	
	
	///////Implementation////////////////////////
    public String ExisACCount()
    {
    	String first=null;
		String second=null;
    	String d = ExisACC.getText();
    	String[] d1 = d.split("/");
    	for(int i=0; i<=d1.length; i++)
		    	{
		    		System.out.println(d1[0]);
		    		System.out.println(d1[1]);
		    		first=d1[0];
		    		second=d1[1];
		    	}
		    	int add= Integer.valueOf(second)+1;
		    	System.out.println(add);
		    	String sfinal = String.valueOf(add);
		    	System.out.println(sfinal);
		    	String result = first+"/"+sfinal;
		    	System.out.println(result);
		    	return result;
		    
    }
    public String PerCustID()
    {
    	//driver.navigate().refresh();
    	return PcustID.getText();
    }
    public String PerStatus()
    {
    	//driver.navigate().refresh();
    	return PStatus.getText();
    }
    public String PerName()
    {
    	//driver.navigate().refresh();
    	return PName.getText();
    }
    public String PerAddress()
    {
    	//driver.navigate().refresh();
    	return PAddress.getText();
    }
    ////
    public String Transaction()
    {
    	//driver.navigate().refresh();
    	boolean b= Trxn.isDisplayed();
    	return String.valueOf(b);
    }
    public String ProductType()
    {
    	boolean b= ProdType.isDisplayed();
    	return String.valueOf(b);
    	
    }
    public String Prod()
    {
    	boolean b= Prod.isDisplayed();
    	return String.valueOf(b);
    	
    }
    public String SaleValue()
    {
    	boolean b= SaleVal.isDisplayed();
    	return String.valueOf(b);
    	
    }
    
    public String AggNumber()
    {
    	boolean b= AggNum.isDisplayed();
    	System.out.println(AggNum.isDisplayed());
    	return String.valueOf(b);
    	
    }
    public String SaleDate()
    {
    	boolean b= SalDate.isDisplayed();
    	return String.valueOf(b);
    	
    }
    
    public String getTransactionDate()
    {
    	return TranDate.getAttribute("value");
    	
    }
    
    public SearchCustomerTransaction trasaction()
    {
    	TrxnType.click();
    	//TrxnType.sendKeys(Keys.UP);
    	
    	return new SearchCustomerTransaction(driver);
    }
    public SearchCustomerTransaction CustomerLink()
    {
    	CustLink.click();
    	return new SearchCustomerTransaction(driver);
    }
    
    public SearchCustomerTransaction CustLink()
    {
    	CustomerLink.click();
    	return new SearchCustomerTransaction(driver);
    }
    
    //payNowButton
    
  
	public SearchCustomerTransaction clickSubmitQuery()
    {
		SubmitQuery.click();
    	return new SearchCustomerTransaction(driver);
    }
    
    public SearchCustomerTransaction setPaymentValue(String payval)
    {
    	PayValue.sendKeys(Keys.BACK_SPACE);
    	PayValue.sendKeys(Keys.BACK_SPACE);
    	PayValue.sendKeys(Keys.BACK_SPACE);
    	PayValue.sendKeys(Keys.BACK_SPACE);
    	
    	PayValue.sendKeys(payval);
    	return new SearchCustomerTransaction(driver);
    }
    
    //////////////////////
    
    public SearchCustomerTransaction DisplayPaymentValue(String payval)
    {
    	//CreditValue.sendKeys(Keys.BACK_SPACE);
    	//CreditValue.sendKeys(Keys.BACK_SPACE);
    	//CreditValue.sendKeys(Keys.BACK_SPACE);
    	//CreditValue.sendKeys(Keys.BACK_SPACE);
    	
    	CreditValue.sendKeys(payval);
    	return new SearchCustomerTransaction(driver);
    }
    
    
    
    //////////////////////
    
    
    
    
    public SearchCustomerTransaction setPayment(String pay)
    {
    	String[] d = PaymentAcc.getText().split("/");
		String s = null;
		
		for(int f = 0;f<=d.length;f++)
		{
			s=d[1];
		}
		System.out.println(s);
    	
    	driver.findElement(By.id(s)).sendKeys(pay);
    	return new SearchCustomerTransaction(driver);
    }
    
    /////////////////////////////////
    

    public SearchCustomerTransaction GetPaymentValue(String pay)
    {
    	String[] d = StatementAccount.getText().split("/");
		String s = null;
		
		for(int f = 0;f<=d.length;f++)
		{
			s=d[1];
		}
		System.out.println(s);
    	
    	driver.findElement(By.id(s)).sendKeys(pay);
    	return new SearchCustomerTransaction(driver);
    	
    }
    
    
    
    
    //////////////////////////////////////
    
    public String getAccountsDetails(WebElement element){
    	
    	String strAccounts = element.getText();
    	return strAccounts;
    }
    
    
    public SearchCustomerTransaction Allocate() throws InterruptedException
    {
    	Thread.sleep(3000);
    	driver.findElement(By.xpath(".//*[@id='txtPaymentDate']")).click();
    	Thread.sleep(1000);
    	allo.click();
    	Alert alert = driver.switchTo().alert();
    	alert.accept();
    	return new SearchCustomerTransaction(driver);
    }
    public SearchCustomerTransaction Alert() throws InterruptedException
    {
    	Alert alert = driver.switchTo().alert();
    	Thread.sleep(3000);
    	alert.accept();
    	return new SearchCustomerTransaction(driver);
    }
    
    public SearchCustomerTransaction AlertDismiss() throws InterruptedException
    {
    	Alert alert = driver.switchTo().alert();
    	Thread.sleep(3000);
    	alert.dismiss();
    	System.out.println("Closing the Alert Window");
    	return new SearchCustomerTransaction(driver);
    }
   
    public String setTitle() {
    	return ListOfTitle.getText();
    }
    public SearchCustomerTransaction setPaymentType(String str)
    {
    	PaymentType.sendKeys(str);
    	return new SearchCustomerTransaction(driver);
    }
    public SearchCustomerTransaction setchequeno(String str)
    {
    	Cheque.sendKeys(str);
    	return new SearchCustomerTransaction(driver);
    }
    
    public String getOutStandingAmout(String strAccountNumber){
    	
    	return driver.findElement(By.xpath("//input[@id='"+strAccountNumber+"']/ancestor::td/preceding-sibling::td[3]")).getText();
    	
    }
    
 public String DisplayOutStandingAmout(String strAccountNumber){
    	
    	return driver.findElement(By.xpath("//input[@id='"+strAccountNumber+"']/ancestor::td/preceding-sibling::td[6]")).getText();
    	
    }
 
 public String getCreditCadAmtForSpecificAccount(String strTransactionDate, String str)
 {
 	return driver.findElement(By.xpath("//td[@text='"+strTransactionDate+"']/../td[@text='"+str+"']/following-sibling::td[6]")).getText();
 	
 }
    
    
    public String paymentDetailsHeader()
	{
	    return paymentDeatilsHeader.getText();
	}
	
	public SearchCustomerTransaction cardNumber(String strCardNumber)
    {
		cardNumberTextBox.sendKeys(strCardNumber);
    	return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction expiryMonth(String strExpiryMonth)
    {
		expiryMonthTextBox.clear();
		expiryMonthTextBox.sendKeys(strExpiryMonth);
    	return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction expiryYear(String strExpiryYear)
    {
		expiryYearTextBox.clear();
		expiryYearTextBox.sendKeys(strExpiryYear);
    	return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction securityCode(String strSecurityCode)
    {
		securityCodeTextBox.clear();
		securityCodeTextBox.sendKeys(strSecurityCode);
    	return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction cardHolderName(String strCardholderName)
    {
		cardholderNameTextBox.clear();
		cardholderNameTextBox.sendKeys(strCardholderName);
    	return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction EventLogDescriptionTextBox(String strEventLogTextBox)
    {
		EventLogTextBox.click();
		EventLogTextBox.sendKeys(strEventLogTextBox);
    	return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction EventLogNotesTextBox(String strLogNotesTextBox)
    {
		LogNotesTextBox.click();
		LogNotesTextBox.sendKeys(strLogNotesTextBox);
    	return new SearchCustomerTransaction(driver);
    }
	
	
	
	public SearchCustomerTransaction clickPayNowButton()
    {
		payNowButton.click();
    	return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction GetPaymentFailureText()
    {
		payNowButton.click();
    	return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction clickCardButton()
    {
		CardButton.click();
    	return new SearchCustomerTransaction(driver);
    }
	
	
	
	
	public SearchCustomerTransaction selectTransactionType()
    {
		transactionTypeDropDown.click();
		transactionTypeDropDown.sendKeys(Keys.ARROW_DOWN);
		transactionTypeDropDown.sendKeys(Keys.ARROW_DOWN);
		transactionTypeDropDown.sendKeys(Keys.ARROW_DOWN);
		transactionTypeDropDown.sendKeys(Keys.ENTER);
		return new SearchCustomerTransaction(driver);
    }
    
	public SearchCustomerTransaction selectPaymentType()
    {
		paymentTypeDropdown.click();
		paymentTypeDropdown.sendKeys(Keys.ARROW_DOWN);
		paymentTypeDropdown.sendKeys(Keys.ARROW_DOWN);
		paymentTypeDropdown.sendKeys(Keys.ARROW_DOWN);
		paymentTypeDropdown.sendKeys(Keys.ARROW_DOWN);
		paymentTypeDropdown.sendKeys(Keys.ENTER);
		return new SearchCustomerTransaction(driver);
    }
	
	
	public SearchCustomerTransaction VerifyCPAPayment()
    {
		CPAPayment.isDisplayed();
		return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction VerifyCollectedBy()
    {
		CollectedBy.isDisplayed();
		return new SearchCustomerTransaction(driver);
    }
	
	

	public SearchCustomerTransaction VerifyEnabledOptions()
    {
		 if(CPAPayment.isEnabled())
		  {
		   System.out.print("Text BoX is enabled. GoAhead.");
		  }
		  else
		  {
		   System.out.print("Text Box is disabled. Text Box not Present.");
		  }
		  
		  if(CollectedBy.isEnabled())
		  {
			  System.out.print("Dropdown is enabled. GoAhead.");
		  }
		  else
		  {
		   System.out.print("Dropdown is disabled. Text Box not Present.");
		  }
		return new SearchCustomerTransaction(driver);
    }
	
	


	
	public SearchCustomerTransaction getAllPaymentType()
    {
		Select oSelect = new Select(driver.findElement(By.xpath("//select[@id='custPaymentBean.paymentType']")));
		List <WebElement> elementCount = oSelect.getOptions();
		int iSize = elementCount.size();
		System.out.println("Count of dropdown values:" + iSize);
	 
		for(int i =0; i<iSize ; i++){
			String sValue = elementCount.get(i).getText();
			System.out.println("Display of all the options inside dropdown:" + sValue);
			}
		return new SearchCustomerTransaction(driver);
    }
	
	
	public SearchCustomerTransaction getAllCollectedBy()
    {
		Select oSelect = new Select(driver.findElement(By.xpath("//select[@name='collectedBy']")));
		List <WebElement> elementCount = oSelect.getOptions();
		int iSize = elementCount.size();
		System.out.println("Count of dropdown values:" + iSize);
	 
		for(int i =0; i<iSize ; i++){
			String sValue = elementCount.get(i).getText();
			System.out.println("Display of all the options inside dropdown:" + sValue);
			}
		return new SearchCustomerTransaction(driver);
    }
	
	
	
	
	public SearchCustomerTransaction selectCollectedBy()
    {
		collectByDropdown.click();
		collectByDropdown.sendKeys(Keys.ARROW_DOWN);
		collectByDropdown.sendKeys(Keys.ARROW_DOWN);
		collectByDropdown.sendKeys(Keys.ENTER);
		return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction selectoptionCollectedBy()
    {
		collectByDropdown.click();
		collectByDropdown.sendKeys(Keys.ARROW_DOWN);
		collectByDropdown.sendKeys(Keys.ENTER);
		return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction LogTypeDropdown()
    {
		LogTypeDropdown.click();
		LogTypeDropdown.sendKeys(Keys.ARROW_DOWN);
		LogTypeDropdown.sendKeys(Keys.ARROW_DOWN);
		LogTypeDropdown.sendKeys(Keys.ARROW_DOWN);
		LogTypeDropdown.sendKeys(Keys.ENTER);
		return new SearchCustomerTransaction(driver);
    }
	
	
	public SearchCustomerTransaction EventReasonDropdown()
    {
		EventReasonDropdown.click();
		EventReasonDropdown.sendKeys(Keys.ARROW_DOWN);
		EventReasonDropdown.sendKeys(Keys.ARROW_DOWN);
		EventReasonDropdown.sendKeys(Keys.ENTER);
		return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction SelectAccountDropdown()
    {
		SelectAccount.click();
		SelectAccount.sendKeys(Keys.ARROW_DOWN);
		return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction SelectOverpayment() throws InterruptedException
    {
		//  change code Arrow UP to Arrow Down by Rajesh 
		SelectAccount.click();
		Thread.sleep(1000);
		SelectAccount.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
	//	SelectAccount.sendKeys(Keys.ENTER);
		return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction GetAllSelectAccountDropdownvalues()
    {
		Select oSelect = new Select(driver.findElement(By.xpath("//select[@name='accountList']")));
		List <WebElement> elementCount = oSelect.getOptions();
		int iSize = elementCount.size();
		System.out.println("Count of dropdown values:" + iSize);
	 
		for(int i =0; i<iSize ; i++){
			String sValue = elementCount.get(i).getText();
			System.out.println("Display of all the options inside dropdown:" + sValue);
			}
		return new SearchCustomerTransaction(driver);
    }
	
	
	public SearchCustomerTransaction GetAllLetterTypes()
    {
		Select oSelect = new Select(driver.findElement(By.xpath("//select[@name='LetterType']")));
		List <WebElement> elementCount = oSelect.getOptions();
		int iSize = elementCount.size();
		System.out.println("Count of dropdown values:" + iSize);
	 
		for(int i =0; i<iSize ; i++){
			String sValue = elementCount.get(i).getText();
			System.out.println("Display of all the Letter Type options inside dropdown:" + sValue);
			}
		return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction GetAllTypes()
    {
		Select oSelect = new Select(driver.findElement(By.xpath("//select[@id='LetterAction']")));
		List <WebElement> elementCount = oSelect.getOptions();
		int iSize = elementCount.size();
		System.out.println("Count of dropdown values:" + iSize);
	 
		for(int i =0; i<iSize ; i++){
			String sValue = elementCount.get(i).getText();
			System.out.println("Display of all the Letter Type options inside dropdown:" + sValue);
			}
		return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction SelectRTWLetter()
    {
		SelectLetter.click();
		SelectLetter.sendKeys(Keys.ARROW_DOWN);
		SelectLetter.sendKeys(Keys.ENTER);
		System.out.println("RTW Letter Selected");
		return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction SelectLetterOverpayment()
    {
		SelectLetter.click();
		SelectLetter.sendKeys(Keys.ARROW_DOWN);
		SelectLetter.sendKeys(Keys.ENTER);
		System.out.println("RTW Letter Selected");
		return new SearchCustomerTransaction(driver);
    }
	
	
	public SearchCustomerTransaction SelectLoanAgreementLetter()
    {
		SelectLetter.click();
		SelectLetter.sendKeys(Keys.ARROW_DOWN);
		SelectLetter.sendKeys(Keys.ARROW_DOWN);
		SelectLetter.sendKeys(Keys.ENTER);
		System.out.println("RTW Letter Selected");
		return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction SelectBalancePartial_SettlementLetter()
    {
		SelectLetter.click();
		SelectLetter.sendKeys(Keys.ARROW_DOWN);
		SelectLetter.sendKeys(Keys.ARROW_DOWN);
		SelectLetter.sendKeys(Keys.ARROW_DOWN);
		SelectLetter.sendKeys(Keys.ENTER);
		System.out.println("RTW Letter Selected");
		return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction Select2YearsNonPaymentLetter()
    {
		SelectLetter.click();
		SelectLetter.sendKeys(Keys.ARROW_DOWN);
		SelectLetter.sendKeys(Keys.ARROW_DOWN);
		SelectLetter.sendKeys(Keys.ARROW_DOWN);
		SelectLetter.sendKeys(Keys.ARROW_DOWN);
		SelectLetter.sendKeys(Keys.ENTER);
		System.out.println("RTW Letter Selected");
		return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction SelectPDFLetter()
    {
		SelectPDF.click();
		SelectPDF.sendKeys(Keys.ARROW_DOWN);
		SelectLetter.sendKeys(Keys.ENTER);
		System.out.println("RTW Letter Selected");
		return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction SelectOverpaymentLetter()
    {
		SelectLetter.click();
		SelectLetter.sendKeys(Keys.ARROW_DOWN);
		SelectLetter.sendKeys(Keys.ARROW_DOWN);
		SelectLetter.sendKeys(Keys.ARROW_DOWN);
		SelectLetter.sendKeys(Keys.ARROW_DOWN);
		SelectLetter.sendKeys(Keys.ARROW_DOWN);
		SelectLetter.sendKeys(Keys.ENTER);
		System.out.println("RTW Letter Selected");
		return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction SelectPDF()
    {
		SelectLetter.click();
		SelectLetter.sendKeys(Keys.ARROW_DOWN);
		System.out.println("RTW Letter Selected");
		return new SearchCustomerTransaction(driver);
    }
	

	public SearchCustomerTransaction StatementSubmitButton()
    {
		StatementSubmitButton.click();
		System.out.println("Submit button clicked");
		return new SearchCustomerTransaction(driver);
    }
	
	public SearchCustomerTransaction StatementClickOnSubmitButton()
    {
		WebElement element = driver.findElement(By.xpath("//input[@value='Submit']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		System.out.println("Submit button clicked");
		return new SearchCustomerTransaction(driver);
    }
	
	
	 public SearchCustomerStatement ClickingONLettersEventLog()
	    {
		    WebElement element = driver.findElement(By.linkText("Letters/Event Logs"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			System.out.println("Submit button clicked");
	    	return new SearchCustomerStatement(driver);
	    }
	    
	 
	 public SearchCustomerTransaction ReaddataFromWebTable() throws InterruptedException
	    {
			List<WebElement> tablerow = driver.findElements(By.xpath("//tr[@class='Field2']"));
			System.out.println("Count as:" + tablerow.size());
			
			for(int i=0; i<= tablerow.size();i++)
			{
				System.out.println("data display as:" + tablerow.get(i).getText());	
				Thread.sleep(1000);
			}
			
			System.out.println("Read data From Web Table");
			return new SearchCustomerTransaction(driver);
	    }
	 
	 public SearchCustomerTransaction PerfectdataFromWebTable() throws InterruptedException
	    {
		 System.out.println("Welcome letter For account 11 generated in PDF format");
	//	 List<WebElement> tablerow= driver.findElements(By.xpath("//tr[@class='Field2']/td"));
		 List<WebElement> tablerow= driver.findElements(By.xpath("//tbody/tr[1]/td[6]/a"));
		 System.out.println("Number of records :"+ tablerow.size() );	
			for(int i=0; i<= tablerow.size();i++)
			{
				System.out.println("data display as:" + tablerow.get(i).getText());	
				Thread.sleep(1000);
			}
			return new SearchCustomerTransaction(driver);
	    }
		
	
	
	
	
	public SearchCustomerTransaction selectOnBeHalfOf()
    {
		onBehalfOfAgentDropdown.click();
		onBehalfOfAgentDropdown.sendKeys(Keys.ARROW_DOWN);
		onBehalfOfAgentDropdown.sendKeys(Keys.ENTER);
		return new SearchCustomerTransaction(driver);
    }
    
	public SearchCustomerTransaction EventLogSavebutton()
    {
		EventLogSaveButton.click();
		return new SearchCustomerTransaction(driver);
    }

	 public SearchCustomerTransaction ClickOnSave() {
		   
	    	Actions builder = new Actions(driver);

	    	builder.keyDown(Keys.CONTROL);
	    	builder.keyDown(Keys.SHIFT);
	    	builder.sendKeys("S");

	    	builder.keyUp(Keys.CONTROL);
	    	builder.keyUp(Keys.SHIFT);

	    	builder.build().perform();
	    	
	    	
	    	
	    	return new SearchCustomerTransaction(driver);
	}
	 
	 public SearchCustomerTransaction HitSave() {
		
	    	return new SearchCustomerTransaction(driver);
	}
}