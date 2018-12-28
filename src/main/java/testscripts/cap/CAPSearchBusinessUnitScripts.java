
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
import pageobjects.cap.SetupProduct;
import pageobjects.cap.ViewLeadsPage;
import reporting.ListenerClass;
import utilities.*;

@Listeners(ListenerClass.class)
public class CAPSearchBusinessUnitScripts extends BaseClass
{
	//WebDriverWait wait1;
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Organisation"})
	@Parameters({ "environment", "clientName" })
	public void SearchBusinessUnitTC58(String environment, String clientName) throws InterruptedException
	{
		SearchBusinessUnit BU = new SearchBusinessUnit(getDriver());
		BU.OrgLink();
		BU.SearchBULink();
		BU.UnitType(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "58", 1));
		BU.UnitName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "58", 2));
		Thread.sleep(1000);
		BU.BUStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "58", 3));
		BU.PBusunit(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "58", 4));
		BU.StaffID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "58", 5));
		BU.StaffName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "58", 6));
		BU.SearchLink();
		BU.BUSearchClick(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "58",7));
		if(BU.HeaderDetails().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "58", 8)))
			setAssertMessage("business unit is displayed",1);
			Verify.verifyEquals(BU.HeaderDetails(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "58", 8));
		if(BU.ResUnitName().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "58", 2)))
			setAssertMessage("Unit Name is displayed properly",2);
			Verify.verifyEquals(BU.ResUnitName(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "58", 2));
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
		
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Organisation"})
	@Parameters({ "environment", "clientName" })
	public void SearchBusinessUnitTC59(String environment, String clientName) throws InterruptedException
	{
		SearchBusinessUnit BU = new SearchBusinessUnit(getDriver());
		BU.OrgLink();
		BU.SearchBULink();
		BU.UnitType(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "59", 1));
		BU.UnitName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "59", 2));
		Thread.sleep(1000);
		BU.BUStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "59", 3));
		BU.PBusunit(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "59", 4));
		BU.StaffID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "59", 5));
		BU.StaffName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "59", 6));
		BU.ClearSearchLink();
		
		if(BU.UnitTypeClear().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "59", 7)))
			setAssertMessage("Clear search button functionality is working properly",1);
			Verify.verifyEquals(BU.UnitTypeClear(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Organisation", "59", 7));
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
		
		
	}
}