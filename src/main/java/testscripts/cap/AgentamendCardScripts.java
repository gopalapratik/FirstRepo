//*********************************************************---> Rajesh Beg,Automation Tester********************************
// Date : 25/09/2018
package testscripts.cap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsersetup.BaseClass;
import pageobjects.cap.AgentAmend;
import reporting.ListenerClass;
import utilities.ExcelUtilities;
import verify.Verify;
@Listeners(ListenerClass.class)
public class AgentamendCardScripts extends  BaseClass{
		@Test(priority=2,enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Business Administration"})
		@Parameters({ "environment", "clientName" })
		public void ATMAmendwithInvalidCardNumber253(String environment, String clientName) throws InterruptedException
		{
			Thread.sleep(2000);
			AgentAmend agentAmend = new AgentAmend(getDriver());
			Thread.sleep(3000);
			// click on Business Adminstrator Link
			agentAmend= agentAmend.BusinessAdministrationclick();
			Thread.sleep(2000);
			// Click On ATM link 
			agentAmend=agentAmend.ATMclick();
			
			// Select check box
			agentAmend=agentAmend.selectCheckbox();	
			Thread.sleep(2000);
			
			// Click on Amend button 
			agentAmend=agentAmend.AmendClick();
			Thread.sleep(15000);
			
			// Enter the 5 Digit Invalid ATM Number 
			agentAmend =agentAmend.EnterInvalidcardno(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "253", 1));
			
			// After Click on Apply Button 
			if(agentAmend.Message().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "253", 2)))
				setAssertMessage("System displayed a message "+agentAmend.Message() ,2);
			Verify.verifyEquals(agentAmend.Message(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "253", 2));
			
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
	
		}
		
		@Test(priority=1,enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Business Administration"})
		@Parameters({ "environment", "clientName" })
		public void ATMAmendwithBlankdata(String environment, String clientName) throws InterruptedException
		{
			Thread.sleep(2000);
			AgentAmend agentAmend = new AgentAmend(getDriver());
			Thread.sleep(3000);
			// click on Business Adminstrator Link
			agentAmend= agentAmend.BusinessAdministrationclick();
			Thread.sleep(2000);
			// Click On ATM link 
			agentAmend=agentAmend.ATMclick();
			
			// Select check box
			agentAmend=agentAmend.selectCheckbox();	
			Thread.sleep(2000);
			
			// Click on Amend button 
			agentAmend=agentAmend.AmendClick();
			Thread.sleep(5000);
			
			// Enter the 5 Digit Invalid ATM Number 
			agentAmend =agentAmend.EnterInvalidcardno(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "253", 6));
			
			// After Click on Apply Button 
			if(agentAmend.Message().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "253", 7)))
				setAssertMessage("System displayed a message "+agentAmend.Message() ,2);
			Verify.verifyEquals(agentAmend.Message(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "253", 7));
		
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
	
		}

		@Test(priority=3,enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Business Administration"})
		@Parameters({ "environment", "clientName" })
		public void ATMAmendwithValidCardNumber(String environment, String clientName) throws InterruptedException
		{
			Thread.sleep(2000);
			AgentAmend agentAmend = new AgentAmend(getDriver());
			Thread.sleep(3000);
			// click on Business Adminstrator Link
			agentAmend= agentAmend.BusinessAdministrationclick();
			Thread.sleep(2000);
			// Click On ATM link 
			agentAmend=agentAmend.ATMclick();
			
			// Select check box
			agentAmend=agentAmend.selectCheckbox();	
			Thread.sleep(2000);
			
			// Click on Amend button 
			agentAmend=agentAmend.AmendClick();
			Thread.sleep(5000);
			
			// Enter the valid ATM Number in blank field
			agentAmend =agentAmend.EnterValidCardNumber();
			
			// After Click on Apply Button verify the customer ATM Number 
			agentAmend =agentAmend.ValidATMcardNumber();
			// Verify Customer name with Entered Card Number
			
			System.out.println(agentAmend.validcardNumber());
			
			System.out.println(agentAmend.ExistedATM());
			
				setAssertMessage("System displayed a message "+agentAmend.validcardNumber(),1);
			Verify.verifyEquals(agentAmend.validcardNumber(), agentAmend.ExistedATM());
			
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	
		}
		
		@Test(priority=4,enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Business Administration"})
		@Parameters({ "environment", "clientName" })
		public void ATMAmendwithExistedPassword(String environment, String clientName) throws InterruptedException
		{
			Thread.sleep(2000);
			AgentAmend agentAmend = new AgentAmend(getDriver());
			Thread.sleep(3000);
			// click on Business Adminstrator Link
			agentAmend= agentAmend.BusinessAdministrationclick();
			Thread.sleep(2000);
			// Click On ATM link 
			agentAmend=agentAmend.ATMclick();
			
			// Select check box
			agentAmend=agentAmend.selectCheckbox();	
			Thread.sleep(2000);
			
			
			// Click on Amend button 
			agentAmend=agentAmend.AmendClick();
			Thread.sleep(5000);
			
			// Enter the valid ATM Number in blank field
			agentAmend =agentAmend.EnterExistedNumber();
			
			// After Click on Apply Button verify the customer ATM Number 
			
			
			if(agentAmend.Message().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "253", 5)))
				setAssertMessage("System displayed a message "+agentAmend.Message() ,2);
			Verify.verifyEquals(agentAmend.Message(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "253", 5));
		
			Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	
		}
		
	}

