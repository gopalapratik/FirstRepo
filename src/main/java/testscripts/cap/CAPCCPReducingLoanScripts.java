
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
public class CAPCCPReducingLoanScripts extends BaseClass
{
	
	public static String CustIDvalue;
	@BeforeTest(groups = { "Regression","CAP","Credit Control Policy"})
	@Parameters({ "environment", "clientName"})
	public void Beforetest(String environment, String clientName) throws InterruptedException
	{
		//CommonFunctions.roll(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 1));
		System.out.println("in before test");
		CommonFunctions.roll("BM");
		//Thread.sleep(10000);
	}
	
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"})
	@Parameters({ "environment", "clientName"})
	public void CCPReducingLoanTC104(String environment, String clientName) throws InterruptedException
	{
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "104", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		CustIDvalue = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+CustIDvalue);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "104", 2),"33");
		Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "104", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "104", 3));
		SPL.CCPLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "104", 4)))
		setAssertMessage("The Customer's Status is displayed as Approved on Sales Potential Screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "104", 4));
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerDetails ScustDetail = new SearchCustomerDetails(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(CustIDvalue);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "104", 4)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,3);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "104", 4));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		CommonFunctions.roll("RM");
		DBRoleValue ="RM";
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods="CCPReducingLoanTC104")
	@Parameters({ "environment", "clientName"})
	public void CCPReducingLoanTC105(String environment, String clientName) throws InterruptedException
	{
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "105", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		CustIDvalue = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+CustIDvalue);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "105", 2),"33");
		Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "105", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "105", 3));
		SPL.CCPLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "105", 4)))
		setAssertMessage("The Customer's Status is displayed as Approved on Sales Potential Screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "105", 4));
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerDetails ScustDetail = new SearchCustomerDetails(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(CustIDvalue);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "105", 4)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,3);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "105", 4));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		DBRoleValue ="BM";
		CommonFunctions.roll("BM");
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods="CCPReducingLoanTC105")
	@Parameters({ "environment", "clientName"})
	public void CCPReducingLoanTC106(String environment, String clientName) throws InterruptedException
	{
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "106", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		CustIDvalue = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+CustIDvalue);
		SPL.TermIconwindowProduct("true","20");
		Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "106", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "106", 3));
		SPL.CCPLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "106", 4)))
		setAssertMessage("The Customer's Status is displayed as Approved on Sales Potential Screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "106", 4));
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerDetails ScustDetail = new SearchCustomerDetails(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(CustIDvalue);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "106", 4)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,3);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "106", 4));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		DBRoleValue ="RM";
		CommonFunctions.roll("RM");
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods="CCPReducingLoanTC106")
	@Parameters({ "environment", "clientName"})
	public void CCPReducingLoanTC107(String environment, String clientName) throws InterruptedException
	{
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "107", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		CustIDvalue = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+CustIDvalue);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "107", 2),"20");
		Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "107", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "107", 3));
		SPL.CCPLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "107", 4)))
		setAssertMessage("The Customer's Status is displayed as Approved on Sales Potential Screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "107", 4));
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerDetails ScustDetail = new SearchCustomerDetails(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(CustIDvalue);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "107", 4)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,3);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "107", 4));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		DBRoleValue ="BM";
		CommonFunctions.roll("BM");
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods="CCPReducingLoanTC107")
	@Parameters({ "environment", "clientName"})
	public void CCPReducingLoanTC108(String environment, String clientName) throws InterruptedException
	{
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "108", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		CustIDvalue = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+CustIDvalue);
		SPL.TermIconwindowProduct(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "108", 2),"20");
		//SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "108", 2),"20");
		Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "108", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "108", 3));
		SPL.CCPLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "108", 4)))
		setAssertMessage("The Customer's Status is displayed as Approved on Sales Potential Screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "108", 4));
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerDetails ScustDetail = new SearchCustomerDetails(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(CustIDvalue);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "108", 4)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,3);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "108", 4));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		DBRoleValue ="RM";
		CommonFunctions.roll("RM");
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods="CCPReducingLoanTC108")
	@Parameters({ "environment", "clientName"})
	public void CCPReducingLoanTC109(String environment, String clientName) throws InterruptedException
	{
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "109", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		CustIDvalue = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+CustIDvalue);
		SPL.TermIconwindowProduct(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "109", 2),"20");
		//SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "109", 2),"20");
		Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "109", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "109", 3));
		SPL.CCPLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "109", 4)))
		setAssertMessage("The Customer's Status is displayed as Approved on Sales Potential Screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "109", 4));
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerDetails ScustDetail = new SearchCustomerDetails(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(CustIDvalue);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "109", 4)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,3);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "109", 4));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		DBRoleValue ="BM";
		CommonFunctions.roll("BM");
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

