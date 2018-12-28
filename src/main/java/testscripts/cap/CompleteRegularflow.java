
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

@Listeners(ListenerClass.class)
public class CompleteRegularflow extends BaseClass
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
	public void CCPSPLScreenTC72(String environment, String clientName) throws InterruptedException
	{
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "72", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		TC73value = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+TC73value);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "72", 2),"33");
		Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "72", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,2);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "72", 3));
		SPL.CCPLink();
		SPL.setcustomerID(TC73value);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "72", 4)))
		setAssertMessage("The Customer's Status is displayed as Approved on screen." ,1);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "72", 4));
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerDetails ScustDetail = new SearchCustomerDetails(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(TC73value);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "72", 4)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,2);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "72", 4));
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		CommonFunctions.roll("BM");
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods={"CCPSPLScreenTC72"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC73(String environment, String clientName) throws InterruptedException
	{
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "73", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		TC73value = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+TC73value);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "73", 2),"33");
		//Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "72", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,2);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "72", 3));
		//DBRoleValue ="AM";
		DBRoleValue ="AM";
		CommonFunctions.roll("AM");
		System.out.println("DBRoleValue in script"+DBRoleValue);
		
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"}, dependsOnMethods={"CCPSPLScreenTC73"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC74(String environment, String clientName) throws InterruptedException
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
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 1)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Pending approval Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 1));
		SPL.CCPLink();
		SPL.setcustomerID(TC73value);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 2)))
		setAssertMessage("The Customer's Status is displayed as Approved on SAles Potential screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 2));
		SPL.PALLink();
		SPL.setcustomerID(TC73value);
		SPL.SearchLink();
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 4));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 4)).equals("true"))
		setAssertMessage("Required Approval - AM is displayd Pending approval Screen." ,3);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 4)), "true");
		
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 6));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 6)).equals("true"))
		setAssertMessage("Required Approval - AM is displayd Pending approval Screen." ,4);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 6)), "true");
		
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(TC73value);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 6)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,5);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "74", 6));
		CommonFunctions.roll("BM");
		
		
	/*	SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerDetails ScustDetail = new SearchCustomerDetails(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(TC73value);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "72", 4)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,2);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "72", 4));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
*/
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods="CCPSPLScreenTC74")
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
		CommonFunctions.roll("RM");
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods="CCPSPLScreenTC77")
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC78(String environment, String clientName) throws InterruptedException
	{
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "78", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		TC73value = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+TC73value);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "78", 2),"33");
		//Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "78", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "78", 3));
		//DBRoleValue ="AM";
		DBRoleValue ="AM";
		CommonFunctions.roll("AM");
		System.out.println("DBRoleValue in script"+DBRoleValue);
		
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"}, dependsOnMethods={"CCPSPLScreenTC78"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC79(String environment, String clientName) throws InterruptedException
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
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "79", 1)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Pending approval Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "79", 1));
		DBRoleValue ="RM";
		CommonFunctions.roll("RM");
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"}, dependsOnMethods={"CCPSPLScreenTC79"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC80(String environment, String clientName) throws InterruptedException
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
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "80", 1)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Pending approval Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "80", 1));
		DBRoleValue ="DM";
		CommonFunctions.roll("DM");
		
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"}, dependsOnMethods={"CCPSPLScreenTC80"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC81(String environment, String clientName) throws InterruptedException
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
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 1)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Pending approval Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 1));
		SPL.CCPLink();
		SPL.setcustomerID(TC73value);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 2)))
		setAssertMessage("The Customer's Status is displayed as Approved on SAles Potential screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 2));
		SPL.PALLink();
		SPL.setcustomerID(TC73value);
		SPL.SearchLink();
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 4));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 4)).equals("true"))
		setAssertMessage("Required Approval - DM is displayd Pending approval Screen." ,3);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 4)), "true");
		
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 6));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 6)).equals("true"))
		setAssertMessage("Required Approval - DM is displayd Pending approval Screen." ,4);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 6)), "true");
		
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(TC73value);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 7)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,5);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "81", 7));
		CommonFunctions.roll("BM");
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods="CCPSPLScreenTC81")
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC82(String environment, String clientName) throws InterruptedException
	{
		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "82", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		TC73value = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+TC73value);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "82", 2),"33");
		Thread.sleep(2000);
