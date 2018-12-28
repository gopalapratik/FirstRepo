package testscripts.cap;


import static org.testng.Assert.assertEquals;

import java.sql.BatchUpdateException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import browsersetup.BaseClass;
import pageobjects.cap.GoogleSearch;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchCustomerTransaction;
import pageobjects.cap.SearchStaffPage;
import pageobjects.cap.SetupStaff;
import reporting.ListenerClass;
import utilities.ExcelUtilities;
import verify.Verify;

@Listeners(ListenerClass.class)
public class CAPSearchStaffScripts extends BaseClass
{
	public String FloatLimitS;
	WebDriverWait wait;
	@Test(enabled=false,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Staff"})
	@Parameters({ "environment", "clientName" })
	public void SearchStaff(String environment, String clientName) throws InterruptedException
	{
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		SStaff = SStaff.Staff();
		if(SStaff.staffID().equals("Staff ID"))
			setAssertMessage("1 By default Search Staff page is displayed",1);
		SStaff = SStaff.SearchStaff();
		SStaff = SStaff.FirstName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "4", 1));
		SStaff = SStaff.LastName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "4", 2));
		SStaff = SStaff.Status(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "4", 3));
		SStaff = SStaff.Search();
		Thread.sleep(3000);
		
		assertEquals(SStaff.Result(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "4", 4));
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "4", 4)))
			setAssertMessage("2 staff details are displayed properly",2);
		
		//Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "4", 4));
		
	}
	
	@Test(enabled=false,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Staff"})
	@Parameters({ "environment", "clientName" })
	public void SearchStaffTC42(String environment, String clientName) throws InterruptedException
	{
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		SStaff = SStaff.Staff();
		if(SStaff.staffID().equals("Staff ID"))
			setAssertMessage("1 By default Search Staff page is displayed",1);
		SStaff = SStaff.SearchStaff();
		SStaff = SStaff.Staffid(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "42", 1));
		SStaff = SStaff.FirstName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "42", 2));
		SStaff = SStaff.LastName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "42", 3));
		SStaff = SStaff.Search();
		Thread.sleep(3000);
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "42", 4)))
			setAssertMessage("Staff displayed properly",2);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "42", 4));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		//Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "4", 4));
		
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Staff"})
	@Parameters({ "environment", "clientName" })
	public void SearchStaffTC43(String environment, String clientName) throws InterruptedException
	{
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		SStaff = SStaff.Staff();
		SStaff = SStaff.SearchStaff();
		SStaff = SStaff.Staffid(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "43", 1));
		SStaff = SStaff.Search();
		Thread.sleep(2000);
		SStaff = SStaff.StaffLink();
		SStaff = SStaff.AmendstaffButton();
		SStaff = SStaff.Amendstaff();
		SStaff = SStaff.SavestaffButton();
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "43", 2)))
			setAssertMessage("System Displayed message >>>>>>"+SStaff.Result(),1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "43", 2));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		//Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "4", 4));
		
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Staff"})
	@Parameters({ "environment", "clientName" })
	public void SearchStaffTC44(String environment, String clientName) throws InterruptedException
	{
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		SStaff = SStaff.Staff();
		SStaff = SStaff.SearchStaff();
		SStaff = SStaff.Staffid(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "44", 1));
		SStaff = SStaff.Search();
		Thread.sleep(2000);
		SStaff = SStaff.StaffLink();
		SStaff = SStaff.BussUnit();
		SStaff = SStaff.Check();
		SStaff = SStaff.AmendUNIT();
		SStaff = SStaff.Addwindow();
		if(SStaff.BUDate1().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "44", 2)))
			setAssertMessage("Changes Reflected Succesfully",1);
		Verify.verifyEquals(SStaff.BUDate1(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "44", 2));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Staff"})
	@Parameters({ "environment", "clientName" })
	public void SearchStaffTC45(String environment, String clientName) throws InterruptedException
	{
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		SStaff = SStaff.Staff();
		SStaff = SStaff.SearchStaff();
		SStaff = SStaff.Staffid(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "45", 1));
		SStaff = SStaff.Search();
		Thread.sleep(2000);
		SStaff = SStaff.StaffLink();
		SStaff = SStaff.BussUnit();
		//SStaff = SStaff.Check();
		SStaff = SStaff.AddUNIT();
		SStaff = SStaff.AddwindowUnit();
		if(SStaff.ResultAddUNIT().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "45", 2)))
			setAssertMessage("Unit Added Succesfully",1);
		Verify.verifyEquals(SStaff.ResultAddUNIT(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "45", 2));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
	// Time Frame While Selecting Agent*********************************************unable to add the Commission scheme . As Per the Discussion with Gagan We are Skipping the This Test Case 
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Staff"})
	@Parameters({ "environment", "clientName" })
	public void SearchStaffTC46(String environment, String clientName) throws InterruptedException, ParseException
	{
Thread.sleep(1000);
	SetupStaff setup = new SetupStaff(getDriver());
	SearchStaffPage SStaff = new SearchStaffPage(getDriver());
	setup.StaffLink();
	setup.SetupStaffLink();
	setup.setSalutation(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 1));
	setup.setFN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 2));
	setup.setSN();
	setup.setHN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 4));
	setup.setStrt(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 5));
	setup.setLoclty(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 6));	
	setup.settn(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 7));
	setup.setcntry(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 8));
	setup.setPC(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 9));
	setup.setHP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 10));
	setup.setMP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 11));
	setup.setSD();
	setup.setUsergrp(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 12));
	//getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	//getDriver().manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	Thread.sleep(2000);
	setup.setSType(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 13));
	Thread.sleep(2000);
	setup.setUN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 14));
	setup.setJobId(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 15));
	Thread.sleep(1000);
	setup.setpmt(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 16));
	setup.setAtmN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 17));
	setup.setAlimit(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 18));
	setup.setFL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 19));
	Thread.sleep(3000);
	setup.Savebutton();
	//-----------------------------------------------------------> Changed by Rajesh
	
	//**********************************As Per the Discussion With Gagan We are Skipping the Add Commission . WE will cover the test cases in Agent Commission MileStone ---------------
	
