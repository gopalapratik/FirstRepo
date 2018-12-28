package testscripts.map;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
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
import helpers.CommonFunctions;
import helpers.MAPFunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import pageobjects.cap.LoginPage;
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
public class MAPATMWithdrawalScripts extends BaseClass {

	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "ATMWithdrawal" }, priority = 1)
	@Parameters({ "environment", "clientName" })
	public void ATMWithdrawalTC217(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
		String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
		MAPLoginPage.EnterLoginID(userName);
		MAPLoginPage.EnterPassword(password);
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 240);
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
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "217", 1));
		MAPATMWithdrawal.selectFromCard(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "217", 2));
		MAPATMWithdrawal.clickConfirmATMwithdrawalbutton();
		if (MAPATMWithdrawal.verifyATMWithdrawalAmount().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "217", 3)))
			setAssertMessage("ATM Withdrawal Amount on withdrawal model window   " + MAPATMWithdrawal.verifyATMWithdrawalAmount(),1);
		Verify.verifyEquals(MAPATMWithdrawal.verifyATMWithdrawalAmount(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "217", 3));
		
		MAPATMWithdrawal.clickConfirmatmmodalbutton();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPATMWithdrawal.clickATMwithdrawalHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		//MAPCashReconcillation MAPCashReconcillation=new MAPCashReconcillation(getAndroidDriver());
		Double ATM= Double.valueOf(ATMWithdrawal)+Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "217", 1));
		DecimalFormat formatter = new DecimalFormat("#.00");
		//String ATMAmount= "£"+String.valueOf(formatter.format(ATM));
		
		//String ATMAmount= "£"+String.format("%,.2f",String.valueOf(formatter.format(ATM)));
		 NumberFormat numberformatter = NumberFormat.getCurrencyInstance(Locale.UK);
		 String ATMAmount = numberformatter.format(new BigDecimal(ATM));
		 
		if (MAPCashReconcillation.ATMWithdrawalAmmount().equals(ATMAmount))
			setAssertMessage("ATM Withdrawal Amount on Cash Reconcillation Screen   " + MAPCashReconcillation.ATMWithdrawalAmmount(),2);
		Verify.verifyEquals(MAPCashReconcillation.ATMWithdrawalAmmount(),ATMAmount);
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "ATMWithdrawal" }, priority = 1)
	@Parameters({ "environment", "clientName" })
	public void ATMWithdrawalTC218(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
		String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
		MAPLoginPage.EnterLoginID(userName);
		MAPLoginPage.EnterPassword(password);
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 240);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPCashReconcillation MAPCashReconcillation=new MAPCashReconcillation(getAndroidDriver());
		String ATMWithdrawal = MAPCashReconcillation.ATMWithdrawalAmmount();
		
		MAPClientList.clickHamburger();
		MAPClientList.clickATMWithdrawal();
		MAPATMWithdrawal MAPATMWithdrawal = new MAPATMWithdrawal(getAndroidDriver());
		MAPATMWithdrawal.enterWithdrawalAmmount(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "218", 1));
		MAPATMWithdrawal.selectFromCard(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "218", 2));
		MAPATMWithdrawal.clickConfirmATMwithdrawalbutton();
		if (MAPATMWithdrawal.verifyATMWithdrawalAmount().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "218", 3)))
			setAssertMessage("ATM Withdrawal Amount on withdrawal model window      " + MAPATMWithdrawal.verifyATMWithdrawalAmount(),1);
		Verify.verifyEquals(MAPATMWithdrawal.verifyATMWithdrawalAmount(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "218", 3));
		
		MAPATMWithdrawal.clickCancelatmmodalbutton2();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPATMWithdrawal.clickATMwithdrawalHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		if (MAPCashReconcillation.ATMWithdrawalAmmount().equals(ATMWithdrawal))
			setAssertMessage("ATM Withdrawal Amount on Cash Reconcillation Screen      " + MAPCashReconcillation.ATMWithdrawalAmmount(),2);
		Verify.verifyEquals(MAPCashReconcillation.ATMWithdrawalAmmount(),ATMWithdrawal);
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "ATMWithdrawal" }, priority = 1)
		@Parameters({ "environment", "clientName" })
		public void ATMWithdrawalLimitTC219(String environment, String clientName) throws InterruptedException {
			MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
			String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
			String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
			MAPLoginPage.EnterLoginID(userName);
			MAPLoginPage.EnterPassword(password);
			MAPLoginPage.clickLogIn();
			Thread.sleep(30000);
			WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 240);
			MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
			wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
			
			MAPClientList.clickHamburger();
			MAPClientList.clickATMWithdrawal();
			MAPATMWithdrawal MAPATMWithdrawal = new MAPATMWithdrawal(getAndroidDriver());
			MAPATMWithdrawal.enterWithdrawalAmmount(
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "219", 1));
			
			if (MAPATMWithdrawal.verifyATMWithdrawalAlert().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "219", 2)))
				setAssertMessage("ATM Withdrawal Alert  Message    " + MAPATMWithdrawal.verifyATMWithdrawalAlert(),1);
			Verify.verifyEquals(MAPATMWithdrawal.verifyATMWithdrawalAlert(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "219", 2));
			
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		}
		
		@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "ATMWithdrawal" }, priority = 1)
		@Parameters({ "environment", "clientName" })
		public void ATMWithdrawalAdjustPaymentTC220(String environment, String clientName) throws InterruptedException {
			MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
			String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
			String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
			MAPLoginPage.EnterLoginID(userName);
			MAPLoginPage.EnterPassword(password);
			MAPLoginPage.clickLogIn();
			Thread.sleep(30000);
			WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 240);
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
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "220", 1));
			MAPATMWithdrawal.selectFromCard(
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "220", 2));
			MAPATMWithdrawal.clickConfirmATMwithdrawalbutton();
			
			MAPATMWithdrawal.clickConfirmatmmodalbutton();
			wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		
			//MAPATMWithdrawal MAPATMWithdrawal = new MAPATMWithdrawal(getAndroidDriver());
			MAPATMWithdrawal.clickTodaysATMWithdrawals();
			MAPATMWithdrawal.enterAdjustmentAmmount(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "220", 4));
			MAPATMWithdrawal.selectAdjustmentCard(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "220", 5));
			MAPATMWithdrawal.clickConfirmAtmWithdrawalAdjustment();
			
			MAPATMWithdrawal.clickAdjustmentconfirmatmmodalbutton();
			
			Double ATM= Double.valueOf(ATMWithdrawal)+Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "220", 4));
			DecimalFormat formatter = new DecimalFormat("#.00");
			 NumberFormat numberformatter = NumberFormat.getCurrencyInstance(Locale.UK);
			 String ATMAmount = numberformatter.format(new BigDecimal(ATM));
			 
			 MAPATMWithdrawal.clickATMwithdrawalHamburger();
			 MAPClientList.clickCashReconciliation();
				wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
			if (MAPCashReconcillation.ATMWithdrawalAmmount().equals(ATMAmount))
				setAssertMessage("ATM Withdrawal Amount  on Cash Reconcillation Screen   " + MAPCashReconcillation.ATMWithdrawalAmmount(),1);
			Verify.verifyEquals(MAPCashReconcillation.ATMWithdrawalAmmount(),ATMAmount);
			

			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		}
		
		@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "ATMWithdrawal" }, priority = 1)
		@Parameters({ "environment", "clientName" })
		public void ATMWithdrawalAdjustPaymentConfirmCancelTC221(String environment, String clientName) throws InterruptedException {
			MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
			String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
			String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
			MAPLoginPage.EnterLoginID(userName);
			MAPLoginPage.EnterPassword(password);
			MAPLoginPage.clickLogIn();
			Thread.sleep(30000);
			WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 240);
			MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
			wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
						
			MAPClientList.clickHamburger();
			MAPClientList.clickATMWithdrawal();
			MAPATMWithdrawal MAPATMWithdrawal = new MAPATMWithdrawal(getAndroidDriver());
			MAPATMWithdrawal.enterWithdrawalAmmount(
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "221", 1));
			MAPATMWithdrawal.selectFromCard(
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "221", 2));
			MAPATMWithdrawal.clickConfirmATMwithdrawalbutton();
			
			MAPATMWithdrawal.clickConfirmatmmodalbutton();
			wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		
			//MAPATMWithdrawal MAPATMWithdrawal = new MAPATMWithdrawal(getAndroidDriver());
			MAPATMWithdrawal.clickTodaysATMWithdrawals();
			MAPATMWithdrawal.enterAdjustmentAmmount(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "221", 4));
			MAPATMWithdrawal.selectAdjustmentCard(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "221", 5));
			MAPATMWithdrawal.clickConfirmAtmWithdrawalAdjustment();
			Thread.sleep(2000);
			//wait.until(ExpectedConditions.visibilityOf(MAPATMWithdrawal.Adjustmentconfirmatmmodalbutton));
			//wait.until(ExpectedConditions.elementToBeClickable(MAPATMWithdrawal.Adjustmentconfirmatmmodalbutton));
			MAPATMWithdrawal.clickAdjustmentCancelatmmodalbutton();
			
			
			if (MAPATMWithdrawal.verifyTodayAtmTitle().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "221", 6)))
				setAssertMessage("Todays Atm Title     " + MAPATMWithdrawal.verifyTodayAtmTitle(),1);
			Verify.verifyEquals(MAPATMWithdrawal.verifyTodayAtmTitle(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "221", 6));
			

			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		}
		
		@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "ATMWithdrawal" }, priority = 1)
		@Parameters({ "environment", "clientName" })
		public void ATMWithdrawalAdjustPaymentCancelTC222(String environment, String clientName) throws InterruptedException {
			MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
			String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
			String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
			MAPLoginPage.EnterLoginID(userName);
			MAPLoginPage.EnterPassword(password);
			MAPLoginPage.clickLogIn();
			Thread.sleep(30000);
			WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 240);
			MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
			wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
						
			MAPClientList.clickHamburger();
			MAPClientList.clickATMWithdrawal();
			MAPATMWithdrawal MAPATMWithdrawal = new MAPATMWithdrawal(getAndroidDriver());
			MAPATMWithdrawal.enterWithdrawalAmmount(
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "222", 1));
			MAPATMWithdrawal.selectFromCard(
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "222", 2));
			MAPATMWithdrawal.clickConfirmATMwithdrawalbutton();
			
			MAPATMWithdrawal.clickConfirmatmmodalbutton();
			wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		
			//MAPATMWithdrawal MAPATMWithdrawal = new MAPATMWithdrawal(getAndroidDriver());
			MAPATMWithdrawal.clickTodaysATMWithdrawals();
			String adjustmentAmount=MAPATMWithdrawal.verifyAdjustmentAmmount();
			MAPATMWithdrawal.enterAdjustmentAmmount(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "222", 4));
			MAPATMWithdrawal.selectAdjustmentCard(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "222", 5));
			MAPATMWithdrawal.clickCancelAtmWithdrawalAdjustment();
			
			MAPATMWithdrawal.clickTodaysATMWithdrawals();
			
			if (MAPATMWithdrawal.verifyAdjustmentAmmount().equals(adjustmentAmount))
				setAssertMessage("Adjustment Amount   " + MAPATMWithdrawal.verifyAdjustmentAmmount(),1);
			Verify.verifyEquals(MAPATMWithdrawal.verifyAdjustmentAmmount(),adjustmentAmount);
			

			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		}
		
		@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "ATMWithdrawal" }, priority = 1)
		@Parameters({ "environment", "clientName" })
		public void AdjustmentWithdrawalLimitTC223(String environment, String clientName) throws InterruptedException {
			MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
			String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
			String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
			MAPLoginPage.EnterLoginID(userName);
			MAPLoginPage.EnterPassword(password);
			MAPLoginPage.clickLogIn();
			Thread.sleep(30000);
			WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 240);
			MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
			wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
						
			MAPClientList.clickHamburger();
			MAPClientList.clickATMWithdrawal();
			MAPATMWithdrawal MAPATMWithdrawal = new MAPATMWithdrawal(getAndroidDriver());
			MAPATMWithdrawal.enterWithdrawalAmmount(
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "223", 1));
			MAPATMWithdrawal.selectFromCard(
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "223", 2));
			MAPATMWithdrawal.clickConfirmATMwithdrawalbutton();
			
			MAPATMWithdrawal.clickConfirmatmmodalbutton();
			wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		
			//MAPATMWithdrawal MAPATMWithdrawal = new MAPATMWithdrawal(getAndroidDriver());
			MAPATMWithdrawal.clickTodaysATMWithdrawals();
			
			MAPATMWithdrawal.enterAdjustmentAmmount(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "223", 3));
						
			
			if (MAPATMWithdrawal.verifyAdjustmentWithdrawalAlert().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "223", 4)))
				setAssertMessage("Adjustment Amount   " +MAPATMWithdrawal.verifyAdjustmentWithdrawalAlert(),1);
			Verify.verifyEquals(MAPATMWithdrawal.verifyAdjustmentWithdrawalAlert(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "223", 4));
			

			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		}
}
