
package testscripts.cap;

import static org.testng.Assert.assertEquals;

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
import pageobjects.cap.CustomerHistoryRefresh;
import pageobjects.cap.GooglePage;
import pageobjects.cap.GoogleSearch;
import pageobjects.cap.ProductPartnerList;
import pageobjects.cap.SetupProduct;
import pageobjects.cap.ViewLeadsPage;
import reporting.ListenerClass;
import utilities.*;

@Listeners(ListenerClass.class)
public class CAPProductPartnerListScripts extends BaseClass
{
	//WebDriverWait wait1;
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Product"})
	@Parameters({ "environment", "clientName" })
	public void ProductPartnerListTC55(String environment, String clientName) throws InterruptedException
	{
		SetupProduct setProd = new SetupProduct(getDriver());
		setProd.ProductLink();
		ProductPartnerList Partner =new ProductPartnerList(getDriver());
		Partner.PartnerlistClick();
		if(Partner.PListHeader().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "55", 1)))
		setAssertMessage("Existing partner list is displayed.",1);
		Verify.verifyEquals(Partner.PListHeader(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "55", 1));
		Partner.PartnrIDClick();
		System.out.println("out");
		if(Partner.PListIDHeader().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "55", 2)))
		setAssertMessage("Selected product partner is displayed." ,2);
		Verify.verifyEquals(Partner.PListIDHeader(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "55", 2));
		System.out.println("out");
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Product"})
	@Parameters({ "environment", "clientName" })
	public void ProductPartnerListTC56(String environment, String clientName) throws InterruptedException
	{
		SetupProduct setProd = new SetupProduct(getDriver());
		SetupProduct SStaff = new SetupProduct(getDriver());
		setProd.ProductLink();
		ProductPartnerList Partner =new ProductPartnerList(getDriver());
		Partner.PartnerlistClick();
		Partner.PartnrIDClick();
		Partner.AmendButton();
		Partner.setIdentifier();
		Partner.SaveButton();
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "56", 1)))
		setAssertMessage("System displayed message "+SStaff.Result(),1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "56", 1));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Product"})
	@Parameters({ "environment", "clientName" })
	public void ProductPartnerListTC57(String environment, String clientName) throws InterruptedException
	{
		SetupProduct setProd = new SetupProduct(getDriver());
		SetupProduct SStaff = new SetupProduct(getDriver());
		setProd.ProductLink();
		Thread.sleep(2000);
		ProductPartnerList Partner =new ProductPartnerList(getDriver());
		Partner.PartnerlistClick();
		Thread.sleep(2000);
		Partner.PartnrIDClick();
		Thread.sleep(2000);
		Partner.AmendButton();
		Thread.sleep(2000);
		Partner.setAddPrefix();
		Thread.sleep(2000);
		Partner.AddPrefixCheck();
		Thread.sleep(2000);
		Partner.AddButton();
		Thread.sleep(2000);
		Partner.SaveButton();
		Thread.sleep(3000);
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "57", 1)))
		setAssertMessage("System displayed message after add prefix >>>>"+SStaff.Result(),1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "57", 1));
		if(Partner.AddPref.equals(Partner.PrefixExpected()))
		setAssertMessage("Prefix added successfully",2);
		Verify.verifyEquals(Partner.AddPref, Partner.PrefixExpected());
		Partner.AmendButton();
		Thread.sleep(2000);
		Partner.SelectChk();
		Thread.sleep(2000);
		Partner.DeleteButton();
		Thread.sleep(2000);
		Partner.SaveButton();
		Thread.sleep(4000);
		// As Message is not displayed after saving .
		
//		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "57", 1)))
//		setAssertMessage("System displayed message after delete prefix >>>>"+SStaff.Result(),3);
//		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "57", 1));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		
	}
}