package testscripts.map;

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
import pageobjects.map.MAPClientList;
import pageobjects.map.MAPCustomerDetails;
import pageobjects.map.MAPLead;
import pageobjects.map.MAPLoanSale;
import pageobjects.map.MAPLoanSale_ProductSelection;
import helpers.MAPFunctions;

@Listeners(ListenerClass.class)
public class MAPLeadListScripts extends BaseClass {

	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "LeadList" }, priority = 1)
	@Parameters({ "environment", "clientName" })
	public void LeadCreationTC211(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
		String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
		MAPLoginPage.EnterLoginID(userName);
		MAPLoginPage.EnterPassword(password);
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 300);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		// wait.until(ExpectedConditions.visibilityOf(MAPClientList.territory));
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickHamburger();
		MAPClientList.clickLeadList();
		MAPLead MAPLead = new MAPLead(getAndroidDriver());
		MAPLead.clickNewLead();
		MAPLead.selectLeadSalutation(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 1));
		MAPLead.enterLeadFirstName(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 2));
		MAPLead.enterLeadSurname(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 3));
		MAPLead.enterleadaddresspostcode(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 4));
		/*MAPLead.enterleadaddressflatNo(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 5));*/
		MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
		MAPfunctions.switchContext("NATIVE");
		// MAPfunctions.scrollPage(1);
		MAPfunctions.scrollPageByHeight(10);
		MAPfunctions.switchContext("WEBVIEW");
		MAPLead.enterleadaddresshouseNo(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 6));
		/*MAPLead.enterleadaddresshouseName(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 7));*/
		MAPLead.enterleadaddressstreet(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 7));
		MAPLead.enterleadaddresstown(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 8));
		// MAPLead.enterDOB();
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPageByHeight(2);
		MAPfunctions.switchContext("WEBVIEW");
		//MAPLead.enterDOB();
		MAPLead.enterDOB(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 14));
		MAPLead.entertelephoneNo(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 10));
		MAPLead.entermobileNo(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 11));
		MAPLead.selectMaritalStatus(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 12));
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MAPLead.selectbankruptSequestrated_No();
		MAPLead.selectivaDroMapScotland_No();
		MAPLead.selectcabDma_No();
		MAPLead.clickDetailsNext();
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(2);
		MAPfunctions.switchContext("WEBVIEW");
		MAPLead.clickIAgree();
		MAPLead.clickConfirmationNext();
		MAPLead.enterCustomerSign();
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		// MAPfunctions.scrollPageByHeight(6);
		MAPfunctions.switchContext("WEBVIEW");
		MAPLead.clickSignatureNext();
		Thread.sleep(7000);
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		wait.until(ExpectedConditions.visibilityOf(MAPLead.ViewLeads));
		MAPClientList.clickHamburger();
		MAPClientList.clickSynchronization();
		MAPSynchronization mapSynchronization= new MAPSynchronization(getAndroidDriver());
		mapSynchronization.clickSynchronization();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.invisibilityOf(mapSynchronization.syncWait));
		mapSynchronization.clickSynHamburger();
		MAPClientList.clickLeadList();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		if (MAPLead.verifyLeadStatus(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 13))
				.equals("COOLING OFF PERIOD ACTIVE"))
			setAssertMessage("Leads status " + MAPLead.verifyLeadStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 13)), 1);
		Verify.verifyEquals(MAPLead.verifyLeadStatus(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 13)),
				"COOLING OFF PERIOD ACTIVE");

		if (MAPLead.verifyLeadAddress(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 13))
				.equals("19 ZOOFIELD GROVE TEST TOWN X9 9AD"))
			setAssertMessage("Leads status " + MAPLead.verifyLeadAddress(
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 13)),
					2);
		Verify.verifyEquals(MAPLead.verifyLeadAddress(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 13)), "19 ZOOFIELD GROVE TEST TOWN X9 9AD");

		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}

	//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP",	"LeadList" }, dependsOnMethods = "LeadCreationTC211")
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP",	"LeadList" }, priority=2)
	@Parameters({ "environment", "clientName" })
	public void ViewLeadDetailsTC212(String environment, String clientName) throws InterruptedException {
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
		MAPClientList.clickHamburger();
		MAPClientList.clickLeadList();
		MAPLead MAPLead = new MAPLead(getAndroidDriver());
		//wait.until(ExpectedConditions.visibilityOf(MAPLead.ViewLeads));
		//wait.until(ExpectedConditions.elementToBeClickable(MAPLead.NewLead));
		// MAPLead.clickLead();
		MAPLead.SelectLead(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "212", 1));

		if (MAPLead.verifyViewLeadDetailsStatus().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "212", 2)))
			setAssertMessage("Leads status " + MAPLead.verifyViewLeadDetailsStatus(), 1);
		Verify.verifyEquals(MAPLead.verifyViewLeadDetailsStatus(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "212", 2));

		if (MAPLead.verifyViewLeadFullName().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "212", 3)))
			setAssertMessage("Leads Full Name " + MAPLead.verifyViewLeadFullName(), 2);
		Verify.verifyEquals(MAPLead.verifyViewLeadFullName(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "212", 3));

		if (MAPLead.verifyViewLeadDetailsHomeAddress().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "212", 4)))
			setAssertMessage("Home Address " + MAPLead.verifyViewLeadDetailsHomeAddress(), 3);
		Verify.verifyEquals(MAPLead.verifyViewLeadDetailsHomeAddress(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "212", 4));

		if (MAPLead.verifyViewLeadDetailsDOB().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "212", 5)))
			setAssertMessage("Date of Birth " + MAPLead.verifyViewLeadDetailsDOB(), 4);
		Verify.verifyEquals(MAPLead.verifyViewLeadDetailsDOB(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "212", 5));

		if (MAPLead.verifyViewLeadDetailsHomePhone().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "212", 6)))
			setAssertMessage("Home Phone " + MAPLead.verifyViewLeadDetailsHomePhone(), 5);
		Verify.verifyEquals(MAPLead.verifyViewLeadDetailsHomePhone(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "212", 6));

		MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");

		if (MAPLead.verifyViewLeadDetailsMobile().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "212", 7)))
			setAssertMessage("Mobile Phone " + MAPLead.verifyViewLeadDetailsMobile(), 6);
		Verify.verifyEquals(MAPLead.verifyViewLeadDetailsMobile(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "212", 7));

		if (MAPLead.verifyViewLeadDetailsMaritalStatus().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "212", 8)))
			setAssertMessage("Mobile Phone " + MAPLead.verifyViewLeadDetailsMaritalStatus(), 7);
		Verify.verifyEquals(MAPLead.verifyViewLeadDetailsMaritalStatus(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "212", 8));

		/*if (MAPLead.verifyViewLeadDetailsRejectReason().equals("Denied applying/ no longer interested"))
			setAssertMessage("Mobile Phone " + MAPLead.verifyViewLeadDetailsRejectReason(), 8);
		Verify.verifyEquals(MAPLead.verifyViewLeadDetailsRejectReason(), "Denied applying/ no longer interested");
*/
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}

	/*
	 * @Test(retryAnalyzer = helpers.RetryMechanism.class, groups = {
	 * "Regression", "MAP", "LeadList" }, dependsOnMethods =
	 * "LeadCreationTC211")
	 * 
	 * @Parameters({ "environment", "clientName" }) public void
	 * ViewLeadDetailsTC212(String environment, String clientName) throws
	 * InterruptedException { MAPLoginPage MAPLoginPage = new
	 * MAPLoginPage(getAndroidDriver()); String userName =
	 * ConfigurationData.getUserDetails(environment, clientName,
	 * "Automation Username 1"); String password =
	 * ConfigurationData.getUserDetails(environment, clientName,
	 * "Automation Password 1"); MAPLoginPage.EnterLoginID(userName);
	 * MAPLoginPage.EnterPassword(password); MAPLoginPage.clickLogIn();
	 * Thread.sleep(30000); WebDriverWait wait = new
	 * WebDriverWait(getAndroidDriver(), 120); MAPClientList MAPClientList = new
	 * MAPClientList(getAndroidDriver()); //
	 * wait.until(ExpectedConditions.visibilityOf(MAPClientList.territory));
	 * wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
	 * MAPClientList.clickHamburger(); MAPClientList.clickLeadList(); MAPLead
	 * MAPLead = new MAPLead(getAndroidDriver());
	 * wait.until(ExpectedConditions.visibilityOf(MAPLead.ViewLeads));
	 * //MAPLead.clickLead(); MAPLead.SelectLead("AutoLead1 AutoLead1");
	 * 
	 * if (MAPLead.verifyViewLeadDetailsStatus().equals("REJECTED"))
	 * setAssertMessage("Leads status " + MAPLead.verifyViewLeadDetailsStatus(),
	 * 1); Verify.verifyEquals(MAPLead.verifyViewLeadDetailsStatus(),
	 * "REJECTED");
	 * 
	 * if (MAPLead.verifyViewLeadFullName().equals("Mr AutoLead1 AutoLead1"))
	 * setAssertMessage("Leads Full Name " + MAPLead.verifyViewLeadFullName(),
	 * 2); Verify.verifyEquals(MAPLead.verifyViewLeadFullName(),
	 * "Mr AutoLead1 AutoLead1");
	 * 
	 * if (MAPLead.verifyViewLeadDetailsHomeAddress().
	 * equals("ABCDD, 51, X, 2, X, BDD 3NN")) setAssertMessage("Home Address " +
	 * MAPLead.verifyViewLeadDetailsHomeAddress(), 3);
	 * Verify.verifyEquals(MAPLead.verifyViewLeadDetailsHomeAddress(),
	 * "ABCDD, 51, X, 2, X, BDD 3NN");
	 * 
	 * if (MAPLead.verifyViewLeadDetailsDOB().equals("1 Dec 1980"))
	 * setAssertMessage("Date of Birth " + MAPLead.verifyViewLeadDetailsDOB(),
	 * 4); Verify.verifyEquals(MAPLead.verifyViewLeadDetailsDOB(),
	 * "1 Dec 1980");
	 * 
	 * if (MAPLead.verifyViewLeadDetailsHomePhone().equals("12345678"))
	 * setAssertMessage("Home Phone " +
	 * MAPLead.verifyViewLeadDetailsHomePhone(), 5);
	 * Verify.verifyEquals(MAPLead.verifyViewLeadDetailsHomePhone(),
	 * "12345678");
	 * 
	 * MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
	 * MAPfunctions.switchContext("NATIVE"); MAPfunctions.scrollPage(1);
	 * MAPfunctions.switchContext("WEBVIEW");
	 * 
	 * if (MAPLead.verifyViewLeadDetailsMobile().equals("12378945"))
	 * setAssertMessage("Mobile Phone " + MAPLead.verifyViewLeadDetailsMobile(),
	 * 6); Verify.verifyEquals(MAPLead.verifyViewLeadDetailsMobile(),
	 * "12378945");
	 * 
	 * if (MAPLead.verifyViewLeadDetailsMaritalStatus().equals("Single"))
	 * setAssertMessage("Mobile Phone " +
	 * MAPLead.verifyViewLeadDetailsMaritalStatus(), 7);
	 * Verify.verifyEquals(MAPLead.verifyViewLeadDetailsMaritalStatus(),
	 * "Single");
	 * 
	 * if (MAPLead.verifyViewLeadDetailsRejectReason().
	 * equals("Denied applying/ no longer interested"))
	 * setAssertMessage("Mobile Phone " +
	 * MAPLead.verifyViewLeadDetailsRejectReason(), 8);
	 * Verify.verifyEquals(MAPLead.verifyViewLeadDetailsRejectReason(),
	 * "Denied applying/ no longer interested");
	 * 
	 * Assert.assertFalse(Verify.verifyFailure(),
	 * "There were some Failures as shown above."); }
	 */

	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "LeadList" }, priority = 4)
	@Parameters({ "environment", "clientName" })
	public void LeadDetailsLoanSaleLTC213(String environment, String clientName) throws InterruptedException {
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
		MAPClientList.clickLeadList();
		MAPLead MAPLead = new MAPLead(getAndroidDriver());
		wait.until(ExpectedConditions.visibilityOf(MAPLead.ViewLeads));
		//MAPLead.clickLead();
		MAPLead.SelectLead(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "213", 1));
		MAPLead.clickLeadLoanSale();
		MAPLoanSale MAPLoanSale = new MAPLoanSale(getAndroidDriver());
		Thread.sleep(3000);
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
		MAPLoanSale.enterWagesReference("Reference");
		MAPfunctions.switchContext("NATIVE");
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
		Verify.verifyEquals(MapLoanSale_ProductSelection.verifytotalAmmountCredit(), "£1,000:00");
