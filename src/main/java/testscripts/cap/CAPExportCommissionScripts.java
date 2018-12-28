
package testscripts.cap;

import static org.testng.Assert.assertEquals;

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
import pageobjects.cap.CustomerHistoryRefresh;
import pageobjects.cap.GooglePage;
import pageobjects.cap.GoogleSearch;
import pageobjects.cap.ProductPartnerList;
import pageobjects.cap.SearchBusinessUnit;
import pageobjects.cap.SearchStaffPage;
import pageobjects.cap.SetupBusinessUnit;
import pageobjects.cap.SetupProduct;
import pageobjects.cap.ViewLeadsPage;
import pageobjects.cap.*;
import reporting.ListenerClass;
import utilities.*;

//@Listeners(ListenerClass.class)

// displayed message is wrong . verification issue 
public class CAPExportCommissionScripts extends BaseClass
{
	//WebDriverWait wait1;
	@Test(enabled= true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Finance"})
	@Parameters({ "environment", "clientName" })
	public void ExportCommissionTC66(String environment, String clientName) throws InterruptedException
	{
		CreditControlSchemes CCS = new CreditControlSchemes(getDriver());
		SearchStaffPage staff=new SearchStaffPage(getDriver());
		CCS.FinanceLink();
		ExportCommission Exprtcomm = new ExportCommission(getDriver());
		Exprtcomm.CommissionLink();
		Thread.sleep(2000);
		Exprtcomm.RadioLink();
		Exprtcomm.PayrollCreateClick();
		Exprtcomm.WindowSwitch();
		if(Exprtcomm.WindowName.equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "66", 1)))
		setAssertMessage("Schemes is displayed when clicked.",3);
		Verify.verifyEquals(Exprtcomm.WindowName, ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "66", 1));
		if(staff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "66", 2)))
			setAssertMessage("System displays a message"+staff.Result(),3);
			Verify.verifyEquals(staff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Finance", "66", 2));
			
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");	
			
		
		
	}
	
}