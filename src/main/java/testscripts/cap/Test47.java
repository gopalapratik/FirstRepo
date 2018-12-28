package testscripts.cap;

import java.text.DecimalFormat;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsersetup.BaseClass;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchCustomerTransaction;
import pageobjects.cap.SearchStaffPage;
import pageobjects.cap.SetupStaff;
import utilities.ExcelUtilities;
import verify.Verify;

public class Test47 extends BaseClass {
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
		//Scusttrxn = Scusttrxn.setPayment(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "47", 7));
		
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
}