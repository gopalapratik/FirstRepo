package testscripts.e2e;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
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
import pageobjects.cap.ViewLeadsPage;
import pageobjects.map.MAPLoginPage;
import pageobjects.map.MAPSynchronization;
import pageobjects.map.MAPClientList;
import pageobjects.map.MAPCustomerDetails;
import pageobjects.map.MAPLead;
import pageobjects.map.MAPLoanSale;
import pageobjects.map.MAPLoanSale_ProductSelection;
import helpers.MAPFunctions;

@Listeners(ListenerClass.class)
public class E2ELeadListScripts extends BaseClass {

	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "E2E", "LeadList" }, priority = 1)
	@Parameters({ "environment", "clientName" })
	public void E2EScenario181(String environment, String clientName) throws InterruptedException{
		
	/*	CommonFunctions.Browser();
		ViewLeadsPage Vlead = new ViewLeadsPage(CommonFunctions.driver);
		Vlead = Vlead.Customer();
		Vlead = Vlead.VeiwLead();
		Vlead =Vlead.setStatusblank(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "181", 16));
		Vlead = Vlead.setFirstName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 2));
		Vlead = Vlead.setLastName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 3));
		Vlead = Vlead.Assigned(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 15));
		Vlead = Vlead.Search();
		if(Vlead.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181",17)))
		setAssertMessage("Leads are displayed based on entered first name and Last Name" ,1);
		Verify.verifyEquals(Vlead.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 17));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");*/
		
		
		
		
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
		MAPClientList.clickHamburger();
		MAPClientList.clickLeadList();
		MAPLead MAPLead = new MAPLead(getAndroidDriver());
		MAPLead.clickNewLead();
		MAPLead.selectLeadSalutation(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 1));
		MAPLead.enterLeadFirstName(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 2));
		MAPLead.enterLeadSurname(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 3));
		MAPLead.enterleadaddresspostcode(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 4));
		/*MAPLead.enterleadaddressflatNo(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 5));*/
		MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
		MAPfunctions.switchContext("NATIVE");
		// MAPfunctions.scrollPage(1);
		MAPfunctions.scrollPageByHeight(10);
		MAPfunctions.switchContext("WEBVIEW");
		MAPLead.enterleadaddresshouseNo(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 6));
		/*MAPLead.enterleadaddresshouseName(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "MapTestData", "181", 7));*/
		MAPLead.enterleadaddressstreet(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 7));
		MAPLead.enterleadaddresstown(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 8));
		// MAPLead.enterDOB();
		 MAPLead.enterDOB(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 18));
		MAPfunctions.switchContext("NATIVE");
		MAPfunctions.scrollPageByHeight(2);
		MAPfunctions.switchContext("WEBVIEW");
		//MAPLead.enterDOB();
		MAPLead.entertelephoneNo(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 10));
		MAPLead.entermobileNo(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 11));
		MAPLead.selectMaritalStatus(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 12));
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
		/*MAPClientList.clickHamburger();
		MAPClientList.clickSynchronization();
		MAPSynchronization mapSynchronization= new MAPSynchronization(getAndroidDriver());
		mapSynchronization.clickSynchronization();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.invisibilityOf(mapSynchronization.syncWait));
		mapSynchronization.clickSynHamburger();
		MAPClientList.clickLeadList();
		if (MAPLead.verifyLeadStatus(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 2))
				.equals("COOLING OFF PERIOD ACTIVE"))
			setAssertMessage("Leads status " + MAPLead.verifyLeadStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 13)), 1);
		Verify.verifyEquals(MAPLead.verifyLeadStatus(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 13)),
				"COOLING OFF PERIOD ACTIVE");

		if (MAPLead.verifyLeadAddress(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 13))
				.equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 14)))
			setAssertMessage("Leads Address " + MAPLead.verifyLeadAddress(
					ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 13)),
					2);
		Verify.verifyEquals(MAPLead.verifyLeadAddress(
				ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 13)), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "1", 14));
*/
		
		/////////CAP//////////////////////////////////////////////////////
		
		
		CommonFunctions.Browser();
		ViewLeadsPage Vlead = new ViewLeadsPage(CommonFunctions.driver);
		Vlead = Vlead.Customer();
		Vlead = Vlead.VeiwLead();
		Vlead =Vlead.setStatusblank(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "181", 16));
		Vlead = Vlead.setFirstName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 2));
		Vlead = Vlead.setLastName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 3));
		Vlead = Vlead.Assigned(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 15));
		Vlead = Vlead.Search();
		if(Vlead.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181",17)))
		setAssertMessage("Leads are displayed based on entered first name and Last Name" ,1);
		Verify.verifyEquals(Vlead.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataE2E.xlsx", "E2E", "181", 17));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		
	}

}
