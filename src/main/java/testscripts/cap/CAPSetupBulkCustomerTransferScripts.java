package testscripts.cap;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsersetup.BaseClass;
import helpers.DatabaseHelper;
import helpers.TestDataHelpers;
import pageobjects.cap.SearchBulkCustomerTransfer;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SetupBulkCustomerTransfer;
import reporting.ListenerClass;
import testdata.TestConstants;
import utilities.ExcelUtilities;
import verify.Verify;

@Listeners(ListenerClass.class)
public class CAPSetupBulkCustomerTransferScripts extends BaseClass {
	
	String strRandomNumber,strParentWindow;
	
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void verifyBCTWhenSrcAndDestTerritoryIsSame(String environment, String clientName) throws InterruptedException {
		
		SetupBulkCustomerTransfer setupBCT = new SetupBulkCustomerTransfer(getDriver());
		
		setupBCT.clickOnCustomerLink();
		Thread.sleep(3000);
		setupBCT.clickOnSetupBulkCustomerTransferLink();
		Thread.sleep(3000);
		String strSetUpBCTScreenHeader = setupBCT.getScreenHeaderText();
		Verify.verifyEquals(strSetUpBCTScreenHeader, TestConstants.strSetupBulkCustomerTransferHeader);
		setAssertMessage("Verifying Setup Bulk Customer Transfer page displayed with header : "+strSetUpBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		strRandomNumber = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
		
		setupBCT.enterSourceTerritory(strRandomNumber);
		Thread.sleep(3000);
		String strParentWindow = getDriver().getWindowHandle();
		
		setupBCT.clickOnSourceTerritorySearchButton();
		Thread.sleep(3000);
		switchBetweenWindows(strParentWindow);
		
		setupBCT.clickOnSearchButton();
		Thread.sleep(4000);
		
		String strSearchTerritoryScreenHeader = setupBCT.getScreenHeaderText();
		Verify.verifyEquals(strSearchTerritoryScreenHeader, TestConstants.strSearchTerritoryScreenHeader);
		setAssertMessage("Search Territory Screen displayed with header: "+strSearchTerritoryScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
			
		String strTerritoryName = selectAndRetrieveSourceTerritoryOnSearchTerritoryScreen(setupBCT,strRandomNumber);
		
		switchToParentWindow(strParentWindow);
		
		Thread.sleep(3000);
		
		System.out.println("Source is : "+setupBCT.getSourceTerritory());
		System.out.println(setupBCT.getSourceTerritory());
		
		System.out.println(strTerritoryName);
		Verify.verifyEquals(setupBCT.getSourceTerritory(), strTerritoryName);
		setAssertMessage("Selected Territory should be displayed under Source Territory TextBox" ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
		setupBCT.enterDestinationTerritory(strTerritoryName);
		
		setupBCT.clickOnSubmitRequestButton();
		
		Thread.sleep(5000);
		
		String strActualErrorMsg = setupBCT.getErrorMessage();
		System.out.println(setupBCT.getErrorMessage());
		Verify.verifyEquals(strActualErrorMsg, TestConstants.strErrorMsgWhenSrcAndDestTerritoryIsSame);
		setAssertMessage("Verifying error message when Source & Destination territory is same & message is : "+strActualErrorMsg ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		Thread.sleep(4000);
	}
	
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void verifyRemoveCustomersFromBCTRequest(String environment, String clientName) throws InterruptedException {

		SetupBulkCustomerTransfer setupBCT = new SetupBulkCustomerTransfer(getDriver());
		setupBCT.clickOnCustomerLink();
		Thread.sleep(3000);
		setupBCT.clickOnSetupBulkCustomerTransferLink();
		Thread.sleep(3000);
		String strSetUpBCTScreenHeader = setupBCT.getScreenHeaderText();
		Verify.verifyEquals(strSetUpBCTScreenHeader, TestConstants.strSetupBulkCustomerTransferHeader);
		setAssertMessage("Verifying Setup Bulk Customer Transfer page displayed with header : "+strSetUpBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		//Select Source Territory
		String strSourceRandomNumber = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
		
		setupBCT.enterSourceTerritory(strSourceRandomNumber);
		
		strParentWindow = getDriver().getWindowHandle();
		
		setupBCT.clickOnSourceTerritorySearchButton();
		Thread.sleep(3000);
		switchBetweenWindows(strParentWindow);
		
		setupBCT.clickOnSearchButton();
		Thread.sleep(3000);
		String strSourceTerritoryName = selectAndRetrieveSourceTerritoryOnSearchTerritoryScreen(setupBCT,strSourceRandomNumber);
		
		switchToParentWindow(strParentWindow);
		
		//Select Destination Territory
		String strDestinationRandomNumber = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
		
		while(strDestinationRandomNumber.equals(strSourceRandomNumber)) {
			strDestinationRandomNumber = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
		}
		setupBCT.enterDestinationTerritory(strDestinationRandomNumber);
		
		strParentWindow = getDriver().getWindowHandle();
		
		setupBCT.clickOnDestinationTerritorySearchButton();
		Thread.sleep(3000);
		switchBetweenWindows(strParentWindow);
		
		setupBCT.clickOnSearchButton();
		Thread.sleep(3000);
		String strDestinationTerritoryName = selectAndRetrieveDestinationTerritoryOnSearchTerritoryScreen(setupBCT,strDestinationRandomNumber,strSourceTerritoryName);
		
		switchToParentWindow(strParentWindow);
		
		selectEffectiveMondayDate(setupBCT);
		
		String strEffectiveDate = setupBCT.getEffectiveDate();
		Thread.sleep(3000);
		setupBCT.clickOnAddCustomerToListButton();
		Thread.sleep(3000);
		String strSearchCustomerHeader = setupBCT.getScreenHeaderText();
		Thread.sleep(3000);
		Verify.verifyEquals(strSearchCustomerHeader, TestConstants.strSearchCustomerHeader);
		setAssertMessage("Verifying Search Customer page displayed with header : "+strSearchCustomerHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		Thread.sleep(2000);
		
		setupBCT.clickOnSearchButton();
		Thread.sleep(3000);
		ArrayList<String> customerIDs = new ArrayList<String>();
		customerIDs = selectCustomerOnSearchCustomerScreen(setupBCT,strSourceRandomNumber);
		
		System.out.println("Number of customer selected : "+customerIDs.size());
		String strActualConfirmationMsg = setupBCT.getErrorMessage();
		
		String expectedConfirmationMsg;
		if(customerIDs.size()==1) {
			expectedConfirmationMsg = "You have selected "+customerIDs.size()+" customer.";
		}else {
			expectedConfirmationMsg = "You have selected "+customerIDs.size()+" customer(s).";
		}
		System.out.println(strActualConfirmationMsg);
		System.out.println(expectedConfirmationMsg);
		Verify.verifyEquals(strActualConfirmationMsg, expectedConfirmationMsg);
		setAssertMessage("Verifying Customers selected should be ticked and displayed a message : "+strActualConfirmationMsg ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
		setupBCT.clickOnAcceptButton();
		Thread.sleep(2000);
		strSetUpBCTScreenHeader = setupBCT.getScreenHeaderText();
		System.out.println(strSetUpBCTScreenHeader);
		System.out.println(TestConstants.strSetupBulkCustomerTransferHeader);
		Verify.verifyEquals(strSetUpBCTScreenHeader, TestConstants.strSetupBulkCustomerTransferHeader);
		setAssertMessage("Verifying Setup Bulk Customer Transfer page displayed with header : "+strSetUpBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		String strCustomerAdditionMsg = setupBCT.getErrorMessage();
		
		Verify.verifyEquals(strCustomerAdditionMsg, TestConstants.strCustomerAddedMessage);
		setAssertMessage("Verifying Customers should get added and confirmation message should be displayed like : "+strCustomerAdditionMsg  ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
		setupBCT.clickOnSelectAllCheckBox();
		Thread.sleep(3000);
		setupBCT.clickOnRemoveCustomerFromListButton();
		
        String strCustomerRemoveMsg = setupBCT.getErrorMessage();
        System.out.println(strCustomerRemoveMsg);
		System.out.println(TestConstants.strCustomerRemovedMessage);
		Verify.verifyEquals(strCustomerRemoveMsg, TestConstants.strCustomerRemovedMessage);
		setAssertMessage("Verifying Customers should get removed and confirmation message should be displayed like : "+strCustomerRemoveMsg  ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
		Thread.sleep(2000);
		
		setupBCT.clickOnSubmitRequestButton();
		Thread.sleep(3000);
        String strPleaseAddCustomerMsg = setupBCT.getErrorMessage();
		System.out.println(strPleaseAddCustomerMsg);
		System.out.println(TestConstants.strPleaseAddCustomerMessage);
		Verify.verifyEquals(strPleaseAddCustomerMsg, TestConstants.strPleaseAddCustomerMessage);
		setAssertMessage("Verifying please add customer confirmation message should be displayed like : "+strPleaseAddCustomerMsg  ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
        setupBCT.clickOnAddCustomerToListButton();
		
        Thread.sleep(2000);
		
		setupBCT.clickOnSearchButton();
		Thread.sleep(3000);
        customerIDs = selectCustomerOnSearchCustomerScreen(setupBCT,strSourceRandomNumber);
		
		strActualConfirmationMsg = setupBCT.getErrorMessage();
		Thread.sleep(3000);
		expectedConfirmationMsg = "You have selected "+customerIDs.size()+" customer(s).";
		System.out.println(strActualConfirmationMsg);
		System.out.println(expectedConfirmationMsg);
		Verify.verifyEquals(strActualConfirmationMsg, expectedConfirmationMsg);
		setAssertMessage("Verifying Customers selected should be ticked and displayed a message : "+strActualConfirmationMsg ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
		setupBCT.clickOnAcceptButton();
		
        Thread.sleep(2000);
        
        strSetUpBCTScreenHeader = setupBCT.getScreenHeaderText();
		Verify.verifyEquals(strSetUpBCTScreenHeader, TestConstants.strSetupBulkCustomerTransferHeader);
		setAssertMessage("Verifying Setup Bulk Customer Transfer page displayed with header : "+strSetUpBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		strCustomerAdditionMsg = setupBCT.getErrorMessage();
		
		Verify.verifyEquals(strCustomerAdditionMsg, TestConstants.strCustomerAddedMessage);
		setAssertMessage("Verifying Customers should get added and confirmation message should be displayed like : "+strCustomerAdditionMsg  ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
		setupBCT.clickOnSubmitRequestButton();
		
		Thread.sleep(3000);
		
        String strActualBCTSuccessMsg = setupBCT.getErrorMessage();
        System.out.println(strActualBCTSuccessMsg.contains(TestConstants.strSuccessfullyBCTMessage));
		
		Verify.verifyTrue(strActualBCTSuccessMsg.contains(TestConstants.strSuccessfullyBCTMessage), "Bulk customer transfer request has been raised successfully");
		setAssertMessage("Verifying Bulk customer transfer request has been raised successfully : "+strActualBCTSuccessMsg ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		Thread.sleep(3000);
		
	}
	
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void verifyCreateBCTRequest(String environment, String clientName) throws InterruptedException, IOException {
		
		SetupBulkCustomerTransfer setupBCT = new SetupBulkCustomerTransfer(getDriver());
		setupBCT.clickOnCustomerLink();
		
		setupBCT.clickOnSetupBulkCustomerTransferLink();
		
		String strSetUpBCTScreenHeader = setupBCT.getScreenHeaderText();
		Verify.verifyEquals(strSetUpBCTScreenHeader, TestConstants.strSetupBulkCustomerTransferHeader);
		setAssertMessage("Verifying Setup Bulk Customer Transfer page displayed with header : "+strSetUpBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		//Select Source Territory
		String strSourceRandomNumber = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
		
		setupBCT.enterSourceTerritory(strSourceRandomNumber);
		
		strParentWindow = getDriver().getWindowHandle();
		
		setupBCT.clickOnSourceTerritorySearchButton();
		
		switchBetweenWindows(strParentWindow);
		
		setupBCT.clickOnSearchButton();
		
		String strSourceTerritoryName = selectAndRetrieveSourceTerritoryOnSearchTerritoryScreen(setupBCT,strSourceRandomNumber);
		
		switchToParentWindow(strParentWindow);
		
        setupBCT.clickOnAddCustomerToListButton();
		
		String strSearchCustomerHeader = setupBCT.getScreenHeaderText();
		
		Verify.verifyEquals(strSearchCustomerHeader, TestConstants.strSearchCustomerHeader);
		setAssertMessage("Verifying Search Customer page displayed with header : "+strSearchCustomerHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		Thread.sleep(2000);
		
		setupBCT.clickOnSearchButton();
		
		ArrayList<String> listOfSelectedCustomerIDs = new ArrayList<String>();
		listOfSelectedCustomerIDs = selectCustomerOnSearchCustomerScreen(setupBCT,strSourceRandomNumber);
		
		System.out.println("Number of customer selected : "+listOfSelectedCustomerIDs.size());
		String strActualConfirmationMsg = setupBCT.getErrorMessage();
		
		String expectedConfirmationMsg;
		if(listOfSelectedCustomerIDs.size()==1) {
			expectedConfirmationMsg = "You have selected "+listOfSelectedCustomerIDs.size()+" customer.";
		}else {
			expectedConfirmationMsg = "You have selected "+listOfSelectedCustomerIDs.size()+" customer(s).";
		}
		
		Verify.verifyEquals(strActualConfirmationMsg, expectedConfirmationMsg);
		setAssertMessage("Verifying Customers selected should be ticked and displayed a message : "+strActualConfirmationMsg ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
		setupBCT.clickOnAcceptButton();
		
		strSetUpBCTScreenHeader = setupBCT.getScreenHeaderText();
		Verify.verifyEquals(strSetUpBCTScreenHeader, TestConstants.strSetupBulkCustomerTransferHeader);
		setAssertMessage("Verifying Setup Bulk Customer Transfer page displayed with header : "+strSetUpBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		String strCustomerAdditionMsg = setupBCT.getErrorMessage();
		
		Verify.verifyEquals(strCustomerAdditionMsg, TestConstants.strCustomerAddedMessage);
		setAssertMessage("Verifying Customers should get added and confirmation message should be displayed like : "+strCustomerAdditionMsg  ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
		strSourceTerritoryName = setupBCT.getSourceTerritory();
		
		//Select Destination Territory
        String strDestinationRandomNumber = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
		
		while(strDestinationRandomNumber.equals(strSourceRandomNumber)) {
			strDestinationRandomNumber = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
		}
		setupBCT.enterDestinationTerritory(strDestinationRandomNumber);
		
		strParentWindow = getDriver().getWindowHandle();
		
		setupBCT.clickOnDestinationTerritorySearchButton();
		Thread.sleep(3000);
		switchBetweenWindows(strParentWindow);
		
		setupBCT.clickOnSearchButton();
		Thread.sleep(3000);
		String strDestinationTerritoryName = selectAndRetrieveDestinationTerritoryOnSearchTerritoryScreen(setupBCT,strDestinationRandomNumber,strSourceTerritoryName);
		
		switchToParentWindow(strParentWindow);
		Thread.sleep(3000);
		selectEffectiveMondayDate(setupBCT);
		
		String strEffectiveDate = setupBCT.getEffectiveDate();
		Thread.sleep(3000);
		String strFromDate = getTodaysDate();
		
		Verify.verifyTrue(setupBCT.isEffectiveDateDisplayed(), "Selected Date should be displayed under Effective Date text box");
		setAssertMessage("Verifying Selected Date should be displayed under Effective Date text box and Effective Monday Date is : "+strEffectiveDate  ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
		setupBCT.clickOnSubmitRequestButton();
		
		Thread.sleep(3000);
		
        String strActualBCTSuccessMsg = setupBCT.getErrorMessage();
        Thread.sleep(3000);
		Verify.verifyTrue(strActualBCTSuccessMsg.contains(TestConstants.strSuccessfullyBCTMessage), "Bulk customer transfer request has been raised succesfully");
		setAssertMessage("Verifying Bulk customer transfer request has been raised successfully : "+strActualBCTSuccessMsg ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		String strRequestID = strActualBCTSuccessMsg.split(":")[1].trim();
		System.out.println("Request ID is : "+strRequestID);
		Thread.sleep(3000);
		System.out.println(strEffectiveDate);
		System.out.println(strSourceTerritoryName);
		System.out.println(strDestinationTerritoryName);
		System.out.println(strFromDate);
		System.out.println(listOfSelectedCustomerIDs.size());
		// It will take  too much time. before run the test save the data 
		
		//For further Test Case validation : Taking all the Bulk Customer Transfer related details and save it on TestCaseData.xlsx-->BulkCustomerTransfer sheet
		ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", 1, 1,strRequestID);
		Thread.sleep(3000);
		ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", 2, 1,strEffectiveDate);
		Thread.sleep(3000);
		ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", 3, 1,strSourceTerritoryName);
		Thread.sleep(3000);
		ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", 4, 1,strDestinationTerritoryName);
		Thread.sleep(3000);
		ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", 5, 1,strFromDate);
		Thread.sleep(3000);
		ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", 6, 1,String.valueOf(listOfSelectedCustomerIDs.size()));
		Thread.sleep(3000);
		//adding customer id's
		int i=8;
		for(int j=0; j<listOfSelectedCustomerIDs.size(); j++){
		
			do {
				
			ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", i, 0,"Customer ID"+j);	
			Thread.sleep(3000);
			ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", i, 1,listOfSelectedCustomerIDs.get(j));
			Thread.sleep(3000);
			
			}while(i>++i);
		}
		
	}
	
	
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Customer"},dependsOnMethods = {"verifyCreateBCTRequest"})
	@Parameters({ "environment", "clientName" })
	public void verifySearchAndPerformBCTRequest(String environment, String clientName) throws InterruptedException, RuntimeException, SQLException, ClassNotFoundException, IOException {
		
		SearchBulkCustomerTransfer searchBCT =  new SearchBulkCustomerTransfer(getDriver());
		
		String strSourceTerritory = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BulkCustomerTransfer", "Source Territory", 1);
		String strDestinationTerritory = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BulkCustomerTransfer", "Destination Territory", 1);
		String strCustomerRequestID = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BulkCustomerTransfer", "Customer Request ID", 1);
		String strToDate = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BulkCustomerTransfer", "Effective BCT Date", 1);
		String strFromDate = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BulkCustomerTransfer", "Raised Request Date", 1);
		String strTotalCustomerCount = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BulkCustomerTransfer", "Total Customer", 1);
		
		searchBCT.clickOnCustomerLink();
		Thread.sleep(3000);
		searchBCT.clickOnSearchBulkCustomerTransferLink();
		Thread.sleep(3000);
		String strSearchBCTScreenHeader = searchBCT.getScreenHeaderText();
		Verify.verifyEquals(strSearchBCTScreenHeader, TestConstants.strSearchBulkCustomerTransferHeader);
		setAssertMessage("Verifying Search Bulk Customer Transfer page displayed with header : "+strSearchBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		searchBCT.enterSourceTerritory(strSourceTerritory);
		Thread.sleep(2000);
		searchBCT.enterDestinationTerritory(strDestinationTerritory);
		Thread.sleep(1000);
		searchBCT.enterFromDate(strFromDate);
		Thread.sleep(1000);
		searchBCT.enterToDate(strToDate);
		Thread.sleep(1000);
		searchBCT.enterTransferRequestID(strCustomerRequestID);
		Thread.sleep(1000);
		searchBCT.clickOnSearchButton();
		
		Thread.sleep(4000);
		
		if(searchBCT.isTransferRequestIDDisplayed(strCustomerRequestID)) {
			
		String strSearchedRequestId = searchBCT.getTransferRequestIDName();
		System.out.println("Searched Request ID : "+strSearchedRequestId);
		
		Verify.verifyEquals(strSearchedRequestId,strCustomerRequestID);
		setAssertMessage("Verifying searched transfer request should be matched with Raised Customer Transfer Request ID : "+strSearchedRequestId ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		Thread.sleep(2000);
		String strActualStatusOfRequestID = searchBCT.getStatusOfSpecificTransferID(strCustomerRequestID);
		Verify.verifyEquals(strActualStatusOfRequestID,"Pending");
		setAssertMessage("Verifying status of transfer request is should be Pending",1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		Thread.sleep(2000);
		ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", 7, 1,strActualStatusOfRequestID);
		
		searchBCT.selectTransferRequestID(strCustomerRequestID);
		Thread.sleep(2000);
		}else {
			
			Verify.verifyTrue(searchBCT.isTransferRequestIDDisplayed(strCustomerRequestID), "Verifying Searched Request ID on 'Search Bulk Customer Request' screen");
			setAssertMessage("Verifying searched transfer request on 'Search Bulk Customer Request' screen" ,1);
		}
		
		explicitWaitForElement(searchBCT.screenHeader);
		Thread.sleep(2000);
		String strViewBCTScreenHeader = searchBCT.getScreenHeaderText();
		Verify.verifyEquals(strViewBCTScreenHeader, TestConstants.strViewBulkCustomerTransferHeader);
		setAssertMessage("Verifying View Bulk Customer Transfer page displayed with header : "+strViewBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		Thread.sleep(2000);
		//Verifying added customer should be displayed on View Bulk Customer Transfer Screen
		
		List<WebElement> listOfCustomerID = searchBCT.getCustomerIDList();
		
		Verify.verifyEquals(String.valueOf(listOfCustomerID.size()), strTotalCustomerCount);
		setAssertMessage("Verifying Total customer count : "+listOfCustomerID.size() ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		Thread.sleep(2000);
		
		for(int i=0 ; i<listOfCustomerID.size();i++) {
			String strCustomerID = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BulkCustomerTransfer","Customer ID"+i, 1);
			Verify.verifyTrue(searchBCT.isSpecifiedCustomerID_Displayed(strCustomerID), "Verifying added customer on View BCT screen");
			setAssertMessage("Verifying added customer should be displayed on View BCT screen, Customer name is : "+strCustomerID ,1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above."); 
		}
	
		//JDBC logic of Batch Run for status updation 
		DatabaseHelper.executeBCTQuery(strCustomerRequestID, environment);
		
		logoutFromApplication();
		
		Thread.sleep(2000);
		
		loginToApplication();
		
		searchBCT.clickOnCustomerLink();
		Thread.sleep(2000);
		searchBCT.clickOnSearchBulkCustomerTransferLink();
		Thread.sleep(2000);
        searchBCT.enterFromDate(strFromDate);
		
		searchBCT.enterToDate(strToDate);
		
		searchBCT.enterTransferRequestID(strCustomerRequestID);
		
		searchBCT.clickOnSearchButton();
		
		Thread.sleep(2000);
		
		if(searchBCT.isTransferRequestIDDisplayed(strCustomerRequestID)) {
			
		String strSearchedRequestId = searchBCT.getTransferRequestIDName();
		System.out.println("Searched Request ID : "+strSearchedRequestId);
		
		Verify.verifyEquals(strSearchedRequestId,strCustomerRequestID);
		setAssertMessage("Verifying searched transfer request should be matched with Raised Customer Transfer Request ID : "+strSearchedRequestId ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		String strActualStatusOfRequestID = searchBCT.getStatusOfSpecificTransferID(strCustomerRequestID);
		Verify.verifyEquals(strActualStatusOfRequestID,"Complete");
		setAssertMessage("Verifying status of transfer request is should be Complete",1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", 7, 2,"After successful completion of BCT, Updated Status is : "+strActualStatusOfRequestID);
		
		}else {
			
			Verify.verifyTrue(searchBCT.isTransferRequestIDDisplayed(strCustomerRequestID), "Verifying Searched Request ID on 'Search Bulk Customer Request' screen");
			setAssertMessage("Verifying searched transfer request on 'Search Bulk Customer Request' screen" ,1);
		}
		
		String strCustomerID = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BulkCustomerTransfer","Customer ID"+0, 1);
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer")) {
		setAssertMessage("By default Search Customer page is displayed",1);
		Scustomer.setCID(strCustomerID);	
		Scustomer.Search();
		}
		
		Thread.sleep(2000);
		if(Scustomer.isCustomerIDSearched(strCustomerID)) {
			String strUpdatedTerritory =Scustomer.getBusinessUnit(strCustomerID);
			
			System.out.println("Updated Territory : "+strUpdatedTerritory);
			
		    Verify.verifyEquals(strUpdatedTerritory,strDestinationTerritory);
		    setAssertMessage("Verifying after succesfully bulk customer transfer, updated territiry should be displayed for selected customer and updated territory is "+strUpdatedTerritory,1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		}
		
		
		
	}
	
	// (1)verify.VerificationError:expected [You have selected 2000 customer(s).] but found [You have selected 598 customer(s).]
	// Not able to retrieve customer list more than 2000 on Search Customer Screen
	
	@Test(enabled=false,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void verifyBCTFunctionalityFor2000Customer(String environment, String clientName) throws InterruptedException, IOException, ClassNotFoundException, SQLException {
		
		SetupBulkCustomerTransfer setupBCT = new SetupBulkCustomerTransfer(getDriver());
		setupBCT.clickOnCustomerLink();
		
		setupBCT.clickOnSetupBulkCustomerTransferLink();
		
		Thread.sleep(2000);
		
		String strSetUpBCTScreenHeader = setupBCT.getScreenHeaderText();
		Verify.verifyEquals(strSetUpBCTScreenHeader, TestConstants.strSetupBulkCustomerTransferHeader);
		setAssertMessage("Verifying Setup Bulk Customer Transfer page displayed with header : "+strSetUpBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		String strSourceTerritory = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BulkCustomerTransfer", "Source Territory_2000 Customer", 1);
		String strDestinationTerritory = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BulkCustomerTransfer", "Destination Territory_2000 Customer", 1);
		
		setupBCT.enterSourceTerritory(strSourceTerritory);
		
		setupBCT.clickOnAddCustomerToListButton();
		
		String strSearchCustomerHeader = setupBCT.getScreenHeaderText();
		
		Verify.verifyEquals(strSearchCustomerHeader, TestConstants.strSearchCustomerHeader);
		setAssertMessage("Verifying Search Customer page displayed with header : "+strSearchCustomerHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		Thread.sleep(2000);
		
		setupBCT.clickOnSearchButton();
		
		setupBCT.clickOnSelectAllCheckBox();
		
        String strActualConfirmationMsg = setupBCT.getErrorMessage();
		
		String expectedConfirmationMsg = "You have selected "+2000+" customer(s).";
		System.out.println(strActualConfirmationMsg);
		System.out.println(expectedConfirmationMsg);
		Verify.verifyEquals(strActualConfirmationMsg, expectedConfirmationMsg);
		setAssertMessage("Verifying 2000 Customers should get selected and displayed a message : "+strActualConfirmationMsg ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
		setupBCT.clickOnAcceptButton();
		
		strSetUpBCTScreenHeader = setupBCT.getScreenHeaderText();
		Verify.verifyEquals(strSetUpBCTScreenHeader, TestConstants.strSetupBulkCustomerTransferHeader);
		setAssertMessage("Verifying Setup Bulk Customer Transfer page displayed with header : "+strSetUpBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		String strCustomerAdditionMsg = setupBCT.getErrorMessage();
		
		Verify.verifyEquals(strCustomerAdditionMsg, TestConstants.strCustomerAddedMessage);
		setAssertMessage("Verifying Customers should get added and confirmation message should be displayed like : "+strCustomerAdditionMsg  ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
		//Select Destination Territory
		
		setupBCT.enterDestinationTerritory(strDestinationTerritory);
		
		selectEffectiveMondayDate(setupBCT);
		
        setupBCT.clickOnSubmitRequestButton();
		
		Thread.sleep(3000);
		
        String strActualBCTSuccessMsg = setupBCT.getErrorMessage();
		
		Verify.verifyTrue(strActualBCTSuccessMsg.contains(TestConstants.strSuccessfullyBCTMessage), "Bulk customer transfer request has been raised succesfully");
		setAssertMessage("Verifying Bulk customer transfer request has been raised successfully : "+strActualBCTSuccessMsg ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		String strRequestID = strActualBCTSuccessMsg.split(":")[1].trim();
		System.out.println("Request ID is : "+strRequestID);
		Thread.sleep(3000);
		
		SearchBulkCustomerTransfer searchBCT =  new SearchBulkCustomerTransfer(getDriver());
		
		searchBCT.clickOnCustomerLink();
	
		searchBCT.clickOnSearchBulkCustomerTransferLink();
		
		String strSearchBCTScreenHeader = searchBCT.getScreenHeaderText();
		Verify.verifyEquals(strSearchBCTScreenHeader, TestConstants.strSearchBulkCustomerTransferHeader);
		setAssertMessage("Verifying Search Bulk Customer Transfer page displayed with header : "+strSearchBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		searchBCTRequestOnSearchRequestScreen(searchBCT, strRequestID);
		
		if(searchBCT.isTransferRequestIDDisplayed(strRequestID)) {
			
			String strSearchedRequestId = searchBCT.getTransferRequestIDName();
			System.out.println("Searched Request ID : "+strSearchedRequestId);
			
			Verify.verifyEquals(strSearchedRequestId,strRequestID);
			setAssertMessage("Verifying searched transfer request should be matched with Raised Customer Transfer Request ID : "+strSearchedRequestId ,1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
			String strActualStatusOfRequestID = searchBCT.getStatusOfSpecificTransferID(strRequestID);
			Verify.verifyEquals(strActualStatusOfRequestID,"Pending");
			setAssertMessage("Verifying status of transfer request is should be Pending",1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
			searchBCT.selectTransferRequestID(strRequestID);
			
			}else {
				
				Verify.verifyTrue(searchBCT.isTransferRequestIDDisplayed(strRequestID), "Verifying Searched Request ID on 'Search Bulk Customer Request' screen");
				setAssertMessage("Verifying searched Transfer Request ID on 'Search Bulk Customer Request' screen" ,1);
			}
		
        explicitWaitForElement(searchBCT.screenHeader);
        
		String strViewBCTScreenHeader = searchBCT.getScreenHeaderText();
		Verify.verifyEquals(strViewBCTScreenHeader, TestConstants.strViewBulkCustomerTransferHeader);
		setAssertMessage("Verifying View Bulk Customer Transfer page displayed with header : "+strViewBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		String strCustomerID = searchBCT.getCustomerID();
		
		Verify.verifyTrue(searchBCT.isPeginationDisplayed(), "Verifying pegination is displayed on View Bulk Customer Transfer request screen");
		setAssertMessage("Verifying pegination is displayed on View Bulk Customer Transfer request screen",1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		
		//JDBC logic of Batch Run for BCT status updation 
				DatabaseHelper.executeBCTQuery(strRequestID, environment);
						
				logoutFromApplication();
						
				Thread.sleep(2000);
						
				loginToApplication();

				searchBCT.clickOnCustomerLink();

				searchBCT.clickOnSearchBulkCustomerTransferLink();
				
				searchBCTRequestOnSearchRequestScreen(searchBCT,strRequestID );

				if (searchBCT.isTransferRequestIDDisplayed(strRequestID)) {

					String strSearchedRequestId = searchBCT.getTransferRequestIDName();
					System.out.println("Searched Request ID : " + strSearchedRequestId);
					System.out.println(strSearchedRequestId);
					System.out.println(strRequestID);

					Verify.verifyEquals(strSearchedRequestId, strRequestID);
					setAssertMessage(
							"Verifying searched transfer request should be matched with Raised Customer Transfer Request ID : "+strSearchedRequestId,1);
					Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

					String strActualStatusOfRequestID = searchBCT.getStatusOfSpecificTransferID(strRequestID);
					Verify.verifyEquals(strActualStatusOfRequestID, "Complete");
					setAssertMessage("Verifying status of transfer request is should be Complete", 1);
					Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

				} else {

					Verify.verifyTrue(searchBCT.isTransferRequestIDDisplayed(strRequestID),
							"Verifying Searched Request ID on 'Search Bulk Customer Request' screen");
					setAssertMessage("Verifying searched transfer request on 'Search Bulk Customer Request' screen", 1);
				}
				
				
				SearchCustomer Scustomer = new SearchCustomer(getDriver());
				Scustomer.Customer();
				if(Scustomer.SCust().equals("Search Customer")) {
				setAssertMessage("By default Search Customer page is displayed",1);
				Scustomer.setCID(strCustomerID);	
				Scustomer.Search();
				}
				
				Thread.sleep(2000);
				
				if(Scustomer.isCustomerIDSearched(strCustomerID)) {
					String strUpdatedTerritory =Scustomer.getBusinessUnit(strCustomerID);
					
					System.out.println("Updated Territory : "+strUpdatedTerritory);
					
				    Verify.verifyEquals(strUpdatedTerritory,strDestinationTerritory);
				    setAssertMessage("Verifying after succesfully bulk customer transfer, updated territiry should be displayed for selected customer and updated territory is "+strUpdatedTerritory,1);
					Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
				}else {
					Verify.verifyTrue(Scustomer.isCustomerIDSearched(strCustomerID), "Verifying customer should get searched");
					setAssertMessage("Verifying specified customer should get searched", 2);
				}
		
				ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", 13, 1,strDestinationTerritory);
				ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", 14, 1,strSourceTerritory);
				ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", 15, 1,strRequestID);
		
	}
	
	/*
	 * searchBCTRequestOnSearchRequestScreen(SearchBulkCustomerTransfer searchBCT,String strRequestId) : This method is used to search BCT request on Search Screen
	 */
	public void searchBCTRequestOnSearchRequestScreen(SearchBulkCustomerTransfer searchBCT,String strRequestId) throws InterruptedException {
		
		String strFromDate = getTodaysDate();
		searchBCT.enterFromDate(strFromDate);
		
		selectFutureDateFromCalendar(searchBCT.toDateCalendarButton);
		
		searchBCT.enterTransferRequestID(strRequestId);
		
		searchBCT.clickOnSearchButton();
		
		Thread.sleep(2000);
	}
	
	
	
}
