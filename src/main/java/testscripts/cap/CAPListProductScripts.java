
package testscripts.cap;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import browsersetup.BaseClass;
import pageobjects.cap.GooglePage;
import pageobjects.cap.GoogleSearch;
import pageobjects.cap.ListProduct;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchStaffPage;
import pageobjects.cap.SetupProduct;
import reporting.ListenerClass;
import utilities.ExcelUtilities;
import verify.Verify;

@Listeners(ListenerClass.class)
public class CAPListProductScripts extends BaseClass
{
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Product"})
	@Parameters({ "environment", "clientName" })
	public void ListProductTC54(String environment, String clientName) throws InterruptedException
	{
		SetupProduct setProd = new SetupProduct(getDriver());
		SearchStaffPage SStaff = new SearchStaffPage(getDriver());
		setProd.ProductLink();
		ListProduct list=new ListProduct(getDriver());
		list.productclick();
		list.AmendProduct();
		list.AmendTerm();
		list.SaveButton();
		System.out.println(list.add);
		String terms = list.add+" weeks";
		System.out.println(terms);
		if(SStaff.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "54", 1)))
			setAssertMessage("System Displayed message >>>>>>"+SStaff.Result(),1);
		Verify.verifyEquals(SStaff.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "54",1));
		if(terms.equals(list.Termresult()))
			setAssertMessage("Changes for product partner list is saved on CAP successfully.",1);
		Verify.verifyEquals(terms,list.Termresult());
		
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		
	}
}