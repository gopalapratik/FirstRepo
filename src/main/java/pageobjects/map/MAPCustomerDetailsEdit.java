package pageobjects.map;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import browsersetup.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class MAPCustomerDetailsEdit extends BaseClass {

	public MAPCustomerDetailsEdit(AndroidDriver androiddriver) {
		setAndroidDriver(androiddriver);
		PageFactory.initElements(new AjaxElementLocatorFactory(getAndroidDriver(), 120), this);
	}

	@FindBy(xpath = "//div[@id='go-to-customers-details']")
	public WebElement editCustomerDetails;

	@FindBy(xpath = "//input[@id='client.customerAddress.flatNo']")
	public WebElement flatNo;

	@FindBy(xpath = "//input[@id='client.customerAddress.street']")
	public WebElement street;

	@FindBy(xpath = "//input[@id='client.customerAddress.county']")
	public WebElement country;

	@FindBy(xpath = "//input[@id='client.homePhone']")
	public WebElement telephoneNo;

	@FindBy(xpath = "//input[@id='client.mobile']")
	public WebElement mobileNo;
	
	@FindBy(xpath = "//input[@id='client.email']")
	public WebElement email;
	
	@FindBy(xpath = "//input[@name='reemailAddress']")
	public WebElement reEmail;

	@FindBy(xpath = "//input[@id='client.NINumber']")
	public WebElement NINumber;

	@FindBy(xpath = "//select[@id='client.nationality']")
	public WebElement Nationality;

	@FindBy(xpath = "//button[@id='confirmCustomerDetailsButton']")
	public WebElement confirmCustomerDetailsButton;

	@FindBy(xpath = "//span[@id='closeEditCustomerDetailsButton']")
	public WebElement closeEditCustomerDetailsButton;
	
	@FindBy(xpath = "//button[@id='confirmModalButton']")
	public WebElement confirmModalButton;
	
	@FindBy(xpath = "//button[@id='cancelModalButton']")
	public WebElement cancelModalButton;
	
	@FindBy(xpath = "//div[contains(@ng-bind,'customer.ninumber')]")
	public WebElement VerifyNINumber;


	public MAPCustomerDetailsEdit clickEditCustomerDetails() {
		editCustomerDetails.click();
		return new MAPCustomerDetailsEdit(getAndroidDriver());
	}

	public MAPCustomerDetailsEdit enterFlatNo(String flat) {
		flatNo.clear();
		flatNo.sendKeys(flat);
		getAndroidDriver().hideKeyboard();
		return new MAPCustomerDetailsEdit(getAndroidDriver());
	}
	
	public String verifyFlatNo() {
		return flatNo.getText();
	}
	
	public MAPCustomerDetailsEdit enterStreetName(String StreetName) {
		street.clear();
		street.sendKeys(StreetName);
		getAndroidDriver().hideKeyboard();
		return new MAPCustomerDetailsEdit(getAndroidDriver());
	}

	public MAPCustomerDetailsEdit enterCountryName(String Country) {
		country.clear();
		country.sendKeys(Country);
		getAndroidDriver().hideKeyboard();
		return new MAPCustomerDetailsEdit(getAndroidDriver());
	}

	public MAPCustomerDetailsEdit enterTelephoneNo(String No) {
		telephoneNo.clear();
		telephoneNo.sendKeys(No);
		getAndroidDriver().hideKeyboard();
		return new MAPCustomerDetailsEdit(getAndroidDriver());
	}
	
	public MAPCustomerDetailsEdit enterMobileNo(String No) {
		mobileNo.clear();
		mobileNo.sendKeys(No);
		getAndroidDriver().hideKeyboard();
		return new MAPCustomerDetailsEdit(getAndroidDriver());
	}
	
	public MAPCustomerDetailsEdit enterEmail(String emailid) {
		email.clear();
		email.sendKeys(emailid);
		getAndroidDriver().hideKeyboard();
		return new MAPCustomerDetailsEdit(getAndroidDriver());
	}
	
	public MAPCustomerDetailsEdit enterReEmail(String emailid) {
		reEmail.clear();
		reEmail.sendKeys(emailid);
		getAndroidDriver().hideKeyboard();
		return new MAPCustomerDetailsEdit(getAndroidDriver());
	}

	public MAPCustomerDetailsEdit enterNINumber(String No) {
		NINumber.clear();
		NINumber.sendKeys(No);
		getAndroidDriver().hideKeyboard();
		return new MAPCustomerDetailsEdit(getAndroidDriver());
	}

	public MAPCustomerDetailsEdit selectNationality(String Nationalit) {
		Select S1 = new Select(Nationality);
		S1.selectByVisibleText(Nationalit);
		;
		return new MAPCustomerDetailsEdit(getAndroidDriver());
	}

	public MAPCustomerDetailsEdit clickConfirmCustomerDetailsButton() {
		confirmCustomerDetailsButton.click();
		return new MAPCustomerDetailsEdit(getAndroidDriver());
	}
	
	public String VerifyConfirmCustomerDetailsButton() {
		return confirmCustomerDetailsButton.getText();
	}

	public MAPCustomerDetailsEdit clickCloseEditCustomerDetailsButton() {
		closeEditCustomerDetailsButton.click();
		return new MAPCustomerDetailsEdit(getAndroidDriver());
	}
	
	public MAPCustomerDetailsEdit clickConfirmModalButton() {
		confirmModalButton.click();
		return new MAPCustomerDetailsEdit(getAndroidDriver());
	}
	
	public MAPCustomerDetailsEdit clickCancelModalButton() {
		cancelModalButton.click();
		return new MAPCustomerDetailsEdit(getAndroidDriver());
	}
	
	public String VerifyCustomerNINumber() {
		return VerifyNINumber.getText();
	}
}
