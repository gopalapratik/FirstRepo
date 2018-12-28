package pageobjects.map;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import io.appium.java_client.android.AndroidDriver;

public class MAPClientList extends BaseClass {
	// WebDriver driver;
	// AndroidDriver androiddriver;

	public MAPClientList(AndroidDriver androiddriver) {
		setAndroidDriver(androiddriver);
		// this.driver = (AndroidDriver<WebElement>) driver;
		// this.androiddriver = driver;
		// PageFactory.initElements(this.driver, this);
		// PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20),
		// this);
		PageFactory.initElements(new AjaxElementLocatorFactory(getAndroidDriver(), 180), this);
	}

	@FindBy(xpath = "//ion-spinner[contains(@class, 'spinner-android')]")
	public WebElement spinner;

	// @FindBy(xpath = "//div[contains(@class,'col-15 territory-title')]")
	@FindBy(xpath = "//div[@class='col-15 territory-title']")
	// @FindBy(xpath = "//android.view.View[@content-desc='Territory:']")
	public WebElement territory;

	// @FindBy(xpath =
	// "//div[@id='clientListContent']/div/div/div/div[contains(text(),'Toni
	// Foister']")
	@FindBy(xpath = "//*[@id='clientListContent']/div[1]/div[1]/div[2]/div")
	public WebElement cust1;

	// @FindBy(xpath = "//button[@id='customer-list-hamburger-button']/i)"
	// @FindBy(xpath = "//*[@id='customer-list-hamburger-button']")
	// @FindBy(xpath = "//button[@id='customer-list-hamburger-button']")
	@FindBy(xpath = "//button[contains(@id,'hamburger-button')]")
	WebElement hamburger;

	@FindBy(xpath = "//p[@class='logout-paragraph']")
	WebElement logout;

	@FindBy(xpath = "//ion-item[@id='main.leadsList']")
	WebElement LeadList;

	@FindBy(xpath = "//ion-item[@id='main.customersList']")
	WebElement ClientList;

	@FindBy(xpath = "//div[@id='clientListContent']/div/div/div/div[contains(text(),'AutoTest1 AutoTest1')]")
	// @FindBy(xpath =
	// "//div[@id='clientListContent']/div/div/div/div[contains(text(),'Toni')]")
	WebElement AutoTestCuts;

	@FindBy(xpath = "//div[@id='clientListContent']/div/div/div/div[contains(text(),'AutoLead1 AutoLead1')]")
	WebElement AutoCustomer;

	@FindBy(xpath = "//ion-item[@id='main.cashReconciliation']")
	WebElement CashReconciliation;

	@FindBy(xpath = "//ion-item[@id='main.ATM']")
	WebElement ATMWithdrawal;
	
	@FindBy(xpath = "//ion-item[@id='main.recycleCash']")
	WebElement RecycleCash;
	
	@FindBy(xpath = "//ion-item[@id='main.allSales']")
	WebElement ViewAllSales;
	
	@FindBy(xpath = "//ion-item[@id='main.synchronization']")
	WebElement Synchronization;
	
	@FindBy(xpath = "//ion-item[@id='main.agentNotes']")
	WebElement AgentNotes;
	
	@FindBy(xpath = "//ion-item[@id='territory']")
	WebElement ChangeTerritory;

	@FindBy(xpath = "//span[@id='search-icon']")
	public WebElement searchButton;
	
	@FindBy(xpath = "//input[@id='search-box']")
	public WebElement searchBox;
	
	@FindBy(xpath = "//button[@ng-click='closeSearch()']")
	public WebElement SearchBackButton;
	
	@FindBy(xpath = "//select[@id='s1']")
	WebElement selectedTerritory;
	
	@FindBy(xpath = "//div[contains(@class,'scroll-bar-indicator scroll-bar-fade-out')]")
	public WebElement Slider;
	
	
	
	public String verifyterritory() {
		return territory.getText();
	}

	public MAPClientList clickCust1() {
		cust1.click();
		// return new MAPClientList(androiddriver);
		return new MAPClientList(getAndroidDriver());
	}

