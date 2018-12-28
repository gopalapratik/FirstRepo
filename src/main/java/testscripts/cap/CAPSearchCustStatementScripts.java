
package testscripts.cap;

import static org.testng.Assert.assertEquals;

import java.text.ParseException;

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
import pageobjects.cap.SearchCustomerStatement;
import reporting.ListenerClass;
import utilities.ExcelUtilities;
import verify.Verify;
@Listeners(ListenerClass.class)
public class CAPSearchCustStatementScripts extends BaseClass {

	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustStatementTC21(String environment, String clientName) throws InterruptedException, ParseException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerLetterEvent ScustletterEvent = new SearchCustomerLetterEvent(getDriver());
		SearchCustomerDetails ScustDetail = new SearchCustomerDetails(getDriver());
		SearchCustomerStatement ScustStat= new SearchCustomerStatement(getDriver());
		Scustomer = Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("By default Search Customer page is displayed",1);
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "21", 1));	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		//ScustDetail = ScustDetail.CustomerLink();
		//ScustDetail.CustDetail();
		ScustStat.Statement();
		
		ScustStat.Account(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "21", 2));
		Thread.sleep(10000);
		ScustStat.Amend();
		ScustStat.AggNumber(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "21", 3));
		Thread.sleep(7000);
		ScustStat.AggDate();
		Thread.sleep(3000);
		ScustStat.ReviewDate();
		
		ScustStat.SaveButton();
		Thread.sleep(7000);
		if(ScustStat.Message().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "21", 4)))
			setAssertMessage("Action completed successfully." ,2);
		Verify.verifyEquals(ScustStat.Message(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "21", 4));
		
		ScustDetail.CustDetail();
		Thread.sleep(4000);
		ScustStat.Statement();
		ScustStat.Account(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "21", 2));
		Thread.sleep(10000);
		if(ScustStat.StatResult().equals(ScustStat.aggNo))
			// Data are not coming so test cases is getting fail
			setAssertMessage("Save Changes Successfully" ,3);
		Verify.verifyEquals(ScustStat.StatResult(), ScustStat.aggNo);
		
	// 	Need to verify Later
	
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
	
	/*@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustStatementtest(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerStatement ScustStat= new SearchCustomerStatement(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer= Scustomer.setFN("LEIGH");
		Scustomer= Scustomer.setSN("TROUGHTON");
		Scustomer = Scustomer.Search();
		String ID=Scustomer.CusIDClink.getText();
		Scustomer = Scustomer.cusIDclick();
		ScustStat.Statement();
		System.out.println(ScustStat.ResultE2E());
		if(ScustStat.ResultE2E().equals(CommonFunctions.NowDate()))
			setAssertMessage("Payment Done today in MAP is reflected in CAP" ,1);
		Verify.verifyEquals(ScustStat.ResultE2E(),CommonFunctions.NowDate());
		System.out.println(ScustStat.ResultE2ECredit());
		if(ScustStat.ResultE2ECredit().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "21", 5)))
			setAssertMessage("CAsh payment debited is "+ScustStat.ResultE2ECredit() ,2);
		Verify.verifyEquals(ScustStat.ResultE2ECredit(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "21", 5));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}*/
}