//		SPL.Checkboxclick();
//		SPL.Acceptbutton();
//		SPL.Alert();
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(TC73value);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SearchCustomerDetails detail= new SearchCustomerDetails(getDriver());
		detail=detail.CustDetail();
		SPL.ExceptionscreenlinkDO();
		DBRoleValue ="AM";
		CommonFunctions.roll("AM");
		System.out.println("DBRoleValue in script"+DBRoleValue);
		
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"}, dependsOnMethods={"CCPSPLScreenTC82"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC83(String environment, String clientName) throws InterruptedException
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
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "83", 1)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Pending approval Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "83", 1));
		DBRoleValue ="RM";
		CommonFunctions.roll("RM");
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"}, dependsOnMethods={"CCPSPLScreenTC83"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC84(String environment, String clientName) throws InterruptedException
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
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "84", 1)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Pending approval Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "84", 1));
		DBRoleValue ="DM";
		CommonFunctions.roll("DM");
		
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"}, dependsOnMethods={"CCPSPLScreenTC84"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC85(String environment, String clientName) throws InterruptedException
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
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "85", 1)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Pending approval Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "85", 1));
		DBRoleValue ="DO";
		CommonFunctions.roll("DO");
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"}, dependsOnMethods={"CCPSPLScreenTC85"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC86(String environment, String clientName) throws InterruptedException
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
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 1)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Pending approval Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 1));
		SPL.CCPLink();
		SPL.setcustomerID(TC73value);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 2)))
		setAssertMessage("The Customer's Status is displayed as Approved on SAles Potential screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 2));
		SPL.PALLink();
		SPL.setcustomerID(TC73value);
		SPL.SearchLink();
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 4));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 4)).equals("true"))
		setAssertMessage("Required Approval - DO is displayd Pending approval Screen." ,3);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 4)), "true");
		
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 6));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 6)).equals("true"))
		setAssertMessage("Required Approval - DO is displayd Pending approval Screen." ,4);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 6)), "true");
		
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(TC73value);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 7)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,5);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "86", 7));
		DBRoleValue ="BM";
		CommonFunctions.roll("BM");
		
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods="CCPSPLScreenTC86")
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC87(String environment, String clientName) throws InterruptedException
	{

		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "87", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		TC73value = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+TC73value);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "87", 2),"33");
		//Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "87", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "87", 3));
		//DBRoleValue ="AM";
		DBRoleValue ="RM";
		CommonFunctions.roll("RM");
		System.out.println("DBRoleValue in script"+DBRoleValue);
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods={"CCPSPLScreenTC87"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC88(String environment, String clientName) throws InterruptedException
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
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "88", 1)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Pending approval Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "88", 1));
		DBRoleValue ="BM";
		CommonFunctions.roll("BM");
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods={"CCPSPLScreenTC88"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC89(String environment, String clientName) throws InterruptedException
	{

		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "89", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		TC73value = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+TC73value);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "89", 2),"33");
		//Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "89", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "89", 3));
		//DBRoleValue ="AM";
		DBRoleValue ="DM";
		CommonFunctions.roll("DM");
		System.out.println("DBRoleValue in script"+DBRoleValue);
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods={"CCPSPLScreenTC89"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC90(String environment, String clientName) throws InterruptedException
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
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "90", 1)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Pending approval Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "90", 1));
		DBRoleValue ="BM";
		CommonFunctions.roll("BM");
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods={"CCPSPLScreenTC90"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC91(String environment, String clientName) throws InterruptedException
	{

		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "91", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		TC73value = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+TC73value);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "91", 2),"33");
		//Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "91", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "91", 3));
		//DBRoleValue ="AM";
		DBRoleValue ="DO";
		CommonFunctions.roll("DO");
		System.out.println("DBRoleValue in script"+DBRoleValue);
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods={"CCPSPLScreenTC91"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC92(String environment, String clientName) throws InterruptedException
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
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 1)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Pending approval Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 1));
		SPL.CCPLink();
		SPL.setcustomerID(TC73value);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 2)))
		setAssertMessage("The Customer's Status is displayed as Approved on SAles Potential screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 2));
		SPL.PALLink();
		SPL.setcustomerID(TC73value);
		SPL.SearchLink();
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 4));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 4)).equals("true"))
		setAssertMessage("Required Approval - DO is displayd Pending approval Screen." ,3);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 4)), "true");
		
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 6));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 6)).equals("true"))
		setAssertMessage("Required Approval - DO is displayd Pending approval Screen." ,4);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 6)), "true");
		
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(TC73value);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 7)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,5);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "92", 7));
		DBRoleValue ="BM";
		CommonFunctions.roll("BM");
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods="CCPSPLScreenTC92")
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC93(String environment, String clientName) throws InterruptedException
	{

		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "93", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		TC73value = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+TC73value);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "93", 2),"33");
		//Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "93", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "93", 3));
		//DBRoleValue ="AM";
		DBRoleValue ="DM";
		CommonFunctions.roll("DM");
		System.out.println("DBRoleValue in script"+DBRoleValue);
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods={"CCPSPLScreenTC93"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC94(String environment, String clientName) throws InterruptedException
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
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "94", 1)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Pending approval Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "94", 1));
		DBRoleValue ="BM";
		CommonFunctions.roll("BM");
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods={"CCPSPLScreenTC94"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC95(String environment, String clientName) throws InterruptedException
	{

		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "95", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		TC73value = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+TC73value);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "95", 2),"33");
		//Thread.sleep(2000);
		SPL.Checkboxclick();
		SPL.Acceptbutton();
		SPL.Alert();
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "95", 3)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Sales Potential Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "95", 3));
		//DBRoleValue ="AM";
		DBRoleValue ="DO";
		CommonFunctions.roll("DO");
		System.out.println("DBRoleValue in script"+DBRoleValue);
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods={"CCPSPLScreenTC95"})
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC96(String environment, String clientName) throws InterruptedException
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
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 1)))
		setAssertMessage("System Displayed message '"+SStaff.Result()+"' on Pending approval Screen." ,1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 1));
		SPL.CCPLink();
		SPL.setcustomerID(TC73value);
		SPL.SearchLink();
		if(SPL.Status().equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 2)))
		setAssertMessage("The Customer's Status is displayed as Approved on SAles Potential screen." ,2);
		Verify.verifyEquals(SPL.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 2));
		SPL.PALLink();
		SPL.setcustomerID(TC73value);
		SPL.SearchLink();
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 4));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 4)).equals("true"))
		setAssertMessage("Required Approval - DO is displayd Pending approval Screen." ,3);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 3), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 4)), "true");
		
		//SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 6));
		if(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 6)).equals("true"))
		setAssertMessage("Required Approval - DO is displayd Pending approval Screen." ,4);
		Verify.verifyEquals(SPL.CheckApprovalONPAL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 5), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 6)), "true");
		
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(TC73value);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 7)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,5);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "96", 7));
		DBRoleValue ="BM";
		CommonFunctions.roll("BM");
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods="CCPSPLScreenTC96")
	@Parameters({ "environment", "clientName"})
	public void CCPSPLScreenTC97(String environment, String clientName) throws InterruptedException
	{

		CCPSPLScreen SPL = new CCPSPLScreen(getDriver());
		SPL.CCPLink();
		SPL.setSALESStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "97", 1));
		SPL.SearchLink();
		SPL.AmendLink();
		TC73value = SPL.IDTextdisplay();
		System.out.println("val>>>>>>>>>>>>"+TC73value);
		SPL.TermIconwindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "97", 2),"33");
		Thread.sleep(2000);
//		SPL.Checkboxclick();
//		SPL.Acceptbutton();
//		SPL.Alert();
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(TC73value);	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		SearchCustomerDetails detail= new SearchCustomerDetails(getDriver());
		detail=detail.CustDetail();
		SPL.ExceptionscreenlinkDO();
		DBRoleValue ="DO";
		CommonFunctions.roll("DO");
		System.out.println("DBRoleValue in script"+DBRoleValue);
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Credit Control Policy"},dependsOnMethods={"CCPSPLScreenTC97"})
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
		Scustomer = Scustomer.cusIDclick();
		SPL.Exceptionscreenlink();
		String Status =SPL.StatusInExceptnScreen;
		System.out.println(Status);
		if(Status.equalsIgnoreCase(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 7)))
		setAssertMessage("The Customer's Status is displayed as Approved on Exception pop-up screen." ,5);
		Verify.verifyEquals(Status, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "98", 7));
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