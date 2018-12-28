
package testscripts.map;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import reporting.ListenerClass;
import testdata.ConfigurationData;
import utilities.ExcelUtilities;
import verify.Verify;
import browsersetup.BaseClass;
import helpers.CommonFunctions;
//import helpers.MAPFunctions;
import helpers.MAPFunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import pageobjects.cap.LoginPage;
import pageobjects.map.MAPLoginPage;
import pageobjects.map.MAPSynchronization;
import pageobjects.map.MAPAgentNotes;
import pageobjects.map.MAPClientList;
import pageobjects.map.MAPCustomerDetails;
import pageobjects.map.MAPLead;
import pageobjects.map.MAPLoanSale;
import pageobjects.map.MAPLoanSale_ProductSelection;
//import helpers.MAPFunctions;

@Listeners(ListenerClass.class)
public class MAPAgentNoteScripts extends BaseClass {

	@BeforeTest(groups = { "Regression","MAP","AgentNote"})
	@Parameters({ "environment", "clientName"})
	public void Beforetest(String environment, String clientName) throws InterruptedException
	{
		//CommonFunctions.roll(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Credit Control Policy", "99", 1));
		System.out.println("in before test");
		CommonFunctions.roll("ClearAgentNote");
		//Thread.sleep(10000);
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "AgentNote" })
	@Parameters({ "environment", "clientName" })
	public void AgentNotesCreationTC242(String environment, String clientName) throws InterruptedException {
		System.out.println("innnnnnnnnnnnnnnnn");
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 2");
		String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 2");
		System.out.println(userName);
		MAPLoginPage.EnterLoginID(userName);
		MAPLoginPage.EnterPassword(password);
		MAPLoginPage.clickLogIn();
		Thread.sleep(70000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 300);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		
		//wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPLead MAPLead = new MAPLead(getAndroidDriver());
		MAPAgentNotes MAPNotes=new MAPAgentNotes(getAndroidDriver());
		MAPNotes.clickTerritory("5713");
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickHamburger();
		MAPNotes.clickAgentNotes();
		MAPNotes.clickCreateNoteButton();
		MAPNotes.clickAgent(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "242", 1));
		MAPNotes.enterTitle(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "242", 2));
		MAPNotes.enterActionPlan(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "242", 3));
		//Barry Brady
	
		Thread.sleep(2000);
		MAPNotes.scroll();
		MAPNotes.clickConfirm();
		if (MAPNotes.ResultCreateNote().equals("true"))
			setAssertMessage("Note Created Succesfully" , 1);
		Verify.verifyEquals(MAPNotes.ResultCreateNote(),"true");
		Thread.sleep(3000);
		MAPNotes.Hamburgerclick();
		MAPClientList.clickLogout();
		Thread.sleep(2000);
		String userName1 = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 3");
		String password1 = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 3");
		System.out.println(userName);
		MAPLoginPage.EnterLoginID(userName1);
		MAPLoginPage.EnterPassword(password1);
		MAPLoginPage.clickLogIn();
		Thread.sleep(70000);
		MAPClientList.clickHamburger();
		MAPNotes.clickAgentNotes();
		if (MAPNotes.ResultCreateNote().equals("true"))
			setAssertMessage("Note Created Succesfully on staff screen" , 1);
		Verify.verifyEquals(MAPNotes.ResultCreateNote(),"true");
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "AgentNote" })
	@Parameters({ "environment", "clientName" })
	public void AgentNotesVeiwTC243(String environment, String clientName) throws InterruptedException {
		System.out.println("innnnnnnnnnnnnnnnn");
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 2");
		String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 2");
		System.out.println(userName);
		MAPLoginPage.EnterLoginID(userName);
		MAPLoginPage.EnterPassword(password);
		MAPLoginPage.clickLogIn();
		Thread.sleep(70000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 300);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		
		//wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPLead MAPLead = new MAPLead(getAndroidDriver());
		MAPAgentNotes MAPNotes=new MAPAgentNotes(getAndroidDriver());
		MAPNotes.clickTerritory("5713");
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickHamburger();
		MAPNotes.clickAgentNotes();
		MAPNotes.clickCreateNoteButton();
		MAPNotes.clickAgent(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "243", 1));
		MAPNotes.enterTitle(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "243", 2));
		MAPNotes.enterActionPlan(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "243", 3));
		Thread.sleep(2000);
		MAPNotes.scroll();
		MAPNotes.clickConfirm();
		DateFormat dateformat= new SimpleDateFormat("dd.MM.YYYY");
		Date date = new Date();
		MAPNotes.NotesClick(dateformat.format(date));
		MAPNotes.ActionPlanButtonClick();
		if (MAPNotes.ResultViewNote().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "243", 4)))
			setAssertMessage("Note is displayed on Agent note screen" , 1);
		Verify.verifyEquals(MAPNotes.ResultViewNote(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "243", 4));
		//Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "AgentNote" })
	@Parameters({ "environment", "clientName" })
	public void AgentNotesEditTC244(String environment, String clientName) throws InterruptedException {
		CommonFunctions.roll("ClearAgentNote");
		System.out.println("innnnnnnnnnnnnnnnn");
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 2");
		String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 2");
		System.out.println(userName);
		MAPLoginPage.EnterLoginID(userName);
		MAPLoginPage.EnterPassword(password);
		MAPLoginPage.clickLogIn();
		Thread.sleep(70000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 300);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		
		//wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPLead MAPLead = new MAPLead(getAndroidDriver());
		MAPAgentNotes MAPNotes=new MAPAgentNotes(getAndroidDriver());
		MAPNotes.clickTerritory("5713");
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickHamburger();
		MAPNotes.clickAgentNotes();
		MAPNotes.clickCreateNoteButton();
		MAPNotes.clickAgent(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "244", 1));
		MAPNotes.enterTitle(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "244", 2));
		MAPNotes.enterActionPlan(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "244", 3));
		//Barry Brady
	
		Thread.sleep(2000);
		
		MAPNotes.scroll();
		MAPNotes.clickConfirm();
		//MAPNotes.clickConfirm();
		DateFormat dateformat= new SimpleDateFormat("dd.MM.YYYY");
		Date date = new Date();
		Thread.sleep(2000);
		MAPNotes.NotesClick(dateformat.format(date));
		MAPNotes.EditActionPlanButtonClick();
		MAPNotes.editnote(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "244", 4));
		Thread.sleep(2000);
		MAPNotes.UpdateButton();
		//MAPNotes.clickAgentNotes();
		//MAPNotes.NotesClick(dateformat.format(date));
		//MAPNotes.ActionPlanButtonClick();
		

		Thread.sleep(3000);
		MAPNotes.Hamburgerclick();
		MAPClientList.clickLogout();
		Thread.sleep(2000);
		String userName1 = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 3");
		String password1 = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 3");
		System.out.println(userName);
		MAPLoginPage.EnterLoginID(userName1);
		MAPLoginPage.EnterPassword(password1);
		MAPLoginPage.clickLogIn();
		Thread.sleep(70000);
		MAPClientList.clickHamburger();
		MAPNotes.clickAgentNotes();
		Thread.sleep(3000);
		MAPNotes.NotesClick(dateformat.format(date));
		//MAPNotes.EditActionPlanButtonClick();
		if (MAPNotes.ResultViewNote().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "244", 4)))
			setAssertMessage("Note edited Succesfully and displayed on staff screen" , 1);
		Verify.verifyEquals(MAPNotes.ResultViewNote(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "244", 4));
		MAPNotes.closeAlertclick();
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		
		
		
		
		
		
		
		
		
		
	}

	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "AgentNote" })
	@Parameters({ "environment", "clientName" })
	public void AgentNotesCompleteTC245(String environment, String clientName) throws InterruptedException {
		System.out.println("innnnnnnnnnnnnnnnn");
		MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
		String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 2");
		String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 2");
		System.out.println(userName);
		MAPLoginPage.EnterLoginID(userName);
		MAPLoginPage.EnterPassword(password);
		MAPLoginPage.clickLogIn();
		Thread.sleep(70000);
		WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 300);
		MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
		
		//wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPLead MAPLead = new MAPLead(getAndroidDriver());
		MAPAgentNotes MAPNotes=new MAPAgentNotes(getAndroidDriver());
		MAPNotes.clickTerritory("5713");
		wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
		MAPClientList.clickHamburger();
		MAPNotes.clickAgentNotes();
		MAPNotes.clickCreateNoteButton();
		MAPNotes.clickAgent(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "245", 1));
		MAPNotes.enterTitle(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "245", 2));
		MAPNotes.enterActionPlan(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "245", 3));
		Thread.sleep(2000);
		MAPNotes.scroll();
		MAPNotes.clickConfirm();
		//MAPNotes.clickConfirm();
		DateFormat dateformat= new SimpleDateFormat("dd.MM.YYYY");
		Date date = new Date();
		Thread.sleep(6000);
		MAPNotes.NotesClick(dateformat.format(date));
		MAPNotes.CloseButtonclick();
		Thread.sleep(2000);
		MAPNotes.CompleteButtonclick();
		
		
		Thread.sleep(3000);
		MAPNotes.Hamburgerclick();
		MAPClientList.clickLogout();
		Thread.sleep(2000);
		String userName1 = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 3");
		String password1 = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 3");
		System.out.println(userName);
		MAPLoginPage.EnterLoginID(userName1);
		MAPLoginPage.EnterPassword(password1);
		MAPLoginPage.clickLogIn();
		Thread.sleep(70000);
		MAPClientList.clickHamburger();
		MAPNotes.clickAgentNotes();
		
		if (MAPNotes.ResultStatusText().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "245", 4)))
			setAssertMessage("Note closed Succesfully and Status Changed to Closed" , 1);
		Verify.verifyEquals(MAPNotes.ResultStatusText(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "245", 4));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		
		
		
		
		
		
		
		
	}
	
	
}

