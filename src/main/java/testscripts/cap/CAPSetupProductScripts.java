

package testscripts.cap;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsersetup.BaseClass;
import pageobjects.cap.SetupProduct;
import reporting.ListenerClass;
import utilities.ExcelUtilities;
import verify.Verify;

@Listeners(ListenerClass.class)
public class CAPSetupProductScripts extends BaseClass
{
	WebDriverWait wait1;
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Product"})
	@Parameters({ "environment", "clientName" })
	public void SetupProductTC53(String environment, String clientName) throws InterruptedException
	{
		SetupProduct setProd = new SetupProduct(getDriver());
		setProd.ProductLink();
		setProd.SetuProduct();
		setProd.setPIdentifier();
		setProd.setPDescription(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "53", 2));
		setProd.setPType(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "53", 3));
		setProd.setPStatus(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "53", 4));
		setProd.setPTerm(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "53", 5));
		setProd.setPTermTyper(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "53", 6));
		setProd.setPIntRate(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "53", 7));
		setProd.setPAPR(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "53", 8));
		setProd.setPGranularity(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "53", 9));
		setProd.setPMinAge(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "53", 10));
		setProd.setPMaxAge(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "53", 11));
		setProd.setPMinLoan(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "53", 12));
		setProd.setPMaxLoan(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "53", 13));
		setProd.setPMinRenewalLoan(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "53", 14));
		setProd.setPNAxRenewalLoan(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "53", 15));
		setProd.SaveButton();
		wait1=new WebDriverWait(getDriver(), 40);
		wait1.until(ExpectedConditions.visibilityOf(setProd.PTypeList));
//		System.out.println("next page");
//		System.out.println(setProd.PTypeList.getText());
//		System.out.println(setProd.PIdentifierText);
		if(setProd.Result().equals(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "53", 16)))
		setAssertMessage("System displays message "+setProd.Result() ,1);
		Verify.verifyEquals(setProd.Result(), ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "Product", "53", 16));
		if(setProd.PTypeList.getText().equals(setProd.PIdentifierText))
		setAssertMessage("Product Created Successfully" ,2);
		Verify.verifyEquals(setProd.PTypeList.getText(), setProd.PIdentifierText);
			
		Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
		
		
	}
}