*/
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
		wait.until(ExpectedConditions.visibilityOf(MAPLead.LeadloanSale));
		MAPLead.clickcloseLeadDetails();
		MAPClientList.clickHamburger();
		MAPClientList.clickClientList();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickAutoCustomer(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "213", 1));

		MAPCustomerDetails mapCustomerDetails = new MAPCustomerDetails(getAndroidDriver());
		/*if (mapCustomerDetails.verifyCustomerAccountDetails("Principal Loan Value (£)").equals("1,000.00"))
			setAssertMessage("Principal Loan Value (£) "
					+ mapCustomerDetails.verifyCustomerAccountDetails("Principal Loan Value (£)"), 4);
		Verify.verifyEquals(mapCustomerDetails.verifyCustomerAccountDetails("Principal Loan Value (£)"), "1,000.00");

		if (mapCustomerDetails.verifyCustomerAccountDetails("Terms (Wks)").equals("33"))
			setAssertMessage("Terms (Wks)" + mapCustomerDetails.verifyCustomerAccountDetails("Terms (Wks)"), 5);
		Verify.verifyEquals(mapCustomerDetails.verifyCustomerAccountDetails("Terms (Wks)"), "33");

		if (mapCustomerDetails.verifyCustomerAccountDetails("Total Amount Payable (£)").equals("1,650.00"))
			setAssertMessage("Total Amount Payable (£)"
					+ mapCustomerDetails.verifyCustomerAccountDetails("Total Amount Payable (£)"), 6);
		Verify.verifyEquals(mapCustomerDetails.verifyCustomerAccountDetails("Total Amount Payable (£)"), "1,650.00");

		if (mapCustomerDetails.verifyCustomerAccountDetails("Weekly Rate (£)").equals("50.00"))
			setAssertMessage("Weekly Rate (£)" + mapCustomerDetails.verifyCustomerAccountDetails("Weekly Rate (£)"), 7);
		Verify.verifyEquals(mapCustomerDetails.verifyCustomerAccountDetails("Weekly Rate (£)"), "50.00");

		if (mapCustomerDetails.verifyCustomerAccountDetails("Account Performance Percentage (%)").equals("100%"))
			setAssertMessage("Account Performance Percentage (%)"
					+ mapCustomerDetails.verifyCustomerAccountDetails("Account Performance Percentage (%)"), 8);
		Verify.verifyEquals(mapCustomerDetails.verifyCustomerAccountDetails("Account Performance Percentage (%)"),
				"100%");*/
		
		if (mapCustomerDetails.verifyAcccountNo().equals(mapCustomerDetails.CustomerID()+"/1"))
			setAssertMessage("Verify Acount No " + mapCustomerDetails.verifyAcccountNo(), 5);
		Verify.verifyEquals(mapCustomerDetails.verifyAcccountNo(), mapCustomerDetails.CustomerID()+"/1");
		

		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

		System.out.println("Login Sucessful");
	}

	//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "LeadList" }, dependsOnMethods = "LeadCreationTC211")
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "LeadList" }, priority = 3)
	@Parameters({ "environment", "clientName" })
	public void ViewLeadSearchTC214(String environment, String clientName) throws InterruptedException {
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
		MAPClientList.clickLeadList();
		MAPLead MAPLead = new MAPLead(getAndroidDriver());
		wait.until(ExpectedConditions.visibilityOf(MAPLead.ViewLeads));
		// MAPLead.SearchLead("AutoLead1");
		MAPLead.SearchLead(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "214", 1));

		/*
		 * if
		 * (MAPLead.verifyLeadInSearch("AutoLead1").equals("AutoLead1 AutoLead1"
		 * )) setAssertMessage("Leads status " +
		 * MAPLead.verifyLeadInSearch("AutoLead1"), 1);
		 * Verify.verifyEquals(MAPLead.verifyLeadInSearch("AutoLead1"),
		 * "AutoLead1 AutoLead1");
		 */

		if (MAPLead
				.verifyLeadInSearch(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx",
						"MapTestData", "214", 2))
				.equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "214",
						3)))
			setAssertMessage("Leads Name " + MAPLead.verifyLeadInSearch(
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "214", 2)),
					1);
		Verify.verifyEquals(
				MAPLead.verifyLeadInSearch(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx",
						"MapTestData", "214", 2)),
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "214", 3));

		MAPLead.clickSearchBackButton();
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickHamburger();
		MAPClientList.clickLogout();
		wait.until(ExpectedConditions.visibilityOf(MAPLoginPage.logo));

		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

	}
	
	//@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "LeadList" }, priority = 1)
	@Parameters({ "environment", "clientName" })
	public void LeadCreationRejectedTC209(String environment, String clientName) throws InterruptedException {
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
		String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
		MAPLoginPage.EnterLoginID(userName);
		MAPLoginPage.EnterPassword(password);
		MAPLoginPage.clickLogIn();
		Thread.sleep(30000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 300);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickHamburger();
		MAPClientList.clickLeadList();
		MAPLead MAPLead = new MAPLead(getAndroidDriver());
		MAPLead.clickNewLead();
		MAPLead.selectLeadSalutation(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 1));
		MAPLead.enterLeadFirstName(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 2));
		MAPLead.enterLeadSurname(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 3));
		MAPLead.enterleadaddresspostcode(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 4));
		/*MAPLead.enterleadaddressflatNo(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 5));*/
		MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
		MAPfunctions.switchContext("NATIVE");
		// MAPfunctions.scrollPage(1);
		MAPfunctions.scrollPageByHeight(10);
		MAPfunctions.switchContext("WEBVIEW");
		MAPLead.enterleadaddresshouseNo(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 6));
		/*MAPLead.enterleadaddresshouseName(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "211", 7));*/
		MAPLead.enterleadaddressstreet(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 7));
		MAPLead.enterleadaddresstown(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 8));
		// MAPLead.enterDOB();
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPageByHeight(2);
		MAPfunctions.switchContext("WEBVIEW");
		MAPLead.enterDOB("05 Jul 1962");
		MAPLead.entertelephoneNo(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 10));
		MAPLead.entermobileNo(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 11));
		MAPLead.selectMaritalStatus(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 12));
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		MAPfunctions.switchContext("WEBVIEW");
		MAPLead.selectbankruptSequestrated_No();
		MAPLead.selectivaDroMapScotland_No();
		MAPLead.selectcabDma_No();
		MAPLead.clickDetailsNext();
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(2);
		MAPfunctions.switchContext("WEBVIEW");
		MAPLead.clickIAgree();
		MAPLead.clickConfirmationNext();
		MAPLead.enterCustomerSign();
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPage(1);
		// MAPfunctions.scrollPageByHeight(6);
		MAPfunctions.switchContext("WEBVIEW");
		MAPLead.clickSignatureNext();
		Thread.sleep(7000);
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		wait.until(ExpectedConditions.visibilityOf(MAPLead.ViewLeads));
		MAPClientList.clickHamburger();
		MAPClientList.clickSynchronization();
		MAPSynchronization mapSynchronization= new MAPSynchronization(getAndroidDriver());
		mapSynchronization.clickSynchronization();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.invisibilityOf(mapSynchronization.syncWait));
		mapSynchronization.clickSynHamburger();
		MAPClientList.clickLeadList();
		if (MAPLead.verifyLeadStatus(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 2))
				.equals("REJECTED"))
			setAssertMessage("Leads status " + MAPLead.verifyLeadStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 2)), 1);
		Verify.verifyEquals(MAPLead.verifyLeadStatus(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 2)),
				"REJECTED");
		System.out.println("Lead address"+ MAPLead.verifyLeadAddress(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 2)));
		if (MAPLead.verifyLeadAddress(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 2))
				.equals("19 Lead Street TEST TOWN X9 9AD"))
			setAssertMessage("Leads status " + MAPLead.verifyLeadAddress(
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 2)),
					2);
		Verify.verifyEquals(MAPLead.verifyLeadAddress(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "209", 2)), "19 Lead Street TEST TOWN X9 9AD");

		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
}
