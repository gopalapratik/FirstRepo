
package testscripts.cap;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import verify.Verify;

import browsersetup.BaseClass;
import pageobjects.cap.CustomerHistoryRefresh;
import pageobjects.cap.GooglePage;
import pageobjects.cap.GoogleSearch;
import pageobjects.cap.ProductPartnerList;
import pageobjects.cap.SearchBusinessUnit;
import pageobjects.cap.SearchStaffPage;
import pageobjects.cap.SetupBusinessUnit;
import pageobjects.cap.SetupProduct;
import pageobjects.cap.ViewLeadsPage;
import reporting.ListenerClass;
import utilities.*;

@Listeners(ListenerClass.class)
public class CAPSetupBusinessUnitScripts extends BaseClass
{
	//WebDriverWait wait1;
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Organisation"})
	@Parameters({ "environment", "clientName" })
	public void SetupBusinessUnitTC60(String environment, String clientName) throws InterruptedException
	{
		SearchBusinessUnit BU = new SearchBusinessUnit(getDriver());
		BU.OrgLink();
		SetupBusinessUnit BUSetup = new SetupBusinessUnit(getDriver());
		BUSetup.SetUpLink();
		BUSetup.setBUName();
		System.out.println(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "59", 1));
	
		BUSetup.setUnitID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "60", 1));
		BUSetup.setCntrCode(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "60", 2));
		BUSetup.setStartDate();
		BUSetup.setPunit(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "60",4));
		BUSetup.setCStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "60",5));
		
		BUSetup.setFlatNo(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "60",6));
		BUSetup.setHouseNO(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "60",7));
		BUSetup.setPostCode(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "60",8));
		SearchStaffPage staff =new SearchStaffPage(getDriver());
		
		
		BUSetup.SaveLink();
		
		Thread.sleep(5000);
		System.out.println(BUSetup.BUNAme);
		
		if(staff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "60", 9)))
		setAssertMessage("System displayed a message " +staff.Result(),1);
		Verify.verifyEquals(staff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "60", 9));
		if(BUSetup.ResUnitName().equals(BUSetup.BUNAme))
		setAssertMessage("Business Unit is created successfully",1);
		Verify.verifyEquals(BUSetup.ResUnitName(), BUSetup.BUNAme);
			
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
		
		
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Organisation"})
	@Parameters({ "environment", "clientName" })
	public void SetupBusinessUnitTC61(String environment, String clientName) throws InterruptedException
	{
		SearchBusinessUnit BU = new SearchBusinessUnit(getDriver());
		BU.OrgLink();
		SetupBusinessUnit BUSetup = new SetupBusinessUnit(getDriver());
		BUSetup.SetUpLink();
		BUSetup.setBUName1();
		//System.out.println(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "59", 1));
	
		BUSetup.setUnitID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "61", 1));
		BUSetup.setCntrCode(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "61", 2));
		BUSetup.setStartDate();
		BUSetup.setPunit(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "61",4));
		BUSetup.setCStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "61",5));
		
		BUSetup.setFlatNo(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "61",6));
		BUSetup.setHouseNO(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "61",7));
		BUSetup.setPostCode(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "61",8));
		SearchStaffPage staff =new SearchStaffPage(getDriver());
		
		
		BUSetup.SaveLink();
		BUSetup.AmendLink();
		BUSetup.SwitchWindow();
		BUSetup.SaveLink();
		if(staff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "61", 9)))
		setAssertMessage("System displayed a message " +staff.Result(),1);
		Verify.verifyEquals(staff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "61", 9));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
		
		
	}
}
