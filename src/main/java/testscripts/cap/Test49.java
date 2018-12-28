package testscripts.cap;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsersetup.BaseClass;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchStaffPage;
import utilities.ExcelUtilities;
import verify.Verify;

public class Test49 extends BaseClass{
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Staff"})
	@Parameters({ "environment", "clientName" })
	public void SearchStaffTC49(String environment, String clientName) throws InterruptedException
	{
	//	WebDriverWait wait= new WebDriverWait(getDriver(), 200);
		
		
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		SStaff = SStaff.Staff();
		SStaff = SStaff.SearchStaff();
		SStaff = SStaff.Staffid(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "49", 1));
		SStaff = SStaff.Search();
		Thread.sleep(2000);
		SStaff = SStaff.StaffLink();
		//
		//System.out.println("out waittttttttttttt");
		SStaff = SStaff.CashReconClick();
		
		Thread.sleep(2000);
		if(SStaff.FloatCash().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "49", 2)))
			setAssertMessage("Opening Float shows balance same as Closing Float Cash.",3);
		Verify.verifyEquals(SStaff.FloatCash(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "49", 2));
		if(SStaff.FloatCheque().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "49", 3)))
			setAssertMessage("Opening Float Cash and Cheque show the balance as Zero",4);
		Verify.verifyEquals(SStaff.FloatCheque(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "49",3));
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	
	}

}
