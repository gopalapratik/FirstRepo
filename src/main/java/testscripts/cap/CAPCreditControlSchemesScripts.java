
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
import pageobjects.cap.*;
import reporting.ListenerClass;
import utilities.*;

//@Listeners(ListenerClass.class)
public class CAPCreditControlSchemesScripts extends BaseClass
{
	//WebDriverWait wait1;
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Finance"})
	@Parameters({ "environment", "clientName" })
	public void CreditControlSchemesTC62(String environment, String clientName) throws InterruptedException
	{
		CreditControlSchemes CCS = new CreditControlSchemes(getDriver());
		CCS.FinanceLink();
		CCS.CCSchemesLink();
		if(CCS.HeaderDeatils().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "62", 1)))
		setAssertMessage("Credit Control Schemes displayed>>>>' Name,Description and Used by Business Stream ' ",1);
		Verify.verifyEquals(CCS.HeaderDeatils(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "62", 1));
		System.out.println("out ccs");
		
		if(CCS.DeleteText().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "62", 2)))
		setAssertMessage("Delete button is displayed on screen.",2);
		Verify.verifyEquals(CCS.DeleteText(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "62", 2));
		CCS.SchemeClick(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "62", 3));
		if(CCS.SchemeclickText().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "62", 4)))
		setAssertMessage("Schemes is displayed when clicked.",3);
		Verify.verifyEquals(CCS.SchemeclickText(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "62", 4));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
	}
	
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Finance"})
	@Parameters({ "environment", "clientName" })
	public void CreditControlSchemesTC63(String environment, String clientName) throws InterruptedException
	{
		Thread.sleep(5000);
		CreditControlSchemes CCS = new CreditControlSchemes(getDriver());
		SearchStaffPage Search = new SearchStaffPage(getDriver());
		CCS.FinanceLink();
		SetupSchemes setup = new SetupSchemes(getDriver());
		setup.SetupSchemesLink();
		setup.SetName();
		setup.SetExsCusmrBand1(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 1));
		setup.SetExsCusmrBand2(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 2));
		setup.SetExsCusmrBand3(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 3));
		setup.SetExsCusmrBand4(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 4));
		setup.SetMaxSAles1(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 5));
		setup.SetMaxSAles2(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 6));
		setup.SetMaxSAles3(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 7));
		setup.SetMaxSAles4(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 8));
		setup.SetMaxSAles5(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 9));
		setup.SetNewMAx(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 10));
		setup.SetMaxBal1(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 11));
		setup.SetMaxBal2(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 12));
		setup.SetMaxBal3(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 13));
		setup.SetMaxBal4(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 14));
		setup.SetMaxBal5(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 15));
		setup.SetNewMAxBAl(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 16));
		setup.SaveLink();
		if(CCS.message().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 17)))
		setAssertMessage("System displayed a meassage "+CCS.message(),1);
		//Verify.verifyEquals(CCS.message(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "63", 17));
		CCS.FinanceLink();
		CCS.CCSchemesLink();
		String data= setup.ScehemeName;
		CCS.ScehemeNameSelect(data);
		Thread.sleep(2000);
		CCS.DeleteLink();
		Thread.sleep(2000);
	//	CCS.Alert();
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
			
		
	}

	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Finance"})
	@Parameters({ "environment", "clientName" })
	public void CreditControlSchemesTC64(String environment, String clientName) throws InterruptedException
	{
		CreditControlSchemes CCS = new CreditControlSchemes(getDriver());
		SearchStaffPage Search = new SearchStaffPage(getDriver());
		CCS.FinanceLink();
		SetupSchemes setup = new SetupSchemes(getDriver());
		CCS.CCSchemesLink();
		CCS.SchemeClick(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "64", 1));
		CCS.AmendLink();
		CCS.AmendINcr();
		System.out.println("MAxrate>>"+CCS.MAxrate);
		setup.SaveLink();
		System.out.println(CCS.message());
		
		if(CCS.message().equals("Action completed successfully."))
		setAssertMessage("System displayed a message "+CCS.message(),1);
		Verify.verifyEquals(CCS.message(),"Action completed successfully.");
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
	
	}
}