package pageobjects.map;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import browsersetup.BaseClass;
import helpers.MAPFunctions;
import io.appium.java_client.android.AndroidDriver;

public class MAPCustomerDetails extends BaseClass {
	// WebDriver driver;
	// AndroidDriver androiddriver;
	String tableHeader = "//*[@id='cDetPage']/ion-nav-view/div/ion-content/ion-scroll/div[1]/table[1]/thead/tr/th[";
	String tableElement = "//*[@id='cDetPage']/ion-nav-view/div/ion-content/ion-scroll/div[1]/table[1]/tbody/tr[1]/td[";

	public MAPCustomerDetails(AndroidDriver androiddriver) {
		setAndroidDriver(androiddriver);
		PageFactory.initElements(new AjaxElementLocatorFactory(getAndroidDriver(), 120), this);
	}

	@FindBy(xpath = "//a[@id='open-loan-sale-customers-details']")
	public WebElement loanSale;
	
	@FindBy(xpath = "//span[@ng-bind='customer.customerCode']")
	public WebElement CustomerID;

	@FindBy(xpath = "//span[@ng-bind='customerPhone']")
	public WebElement customerPhone;
	
	@FindBy(xpath = "//span[contains(@ng-bind,'street')]")
	public WebElement street;
	
	@FindBy(xpath = "//a[contains(text(),'CANCEL LOAN')]")
	public WebElement CancelLoan;

	@FindBy(xpath = "//a[@id='confirm-cancellation-button']")
	public WebElement confirmcancellationbutton;

	@FindBy(xpath = "//*[@id='cDetPage']/ion-nav-view/ion-content/ion-scroll/div[1]/table/tbody/tr[1]/td[1]")
	public WebElement selectFirstRowLoan;

	@FindBy(xpath = "//button[@id='confirmButton']")
	public WebElement confirmcancellationLoan;

	@FindBy(xpath = "//button[@id='cancelButton']")
	public WebElement cancelcancellationLoan;

	@FindBy(xpath = "//a[@id='historyTab']")
	public WebElement HistoryTab;

	// @FindBy(xpath =
	// "//*[@id='cDetPage']/ion-nav-view/ion-content[2]/ion-content/ion-scroll/div[1]/table/tbody/tr[1]")
	@FindBy(xpath = "//*[@id='cDetPage']/ion-nav-view/ion-content/ion-content/ion-scroll/div[1]/table/tbody/tr[1]")
	public WebElement selectFirstRowHistoryTab;

	@FindBy(xpath = "//a[@id='paymentButton']")
	public WebElement paymentButton;

	@FindBy(xpath = "//select[@ng-model = 'currentType']")
	public WebElement paymentType;

	@FindBy(xpath = "//select[@ng-model = 'currentMethod']")
	public WebElement paymentMethod;

	@FindBy(xpath = "//input[@ng-model = 'payment.totalAmount']")
	public WebElement paymenttotalAmount;

	@FindBy(xpath = "//input[@ng-model = 'account.amount']")
	public WebElement paymentAccountAmount;

	@FindBy(xpath = "//a[@id='confirm-customer-payment']")
	public WebElement confirmCustomerPayment;
	
	@FindBy(xpath = "//a[@id='close-customer-payment2']")
	public WebElement closeCustomerPayment;

	@FindBy(xpath = "//button[@id='close-customer-details']")
	public WebElement closeCustomerDetails;
	
	@FindBy(xpath = "//div[@ng-bind-html='appAlertMessage']")
	public WebElement appAlertMessage;

	@FindBy(xpath = "//button[@id='app-alert-close-button-2']")
	public WebElement alertCloseButton;
	
	@FindBy(xpath = "//a[@id='accountTab']")
	public WebElement AccountTab;
	
	@FindBy(xpath = "//a[@id='notesTab']")
	public WebElement NotesTab;
	
	@FindBy(xpath = "//a[@id='eligibilityTab']")
	public WebElement EligibilityTab;
	
	@FindBy(xpath = "//a[@id='tpaymentsTab']")
	public WebElement tpaymentsTab;
	
	@FindBy(xpath = "//span[@id='show-new-note-modal-button']")
	public WebElement Note;
	
	@FindBy(xpath = "//textarea[@ng-model='newNote.description']")
	public WebElement newNoteDescription;
	
