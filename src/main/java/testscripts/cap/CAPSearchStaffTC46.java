package testscripts.cap;

import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsersetup.BaseClass;
import pageobjects.cap.SearchStaffPage;
import pageobjects.cap.SetupStaff;
import utilities.ExcelUtilities;
import verify.Verify;

public class CAPSearchStaffTC46 extends BaseClass{
	@Test(enabled=false,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Staff"})
	@Parameters({ "environment", "clientName" })
	public void SearchStaffTC46(String environment, String clientName) throws InterruptedException, ParseException
	{
Thread.sleep(10000);
	SetupStaff setup = new SetupStaff(getDriver());
	SearchStaffPage SStaff = new SearchStaffPage(getDriver());
	setup.StaffLink();
	setup.SetupStaffLink();
	setup.setSalutation(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 1));
	setup.setFN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 2));
	setup.setSN();
	setup.setHN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 4));
	setup.setStrt(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 5));
	setup.setLoclty(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 6));	
	setup.settn(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 7));
	setup.setcntry(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 8));
	setup.setPC(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 9));
	setup.setHP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 10));
	setup.setMP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 11));
	setup.setSD();
	setup.setUsergrp(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 12));
	//getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	//getDriver().manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	Thread.sleep(21000);
	setup.setSType(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 13));
	Thread.sleep(2000);
	setup.setUN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 14));
	setup.setJobId(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 15));
	Thread.sleep(1000);
	setup.setpmt(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 16));
	setup.setAtmN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 17));
	setup.setAlimit(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 18));
	setup.setFL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 19));
	Thread.sleep(3000);
	setup.Savebutton();
	setup.AddSchmebutton();
	setup.Addwindow();
	setup.AddItem();
	setup.Savebutton();
	Thread.sleep(10000);
	SStaff = SStaff.BussUnit();
	SStaff = SStaff.AddUNIT();
	SStaff = SStaff.AddUnitDeletewindow();
	SStaff = SStaff.checkboxClick();
	SStaff = SStaff.Delete();
	if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 20)))
		setAssertMessage("System displays a message >>>>"+ SStaff.Result(),1);
	Verify.verifyEquals(SStaff.Result(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 20));
	Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	
	}
}
