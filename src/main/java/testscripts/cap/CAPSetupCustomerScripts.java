
package testscripts.cap;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import verify.Verify;

import browsersetup.BaseClass;
import pageobjects.*;
import pageobjects.cap.GooglePage;
import pageobjects.cap.GoogleSearch;
import pageobjects.cap.SearchCustAffordability;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SetupCustomer;
import reporting.ListenerClass;
import utilities.ExcelUtilities;

@Listeners(ListenerClass.class)
public class CAPSetupCustomerScripts extends BaseClass
{
	
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SetupCustomerTC33(String environment, String clientName) throws InterruptedException
	{
		Thread.sleep(1000);
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SetupCustomer Setup = new SetupCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Setup =Setup.CustomerSetup();
		if(Setup.CustIDNewText()!="")
		{	setAssertMessage("Setup customer page displayed with new customer id" ,1);}
		
		
		if(Setup.Customerstatus().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "33", 1)))
			setAssertMessage("Setup customer page displayed with "+Setup.Customerstatus() ,2);
		Verify.verifyEquals(Setup.Customerstatus(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "33", 1));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SetupCustomerTC34(String environment, String clientName) throws InterruptedException
	{
		Thread.sleep(1000);
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SetupCustomer Setup = new SetupCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Setup =Setup.CustomerSetup();
		Setup =Setup.SetTT(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "34", 1));
		Setup =Setup.ContinueButton();
		
		if(Setup.Message().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "34", 2)))
			setAssertMessage("System displayed a message "+Setup.Message() ,1);
		Verify.verifyEquals(Setup.Message(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "34", 2));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SetupCustomerTC35(String environment, String clientName) throws InterruptedException
	{
		Thread.sleep(1000);
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SetupCustomer Setup = new SetupCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Setup =Setup.CustomerSetup();
		Setup =Setup.SetTT(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "35", 1));
		Setup =Setup.SetFisrtName();
		Setup =Setup.SetLastName();
		Setup =Setup.Setfaltno(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "35", 4));
		Setup =Setup.SetHNO(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "35", 5));
		Setup =Setup.setHname(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "35",6));
		Setup =Setup.SetSName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "35", 7));
		Setup =Setup.SetPC(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "35", 8));
		Setup =Setup.SetTel(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "35", 9));
		Setup =Setup.Setmob(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "35", 10));
		Setup =Setup.ContinueButton();
		Setup =Setup.date();
		//Thread.sleep(2000);
		Setup =Setup.SaveButton();
//		System.out.println("alert starts");
//		Setup =Setup.Alert();
//		
		if(Setup.Message().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "35", 11)))
			setAssertMessage("System displayed a message "+Setup.Message() ,1);
		Verify.verifyEquals(Setup.Message(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "35", 11));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
//		
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SetupCustomerTC110(String environment, String clientName) throws InterruptedException
	{
		Thread.sleep(1000);
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SetupCustomer Setup = new SetupCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Setup =Setup.CustomerSetup();
		Setup =Setup.SetTT(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "110", 1));
		Setup =Setup.SetFisrtName();
		Setup =Setup.SetLastName();
		Setup =Setup.Setfaltno(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "110", 4));
		Setup =Setup.SetHNO(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "110", 5));
		Setup =Setup.setHname(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "110",6));
		Setup =Setup.SetSName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "110", 7));
		Setup =Setup.SetPC(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "110", 8));
		Setup =Setup.SetTel(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "110", 9));
		Setup =Setup.Setmob(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "110", 10));
		Setup =Setup.ContinueButton();
		Setup= Setup.windowcustomerlist();
		Setup =Setup.SaveButton();
		//System.out.println("alert starts");
		Setup =Setup.Alert();
		
		if(Setup.Message().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "110", 11)))
			setAssertMessage("System displayed a message "+Setup.Message() ,1);
	Verify.verifyEquals(Setup.Message(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "110", 11));
	Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
//		
	}
	
	
}
	