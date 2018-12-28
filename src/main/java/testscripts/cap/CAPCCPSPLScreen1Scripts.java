
package testscripts.cap;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import verify.Verify;

import browsersetup.BaseClass;
import helpers.CommonFunctions;
import pageobjects.cap.*;
import reporting.ListenerClass;
import utilities.*;

//@Listeners(ListenerClass.class)
public class CAPCCPSPLScreen1Scripts extends BaseClass
{
	
	//TC77 is getting failed *******************************commented by Rajesh
	
	public static String TC73value;
	
	@BeforeTest(groups = { "Regression","CAP","Credit Control Policy"})
	@Parameters({ "environment", "clientName"})
	public void Beforetest(String environment, String clientName) throws InterruptedException
	{
		//CommonFunctions.roll(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 1));
		System.out.println("in before test");
		CommonFunctions.roll("BM");
		//Thread.sleep(10000);
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC75(String environment, String clientName) throws InterruptedException
	{
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "75", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		TC73value = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+TC73value);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "75", 2),"33");
		//Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "75", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "75", 3));
		//DBRoleValue ="AM";
		DBRoleValue ="AM";
		CommonFunctions.roll("AM");
		System.out.println("DBRoleValue in script"+DBRoleValue);
		
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"}, dependsOnMethods={"CCPSPLScreenTC75"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC76(String environment, String clientName) throws InterruptedException
	{
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.PALLink();
		SPL.setcustomerID(TC73value);
		SPL.SearchLink();
		SPL.Checkboxclick();
		SPL.PALAcceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "76", 1)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Pending approval Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "76", 1));
		DBRoleValue ="RM";
		CommonFunctions.roll("RM");
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"}, dependsOnMethods={"CCPSPLScreenTC76"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC77(String environment, String clientName) throws InterruptedException
	{
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.PALLink();
		SPL.setcustomerID(TC73value);
		SPL.SearchLink();
		SPL.Checkboxclick();
		SPL.PALAcceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 1)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Pending approval Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 1));
		SPL.CCPLink();
		SPL.setcustomerID(TC73value);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 2)))
		setAssertMessage("The Customer's Status is displayed as Approved on SAles Potential screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 2));
		SPL.PALLink();
		SPL.setcustomerID(TC73value);
		SPL.SearchLink();
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 4));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 4)).equals("true"))
		setAssertMessage("Required Approval - RM is displayd Pending approval Screen." ,3);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 4)), "true");
		
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 6));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 6)).equals("true"))
		setAssertMessage("Required Approval - RM is displayd Pending approval Screen." ,4);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 6)), "true");
		
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(TC73value);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 7)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,5);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "77", 7));
	
		
	}
	@AfterMethod(groups = { "Regression","CAP","Credit Control Policy"})
	@Parameters({ "environment", "clientName"})
	public void Rollbackdate(String environment, String clientName) throws InterruptedException
	{
		CommonFunctions.roll(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 1));
		System.out.println("in @AfterMethod");
		CommonFunctions.roll("DateRollBack");
		//Thread.sleep(10000);
	}
}