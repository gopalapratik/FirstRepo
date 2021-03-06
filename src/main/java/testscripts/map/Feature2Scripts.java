package testscripts.map;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsersetup.BaseClass;
import pageobjects.cap.GooglePage;
import pageobjects.cap.GoogleSearch;
import reporting.ListenerClass;

@Listeners(ListenerClass.class)
public class Feature2Scripts extends BaseClass
{
	@Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression","Firm A","Module 1"})
	@Parameters({ "environment", "clientName" })
	public void automationScriptTwo(String environment, String clientName) throws InterruptedException
	{
		GooglePage googlepage = new GooglePage(getDriver());
		googlepage = googlepage.SettingLinkClick();
		GoogleSearch googlesearch = googlepage.searchsettingLinkClick();
		googlesearch = googlesearch.SafeSearchClick();
		googlesearch = googlesearch.instanceResultClick();
		googlesearch = googlesearch.ResultOpen();
		googlesearch = googlesearch.Save();
		Assert.assertTrue(googlesearch.acceptAlertMessage(), "Setting Not Saved");
	}

}
