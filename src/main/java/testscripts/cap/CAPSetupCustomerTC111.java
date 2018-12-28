package testscripts.cap;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsersetup.BaseClass;
import pageobjects.cap.SearchCustAffordability;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SetupCustomer;
import utilities.ExcelUtilities;
import verify.Verify;

public class CAPSetupCustomerTC111 extends BaseClass{
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SetupCustomerTC111(String environment, String clientName) throws InterruptedException
	{
		Thread.sleep(2000);
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SetupCustomer Setup = new SetupCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Setup =Setup.CustomerSetup();
		String CustIdnew=Setup.CustIDNewText();
		Setup =Setup.SetTT(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "111", 1));
		Setup =Setup.SetFisrtName();
		Setup =Setup.SetLastName();
		Setup =Setup.Setfaltno(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "111", 4));
		Setup =Setup.SetHNO(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "111", 5));
		Setup =Setup.setHname(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "111",6));
		Setup =Setup.SetSName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "111", 7));
		Setup =Setup.SetPC(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "111", 8));
		Setup =Setup.SetTel(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "111", 9));
		Setup =Setup.Setmob(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "111", 10));
		Setup =Setup.ContinueButton();
		Setup= Setup.windowcustomerlist();
		Setup =Setup.SaveButton();
		Setup =Setup.Alert();
		if(Setup.Message().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "111", 11)))
		setAssertMessage("System displayed a message "+Setup.Message() ,1);
		Verify.verifyEquals(Setup.Message(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "111", 11));
		//System.out.println("id is"+Setup.CustIDNewgenText());
		
		/* Need To check with Gagan
		
		String text=Setup.CustIDNewgen.getText();
		System.out.println(text);
		//System.out.println("text"+text);
		String cust = CustIdnew.trim();
		if(Setup.CustIDNewgenText().equals(cust))
		setAssertMessage("New customer with unique customer id is created on CAP" ,2);
		Verify.verifyEquals(Setup.CustIDNewgenText(), cust);
		System.out.println("cust is: "+cust);
		Thread.sleep(10000);
		Scustomer = Scustomer.Staff();
		Scustomer = Scustomer.Customer();
		
		Scustomer = Scustomer.setCID(cust);		
		Scustomer = Scustomer.Search();
		
		Thread.sleep(10000);
		SearchCustAffordability ScustAff= new SearchCustAffordability(getDriver());
		ScustAff = ScustAff.custclick();
		
		if(Setup.CustIDNewgenText().equals(cust))
		setAssertMessage("New customer with unique customer id is created on CAP and it is displayed on customer screen" ,3);
		Verify.verifyEquals(Setup.CustIDNewgenText(), cust);
		*/
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
//		
	}

}
