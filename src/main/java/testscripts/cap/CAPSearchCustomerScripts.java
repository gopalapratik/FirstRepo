package testscripts.cap;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import browsersetup.BaseClass;
import pageobjects.cap.GooglePage;
import pageobjects.cap.GoogleSearch;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchCustomerStatement;
import pageobjects.cap.SearchCustomerTransaction;
import reporting.ListenerClass;
import testdata.ConfigurationData;
import utilities.ExcelUtilities;
import verify.Verify;

//@Listeners(ListenerClass.class)
public class CAPSearchCustomerScripts extends BaseClass
{

//	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
//	@Parameters({ "environment", "clientName" })
//	public void TestCap(String environment, String clientName) throws InterruptedException
//	{
//		SearchCustomer d = new SearchCustomer(getDriver());
//		String pageTitle = d.getPageTitle();
//		Assert.assertEquals(pageTitle,"Morses-Customer Account Processing");
//		
//	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustomer(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("1 By default Search Customer page is displayed",1);
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "1", 1));	
		Scustomer = Scustomer.setFN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "1", 2));	
		Scustomer = Scustomer.setSN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "1", 3));
		Scustomer = Scustomer.setPC(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "1", 4));
		Scustomer = Scustomer.setNIN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "1", 5));
		Scustomer = Scustomer.setTN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "1", 6));
		Scustomer = Scustomer.Search();
		Thread.sleep(3000);
		//Assert.assertEquals(Scustomer.NSearch(), "New Search");
		assertEquals(Scustomer.result(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "1", 7));
		if(Scustomer.result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "1", 7)))
			setAssertMessage("2 Customer details are populated as per prototype(Live).",2);
		/*if(Scustomer.NewSearch.equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "1", 7)))
			setAssertMessage("New Search",1);
		Verify.verify(Scustomer.NewSearch, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "HomePage_"+environment.toUpperCase(), "TC1", 4));
		*/
		
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustomerTransaction(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("1 By default Search Customer page is displayed",1);
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "1", 1));	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.CustIDtransaction();
		Scustomer = Scustomer.CustSearchTransaction();
		Scustomer = Scustomer.SelectProductType();
		Thread.sleep(2000);
		Scustomer = Scustomer.setProduct(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "2", 2));
		Thread.sleep(2000);
		Scustomer = Scustomer.setValue(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "2", 3));
		Thread.sleep(2000);
		Scustomer = Scustomer.setaggnum();
		Thread.sleep(2000);
		Scustomer =Scustomer.ConfirmSale();
		
		assertEquals(Scustomer.resultmessege(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "2", 5));
		
		if(Scustomer.resultmessege().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "2", 5)))
			setAssertMessage("2 System displayed a message >>>>>"+Scustomer.resultmessege(),2);
		Scustomer =Scustomer.Save();
		assertEquals(Scustomer.resultmessege(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "2", 6));
		if(Scustomer.resultmessege().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "2", 6)))
			setAssertMessage("3 System displayed a message >>>>>"+Scustomer.resultmessege(),3);
	}
	
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustomerTC5(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("1 By default Search Customer page is displayed",1);
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "5", 1));	
		Scustomer = Scustomer.setFN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "5", 2));	
		Scustomer = Scustomer.setSN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "5", 3));
		Scustomer = Scustomer.setPC(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "5", 4));
		Scustomer = Scustomer.setNIN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "5", 5));
		Scustomer = Scustomer.setTN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "5", 6));
		Scustomer = Scustomer.setPaymentCardNo(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "5", 7));
		Scustomer = Scustomer.setFlat(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "5", 8));
		Scustomer = Scustomer.setHN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "5", 9));
		Scustomer = Scustomer.setHname(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "5", 10));
		Scustomer = Scustomer.setStreetname(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "5", 11));
		Scustomer = Scustomer.setTC(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "5", 12));
		Scustomer = Scustomer.Search();
		assertEquals(Scustomer.result(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "5",13));
		if(Scustomer.result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "5", 13)))
			setAssertMessage("2 Customer details are populated as per prototype(Live).",2);
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustomerTC6(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("1 By default Search Customer page is displayed",1);
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "6", 1));	
		Scustomer = Scustomer.setFN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "6", 2));	
		Scustomer = Scustomer.setSN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "6", 3));
		Scustomer = Scustomer.setPC(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "6", 4));
		Scustomer = Scustomer.setNIN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "6", 5));
		Scustomer = Scustomer.setTN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "6", 6));
		
		Scustomer = Scustomer.Search();
		assertEquals(Scustomer.resultmessege(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "6",7));
		if(Scustomer.resultmessege().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "6", 7)))
			setAssertMessage("2 System displayed a message >>>>>"+Scustomer.resultmessege(),2);
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustomerTC7(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("1 By default Search Customer page is displayed",1);
		Scustomer = Scustomer.setFN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "7", 1));	
		Scustomer = Scustomer.setSN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "7", 2));	
		Scustomer = Scustomer.LiveCheckbox();
		Scustomer = Scustomer.Search();
		assertEquals(Scustomer.Statusresult(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "7",3));
		if(Scustomer.Statusresult().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "7", 3)))
			setAssertMessage("2 System Display status as closed",2);
		System.out.println("iijhfhgdff");
		Scustomer.cusIDclicklink();
		System.out.println("iijhfhgdff");
		//Scustomer.ScreenDetailSummary();
		String Result = Scustomer.ScreenDetailSumm()+ Scustomer.getAllData();
		//System.out.println("Scustomer.ScreenDetailSumm()"+Scustomer.ScreenDetailSumm());
		//System.out.println( "Scustomer.getAllData()"+Scustomer.getAllData());

		if(Result.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "7", 4)))
			setAssertMessage("Screen details are Summary,",2);
			Verify.verifyEquals(Result, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "7", 4));
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}

}
