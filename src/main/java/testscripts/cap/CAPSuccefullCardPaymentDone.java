package testscripts.cap;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsersetup.BaseClass;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchCustomerStatement;
import pageobjects.cap.SearchCustomerTransaction;
import reporting.ListenerClass;
import testdata.TestConstants;
import utilities.ExcelUtilities;
import verify.Verify;

//@Listeners(ListenerClass.class)
public class CAPSuccefullCardPaymentDone extends BaseClass {

	String strCustomerID, strPayableAmt, strPaymentValue, strPaymentAccount, strAccountNumber, strTransactionDate,
			strPaymentAccountNum;
	int intPayableAmt, beforePaymentOutstandingAmt, afterPaymentOutstandingAmt, intCreditAmt, strAccountNumber11;

	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "CAP", "Customer" })
	@Parameters({ "environment", "clientName" })
	public void CAPSuccefullCardPayment(String environment, String clientName)
			throws InterruptedException, IOException, AWTException {
		
		strCustomerID = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "27", 1);
		strPaymentValue = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "27", 2);
		strPayableAmt = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "27", 3);
		intPayableAmt = Integer.valueOf(strPayableAmt);

		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerTransaction Scusttrxn = new SearchCustomerTransaction(getDriver());
		SearchCustomerStatement ScustStat = new SearchCustomerStatement(getDriver());

	
