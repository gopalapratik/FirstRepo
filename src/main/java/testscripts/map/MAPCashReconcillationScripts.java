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
public class MAPCashReconcillationScripts extends BaseClass {

	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "CashReconcillation" }, priority = 1)
	@Parameters({ "environment", "clientName" })
	public void ManualBankingTC235(String environment, String clientName) throws InterruptedException {
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
		Thread.sleep(3000);
		MAPClientList.clickHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPCashReconcillation MAPCashReconcillation=new MAPCashReconcillation(getAndroidDriver());
		MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
		Double ClosingFloatCash;
		Double AutoCashBanking;
		
		String ManualCashBankinBefore = MAPCashReconcillation.ManualCashBankingAmmount();
		ManualCashBankinBefore=ManualCashBankinBefore.replaceFirst("£", "");
		if(ManualCashBankinBefore.contains(","))
		{
			ManualCashBankinBefore=ManualCashBankinBefore.replaceAll(",", "");
		}
		
		String AutoCashBankingBefore = MAPCashReconcillation.AutoCashBankingAmount();
		AutoCashBankingBefore=AutoCashBankingBefore.replaceFirst("£", "");
		if(AutoCashBankingBefore.contains(","))
		{
			AutoCashBankingBefore=AutoCashBankingBefore.replaceAll(",", "");
		}
		
		String ClosingFloatCashBefore = MAPCashReconcillation.ClosingFloatCashAmmount();
		ClosingFloatCashBefore=ClosingFloatCashBefore.replaceFirst("£", "");
		if(ClosingFloatCashBefore.contains(","))
		{
			ClosingFloatCashBefore=ClosingFloatCashBefore.replaceAll(",", "");
		}
		
		
		
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MAPCashReconcillation.clickManualBankingButton();
		MAPCashReconcillation.EnterManualBankingAmount(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "235", 1));
		MAPCashReconcillation.SelectDepositeCardRef(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "235", 2));
		MAPCashReconcillation.ClickManualBankingOK();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		
		Double ManualCashBanking= Double.valueOf(ManualCashBankinBefore)+Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "235", 1));
		NumberFormat numberformatter = NumberFormat.getCurrencyInstance(Locale.UK);
		String ManualCashBankingAfter = numberformatter.format(new BigDecimal(ManualCashBanking));
		
		if (MAPCashReconcillation.ManualCashBankingAmmount().equals(ManualCashBankingAfter))
			setAssertMessage("Manual Cash Banking Amount verified on Cash Reconcillation Screen   " + MAPCashReconcillation.ManualCashBankingAmmount(),1);
		Verify.verifyEquals(MAPCashReconcillation.ManualCashBankingAmmount(),ManualCashBankingAfter);
		
		if(Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "235", 1))>Double.valueOf(AutoCashBankingBefore))
		{
			Double Temp= Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "235", 1))-Double.valueOf(AutoCashBankingBefore);
			ClosingFloatCash= Double.valueOf(ClosingFloatCashBefore)-Temp;
			AutoCashBanking=0.00;
		}else
		{
			AutoCashBanking= Double.valueOf(AutoCashBankingBefore)-Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "235", 1));
			ClosingFloatCash=Double.valueOf(ClosingFloatCashBefore);
		}
		
		String AutoCashBankingAfter = numberformatter.format(new BigDecimal(AutoCashBanking));
		String ClosingFloatCashAfter = numberformatter.format(new BigDecimal(ClosingFloatCash));
		
		if (MAPCashReconcillation.AutoCashBankingAmount().equals(AutoCashBankingAfter))
			setAssertMessage("Auto Cash Banking Amount verified on Cash Reconcillation Screen   " + MAPCashReconcillation.AutoCashBankingAmount(),2);
		Verify.verifyEquals(MAPCashReconcillation.AutoCashBankingAmount(),AutoCashBankingAfter);
		
		if (MAPCashReconcillation.ClosingFloatCashAmmount().equals(ClosingFloatCashAfter))
			setAssertMessage("Closing Float Cash Banking Amount verified on Cash Reconcillation Screen   " + MAPCashReconcillation.ClosingFloatCashAmmount(),3);
		Verify.verifyEquals(MAPCashReconcillation.ClosingFloatCashAmmount(),ClosingFloatCashAfter);
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "CashReconcillation" }, priority = 1)
	@Parameters({ "environment", "clientName" })
	public void ManualBankingCancelTC236(String environment, String clientName) throws InterruptedException {
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
		Thread.sleep(3000);
		MAPClientList.clickHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPCashReconcillation MAPCashReconcillation=new MAPCashReconcillation(getAndroidDriver());
		MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
		
		String ManualCashBankinBefore = MAPCashReconcillation.ManualCashBankingAmmount();
		String AutoCashBankingBefore = MAPCashReconcillation.AutoCashBankingAmount();
		String ClosingFloatCashBefore = MAPCashReconcillation.ClosingFloatCashAmmount();
		
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MAPCashReconcillation.clickManualBankingButton();
		MAPCashReconcillation.EnterManualBankingAmount(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "236", 1));
		MAPCashReconcillation.SelectDepositeCardRef(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "236", 2));
		MAPCashReconcillation.ClickManualBankingCancel();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		
		if (MAPCashReconcillation.ManualCashBankingAmmount().equals(ManualCashBankinBefore))
			setAssertMessage("Manual Cash Banking Amount verified on Cash Reconcillation Screen   " + MAPCashReconcillation.ManualCashBankingAmmount(),1);
		Verify.verifyEquals(MAPCashReconcillation.ManualCashBankingAmmount(),ManualCashBankinBefore);
		
		if (MAPCashReconcillation.AutoCashBankingAmount().equals(AutoCashBankingBefore))
			setAssertMessage("Auto Cash Banking Amount verified on Cash Reconcillation Screen   " + MAPCashReconcillation.AutoCashBankingAmount(),2);
		Verify.verifyEquals(MAPCashReconcillation.AutoCashBankingAmount(),AutoCashBankingBefore);
		
		if (MAPCashReconcillation.ClosingFloatCashAmmount().equals(ClosingFloatCashBefore))
			setAssertMessage("Closing Float Cash Banking Amount verified on Cash Reconcillation Screen   " + MAPCashReconcillation.ClosingFloatCashAmmount(),3);
		Verify.verifyEquals(MAPCashReconcillation.ClosingFloatCashAmmount(),ClosingFloatCashBefore);
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
	
}
