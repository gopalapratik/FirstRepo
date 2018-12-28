
package testscripts.cap;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
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

@Listeners(ListenerClass.class)
public class CAPCCPTempRoleScripts extends BaseClass
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
/*	@BeforeMethod(groups = { "Regression","CAP","Credit Control Policy"})
	@Parameters({ "environment", "clientName"})
	public void Beforemethod(String environment, String clientName) throws InterruptedException
	{
		System.out.println("in Before Method");
		if(!DBRoleValue.equals(null))
		{
			CommonFunctions.roll(DBRoleValue);
			
		}
		//Thread.sleep(10000);
	}*/
	
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"})
	@Parameters({ "environment", "clientName"})
	public void CCPTempRoleTC99(String environment, String clientName) throws InterruptedException
	{
		
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		CustIDvalue = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+CustIDvalue);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 2),"33");
		Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 3));
		SPL.CCPLink();
		CCPTempRole temp = new CCPTempRole(getDriver());
		temp.TempRoleLink();
		temp.setStaffID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 4));
		temp.SearchButton();
		temp.StaffIDclick(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 4));
		temp.Roleassigned("AM");
		SPL.PALLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		System.out.println("in temp");
		//temp.checkbox("14.00");
		SPL.Checkboxclick();
		SPL.PALAcceptbutton();
		SPL.Alert();
		SPL.CCPLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 5)))
		setAssertMessage("The Customer's Status is displayed as Approved on SAles Potential screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 5));
		
		//CustIDvalue="17778804";
		SPL.PALLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 4));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 6), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99",7)).equals("true"))
		setAssertMessage("Required Approval - AM is displayd Pending approval Screen." ,3);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 6), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 7)), "true");
		
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 6));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 8), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 9)).equals("true"))
		setAssertMessage("Required Approval - AM is displayd Pending approval Screen." ,4);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 8), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 9)), "true");
		
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(CustIDvalue);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 10)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,5);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 10));
		DBRoleValue ="AM";
		CommonFunctions.roll("AM");
		
		
		
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods="CCPTempRoleTC99")
	@Parameters({ "environment", "clientName"})
	public void CCPTempRoleTC100(String environment, String clientName) throws InterruptedException
	{
	
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		/*SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		CustIDvalue = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+CustIDvalue);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 2),"33");
		Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 3));
		SPL.CCPLink();
		CCPTempRole temp = new CCPTempRole(getDriver());
		temp.TempRoleLink();
		temp.setStaffID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 4));
		temp.SearchButton();
		temp.StaffIDclick(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 4));
		temp.Roleassigned("RM");
		SPL.PALLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		System.out.println("in temp");
		//temp.checkbox("14.00");
		SPL.Checkboxclick();
		SPL.PALAcceptbutton();
		SPL.Alert();
		SPL.CCPLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 5)))
		setAssertMessage("The Customer's Status is displayed as Approved on SAles Potential screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 5));
		
		//CustIDvalue="17778804";
		SPL.PALLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 4));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 6), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100",7)).equals("true"))
		setAssertMessage("Required Approval - RM is displayd Pending approval Screen." ,3);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 6), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 7)), "true");
		
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 6));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 8), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 9)).equals("true"))
		setAssertMessage("Required Approval - RM is displayd Pending approval Screen." ,4);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 8), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 9)), "true");
		
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(CustIDvalue);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 10)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,5);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "100", 10));*/
		CommonFunctions.roll("RM");
		DBRoleValue ="RM";	
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods="CCPTempRoleTC100")
	@Parameters({ "environment", "clientName"})
	public void CCPTempRoleTC101(String environment, String clientName) throws InterruptedException
	{
	
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		CustIDvalue = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+CustIDvalue);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 2),"33");
		Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 3));
		SPL.CCPLink();
		CCPTempRole temp = new CCPTempRole(getDriver());
		temp.TempRoleLink();
		temp.setStaffID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 4));
		temp.SearchButton();
		temp.StaffIDclick(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 4));
		temp.Roleassigned("DM");
		SPL.PALLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		System.out.println("in temp");
		//temp.checkbox("14.00");
		SPL.Checkboxclick();
		SPL.PALAcceptbutton();
		SPL.Alert();
		SPL.CCPLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 5)))
		setAssertMessage("The Customer's Status is displayed as Approved on SAles Potential screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 5));
		
		//CustIDvalue="17778804";
		SPL.PALLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 4));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 6), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101",7)).equals("true"))
		setAssertMessage("Required Approval - DM is displayd Pending approval Screen." ,3);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 6), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 7)), "true");
		
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 6));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 8), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 9)).equals("true"))
		setAssertMessage("Required Approval - DM is displayd Pending approval Screen." ,4);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 8), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 9)), "true");
		
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(CustIDvalue);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 10)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,5);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "101", 10));
		CommonFunctions.roll("RM");
		DBRoleValue ="RM";	
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods="CCPTempRoleTC101")
	@Parameters({ "environment", "clientName"})
	public void CCPTempRoleTC102(String environment, String clientName) throws InterruptedException
	{
	
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		/*SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		CustIDvalue = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+CustIDvalue);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102", 2),"33");
		Thread.sleep(2000);
//		SPL.Checkboxclick();
//		SPL.Acceptbutton();
//		SPL.Alert();
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(CustIDvalue);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SearchCustomerDetails detail= new SearchCustomerDetails(getDriver());
		detail=detail.CustDetail();
		SPL.ExceptionscreenlinkDO();
		SPL.CCPLink();
		CCPTempRole temp = new CCPTempRole(getDriver());
		temp.TempRoleLink();
		temp.setStaffID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102", 4));
		temp.SearchButton();
		temp.StaffIDclick(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102", 4));
		temp.Roleassigned("DO");
		SPL.PALLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		System.out.println("in temp");
		//temp.checkbox("14.00");
		SPL.Checkboxclick();
		SPL.PALAcceptbutton();
		SPL.Alert();
		SPL.CCPLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102", 5)))
		setAssertMessage("The Customer's Status is displayed as Approved on SAles Potential screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102", 5));
		
		//CustIDvalue="17778804";
		SPL.PALLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 4));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102", 6), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102",7)).equals("true"))
		setAssertMessage("Required Approval - DO is displayd Pending approval Screen." ,3);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102", 6), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102", 7)), "true");
		
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102", 6));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102", 8), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102", 9)).equals("true"))
		setAssertMessage("Required Approval - DO is displayd Pending approval Screen." ,4);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102", 8), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102", 9)), "true");
		
		//SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(CustIDvalue);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102", 10)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,5);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "102", 10));*/
		CommonFunctions.roll("DM");
		DBRoleValue ="DM";	
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods="CCPTempRoleTC102")
	@Parameters({ "environment", "clientName"})
	public void CCPTempRoleTC103(String environment, String clientName) throws InterruptedException
	{
	
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		/*SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		CustIDvalue = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+CustIDvalue);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103", 2),"33");
		Thread.sleep(2000);
//		SPL.Checkboxclick();
//		SPL.Acceptbutton();
//		SPL.Alert();
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(CustIDvalue);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SearchCustomerDetails detail= new SearchCustomerDetails(getDriver());
		detail=detail.CustDetail();
		SPL.ExceptionscreenlinkDO();
		SPL.CCPLink();
		CCPTempRole temp = new CCPTempRole(getDriver());
		temp.TempRoleLink();
		temp.setStaffID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103", 4));
		temp.SearchButton();
		temp.StaffIDclick(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103", 4));
		temp.Roleassigned("DO");
		SPL.PALLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		System.out.println("in temp");
		//temp.checkbox("14.00");
		SPL.Checkboxclick();
		SPL.PALAcceptbutton();
		SPL.Alert();
		SPL.CCPLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103", 5)))
		setAssertMessage("The Customer's Status is displayed as Approved on SAles Potential screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103", 5));
		
		//CustIDvalue="17778804";
		SPL.PALLink();
		SPL.setcustomerID(CustIDvalue);
		SPL.SearchLink();
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 4));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103", 6), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103",7)).equals("true"))
		setAssertMessage("Required Approval - DO is displayd Pending approval Screen." ,3);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103", 6), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103", 7)), "true");
		
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103", 6));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103", 8), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103", 9)).equals("true"))
		setAssertMessage("Required Approval - DO is displayd Pending approval Screen." ,4);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103", 8), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103", 9)), "true");
		
		//SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(CustIDvalue);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103", 10)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,5);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "103", 10));*/
		
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
