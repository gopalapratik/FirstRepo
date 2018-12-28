
package testscripts.cap;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import verify.Verify;

import browsersetup.BaseClass;
import pageobjects.cap.GooglePage;
import pageobjects.cap.GoogleSearch;
import pageobjects.cap.SearchCustBusinessUnit;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchCustomerDetails;
import reporting.ListenerClass;
import utilities.ExcelUtilities;

//@Listeners(ListenerClass.class)
public class CAPSearchCustBusinessUnitScripts extends BaseClass
{

	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustBusinessUnitTC29(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustBusinessUnit ScustBU= new SearchCustBusinessUnit(getDriver());
		Scustomer = Scustomer.Customer();
		
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "29", 1));	
		Scustomer = Scustomer.Search();
		//System.out.println("kkkkkk");
		ScustBU = ScustBU.custclick();
		ScustBU = ScustBU.BUnit();
		//System.out.println("kkkkkk");
		if(ScustBU.ProD().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "29",2)));
		//System.out.println("kkkkkk");
		setAssertMessage("Business unit tab displays the details of PERSONAL DETAILS",1);
		Verify.verifyEquals(ScustBU.ProD(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "29", 2));
		if(ScustBU.LevelTwo().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "29", 3)));
		setAssertMessage("Business unit tab displays the details of LEVEL 2 UNIT",2);
		Verify.verifyEquals(ScustBU.LevelTwo(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "29", 3));
		if(ScustBU.LevelThree().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "29", 4)));
		setAssertMessage("Business unit tab displays the details of LEVEL 3 UNIT",3);
		Verify.verifyEquals(ScustBU.LevelThree(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "29", 4));
		if(ScustBU.BusUnit().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "29", 5)));
		setAssertMessage("Business unit tab displays the details of BUSINESS UNIT",4);
		Verify.verifyEquals(ScustBU.BusUnit(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "29", 5));
		System.out.println("kkkkkk");
		//System.out.println(ScustBU.AmendButton());
		//if(ScustBU.AmendButton().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "29", 6)));
		//setAssertMessage("Amend button for changing data is not availabel",5);
		//Verify.verifyEquals(ScustBU.AmendButton(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "29", 6));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustBusinessUnitTC30(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustBusinessUnit ScustBU= new SearchCustBusinessUnit(getDriver());
		Scustomer = Scustomer.Customer();
		
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "30", 1));	
		Scustomer = Scustomer.Search();
		//System.out.println("kkkkkk");
		ScustBU = ScustBU.custclick();
		ScustBU = ScustBU.BUnit();
		///L2/////
		if(ScustBU.L2Section().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "30",2)));
		setAssertMessage("Level 2 Unit Displays Section details",1);
		Verify.verifyEquals(ScustBU.L2Section(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "30", 2));
		if(ScustBU.L2Details().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "30", 3)));
		setAssertMessage("Level 2 Unit Displays Staff details",2);
		Verify.verifyEquals(ScustBU.L2Details(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "30", 3));
		////L3/////
		if(ScustBU.L3Area().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "30",4)));
		setAssertMessage("Level 3 Unit Displays Area details",3);
		Verify.verifyEquals(ScustBU.L3Area(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "30", 4));
		if(ScustBU.L3Details().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "30", 5)));
		setAssertMessage("Level 3 Unit Displays Staff details",4);
		Verify.verifyEquals(ScustBU.L3Details(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "30", 5));
		////L4/////
		if(ScustBU.L4Region().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "30",6)));
		setAssertMessage("Level 4 Unit Displays Region details",5);
		Verify.verifyEquals(ScustBU.L4Region(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "30", 6));
		if(ScustBU.L4Details().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "30", 7)));
		setAssertMessage("Level 4 Unit Displays Staff details",6);
		Verify.verifyEquals(ScustBU.L4Details(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "30", 7));
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustBusinessUnitTC31(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustBusinessUnit ScustBU= new SearchCustBusinessUnit(getDriver());
		Scustomer = Scustomer.Customer();
		
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "31", 1));	
		Scustomer = Scustomer.Search();
		//System.out.println("kkkkkk");
		ScustBU = ScustBU.custclick();
		ScustBU = ScustBU.BUnit();
		///BU/////
		if(ScustBU.BUTer().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "31",2)));
		setAssertMessage("Business Unit Displays Territory details",1);
		Verify.verifyEquals(ScustBU.BUTer(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "31", 2));
		if(ScustBU.BUdetails().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "31", 3)));
		setAssertMessage("Business Unit Displays Staff details",2);
		Verify.verifyEquals(ScustBU.BUdetails(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "31", 3));
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
	
}