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
import pageobjects.map.MAPRecycleCash;
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
public class MAPRecycleCashScripts extends BaseClass {

	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "RecycleCash" }, priority = 1)
	@Parameters({ "environment", "clientName" })
	public void RecycleCashTC224(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		
		MAPLoginPage.EnterLoginID(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "224", 5));
		MAPLoginPage.EnterPassword(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "224", 6));
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 300);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPCashReconcillation MAPCashReconcillation = new MAPCashReconcillation(getAndroidDriver());
		String RecycleCashInBefore= MAPCashReconcillation.RecycledCashInAmmount();
		RecycleCashInBefore = RecycleCashInBefore.replaceFirst("£", "");
		if (RecycleCashInBefore.contains(",")) {
			RecycleCashInBefore = RecycleCashInBefore.replaceAll(",", "");
		}
		
		MAPClientList.clickHamburger();
		MAPClientList.clickLogout();
		
		MAPLoginPage.EnterLoginID(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "224", 1));
		MAPLoginPage.EnterPassword(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "224", 2));
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);
	/*	WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 240);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());*/
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		//MAPCashReconcillation MAPCashReconcillation = new MAPCashReconcillation(getAndroidDriver());
		String RecycleCashOutBefore = MAPCashReconcillation.RecycledCashOutAmmount();
		/*
		 * String RecycleCashIn= MAPCashReconcillation.RecycledCashInAmmount();
		 * String ClosingFloat= MAPCashReconcillation.ClosingFloatCashAmmount();
		 */

		RecycleCashOutBefore = RecycleCashOutBefore.replaceFirst("£", "");
		if (RecycleCashOutBefore.contains(",")) {
			RecycleCashOutBefore = RecycleCashOutBefore.replaceAll(",", "");
		}

		MAPClientList.clickHamburger();
		MAPClientList.clickRecycleCash();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPRecycleCash MAPRecycleCash = new MAPRecycleCash(getAndroidDriver());
		MAPRecycleCash.enterRecycleAmount(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "224", 3));
		MAPRecycleCash.selectRecipient(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "224", 4));
		MAPRecycleCash.ClickConfirmRecycleCashButton();
		MAPRecycleCash.ClickRecycleConfirmmodalButton();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));

		Double RecycleCashOutAfter = Double.valueOf(RecycleCashOutBefore) + Double.valueOf(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "224", 3));
		DecimalFormat formatter = new DecimalFormat("#.00");

		NumberFormat numberformatter = NumberFormat.getCurrencyInstance(Locale.UK);
		String RecycleCashOut = numberformatter.format(new BigDecimal(RecycleCashOutAfter));
		MAPClientList.clickHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));

		if (MAPCashReconcillation.RecycledCashOutAmmount().equals(RecycleCashOut))
			setAssertMessage("Recycle Cash out after Recycle Cash on Cash Reconcillation Screen   "
					+ MAPCashReconcillation.RecycledCashOutAmmount(), 1);
		Verify.verifyEquals(MAPCashReconcillation.RecycledCashOutAmmount(), RecycleCashOut);

		MAPClientList.clickHamburger();
		MAPClientList.clickLogout();
		
		MAPLoginPage.EnterLoginID(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "224", 5));
		MAPLoginPage.EnterPassword(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "224", 6));
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		/*
		if (MAPCashReconcillation.RecycledCashInAmmount().equals(RecycleCashOut))
			setAssertMessage("Recycle Cash In after Recycle Cash on Cash Reconcillation Screen for another staff  "
					+ MAPCashReconcillation.RecycledCashInAmmount(), 2);
		Verify.verifyEquals(MAPCashReconcillation.RecycledCashInAmmount(), RecycleCashOut);*/
		
		Double RecycleCashInAfter = Double.valueOf(RecycleCashInBefore) + Double.valueOf(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "224", 3));
		String RecycleCashIn = numberformatter.format(new BigDecimal(RecycleCashInAfter));
		//String RecycleCashIn = numberformatter.format(new BigDecimal(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "224", 3)));
		
		if (MAPCashReconcillation.RecycledCashInAmmount().equals(RecycleCashIn))
			setAssertMessage("Recycle Cash In after Recycle Cash on Cash Reconcillation Screen for another staff  "
					+ MAPCashReconcillation.RecycledCashInAmmount(), 2);
		Verify.verifyEquals(MAPCashReconcillation.RecycledCashInAmmount(), RecycleCashIn);
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "RecycleCash" })
	@Parameters({ "environment", "clientName" })
	public void RecycleCashCancelTC225(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		MAPLoginPage.EnterLoginID(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "225", 1));
		MAPLoginPage.EnterPassword(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "225", 2));
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 240);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPCashReconcillation MAPCashReconcillation = new MAPCashReconcillation(getAndroidDriver());
		String RecycleCashOutBefore = MAPCashReconcillation.RecycledCashOutAmmount();

		MAPClientList.clickHamburger();
		MAPClientList.clickRecycleCash();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPRecycleCash MAPRecycleCash = new MAPRecycleCash(getAndroidDriver());
		MAPRecycleCash.enterRecycleAmount(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "224", 3));
		MAPRecycleCash.selectRecipient(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "224", 4));
		MAPRecycleCash.ClickConfirmRecycleCashButton();
		MAPRecycleCash.ClickRecycleCancelmodalbutton();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));

		MAPClientList.clickHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));

		if (MAPCashReconcillation.RecycledCashOutAmmount().equals(RecycleCashOutBefore))
			setAssertMessage("Recycle Cash out after Recycle Cash on Cash Reconcillation Screen   "
					+ MAPCashReconcillation.RecycledCashOutAmmount(), 1);
		Verify.verifyEquals(MAPCashReconcillation.RecycledCashOutAmmount(), RecycleCashOutBefore);
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "RecycleCash" })
	@Parameters({ "environment", "clientName" })
	public void RecycleCashAmountTC226(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		MAPLoginPage.EnterLoginID(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "226", 1));
		MAPLoginPage.EnterPassword(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "226", 2));
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 300);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPCashReconcillation MAPCashReconcillation = new MAPCashReconcillation(getAndroidDriver());
		String ClosingFloatCashAmmount = MAPCashReconcillation.ClosingFloatCashAmmount();
		ClosingFloatCashAmmount = ClosingFloatCashAmmount.replaceFirst("£", "");
		if (ClosingFloatCashAmmount.contains(",")) {
			ClosingFloatCashAmmount = ClosingFloatCashAmmount.replaceAll(",", "");
		}

		String AutoCashBankingAmount = MAPCashReconcillation.AutoCashBankingAmount();
		AutoCashBankingAmount = AutoCashBankingAmount.replaceFirst("£", "");
		if (AutoCashBankingAmount.contains(",")) {
			AutoCashBankingAmount = AutoCashBankingAmount.replaceAll(",", "");
		}

		Double Amount = Double.valueOf(ClosingFloatCashAmmount) + Double.valueOf(AutoCashBankingAmount) +Double.valueOf(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "226", 3));
		System.out.println("Amount "+Amount);
		DecimalFormat formatter = new DecimalFormat("#.00");
		MAPClientList.clickHamburger();
		MAPClientList.clickRecycleCash();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPRecycleCash MAPRecycleCash = new MAPRecycleCash(getAndroidDriver());
		MAPRecycleCash.enterRecycleAmount(String.valueOf(formatter.format(Amount)));

		
		
		if (MAPRecycleCash.VerifyRecycleAmountLimit().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "226", 4)))
			setAssertMessage("Recyle Cash Amount verified- Should not be greater than( Closing Float + Auto Cash Banking)  "	, 1);
		Verify.verifyEquals(MAPRecycleCash.VerifyRecycleAmountLimit(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "226", 4));
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}


}
