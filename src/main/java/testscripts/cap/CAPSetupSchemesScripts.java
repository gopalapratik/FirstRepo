
package testscripts.cap;

import static org.testng.Assert.assertEquals;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
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
import pageobjects.cap.*;
import reporting.ListenerClass;
import utilities.*;

//@Listeners(ListenerClass.class)
public class CAPSetupSchemesScripts extends BaseClass
{
	
	@Test(enabled= true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Finance"})
	@Parameters({ "environment", "clientName" })
	public void SetupSchemesTC65(String environment, String clientName) throws InterruptedException
	{
		CreditControlSchemes CCS = new CreditControlSchemes(getDriver());
		SearchStaffPage Search = new SearchStaffPage(getDriver());
		CCS.FinanceLink();
		SetupSchemes setup = new SetupSchemes(getDriver());
		setup.SetupSchemesLink();
		setup.SetName();
		setup.SetExsCusmrBand1(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 1));
		setup.SetExsCusmrBand2(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 2));
		setup.SetExsCusmrBand3(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 3));
		setup.SetExsCusmrBand4(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 4));
		setup.SetMaxSAles1(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 5));
		setup.SetMaxSAles2(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 6));
		setup.SetMaxSAles3(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 7));
		setup.SetMaxSAles4(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 8));
		setup.SetMaxSAles5(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 9));
		setup.SetNewMAx(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 10));
		setup.SetMaxBal1(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 11));
		setup.SetMaxBal2(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 12));
		setup.SetMaxBal3(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 13));
		setup.SetMaxBal4(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 14));
		setup.SetMaxBal5(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 15));
		setup.SetNewMAxBAl(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 16));
		setup.SaveLink();
		System.out.println(CCS.message());
		if(CCS.message().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 17)))
		setAssertMessage("System displayed a meassage "+CCS.message(),1);
		Verify.verifyEquals(CCS.message(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "65", 17));
	
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
			
		
	}
	
}