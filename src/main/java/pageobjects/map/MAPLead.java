package pageobjects.map;

import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import browsersetup.BaseClass;
import helpers.MAPFunctions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class MAPLead extends BaseClass {
	// WebDriver driver;
	// AndroidDriver androiddriver;

	public MAPLead(AndroidDriver androiddriver) {
		setAndroidDriver(androiddriver);
		PageFactory.initElements(new AjaxElementLocatorFactory(getAndroidDriver(), 60), this);
	}

	@FindBy(xpath = "//a[@id='open-new-lead']")
	public WebElement NewLead;

	@FindBy(xpath = "//div[contains(text(),'View Leads')]")
	public WebElement ViewLeads;

	@FindBy(xpath = "//select[@ng-model = 'lead.salutation']")
	public WebElement leadSalutation;

	@FindBy(xpath = "//input[@ng-model = 'lead.firstName']")
	public WebElement leadFirstName;

	@FindBy(xpath = "//input[@ng-model = 'lead.surname']")
	public WebElement leadSurname;

	@FindBy(xpath = "//input[@ng-model = 'lead.address.postcode']")
	public WebElement leadaddresspostcode;

	@FindBy(xpath = "//input[@ng-model = 'lead.address.flatNo']")
	public WebElement leadaddressflatNo;

	@FindBy(xpath = "//input[@ng-model = 'lead.address.houseNo']")
	public WebElement leadaddresshouseNo;

	@FindBy(xpath = "//input[@ng-model = 'lead.address.houseName']")
	public WebElement leadaddresshouseName;

	@FindBy(xpath = "//input[@ng-model = 'lead.address.street']")
	public WebElement leadaddressstreet;

	@FindBy(xpath = "//input[@ng-model = 'lead.address.locality']")
	public WebElement leadaddresslocality;

	@FindBy(xpath = "//input[@ng-model = 'lead.address.town']")
	public WebElement leadaddresstown;

	@FindBy(xpath = "//input[@ng-model = 'lead.address.county']")
	public WebElement leadaddresscounty;

	@FindBy(xpath = "//input[@ng-model = 'lead.dateOfBirth']")
	public WebElement DOB;

	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id='android:id/day']/android.widget.EditText[@resource-id='android:id/numberpicker_input']")
	public WebElement day;

	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id='android:id/month']/android.widget.EditText[@resource-id='android:id/numberpicker_input']")
	public WebElement month;

	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id='android:id/year']/android.widget.EditText[@resource-id='android:id/numberpicker_input']")
	public WebElement year;

	@FindBy(xpath = "//android.widget.Button[@text='Set']")
	public WebElement set;

	@FindBy(xpath = "//input[@ng-model = 'lead.homePhone']")
	public WebElement telephoneNo;

	@FindBy(xpath = "//input[@ng-model = 'lead.mobile']")
	public WebElement mobileNo;

	@FindBy(xpath = "//select[@ng-model = 'lead.maritalStatus']")
	public WebElement maritalStatus;

	// @FindBy(xpath = "//input[@ng-model = 'lead.bankruptSequestrated' AND
	// @text='No']")
	@FindBy(xpath = "//label[contains(text(),'No')]/input[@ng-model='lead.bankruptSequestrated']//following-sibling::span/i[1]")
	public WebElement bankruptSequestrated_No;

	@FindBy(xpath = "//label[contains(text(),'Yes')]/input[@ng-model='lead.bankruptSequestrated']//following-sibling::span/i[1]")
	public WebElement bankruptSequestrated_Yes;

	@FindBy(xpath = "//label[contains(text(),'No')]/input[@ng-model='lead.ivaDroMapScotland']//following-sibling::span/i[1]")
	public WebElement ivaDroMapScotland_No;

	@FindBy(xpath = "//label[contains(text(),'Yes')]/input[@ng-model='lead.ivaDroMapScotland']//following-sibling::span/i[1]")
	public WebElement ivaDroMapScotland_Yes;

	@FindBy(xpath = "//label[contains(text(),'No')]/input[@ng-model='lead.cabDma']//following-sibling::span/i[1]")
	public WebElement cabDma_No;

	@FindBy(xpath = "//label[contains(text(),'Yes')]/input[@ng-model='lead.cabDma']//following-sibling::span/i[1]")
	public WebElement cabDma_Yes;

	@FindBy(xpath = "//input[@id='details-next-button']")
	public WebElement details_next;

	@FindBy(xpath = "//label[contains(text(),'I agree with the terms above')]")
	public WebElement IAgree;

	@FindBy(xpath = "//input[@id='confirmation-next-button']")
	public WebElement confirmation_next;

	@FindBy(xpath = "//div[@id='signCustomerLead']/canvas")
	public WebElement CustomerSign;

	@FindBy(xpath = "//a[@id='signature-next-button']")
	public WebElement signature_next;

	/*@FindBy(xpath = "//div[contains(text(),'AutoLead1 AutoLead1')]")
	public WebElement viewLeads_Lead;

	@FindBy(xpath = "//div[contains(text(),'AutoLead1 AutoLead1')]//following-sibling::div[contains(@ng-class,'leadsStatuses')]")
	public WebElement viewLeads_Status;

	@FindBy(xpath = "//div[contains(text(),'AutoLead1 AutoLead1')]//following-sibling::div[contains(@class,'leads-row-address')]")
	public WebElement viewLeads_Adress;*/

	@FindBy(xpath = "//span[contains(text(),'STATUS')]//following-sibling::span")
	public WebElement viewLeadsDetails_Status;
	@FindBy(xpath = "//div[contains(text(),'Full Name')]//following-sibling::div/p/span[@ng-bind='ref.TITLE_DESC[lead.salutation]']")
	public WebElement viewLeads_Title;
	@FindBy(xpath = "//div[contains(text(),'Full Name')]//following-sibling::div/p/span[@ng-bind='lead.firstName']")
	public WebElement viewLeads_FirstName;
	@FindBy(xpath = "//div[contains(text(),'Full Name')]//following-sibling::div/p/span[@ng-bind='lead.surname']")
	public WebElement viewLeads_SurName;
	@FindBy(xpath = "//div[contains(text(),'Home Address')]//following-sibling::div/p/span")
	public WebElement viewLeads_HomeAddress;
	@FindBy(xpath = "//div[contains(text(),'Date of Birth')]//following-sibling::div/p/span")
	public WebElement viewLeads_DOB;
	@FindBy(xpath = "//div[contains(text(),'E-mail')]//following-sibling::div/p/span")
	public WebElement viewLeads_Email;
	@FindBy(xpath = "//div[contains(text(),'Home phone')]//following-sibling::div/p/span")
	public WebElement viewLeads_HomePhone;
	@FindBy(xpath = "//div[contains(text(),'Mobile')]//following-sibling::div/p/span")
	public WebElement viewLeads_Mobile;
	@FindBy(xpath = "//div[contains(text(),'Marital Status')]//following-sibling::div/p/span")
	public WebElement viewLeads_MaritalStatus;
	@FindBy(xpath = "//div[contains(text(),'Reject Reason')]//following-sibling::div/p/span")
	public WebElement viewLeads_RejectReason;

	@FindBy(xpath = "//span[contains(text(),'LOAN SALE')]")
	public WebElement LeadloanSale;

	@FindBy(xpath = "//button[@ng-click='closeLeadDetails()']")
	public WebElement closeLeadDetails;

	@FindBy(xpath = "//span[@id='search-icon']")
	public WebElement searchButton;

	@FindBy(xpath = "//input[@id='search-box']")
	public WebElement searchBox;

	@FindBy(xpath = "//button[@ng-click='closeSearch()']")
	public WebElement SearchBackButton;
	
	public MAPLead clickNewLead() {
		NewLead.click();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead selectLeadSalutation(String doc) {
		Select s1 = new Select(leadSalutation);
		s1.selectByVisibleText(doc);
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead enterLeadFirstName(String doc) {
		leadFirstName.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead enterLeadSurname(String doc) {
		leadSurname.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead enterleadaddresspostcode(String doc) {
		leadaddresspostcode.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead enterleadaddressflatNo(String doc) {
		leadaddressflatNo.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead enterleadaddresshouseNo(String doc) {
		leadaddresshouseNo.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead enterleadaddresshouseName(String doc) {
		leadaddresshouseName.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead enterleadaddressstreet(String doc) {
		leadaddressstreet.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead enterleadaddresslocality(String doc) {
		leadaddresslocality.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead enterleadaddresstown(String doc) {
		leadaddresstown.clear();
		leadaddresstown.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead enterleadaddresscounty(String doc) {
		leadaddresscounty.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead enterDOB() throws InterruptedException {
		// DOB.sendKeys(doc);
		/*
		 * StringTokenizer st = new StringTokenizer(doc);
		 * 
		 * while(st.hasMoreTokens()){ System.out.println("Next token is : " +
		 * st.nextToken("/")); }
		 */
		// DOB.click();
		Actions action = new Actions(getAndroidDriver()).doubleClick(DOB);
		action.build().perform();
		Thread.sleep(1000);
		MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
		MAPfunctions.switchContext("NATIVE");
		day.clear();
		day.sendKeys("05");
		month.clear();
		month.sendKeys("Jul");
		year.clear();
		year.sendKeys("1952");
		getAndroidDriver().hideKeyboard();
		set.click();
		MAPfunctions.switchContext("WEBVIEW");
		return new MAPLead(getAndroidDriver());
	}
	
	public MAPLead enterDOB(String Date) throws InterruptedException {
		String[] split=Date.split(" ");
		/*String d1 =null;
		String d2 =null;
		String d3 =null;
		for(int i=0;i<=split.length;i++)
		{
			d1=split[0];
			d2=split[1];
			d3=split[2];
		}*/
		Actions action = new Actions(getAndroidDriver()).doubleClick(DOB);
		action.build().perform();
		Thread.sleep(1000);
		MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
		MAPfunctions.switchContext("NATIVE");
		day.clear();
		day.sendKeys(split[0]);
		month.clear();
		month.sendKeys(split[1]);
		year.clear();
		year.sendKeys(split[2]);
		getAndroidDriver().hideKeyboard();
		set.click();
		MAPfunctions.switchContext("WEBVIEW");
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead entertelephoneNo(String doc) {
		telephoneNo.click();
		// getAndroidDriver().hideKeyboard();
		telephoneNo.sendKeys(doc);
		// getAndroidDriver().hideKeyboard();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead entermobileNo(String doc) {
		mobileNo.click();
		// getAndroidDriver().hideKeyboard();
		mobileNo.sendKeys(doc);
		// getAndroidDriver().hideKeyboard();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead selectMaritalStatus(String doc) {
		Select s1 = new Select(maritalStatus);
		s1.selectByVisibleText(doc);
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead selectbankruptSequestrated_No() {
		if (!bankruptSequestrated_No.isSelected()) {
			bankruptSequestrated_No.click();
		}
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead selectivaDroMapScotland_No() {
		if (!ivaDroMapScotland_No.isSelected()) {
			ivaDroMapScotland_No.click();
		}
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead selectcabDma_No() {
		if (!cabDma_No.isSelected()) {
			cabDma_No.click();
		}
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead clickDetailsNext() {
		details_next.click();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead clickIAgree() {
		IAgree.click();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead clickConfirmationNext() {
		confirmation_next.click();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead enterCustomerSign() {
		Actions builder = new Actions(getAndroidDriver());
		builder.clickAndHold(CustomerSign).moveByOffset(10, 50).moveByOffset(50, 10).moveByOffset(-10, -50)
				.moveByOffset(-50, -10).release().perform();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead clickSignatureNext() {
		signature_next.click();
		return new MAPLead(getAndroidDriver());
	}

	/*public MAPLead clickLead() {
		viewLeads_Lead.click();
		return new MAPLead(getAndroidDriver());
	}*/
	
	public MAPLead SelectLead(String lead) {
		getAndroidDriver().findElement(By.xpath("//div[contains(text(),'"+lead+"')]")).click();
		return new MAPLead(getAndroidDriver());
	}

	/*public String verifyLeadStatus() {
		System.out.println(viewLeads_Status.getText());
		return viewLeads_Status.getText();
	}*/

	public String verifyLeadStatus(String Customer) {
		String status;
		status = getAndroidDriver().findElement(By.xpath("//div[contains(text(),'"+Customer+"')]//following-sibling::div[contains(@ng-class,'leadsStatuses')]")).getText();
		System.out.println("Lead status " + status);
		return status;
	}

	public String verifyLeadAddress(String Customer) {
		String address;
		address = getAndroidDriver().findElement(By.xpath("//div[contains(text(),'"+Customer+"')]//following-sibling::div[contains(@class,'leads-row-address')]")).getText();
		//div[contains(text(),'AutoLead1 AutoLead1')]//following-sibling::div[contains(@class,'leads-row-address')]
		System.out.println("Lead address " + address);
		return address;
	}

	public String verifyViewLeadFullName() {
		return viewLeads_Title.getText() + " " + viewLeads_FirstName.getText() + " " + viewLeads_SurName.getText();
	}

	public String verifyViewLeadDetailsStatus() {
		return viewLeadsDetails_Status.getText();
	}

	public String verifyViewLeadDetailsHomeAddress() {
		return viewLeads_HomeAddress.getText();
	}

	public String verifyViewLeadDetailsDOB() {
		return viewLeads_DOB.getText();
	}

	public String verifyViewLeadDetailsEmail() {
		return viewLeads_Email.getText();
	}

	public String verifyViewLeadDetailsHomePhone() {
		return viewLeads_HomePhone.getText();
	}

	public String verifyViewLeadDetailsMobile() {
		return viewLeads_Mobile.getText();
	}

	public String verifyViewLeadDetailsMaritalStatus() {
		return viewLeads_MaritalStatus.getText();
	}

	public String verifyViewLeadDetailsRejectReason() {
		return viewLeads_RejectReason.getText();
	}

	public MAPLead clickLeadLoanSale() {
		LeadloanSale.click();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead clickcloseLeadDetails() {
		closeLeadDetails.click();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead SearchLead(String leadName) {
		searchButton.click();
		if (searchBox.isEnabled()) {
			searchBox.clear();
			searchBox.sendKeys(leadName + Keys.ENTER);
		}
		return new MAPLead(getAndroidDriver());
	}

	public String verifyLeadInSearch(String Customer) {
		String lead;
		//lead = getAndroidDriver().findElement(By.xpath("//div[contains(text(),'"+Customer+"')]")).getText();
		lead = getAndroidDriver().findElement(By.xpath("//div[contains(text(),'"+Customer+"')]//parent::div[@class='search-customers-name ng-binding']")).getText();
		System.out.println("Lead name " + lead);
		return lead;
	}
	
	public MAPLead clickSearchBackButton() {
		SearchBackButton.click();
		return new MAPLead(getAndroidDriver());
	}
}
