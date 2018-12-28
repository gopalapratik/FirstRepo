

package testscripts.cap;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import verify.Verify;

import browsersetup.BaseClass;
import pageobjects.cap.CustomerHistoryRefresh;
import pageobjects.cap.GooglePage;
import pageobjects.cap.GoogleSearch;
import pageobjects.cap.ViewLeadsPage;
import reporting.ListenerClass;
import utilities.ExcelUtilities;

@Listeners(ListenerClass.class)
public class CAPViewLeadsScripts extends BaseClass
{
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void ViewLeads(String environment, String clientName) throws InterruptedException
	{
		Thread.sleep(1000);
		ViewLeadsPage Vlead = new ViewLeadsPage(getDriver());
		Vlead = Vlead.Customer();
		if(Vlead.SCust().equals("Search Customer"))
			setAssertMessage("1 By default Search Customer page is displayed",1);
		Vlead = Vlead.VeiwLead();
		if(Vlead.VLtabel().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "3", 1)))
			setAssertMessage("2 Search Leads page displayed fields are Status Company First name Surname Postcode Assigned to",2);
		Vlead = Vlead.setFirstName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "3", 2));
		Vlead = Vlead.setLastName(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "3", 3));
		Vlead = Vlead.Assigned(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "3", 4));
		Vlead = Vlead.Search();
		assertEquals(Vlead.Result(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "3", 5));
		
		if(Vlead.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "3", 5)))
			setAssertMessage("3 Leads are displayed based on entered first name and Last Name",3);

	}
	
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void ViewLeadsTC36(String environment, String clientName) throws InterruptedException
	{
		Thread.sleep(1000);
		ViewLeadsPage Vlead = new ViewLeadsPage(getDriver());
		Vlead = Vlead.Customer();
		Vlead = Vlead.VeiwLead();
		if(Vlead.Status().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "36", 1)))
		setAssertMessage("By default only new/hold status leads is listed." ,1);
		Verify.verifyEquals(Vlead.Status(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "36", 1));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void ViewLeadsTC37(String environment, String clientName) throws InterruptedException
	{
		Thread.sleep(1000);
		ViewLeadsPage Vlead = new ViewLeadsPage(getDriver());
		Vlead = Vlead.Customer();
		Vlead = Vlead.VeiwLead();
		Vlead =Vlead.setStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 1));
		//Change By Rajesh
		// Set First name
		Vlead =Vlead.setFname();
		// set surname
		Vlead =Vlead.setSname();
		Thread.sleep(2000);
		// Change by Rajesh
		Vlead = Vlead.Assigned(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 4));
		Vlead = Vlead.Search();
		if(Vlead.StatusResult().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 2)))
		setAssertMessage("Leads are displayed based on selected status >>>" +Vlead.StatusResult() ,1);
		Verify.verifyEquals(Vlead.StatusResult(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 2));

		//Change By Rajesh
		
		Vlead =Vlead.setStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 3));
		//Change By Rajesh according to Data visiblity
		Vlead=Vlead.ClrFname();
		Vlead=Vlead.CLRSname();
		Vlead = Vlead.Assigned(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 4));
		Vlead = Vlead.Search();
		if(Vlead.StatusResult().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 5)))
		setAssertMessage("Leads are displayed based on selected status >>>" +Vlead.StatusResult() ,2);
		Verify.verifyEquals(Vlead.StatusResult(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 5));
		
		Vlead =Vlead.setStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 6));
		//Change By Rajesh according to Data visiblity   
		// Set First name
				Vlead =Vlead.setFname();
				// set surname
				Vlead =Vlead.setSname();
				Vlead = Vlead.Assigned(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 4));
				// Change by Rajesh As The data is not available 
		//Vlead = Vlead.Assigned(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 7));
		Vlead = Vlead.Search();
		if(Vlead.StatusResult().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 8)))
		setAssertMessage("Leads are displayed based on selected status >>>" +Vlead.StatusResult() ,3);
		Verify.verifyEquals(Vlead.StatusResult(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "37", 8));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
	
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void ViewLeadsTC38(String environment, String clientName) throws InterruptedException
	{
		Thread.sleep(1000);
		ViewLeadsPage Vlead = new ViewLeadsPage(getDriver());
		Vlead = Vlead.Customer();
		Vlead = Vlead.VeiwLead();
		Vlead =Vlead.setStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "38", 1));
		Vlead = Vlead.Assigned(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "38", 2));
		Vlead = Vlead.Search();
		CustomerHistoryRefresh refresh = new CustomerHistoryRefresh(getDriver());
