package testscripts.e2e;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.text.DecimalFormat;
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
import pageobjects.cap.SearchCustAffordability;
import pageobjects.cap.SearchCustBusinessUnit;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchCustomerStatement;
import pageobjects.cap.ViewLeadsPage;
import pageobjects.map.MAPLoginPage;
import pageobjects.map.MAPSynchronization;
import pageobjects.map.MAPAffordability;
import pageobjects.map.MAPCashReconcillation;
import pageobjects.map.MAPClientList;
import pageobjects.map.MAPCustomerDetails;
import pageobjects.map.MAPLead;
import pageobjects.map.MAPLoanSale;
import pageobjects.map.MAPLoanSale_ProductSelection;
import helpers.MAPFunctions;

@Listeners(ListenerClass.class)
public class E2EPaymentScripts extends BaseClass {
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "E2E", "ClientList" })
	@Parameters({ "environment", "clientName" })
	public void E2EScenario182(String environment, String clientName) throws InterruptedException {

		/*
		 * CommonFunctions.Browser(); SearchCustomer Scustomer = new
		 * SearchCustomer(CommonFunctions.driver); SearchCustomerStatement
		 * ScustStat= new SearchCustomerStatement(CommonFunctions.driver);
		 * Scustomer = Scustomer.Customer(); Scustomer= Scustomer.setFN("PAUL");
		 * Scustomer= Scustomer.setSN("PITKIN"); Scustomer = Scustomer.Search();
		 * // String ID=Scustomer.CusIDClink.getText(); Scustomer =
		 * Scustomer.cusIDclick(); ScustStat.Statement();
		 * System.out.println(ScustStat.ResultE2E());
		 * if(ScustStat.ResultE2E().equals(CommonFunctions.NowDate()))
		 * setAssertMessage("Payment Done today in MAP is reflected in CAP" ,1);
		 * Verify.verifyEquals(ScustStat.ResultE2E(),CommonFunctions.NowDate());
		 * System.out.println(ScustStat.ResultE2ECredit());
		 * if(ScustStat.ResultE2ECredit().equals(ExcelUtilities.
		 * getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E",
		 * "182", 5)))
		 * setAssertMessage("CAsh payment debited is "+ScustStat.ResultE2ECredit
		 * () ,2); Verify.verifyEquals(ScustStat.ResultE2ECredit(),
		 * ExcelUtilities.getKeyValueFromExcelWithPosition(
		 * "TestCaseDataE2E.xlsx", "E2E", "182", 5));
		 */

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
		MAPCashReconcillation MAPCashReconcillation = new MAPCashReconcillation(getAndroidDriver());
		String totalCashCollected = MAPCashReconcillation.verifTotalCASHCollectedAmount();
		totalCashCollected = totalCashCollected.replaceFirst("£", "");
		String TotalCollections = MAPCashReconcillation.TotalCollectionsAmmount();
		TotalCollections = TotalCollections.replaceFirst("£", "");
		MAPClientList.clickHamburger();
		MAPClientList.clickClientList();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickAutoCustomer(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "182", 1));
		MAPCustomerDetails mapCustomerDetails = new MAPCustomerDetails(getAndroidDriver());
		wait.until(ExpectedConditions.elementToBeClickable(mapCustomerDetails.loanSale));
		/*
		 * String currentLoanBalance= mapCustomerDetails.
		 * verifyCustomerAccountDetails("Current Loan Balance (£)"); String
		 * EarlySettlementBalance= mapCustomerDetails.
		 * verifyCustomerAccountDetails("Early Settlement Balance of the Loan (£)"
		 * ); if(currentLoanBalance.contains(",")) {
		 * currentLoanBalance=currentLoanBalance.replaceAll(",", ""); }
		 * if(EarlySettlementBalance.contains(",")) {
		 * EarlySettlementBalance=EarlySettlementBalance.replaceAll(",", ""); }
		 */
		mapCustomerDetails.clickPaymentButton();
		mapCustomerDetails.selectPaymentType(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "182", 2));
		mapCustomerDetails.selectPaymentMethod(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "182", 3));
		mapCustomerDetails.enterPaymentAmmount(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "182", 4));
		mapCustomerDetails.enterPaymentAccountAmmount(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "182", 5));
		mapCustomerDetails.clickconfirmCustomerPayment();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		/*
		 * Double loanBalance=
		 * Double.valueOf(currentLoanBalance)-Double.valueOf(ExcelUtilities.
		 * getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E",
		 * "182", 4));
		 * 
		 * DecimalFormat formatter = new DecimalFormat("#.00");
		 * 
		 * Double SettlementBalance=
		 * Double.valueOf(EarlySettlementBalance)-Double.valueOf(ExcelUtilities.
		 * getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E",
		 * "182", 4));
		 */
		/*
		 * if (mapCustomerDetails.
		 * verifyCustomerAccountDetails("Current Loan Balance (£)").equals(
		 * formatter.format(loanBalance))) setAssertMessage(
		 * "Current Loan Balance  " + mapCustomerDetails.
		 * verifyCustomerAccountDetails("Current Loan Balance (£)"), 1);
		 * Verify.verifyEquals(mapCustomerDetails.
		 * verifyCustomerAccountDetails("Current Loan Balance (£)"),
		 * formatter.format(loanBalance));
		 * 
		 * if (mapCustomerDetails.
		 * verifyCustomerAccountDetails("Early Settlement Balance of the Loan (£)"
		 * ).equals(formatter.format(SettlementBalance))) setAssertMessage(
		 * "Early Settlement Balance of the Loan  " + mapCustomerDetails.
		 * verifyCustomerAccountDetails("Early Settlement Balance of the Loan (£)"
		 * ), 2); Verify.verifyEquals(mapCustomerDetails.
		 * verifyCustomerAccountDetails("Early Settlement Balance of the Loan (£)"
		 * ), formatter.format(SettlementBalance));
		 * 
		 * if (mapCustomerDetails.
		 * verifyCustomerAccountDetails("Date of Last Payment").equals(
		 * CommonFunctions.NowDate())) setAssertMessage( "Date of Last Payment "
		 * + mapCustomerDetails.
		 * verifyCustomerAccountDetails("Date of Last Payment"), 3);
		 * Verify.verifyEquals(mapCustomerDetails.
		 * verifyCustomerAccountDetails("Date of Last Payment"),
		 * CommonFunctions.NowDate());
		 */

		mapCustomerDetails.clickcloseCustomerDetails();
		MAPClientList.clickHamburger();
		MAPClientList.clickCashReconciliation();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		/*
		 * Double
		 * cashCollected=Double.valueOf(totalCashCollected)+Double.valueOf(
		 * ExcelUtilities.getKeyValueFromExcelWithPosition(
		 * "TestCaseDataE2E.xlsx", "E2E", "182", 5)); Double
		 * totalCollection=Double.valueOf(TotalCollections)+Double.valueOf(
		 * ExcelUtilities.getKeyValueFromExcelWithPosition(
		 * "TestCaseDataE2E.xlsx", "E2E", "182", 5));
		 */

		// if
		// (MAPCashReconcillation.verifTotalCASHCollectedAmount().equals(String.valueOf(cashCollected)))
		/*
		 * if (MAPCashReconcillation.verifTotalCASHCollectedAmount().equals("£"+
		 * formatter.format(cashCollected))) setAssertMessage(
		 * "Total Cash Collected " +
		 * MAPCashReconcillation.verifTotalCASHCollectedAmount(), 4);
		 * Verify.verifyEquals(MAPCashReconcillation.
		 * verifTotalCASHCollectedAmount(),
		 * "£"+formatter.format(cashCollected));
		 * 
		 * if
		 * (MAPCashReconcillation.TotalCollectionsAmmount().equals("£"+formatter
		 * .format(totalCollection))) setAssertMessage( "Total Collection " +
		 * MAPCashReconcillation.TotalCollectionsAmmount(), 5);
		 * Verify.verifyEquals(MAPCashReconcillation.TotalCollectionsAmmount(),
		 * "£"+formatter.format(totalCollection));
		 */

		CommonFunctions.Browser();
		SearchCustomer Scustomer = new SearchCustomer(CommonFunctions.driver);
		SearchCustomerStatement ScustStat = new SearchCustomerStatement(CommonFunctions.driver);
		Scustomer = Scustomer.Customer();
		/*Scustomer = Scustomer.setFN("Linda");
		Scustomer = Scustomer.setSN("Lloyd");*/
		Scustomer = Scustomer.setCID("08799705");
		Scustomer = Scustomer.Search();
		// String ID=Scustomer.CusIDClink.getText();
		Scustomer = Scustomer.cusIDclick();
		ScustStat.Statement();
		System.out.println(ScustStat.ResultE2E());
		if (ScustStat.ResultE2E().equals(CommonFunctions.NowDate()))
			setAssertMessage("Payment Done today in MAP is reflected in CAP", 1);
		Verify.verifyEquals(ScustStat.ResultE2E(), CommonFunctions.NowDate());
		System.out.println(ScustStat.ResultE2ECredit());
		if (ScustStat.ResultE2ECredit()
				.equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "182", 5)))
			setAssertMessage("CAsh payment debited is " + ScustStat.ResultE2ECredit(), 2);
		Verify.verifyEquals(ScustStat.ResultE2ECredit(),
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "182", 5));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

	}

	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "E2E", "ClientList" })
	@Parameters({ "environment", "clientName" })
	public void E2EScenario184(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		MAPLoginPage
				.EnterLoginID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 1));
		MAPLoginPage.EnterPassword(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 2));
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);

		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 360);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		// wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		wait.until(ExpectedConditions.elementToBeClickable(MAPLoginPage.LogoutTerritory));
		MAPLoginPage.clickTerritoryNo(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 3));
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickAutoCustomer(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 4));
		MAPCustomerDetails mapCustomerDetails = new MAPCustomerDetails(getAndroidDriver());
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		wait.until(ExpectedConditions.elementToBeClickable(mapCustomerDetails.loanSale));
		MAPAffordability MAPAffordability = new MAPAffordability(getAndroidDriver());
		MAPAffordability.clickNotesTab();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPAffordability.clicknewArreasContact();
		MAPAffordability
				.enterWages(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 5));
		//MAPAffordability.enterWagesEvidence();
		MAPAffordability.selectWagesDocument(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 6));
		MAPAffordability.enterWagesReference(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 7));
		MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
		MAPfunctions.switchContext("NATIVE");
		// MAPfunctions.scrollPage(1);
		MAPfunctions.scrollPageByHeight(4);
		MAPfunctions.switchContext("WEBVIEW");
		MAPAffordability.clickRentPaid();
		MAPAffordability.enterRentAmmount(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 8));
		MAPAffordability.enterRentEvidence();
		MAPAffordability.selectRentDocument(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 9));
		MAPAffordability.enterRentReference(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 10));
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MAPAffordability.slider(30, 0);
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPageByHeight(6);
		// MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MAPAffordability.enterProblem(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 11));
		/*
		 * MAPfunctions.switchContext("NATIVE");
		 * MAPfunctions.scrollPageByHeight(6); // MAPfunctions.scrollPage(1);
		 * MAPfunctions.switchContext("WEBVIEW");
		 */
		MAPAffordability.enterSolution(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 12));
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MAPAffordability.enterArrangement(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 13));
		MAPAffordability.clickConfirmNewArreas();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));

		CommonFunctions.Browser();
		SearchCustomer Scustomer = new SearchCustomer(CommonFunctions.driver);
		SearchCustBusinessUnit ScustBU = new SearchCustBusinessUnit(CommonFunctions.driver);
		SearchCustAffordability ScustAff = new SearchCustAffordability(CommonFunctions.driver);
		Scustomer = Scustomer.Customer();
		String Name = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 4);
		String[] split = Name.split(" ");
		Scustomer = Scustomer.setFN(split[0]);
		Scustomer = Scustomer.setSN(split[1]);

		Scustomer = Scustomer.Search();
		ScustAff = ScustAff.custclick();
		ScustAff = ScustAff.Affortability();
		ScustAff.CheckResultWages("Wages");
		ScustAff.CheckResultrent("Rent");
		double Wages = Double
				.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 5));
		double Rent = Double
				.valueOf(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 8));
		DecimalFormat df = new DecimalFormat("#.00");

		if (ScustAff.CheckResultWages("Wages").equals(String.valueOf(df.format(Wages))))
			setAssertMessage("Wages value entered in MAP reflected in CAP is " + ScustAff.CheckResultWages("Wages"), 1);
		Verify.verifyEquals(ScustAff.CheckResultWages("Wages"), String.valueOf(df.format(Wages)));

		if (ScustAff.CheckResultWages("Document").equalsIgnoreCase(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 6)))
			setAssertMessage(
					"Document value entered in MAP reflected in CAP is " + ScustAff.CheckResultWages("Document"), 1);
		Verify.verifyEquals(ScustAff.CheckResultWages("Document"),
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 6));

		if (ScustAff.CheckResultWages("Ref").equalsIgnoreCase(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 7)))
			setAssertMessage("Ref value entered done in MAP reflected in CAP is " + ScustAff.CheckResultWages("Ref"),
					1);
		Verify.verifyEquals(ScustAff.CheckResultWages("Ref"),
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "184", 7));

		if (ScustAff.CheckResultrent("Rent").equals(String.valueOf(df.format(Rent))))
			setAssertMessage("Rent value entered in MAP reflected in CAP is " + ScustAff.CheckResultrent("Rent"), 1);
		Verify.verifyEquals(ScustAff.CheckResultrent("Rent"), String.valueOf(df.format(Rent)));

		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

	}
}