	@FindBy(xpath = "//button[@id='confirm-new-note-modal-button']")
	public WebElement confirmNote;
	
	@FindBy(xpath = "//div[contains(@ng-repeat,'note in notes')][1]//div[2]/span")
	public WebElement NoteTimeFormat;
	
	@FindBy(xpath = "//div[@class='VN-body']")
	public WebElement savedNote;
	
	@FindBy(xpath = "//button[@id='close-view-agent-history-note-button']")
	public WebElement closeNote;
	
	@FindBy(xpath = "//a[contains(@ng-click,'showModalCallback')]")
	public WebElement callBack;
	
	@FindBy(xpath = "//ion-modal-view[@class='generic-modal modal slide-in-up ng-enter active ng-enter-active']//select[@id='callbackSelect']")
	public WebElement callBackDate;
	
	@FindBy(xpath = "//ion-modal-view[@class='generic-modal modal slide-in-up ng-enter active ng-enter-active']//button[@id='confirm-callback']")
	public WebElement ConfirmcallBack;
	
	@FindBy(xpath = "//ion-modal-view[@class='generic-modal modal slide-in-up ng-enter active ng-enter-active']//button[@id='close-modal-callback2']")
	public WebElement CancelCallBack;
	
	@FindBy(xpath = "//ion-modal-view[@class='generic-modal modal slide-in-up ng-enter active ng-enter-active']//button[@id='delete-callback']")
	public WebElement DeleteCallBack;
	
