
package testscripts.cap;

import static org.testng.Assert.assertEquals;

import java.text.ParseException;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import verify.Verify;

import browsersetup.BaseClass;
import helpers.CommonFunctions;
import pageobjects.cap.*;
import reporting.ListenerClass;
import utilities.*;

@Listeners(ListenerClass.class)
public class CAPDepositCardsScripts extends BaseClass
{
	 public  String SurName="Test"+CommonFunctions.InsertTime();
	//WebDriverWait wait1;
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Business Administration"})
	@Parameters({ "environment", "clientName" })
	public void DepositCardsTC67(String environment, String clientName) throws InterruptedException, ParseException
	{
		SetupStaff setup = new SetupStaff(getDriver());
		System.out.println("surname"+setup.SurName);
		DepositCards card =new DepositCards(getDriver());
		String name= "Test"+CommonFunctions.InsertTime();
		setup.StaffLink();
		setup.SetupStaffLink();
		setup.setSalutation(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 1));
		setup.setFN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 2));
		card.setSN(name);
		setup.setHN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 4));
		setup.setStrt(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 5));
		setup.setLoclty(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 6));	
		setup.settn(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 7));
		setup.setcntry(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 8));
		setup.setPC(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 9));
		setup.setHP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 10));
		setup.setMP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 11));
		setup.setSD();
		setup.setUsergrp(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 12));
		//getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		//getDriver().manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		Thread.sleep(18000);
		setup.setSType(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 13));
		Thread.sleep(2000);
		setup.setUN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 2)+"."+name);
		setup.setJobId(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 15));
		Thread.sleep(1000);
		setup.setpmt(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 16));
		setup.setAtmN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 17));
		setup.setAlimit(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 18));
		setup.setFL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 19));
		Thread.sleep(3000);
		setup.Savebutton();
		setup.AddSchmebutton();
		setup.Addwindow();
		setup.AddItem();
		setup.Savebutton();
		Thread.sleep(10000);
		if(setup.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 20)))
			setAssertMessage("System displayed a message "+setup.Result(),1);
		Verify.verifyEquals(setup.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 20));
	
			
		card.BusAdministrationLink();
		card.DepositCardsLink();
		card.AddLink();
		card.SwitchWindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 2),name,false,"No","No");
		//card.SwitchWindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "67", 2), "Test10345");
		card.Result();
		if(card.Result().equals(card.CardNO))
			setAssertMessage("Card Added Successufully ",2);
		Verify.verifyEquals(card.Result(), card.CardNO);
	
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Business Administration"})
	@Parameters({ "environment", "clientName" })
	public void DepositCardsTC68(String environment, String clientName) throws InterruptedException, ParseException
	{
		
		
		
		SetupStaff setup = new SetupStaff(getDriver());
		System.out.println("surname"+setup.SurName);
		DepositCards card =new DepositCards(getDriver());
		String name= "Test"+CommonFunctions.InsertTime();
		setup.StaffLink();
		setup.SetupStaffLink();
		setup.setSalutation(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 1));
		setup.setFN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 2));
		card.setSN(name);
		setup.setHN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 4));
		setup.setStrt(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 5));
		setup.setLoclty(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 6));	
		setup.settn(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 7));
		setup.setcntry(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 8));
		setup.setPC(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 9));
		setup.setHP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 10));
		setup.setMP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 11));
		setup.setSD();
		setup.setUsergrp(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 12));
		//getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		//getDriver().manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		Thread.sleep(21000);
		setup.setSType(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 13));
		Thread.sleep(2000);
		card.setUN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 2)+"."+name);
		setup.setJobId(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 15));
		Thread.sleep(1000);
		setup.setpmt(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 16));
		setup.setAtmN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 17));
		setup.setAlimit(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 18));
		setup.setFL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 19));
		Thread.sleep(3000);
		setup.Savebutton();
		setup.AddSchmebutton();
		setup.Addwindow();
		setup.AddItem();
		setup.Savebutton();
		Thread.sleep(10000);
		if(setup.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 20)))
			setAssertMessage("System displayed a message "+setup.Result(),1);
		Verify.verifyEquals(setup.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 20));
	
		//	DepositCards card =new DepositCards(getDriver());
		card.BusAdministrationLink();
		card.DepositCardsLink();
		card.AddLink();
		//card.SwitchWindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 2), setup.SurName,true);
		card.SwitchWindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 2), name,true,"No","No");
		
		card.Search("true");
		if(setup.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 21)))
			setAssertMessage("Card deleted Successufully where no transaction on card ",2);
		Verify.verifyEquals(setup.Result(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 21));
		card.DepositCardsLink();
		card.DeleteActiveCard("MCL00002695",false);
		
		if(setup.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 22)))
			setAssertMessage("System displayed a message >> "+setup.Result(),3);
		Verify.verifyEquals(setup.Result(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 22));
		
		/*card.DeleteActiveCard("MCL00003137",true);
		
		if(setup.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 23)))
			setAssertMessage("System displayed a message >> "+setup.Result(),3);
		Verify.verifyEquals(setup.Result(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "68", 23));
		*/
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Business Administration"})
	@Parameters({ "environment", "clientName" })
	public void DepositCardsTC69(String environment, String clientName) throws InterruptedException, ParseException
	{
		SetupStaff setup = new SetupStaff(getDriver());
		DepositCards card =new DepositCards(getDriver());
		
		/*SetupStaff setup = new SetupStaff(getDriver());
		DepositCards card =new DepositCards(getDriver());*/
		String name= "Test"+CommonFunctions.InsertTime();
		setup.StaffLink();
		setup.SetupStaffLink();
		setup.setSalutation(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 1));
		setup.setFN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 2));
		card.setSN(name);
		setup.setHN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 4));
		setup.setStrt(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 5));
		setup.setLoclty(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 6));	
		setup.settn(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 7));
		setup.setcntry(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 8));
		setup.setPC(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 9));
		setup.setHP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 10));
		setup.setMP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 11));
		setup.setSD();
		setup.setUsergrp(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 12));
		//getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		//getDriver().manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		Thread.sleep(21000);
		setup.setSType(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 13));
		Thread.sleep(2000);
		setup.setUN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 2)+"."+name);
		setup.setJobId(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 15));
		Thread.sleep(1000);
		setup.setpmt(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 16));
		setup.setAtmN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 17));
		setup.setAlimit(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 18));
		setup.setFL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 19));
		Thread.sleep(3000);
		setup.Savebutton();
		setup.AddSchmebutton();
		setup.Addwindow();
		setup.AddItem();
		setup.Savebutton();
		Thread.sleep(10000);
		if(setup.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 20)))
			setAssertMessage("System displayed a message "+setup.Result(),1);
		Verify.verifyEquals(setup.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 20));
	
		//DepositCards card =new DepositCards(getDriver());
		card.BusAdministrationLink();
		card.DepositCardsLink();
		card.AddLink();
		//card.SwitchWindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 2), setup.SurName,true);
		card.SwitchWindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 2), name,true,"No","No");
		card.Search("false");
		card.AddLink();
		card.SwitchWindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 2), name,true,"yes","yes");
		

		
		if(card.Resultmsg.equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 21)))
			setAssertMessage("System displayed a message >> "+card.Resultmsg,2);
		Verify.verifyEquals(card.Resultmsg,ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "69", 21));
	
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Business Administration"})
	@Parameters({ "environment", "clientName" })
	public void DepositCardsTC70(String environment, String clientName) throws InterruptedException, ParseException
	{
		
		SetupStaff setup = new SetupStaff(getDriver());
		DepositCards card =new DepositCards(getDriver());
		//SetupStaff setup = new SetupStaff(getDriver());
		String name= "Test"+CommonFunctions.InsertTime();
		setup.StaffLink();
		setup.SetupStaffLink();
		setup.setSalutation(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 1));
		setup.setFN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 2));
		card.setSN(name);
		setup.setHN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 4));
		setup.setStrt(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 5));
		setup.setLoclty(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 6));	
		setup.settn(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 7));
		setup.setcntry(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 8));
		setup.setPC(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 9));
		setup.setHP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 10));
		setup.setMP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 11));
		setup.setSD();
		setup.setUsergrp(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 12));
		//getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		//getDriver().manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		Thread.sleep(21000);
		setup.setSType(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 13));
		Thread.sleep(2000);
		card.setUN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 14)+"."+name);
		setup.setJobId(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 15));
		Thread.sleep(1000);
		setup.setpmt(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 16));
		setup.setAtmN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 17));
		setup.setAlimit(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 18));
		setup.setFL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 19));
		Thread.sleep(3000);
		setup.Savebutton();
		setup.AddSchmebutton();
		setup.Addwindow();
		setup.AddItem();
		setup.Savebutton();
		Thread.sleep(10000);
		if(setup.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 20)))
			setAssertMessage("System displayed a message "+setup.Result(),1);
		Verify.verifyEquals(setup.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 20));
	
		//DepositCards card =new DepositCards(getDriver());
		card.BusAdministrationLink();
		card.DepositCardsLink();
		card.AddLink();
		//card.SwitchWindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 2), setup.SurName,true);
		card.SwitchWindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 2), name,true,"No","No");
		//card.Search("false");
		card.AddLink();
		card.SwitchWindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 2), name,true,"yes","No");
		

		
		if(card.Resultmsg.equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 21)))
			setAssertMessage("System displayed a message >> "+card.Resultmsg,2);
		Verify.verifyEquals(card.Resultmsg,ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "70", 21));
	
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Business Administration"})
	@Parameters({ "environment", "clientName" })
	public void DepositCardsTC71(String environment, String clientName) throws InterruptedException, ParseException
	{
		
		
		SetupStaff setup = new SetupStaff(getDriver());
		DepositCards card =new DepositCards(getDriver());
		String name= "Test"+CommonFunctions.InsertTime();
		//SetupStaff setup = new SetupStaff(getDriver());
		setup.StaffLink();
		setup.SetupStaffLink();
		setup.setSalutation(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 1));
		setup.setFN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 2));
		card.setSN(name);
		setup.setHN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 4));
		setup.setStrt(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 5));
		setup.setLoclty(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 6));	
		setup.settn(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 7));
		setup.setcntry(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 8));
		setup.setPC(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 9));
		setup.setHP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 10));
		setup.setMP(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 11));
		setup.setSD();
		setup.setUsergrp(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 12));
		//getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		//getDriver().manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		Thread.sleep(21000);
		setup.setSType(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 13));
		Thread.sleep(2000);
		card.setUN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 14)+"."+name);

		//setup.setUN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 14));
		setup.setJobId(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 15));
		Thread.sleep(1000);
		setup.setpmt(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 16));
		setup.setAtmN(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 17));
		setup.setAlimit(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 18));
		setup.setFL(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 19));
		Thread.sleep(3000);
		setup.Savebutton();
		setup.AddSchmebutton();
		setup.Addwindow();
		setup.AddItem();
		setup.Savebutton();
		Thread.sleep(10000);
		if(setup.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 20)))
			setAssertMessage("System displayed a message "+setup.Result(),1);
		Verify.verifyEquals(setup.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 20));
	
		
		
		//DepositCards card =new DepositCards(getDriver());
		card.BusAdministrationLink();
		card.DepositCardsLink();
		card.AddLink();
		//card.SwitchWindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 2), setup.SurName,true);
		card.SwitchWindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 2), name,true,"No","No");
		card.Search("Pastdate");
		card.AddLink();
		card.SwitchWindow(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 2), name,true,"yes","No");
		

		
		if(card.Search("Pastdate").equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 21)))
			setAssertMessage("Option to select (checkbox) is disabled when it passed the end date.",1);
		//Verify.verifyEquals(card.Resultmsg,ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "BusinessAdministration", "71", 1));
	
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
	}
}