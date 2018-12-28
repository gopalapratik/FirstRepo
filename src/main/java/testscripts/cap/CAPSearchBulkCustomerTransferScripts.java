package testscripts.cap;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsersetup.BaseClass;
import helpers.DatabaseHelper;
import helpers.TestDataHelpers;
import pageobjects.cap.SearchBulkCustomerTransfer;
import pageobjects.cap.SearchCustmerSUMMARY;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchCustomerTransaction;
import pageobjects.cap.SetupBulkCustomerTransfer;
import testdata.TestConstants;
import utilities.ExcelUtilities;
import verify.Verify;

public class CAPSearchBulkCustomerTransferScripts extends BaseClass{
	
	//Currently Model Dialog Box is not handled by Selenium
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void verifyCancelBCTRequest(String environment, String clientName) throws InterruptedException, AWTException, IOException {
		Thread.sleep(5000);
		String strBCTRequestID = setupBCTRequest();
		
		//String strBCTRequestID = "154";
		
        SearchBulkCustomerTransfer searchBCT =  new SearchBulkCustomerTransfer(getDriver());
		
		searchBCT.clickOnCustomerLink();
	
		searchBCT.clickOnSearchBulkCustomerTransferLink();
		
		String strSearchBCTScreenHeader = searchBCT.getScreenHeaderText();
		Verify.verifyEquals(strSearchBCTScreenHeader, TestConstants.strSearchBulkCustomerTransferHeader);
		setAssertMessage("Verifying Search Bulk Customer Transfer page displayed with header : "+strSearchBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		searchBCTRequestOnSearchRequestScreen(searchBCT, strBCTRequestID);
		
		if(searchBCT.isTransferRequestIDDisplayed(strBCTRequestID)) {
			
			String strSearchedRequestId = searchBCT.getTransferRequestIDName();
			System.out.println("Searched Request ID : "+strSearchedRequestId);
			
			Verify.verifyEquals(strSearchedRequestId,strBCTRequestID);
			setAssertMessage("Verifying searched transfer request should be matched with Raised Customer Transfer Request ID : "+strSearchedRequestId ,1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
			String strActualStatusOfRequestID = searchBCT.getStatusOfSpecificTransferID(strBCTRequestID);
			Verify.verifyEquals(strActualStatusOfRequestID,"Pending");
			setAssertMessage("Verifying status of transfer request is should be Pending",1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
			searchBCT.selectTransferRequestID(strBCTRequestID);
			
			}else {
				
				Verify.verifyTrue(searchBCT.isTransferRequestIDDisplayed(strBCTRequestID), "Verifying Searched Request ID on 'Search Bulk Customer Request' screen");
				setAssertMessage("Verifying searched transfer request on 'Search Bulk Customer Request' screen" ,1);
			}
		
        explicitWaitForElement(searchBCT.screenHeader);
		
		String strViewBCTScreenHeader = searchBCT.getScreenHeaderText();
		Verify.verifyEquals(strViewBCTScreenHeader, TestConstants.strViewBulkCustomerTransferHeader);
		setAssertMessage("Verifying View Bulk Customer Transfer page displayed with header : "+strViewBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		searchBCT.cancelRequestButton.click();
		
		Thread.sleep(3000);
		
		acceptAlert();
        
        Thread.sleep(3000);

		String strActualCancelBCTRequestMsg = searchBCT.getErrorMessage();
		
		System.out.println("Actual MSG ****"+strActualCancelBCTRequestMsg);
		
		Verify.verifyEquals(strActualCancelBCTRequestMsg, TestConstants.strCancelBCTRequestMessage);
		setAssertMessage("Verifying Bulk customer transfer request has been Cancelled successfully and message will be displayed as : "+strActualCancelBCTRequestMsg ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		List<WebElement> listOfCustomerID = searchBCT.getCustomerIDList();
		for(WebElement customerId : listOfCustomerID) {
			
			String strCustomerTransferStatus = searchBCT.getTransferStatusFromCustomerID(customerId.getText());
			Verify.verifyEquals(strCustomerTransferStatus,"Cancelled");
			setAssertMessage("Verifying Transfer Status of selected customer should be Cancelled",1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		}
		
		searchBCT.clickOnCancelButton();
		
		searchBCT.clickOnSearchBulkCustomerTransferLink();
		
		searchBCTRequestOnSearchRequestScreen(searchBCT, strBCTRequestID);
		
		String strActualStatusOfRequestID = searchBCT.getStatusOfSpecificTransferID(strBCTRequestID);
		Verify.verifyEquals(strActualStatusOfRequestID,"Cancelled");
		setAssertMessage("Verifying Transfer Status of selected customer should be Cancelled",1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		String strDisableCheckBoxStatus = searchBCT.getDisableCheckBoxStatus(strBCTRequestID);
		System.out.println(strDisableCheckBoxStatus);
		// Change By Rajesh --------------------------------------->As Check box is disable. so it will return True value 
		Verify.verifyEquals(strDisableCheckBoxStatus,"true");
		setAssertMessage("Verifying select checkbox for the BCT Request will be disabled.",1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
	
	
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void verifyAmendBCTRequestScript(String environment, String clientName) throws InterruptedException, ClassNotFoundException, SQLException {
		

		String strBCTRequestID = setupBCTRequest();
		
        SearchBulkCustomerTransfer searchBCT =  new SearchBulkCustomerTransfer(getDriver());
        SetupBulkCustomerTransfer setupBCT = new SetupBulkCustomerTransfer(getDriver());
		
		searchBCT.clickOnCustomerLink();
	
		searchBCT.clickOnSearchBulkCustomerTransferLink();
		
		String strSearchBCTScreenHeader = searchBCT.getScreenHeaderText();
		Verify.verifyEquals(strSearchBCTScreenHeader, TestConstants.strSearchBulkCustomerTransferHeader);
		setAssertMessage("Verifying Search Bulk Customer Transfer page displayed with header : "+strSearchBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		searchBCTRequestOnSearchRequestScreen(searchBCT, strBCTRequestID);
		
		if(searchBCT.isTransferRequestIDDisplayed(strBCTRequestID)) {
			
			String strSearchedRequestId = searchBCT.getTransferRequestIDName();
			System.out.println("Searched Request ID : "+strSearchedRequestId);
			
			Verify.verifyEquals(strSearchedRequestId,strBCTRequestID);
			setAssertMessage("Verifying searched transfer request should be matched with Raised Customer Transfer Request ID : "+strSearchedRequestId ,1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
			String strActualStatusOfRequestID = searchBCT.getStatusOfSpecificTransferID(strBCTRequestID);
			Verify.verifyEquals(strActualStatusOfRequestID,"Pending");
			setAssertMessage("Verifying status of transfer request is should be Pending",1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
			searchBCT.selectTransferRequestID(strBCTRequestID);
			
			}else {
				
				Verify.verifyTrue(searchBCT.isTransferRequestIDDisplayed(strBCTRequestID), "Verifying Searched Request ID on 'Search Bulk Customer Request' screen");
				setAssertMessage("Verifying searched Transfer Request ID on 'Search Bulk Customer Request' screen" ,1);
			}
		
        explicitWaitForElement(searchBCT.screenHeader);
		
		String strViewBCTScreenHeader = searchBCT.getScreenHeaderText();
		Verify.verifyEquals(strViewBCTScreenHeader, TestConstants.strViewBulkCustomerTransferHeader);
		setAssertMessage("Verifying View Bulk Customer Transfer page displayed with header : "+strViewBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		searchBCT.clickOnAmendButton();
		
		String strAmendBCTScreenHeader = searchBCT.getScreenHeaderText();
		Verify.verifyEquals(strAmendBCTScreenHeader, TestConstants.strAmendBulkCustomerTransferHeader);
		setAssertMessage("Verifying Amend Bulk Customer Transfer page displayed with header : "+strAmendBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		searchBCT.clickOnAddCustomerToListButton();
		
        String strSearchCustomerHeader = searchBCT.getScreenHeaderText();
		
		Verify.verifyEquals(strSearchCustomerHeader, TestConstants.strSearchCustomerHeader);
		setAssertMessage("Verifying Search Customer page displayed with header : "+strSearchCustomerHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		Thread.sleep(2000);
		
		searchBCT.clickOnSearchButton();
		
		//Selecting customers
		ArrayList<String> listOfSelectedCustomerIDs  = new ArrayList<String>();
		
		if(searchBCT.getErrorMessage().contains(TestConstants.strNoMatchesRelevantMatchesMessage)) {
		
			setAssertMessage("No more customers are present in selected source territory", 1);
			searchBCT.clickOnCloseButton();
			
		}else {
		
			List<WebElement> listOFCustomerID = searchBCT.getListOfCustomerIDs();
			System.out.println("List size is : "+listOFCustomerID.size());
			
			int noOfCustomer;
			//Selecting 2 customer
			if(listOFCustomerID.size()<2) {
				
				noOfCustomer = listOFCustomerID.size();
			}else {
				noOfCustomer = 2;
			}
			
	       for(int i=0 ; i< noOfCustomer; i++) {
	    	   listOfSelectedCustomerIDs.add(listOFCustomerID.get(i).getText());
			}
			
			for(String strCustomerID :listOfSelectedCustomerIDs ) {
	
				searchBCT.selectCustomerIDCheckBox(strCustomerID);
			}
			
	        Thread.sleep(2000);
		}
		
		
		System.out.println("Number of customer selected : "+listOfSelectedCustomerIDs.size());
		String strActualConfirmationMsg = searchBCT.getErrorMessage();
		
		String expectedConfirmationMsg;
		if(listOfSelectedCustomerIDs.size()==1) {
			expectedConfirmationMsg = "You have selected "+listOfSelectedCustomerIDs.size()+" customer.";
		}else {
			expectedConfirmationMsg = "You have selected "+listOfSelectedCustomerIDs.size()+" customer(s).";
		}
		
		Verify.verifyEquals(strActualConfirmationMsg, expectedConfirmationMsg);
		setAssertMessage("Verifying Customers selected should be ticked and displayed a message : "+strActualConfirmationMsg ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
		searchBCT.clickOnAcceptButton();
		
		strAmendBCTScreenHeader = searchBCT.getScreenHeaderText();
		Verify.verifyEquals(strAmendBCTScreenHeader, TestConstants.strAmendBulkCustomerTransferHeader);
		setAssertMessage("Verifying Amend Bulk Customer Transfer page displayed with header : "+strAmendBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		String strCustomerAdditionMsg = searchBCT.getErrorMessage();
		
		Verify.verifyEquals(strCustomerAdditionMsg, TestConstants.strCustomerAddedMessage);
		setAssertMessage("Verifying Customers should get added and confirmation message should be displayed like : "+strCustomerAdditionMsg  ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
		String strDisableSourceTerritoryStatus = searchBCT.getDisableStatusOfSourceTerritory();
		Verify.verifyEquals(strDisableSourceTerritoryStatus,"true");
		setAssertMessage("Verifying Source Territory text field of BCT Request will be disabled.",1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		String strSourceTerritory = searchBCT.getSourceTerritory();
		
		//Select Destination Territory
        String strDestinationRandomNumber = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
		
        searchBCT.setAmendDestinationTerritory(strDestinationRandomNumber);
		
		String strParentWindow = getDriver().getWindowHandle();
		
		searchBCT.clickOnDestinationTerritorySearchButton();
		
		switchBetweenWindows(strParentWindow);
		
		searchBCT.clickOnSearchButton();
		
		while(searchBCT.getErrorMessage().contains("No relevant matches have been found.")) {
			 
			setupBCT.clickOnNewSearchButton();
			 
			String strRandomTerritory = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
			 
			while(strDestinationRandomNumber.equals(strRandomTerritory)) {
					 
				strRandomTerritory = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
			}
			 
			 setupBCT.enterTerritory(strRandomTerritory);
			 
			 setupBCT.clickOnSearchButton();
		 }
		
		String strTerritoryName;
		
		strTerritoryName = setupBCT.getTerritoryName();
		
		while(strTerritoryName.equals(strSourceTerritory)) {
			
			strTerritoryName = setupBCT.getSecondTerritoryName();
		}
		
		setupBCT.clickOnTerritoryRadioButton(strTerritoryName);

		setupBCT.clickOnAcceptButton();
		
		switchToParentWindow(strParentWindow);
		
		String strDestTerritory = searchBCT.getDestinationTerritory();
		System.out.println(strDestTerritory);
		
		selectFutureDateFromCalendar(searchBCT.fromDateCalendarButton);
		
		String strEffectiveDate = setupBCT.getEffectiveDate();
		
        setupBCT.clickOnSubmitRequestButton();
		
		Thread.sleep(3000);
		
        String strActualBCTUpdateMsg = setupBCT.getErrorMessage();
		Verify.verifyEquals(strActualBCTUpdateMsg,TestConstants.strAmendBCTRequestSuccessfullyMessage);
		setAssertMessage("Verifying Bulk customer transfer request has been updated successfully : "+strActualBCTUpdateMsg ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		
		Verify.verifyEquals(searchBCT.getDestinationTerritory(),strDestTerritory);
		setAssertMessage("Verifying Destination Territory should be same as selected territory : "+searchBCT.getDestinationTerritory(),1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
		Verify.verifyEquals(setupBCT.getEffectiveDate(), strEffectiveDate);
		setAssertMessage("Verifying Effective Monday Date should be same as selected date : "+setupBCT.getEffectiveDate(),1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
		//JDBC logic of Batch Run for BCT status updation 
		DatabaseHelper.executeBCTQuery(strBCTRequestID, environment);
				
		logoutFromApplication();
				
		Thread.sleep(2000);
				
		loginToApplication();

		searchBCT.clickOnCustomerLink();

		searchBCT.clickOnSearchBulkCustomerTransferLink();
		
		searchBCTRequestOnSearchRequestScreen(searchBCT,strBCTRequestID );

		if (searchBCT.isTransferRequestIDDisplayed(strBCTRequestID)) {

			String strSearchedRequestId = searchBCT.getTransferRequestIDName();
			System.out.println("Searched Request ID : " + strSearchedRequestId);

			Verify.verifyEquals(strSearchedRequestId, strBCTRequestID);
			setAssertMessage(
					"Verifying searched transfer request should be matched with Raised Customer Transfer Request ID : "+strSearchedRequestId,1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

			String strActualStatusOfRequestID = searchBCT.getStatusOfSpecificTransferID(strBCTRequestID);
			Verify.verifyEquals(strActualStatusOfRequestID, "Complete");
			setAssertMessage("Verifying status of transfer request is should be Complete", 1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

		} else {

			Verify.verifyTrue(searchBCT.isTransferRequestIDDisplayed(strBCTRequestID),
					"Verifying Searched Request ID on 'Search Bulk Customer Request' screen");
			setAssertMessage("Verifying searched transfer request on 'Search Bulk Customer Request' screen", 1);
		}
		
		//Taking first customer id from Customer List to verify Territory should get updated
		String strCustomerName = listOfSelectedCustomerIDs.get(0).trim();
		
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer")) {
		setAssertMessage("By default Search Customer page is displayed",1);
		Scustomer.setCID(strCustomerName);	
		Scustomer.Search();
		}
		
		Thread.sleep(2000);
		
		if(Scustomer.isCustomerIDSearched(strCustomerName)) {
			String strUpdatedTerritory =Scustomer.getBusinessUnit(strCustomerName);
			
			System.out.println("Updated Territory : "+strUpdatedTerritory);
			
		    Verify.verifyEquals(strUpdatedTerritory,strDestTerritory);
		    setAssertMessage("Verifying after succesfully bulk customer transfer, updated territiry should be displayed for selected customer and updated territory is "+strUpdatedTerritory,1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		}else {
			Verify.verifyTrue(Scustomer.isCustomerIDSearched(strCustomerName), "Verifying customer should get searched");
			setAssertMessage("Verifying specified customer should get searched", 2);
		}
		
		
	}

	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void verifyBCTByChangingSameDestinationTerritory (String environment, String clientName) throws InterruptedException, ClassNotFoundException, SQLException {
		
        String strBCTRequestID = setupBCTRequest();
		
        SearchBulkCustomerTransfer searchBCT =  new SearchBulkCustomerTransfer(getDriver());
        SetupBulkCustomerTransfer setupBCT = new SetupBulkCustomerTransfer(getDriver());
		
		searchBCT.clickOnCustomerLink();
	
		searchBCT.clickOnSearchBulkCustomerTransferLink();
		
		String strSearchBCTScreenHeader = searchBCT.getScreenHeaderText();
		Verify.verifyEquals(strSearchBCTScreenHeader, TestConstants.strSearchBulkCustomerTransferHeader);
		setAssertMessage("Verifying Search Bulk Customer Transfer page displayed with header : "+strSearchBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		searchBCTRequestOnSearchRequestScreen(searchBCT, strBCTRequestID);
		
		if(searchBCT.isTransferRequestIDDisplayed(strBCTRequestID)) {
			
			String strSearchedRequestId = searchBCT.getTransferRequestIDName();
			System.out.println("Searched Request ID : "+strSearchedRequestId);
			
			Verify.verifyEquals(strSearchedRequestId,strBCTRequestID);
			setAssertMessage("Verifying searched transfer request should be matched with Raised Customer Transfer Request ID : "+strSearchedRequestId ,1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
			String strActualStatusOfRequestID = searchBCT.getStatusOfSpecificTransferID(strBCTRequestID);
			Verify.verifyEquals(strActualStatusOfRequestID,"Pending");
			setAssertMessage("Verifying status of transfer request is should be Pending",1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
			searchBCT.selectTransferRequestID(strBCTRequestID);
			
			}else {
				
				Verify.verifyTrue(searchBCT.isTransferRequestIDDisplayed(strBCTRequestID), "Verifying Searched Request ID on 'Search Bulk Customer Request' screen");
				setAssertMessage("Verifying searched Transfer Request ID on 'Search Bulk Customer Request' screen" ,1);
			}
		
        explicitWaitForElement(searchBCT.screenHeader);
		
		String strViewBCTScreenHeader = searchBCT.getScreenHeaderText();
		Verify.verifyEquals(strViewBCTScreenHeader, TestConstants.strViewBulkCustomerTransferHeader);
		setAssertMessage("Verifying View Bulk Customer Transfer page displayed with header : "+strViewBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		String strCustomerID = searchBCT.getCustomerID().trim();
		String strSourceTerritory = searchBCT.getSourceTerritory();
		String strDestinationTerritory = searchBCT.getDestinationTerritory();
		
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustmerSUMMARY Summary = new SearchCustmerSUMMARY(getDriver());
		
		Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer")) {
		setAssertMessage("By default Search Customer page is displayed",1);
		Scustomer.setCID(strCustomerID);	
		Scustomer.Search();
		}
		
		Thread.sleep(2000);
		
		if(Scustomer.isCustomerIDSearched(strCustomerID)) {
			
			Scustomer.clickOnCustomerID(strCustomerID);
			Summary.AmendButton();
			
			Verify.verifyEquals(Summary.getTerritorName(), strSourceTerritory);
			
			setAssertMessage("Verifying Source Territory of searched Customer should be same as selected under BCT request", 1);
			
		    Summary.setTTN(strDestinationTerritory);
		    
		    Summary.setHP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "12", 7));
			Summary.setMP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "12", 8));
		    
		    Summary.SaveButton();
		    
		    Thread.sleep(2000);
		    
		    String strActualActionCompletedMsg = Summary.getErrorMessage();
		    Verify.verifyTrue(strActualActionCompletedMsg.contains("Action completed successfully"));
			setAssertMessage("Verifying Customers details should get update and message will be displayed like : "+strActualActionCompletedMsg  ,1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
			
		    
		}else {
			
			Verify.verifyTrue(Scustomer.isCustomerIDSearched(strCustomerID), "Verifying searched Customer ID should be displayed searched screen");
			setAssertMessage("Verifying searched Customer ID should be displayed searched screen", 2);
		}
		
		// JDBC logic of Batch Run for BCT status updation
		DatabaseHelper.executeBCTQuery(strBCTRequestID, environment);

		logoutFromApplication();

		Thread.sleep(2000);

		loginToApplication();

		searchBCT.clickOnCustomerLink();

		searchBCT.clickOnSearchBulkCustomerTransferLink();

		searchBCTRequestOnSearchRequestScreen(searchBCT, strBCTRequestID);

		if (searchBCT.isTransferRequestIDDisplayed(strBCTRequestID)) {

			String strSearchedRequestId = searchBCT.getTransferRequestIDName();
			System.out.println("Searched Request ID : " + strSearchedRequestId);

			Verify.verifyEquals(strSearchedRequestId, strBCTRequestID);
			setAssertMessage("Verifying searched transfer request should be matched with Raised Customer Transfer Request ID : "+ strSearchedRequestId,1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

			String strActualStatusOfRequestID = searchBCT.getStatusOfSpecificTransferID(strBCTRequestID);
			Verify.verifyEquals(strActualStatusOfRequestID, "Complete");
			setAssertMessage("Verifying status of transfer request is should be Complete", 1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
			searchBCT.selectTransferRequestID(strBCTRequestID);
			
			Thread.sleep(2000);
			
			String strCustoimerTransferRequest = searchBCT.getTransferStatusFromCustomerID(strCustomerID);
			Verify.verifyEquals(strCustoimerTransferRequest, "Ignored");
			setAssertMessage("Verifying status of transfer request for specified customer id '"+strCustomerID+"' should be Ignored", 1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			

		} else {

			Verify.verifyTrue(searchBCT.isTransferRequestIDDisplayed(strBCTRequestID),
					"Verifying Searched Request ID on 'Search Bulk Customer Request' screen");
			setAssertMessage("Verifying searched transfer request on 'Search Bulk Customer Request' screen", 1);
		}
	}
	
	
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void verifyBCTByChangingDifferentDestinationTerritory (String environment, String clientName) throws InterruptedException, ClassNotFoundException, SQLException {
		
        String strBCTRequestID = setupBCTRequest();
		
        SearchBulkCustomerTransfer searchBCT =  new SearchBulkCustomerTransfer(getDriver());
        SetupBulkCustomerTransfer setupBCT = new SetupBulkCustomerTransfer(getDriver());
		
		searchBCT.clickOnCustomerLink();
	
		searchBCT.clickOnSearchBulkCustomerTransferLink();
		
		String strSearchBCTScreenHeader = searchBCT.getScreenHeaderText();
		Verify.verifyEquals(strSearchBCTScreenHeader, TestConstants.strSearchBulkCustomerTransferHeader);
		setAssertMessage("Verifying Search Bulk Customer Transfer page displayed with header : "+strSearchBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		searchBCTRequestOnSearchRequestScreen(searchBCT, strBCTRequestID);
		
		if(searchBCT.isTransferRequestIDDisplayed(strBCTRequestID)) {
			
			String strSearchedRequestId = searchBCT.getTransferRequestIDName();
			System.out.println("Searched Request ID : "+strSearchedRequestId);
			
			Verify.verifyEquals(strSearchedRequestId,strBCTRequestID);
			setAssertMessage("Verifying searched transfer request should be matched with Raised Customer Transfer Request ID : "+strSearchedRequestId ,1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
			String strActualStatusOfRequestID = searchBCT.getStatusOfSpecificTransferID(strBCTRequestID);
			Verify.verifyEquals(strActualStatusOfRequestID,"Pending");
			setAssertMessage("Verifying status of transfer request is should be Pending",1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
			searchBCT.selectTransferRequestID(strBCTRequestID);
			
			}else {
				
				Verify.verifyTrue(searchBCT.isTransferRequestIDDisplayed(strBCTRequestID), "Verifying Searched Request ID on 'Search Bulk Customer Request' screen");
				setAssertMessage("Verifying searched Transfer Request ID on 'Search Bulk Customer Request' screen" ,1);
			}
		
        explicitWaitForElement(searchBCT.screenHeader);
		
		String strViewBCTScreenHeader = searchBCT.getScreenHeaderText();
		Verify.verifyEquals(strViewBCTScreenHeader, TestConstants.strViewBulkCustomerTransferHeader);
		setAssertMessage("Verifying View Bulk Customer Transfer page displayed with header : "+strViewBCTScreenHeader ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		String strCustomerID = searchBCT.getCustomerID().trim();
		String strSourceTerritory = searchBCT.getSourceTerritory();
		String strDestinationTerritory = searchBCT.getDestinationTerritory();
		
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustmerSUMMARY Summary = new SearchCustmerSUMMARY(getDriver());
		
		Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer")) {
		setAssertMessage("By default Search Customer page is displayed",1);
		Scustomer.setCID(strCustomerID);	
		Scustomer.Search();
		}
		
		Thread.sleep(2000);
		
		if(Scustomer.isCustomerIDSearched(strCustomerID)) {
			
			Scustomer.clickOnCustomerID(strCustomerID);
			Summary.AmendButton();
			
			Verify.verifyEquals(Summary.getTerritorName(), strSourceTerritory);
			setAssertMessage("Verifying Source Territory of searched Customer should be same as selected under BCT request", 1);
			
			//Selecting different Destination Territory
	        String strDestinationRandomNumber = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
			
	        Summary.setTTN(strDestinationRandomNumber);
	        
			String strParentWindow = getDriver().getWindowHandle();
			
			Summary.clickOnTerritorySearchButton();
		
			switchBetweenWindows(strParentWindow);
			
			searchBCT.clickOnSearchButton();
			
			while(searchBCT.getErrorMessage().contains("No relevant matches have been found.")) {
				 
				setupBCT.clickOnNewSearchButton();
				 
				String strRandomTerritory = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
				 
				while(strDestinationRandomNumber.equals(strRandomTerritory)) {
						 
					strRandomTerritory = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
				}
				 
				 setupBCT.enterTerritory(strRandomTerritory);
				 
				 setupBCT.clickOnSearchButton();
			 }
			
			String strTerritoryName;
			
			strTerritoryName = setupBCT.getTerritoryName();
			
			while(strTerritoryName.equals(strDestinationTerritory)) {
				
				strTerritoryName = setupBCT.getSecondTerritoryName();
			}
			
			setupBCT.clickOnTerritoryRadioButton(strTerritoryName);

			setupBCT.clickOnAcceptButton();
			
			switchToParentWindow(strParentWindow);
		    
		    Summary.setHP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "12", 7));
			Summary.setMP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "12", 8));
		    
		    Summary.SaveButton();
		    
		    Thread.sleep(2000);
		    
		    String strActualActionCompletedMsg = Summary.getErrorMessage();
		    Verify.verifyTrue(strActualActionCompletedMsg.contains("Action completed successfully"));
			setAssertMessage("Verifying Customers details should get update and message will be displayed like : "+strActualActionCompletedMsg  ,1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
			
		    
		}else {
			
			Verify.verifyTrue(Scustomer.isCustomerIDSearched(strCustomerID), "Verifying searched Customer ID should be displayed searched screen");
			setAssertMessage("Verifying searched Customer ID should be displayed searched screen", 2);
		}
		
		// JDBC logic of Batch Run for BCT status updation
		DatabaseHelper.executeBCTQuery(strBCTRequestID, environment);

		logoutFromApplication();

		Thread.sleep(2000);

		loginToApplication();

		searchBCT.clickOnCustomerLink();

		searchBCT.clickOnSearchBulkCustomerTransferLink();

		searchBCTRequestOnSearchRequestScreen(searchBCT, strBCTRequestID);

		if (searchBCT.isTransferRequestIDDisplayed(strBCTRequestID)) {

			String strSearchedRequestId = searchBCT.getTransferRequestIDName();
			System.out.println("Searched Request ID : " + strSearchedRequestId);

			Verify.verifyEquals(strSearchedRequestId, strBCTRequestID);
			setAssertMessage("Verifying searched transfer request should be matched with Raised Customer Transfer Request ID : "+ strSearchedRequestId,1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

			String strActualStatusOfRequestID = searchBCT.getStatusOfSpecificTransferID(strBCTRequestID);
			Verify.verifyEquals(strActualStatusOfRequestID, "Complete");
			setAssertMessage("Verifying status of transfer request is should be Complete", 1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
			searchBCT.selectTransferRequestID(strBCTRequestID);
			
			Thread.sleep(2000);
			
			String strCustoimerTransferRequest = searchBCT.getTransferStatusFromCustomerID(strCustomerID);
			Verify.verifyEquals(strCustoimerTransferRequest, "Ignored");
			setAssertMessage("Verifying status of transfer request for specified customer id '"+strCustomerID+"' should be Ignored", 1);
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			

		} else {

			Verify.verifyTrue(searchBCT.isTransferRequestIDDisplayed(strBCTRequestID),
					"Verifying Searched Request ID on 'Search Bulk Customer Request' screen");
			setAssertMessage("Verifying searched transfer request on 'Search Bulk Customer Request' screen", 1);
		}
	}
	
	/*
	 * setupBCTRequest() : This method is used to Create BCT request
	 */
	public String setupBCTRequest() throws InterruptedException {
		
		String strParentWindow;
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
		
		selectCustomerOnSearchCustomerScreen(setupBCT,strSourceRandomNumber);
		
		setupBCT.clickOnAcceptButton();
		
        String strCustomerAdditionMsg = setupBCT.getErrorMessage();
		
		Verify.verifyEquals(strCustomerAdditionMsg, TestConstants.strCustomerAddedMessage);
		setAssertMessage("Verifying Customers should get added and confirmation message should be displayed like : "+strCustomerAdditionMsg  ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
		
		//Select Destination Territory
        String strDestinationRandomNumber = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
		
		while(strDestinationRandomNumber.equals(strSourceRandomNumber)) {
			strDestinationRandomNumber = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
		}
		setupBCT.enterDestinationTerritory(strDestinationRandomNumber);
		
		strParentWindow = getDriver().getWindowHandle();
		
		setupBCT.clickOnDestinationTerritorySearchButton();
		
		switchBetweenWindows(strParentWindow);
		
		setupBCT.clickOnSearchButton();
		
		String strDestinationTerritoryName = selectAndRetrieveDestinationTerritoryOnSearchTerritoryScreen(setupBCT,strDestinationRandomNumber,strSourceTerritoryName);
		
		switchToParentWindow(strParentWindow);
		
		selectEffectiveMondayDate(setupBCT);
		
		String strEffectiveDate = setupBCT.getEffectiveDate();
		
        setupBCT.clickOnSubmitRequestButton();
		
		Thread.sleep(3000);
		
        String strActualBCTSuccessMsg = setupBCT.getErrorMessage();
		
		Verify.verifyTrue(strActualBCTSuccessMsg.contains(TestConstants.strSuccessfullyBCTMessage), "Bulk customer transfer request has been raised succesfully");
		setAssertMessage("Verifying Bulk customer transfer request has been raised successfully : "+strActualBCTSuccessMsg ,1);
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		String strRequestID = strActualBCTSuccessMsg.split(":")[1].trim();
		System.out.println("Request ID is : "+strRequestID);
		Thread.sleep(3000);
		
		return strRequestID;
		
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
