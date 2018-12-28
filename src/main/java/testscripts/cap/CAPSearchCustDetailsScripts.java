
package testscripts.cap;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import browsersetup.BaseClass;
//import reporting.ListenerClass;
import pageobjects.*;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchCustomerDetails;
import reporting.ListenerClass;
import utilities.ExcelUtilities;
import verify.Verify;
//@Listeners(ListenerClass.class)
public class CAPSearchCustDetailsScripts extends BaseClass {

	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustDetailsTC14(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerDetails ScustDetail = new SearchCustomerDetails(getDriver());
		Thread.sleep(3000);
		Scustomer = Scustomer.Customer();
		Thread.sleep(3000);
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("By default Search Customer page is displayed",1);
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "14", 1));	
		Thread.sleep(3000);
		Scustomer = Scustomer.Search();
		Thread.sleep(3000);
		Scustomer = Scustomer.cusIDclick();
		Thread.sleep(3000);
		//ScustDetail = ScustDetail.CustomerLink();
		ScustDetail.CustDetail();
		Thread.sleep(3000);
	
		if(ScustDetail.AGGNINO().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "14", 2)))
			setAssertMessage("NI Number is displayed under Aggreement details Tab",2);
		Verify.verifyEquals(ScustDetail.AGGNINO(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "14", 2));
		if(ScustDetail.AGGEmail().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "14", 3)));
			setAssertMessage("Email Address is displayed under Aggreement details Tab",3);
		Verify.verifyEquals(ScustDetail.AGGEmail(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "14", 3));
		if(ScustDetail.AGGHomeVisit().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "14", 4)));
		setAssertMessage("Home Visit Form is displayed under Aggreement details Tab",4);
		Verify.verifyEquals(ScustDetail.AGGHomeVisit(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "14", 4));
		if(ScustDetail.AGGPD().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "14", 5)));
		setAssertMessage("Proof of Address is displayed under Aggreement details Tab",5);
		Verify.verifyEquals(ScustDetail.AGGPD(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "14", 5));
		if(ScustDetail.AGGBusStream().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "14", 6)));
		setAssertMessage("Business Stream is displayed under Aggreement details Tab",6);
		Verify.verifyEquals(ScustDetail.AGGBusStream(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "14", 6));
		if(ScustDetail.AGGcollfreq().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "14", 7)));
		setAssertMessage("Collection Frequency is displayed under Aggreement details Tab",7);
		Verify.verifyEquals(ScustDetail.AGGcollfreq(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "14", 7));
		if(ScustDetail.AGGcollectedon().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "14", 8)));
		setAssertMessage("Collected On is displayed under Aggreement details Tab",8);
		Verify.verifyEquals(ScustDetail.AGGcollectedon(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "14", 8));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		//setAssertMessage(message, verificationNumber);
	}
	
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustDetailsTC15(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerDetails ScustDetail = new SearchCustomerDetails(getDriver());
		Scustomer = Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("By default Search Customer page is displayed",1);
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "15", 1));	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		//ScustDetail = ScustDetail.CustomerLink();
		ScustDetail.CustDetail();
	
		if(ScustDetail.AGGEmailData()!="")
			setAssertMessage("Email Id is availabel for this CustomerID ",2);
		String result = String.valueOf(ScustDetail.MEmailAppted());
		//if(result.equals("true"))
		
		if(result.equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "15", 2)))
			setAssertMessage("Email documentation opted in checkbox is selected ",3);
		Verify.verifyEquals(result, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "15", 2));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustDetailsTC16(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerDetails ScustDetail = new SearchCustomerDetails(getDriver());
		Scustomer = Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("By default Search Customer page is displayed",1);
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "16", 1));	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		//ScustDetail = ScustDetail.CustomerLink();
		ScustDetail.CustDetail();
		ScustDetail.AmendButton();
		ScustDetail.MarCheckSMStext();
		if(ScustDetail.AGGEmailData().equalsIgnoreCase(""))
		{
		ScustDetail.MarCheckemail();
		}
		ScustDetail.MarCheckTelephone();
		ScustDetail.MarCheckLetter();
		ScustDetail.MarCheckMarReasearch();
		ScustDetail.SaveButton();
		if(ScustDetail.ResultMesage().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "16", 2)))
			setAssertMessage("Details Saved Successfully ",2);
		Verify.verifyEquals(ScustDetail.ResultMesage(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "16", 2));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void SearchCustDetailsTC17(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer Scustomer = new SearchCustomer(getDriver());
		SearchCustomerDetails ScustDetail = new SearchCustomerDetails(getDriver());
		Scustomer = Scustomer.Customer();
		if(Scustomer.SCust().equals("Search Customer"))
			setAssertMessage("By default Search Customer page is displayed",1);
		Scustomer = Scustomer.setCID(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "17", 1));	
		Scustomer = Scustomer.Search();
		Scustomer = Scustomer.cusIDclick();
		//ScustDetail = ScustDetail.CustomerLink();
		ScustDetail.CustDetail();
		ScustDetail.AmendButton();
		ScustDetail.setAGGEmail(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "17", 2));
		ScustDetail.MarCheckSMStext();
		ScustDetail.SaveButton();
		if(ScustDetail.ResultMesage().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "17", 3)))
			setAssertMessage("Action Completed Successfully ",2);
		Verify.verifyEquals(ScustDetail.ResultMesage(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "17", 3));
		if(ScustDetail.AGGEmailData().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "17", 4)))
			setAssertMessage("Email Id we entered is saved successfully  ",3);
		Verify.verifyEquals(ScustDetail.AGGEmailData(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "17", 4));
		String result = String.valueOf(ScustDetail.AmendCheckSMStext());
		if(result.equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "17", 5)))
			setAssertMessage("SMS/text checkbox under Marketing information tab is selected   ",4);
		Verify.verifyEquals(result, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "17", 5));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
	}
	
	
	
	

}
