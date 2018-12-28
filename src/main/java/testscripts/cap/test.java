
package testscripts.cap;


import static org.testng.Assert.assertEquals;

import java.sql.BatchUpdateException;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import browsersetup.BaseClass;
import pageobjects.cap.GoogleSearch;
import pageobjects.cap.SearchCustAffordability;
import pageobjects.cap.SearchCustBusinessUnit;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchCustomerTransaction;
import pageobjects.cap.SearchStaffPage;
import pageobjects.cap.SetupStaff;
import reporting.ListenerClass;
import utilities.ExcelUtilities;
import verify.Verify;

@Listeners(ListenerClass.class)
public class test extends BaseClass
{
	public String FloatLimitS;
	WebDriverWait wait;
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Staff"})
	@Parameters({ "environment", "clientName" })
	public void testTC49(String environment, String clientName) throws InterruptedException
	{
	//	WebDriverWait wait= new WebDriverWait(getDriver(), 200);
		
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		SStaff = SStaff.Staff();
		SStaff = SStaff.SearchStaff();
		//SStaff = SStaff.FirstName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "49", 1));
		//SStaff = SStaff.LastName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "49", 1));
		SStaff = SStaff.FirstName("paul");
		SStaff = SStaff.LastName("Allen");

		SStaff = SStaff.Search();
		Thread.sleep(2000);
		SStaff = SStaff.StaffLink();
		
		SStaff = SStaff.CashReconClick();
		
		Thread.sleep(2000);
		if(SStaff.CheckResult("Total ATM Withdrawals").equals("2,000.00"))
			setAssertMessage("ATM Withdrawals done in MAP reflected in CAP ",1);
		Verify.verifyEquals(SStaff.CheckResult("Total ATM Withdrawals"),"2,000.00");
		
	
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Staff"})
	@Parameters({ "environment", "clientName" })
	public void testTC50(String environment, String clientName) throws InterruptedException
	{
	//	WebDriverWait wait= new WebDriverWait(getDriver(), 200);
		
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustBusinessUnit ScustBU= new SearchCustBusinessUnit(getDriver());
		SearchCustAffordability ScustAff= new SearchCustAffordability(getDriver());
		Scustomer = Scustomer.Customer();
		String Name=ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 4);
		String[] split=Name.split(" ");
		Scustomer = Scustomer.setFN(split[0]);	
		Scustomer = Scustomer.setSN(split[1]);	

		Scustomer = Scustomer.Search();
		ScustAff = ScustAff.custclick();
		ScustAff = ScustAff.Affortability();
		ScustAff.CheckResultWages("Wages");
		ScustAff.CheckResultrent("Rent");
		double Wages= Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 5));
		double Rent= Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 8));
		DecimalFormat df = new DecimalFormat("#.00");
		
		if(ScustAff.CheckResultWages("Wages").equals(String.valueOf(df.format(Wages))))
			setAssertMessage("Wages value entered in MAP reflected in CAP is "+ScustAff.CheckResultWages("Wages"),1);
		Verify.verifyEquals(ScustAff.CheckResultWages("Wages"),String.valueOf(df.format(Wages)));
	
		if(ScustAff.CheckResultWages("Document").equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 6)))
			setAssertMessage("Document value entered in MAP reflected in CAP is "+ScustAff.CheckResultWages("Document"),1);
		Verify.verifyEquals(ScustAff.CheckResultWages("Document"),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 6));
		
		if(ScustAff.CheckResultWages("Ref").equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 7)))
			setAssertMessage("Ref value entered done in MAP reflected in CAP is "+ScustAff.CheckResultWages("Ref"),1);
		Verify.verifyEquals(ScustAff.CheckResultWages("Ref"),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 7));
		
		if(ScustAff.CheckResultrent("Rent").equals(String.valueOf(df.format(Rent))))
			setAssertMessage("Rent value entered in MAP reflected in CAP is "+ScustAff.CheckResultrent("Rent"),1);
		Verify.verifyEquals(ScustAff.CheckResultrent("Rent"),String.valueOf(df.format(Rent)));
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
}