	public MAPClientList clickHamburger() {
		/*
		 * System.out.println(hamburger.getLocation());
		 * System.out.println(hamburger.getSize());
		 */
		hamburger.click();

		// hamburger.findElement(By.xpath("..")).click();
		// return new MAPClientList(androiddriver);
		return new MAPClientList(getAndroidDriver());
	}

	public MAPClientList clickLogout() {
		logout.click();
		// return new MAPClientList(androiddriver);
		return new MAPClientList(getAndroidDriver());
	}

	public MAPClientList clickAutoTestCuts() {
		AutoTestCuts.click();
		return new MAPClientList(getAndroidDriver());
	}

	public MAPClientList clickLeadList() {
		LeadList.click();
		return new MAPClientList(getAndroidDriver());
	}

	public MAPClientList clickClientList() {
		ClientList.click();
		return new MAPClientList(getAndroidDriver());
	}

	public MAPClientList clickAutoCustomer(String Customer) {
		getAndroidDriver()
				.findElement(
						By.xpath("//div[@id='clientListContent']/div/div/div/div[contains(text(),'"+Customer+"')]"))
				.click();
		// AutoTestCuts.click();
		return new MAPClientList(getAndroidDriver());
	}
	
	public MAPClientList clickCashReconciliation() {
		CashReconciliation.click();
		return new MAPClientList(getAndroidDriver());
	}
	
	public MAPClientList clickATMWithdrawal() {
		ATMWithdrawal.click();
		return new MAPClientList(getAndroidDriver());
	}
	
	public MAPClientList clickRecycleCash() {
		RecycleCash.click();
		return new MAPClientList(getAndroidDriver());
	}
	
	public MAPClientList clickViewAllSales() {
		ViewAllSales.click();
		return new MAPClientList(getAndroidDriver());
	}
	
	public MAPClientList clickSynchronization() {
		Synchronization.click();
		return new MAPClientList(getAndroidDriver());
	}
	
	public MAPClientList clickAgentNotes() {
		AgentNotes.click();
		return new MAPClientList(getAndroidDriver());
	}
	
	public MAPClientList clickChangeTerritory() {
		/*Action action = (Action) move.dragAndDropBy(AffSlider, 30, 0).build();
		((Actions) action).perform();*/
		Actions builder = new Actions(getAndroidDriver());   
		//builder.moveToElement(AffSlider).click().dragAndDropBy(AffSlider,AffSlider.getLocation().getY() +50, 0).build().perform();
		builder.moveToElement(Slider).click().dragAndDropBy(Slider,0,Slider.getLocation().getX()+50).build().perform();
		ChangeTerritory.click();
		return new MAPClientList(getAndroidDriver());
	}
	
	public MAPClientList SearchCustomer(String Customer) {
		searchButton.click();
		if (searchBox.isEnabled()) {
			searchBox.clear();
			searchBox.sendKeys(Customer + Keys.ENTER);
		}
		return new MAPClientList(getAndroidDriver());
	}
	public String verifyTerritoryNo() {
		Select s1 = new Select(selectedTerritory);
		String territory=s1.getFirstSelectedOption().getText();
		return territory;
	}
	
	public MAPClientList SearchClient(String clientName) {
		searchButton.click();
		if (searchBox.isEnabled()) {
			searchBox.clear();
			searchBox.sendKeys(clientName + Keys.ENTER);
		}
		return new MAPClientList(getAndroidDriver());
	}

	public String verifyClientInSearch(String Customer) {
		String client;
		//client = getAndroidDriver().findElement(By.xpath("//div[contains(text(),'"+Customer+"')]")).getText();
		client = getAndroidDriver().findElement(By.xpath("//div[contains(text(),'"+Customer+"')]//parent::div[@class='search-customers-name ng-binding']")).getText();
		System.out.println("Client name " + client);
		return client;
	}
	
	public MAPClientList clickSearchBackButton() {
		SearchBackButton.click();
		return new MAPClientList(getAndroidDriver());
	}
}
