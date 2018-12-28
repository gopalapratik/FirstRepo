package testscripts.cap;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsersetup.BaseClass;
import pageobjects.cap.CreditControlSchemes;
import pageobjects.cap.SearchStaffPage;
import pageobjects.cap.SetupSchemes;
import pageobjects.cap.ViewLeadsPage;
import utilities.ExcelUtilities;
import verify.Verify;

public class CAPCreditControlSchemesTC63Scripts extends BaseClass {
	
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void ViewLeadsTC37(String environment, String clientName) throws InterruptedException
	{
		Thread.sleep(1000);
		ViewLeadsPage Vlead = new ViewLeadsPage(getDriver());
		Vlead = Vlead.Customer();
		Vlead = Vlead.VeiwLead();
		Vlead =Vlead.setStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 1));
		//Change By Rajesh
		// Set First name
		Vlead =Vlead.setFname();
		// set surname
		Vlead =Vlead.setSname();
		Thread.sleep(2000);
		// Change by Rajesh
		Vlead = Vlead.Assigned(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 4));
		Vlead = Vlead.Search();
		if(Vlead.StatusResult().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 2)))
		setAssertMessage("Leads are displayed based on selected status >>>" +Vlead.StatusResult() ,1);
		Verify.verifyEquals(Vlead.StatusResult(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 2));

		//Change By Rajesh
		
		Vlead =Vlead.setStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 3));
		//Change By Rajesh according to Data visiblity
		Vlead=Vlead.ClrFname();
		Vlead=Vlead.CLRSname();
		Vlead = Vlead.Assigned(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 4));
		Vlead = Vlead.Search();
		if(Vlead.StatusResult().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 5)))
		setAssertMessage("Leads are displayed based on selected status >>>" +Vlead.StatusResult() ,2);
		Verify.verifyEquals(Vlead.StatusResult(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 5));
		
		Vlead =Vlead.setStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 6));
		//Change By Rajesh according to Data visiblity   
		// Set First name
				Vlead =Vlead.setFname();
				// set surname
				Vlead =Vlead.setSname();
				Vlead = Vlead.Assigned(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 4));
				// Change by Rajesh As The data is not available 
		//Vlead = Vlead.Assigned(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 7));
		Vlead = Vlead.Search();
		if(Vlead.StatusResult().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 8)))
		setAssertMessage("Leads are displayed based on selected status >>>" +Vlead.StatusResult() ,3);
		Verify.verifyEquals(Vlead.StatusResult(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 8));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
	
}
