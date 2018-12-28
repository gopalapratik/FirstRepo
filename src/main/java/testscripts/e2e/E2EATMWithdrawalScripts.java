package testscripts.e2e;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import reporting.ListenerClass;
import testdata.ConfigurationData;
import utilities.ExcelUtilities;
import verify.Verify;
import browsersetup.BaseClass;
import browsersetup.Setup;
import helpers.CommonFunctions;
import helpers.MAPFunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import pageobjects.cap.LoginPage;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchCustomerStatement;
import pageobjects.cap.SearchStaffPage;
import pageobjects.cap.ViewLeadsPage;
import pageobjects.map.MAPLoginPage;
import pageobjects.map.MAPSynchronization;
import pageobjects.map.MAPATMWithdrawal;
import pageobjects.map.MAPCashReconcillation;
import pageobjects.map.MAPClientList;
import pageobjects.map.MAPCustomerDetails;
import pageobjects.map.MAPLead;
import pageobjects.map.MAPLoanSale;
import pageobjects.map.MAPLoanSale_ProductSelection;
import helpers.MAPFunctions;

@Listeners(ListenerClass.class)
public class E2EATMWithdrawalScripts extends BaseClass {
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "E2E", "ATMWithdrawal" })
	@Parameters({ "environment", "clientName" })
	public void E2EScenario183(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
		String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
		MAPLoginPage.EnterLoginID(userName);
		MAPLoginPage.EnterPassword(password);
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 360);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPCashReconcillation MAPCashReconcillation=new MAPCashReconcillation(getAndroidDriver());
		String ATMWithdrawal = MAPCashReconcillation.ATMWithdrawalAmmount();
		ATMWithdrawal=ATMWithdrawal.replaceFirst("£", "");
		if(ATMWithdrawal.contains(","))
		{
			ATMWithdrawal=ATMWithdrawal.replaceAll(",", "");
		}
		
		MAPClientList.clickHamburger();
		MAPClientList.clickATMWithdrawal();
		MAPATMWithdrawal MAPATMWithdrawal = new MAPATMWithdrawal(getAndroidDriver());
		MAPATMWithdrawal.enterWithdrawalAmmount(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "183", 1));
		MAPATMWithdrawal.selectFromCard(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "183", 2));
		MAPATMWithdrawal.clickConfirmATMwithdrawalbutton();
		if (MAPATMWithdrawal.verifyATMWithdrawalAmount().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "183", 3)))
			setAssertMessage("ATM Withdrawal Amount            " + MAPATMWithdrawal.verifyATMWithdrawalAmount(),1);
		Verify.verifyEquals(MAPATMWithdrawal.verifyATMWithdrawalAmount(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "183", 3));
		
		MAPATMWithdrawal.clickConfirmatmmodalbutton();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		
		/*MAPATMWithdrawal.clickATMwithdrawalHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));*/
		Double ATM= Double.valueOf(ATMWithdrawal)+Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "183", 1));
		DecimalFormat formatter = new DecimalFormat("#.00");
		//String ATMAmount= "£"+String.valueOf(formatter.format(ATM));
		
		 NumberFormat numberformatter = NumberFormat.getCurrencyInstance(Locale.UK);
		 String ATMAmount = numberformatter.format(new BigDecimal(ATM));
		 
		/*if (MAPCashReconcillation.ATMWithdrawalAmmount().equals(ATMAmount))
			setAssertMessage("ATM Withdrawal Amount          " + MAPCashReconcillation.ATMWithdrawalAmmount(),2);
		Verify.verifyEquals(MAPCashReconcillation.ATMWithdrawalAmmount(),ATMAmount);
		String MAPAtmValue=MAPCashReconcillation.ATMWithdrawalAmmount();
		System.out.println(MAPAtmValue);*/
		
		CommonFunctions.Browser();
        SearchStaffPage SStaff = new SearchStaffPage(CommonFunctions.driver);
        SStaff = SStaff.Staff();
        SStaff = SStaff.SearchStaff();
        //SStaff = SStaff.FirstName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "49", 1));
        //SStaff = SStaff.LastName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "49", 1));
        SStaff = SStaff.FirstName("paul");
        SStaff = SStaff.LastName("Allen");

        SStaff = SStaff.Search();
        Thread.sleep(2000);
        SStaff = SStaff.StaffLink();
        
        SStaff = SStaff.CashReconClick();
       String  MAPAtmValue=ATMAmount.replaceFirst("£","");
        Thread.sleep(2000);
        if(SStaff.CheckResult("Total ATM Withdrawals").equals(MAPAtmValue))
               setAssertMessage("ATM Withdrawals done in MAP reflected in CAP ",3);
        Verify.verifyEquals(SStaff.CheckResult("Total ATM Withdrawals"),MAPAtmValue);

        
        MAPATMWithdrawal.clickATMwithdrawalHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		if (MAPCashReconcillation.ATMWithdrawalAmmount().equals(ATMAmount))
			setAssertMessage("ATM Withdrawal Amount" + MAPCashReconcillation.ATMWithdrawalAmmount(),2);
		Verify.verifyEquals(MAPCashReconcillation.ATMWithdrawalAmmount(),ATMAmount);
		MAPAtmValue=MAPCashReconcillation.ATMWithdrawalAmmount();
		System.out.println(MAPAtmValue);
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

	}
}
