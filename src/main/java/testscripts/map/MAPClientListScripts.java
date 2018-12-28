package testscripts.map;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.time.DateUtils;
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
import pageobjects.map.MAPViewAllSales;
import pageobjects.map.MAPCashReconcillation;
import pageobjects.map.MAPClientList;
import pageobjects.map.MAPCustomerDetails;
import pageobjects.map.MAPCustomerDetailsEdit;
import pageobjects.map.MAPLoanSale;
import pageobjects.map.MAPLoanSale_ProductSelection;
import helpers.MAPFunctions;

@Listeners(ListenerClass.class)
public class MAPClientListScripts extends BaseClass {

	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = {"Regression", "MAP", "ClientList" },priority = 1)
	@Parameters({ "environment", "clientName" })
	public void ClientLoanSaleTC208(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
		String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
		MAPLoginPage.EnterLoginID(userName);
		MAPLoginPage.EnterPassword(password);
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 360);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		// wait.until(ExpectedConditions.visibilityOf(MAPClientList.territory));
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		Thread.sleep(3000);
		//MAPClientList.clickAutoTestCuts();
		MAPClientList.clickAutoCustomer(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "208", 1));
		MAPCustomerDetails mapCustomerDetails = new MAPCustomerDetails(getAndroidDriver());
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(mapCustomerDetails.loanSale));
		String customerID=mapCustomerDetails.CustomerID();
		mapCustomerDetails.clickloanSale();
		MAPLoanSale MAPLoanSale = new MAPLoanSale(getAndroidDriver());
		Thread.sleep(3000);
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		wait.until(ExpectedConditions.visibilityOf(MAPLoanSale.loanSaleText));
		MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MAPLoanSale.clickPTCnext();
		MAPLoanSale.clickKYCNotSeen();
		MAPLoanSale.clickPiorDoc1();
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MAPLoanSale.clickUKPass();
		MAPLoanSale.enterPiorDoc1Section("123456789");
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MAPLoanSale.clickKYCNext();
		MAPLoanSale.enterSign();
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		wait.until(ExpectedConditions.visibilityOf(MAPLoanSale.KYCnext1));
		MAPLoanSale.clickKYCNext1();
		MAPLoanSale.enterTotalNetIncome("100.00");
		MAPLoanSale.clickSubmitTotalNetIncomeButton();
		Thread.sleep(3000);
		/*MAPLoanSale.enterWages("1000");
		MAPLoanSale.enterWagesEvidence();
		MAPLoanSale.selectWagesDocument("Wage Slip");
		MAPLoanSale.enterWagesReference("Reference");*/
	/*	MAPfunctions.switchContext("NATIVE");
		// MAPfunctions.scrollPage(1);
		MAPfunctions.scrollPageByHeight(4);
		MAPfunctions.switchContext("WEBVIEW");*/
		MAPLoanSale.clickRentPaid();
		MAPLoanSale.enterRentAmmount("10");
		MAPLoanSale.enterRentEvidence();
		MAPLoanSale.selectRentDocument("Rent Book");
		MAPLoanSale.enterRentReference("Refe");
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(2);
		MAPfunctions.switchContext("WEBVIEW");
		MAPLoanSale.slider(30, 0);
		Thread.sleep(3000);
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MAPLoanSale.clickConfirmCheck();
		wait.until(ExpectedConditions.elementToBeClickable(MAPLoanSale.AffNext));
		MAPLoanSale.clickAffNext();
		MAPLoanSale_ProductSelection MapLoanSale_ProductSelection = new MAPLoanSale_ProductSelection(
				getAndroidDriver());
		MapLoanSale_ProductSelection.clicksameAsHomeAddressCheckbox();
		MapLoanSale_ProductSelection.clickWeeklyRadio();
		MapLoanSale_ProductSelection.selectNationality("British");
		MapLoanSale_ProductSelection.enterNiNumber("AB123456C");
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPageByHeight(4);
		MAPfunctions.switchContext("WEBVIEW");
		MapLoanSale_ProductSelection.selectDeliveryMethod("Cash");
		MapLoanSale_ProductSelection.LoanType_additional();
		MapLoanSale_ProductSelection.selectProductType("33 Week Loan");
		MapLoanSale_ProductSelection.selectReasonForLoan("Other");
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MapLoanSale_ProductSelection.selectHCAdults("2");
		MapLoanSale_ProductSelection.selectHCChildren("1");
		MapLoanSale_ProductSelection.selectResidentialStatus("Other");
		MapLoanSale_ProductSelection.selectPropertyStatus("1 Bedroom");
		MapLoanSale_ProductSelection.selectEmploymentStatus("Self employed");
		MapLoanSale_ProductSelection.clickProductSelection_Next();
		MapLoanSale_ProductSelection.clickSECCIClose();
		// wait.until(ExpectedConditions.visibilityOf(MapLoanSale_ProductSelection.SECCI_closePreContractButton));
		wait.until(ExpectedConditions.elementToBeClickable(MapLoanSale_ProductSelection.SECCI_closePreContractButton));
		MapLoanSale_ProductSelection.clickSECCIClosePreContract();
		MapLoanSale_ProductSelection.enterSECCICustomerSign();
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MapLoanSale_ProductSelection.clickSECCINext();
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(3);
		MAPfunctions.switchContext("WEBVIEW");
		MapLoanSale_ProductSelection.clickTCNext();
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(2);
		MAPfunctions.switchContext("WEBVIEW");
		MapLoanSale_ProductSelection.clickMCNext();
		// MapLoanSale_ProductSelection.enterMRCustomerSign();
		MAPfunctions.switchContext("NATIVE");
		// MAPfunctions.scrollPage(1);
		MAPfunctions.scrollPageByHeight(6);
		MAPfunctions.switchContext("WEBVIEW");
		MapLoanSale_ProductSelection.enterMRCustomerSign();
		MapLoanSale_ProductSelection.clickMRNext();
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPageByHeight(7);
		// MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		if (MapLoanSale_ProductSelection.verifytypeOfCredit().equals("Fixed sum loan"))
			setAssertMessage("verify type of credit " + MapLoanSale_ProductSelection.verifytypeOfCredit(), 1);
		Verify.verifyEquals(MapLoanSale_ProductSelection.verifytypeOfCredit(), "Fixed sum loan");

		/*if (MapLoanSale_ProductSelection.verifytotalAmmountCredit().equals("£1,000:00"))
			setAssertMessage("verify ammount of credit " + MapLoanSale_ProductSelection.verifytotalAmmountCredit(), 2);
		Verify.verifyEquals(MapLoanSale_ProductSelection.verifytotalAmmountCredit(), "£1,000:00");*/

		if (MapLoanSale_ProductSelection.verifyDurationCredit().equals("33   Weeks\nMonths"))
			setAssertMessage("verify duration of credit " + MapLoanSale_ProductSelection.verifyDurationCredit(), 3);
		Verify.verifyEquals(MapLoanSale_ProductSelection.verifyDurationCredit(), "33   Weeks\nMonths");

		/*
		 * if (MapLoanSale_ProductSelection.verifynoOfPayable().
		 * equals("33   Weeks\nMonths"))
		 * setAssertMessage("verify no of payable "
		 * +MapLoanSale_ProductSelection.verifynoOfPayable(), 4);
		 * Verify.verifyEquals(MapLoanSale_ProductSelection.verifynoOfPayable(),
		 * "33   Weeks\nMonths");
		 */
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(5);
		MAPfunctions.switchContext("WEBVIEW");
		MapLoanSale_ProductSelection.clickLoanAgreementNext();
		MapLoanSale_ProductSelection.clickAcceptTermsCondition();
		MapLoanSale_ProductSelection.enterCustomerSign();
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		// MapLoanSale_ProductSelection.enterCustomerSign();
		MapLoanSale_ProductSelection.clickLoanAgreementNext1();
		MapLoanSale_ProductSelection.enterAgentSign();
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		// MapLoanSale_ProductSelection.enterAgentSign();
		MapLoanSale_ProductSelection.clickLoanAgreement_AgentNext();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		if (MapLoanSale_ProductSelection.verifyLoanTransactionMessage()
				.equals("The loan transaction was successfully completed!"))
			setAssertMessage("Loan transaction message " + MapLoanSale_ProductSelection.verifyLoanTransactionMessage(),
					4);
		Verify.verifyEquals(MapLoanSale_ProductSelection.verifyLoanTransactionMessage(),
				"The loan transaction was successfully completed!");
		MapLoanSale_ProductSelection.clickOKTransaction();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		if (mapCustomerDetails.verifyAcccountNo().equals(mapCustomerDetails.CustomerID()+"/1"))
			setAssertMessage("Verify Acount No " + mapCustomerDetails.verifyAcccountNo(), 5);
		Verify.verifyEquals(mapCustomerDetails.verifyAcccountNo(), mapCustomerDetails.CustomerID()+"/1");

		
		/*if (mapCustomerDetails.verifyPrincipalLoanValue().equals("1,000.00"))
			setAssertMessage("Principal loan value " + mapCustomerDetails.verifyPrincipalLoanValue(), 5);
		Verify.verifyEquals(mapCustomerDetails.verifyPrincipalLoanValue(), "1,000.00");

		if (mapCustomerDetails.verifyTermsWks().equals("33"))
			setAssertMessage("Terms week " + mapCustomerDetails.verifyTermsWks(), 6);
		Verify.verifyEquals(mapCustomerDetails.verifyTermsWks(), "33");

		if (mapCustomerDetails.verifyTotalAmmountPayable().equals("1,650.00"))
			setAssertMessage("Total Amount Payable " + mapCustomerDetails.verifyTotalAmmountPayable(), 7);
		Verify.verifyEquals(mapCustomerDetails.verifyTotalAmmountPayable(), "1,650.00");

		if (mapCustomerDetails.verifyWeeklyRate().equals("50.00"))
			setAssertMessage("Total Amount Payable " + mapCustomerDetails.verifyWeeklyRate(), 8);
		Verify.verifyEquals(mapCustomerDetails.verifyWeeklyRate(), "50.00");

		if (mapCustomerDetails.verifyAccountPerformancePercentage().equals("100%"))
			setAssertMessage(
					"Account Performance Percentage " + mapCustomerDetails.verifyAccountPerformancePercentage(), 9);
		Verify.verifyEquals(mapCustomerDetails.verifyAccountPerformancePercentage(), "100%");*/

		
		MAPClientList.clickHamburger();
		MAPClientList.clickViewAllSales();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPViewAllSales MAPViewAllSales= new MAPViewAllSales(getAndroidDriver());
		
		if (MAPViewAllSales.getLoanSalesCustomerID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "208", 1)).equals(customerID))
			setAssertMessage(
					"Customer ID At View All Sales  " + MAPViewAllSales.getLoanSalesCustomerID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "208", 1)), 9);
		Verify.verifyEquals(MAPViewAllSales.getLoanSalesCustomerID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "208", 1)), customerID);

		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

		System.out.println("Login Sucessful");
	}

	//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "ClientList" },priority = 2)
	@Parameters({ "environment", "clientName" })
	public void VerifyClientDetailsTC209(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
		String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
		MAPLoginPage.EnterLoginID(userName);
		MAPLoginPage.EnterPassword(password);
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 120);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		// wait.until(ExpectedConditions.visibilityOf(MAPClientList.territory));
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickAutoTestCuts();
		MAPCustomerDetails mapCustomerDetails = new MAPCustomerDetails(getAndroidDriver());
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(mapCustomerDetails.loanSale));
		if (mapCustomerDetails.verifyPrincipalLoanValue().equals("1,000.00"))
			setAssertMessage("Principal loan value " + mapCustomerDetails.verifyPrincipalLoanValue(), 5);
		Verify.verifyEquals(mapCustomerDetails.verifyPrincipalLoanValue(), "1,000.00");

		if (mapCustomerDetails.verifyTermsWks().equals("33"))
			setAssertMessage("Terms week " + mapCustomerDetails.verifyTermsWks(), 6);
		Verify.verifyEquals(mapCustomerDetails.verifyTermsWks(), "33");

		if (mapCustomerDetails.verifyTotalAmmountPayable().equals("1,650.00"))
			setAssertMessage("Total Amount Payable " + mapCustomerDetails.verifyTotalAmmountPayable(), 7);
		Verify.verifyEquals(mapCustomerDetails.verifyTotalAmmountPayable(), "1,650.00");

		if (mapCustomerDetails.verifyWeeklyRate().equals("50.00"))
			setAssertMessage("Total Amount Payable " + mapCustomerDetails.verifyWeeklyRate(), 8);
		Verify.verifyEquals(mapCustomerDetails.verifyWeeklyRate(), "50.00");

		if (mapCustomerDetails.verifyAccountPerformancePercentage().equals("100%"))
			setAssertMessage(
					"Account Performance Percentage " + mapCustomerDetails.verifyAccountPerformancePercentage(), 9);
		Verify.verifyEquals(mapCustomerDetails.verifyAccountPerformancePercentage(), "100%");

		if (mapCustomerDetails.verifyCustomerAccountDetails("Principal Loan Value (£)").equals("1,000.00"))
			setAssertMessage(
					"Principal Loan Value (£) " + mapCustomerDetails.verifyCustomerAccountDetails("Principal Loan Value (£)"), 9);
		Verify.verifyEquals(mapCustomerDetails.verifyCustomerAccountDetails("Principal Loan Value (£)"), "1,000.00");

		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

	}

	//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "ClientList" },priority = 3)
	@Parameters({ "environment", "clientName" })
	public void CancelLoanofcustomerTC210(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
		String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
		MAPLoginPage.EnterLoginID(userName);
		MAPLoginPage.EnterPassword(password);
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 120);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		//MAPClientList.clickAutoTestCuts();
		MAPClientList.clickAutoCustomer(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "210", 1));
		MAPCustomerDetails mapCustomerDetails = new MAPCustomerDetails(getAndroidDriver());
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(mapCustomerDetails.loanSale));
		Assert.assertFalse(!mapCustomerDetails.CancelLoan.isEnabled());
		mapCustomerDetails.clickCanbcelLoan();
		Thread.sleep(2000);
		mapCustomerDetails.clickFristRowLoan();
		wait.until(ExpectedConditions.elementToBeClickable(mapCustomerDetails.confirmcancellationbutton));
		mapCustomerDetails.clickconfirmcancellationbutton();
		mapCustomerDetails.clickConfirmCancelLoan();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		
		mapCustomerDetails.clickHistoryTab();
		/*if (mapCustomerDetails.gettextselectFirstRowHistoryTab().equals(CommonFunctions.NowDate()+" Loan Cancellation £1,000.00"))
			setAssertMessage(
					"Loan cancellation status " + mapCustomerDetails.gettextselectFirstRowHistoryTab(), 1);
		Verify.verifyEquals(mapCustomerDetails.gettextselectFirstRowHistoryTab(), CommonFunctions.NowDate()+ " Loan Cancellation  £1,000.00");*/
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
	
	//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "ClientList" })
	@Parameters({ "environment", "clientName" })
	public void CashLoanPaymentTC215(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
		String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
		MAPLoginPage.EnterLoginID(userName);
		MAPLoginPage.EnterPassword(password);
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 120);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPCashReconcillation MAPCashReconcillation=new MAPCashReconcillation(getAndroidDriver());
		String totalCashCollected = MAPCashReconcillation.verifTotalCASHCollectedAmount();
		totalCashCollected=totalCashCollected.replaceFirst("£", "");
		String TotalCollections= MAPCashReconcillation.TotalCollectionsAmmount();
		TotalCollections=TotalCollections.replaceFirst("£", "");
		MAPClientList.clickHamburger();
		MAPClientList.clickClientList();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		//MAPClientList.SearchCustomer("NATALIE GEARY");
		MAPClientList.clickAutoCustomer(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "215", 1));
		MAPCustomerDetails mapCustomerDetails = new MAPCustomerDetails(getAndroidDriver());
		wait.until(ExpectedConditions.elementToBeClickable(mapCustomerDetails.loanSale));
		/*String currentLoanBalance= mapCustomerDetails.verifyCustomerAccountDetails("Current Loan Balance (£)");
		String EarlySettlementBalance= mapCustomerDetails.verifyCustomerAccountDetails("Early Settlement Balance of the Loan (£)");*/
		
		String currentLoanBalance= mapCustomerDetails.verifyCurrentLoanBalance();
		String EarlySettlementBalance= mapCustomerDetails.verifyEarlySettlementBalance();
		
		if(currentLoanBalance.contains(","))
		{
			currentLoanBalance=currentLoanBalance.replaceAll(",", "");
		}
		if(EarlySettlementBalance.contains(","))
		{
			EarlySettlementBalance=EarlySettlementBalance.replaceAll(",", "");
		}
		mapCustomerDetails.clickPaymentButton();
		mapCustomerDetails.selectPaymentType(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "215", 2));
		mapCustomerDetails.selectPaymentMethod(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "215", 3));
		mapCustomerDetails.enterPaymentAmmount(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "215", 4));
		mapCustomerDetails.enterPaymentAccountAmmount(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "215", 5));
		mapCustomerDetails.clickconfirmCustomerPayment();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		Double loanBalance= Double.valueOf(currentLoanBalance)-Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "215", 4));

		DecimalFormat formatter = new DecimalFormat("#,###.00");
		
		Double SettlementBalance= Double.valueOf(EarlySettlementBalance)-Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "215", 4));
		/*if (mapCustomerDetails.verifyCustomerAccountDetails("Current Loan Balance (£)").equals(formatter.format(loanBalance)))
			setAssertMessage(
					"Current Loan Balance  " + mapCustomerDetails.verifyCustomerAccountDetails("Current Loan Balance (£)"), 1);
		Verify.verifyEquals(mapCustomerDetails.verifyCustomerAccountDetails("Current Loan Balance (£)"), formatter.format(loanBalance));
		
		if (mapCustomerDetails.verifyCustomerAccountDetails("Early Settlement Balance of the Loan (£)").equals(formatter.format(SettlementBalance)))
			setAssertMessage(
					"Early Settlement Balance of the Loan  " + mapCustomerDetails.verifyCustomerAccountDetails("Early Settlement Balance of the Loan (£)"), 2);
		Verify.verifyEquals(mapCustomerDetails.verifyCustomerAccountDetails("Early Settlement Balance of the Loan (£)"), formatter.format(SettlementBalance));
		
		if (mapCustomerDetails.verifyCustomerAccountDetails("Date of Last Payment").equals(CommonFunctions.NowDate()))
			setAssertMessage(
					"Date of Last Payment " + mapCustomerDetails.verifyCustomerAccountDetails("Date of Last Payment"), 3);
		Verify.verifyEquals(mapCustomerDetails.verifyCustomerAccountDetails("Date of Last Payment"), CommonFunctions.NowDate());*/
		
		if (mapCustomerDetails.verifyCurrentLoanBalance().equals(formatter.format(loanBalance)))
			setAssertMessage(
					"Current Loan Balance  " + mapCustomerDetails.verifyCurrentLoanBalance(), 1);
		Verify.verifyEquals(mapCustomerDetails.verifyCurrentLoanBalance(), formatter.format(loanBalance));
		
		if (mapCustomerDetails.verifyEarlySettlementBalance().equals(formatter.format(SettlementBalance)))
			setAssertMessage(
					"Early Settlement Balance of the Loan  " + mapCustomerDetails.verifyEarlySettlementBalance(), 2);
		Verify.verifyEquals(mapCustomerDetails.verifyEarlySettlementBalance(), formatter.format(SettlementBalance));
		
		if (mapCustomerDetails.verifyDateOfLastPayment().equals(CommonFunctions.NowDate()))
			setAssertMessage(
					"Date of Last Payment " + mapCustomerDetails.verifyDateOfLastPayment(), 3);
		Verify.verifyEquals(mapCustomerDetails.verifyDateOfLastPayment(), CommonFunctions.NowDate());
		
		mapCustomerDetails.clickcloseCustomerDetails();
		MAPClientList.clickHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		Double cashCollected=Double.valueOf(totalCashCollected)+Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "215", 5));
		Double totalCollection=Double.valueOf(TotalCollections)+Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "215", 5));
		
		//if (MAPCashReconcillation.verifTotalCASHCollectedAmount().equals(String.valueOf(cashCollected)))
		if (MAPCashReconcillation.verifTotalCASHCollectedAmount().equals("£"+formatter.format(cashCollected)))
			setAssertMessage(
					"Total Cash Collected " + MAPCashReconcillation.verifTotalCASHCollectedAmount(), 4);
		Verify.verifyEquals(MAPCashReconcillation.verifTotalCASHCollectedAmount(), "£"+formatter.format(cashCollected));
		
		if (MAPCashReconcillation.TotalCollectionsAmmount().equals("£"+formatter.format(totalCollection)))
			setAssertMessage(
					"Total Collection " + MAPCashReconcillation.TotalCollectionsAmmount(), 5);
		Verify.verifyEquals(MAPCashReconcillation.TotalCollectionsAmmount(), "£"+formatter.format(totalCollection));
		
		MAPCashReconcillation.clickViewAlltodaypayments();
		if (MAPCashReconcillation.VerifyPaymentInViewTodaysPayment(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "215", 1)).equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "215", 4)))
			setAssertMessage("Payment Verified in View All Today's Payments " , 6);
		Verify.verifyEquals(MAPCashReconcillation.VerifyPaymentInViewTodaysPayment(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "215", 1)), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "215", 4));
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
	
	//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = {"Regression", "MAP", "ClientList" },priority = 1)
	@Parameters({ "environment", "clientName" })
	public void EditCustomerConfirmTC227(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		MAPLoginPage.EnterLoginID(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "227", 1));
		MAPLoginPage.EnterPassword(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "227", 2));
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);

		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 120);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		//wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		wait.until(ExpectedConditions.elementToBeClickable(MAPLoginPage.LogoutTerritory));
		MAPLoginPage.clickTerritoryNo(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "227", 3));
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickAutoCustomer(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "227", 4));
		MAPCustomerDetailsEdit MAPCustomerDetailsEdit = new MAPCustomerDetailsEdit(getAndroidDriver());
		MAPCustomerDetailsEdit.clickEditCustomerDetails();
		MAPCustomerDetailsEdit.enterStreetName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "227", 5));
		MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPageByHeight(4);
		//MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MAPCustomerDetailsEdit.enterCountryName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "227", 6));
		MAPCustomerDetailsEdit.enterMobileNo(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "227", 7));
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPageByHeight(4);
		//MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MAPCustomerDetailsEdit.enterNINumber(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "227", 8));
		MAPCustomerDetailsEdit.selectNationality(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "227", 9));
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPageByHeight(4);
		//MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MAPCustomerDetailsEdit.clickConfirmCustomerDetailsButton();
		MAPCustomerDetailsEdit.clickConfirmModalButton();
		MAPCustomerDetails MAPCustomerDetails= new MAPCustomerDetails(getAndroidDriver());
		
		if (MAPCustomerDetails.customerPhone().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "227", 7)))
			setAssertMessage("Verified Customer Mobile Phone  " + MAPCustomerDetails.customerPhone(), 1);
		Verify.verifyEquals(MAPCustomerDetails.customerPhone(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "227", 7));
		
		if (MAPCustomerDetails.street().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "227", 5)))
			setAssertMessage("Verified Customer Street   " + MAPCustomerDetails.street(), 1);
		Verify.verifyEquals(MAPCustomerDetails.street(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "227", 5));
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
	
	//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = {"Regression", "MAP", "ClientList" },priority = 1)
	@Parameters({ "environment", "clientName" })
	public void EditCustomerConfirmNoTC228(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		MAPLoginPage.EnterLoginID(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "228", 1));
		MAPLoginPage.EnterPassword(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "228", 2));
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);

		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 360);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		//wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		wait.until(ExpectedConditions.elementToBeClickable(MAPLoginPage.LogoutTerritory));
		MAPLoginPage.clickTerritoryNo(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "228", 3));
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickAutoCustomer(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "228", 4));
		MAPCustomerDetailsEdit MAPCustomerDetailsEdit = new MAPCustomerDetailsEdit(getAndroidDriver());
		MAPCustomerDetailsEdit.clickEditCustomerDetails();
		MAPCustomerDetailsEdit.enterStreetName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "228", 5));
		MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPageByHeight(4);
		//MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MAPCustomerDetailsEdit.enterCountryName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "228", 6));
		MAPCustomerDetailsEdit.enterMobileNo(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "228", 7));
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPageByHeight(4);
		//MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MAPCustomerDetailsEdit.enterNINumber(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "228", 8));
		MAPCustomerDetailsEdit.selectNationality(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "228", 9));
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPageByHeight(4);
		//MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MAPCustomerDetailsEdit.clickConfirmCustomerDetailsButton();
		MAPCustomerDetailsEdit.clickCancelModalButton();
		
		if (MAPCustomerDetailsEdit.VerifyConfirmCustomerDetailsButton().equals("Confirm"))
			setAssertMessage("Verified Confirm button displaed  " + MAPCustomerDetailsEdit.VerifyConfirmCustomerDetailsButton(), 1);
		Verify.verifyEquals(MAPCustomerDetailsEdit.VerifyConfirmCustomerDetailsButton(),"Confirm");
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
	
	//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = {"Regression", "MAP", "ClientList" },priority = 1)
	@Parameters({ "environment", "clientName" })
	public void EditCustomerDetailsCloseTC229(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		MAPLoginPage.EnterLoginID(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "228", 1));
		MAPLoginPage.EnterPassword(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "228", 2));
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);

		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 360);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		//wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		wait.until(ExpectedConditions.elementToBeClickable(MAPLoginPage.LogoutTerritory));
		MAPLoginPage.clickTerritoryNo(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "229", 3));
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickAutoCustomer(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "229", 4));
		MAPCustomerDetailsEdit MAPCustomerDetailsEdit = new MAPCustomerDetailsEdit(getAndroidDriver());
		MAPCustomerDetailsEdit.clickEditCustomerDetails();
		MAPCustomerDetailsEdit.enterFlatNo(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "229", 5));
		MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(2);
		MAPfunctions.switchContext("WEBVIEW");
		MAPCustomerDetailsEdit.clickCloseEditCustomerDetailsButton();
		MAPCustomerDetailsEdit.clickEditCustomerDetails();
		
		if (!MAPCustomerDetailsEdit.verifyFlatNo().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "229", 5)))
			setAssertMessage("Closed Functionality checked  ", 1);
		Verify.verifyNotEquals(MAPCustomerDetailsEdit.verifyFlatNo(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "229", 5));
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
	
	//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = {"Regression", "MAP", "ClientList" },priority = 1)
		@Parameters({ "environment", "clientName" })
		public void CustomerEligibilityTC230(String environment, String clientName) throws InterruptedException {
			MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
			String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
			String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
			MAPLoginPage.EnterLoginID(userName);
			MAPLoginPage.EnterPassword(password);
			MAPLoginPage.clickLogIn();
			Thread.sleep(30000);
			WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 420);
			MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
			wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
			MAPClientList.clickAutoCustomer(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "230", 1));
			MAPCustomerDetails mapCustomerDetails = new MAPCustomerDetails(getAndroidDriver());
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(mapCustomerDetails.loanSale));
			String customerID=mapCustomerDetails.CustomerID();
			mapCustomerDetails.clickloanSale();
			if (mapCustomerDetails.verifyAlertMsg().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "230", 2)))
				setAssertMessage("Eligibility Warning message  " + mapCustomerDetails.verifyAlertMsg(), 1);
			Verify.verifyEquals(mapCustomerDetails.verifyAlertMsg(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "230", 2));
			
			mapCustomerDetails.clickAlertCloseButton();
			
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
		}
	
	//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = {"Regression", "MAP", "ClientList" },priority = 1)
	@Parameters({ "environment", "clientName" })
	public void ClientLiatSearchTC231(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
		String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
		MAPLoginPage.EnterLoginID(userName);
		MAPLoginPage.EnterPassword(password);
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 480);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.SearchClient(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "231", 1));
		
		if (MAPClientList.verifyClientInSearch(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx","MapTestData", "231", 2))
				.equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "231",3)))
			setAssertMessage("Client Name " + MAPClientList.verifyClientInSearch(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx","MapTestData", "231", 2)),
					1);
		Verify.verifyEquals(MAPClientList.verifyClientInSearch(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx","MapTestData", "231", 2)),
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "231", 3));

		MAPClientList.clickSearchBackButton();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickHamburger();
		MAPClientList.clickLogout();
		wait.until(ExpectedConditions.visibilityOf(MAPLoginPage.logo));
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
	
	//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "ClientList" },priority = 3)
	@Parameters({ "environment", "clientName" })
	public void CancelLoanofcustomerTC232(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
		String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
		MAPLoginPage.EnterLoginID(userName);
		MAPLoginPage.EnterPassword(password);
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 120);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		//MAPClientList.clickAutoTestCuts();
		MAPClientList.clickAutoCustomer(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "232", 1));
		MAPCustomerDetails mapCustomerDetails = new MAPCustomerDetails(getAndroidDriver());
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(mapCustomerDetails.loanSale));
		Assert.assertFalse(!mapCustomerDetails.CancelLoan.isEnabled());
		mapCustomerDetails.clickCanbcelLoan();
		Thread.sleep(2000);
		mapCustomerDetails.clickFristRowLoan();
		String AccountNo= mapCustomerDetails.verifyFristRowLoanAccountNo();
		
		wait.until(ExpectedConditions.elementToBeClickable(mapCustomerDetails.confirmcancellationbutton));
		mapCustomerDetails.clickconfirmcancellationbutton();
		mapCustomerDetails.clickCancelCancelLoan();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		
		if (mapCustomerDetails.verifyFristRowLoanAccountNo().equals(AccountNo))
		setAssertMessage("Cancel Loan of a customer-->Cancel Confirmation Popup functionality vrified " , 1);
	Verify.verifyEquals(mapCustomerDetails.verifyFristRowLoanAccountNo(), AccountNo);
	
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
	
		//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "ClientList" })
		@Parameters({ "environment", "clientName" })
		public void CashLoanPaymentCancelTC233(String environment, String clientName) throws InterruptedException {
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
			String totalCashCollected = MAPCashReconcillation.verifTotalCASHCollectedAmount();
			/*totalCashCollected=totalCashCollected.replaceFirst("£", "");
			String TotalCollections= MAPCashReconcillation.TotalCollectionsAmmount();
			TotalCollections=TotalCollections.replaceFirst("£", "");*/
			MAPClientList.clickHamburger();
			MAPClientList.clickClientList();
			wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
			//MAPClientList.SearchCustomer("NATALIE GEARY");
			MAPClientList.clickAutoCustomer(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "233", 1));
			MAPCustomerDetails mapCustomerDetails = new MAPCustomerDetails(getAndroidDriver());
			wait.until(ExpectedConditions.elementToBeClickable(mapCustomerDetails.loanSale));
			String currentLoanBalance= mapCustomerDetails.verifyCurrentLoanBalance();
			String EarlySettlementBalance= mapCustomerDetails.verifyEarlySettlementBalance();
			/*if(currentLoanBalance.contains(","))
			{
				currentLoanBalance=currentLoanBalance.replaceAll(",", "");
			}
			if(EarlySettlementBalance.contains(","))
			{
				EarlySettlementBalance=EarlySettlementBalance.replaceAll(",", "");
			}*/
			mapCustomerDetails.clickPaymentButton();
			mapCustomerDetails.selectPaymentType(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "233", 2));
			mapCustomerDetails.selectPaymentMethod(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "233", 3));
			mapCustomerDetails.enterPaymentAmmount(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "233", 4));
			mapCustomerDetails.enterPaymentAccountAmmount(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "233", 5));
			mapCustomerDetails.clickCloseCustomerPayment();
			wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
			/*
			Double loanBalance= Double.valueOf(currentLoanBalance)-Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "215", 4));

			DecimalFormat formatter = new DecimalFormat("#.00");
			
			Double SettlementBalance= Double.valueOf(EarlySettlementBalance)-Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "215", 4));*/
			
			if (mapCustomerDetails.verifyCurrentLoanBalance().equals(currentLoanBalance))
				setAssertMessage("Current Loan Balance  " + mapCustomerDetails.verifyCurrentLoanBalance(), 1);
			Verify.verifyEquals(mapCustomerDetails.verifyCurrentLoanBalance(), currentLoanBalance);
			
			if (mapCustomerDetails.verifyEarlySettlementBalance().equals(EarlySettlementBalance))
				setAssertMessage("Early Settlement Balance of the Loan  " + mapCustomerDetails.verifyEarlySettlementBalance(), 2);
			Verify.verifyEquals(mapCustomerDetails.verifyEarlySettlementBalance(), EarlySettlementBalance);
			
			mapCustomerDetails.clickcloseCustomerDetails();
			MAPClientList.clickHamburger();
			MAPClientList.clickCashReconciliation();
			wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
			/*Double cashCollected=Double.valueOf(totalCashCollected)+Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "215", 5));
			Double totalCollection=Double.valueOf(TotalCollections)+Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "215", 5));*/
			
			//if (MAPCashReconcillation.verifTotalCASHCollectedAmount().equals(String.valueOf(cashCollected)))
			if (MAPCashReconcillation.verifTotalCASHCollectedAmount().equals(totalCashCollected))
				setAssertMessage("Total Cash Collected " + MAPCashReconcillation.verifTotalCASHCollectedAmount(), 3);
			Verify.verifyEquals(MAPCashReconcillation.verifTotalCASHCollectedAmount(), totalCashCollected);
			
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		}
		
		//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = {"Regression", "MAP", "ClientList" },priority = 1)
		@Parameters({ "environment", "clientName" })
		public void CustomerAgentNotesTC234(String environment, String clientName) throws InterruptedException {
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
			Thread.sleep(3000);
			MAPClientList.clickAutoCustomer(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "234", 1));
			MAPCustomerDetails mapCustomerDetails = new MAPCustomerDetails(getAndroidDriver());
			wait.until(ExpectedConditions.elementToBeClickable(mapCustomerDetails.loanSale));
			mapCustomerDetails.clickNotesTab();
			mapCustomerDetails.clickNote();
			mapCustomerDetails.EnternewNoteDescription(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "234", 2));
			mapCustomerDetails.clickConfirmNote();
			/*DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy | hh:mm a");
			Date date = new Date();
			System.out.println("current date "+dateFormat.format(date));
			String currentDate=dateFormat.format(date).toLowerCase();
			
			String currentDate1=dateFormat.format(DateUtils.addMinutes(date, 1)).toLowerCase();
			System.out.println("currentDate"+currentDate);
			System.out.println("currentDate1"+currentDate1);
			
			if (mapCustomerDetails.verifyNoteTimeFormat().equals(currentDate) || mapCustomerDetails.verifyNoteTimeFormat().equals(currentDate1))
				setAssertMessage("Notes saved successfully", 1);
			Verify.verifyEquals(mapCustomerDetails.verifyNoteTimeFormat(), currentDate);*/
			Thread.sleep(3000);
			mapCustomerDetails.clickFirstNote();
			System.out.println("Saved Notes"+mapCustomerDetails.verifySavedNotes());
			if (mapCustomerDetails.verifySavedNotes().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "234", 2)))
				setAssertMessage("Notes saved successfully", 1);
			Verify.verifyEquals(mapCustomerDetails.verifySavedNotes(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "234", 2));
			
			mapCustomerDetails.clickCloseNotes();
			
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
		}
		
		//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = {"Regression", "MAP", "ClientList" },priority = 1)
		@Parameters({ "environment", "clientName" })
		public void CallbackFunctionalityTC237(String environment, String clientName) throws InterruptedException {
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
			Thread.sleep(3000);
			MAPClientList.clickAutoCustomer(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "237", 1));
			MAPCustomerDetails mapCustomerDetails = new MAPCustomerDetails(getAndroidDriver());
			wait.until(ExpectedConditions.elementToBeClickable(mapCustomerDetails.loanSale));
			mapCustomerDetails.clickCallback();
			LocalDate today = LocalDate.now();
	        System.out.println("Current date: " + today);

	        //add 1 day to the current date
	        LocalDate date1Day = today.plus(1, ChronoUnit.DAYS);
	        System.out.println("Date After 1 day : " + date1Day); 
	        
	        mapCustomerDetails.selectCallbackDate(date1Day.toString());
	        mapCustomerDetails.clickConfirmCallback();
	        mapCustomerDetails.clickcloseCustomerDetails();
	    	wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
	    	mapCustomerDetails.clickCustomerDate(date1Day.toString());
	    	wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
	    	if (mapCustomerDetails.verifyCallbackStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "237", 1)).equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "237", 2)))
				setAssertMessage("Customer CallBack Functionality verified as "+mapCustomerDetails.verifyCallbackStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "237", 1)) , 1);
			Verify.verifyEquals(mapCustomerDetails.verifyCallbackStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "237", 1)), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "237", 2));
	    	
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
		}
		
		//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = {"Regression", "MAP", "ClientList" },priority = 1,dependsOnMethods={"CallbackFunctionalityTC237"})
		@Parameters({ "environment", "clientName" })
		public void CallbackDeleteTC238(String environment, String clientName) throws InterruptedException {
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
			Thread.sleep(3000);
			LocalDate today = LocalDate.now();
	        System.out.println("Current date: " + today);
	        LocalDate date1Day = today.plus(1, ChronoUnit.DAYS);
	        System.out.println("Date After 1 day : " + date1Day); 
	        MAPCustomerDetails mapCustomerDetails = new MAPCustomerDetails(getAndroidDriver());
	    	mapCustomerDetails.clickCustomerDate(date1Day.toString());
	    	wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
			MAPClientList.clickAutoCustomer(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "238", 1));
			wait.until(ExpectedConditions.elementToBeClickable(mapCustomerDetails.loanSale));
			mapCustomerDetails.clickCallback();
	        mapCustomerDetails.clickDeleteCallback();
	        mapCustomerDetails.clickcloseCustomerDetails();
	    	wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
	    	
	    	if (mapCustomerDetails.verifyCallbackStatus_ActionRequired(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "238", 1)).equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "238", 2)))
				setAssertMessage("Customer CallBack Delete Functionality verified as "+mapCustomerDetails.verifyCallbackStatus_ActionRequired(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "238", 1)) , 1);
			Verify.verifyEquals(mapCustomerDetails.verifyCallbackStatus_ActionRequired(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "238", 1)), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "238", 2));
	    	
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		}
		
		//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = {"Regression", "MAP", "ClientList" },priority = 1)
		@Parameters({ "environment", "clientName" })
		public void CallbackCancelTC239(String environment, String clientName) throws InterruptedException {
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
			Thread.sleep(3000);
			MAPClientList.clickAutoCustomer(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "239", 1));
			MAPCustomerDetails mapCustomerDetails = new MAPCustomerDetails(getAndroidDriver());
			wait.until(ExpectedConditions.elementToBeClickable(mapCustomerDetails.loanSale));
			String CallbackBefore=mapCustomerDetails.verifyCallbackText();
			mapCustomerDetails.clickCallback();
			LocalDate today = LocalDate.now();
	        System.out.println("Current date: " + today);

	        //add 1 day to the current date
	        LocalDate date1Day = today.plus(1, ChronoUnit.DAYS);
	        System.out.println("Date After 1 day : " + date1Day); 
	        
	        mapCustomerDetails.selectCallbackDate(date1Day.toString());
	        mapCustomerDetails.clickCancelCallback();
	        
	        if (mapCustomerDetails.verifyCallbackText().equals(CallbackBefore))
				setAssertMessage("Customer CallBack cancel Functionality verified " , 1);
			Verify.verifyEquals(mapCustomerDetails.verifyCallbackText(), CallbackBefore);
			
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		}
		
		//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "ClientList" })
		@Parameters({ "environment", "clientName" })
		public void AdjustPaymentTC240(String environment, String clientName) throws InterruptedException {
			MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
			String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
			String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
			MAPLoginPage.EnterLoginID(userName);
			MAPLoginPage.EnterPassword(password);
			MAPLoginPage.clickLogIn();
			Thread.sleep(30000);
			WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 240);
			MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
			Thread.sleep(3000);
			wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
			MAPClientList.clickAutoCustomer(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "240", 1));
			MAPCustomerDetails mapCustomerDetails = new MAPCustomerDetails(getAndroidDriver());
			wait.until(ExpectedConditions.elementToBeClickable(mapCustomerDetails.loanSale));
			String currentLoanBalance= mapCustomerDetails.verifyCurrentLoanBalance();
			String EarlySettlementBalance= mapCustomerDetails.verifyEarlySettlementBalance();
			if(currentLoanBalance.contains(","))
			{
				currentLoanBalance=currentLoanBalance.replaceAll(",", "");
			}
			if(EarlySettlementBalance.contains(","))
			{
				EarlySettlementBalance=EarlySettlementBalance.replaceAll(",", "");
			}
			mapCustomerDetails.clickPaymentButton();
			mapCustomerDetails.selectPaymentType(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "240", 2));
			mapCustomerDetails.selectPaymentMethod(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "240", 3));
			mapCustomerDetails.enterPaymentAmmount(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "240", 4));
			mapCustomerDetails.enterPaymentAccountAmmount(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "240", 5));
			mapCustomerDetails.clickconfirmCustomerPayment();
			wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
			Double loanBalance= Double.valueOf(currentLoanBalance)-Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "240", 4));

			DecimalFormat formatter = new DecimalFormat("#,###.00");
			
			Double SettlementBalance= Double.valueOf(EarlySettlementBalance)-Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "240", 4));
			if (mapCustomerDetails.verifyCurrentLoanBalance().equals(formatter.format(loanBalance)))
				setAssertMessage("Current Loan Balance on First payment  " + mapCustomerDetails.verifyCurrentLoanBalance(), 1);
			Verify.verifyEquals(mapCustomerDetails.verifyCurrentLoanBalance(), formatter.format(loanBalance));
			
			if (mapCustomerDetails.verifyEarlySettlementBalance().equals(formatter.format(SettlementBalance)))
				setAssertMessage("Early Settlement Balance on First Payment  " + mapCustomerDetails.verifyEarlySettlementBalance(), 2);
			Verify.verifyEquals(mapCustomerDetails.verifyEarlySettlementBalance(), formatter.format(SettlementBalance));
			
			mapCustomerDetails.clickTpaymentsTab();
			mapCustomerDetails.clickAdjustPaymentButton();
			mapCustomerDetails.enterAdjustPaymentAmount(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "240", 6));
			mapCustomerDetails.clickAdjustPaymentsConfirmButton();
			wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
			mapCustomerDetails.clickAccountTab();
			
			Double loanBalanceAdjust= Double.valueOf(currentLoanBalance)-Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "240", 6));
			Double SettlementBalanceAdjust= Double.valueOf(EarlySettlementBalance)-Double.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "240", 6));
			
			if (mapCustomerDetails.verifyCurrentLoanBalance().equals(formatter.format(loanBalanceAdjust)))
				setAssertMessage("Current Loan Balance on After Adjust payment  " + mapCustomerDetails.verifyCurrentLoanBalance(), 3);
			Verify.verifyEquals(mapCustomerDetails.verifyCurrentLoanBalance(), formatter.format(loanBalanceAdjust));
			
			if (mapCustomerDetails.verifyEarlySettlementBalance().equals(formatter.format(SettlementBalanceAdjust)))
				setAssertMessage("Early Settlement Balance on After Adjust payment  " + mapCustomerDetails.verifyEarlySettlementBalance(), 4);
			Verify.verifyEquals(mapCustomerDetails.verifyEarlySettlementBalance(), formatter.format(SettlementBalanceAdjust));
			
			mapCustomerDetails.clickHistoryTab();
			if (mapCustomerDetails.gettextselectFirstRowHistoryTab().equals(CommonFunctions.NowDate()+" Payment £"+ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "240", 6)+" CASH"))
				setAssertMessage("Loan Adjustment status " + mapCustomerDetails.gettextselectFirstRowHistoryTab(), 5);
			Verify.verifyEquals(mapCustomerDetails.gettextselectFirstRowHistoryTab(), CommonFunctions.NowDate()+" Payment £"+ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "240", 6)+" CASH");
			
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		}
		
		//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = {"Regression", "MAP", "ClientList" },priority = 1)
		@Parameters({ "environment", "clientName" })
		public void EditCustomerTC241(String environment, String clientName) throws InterruptedException {
			MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
			MAPLoginPage.EnterLoginID(
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 1));
			MAPLoginPage.EnterPassword(
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 2));
			MAPLoginPage.clickLogIn();
			Thread.sleep(30000);

			WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 120);
			MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
			//wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
			wait.until(ExpectedConditions.elementToBeClickable(MAPLoginPage.LogoutTerritory));
			MAPLoginPage.clickTerritoryNo(
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 3));
			wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
			MAPClientList.clickAutoCustomer(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 4));
			MAPCustomerDetailsEdit MAPCustomerDetailsEdit = new MAPCustomerDetailsEdit(getAndroidDriver());
			MAPCustomerDetailsEdit.clickEditCustomerDetails();
			MAPCustomerDetailsEdit.enterStreetName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 5));
			MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
			MAPfunctions.switchContext("NATIVE");
			MAPfunctions.scrollPageByHeight(4);
			MAPfunctions.switchContext("WEBVIEW");
			MAPCustomerDetailsEdit.enterCountryName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 6));
			MAPCustomerDetailsEdit.enterTelephoneNo(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 7));
			MAPCustomerDetailsEdit.enterMobileNo(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 8));
			MAPCustomerDetailsEdit.enterEmail(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 9));
			MAPCustomerDetailsEdit.enterReEmail(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 10));
			MAPfunctions.switchContext("NATIVE");
			MAPfunctions.scrollPageByHeight(4);
			MAPfunctions.switchContext("WEBVIEW");
			MAPCustomerDetailsEdit.enterNINumber(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 11));
			MAPCustomerDetailsEdit.selectNationality(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 12));
			MAPfunctions.switchContext("NATIVE");
			MAPfunctions.scrollPageByHeight(4);
			MAPfunctions.switchContext("WEBVIEW");
			MAPCustomerDetailsEdit.clickConfirmCustomerDetailsButton();
			MAPCustomerDetailsEdit.clickConfirmModalButton();
			MAPClientList.clickHamburger();
			MAPClientList.clickLogout();
			
			MAPLoginPage.EnterLoginID(
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 13));
			MAPLoginPage.EnterPassword(
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 14));
			MAPLoginPage.clickLogIn();
			Thread.sleep(30000);
			wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
			MAPClientList.clickAutoCustomer(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 4));
			
			MAPCustomerDetails MAPCustomerDetails= new MAPCustomerDetails(getAndroidDriver());
			
			if (MAPCustomerDetails.customerPhone().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 8)))
				setAssertMessage("Verified Customer Mobile Phone  " + MAPCustomerDetails.customerPhone(), 1);
			Verify.verifyEquals(MAPCustomerDetails.customerPhone(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 8));
			
			if (MAPCustomerDetails.street().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 5)))
				setAssertMessage("Verified Customer Street   " + MAPCustomerDetails.street(), 2);
			Verify.verifyEquals(MAPCustomerDetails.street(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 5));
			
			MAPCustomerDetailsEdit.clickEditCustomerDetails();
			
			if (MAPCustomerDetailsEdit.VerifyCustomerNINumber().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 11)))
				setAssertMessage("Verified Customer NI Number   " + MAPCustomerDetailsEdit.VerifyCustomerNINumber(), 3);
			Verify.verifyEquals(MAPCustomerDetailsEdit.VerifyCustomerNINumber(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "241", 11));
			
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
		}
}
