package pageobjects.map;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
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

public class MAPLoanSale extends BaseClass {
	// WebDriver driver;
	// AndroidDriver androiddriver;

	public MAPLoanSale(AndroidDriver androiddriver) {
		setAndroidDriver(androiddriver);
		PageFactory.initElements(new AjaxElementLocatorFactory(getAndroidDriver(), 60), this);
	}

	@FindBy(xpath = "/html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-view[1]/div/loan-sale-header/div/div[2]/p")
	public WebElement loanSaleText;

	@FindBy(xpath = "//a[@id='nextViewButton']")
	// @FindBy(xpath =
	// "//a[@id='detailsWrapper']/form/div/div/a[contains(text(),'NEXT')]")
	public WebElement PTCnext;

	@FindBy(xpath = "//div[@id='notSeenCustomerIdRadio']")
	public WebElement KYCNotSeen;

	@FindBy(xpath = "//div[@id='notKnownCustomerIdRadio']")
	public WebElement KYCNotKnown;

	@FindBy(xpath = "//div[@id='1PiorDocRadio']")
	public WebElement PiorDoc1;

	@FindBy(xpath = "//div[@id='1SecDoc1SupDocRadio']")
	public WebElement SecDoc1SupDoc1;

	@FindBy(xpath = "//div[@id='2SupDocsRadio']")
	public WebElement SupDocs2;

	@FindBy(xpath = "//div[@id='cUKPassRadio']")
	public WebElement UKPass;

	// @FindBy(xpath =
	// "//input[@id='1PiorDocSection']/div[contains(@text(),'Document
	// Number')]/input")
	@FindBy(xpath = "//input[@ng-model = 'kycView.DN']")
	public WebElement PiorDoc1Section;

	@FindBy(xpath = "//a[@id='nextButton']")
	public WebElement KYCnext;
	@FindBy(xpath = "//div[@id='signatureWrapper'] //a[contains(text(),'Next')]")
	public WebElement KYCnext1;

	@FindBy(xpath = "//div[@id='signature']/canvas")
	public WebElement KYCSign;

	// @FindBy(xpath = "//div[@label = 'Wages']/div")
	@FindBy(xpath = "//div[@label = 'Wages']//input[@name='entry-value']")
	public WebElement Wages;

	@FindBy(xpath = "//div[@label = 'Wages']//div[@class='checkbox-container']")
	public WebElement WagesEvidence;

	// @FindBy(xpath = ".//select[@ng-model = 'entry.evidence.evidenceId']")
	@FindBy(xpath = "//div[@label = 'Wages']//select[@ng-model = 'entry.evidence.evidenceId']")
	public WebElement WagesDocument;

	// @FindBy(xpath = ".//input[@ng-model = 'entry.evidence.reference']")
	@FindBy(xpath = "//div[@label = 'Wages']//input[@ng-model = 'entry.evidence.reference']")
	public WebElement WagesReference;

	//@FindBy(xpath = "//div[@label = 'Rent']//div[@class='checkbox-container'][1]")
	@FindBy(xpath = "//div[@label = 'Rent']//div[@class='checkbox-container']")
	public List<WebElement> Rent_Check;

	//@FindBy(xpath = "//div[@label = 'Rent']//input[@name='entry-value']")
	@FindBy(xpath = "//div[@label = 'Rent']//input[@name='Rent0']")
	public WebElement RentAmmount;

	@FindBy(xpath = "//div[@label = 'Rent']//div[@class='checkbox-container'][2]")
	public WebElement RentEvidence;

	@FindBy(xpath = "//div[@label = 'Rent']//select[@ng-model = 'entry.evidence.evidenceId']")
	public WebElement RentDocument;

	@FindBy(xpath = "//div[@label = 'Rent']//input[@ng-model = 'entry.evidence.reference']")
	public WebElement RentReference;

	//@FindBy(xpath = "//slider[@ng-model = 'customer.affordability.affordability']")
	@FindBy(xpath = "//slider[@ng-model = 'customer.affordability.affordability']//div[@class='handle low']")
	public WebElement AffSlider;
	
	@FindBy(xpath = "//div[@id='affDeclConfirmCheckbox']/i")
	public WebElement confirmCheck;
	
	@FindBy(xpath = "//a[contains(text(),'NEXT')]")
	public WebElement AffNext;
	