//		Scustomer = Scustomer.Customer();
//		if(Scustomer.SCust().equals("Search Customer"))
//			setAssertMessage("1 By default Search Customer page is displayed",1);
//		Scustomer = Scustomer.setCID(strCustomerID);	
//		//Scustomer = Scustomer.setCID("00044317");
//		Scustomer = Scustomer.Search();
//		Thread.sleep(10000);
//		Scusttrxn = Scusttrxn.CustomerLink();
//		Thread.sleep(10000);
//		Scustomer = Scustomer.CustSearchTransaction();
		
		Scustomer = Scustomer.Customer();
		if (Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("1 By default Search Customer page is displayed", 1);
		Scustomer = Scustomer.setCID(strCustomerID);
		Scustomer = Scustomer.Search();
		Scusttrxn = Scusttrxn.CustomerLink();
		Scustomer = Scustomer.CustSearchTransaction();
		
		Thread.sleep(5000);
		System.out.println("Hello1");
		Scusttrxn = Scusttrxn.trasaction();
		Thread.sleep(2000);
		System.out.println("Hello2");
		
		Thread.sleep(5000);
		explicitWaitForElement(Scusttrxn.paymentTypeDropdown);
		System.out.println("Hello3");
		Scusttrxn = Scusttrxn.selectPaymentType();
		
		Thread.sleep(5000);
		Scusttrxn = Scusttrxn.getAllPaymentType();
		Thread.sleep(3000);
		
		explicitWaitForElement(Scusttrxn.collectByDropdown);
		System.out.println("Hello4");
		
		Thread.sleep(3000);
		
		Scusttrxn = Scusttrxn.selectCollectedBy();
		Thread.sleep(5000);
		System.out.println("Hello5");
		
		explicitWaitForElement(Scusttrxn.onBehalfOfAgentDropdown);
		System.out.println("Hello6");
		
		Thread.sleep(3000);
		
		Scusttrxn = Scusttrxn.selectOnBeHalfOf();
		System.out.println("Hello7");
		
		strTransactionDate = Scusttrxn.getTransactionDate();
		System.out.println(strTransactionDate);
		
		strPaymentAccount = Scusttrxn.getAccountsDetails(Scusttrxn.PaymentAcc);
		System.out.println(strPaymentAccount);
		strAccountNumber = strPaymentAccount.split("/")[1];
		System.out.println(strAccountNumber);
		
		Scusttrxn = Scusttrxn.setPaymentValue(strPaymentValue);
		Thread.sleep(3000);
	//	Scusttrxn = Scusttrxn.setPayment(strPayableAmt);
		System.out.println("HELLODONE");
		
		//split decimal value

		String strAmt = Scusttrxn.getOutStandingAmout(strAccountNumber).replaceAll("[-+^:,]","");
		System.out.println("strAmt IS :"+strAmt);
	    beforePaymentOutstandingAmt = Integer.valueOf(strAmt.split("\\.")[0]);
	    System.out.println("bEFORE PAYMENT AMT: "+beforePaymentOutstandingAmt);
		
		String strParentWindow = getDriver().getWindowHandle();
		System.out.println(strParentWindow);
		
		Scusttrxn.allo.click();
		Thread.sleep(5000);
		
		Scusttrxn.Alert();
		
		
		//fluentWaitMethod();
		Thread.sleep(8000);

		Set <String>multipleWindows= getDriver().getWindowHandles();
		
		
		for (String currentWindow : multipleWindows) 
		{
			Thread.sleep(200);
			getDriver().switchTo().window(currentWindow);
			String currentWindowTitle=getDriver().getTitle();
			
			if(currentWindowTitle.contains("Realex"))
			{
				System.out.println("Current Window: "+currentWindowTitle);
				break;
			}	
		}
		

		Thread.sleep(5000);
		
		List<WebElement> lstOfFrames = getDriver().findElements(By.xpath("//iFrame"));
		System.out.println("No of Frames : "+lstOfFrames.size());
		Thread.sleep(2000);
		
		switchToFrame("frRealex");
		System.out.println("Navigating to iFrame");
		Thread.sleep(10000);
		
		Scusttrxn.cardNumber(TestConstants.strCardNumber);
		
		Scusttrxn.expiryMonth(TestConstants.strExpiryMonth);
		
		Scusttrxn.expiryYear(TestConstants.strExpiryYear);
		
		Scusttrxn.securityCode(TestConstants.strSecurityCode);
		
		Scusttrxn.cardHolderName(TestConstants.strUserName);
		
		Scusttrxn .clickPayNowButton();
		
		Thread.sleep(10000);
				
		
		switchToParentWindow(strParentWindow);
		System.out.println("Switch to parent window");
		
		Thread.sleep(5000);
		setAssertMessage("System displayed a message <<<<<<"+Scustomer.resultmessege(),1);
		Thread.sleep(10000);
		System.out.println("Payment Success Msg : "+Scustomer.resultmessege());
		
		Thread.sleep(5000);
		Verify.verifyTrue(Scustomer.resultmessege().contains(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "27",4)), "Verifying payment action should get completed successfully");
		
		Thread.sleep(10000);
		
		String strAmt1 = Scusttrxn.getOutStandingAmout(strAccountNumber).replaceAll("[-+^:,]","");
		System.out.println("strAmt IS :"+strAmt1);
		Thread.sleep(5000);
	    beforePaymentOutstandingAmt = Integer.valueOf(strAmt1.split("\\.")[0]);
	    System.out.println("Before Payment Amount: "+beforePaymentOutstandingAmt);
	    Thread.sleep(5000);
		System.out.println("After Payment Amount : "+Scusttrxn.getOutStandingAmout(strAccountNumber));
		
		Thread.sleep(10000);
	
		
		setAssertMessage("Outstanding amount should get updated after complted payment by card and updated outstanding amount is : "+afterPaymentOutstandingAmt,1);
		Verify.verifyEquals(afterPaymentOutstandingAmt, beforePaymentOutstandingAmt-intPayableAmt);
		Thread.sleep(2000);
		
		//After switching Statement page 
		
		ScustStat.Statement();
		System.out.println("Switching to Statement Tab");
		Thread.sleep(10000);
		Thread.sleep(10000);
		
		strPaymentAccount = Scusttrxn.getAccountsDetails(Scusttrxn.CreditValue);
		System.out.println("Credit Value in Statement tab gets display as:"+ strPaymentAccount);
		System.out.println("Verified Credit Value under Account Statement");
		//strAccountNumber = strPaymentAccount.split("\\.")[0];
		//System.out.println("Display of Credit Value after spliting:" + strAccountNumber);
		Thread.sleep(5000);
		ClosingBrowser();
		Thread.sleep(10000);
		
		
	}

}
