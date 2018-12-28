package testscripts.cap;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsersetup.BaseClass;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchCustomerStatement;
import pageobjects.cap.SearchCustomerTransaction;
import reporting.ListenerClass;
import utilities.ExcelUtilities;

//@Listeners(ListenerClass.class)
public class CAPAutomate_Letter_GenerationScripts extends BaseClass {

	String strCustomerID, strPayableAmt, strPaymentValue, strPaymentAccount, strAccountNumber, strTransactionDate,
			strPaymentAccountNum;
	int intPayableAmt, beforePaymentOutstandingAmt, afterPaymentOutstandingAmt, intCreditAmt, strAccountNumber11;

	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity", "CAP", "Customer" })
	@Parameters({ "environment", "clientName" })
	public void Verifying_RTWLetter_Generation(String environment, String clientName)
			throws InterruptedException, IOException, AWTException {
		
		strCustomerID = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "27", 1);
		strPaymentValue = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "27", 2);
		strPayableAmt = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "27", 3);
		intPayableAmt = Integer.valueOf(strPayableAmt);

		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerTransaction Scusttrxn = new SearchCustomerTransaction(getDriver());
		SearchCustomerStatement ScustStat = new SearchCustomerStatement(getDriver());

		Scustomer = Scustomer.Customer();
		if (Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("1 By default Search Customer page is displayed", 1);
		Scustomer = Scustomer.setCID(strCustomerID);
		Scustomer = Scustomer.Search();
		Scusttrxn = Scusttrxn.CustomerLink();
		Scustomer = Scustomer.CustSearchTransaction();

		// After switching Statement page
		ScustStat.Statement();
		System.out.println("Switching to Statement Tab");
		Thread.sleep(1000);

		Scusttrxn = Scusttrxn.GetAllSelectAccountDropdownvalues();
		Thread.sleep(10000);

		Scusttrxn = Scusttrxn.SelectAccountDropdown();
		System.out.println("Select Account from Dropdown Succeeded");
		Thread.sleep(10000);

		Scusttrxn = Scusttrxn.GetAllLetterTypes();
		Thread.sleep(1000);

		Scusttrxn = Scusttrxn.SelectRTWLetter();
		Thread.sleep(1000);

		Scusttrxn = Scusttrxn.GetAllTypes();
		Thread.sleep(1000);

		Scusttrxn = Scusttrxn.SelectPDFLetter();
		Thread.sleep(1000);

		Scusttrxn = Scusttrxn.StatementClickOnSubmitButton();
		Thread.sleep(1000);
		
		Runtime.getRuntime().exec("D:\\Product\\Autoit\\DownloadFile.exe");
		Thread.sleep(10000);
		Runtime.getRuntime().exec("D:\\Product\\Autoit\\PDFClose.exe");
		Thread.sleep(10000);
		Runtime.getRuntime().exec("D:\\Product\\Autoit\\EndPDF.exe");
		Thread.sleep(10000);
		ClosingBrowser();
		Thread.sleep(1000);

	}

}