	@FindBy(xpath = "//input[@id='netIncomeJson.enteredIncome']")
	public WebElement totalNetIncomeAmount;
	
	@FindBy(xpath = "//a[@id='netIncomeBtnSubmit']")
	public WebElement SubmitTotalNetIncomeButton;
	

	public MAPLoanSale clickPTCnext() {
		PTCnext.click();
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale clickKYCNotSeen() {
		if (!KYCNotSeen.isSelected()) {
			KYCNotSeen.click();
		}
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale clickKYCNotKnown() {
		if (!KYCNotKnown.isSelected()) {
			KYCNotKnown.click();
		}
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale clickPiorDoc1() {
		if (!PiorDoc1.isSelected()) {
			PiorDoc1.click();
		}
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale clickSecDoc1SupDoc1() {
		if (!SecDoc1SupDoc1.isSelected()) {
			SecDoc1SupDoc1.click();
		}
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale clickSupDocs2() {
		if (!SupDocs2.isSelected()) {
			SupDocs2.click();
		}
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale clickUKPass() {
		if (!UKPass.isSelected()) {
			UKPass.click();
		}
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale enterPiorDoc1Section(String doc) {
		PiorDoc1Section.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale clickKYCNext() {
		KYCnext.click();
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale clickKYCNext1() {
		KYCnext1.click();
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale enterSign() {
		Actions builder = new Actions(getAndroidDriver());
		builder.clickAndHold(KYCSign).moveByOffset(10, 50).moveByOffset(50, 10).moveByOffset(-10, -50)
				.moveByOffset(-50, -10).release().perform();
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale enterWages(String doc) {
		Wages.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale enterWagesEvidence() {
		if (!WagesEvidence.isSelected()) {
			WagesEvidence.click();
		}
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale selectWagesDocument(String doc) {
		Select s1 = new Select(WagesDocument);
		s1.selectByVisibleText(doc);

		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale enterWagesReference(String doc) {
		WagesReference.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale clickRentPaid() {
		for (int i = 1; i <= Rent_Check.size(); i++) {
			if (!Rent_Check.get(0).isSelected()) {
				Rent_Check.get(0).click();
				return new MAPLoanSale(getAndroidDriver());
			}
		}

		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale enterRentAmmount(String ammount) {
		// RentAmmount.clear();
		RentAmmount.sendKeys(ammount);
		try{
			getAndroidDriver().hideKeyboard();
			}catch (Exception e) {
				System.out.println("Keyboard Invisible");
			}
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale enterRentEvidence() {
		/*if (!RentEvidence.isSelected()) {
			RentEvidence.click();
		}*/
		for (int i = 1; i <= Rent_Check.size(); i++) {
			if (!Rent_Check.get(1).isSelected()) {
				Rent_Check.get(1).click();
				return new MAPLoanSale(getAndroidDriver());
			}
		}
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale selectRentDocument(String doc) {
		Select s1 = new Select(RentDocument);
		s1.selectByVisibleText(doc);

		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale enterRentReference(String doc) {
		RentReference.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale slider(int xoffset, int yoffset) {
		/*Actions move = new Actions(getAndroidDriver());
		Action action = (Action) move.dragAndDropBy(AffSlider, xoffset, yoffset).build();
		((Actions) action).perform();*/
		Actions builder = new Actions(getAndroidDriver());   
		builder.moveToElement(AffSlider).click().dragAndDropBy(AffSlider,AffSlider.getLocation().getY() +50, 0).build().perform();
		
		return new MAPLoanSale(getAndroidDriver());
	}
	
	public MAPLoanSale clickConfirmCheck() {
		if (!confirmCheck.isSelected()) {
			confirmCheck.click();
		}
		return new MAPLoanSale(getAndroidDriver());
	}
	
	public MAPLoanSale clickAffNext() {
			AffNext.click();
		return new MAPLoanSale(getAndroidDriver());
	}
	
	public MAPLoanSale enterTotalNetIncome(String Ammount) {
		totalNetIncomeAmount.clear();
		totalNetIncomeAmount.sendKeys(Ammount);
	return new MAPLoanSale(getAndroidDriver());
	}
	
	public MAPLoanSale clickSubmitTotalNetIncomeButton() {
		SubmitTotalNetIncomeButton.click();
	return new MAPLoanSale(getAndroidDriver());
	}
}