	@FindBy(xpath = "//input[@id='cDate']")
	public WebElement customerDate;
	
	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id='android:id/day']/android.widget.EditText[@resource-id='android:id/numberpicker_input']")
	public WebElement day;

	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id='android:id/month']/android.widget.EditText[@resource-id='android:id/numberpicker_input']")
	public WebElement month;

	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id='android:id/year']/android.widget.EditText[@resource-id='android:id/numberpicker_input']")
	public WebElement year;

	@FindBy(xpath = "//android.widget.Button[@text='Set']")
	public WebElement set;
	
	@FindBy(xpath = "//a[@id='adjust-payment-button']")
	public WebElement adjustPaymentButton;
	
	@FindBy(xpath = "//input[@ng-model = 'payment.adjustedAmount']")
	public WebElement AdjustPaymentAmount;
	
	@FindBy(xpath = "//input[@id='adjust-payments-confirm-button']")
	public WebElement adjustPaymentsConfirmButton;
	
	public String CustomerID() {
		return CustomerID.getText();
	}
	
	public String customerPhone() {
		return customerPhone.getText();
	}
	
	public String street() {
		return street.getText();
	}
	
	public MAPCustomerDetails clickloanSale() {
		loanSale.click();
		// return new MAPCustomerDetails(getAndroidDriver());
		return new MAPCustomerDetails(getAndroidDriver());
	}

	public MAPCustomerDetails clickCanbcelLoan() {
		CancelLoan.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}

	public MAPCustomerDetails clickconfirmcancellationbutton() {
		confirmcancellationbutton.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}

	public MAPCustomerDetails clickFristRowLoan() {
		selectFirstRowLoan.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public String verifyFristRowLoanAccountNo() {
		return selectFirstRowLoan.getText();
	}

	public MAPCustomerDetails clickConfirmCancelLoan() {
		confirmcancellationLoan.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}

	public MAPCustomerDetails clickCancelCancelLoan() {
		cancelcancellationLoan.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}

	public MAPCustomerDetails clickHistoryTab() {
		HistoryTab.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}

	public String gettextselectFirstRowHistoryTab() {
		System.out.println("first row =" + selectFirstRowHistoryTab.getText());
		return selectFirstRowHistoryTab.getText();
	}

	public String verifyAcccountNo() {
		String accountNo = null;

		accountNo = getAndroidDriver()
				.findElement(By
						.xpath("//*[@id='cDetPage']/ion-nav-view/div/ion-content/ion-scroll/div[1]/table[1]/tbody/tr[1]/td[1]"))
				.getText();
		System.out.println("Account No Value " + accountNo);
		return accountNo;
	}
	
	public String verifyCurrentLoanBalance() {
		String currentLoanBalance = null;
		currentLoanBalance = getAndroidDriver().findElement(By.xpath("//*[@id='cDetPage']/ion-nav-view/div/ion-content/ion-scroll/div[1]/table[1]/tbody/tr[1]/td[7]"))
				.getText();
		System.out.println("Current Loan Balance Value " + currentLoanBalance);
		return currentLoanBalance;
	}
	
	public String verifyEarlySettlementBalance() {
		String EarlySettlementBalance = null;
		EarlySettlementBalance = getAndroidDriver().findElement(By.xpath("//*[@id='cDetPage']/ion-nav-view/div/ion-content/ion-scroll/div[1]/table[1]/tbody/tr[1]/td[9]"))
				.getText();
		System.out.println("Early Settlement Balance Loan Balance Value " + EarlySettlementBalance);
		return EarlySettlementBalance;
	}

	public String verifyPrincipalLoanValue() {
		String element = null;
		for (int i = 1; i <= 11; i++) {
			if ((getAndroidDriver().findElement(By.xpath(tableHeader + i + "]"))).getText()
					.equals("Principal Loan Value (£)")) {
				element = getAndroidDriver().findElement(By.xpath(tableElement + i + "]")).getText();
				System.out.println("Principal Loan Value " + element);
				break;
			}
		}
		return element;
	}

	public String verifyDateOfLastPayment() {
		String dateOfLastPayment = null;
		dateOfLastPayment = getAndroidDriver().findElement(By.xpath("//*[@id='cDetPage']/ion-nav-view/div/ion-content/ion-scroll/div[1]/table[1]/tbody/tr[1]/td[11]"))
				.getText();
		System.out.println("Date Of Last Payment " + dateOfLastPayment);
		return dateOfLastPayment;
	}
	
	public String verifyTermsWks() {
		String element = null;
		for (int i = 1; i <= 11; i++) {
			if ((getAndroidDriver().findElement(By.xpath(tableHeader + i + "]"))).getText().equals("Terms (Wks)")) {
				element = getAndroidDriver().findElement(By.xpath(tableElement + i + "]")).getText();
				System.out.println("Terms (Wks) " + element);
				break;
			}
		}
		return element;
	}

	public String verifyWeeklyRate() {
		String element = null;
		for (int i = 1; i <= 11; i++) {
			if ((getAndroidDriver().findElement(By.xpath(tableHeader + i + "]"))).getText().equals("Weekly Rate (£)")) {
				element = getAndroidDriver().findElement(By.xpath(tableElement + i + "]")).getText();
				System.out.println("Weekly Rate (£) " + element);
				break;
			}
		}
		return element;
	}

	public String verifyTotalAmmountPayable() {
		String element = null;
		for (int i = 1; i <= 11; i++) {
			if ((getAndroidDriver().findElement(By.xpath(tableHeader + i + "]"))).getText()
					.equals("Total Amount Payable (£)")) {
				element = getAndroidDriver().findElement(By.xpath(tableElement + i + "]")).getText();
				System.out.println("Total Amount Payable (£) " + element);
				break;
			}
		}
		return element;
	}

	public String verifyAccountPerformancePercentage() {
		String element = null;
		for (int i = 1; i <= 11; i++) {
			if ((getAndroidDriver().findElement(By.xpath(tableHeader + i + "]"))).getText()
					.equals("Account Performance Percentage (%)")) {
				element = getAndroidDriver().findElement(By.xpath(tableElement + i + "]")).getText();
				System.out.println("Account Performance Percentage (%) " + element);
				break;
			}
		}
		return element;
	}

	public String verifyCustomerAccountDetails(String field) {
		String element = null;
		for (int i = 1; i <= 11; i++) {
			if ((getAndroidDriver().findElement(By.xpath(tableHeader + i + "]"))).getText().equals(field)) {
				element = getAndroidDriver().findElement(By.xpath(tableElement + i + "]")).getText();
				System.out.println(field + element);
				break;
			}
		}
		return element;
	}
	

	public MAPCustomerDetails clickPaymentButton() {
		paymentButton.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}

	public MAPLead selectPaymentType(String doc) {
		Select s1 = new Select(paymentType);
		s1.selectByVisibleText(doc);
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead selectPaymentMethod(String doc) {
		Select s1 = new Select(paymentMethod);
		s1.selectByVisibleText(doc);
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead enterPaymentAmmount(String doc) {
		paymenttotalAmount.clear();
		paymenttotalAmount.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead enterPaymentAccountAmmount(String doc) {
		paymentAccountAmount.clear();
		paymentAccountAmount.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLead(getAndroidDriver());
	}

	public MAPCustomerDetails clickconfirmCustomerPayment() {
		confirmCustomerPayment.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public MAPCustomerDetails clickCloseCustomerPayment() {
		closeCustomerPayment.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}

	public MAPCustomerDetails clickcloseCustomerDetails() {
		closeCustomerDetails.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public String verifyAlertMsg() {
		return appAlertMessage.getText();
	}
	
	public MAPCustomerDetails clickAlertCloseButton() {
		alertCloseButton.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public MAPCustomerDetails clickAccountTab() {
		AccountTab.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public MAPCustomerDetails clickNotesTab() {
		NotesTab.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public MAPCustomerDetails clickEligibilityTab() {
		EligibilityTab.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public MAPCustomerDetails clickTpaymentsTab() {
		tpaymentsTab.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public MAPCustomerDetails clickNote() {
		Note.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public MAPCustomerDetails EnternewNoteDescription(String notes) {
		newNoteDescription.sendKeys(notes);
		getAndroidDriver().hideKeyboard();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public MAPCustomerDetails clickConfirmNote() {
		confirmNote.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public String verifyNoteTimeFormat() {
		return NoteTimeFormat.getText();
	}
	
	public MAPCustomerDetails clickFirstNote() {
		NoteTimeFormat.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public String verifySavedNotes() {
		return savedNote.getText();
	}
	
	public MAPCustomerDetails clickCloseNotes() {
		closeNote.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public MAPCustomerDetails clickCallback() {
		callBack.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public MAPCustomerDetails selectCallbackDate(String Value) {
		Select S1= new Select(callBackDate);
		S1.selectByValue(Value);
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public MAPCustomerDetails clickConfirmCallback() {
		ConfirmcallBack.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public MAPCustomerDetails clickCancelCallback() {
		CancelCallBack.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public MAPCustomerDetails clickDeleteCallback() {
		DeleteCallBack.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public MAPCustomerDetails clickCustomerDate(String Date) throws InterruptedException {
		customerDate.click();
		String[] split=Date.split("-");
		Thread.sleep(1000);
		MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
		MAPfunctions.switchContext("NATIVE");
		day.clear();
		day.sendKeys(split[2]);
		/*month.clear();
		month.sendKeys(split[1]);
		year.clear();
		year.sendKeys(split[0]);*/
		getAndroidDriver().hideKeyboard();
		set.click();
		MAPfunctions.switchContext("WEBVIEW");
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public String verifyCallbackStatus(String Customer) {
		String status;
		status = getAndroidDriver().findElement(By.xpath("//div[contains(text(),'"+Customer+"')]//ancestor::div[@class='sort-option-two pure-u-6-24']//following-sibling::div/p[contains(text(),'STATUS: CALLBACK')]")).getText();
		System.out.println("Cutomer status " + status);
		return status;
	}
	
	public String verifyCallbackStatus_ActionRequired(String Customer) {
		String status;
		status = getAndroidDriver().findElement(By.xpath("//div[contains(text(),'"+Customer+"')]//ancestor::div[@class='sort-option-two pure-u-6-24']//following-sibling::div/p[contains(text(),'STATUS: ACTION REQUIRED')]")).getText();
		System.out.println("Cutomer status " + status);
		return status;
	}
	
	public String verifyCallbackText() {
		System.out.println("verify Callback text"+callBack.getText());
		return callBack.getText();
	}
	
	public MAPCustomerDetails clickAdjustPaymentButton() {
		adjustPaymentButton.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
	
	public MAPLead enterAdjustPaymentAmount(String doc) {
		AdjustPaymentAmount.clear();
		AdjustPaymentAmount.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPLead(getAndroidDriver());
	}

	public MAPCustomerDetails clickAdjustPaymentsConfirmButton() {
		adjustPaymentsConfirmButton.click();
		return new MAPCustomerDetails(getAndroidDriver());
	}
}