//		if(Vlead.StatusResult().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "38", 3)))
//		setAssertMessage("Leads are displayed based on selected status >>>" +Vlead.StatusResult() ,1);
		Vlead = Vlead.CovertLd();
		Vlead = Vlead.window();
		// Change By Rajesh. Method is Changed And Status is set as Converted
		
		//Vlead = Vlead.EnterDetails();
		//CustomerHistoryRefresh refresh = new CustomerHistoryRefresh(getDriver());
		Vlead = Vlead.EnterDetails38();
		Vlead = Vlead.Search();// Data is not Available  after search so Tes case is getting Failed
		
		if(Vlead.StatusResult().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "38", 3)))
		setAssertMessage("Lead is converted into customer with proper customer id and details in CAP application. " ,1);
		Verify.verifyEquals(Vlead.StatusResult(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "38", 3));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void ViewLeadsTC39(String environment, String clientName) throws InterruptedException
	{
		Thread.sleep(1000);
		ViewLeadsPage Vlead = new ViewLeadsPage(getDriver());
		Vlead = Vlead.Customer();
		Vlead = Vlead.VeiwLead();
		Vlead =Vlead.setStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "39", 1));
		Vlead = Vlead.Assigned(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "39", 2));
		Vlead = Vlead.Search();
		Thread.sleep(3000);
		Vlead = Vlead.RejectLd();
		Thread.sleep(5000);
		Vlead = Vlead.windowReject();
		//CustomerHistoryRefresh refresh = new CustomerHistoryRefresh(getDriver());
		//Vlead = Vlead.EnterDetails();
		// Change By Rajesh Change Method 
		Vlead = Vlead.EnterDetails39();
		Thread.sleep(5000);
		Vlead = Vlead.Search();
		Thread.sleep(6000);
		if(Vlead.StatusResult().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "39", 3)))
		setAssertMessage("Lead is rejected and not converted into Customer. " ,1);
		System.out.println(Vlead.StatusResult());
		Verify.verifyEquals(Vlead.StatusResult(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "39", 3));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
	@Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void ViewLeadsTC40(String environment, String clientName) throws InterruptedException
	{
		Thread.sleep(1000);
		ViewLeadsPage Vlead = new ViewLeadsPage(getDriver());
		Vlead = Vlead.Customer();
		Vlead = Vlead.VeiwLead();
		Vlead =Vlead.setStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "40", 1));
		Thread.sleep(2000);
		Vlead = Vlead.Assigned(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "40", 2));
		Vlead = Vlead.Searchhold();
		Thread.sleep(10000);
		Vlead = Vlead.HoldLd();
		if(Vlead.Message().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "40", 3)))
		setAssertMessage("After Clicked on hold system displayed message >>>> "+Vlead.Message() ,1);
		
		
		Verify.verifyEquals(Vlead.Message(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "40", 3));
		Vlead = Vlead.EnterDetailsHold();
		Vlead = Vlead.Search();
		Thread.sleep(5000);
		
		
		if(Vlead.StatusResult().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "40", 4)))
			Thread.sleep(2000);
		setAssertMessage("Lead is on hold with status hold " ,2);
		Verify.verifyEquals(Vlead.StatusResult(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "VeiwLead", "40", 4));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
			
	}
	

	
	
}
