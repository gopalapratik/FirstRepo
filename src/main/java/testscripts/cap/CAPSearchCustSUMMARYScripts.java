package testscripts.cap;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import browsersetup.BaseClass;
//import reporting.ListenerClass;
import pageobjects.*;
import pageobjects.cap.SearchCustmerSUMMARY;
import pageobjects.cap.SearchCustomer;
import reporting.ListenerClass;
import utilities.ExcelUtilities;
//@Listeners(ListenerClass.class)
public class CAPSearchCustSUMMARYScripts extends BaseClass {

	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustmerSUMMARYTC8(String environment, String clientName) throws InterruptedException
	{
		SearchCustmerSUMMARY Summary = new SearchCustmerSUMMARY(getDriver());
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("1 By default Search Customer page is displayed",1);
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "8", 1));	
		Scustomer = Scustomer.setFN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "8", 2));	
		Scustomer = Scustomer.setSN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "8", 3));
		Scustomer = Scustomer.setPC(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "8", 4));
		Scustomer = Scustomer.setNIN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "8", 5));
		Scustomer = Scustomer.setTN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "8", 6));
		Scustomer = Scustomer.setPaymentCardNo(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "8", 7));
		Scustomer = Scustomer.setFlat(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "8", 8));
		Scustomer = Scustomer.setHN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "8", 9));
		Scustomer = Scustomer.setHname(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "8", 10));
		Scustomer = Scustomer.setStreetname(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "8", 11));
		Scustomer = Scustomer.setTC(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "8", 12));	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.CustIDtransaction();
		assertEquals(Summary.Result1(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "8", 13));
		
		if(Summary.Result1().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "8", 13)))
			setAssertMessage("2 System displayed a details >>>>>"+Summary.Result1(),2);
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustmerSUMMARYTC9(String environment, String clientName) throws InterruptedException
	{
		SearchCustmerSUMMARY Summary = new SearchCustmerSUMMARY(getDriver());
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("1 By default Search Customer page is displayed",1);
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "9", 1));	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		
		if(Summary.Balance().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "9", 2)))
			setAssertMessage("2 System displayed a Balance >>>>>"+Summary.Balance(),2);
		
        
		if(Summary.HBalance().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "9", 3)))
			setAssertMessage("3 System displayed Household Balance >>>>>"+Summary.HBalance(),3);
		
		 assertEquals(Summary.ACdate(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "9", 4));
			if(Summary.ACdate().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "9", 4)))
				setAssertMessage("4 System displayed last payment date is >>>>>"+Summary.ACdate(),4);
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustmerSUMMARYTC10(String environment, String clientName) throws InterruptedException
	{
		SearchCustmerSUMMARY Summary = new SearchCustmerSUMMARY(getDriver());
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("1 By default Search Customer page is displayed",1);
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "10", 1));	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		Summary = Summary.showBal();
		if(Summary.ACNO1().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "10", 2)))
		{
		if(Summary.ACNO2().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "10", 3)))
		{	setAssertMessage("2 System display acount no >>>>>"+Summary.ACNO1()+"And"+Summary.ACNO2(),2);
		}
		}
		Summary = Summary.AccountLink();
		assertEquals(Summary.ScreenResult(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "10", 4));
		if(Summary.ScreenResult().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "10", 4)))
			setAssertMessage("3 System displays "+Summary.ScreenResult()+" Screen after clicking on account no",3);
		
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustmerSUMMARYTC11(String environment, String clientName) throws InterruptedException
	{
		SearchCustmerSUMMARY Summary = new SearchCustmerSUMMARY(getDriver());
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("1 By default Search Customer page is displayed",1);
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "11", 1));	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		Summary = Summary.AmendButton();
		Summary = Summary.setFirstN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "11", 2));	
		Summary = Summary.setTTN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "11", 3));	
		//Thread.sleep(5000);
		Assert.assertNotNull(Summary.CID);
		//setAssertMessage("2 CustID input field is readOnly",1);
		if(Summary.CID.equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "11", 4)));
		//setAssertMessage("2 CustID input field is readOnly",1);
		setAssertMessage("2 CustID input field is readOnly",1);
		//Thread.sleep(5000);
		Summary = Summary.NeSearch();
		Thread.sleep(6000);
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("3 Search Customer page is displayed after clicking on new search",1);
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustmerSUMMARYTC12(String environment, String clientName) throws InterruptedException
	{
		SearchCustmerSUMMARY Summary = new SearchCustmerSUMMARY(getDriver());
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("1 By default Search Customer page is displayed",1);
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "12", 1));	
		Scustomer = Scustomer.Search();
		Summary = Summary.CLink();
		Summary = Summary.AmendButton();
		Summary = Summary.setStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "12", 2));	
		Summary = Summary.setTTN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "12", 3));
		Summary = Summary.setTitle(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "12", 4));	
		Summary = Summary.setFirstN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "12", 5));	
		Summary = Summary.setLastN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "12", 6));
		Summary = Summary.setHP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "12", 7));
		Summary = Summary.setMP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "12", 8));
		Summary = Summary.SaveButton();
		assertEquals(Summary.AmendResult(),(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "12", 9)));
		if(Summary.AmendResult().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "12", 9)))
			setAssertMessage("2 Details Reflected Successfully in UI",3);
		
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustmerSUMMARYTC13(String environment, String clientName) throws InterruptedException
	{
		SearchCustmerSUMMARY Summary = new SearchCustmerSUMMARY(getDriver());
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("1 By default Search Customer page is displayed",1);
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "13", 1));	
		Scustomer = Scustomer.Search();
		Summary = Summary.CLink();
		String Result = String.valueOf(Summary.PersonalResult());
		assertEquals(Summary.PersonalResult(),(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "13", 2)));
		if(Summary.PersonalResult().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "13", 2)))
			setAssertMessage("2 Details on summary page are readonly",3);
		
		
	}
}
