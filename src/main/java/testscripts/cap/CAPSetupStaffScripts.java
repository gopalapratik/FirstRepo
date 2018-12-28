
package testscripts.cap;

import static org.testng.Assert.assertEquals;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import browsersetup.BaseClass;
//import reporting.ListenerClass;
import pageobjects.*;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchCustomerDetails;
import pageobjects.cap.SearchCustomerLetterEvent;
import pageobjects.cap.SetupStaff;
import reporting.ListenerClass;
import utilities.ExcelUtilities;
import verify.Verify;
@Listeners(ListenerClass.class)
public class CAPSetupStaffScripts extends BaseClass {
// Data Issue 
	WebDriverWait wait;
	@Test(enabled= true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Staff"})
	@Parameters({ "environment", "clientName" })
	public void SetupStaffTC41(String environment, String clientName) throws InterruptedException, ParseException
	{
		SetupStaff setup = new SetupStaff(getDriver());
		setup.StaffLink();
		setup.SetupStaffLink();
		setup.setSalutation(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 1));
		setup.setFN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 2));
		setup.setSN();
		setup.setHN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 4));
		setup.setStrt(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 5));
		setup.setLoclty(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 6));	
		setup.settn(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 7));
		setup.setcntry(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 8));
		setup.setPC(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 9));
		setup.setHP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 10));
		setup.setMP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 11));
		setup.setSD();
		setup.FinishDate();
		setup.setUsergrp(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 12));
		//getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		//getDriver().manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		Thread.sleep(10000);
		setup.setSType(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 13));
		Thread.sleep(2000);
		setup.setUN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 14));
		
		
		setup.setJobId(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 15));
		Thread.sleep(1000);
		setup.setpmt(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 16));
		setup.setAtmN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 17));
		setup.setAlimit(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 18));
		setup.setFL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 19));
		Thread.sleep(3000);
		setup.Savebutton();
		
		
		//****************** As Per the Discussion with Gagan  We are skipping the ADD commission scheme item*****************
		/*
		setup.AddSchmebutton();
		setup.Addwindow();
		Thread.sleep(10000);
		Thread.sleep(10000);
		Thread.sleep(10000);
		setup.AddItem();
		setup.Savebutton();
		Thread.sleep(10000);
		if(setup.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 20)))
			setAssertMessage("System displayed a message "+setup.Result(),2);
		Verify.verifyEquals(setup.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "41", 20));
		*/
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		
	}
}
	