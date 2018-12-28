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

public class MAPLoanSale_ProductSelection extends BaseClass {
	// WebDriver driver;
	// AndroidDriver androiddriver;

	public MAPLoanSale_ProductSelection(AndroidDriver androiddriver) {
		setAndroidDriver(androiddriver);
		PageFactory.initElements(new AjaxElementLocatorFactory(getAndroidDriver(), 120), this);
	}

	@FindBy(xpath = "//div[@id='sameAsHomeAddressCheckbox']//div[@class='checkbox-container']/i")
	public WebElement sameAsHomeAddressCheckbox;

	@FindBy(xpath = "//div[@id='collectionFrequencyRadios']/div[@label='Weekly']/i")
	public WebElement Weekly;

	@FindBy(xpath = "//div[@id='collectionFrequencyRadios']/div[@label='Fortnightly']/i")
	public WebElement Fortnightly;

	@FindBy(xpath = "//div[@id='collectionFrequencyRadios']/div[@label='Monthly']/i")
	public WebElement Monthly;

	@FindBy(xpath = "//select[@ng-model = 'viewData.collectionDay']")
	public WebElement CollectionDay;

	@FindBy(xpath = "//select[@ng-model = 'viewData.nationality']")
	public WebElement Nationality;

	@FindBy(xpath = "//input[@ng-model = 'viewData.niNumber']")
	public WebElement NINumber;

	@FindBy(xpath = "//select[@ng-model = 'viewData.deliveryType']")
	public WebElement DeliveryMethod;

	@FindBy(xpath = "//div[@label='ADDITIONAL']/i")
	public WebElement loanType_Additional;

	@FindBy(xpath = "//select[@ng-model = 'viewData.product']")
	public WebElement productType;

	@FindBy(xpath = "//select[@ng-model = 'viewData.loanReason']")
	public WebElement reasonForLoan;

	@FindBy(xpath = "//select[@ng-model = 'viewData.householdCompositionAdult']")
	public WebElement HCAdults;

	@FindBy(xpath = "//select[@ng-model = 'viewData.householdCompositionChildren']")
	public WebElement HCChildren;

	@FindBy(xpath = "//select[@ng-model = 'viewData.residentialStatus']")
	public WebElement ResidentialStatus;

	@FindBy(xpath = "//select[@ng-model = 'viewData.propertyStatus']")
	public WebElement PropertyStatus;

	@FindBy(xpath = "//select[@ng-model = 'viewData.employmentStatus']")
	public WebElement EmploymentStatus;

	@FindBy(xpath = "//a[contains(text(),'NEXT')]")
	public WebElement ProductSelection_Next;

	@FindBy(xpath = "//button[@id='confirmSecciButton']")
	public WebElement SECCI_Close;

	@FindBy(xpath = "//button[@id='closePreContractButton']")
	public WebElement SECCI_closePreContractButton;

	@FindBy(xpath = "//div[@id='signCustomerSECCI']/canvas")
	public WebElement SECCISign;

	@FindBy(xpath = "//a[contains(text(),'NEXT')]")
	public WebElement SECCI_Next;

	@FindBy(xpath = "//a[contains(text(),'NEXT')]")
	public WebElement TC_Next;

	@FindBy(xpath = "//ion-content[@id='marketR']//a[contains(text(),'NEXT')]")
	public WebElement MC_Next;

	@FindBy(xpath = "//div[@id='signCustomerMR']/canvas")
	public WebElement MRSign;

	@FindBy(xpath = "//ion-content[@id='LoanSignature']//a[contains(text(),'NEXT')]")
	public WebElement MR_Next;

	@FindBy(xpath = "//ion-content[@id='loanAgreement']//div[contains(text(),'Fixed sum loan')]")
	public WebElement typeOfCredit;

	@FindBy(xpath = "//ion-content[@id='loanAgreement']//div[contains(text(),'Total amount of credit')]//following-sibling::div")
	public WebElement totalAmmountCredit;

	@FindBy(xpath = "//ion-content[@id='loanAgreement']//div[contains(text(), 'The duration of the credit agreement')]//following-sibling::div/div")
	public WebElement durationOfCredit;

	@FindBy(xpath = "//ion-content[@id='loanAgreement']//div[contains(text(), 'Number payable')]//following-sibling::div/div")
	public WebElement noOfPayable;

	@FindBy(xpath = "//ion-content[@id='loanAgreement']//a[contains(text(),'NEXT')]")
	public WebElement LoanAgreement_Next;

	@FindBy(xpath = "//ion-modal-view[@class='modal-view loan-agreement-modal modal slide-in-up ng-enter active ng-enter-active']//div[@id='acceptTermsAndCondButton']")
	public WebElement AcceptTermsCondition;

	@FindBy(xpath = "//div[@id='signCustomerLoan']/canvas")
	public WebElement CustomerLoansign;

	@FindBy(xpath = "//ion-content[@id='LoanSignature']//a[contains(text(),'NEXT')]")
	public WebElement LoanAgreement_Next1;
	
	@FindBy(xpath = "//div[@id='signature']/canvas")
	public WebElement Agentsign;

	@FindBy(xpath = "//div[@id='signatureWrapper']//a[contains(text(),'NEXT')]")
	public WebElement LoanAgreement_AgentNext;
	
	
	@FindBy(xpath = "/html/body/div[8]/div[2]/ion-modal-view/ion-content/div[1]/div/p")
	public WebElement LoanTransactionMessage;
	