//	Thread.sleep(10000);
//	setup.AddSchmebutton();
//	Thread.sleep(3000);
//	setup.Addwindow();
//	Thread.sleep(3000);
//	setup.AddItem();
//	Thread.sleep(3000);
//	setup.Savebutton();
//	Thread.sleep(4000);
//	SStaff = SStaff.BussUnit();
//	SStaff = SStaff.AddUNIT();
//	SStaff = SStaff.AddUnitDeletewindow();
//	SStaff = SStaff.checkboxClick();
//	SStaff = SStaff.Delete();
//	if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 20)))
//		setAssertMessage("System displays a message >>>>"+ SStaff.Result(),1);
//	Verify.verifyEquals(SStaff.Result(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "46", 20));
	Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	
	}
	//--------------------------------------------------------------------------------------> changed by Rajesh
	
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Staff"})
	@Parameters({ "environment", "clientName" })
	public void SearchStaffTC47(String environment, String clientName) throws InterruptedException
	{
		// Old 
		
	//	WebDriverWait wait= new WebDriverWait(getDriver(), 200);
		
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "47", 1));	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.CustIDtransaction();
		Scustomer = Scustomer.CustSearchTransaction();
		/*Scustomer = Scustomer.SelectProductType();
		Thread.sleep(2000);
		Scustomer = Scustomer.setProduct(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "47", 2));
		Thread.sleep(2000);
		Scustomer = Scustomer.setValue(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "47", 3));
		Thread.sleep(2000);
		Scustomer = Scustomer.setaggnum();
		Thread.sleep(2000);
		Scustomer =Scustomer.ConfirmSale();
		
		assertEquals(Scustomer.resultmessege(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "47", 4));
		
		if(Scustomer.resultmessege().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "47", 4)))
			setAssertMessage("2 System displayed a message >>>>>"+Scustomer.resultmessege(),1);
		Scustomer =Scustomer.Save();*/
		Thread.sleep(2000);
		SearchCustomerTransaction Scusttrxn = new SearchCustomerTransaction(getDriver());
		Scusttrxn = Scusttrxn.trasaction();
		Thread.sleep(2000);
		Scusttrxn = Scusttrxn.setPaymentValue(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "47", 6));
		// Need to check this line 
	//	Scusttrxn = Scusttrxn.setPayment(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "47", 7));
		
		//
		
		Scusttrxn = Scusttrxn.Allocate();
		Thread.sleep(2000);
