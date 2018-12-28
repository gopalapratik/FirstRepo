
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
public class CAPCCPSPLScreen6Scripts extends BaseClass
{
	
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
	public void CCPSPLScreenTC97(String environment, String clientName) throws InterruptedException
	{

		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		Thread.sleep(3000);
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "97", 1));
		SPL.SearchLink();
		Thread.sleep(3000);
		SPL.AmendLink();
		Thread.sleep(3000);
		TC73value = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+TC73value);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "97", 2),"33");
		Thread.sleep(2000);
//		SPL.Checkboxclick();
//		SPL.Acceptbutton();
//		SPL.Alert();
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Thread.sleep(3000);
		Scustomer = Scustomer.setCID(TC73value);	
		Scustomer = Scustomer.Search();
		Thread.sleep(3000);
		Scustomer = Scustomer.cusIDclick();
		Thread.sleep(3000);
		SearchCustomerDetails detail= new SearchCustomerDetails(getDriver());
		detail=detail.CustDetail();
		Thread.sleep(3000);
		SPL.ExceptionscreenlinkDO();
		DBRoleValue ="DO";
		CommonFunctions.roll("DO");
		System.out.println("DBRoleValue in script"+DBRoleValue);
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods={"CCPSPLScreenTC97"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC98(String environment, String clientName) throws InterruptedException
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
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 1)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Pending approval Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 1));
		SPL.CCPLink();
		SPL.setcustomerID(TC73value);
		SPL.SearchLink();
		Thread.sleep(2000);
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 2)))
		setAssertMessage("The Customer's Status is displayed as Approved on SAles Potential screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 2));
		SPL.PALLink();
		SPL.setcustomerID(TC73value);
		SPL.SearchLink();
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 4));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 4)).equals("true"))
		setAssertMessage("Required Approval - DO is displayd Pending approval Screen." ,3);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 4)), "true");
		
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 6));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 6)).equals("true"))
		setAssertMessage("Required Approval - DO is displayd Pending approval Screen." ,4);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 6)), "true");
		
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(TC73value);	
		Scustomer = Scustomer.Search();
		Thread.sleep(3000);
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		Thread.sleep(3000);
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 7)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,5);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 7));
		
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