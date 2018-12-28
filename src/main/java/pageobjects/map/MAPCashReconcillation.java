package pageobjects.map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import browsersetup.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class MAPCashReconcillation extends BaseClass {

	public MAPCashReconcillation(AndroidDriver androiddriver) {
		setAndroidDriver(androiddriver);
		PageFactory.initElements(new AjaxElementLocatorFactory(getAndroidDriver(), 60), this);
	}

	@FindBy(xpath = "//a[@id='view-all-today-payments']")
	WebElement viewalltodaypayments;

	@FindBy(xpath = "//a[@id='reconciliation-history']")
	WebElement reconciliationhistory;

	@FindBy(xpath = "//a[@id='view-commission']")
	WebElement viewcommission;

	@FindBy(xpath = "//div[contains(text(),'Opening Float (Cash)')]//following-sibling::div")
	WebElement OpeningFloatAmount;
	
	@FindBy(xpath = "//div[contains(text(),'Total CASH Collected')]//following-sibling::div")
	WebElement TotalCASHCollectedAmount;
	
	@FindBy(xpath = "//div[contains(text(),'Total CHEQUE Collected')]//following-sibling::div")
	WebElement TotalCHEQUECollectedAmount;
	
	@FindBy(xpath = "//div[contains(text(),'Total DEBIT CARD Coll.')]//following-sibling::div")
	WebElement TotalDEBITCARDCollAmount;
	
	@FindBy(xpath = "//div[contains(text(),'Loan Sales (Cash)')]//following-sibling::div")
	WebElement LoanSalesCashAmmount;
	
	@FindBy(xpath = "//div[contains(text(),'Loan Sales (Card)')]//following-sibling::div")
	WebElement LoanSalesCardAmmount;

	@FindBy(xpath = "//div[contains(text(),'Loan Cancellations (CASH)')]//following-sibling::div")
	WebElement LoanCancellationsCASHAmmount;
	
	@FindBy(xpath = "//div[contains(text(),'Loan Cancellations (CARD)')]//following-sibling::div")
	WebElement LoanCancellationsCARDAmmount;
	
	@FindBy(xpath = "//div[contains(text(),'ATM Withdrawal')]//following-sibling::div")
	WebElement ATMWithdrawalAmmount;
	
	@FindBy(xpath = "//div[contains(text(),'Recycled Cash (In)')]//following-sibling::div")
	WebElement RecycledCashInAmmount;
	
	@FindBy(xpath = "//div[contains(text(),'Recycled Cash (Out)')]//following-sibling::div")
	WebElement RecycledCashOutAmmount;

	@FindBy(xpath = "//div[contains(text(),'Commission Taken')]//following-sibling::div")
	WebElement CommissionTakenAmmount;

	@FindBy(xpath = "//div[contains(text(),'Total Collections')]//following-sibling::div")
	WebElement TotalCollectionsAmmount;
	
	@FindBy(xpath = "//div[contains(text(),'Total Loan Sales')]//following-sibling::div")
	WebElement TotalLoanSalesAmmount;
	
	@FindBy(xpath = "//div[contains(text(),'Closing Float (Cash)')]//following-sibling::div")
	WebElement ClosingFloatCashAmmount;
	
	@FindBy(xpath = "//p[contains(text(),'Manual Cash Banking')]//ancestor::div[1]/following-sibling::div/p[1]")
	WebElement ManualCashBankingAmmount;
	
	@FindBy(xpath = "//p[contains(text(),'Manual Cash Banking')]//ancestor::div[1]/following-sibling::div/p[contains(@ng-bind,'managerName')]")
	WebElement managerName;
	
	@FindBy(xpath = "//p[contains(text(),'Manual Cash Banking')]//ancestor::div[1]/following-sibling::div/p[contains(@ng-bind,'card')]")
	WebElement cardNo;
	
	@FindBy(xpath = "//p[contains(text(),'Auto Cash Banking')]//ancestor::div[1]/following-sibling::div/p[contains(@class,'ng-binding')]")
	WebElement AutoCashBankingAmount;
	
	@FindBy(xpath = "//p[contains(text(),'Auto Cheque Banking')]//ancestor::div[1]/following-sibling::div/p[contains(@class,'ng-binding')]")
	WebElement AutoChequeBankingAmount;
	
	@FindBy(xpath = "//input[@value='MANUAL BANKING']")
	WebElement ManualBankingButton;
	
	@FindBy(xpath = "//input[@id='manualBankingAmount']")
	WebElement ManualBankingAmount;
	
	@FindBy(xpath = "//select[@id='cardRefSelect']")
	WebElement DepositeCardRef;
	
	@FindBy(xpath = "//button[contains(@ng-click,'approveMB')]")
	WebElement manualBankingOk;
	
	@FindBy(xpath = "//button[contains(@ng-click,'data.amount')]")
	WebElement manualBankingCancel;
	
	public MAPLead clickViewAlltodaypayments() {
		viewalltodaypayments.click();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead clickReconciliationhistorys() {
		reconciliationhistory.click();
		return new MAPLead(getAndroidDriver());
	}

	public MAPLead clickViewCommission() {
		viewcommission.click();
		return new MAPLead(getAndroidDriver());
	}

	public String verifyOpeningFloatAmount() {
		return OpeningFloatAmount.getText();
	}
	
	public String verifTotalCASHCollectedAmount() {
		return TotalCASHCollectedAmount.getText();
	}
	
	public String verifyTotalCHEQUECollectedAmount() {
		return TotalCHEQUECollectedAmount.getText();
	}
	
	public String TotalDEBITCARDCollAmount() {
		return TotalDEBITCARDCollAmount.getText();
	}
	
	public String LoanSalesCashAmmount() {
		return LoanSalesCashAmmount.getText();
	}
	
	public String LoanSalesCardAmmount() {
		return LoanSalesCardAmmount.getText();
	}
	
	public String LoanCancellationsCASHAmmount() {
		return LoanCancellationsCASHAmmount.getText();
	}
	
	public String LoanCancellationsCARDAmmount() {
		return LoanCancellationsCARDAmmount.getText();
	}
	
	public String ATMWithdrawalAmmount() {
		return ATMWithdrawalAmmount.getText();
	}
	
	public String RecycledCashInAmmount() {
		return RecycledCashInAmmount.getText();
	}
	
	public String RecycledCashOutAmmount() {
		return RecycledCashOutAmmount.getText();
	}
	
	public String CommissionTakenAmmount() {
		return CommissionTakenAmmount.getText();
	}
	
	public String TotalCollectionsAmmount() {
		return TotalCollectionsAmmount.getText();
	}
	
	public String TotalLoanSalesAmmount() {
		return TotalLoanSalesAmmount.getText();
	}
	
	public String ClosingFloatCashAmmount() {
		return ClosingFloatCashAmmount.getText();
	}
	
	public String ManualCashBankingAmmount() {
		return ManualCashBankingAmmount.getText();
	}
	
	public String managerName() {
		return managerName.getText();
	}
	
	public String cardNo() {
		return cardNo.getText();
	}
	
	public String AutoCashBankingAmount() {
		return AutoCashBankingAmount.getText();
	}
	
	public String AutoChequeBankingAmount() {
		return AutoChequeBankingAmount.getText();
	}
	
	public MAPLead clickManualBankingButton() {
		ManualBankingButton.click();
		return new MAPLead(getAndroidDriver());
	}
	
	public MAPLead EnterManualBankingAmount(String Amount) {
		ManualBankingAmount.sendKeys(Amount);
		return new MAPLead(getAndroidDriver());
	}
	
	public MAPLead SelectDepositeCardRef(String card) {
		Select S1= new Select(DepositeCardRef);
		S1.selectByVisibleText(card);
		return new MAPLead(getAndroidDriver());
	}
	
	public MAPLead ClickManualBankingOK() {
		manualBankingOk.click();
		return new MAPLead(getAndroidDriver());
	}
	
	public MAPLead ClickManualBankingCancel() {
		manualBankingCancel.click();
		return new MAPLead(getAndroidDriver());
	}
	
	public String VerifyPaymentInViewTodaysPayment(String Customer) {
		String element = null;
		element= getAndroidDriver().findElement(By.xpath("//td[contains(text(),'"+Customer+"')]//following-sibling::td[4]")).getText();
		return element;
	}
}
