package testscripts.map;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsersetup.BaseClass;
import pageobjects.cap.GooglePage;
import pageobjects.cap.SearchCustomer;
import reporting.ListenerClass;

@Listeners(ListenerClass.class)
public class Feature1Scripts extends BaseClass
{
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","Firm A","Module 1"})
	@Parameters({ "environment", "clientName" })
	public void automationScriptOne(String environment, String clientName) throws InterruptedException
	{
		GooglePage googlepage = new GooglePage(getDriver());
		String pageTitle = googlepage.getPageTitle();
		Assert.assertEquals("Google", pageTitle);
	}
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","CAP","Customer"})
	@Parameters({ "environment", "clientName" })
	public void TestCap(String environment, String clientName) throws InterruptedException
	{
		SearchCustomer d = new SearchCustomer(getDriver());
		String pageTitle = d.getPageTitle();
		Assert.assertEquals("CAP", pageTitle);
		
	}
	

}
