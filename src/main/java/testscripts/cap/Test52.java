package testscripts.cap;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsersetup.BaseClass;
import pageobjects.cap.ProductPartnerList;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchCustomerTransaction;
import pageobjects.cap.SearchStaffPage;
import pageobjects.cap.SetupProduct;
import utilities.ExcelUtilities;
import verify.Verify;

public class Test52 extends BaseClass{
	
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
		Thread.sleep(5000);
		Partner.SelectChk();
		Thread.sleep(2000);
		Partner.DeleteButton();
		Thread.sleep(2000);
		Partner.SaveButton();
		Thread.sleep(4000);
//		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "57", 1)))
//		setAssertMessage("System displayed message after delete prefix >>>>"+SStaff.Result(),3);
//		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "57", 1));
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		
	}

}