	@FindBy(xpath = "//button[@id='confirmLoanButton']")
	public WebElement OKTransaction;
	
	public MAPLoanSale_ProductSelection clicksameAsHomeAddressCheckbox() {
		sameAsHomeAddressCheckbox.click();
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection clickWeeklyRadio() {
		if (!Weekly.isSelected()) {
			Weekly.click();
		}
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection clickFortnightlyRadio() {
		if (!Fortnightly.isSelected()) {
			Fortnightly.click();
		}
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection clickMonthlyRadio() {
		if (!Monthly.isSelected()) {
			Monthly.click();
		}
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection selectCollectionDay(String doc) {
		Select s1 = new Select(CollectionDay);
		s1.selectByVisibleText(doc);
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection selectNationality(String doc) {
		Select s1 = new Select(Nationality);
		s1.selectByVisibleText(doc);
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection enterNiNumber(String doc) {
		NINumber.clear();
		NINumber.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection selectDeliveryMethod(String doc) {
		Select s1 = new Select(DeliveryMethod);
		s1.selectByVisibleText(doc);
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection LoanType_additional() {
		loanType_Additional.click();
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection selectProductType(String doc) {
		Select s1 = new Select(productType);
		s1.selectByVisibleText(doc);
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection selectReasonForLoan(String doc) {
		Select s1 = new Select(reasonForLoan);
		s1.selectByVisibleText(doc);
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection selectHCAdults(String doc) {
		Select s1 = new Select(HCAdults);
		s1.selectByVisibleText(doc);
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection selectHCChildren(String doc) {
		Select s1 = new Select(HCChildren);
		s1.selectByVisibleText(doc);
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection selectResidentialStatus(String doc) {
		Select s1 = new Select(ResidentialStatus);
		s1.selectByVisibleText(doc);
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection selectPropertyStatus(String doc) {
		Select s1 = new Select(PropertyStatus);
		s1.selectByVisibleText(doc);
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection selectEmploymentStatus(String doc) {
		Select s1 = new Select(EmploymentStatus);
		s1.selectByVisibleText(doc);
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection clickProductSelection_Next() {
		ProductSelection_Next.click();
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection clickSECCIClose() {
		SECCI_Close.click();
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection clickSECCIClosePreContract() {
		SECCI_closePreContractButton.click();
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale enterSECCICustomerSign() {
		Actions builder = new Actions(getAndroidDriver());
		builder.clickAndHold(SECCISign).moveByOffset(10, 50).moveByOffset(50, 10).moveByOffset(-10, -50)
				.moveByOffset(-50, -10).release().perform();
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection clickSECCINext() {
		SECCI_Next.click();
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection clickTCNext() {
		TC_Next.click();
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection clickMCNext() {
		MC_Next.click();
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection enterMRCustomerSign() {
		Actions builder = new Actions(getAndroidDriver());
		builder.clickAndHold(MRSign).moveByOffset(10, 50).moveByOffset(50, 10).moveByOffset(-10, -50)
				.moveByOffset(-50, -10).release().perform();
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection clickMRNext() {
		MR_Next.click();
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public String verifytypeOfCredit() {
		System.out.println(typeOfCredit.getText());
		return typeOfCredit.getText();
	}

	public String verifytotalAmmountCredit() {
		System.out.println(totalAmmountCredit.getText());
		return totalAmmountCredit.getText();
	}

	public String verifyDurationCredit() {
		System.out.println(durationOfCredit.getText());
		return durationOfCredit.getText();
	}

	public String verifynoOfPayable() {
		System.out.println(noOfPayable.getText());
		return noOfPayable.getText();
	}

	public MAPLoanSale_ProductSelection clickLoanAgreementNext() {
		LoanAgreement_Next.click();
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection clickAcceptTermsCondition() {
		AcceptTermsCondition.click();
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale enterCustomerSign() {
		Actions builder = new Actions(getAndroidDriver());
		builder.clickAndHold(CustomerLoansign).moveByOffset(10, 50).moveByOffset(50, 10).moveByOffset(-10, -50)
				.moveByOffset(-50, -10).release().perform();
		return new MAPLoanSale(getAndroidDriver());
	}

	public MAPLoanSale_ProductSelection clickLoanAgreementNext1() {
		LoanAgreement_Next1.click();
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public MAPLoanSale enterAgentSign() {
		Actions builder = new Actions(getAndroidDriver());
		builder.clickAndHold(Agentsign).moveByOffset(10, 50).moveByOffset(50, 10).moveByOffset(-10, -50)
				.moveByOffset(-50, -10).release().perform();
		return new MAPLoanSale(getAndroidDriver());
	}
	
	public MAPLoanSale_ProductSelection clickLoanAgreement_AgentNext() {
		LoanAgreement_AgentNext.click();
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}

	public String verifyLoanTransactionMessage() {
		System.out.println(LoanTransactionMessage.getText());
		return LoanTransactionMessage.getText();
	}
	
	public MAPLoanSale_ProductSelection clickOKTransaction() {
		OKTransaction.click();
		return new MAPLoanSale_ProductSelection(getAndroidDriver());
	}
}
