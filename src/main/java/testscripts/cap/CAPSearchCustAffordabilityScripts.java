
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
import pageobjects.cap.SearchCustAffordability;
import pageobjects.cap.SearchCustBusinessUnit;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchCustomerDetails;
import reporting.ListenerClass;
import utilities.ExcelUtilities;

//@Listeners(ListenerClass.class)
public class CAPSearchCustAffordabilityScripts extends BaseClass
{

	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustAffordabilityTC32(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustBusinessUnit ScustBU= new SearchCustBusinessUnit(getDriver());
		SearchCustAffordability ScustAff= new SearchCustAffordability(getDriver());
		Scustomer = Scustomer.Customer();
		
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "32", 1));	
		Scustomer = Scustomer.Search();
		ScustBU = ScustBU.custclick();
		ScustAff = ScustAff.Affortability();
		ScustAff = ScustAff.AmendButton();
		ScustAff = ScustAff.setWages(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "32", 2));
		ScustAff = ScustAff.SaveButton();
		
		
		if(ScustAff.CheckResultWages("Wages").equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "32",3)));
		//System.out.println("kkkkkk");
		setAssertMessage("User succesfully modified the current Affordability details.",1);
		Verify.verifyEquals(ScustAff.CheckResultWages("Wages"), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "32", 3));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}	
	
	}