//		Scusttrxn = Scusttrxn.Alert();
		//WebDriverWait wait= new WebDriverWait(getDriver(), 200);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
		System.out.println("out wait");
		Thread.sleep(1000);
		if(Scustomer.resultmessege().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "47", 8)))
		setAssertMessage("System displayed a message <<<<<<"+Scustomer.resultmessege(),2);
		Verify.verifyEquals(Scustomer.resultmessege(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "47",8));
		
		
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		SStaff = SStaff.Staff();
		SStaff = SStaff.SearchStaff();
		SStaff = SStaff.Staffid(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "47", 9));
		SStaff = SStaff.Search();
		Thread.sleep(2000);
		SStaff = SStaff.StaffLink();
		System.out.println("out wait");
		SStaff = SStaff.CashReconClick();
//		 wait= new WebDriverWait(getDriver(), 299);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Select Period')]")));
		System.out.println("out wait");
		//Thread.sleep(350000);
		
		SStaff = SStaff.AmendCashReconClick();
		//SStaff = SStaff.CashReconLoanClick();
		//Thread.sleep(120000);
		//SStaff = SStaff.CashReconLoanWindow();
	//	System.out.println(SStaff.CashReconLoanClick());
//		if(SStaff.CashReconLoanClick().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "47", 10)))
//			setAssertMessage("Loan details are displayed",1);
//		Verify.verifyEquals(SStaff.CashReconLoanClick(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "47", 10));
		if(SStaff.CashReconcollectionClick().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "47", 11)))
			setAssertMessage("Collection details are displayed",2);
		Verify.verifyEquals(SStaff.CashReconcollectionClick(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "47", 11));
		SStaff = SStaff.ConfirmCashReconClick();
		System.out.println("out confirm");
		Thread.sleep(1000);
		String result=SStaff.ResultRecon();
		System.out.println(SStaff.ResultRecon());
		if(Scustomer.resultmessege().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "47", 12)))
			setAssertMessage("System Displayed message >>>>>>",3);
		Verify.verifyEquals(Scustomer.resultmessege(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "47", 12));
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	
	}
	// -------------------------------------------------------------------------------------------------> Changed By Rajesh
	
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Staff"})
	@Parameters({ "environment", "clientName" })
	public void SearchStaffTC48(String environment, String clientName) throws InterruptedException
	{
	//	WebDriverWait wait= new WebDriverWait(getDriver(), 200);
		
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "48", 1));	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.CustIDtransaction();
		Scustomer = Scustomer.CustSearchTransaction();
		Scustomer = Scustomer.SelectProductType();
		Thread.sleep(2000);
		Scustomer = Scustomer.setProduct(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "48", 2));
		Thread.sleep(2000);
		Scustomer = Scustomer.setValue(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "48", 3));
		Thread.sleep(2000);
		Scustomer = Scustomer.setaggnum();
		Thread.sleep(2000);
		Scustomer =Scustomer.ConfirmSale();
		
		assertEquals(Scustomer.resultmessege(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "48", 4));
		
		if(Scustomer.resultmessege().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "48", 4)))
			setAssertMessage("System displayed a message >>>>>"+Scustomer.resultmessege(),1);
		Scustomer =Scustomer.Save();
		if(Scustomer.resultmessege().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "48", 5)))
			setAssertMessage("System displayed a message >>>>>"+Scustomer.resultmessege(),2);
		Thread.sleep(2000);
		
		
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		SStaff = SStaff.Staff();
		SStaff = SStaff.SearchStaff();
		SStaff = SStaff.Staffid(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "48", 6));
		SStaff = SStaff.Search();
		Thread.sleep(2000);
		SStaff = SStaff.StaffLink();
		Thread.sleep(2000);
		//System.out.println("out waittttttttttttt");
		SStaff = SStaff.CashReconClick();
		Thread.sleep(2000);
		SStaff = SStaff.AmendCashReconClick();
		Thread.sleep(2000);
		SStaff = SStaff.ConfirmCashReconClick();
		Thread.sleep(2000);
		//System.out.println("out confirm");
		//Thread.sleep(100000);
		SStaff = SStaff.setSelectPeriodClick(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "48", 7));
		SStaff = SStaff.Search();
		SStaff = SStaff.SelectPeriodRangeClick();
		Thread.sleep(2000);
		if(SStaff.CashReconLoanClick().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "48", 8)))
			setAssertMessage("Loan details are displayed",3);
		// Issue is Loan sale amount is set as 00
		
		Verify.verifyEquals(SStaff.CashReconLoanClick(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "48", 8));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Staff"})
	@Parameters({ "environment", "clientName" })
	public void SearchStaffTC49(String environment, String clientName) throws InterruptedException
	{
	//	WebDriverWait wait= new WebDriverWait(getDriver(), 200);
		
		
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		SStaff = SStaff.Staff();
		SStaff = SStaff.SearchStaff();
		SStaff = SStaff.Staffid(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "49", 1));
		SStaff = SStaff.Search();
		Thread.sleep(2000);
		SStaff = SStaff.StaffLink();
		//
		//System.out.println("out waittttttttttttt");
		SStaff = SStaff.CashReconClick();
		
		Thread.sleep(2000);
		if(SStaff.FloatCash().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "49", 2)))
			setAssertMessage("Opening Float shows balance same as Closing Float Cash.",3);
		Verify.verifyEquals(SStaff.FloatCash(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "49", 2));
		if(SStaff.FloatCheque().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "49", 3)))
			setAssertMessage("Opening Float Cash and Cheque show the balance as Zero",4);
		Verify.verifyEquals(SStaff.FloatCheque(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "49",3));
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Staff"})
	@Parameters({ "environment", "clientName" })
	public void SearchStaffTC50(String environment, String clientName) throws InterruptedException
	{
	//	WebDriverWait wait= new WebDriverWait(getDriver(), 200);
		
		
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		SStaff = SStaff.Staff();
		SStaff = SStaff.SearchStaff();
		SStaff = SStaff.Staffid(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "50", 1));
		SStaff = SStaff.Search();
		Thread.sleep(2000);
		SStaff = SStaff.StaffLink();
		
		String FloatLimitS =SStaff.FloatLimitValue();
		System.out.println(FloatLimitS);
		SStaff = SStaff.CashReconClick();
		//Thread.sleep(100000);
		 DecimalFormat df = new DecimalFormat("#.00");
		System.out.println(FloatLimitS);
		String f1=String.valueOf(FloatLimitS).replaceAll(",", "");
		double Fval = Double.valueOf(f1);
		//double f=Double.valueOf(FloatLimitS);
		System.out.println(f1);
		String value=SStaff.OpeningFCash.getText();
		String o =String.valueOf(value).replaceAll(",", "");
		double OpeningFloat1=Double.valueOf(o);
		String o1 =df.format(OpeningFloat1);
		double OpeningFloat=Double.valueOf(o1);
		System.out.println("Fval>>>>>"+Fval);
		System.out.println("OpeningFloat>>>>"+OpeningFloat);
		String result=null;
		if(Fval>=OpeningFloat)
		{
			result="True";
			System.out.println(result);
			
		}
		Thread.sleep(2000);
		
		if(result.equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "50", 2)))
			setAssertMessage("Opening Float Cash is same as Float Limit or less than Float limit",1);
		Verify.verifyEquals(result,ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "50", 2));
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Staff"})
	@Parameters({ "environment", "clientName" })
	public void SearchStaffTC51(String environment, String clientName) throws InterruptedException
	{
	//	WebDriverWait wait= new WebDriverWait(getDriver(), 200);
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer = Scustomer.Customer();
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "51", 1));	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.CustIDtransaction();
		Scustomer = Scustomer.CustSearchTransaction();
		SearchCustomerTransaction Scusttrxn = new SearchCustomerTransaction(getDriver());
		Scusttrxn = Scusttrxn.trasaction();
		Thread.sleep(2000);
		Scusttrxn = Scusttrxn.setPaymentType(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "51", 2));
		Scusttrxn = Scusttrxn.setchequeno(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "51", 3));
		Scusttrxn = Scusttrxn.setPaymentValue(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "51", 4));
		//Scusttrxn = Scusttrxn.setPayment(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "51", 5));
		Scusttrxn = Scusttrxn.Allocate();
		Thread.sleep(2000);
		//Scusttrxn = Scusttrxn.Alert();
		//System.out.println("out waittttttttttttt");
		
		if(Scustomer.resultmessege().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "51", 6)))
		setAssertMessage("System displayed a message <<<<<<"+Scustomer.resultmessege(),1);
		//System.out.println("jjjjj");
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		//System.out.println("jjjjj");
		SStaff = SStaff.Staff();
		SStaff = SStaff.SearchStaff();
		SStaff = SStaff.Staffid(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "51", 7));
		SStaff = SStaff.Search();
		Thread.sleep(2000);
		SStaff = SStaff.StaffLink();
		SStaff = SStaff.CashReconClick();
		SStaff = SStaff.AmendCashReconClick();
		SStaff = SStaff.ConfirmCashReconClick();
		
		Thread.sleep(2000);
		//System.out.println("jjjjj");
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "51", 8)))
			setAssertMessage("System displayed message"+SStaff.Result(),1);
		Verify.verifyEquals(SStaff.Result(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "51", 8));
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	
	}

	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Staff"})
	@Parameters({ "environment", "clientName" })
	public void SearchStaffTC52(String environment, String clientName) throws InterruptedException
	{
	
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		//System.out.println("jjjjj");
		SStaff = SStaff.Staff();
		SStaff = SStaff.SearchStaff();
		SStaff = SStaff.Staffid(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "52", 1));
		SStaff = SStaff.Search();
		Thread.sleep(2000);
		SStaff = SStaff.StaffLink();
		SStaff = SStaff.CashReconClick();
		SStaff = SStaff.AmendCashReconClick();
		//SStaff = SStaff.ConfirmCashReconClick();
		String result=null;
		String of=SStaff.OpeningFCash.getText().replaceAll(",", "");
		System.out.println(of);
		double Openingfloat = Double.valueOf(of);
		System.out.println(Openingfloat);
		String cf=SStaff.ClosingFCash.getText().replaceAll(",", "");
		String ab=SStaff.AmountToBankCash.getText().replaceAll(",", "");
		double Closingfloat = Double.valueOf(cf);
		System.out.println(Closingfloat);
		double AmountToBank = Double.valueOf(ab);
		System.out.println(AmountToBank);
		//change by rajesh 
		String floatLimit="1500";
		double Floatlimit=Double.valueOf(floatLimit);
		
		if (Closingfloat<=Floatlimit) {
			System.out.println("true");
			result = "True";
		}
		else if (Closingfloat-Floatlimit==AmountToBank)
		{
			System.out.println("true");
			result = "True";
		}
		Thread.sleep(2000);
		//System.out.println("jjjjj");
		if(result.equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "52", 2)))
			setAssertMessage("Amount to Bank Cash is same as 'Closing Float - Opening Float'",1);
		Verify.verifyEquals(result,ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "52", 2));
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	
	}
}