
package testscripts.cap;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import browsersetup.BaseClass;
import helpers.CommonFunctions;
//import reporting.ListenerClass;
import pageobjects.*;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchCustomerDetails;
import pageobjects.cap.SearchCustomerLetterEvent;
import reporting.ListenerClass;
import utilities.ExcelUtilities;
import verify.Verify;
//@Listeners(ListenerClass.class)
public class CAPSearchCustLetterEventScripts extends BaseClass {

	
	@Test(priority=3,enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustLetterEventTC18(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerLetterEvent ScustletterEvent = new SearchCustomerLetterEvent(getDriver());
		SearchCustomerDetails ScustDetail = new SearchCustomerDetails(getDriver());
		Scustomer = Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("By default Search Customer page is displayed",1);
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "18", 1));	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		//ScustDetail = ScustDetail.CustomerLink();
		ScustDetail.CustDetail();
		ScustletterEvent.LetterEventclick();
		
		if(ScustletterEvent.LogType().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "18", 2)))
			setAssertMessage("System allows log to be sorted are "+ScustletterEvent.LogType() ,2);
		Verify.verifyEquals(ScustletterEvent.LogType(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "18", 2));
		System.out.println(ScustletterEvent.LogType());
		//ScustletterEvent.LogTypeselect("Note");
		ScustletterEvent.LogTypeselect(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "18", 3));
		Thread.sleep(5000);
		ScustletterEvent.LogTypeselect(" ");
		Thread.sleep(5000);
		ScustletterEvent.VeiwHistory();
		if(ScustletterEvent.LogResult().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "18", 4)));
			setAssertMessage("After clicking on view log history we can see all log history till date",3);	
		Verify.verifyEquals(ScustletterEvent.LogResult(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "18", 4));		
		// Need to verify the line later	
//		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		// Need to put the dynamic Date and verify with ScustletterEvent.LogResult()
		
		
	}
	
	@Test(priority=1,enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustLetterEventTC19(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerLetterEvent ScustletterEvent = new SearchCustomerLetterEvent(getDriver());
		SearchCustomerDetails ScustDetail = new SearchCustomerDetails(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "19", 1));	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		//ScustDetail = ScustDetail.CustomerLink();
		ScustDetail.CustDetail();
		ScustletterEvent.LetterEventclick();
		ScustletterEvent.CreateNewLog();
		ScustletterEvent.NewWindowOpen(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "19", 2),"false");
		
		System.out.println(ScustletterEvent.NewlogResult());

	//	System.out.println("expectedddddddddd"+CommonFunctions.NowDate()+" "+CommonFunctions.CurrentTimeFormatar("HH:mm"));
		if(ScustletterEvent.NewlogResult().equals(CommonFunctions.NowDate()+" "+CommonFunctions.CurrentTimeFormatar("HH:mm")))
			setAssertMessage("New log Created succesfully" ,1);
		Verify.verifyEquals(ScustletterEvent.NewlogResult(),CommonFunctions.NowDate()+" "+CommonFunctions.CurrentTimeFormatar("HH:mm"));

		// Need to verfy this line latter
			//	Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
	@Test(priority=2,enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustLetterEventTC20(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerLetterEvent ScustletterEvent = new SearchCustomerLetterEvent(getDriver());
		SearchCustomerDetails ScustDetail = new SearchCustomerDetails(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "20", 1));	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		//ScustDetail = ScustDetail.CustomerLink();
		ScustDetail.CustDetail();
		ScustletterEvent.LetterEventclick();
		ScustletterEvent.CreateNewLog();
		ScustletterEvent.NewWindowOpen(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "20", 2),"true");

		if(ScustletterEvent.ErrorMsg.equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "20", 3)))
			setAssertMessage("System Displayed a message "+ScustletterEvent.ErrorMsg ,1);
		Verify.verifyEquals(ScustletterEvent.ErrorMsg, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "20", 3));
	//	Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}	
}