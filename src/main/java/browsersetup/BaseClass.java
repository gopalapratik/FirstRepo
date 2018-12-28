package browsersetup;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.base.Function;

import helpers.CommonFunctions;
import helpers.TestDataHelpers;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageobjects.cap.SetupBulkCustomerTransfer;
import testdata.TestConstants;

public class BaseClass {
	// change by Rajesh 
	private static WebDriver driver;
	public WebDriverWait wait;
	private List<String> assertMessage;
	private String Feature;
	private String clientName;
	private AppiumDriverLocalService appiumDriverLocalService;
	private AndroidDriver androidDriver;
	private String DBRoleChange;
	public static String DBRoleValue = null;
	
	// New Code -----------------------------Rajesh
	 public static ExtentHtmlReporter htmlReporter;
	    public static ExtentReports extent;
	    public static ExtentTest test;
	

	public String getDBRoleChange() {
		return DBRoleChange;
	}

	public void setDBRoleChange(String dBRoleChange) {
		DBRoleChange = dBRoleChange;
	}

	public AppiumDriverLocalService getAppiumDriverLocalService() {
		return appiumDriverLocalService;
	}

	public void setAppiumDriverLocalService(AppiumDriverLocalService appiumDriverLocalService) {
		this.appiumDriverLocalService = appiumDriverLocalService;
	}

	/*
	 * @BeforeMethod(groups = {"Regression","CAP","Credit Control Policy"})
	 * 
	 * @Parameters({"browser","environment","clientName"}) public void
	 * database(String browser,String environment,String clientName) {
	 * 
	 * this.setClientName(clientName); if(clientName.equals("CAP")) {
	 * System.out.println("innnnnn before test");
	 * System.out.println("DBRoleValue"+DBRoleValue);
	 * CommonFunctions.roll("DateRollBack"); if(DBRoleValue==null) {
	 * //System.out.println("innnnnnn null"); CommonFunctions.roll("BM"); } else {
	 * //System.out.println("DBRoleValue in base"+DBRoleValue);
	 * CommonFunctions.roll(DBRoleValue); }
	 * 
	 * //CommonFunctions.
	 * databaseConnection("UPDATE MORSE.STAFF_USER_GROUP SET USER_GROUP_ID = 15 WHERE STAFF_ID =1"
	 * ); } }
	 */

	@BeforeMethod(timeOut = 600000, alwaysRun = true)
	@Parameters({ "browser", "environment", "clientName" })
	public void setup(String browser, String environment, String clientName)
			throws InterruptedException, MalformedURLException {
		this.setClientName(clientName);
		if (clientName.equals("CAP")) {

			Setup setup = new Setup();
			driver = setup.setupBrowser(browser, environment, clientName);
		} else if (clientName.equals("MAP")) {
			Setup setup = new Setup();
			androidDriver = setup.setupAndroidDevice(browser, environment, clientName);
		} else if (clientName.equals("E2E")) {
			Setup setup = new Setup();
			androidDriver = setup.setupAndroidDevice(browser, environment, clientName);
		}

	}

	public void setAssertMessage(String message, int verificationNumber) {
		try {
			assertMessage.add(message);
		} catch (Exception e) {
			assertMessage = new ArrayList<String>();
			assertMessage.add(message);
		}
	}

	public List<String> getAssertMessage() {
		return assertMessage;
	}

	@AfterMethod(timeOut = 600000, alwaysRun = true)
	@Parameters({ "browser", "clientName" })
	public void quit(String browser, String clientName) throws InterruptedException {
		try {// assertMessage.removeAll(assertMessage);
			if ((!assertMessage.isEmpty()) && (!(assertMessage == null))) {
				assertMessage.clear();
			}
		} catch (Exception e) {
			assertMessage = new ArrayList<String>();
			assertMessage.addAll(assertMessage);
		}
		tearDown(browser, clientName);
	}

	@AfterTest(alwaysRun = true, groups = { "Sanity", "CAP", "Credit Control Policy" })
	@Parameters({ "browser", "clientName" })
	public void RollbackDatabase(String browser, String clientName) throws InterruptedException {
		this.setClientName(clientName);
		if (clientName.equals("CAP")) {
			System.out.println("innnnnn After test test");
			CommonFunctions.roll("Administrator Business");

			// CommonFunctions.databaseConnection("UPDATE MORSE.STAFF_USER_GROUP SET
			// USER_GROUP_ID = 15 WHERE STAFF_ID =1");
		}
	}

	/*
	 * @Parameters({ "clientName" }) public String setupClientDB(String clientName)
	 * throws InterruptedException { String dbName = null;
	 * switch(clientName.toUpperCase()) { case "SEI" : dbName = "coredb"; break;
	 * case "BREWIN" : dbName = "brewindb"; break; case "PBGB" : dbName = "pbgbdb";
	 * break; case "WHIRELAND" : dbName = "whidb"; break; default :
	 * Assert.fail("Database for " + clientName + "dosen't exsists"); } return
	 * dbName; }
	 */

	private void tearDown(String browser, String clientName) {
		try {
			if (clientName.equals("CAP")) {
				driver.close();
				driver.quit();
				if (WindowsUtils.thisIsWindows() && browser.equalsIgnoreCase("Firefox"))
					WindowsUtils.killByName("firefox.exe");
				else if (WindowsUtils.thisIsWindows() && browser.equalsIgnoreCase("chrome"))
					WindowsUtils.killByName("chrome.exe");
				else if (WindowsUtils.thisIsWindows() && browser.equalsIgnoreCase("InternetExplorer"))
					WindowsUtils.killByName("iexplore.exe");

			}

			if (clientName.equals("MAP")) {
				androidDriver.closeApp();

				// androidDriver.resetApp();
				// appiumDriverLocalService.stop();
				// getAppiumDriverLocalService().stop();
				WindowsUtils.killByName("adb.exe");

			}
			if (clientName.equals("E2E")) {
				androidDriver.closeApp();
				WindowsUtils.killByName("adb.exe");
				WindowsUtils.killByName("IEDriverServer.exe");
				WindowsUtils.killByName("iexplore.exe");

			}
		} catch (Exception n) {
			n.printStackTrace();
			/*
			 * if(WindowsUtils.thisIsWindows() && browser.equalsIgnoreCase("Firefox"))
			 * WindowsUtils.tryToKillByName("firefox.exe"); else
			 * if(WindowsUtils.thisIsWindows() && browser.equalsIgnoreCase("chrome"))
			 * WindowsUtils.tryToKillByName("chrome.exe"); else
			 * if(WindowsUtils.thisIsWindows() &&
			 * browser.equalsIgnoreCase("InternetExplorer"))
			 * WindowsUtils.tryToKillByName("iexplore.exe");
			 */
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	//////////////////////////////////

	public void fluentWaitMethod() {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//iFrame"));
			}
		});
	}

	///////////////////////////////////

	/////////////

	public void Scrolldown() {
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,1000)");
		//System.out.println("Scrolled Down");
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        //Find element by link text and store in variable "Element"        		
        WebElement Element = driver.findElement(By.xpath("//input[@name='submit']"));
        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
        System.out.println("Scrolled Down");
	}

	///////////////////
	
	
	public void ClosingBrowser() {
		driver.close();
	    System.out.println("Browser closed");
		}
	////////////////////////////

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	  public void getCreditCadAmt()
	    {
	    	WebElement CreditAccount = driver.findElement(By.xpath("//div[@id='tbl-container']/table/tbody/tr/td[5]"));
	    	CreditAccount.getText();
	    }

	public AndroidDriver getAndroidDriver() {
		return androidDriver;
	}

	public void setAndroidDriver(AndroidDriver androidDriver) {
		this.androidDriver = androidDriver;
	}

	/*
	 * selectDropDownValues(WebElement dropdownElement, String strSelectBy, String
	 * strDrpdownValue) : This method is used to handle Dropdown elements on Web
	 * page
	 */
	public void selectDropDownValues(WebElement dropdownElement, String strSelectBy, String strDropdownValue)
			throws InterruptedException {

		Select oSelect = new Select(dropdownElement);

		if (strSelectBy.equals("ByValue")) {

			oSelect.selectByValue(strDropdownValue);

		} else if (strSelectBy.equals("ByVisibleText")) {

			oSelect.selectByVisibleText(strDropdownValue);

		} else if (strSelectBy.equals("ByIndex")) {

			int intIndexNum = Integer.valueOf(strDropdownValue);
			oSelect.selectByIndex(intIndexNum);
		}
		Thread.sleep(2000);
	}

	/*
	 * explicitWaitForElement(WebElement element) : This method used to explicitly
	 * wait for expected element to be visible on web page
	 */
	public void explicitWaitForElement(WebElement element) {

		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/*
	 * switchBetweenWindows(String strParentWindow) : This method is used to switch
	 * between windows
	 */
	public void switchBetweenWindows(String strParentWindow) throws InterruptedException {

		Set<String> setOfWindows = driver.getWindowHandles();

		System.out.println("No of windows : " + setOfWindows.size());

		for (String strWindow : setOfWindows) {
			System.out.println(strWindow);
			if (!strWindow.equals(strParentWindow)) {
				System.out.println("Entering into Child Window");
				driver.switchTo().window(strWindow);
				break;
			}
		}

		Thread.sleep(2000);

	}

	/*
	 * switchToParentWindow(String strParentWindow) : This method is used to switch
	 * to Parent window
	 */
	public void switchToParentWindow(String strParentWindow) throws InterruptedException {

		driver.switchTo().window(strParentWindow);
		Thread.sleep(2000);
	}

	
	/////////////////////////////////////
	
	public void GetTitle() throws InterruptedException {

		driver.getTitle();
	//	 if (driver.getTitle().contains("Realax Payment Gateway") == false)
	//	        throw new NotFoundException("main page not displayed");
		Thread.sleep(2000);
	}

	
	
	
	
	///////////////////////////////////////
	
	
	
	
	
	
	
	
	/*
	 * refershApp() : This method is used to refresh application
	 */
	public void refershApp() {
		driver.navigate().refresh();
	}

	/*
	 * acceptAlert() : This method is used to accept alert
	 */
	public void acceptAlert() throws InterruptedException {
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
	}

	/*
	 * dismissAlert() : This method is used to dismiss alert
	 */
	public void dismissAlert() throws InterruptedException {
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.dismiss();
	}

	/*
	 * getAlertTextMsg() : This method is used to get Alert text message
	 */
	public void getAlertTextMsg() throws InterruptedException {
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.getText();
	}

	/*
	 * setInputForAlert(String strInput) : This method is used to set input for
	 * Alert
	 */
	public void setInputForAlert(String strInput) throws InterruptedException {
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.sendKeys(strInput);
	}

	/*
	 * selectRandomNumberFromList(List<String> strInputList) : This method is used
	 * to select random number from TestData list
	 */
	public String selectRandomNumberFromList(List<String> strInputList) {

		Random selectRandomNumber = new Random();

		String strNumber = strInputList.get(selectRandomNumber.nextInt(strInputList.size()));

		System.out.println("Random Input string : " + strNumber);
		return strNumber;

	}

	/*
	 * selectAndRetrieveSourceTerritoryOnSearchTerritoryScreen(
	 * SetupBulkCustomerTransfer setupBCT,String strRandomNumber) : This method is
	 * used to select & retrieve Source Territory on 'Search Territory Screen'
	 */
	public String selectAndRetrieveSourceTerritoryOnSearchTerritoryScreen(SetupBulkCustomerTransfer setupBCT,
			String strRandomNumber) throws InterruptedException {

		while (setupBCT.getErrorMessage().contains("No relevant matches have been found.")) {

			setupBCT.clickOnNewSearchButton();

			String strRandomTerritory = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);

			while (strRandomNumber.equals(strRandomTerritory)) {

				strRandomTerritory = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
			}

			setupBCT.enterTerritory(strRandomTerritory);

			setupBCT.clickOnSearchButton();
		}

		String strTerritoryName = setupBCT.getTerritoryName();

		setupBCT.clickOnTerritoryRadioButton(strTerritoryName);

		setupBCT.clickOnAcceptButton();

		return strTerritoryName;
	}

	/*
	 * selectAndRetriveDestinationTerritoryOnSearchTerritoryScreen((
	 * SetupBulkCustomerTransfer setupBCT,String strDestinationRandomNumber, String
	 * strSourceTerritory) : This method is used to select & retrieve Destination
	 * Territory on 'Search Territory Screen'
	 */
	public String selectAndRetrieveDestinationTerritoryOnSearchTerritoryScreen(SetupBulkCustomerTransfer setupBCT,
			String strDestinationRandomNumber, String strSourceTerritory) throws InterruptedException {

		while (setupBCT.getErrorMessage().contains("No relevant matches have been found.")) {

			setupBCT.clickOnNewSearchButton();

			String strRandomTerritory = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);

			while (strDestinationRandomNumber.equals(strRandomTerritory)
					|| strSourceTerritory.equals(strRandomTerritory)) {

				strRandomTerritory = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
			}

			setupBCT.enterTerritory(strRandomTerritory);

			setupBCT.clickOnSearchButton();
		}

		String strTerritoryName = setupBCT.getTerritoryName();

		setupBCT.clickOnTerritoryRadioButton(strTerritoryName);

		setupBCT.clickOnAcceptButton();

		return strTerritoryName;

	}

	/*
	 * selectEffectiveMondayDate(SetupBulkCustomerTransfer setupBCT) : This method
	 * is used to select effective Monday Date
	 */
	public void selectEffectiveMondayDate(SetupBulkCustomerTransfer setupBCT) throws InterruptedException {

		setupBCT.clickOnEffectiveDateCalendarButton();

		Thread.sleep(1000);

		setupBCT.clickOnNextMonthArrowButton();

		Thread.sleep(2000);

		setupBCT.clickOnMondayDate();

		Thread.sleep(2000);

	}

	/*
	 * selectCustomerOnSearchCustomerScreen(SetupBulkCustomerTransfer setupBCT) :
	 * This method is used to select Customers on Search Customers screen
	 */
	public ArrayList<String> selectCustomerOnSearchCustomerScreen(SetupBulkCustomerTransfer setupBCT,
			String strSelectedSourceTerritory) throws InterruptedException {

		String strParentWindow;
		while (setupBCT.getErrorMessage().equals(TestConstants.strNoMatchesRelevantMatchesMessage)) {

			setupBCT.clickOnCloseButton();

			setupBCT.sourceTerritoryTextBox.sendKeys(Keys.BACK_SPACE);
			setupBCT.sourceTerritoryTextBox.sendKeys(Keys.BACK_SPACE);
			setupBCT.sourceTerritoryTextBox.sendKeys(Keys.BACK_SPACE);
			setupBCT.sourceTerritoryTextBox.sendKeys(Keys.BACK_SPACE);

			// Select Source Territory
			String strSourceRandomNumber = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);

			while (strSelectedSourceTerritory.equals(strSourceRandomNumber)) {

				strSourceRandomNumber = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
			}

			setupBCT.enterSourceTerritory(strSourceRandomNumber);

			strParentWindow = getDriver().getWindowHandle();

			setupBCT.clickOnSourceTerritorySearchButton();

			switchBetweenWindows(strParentWindow);

			setupBCT.clickOnSearchButton();

			while (setupBCT.getErrorMessage().contains("No relevant matches have been found.")) {

				setupBCT.clickOnNewSearchButton();

				String strNewRandomTerritory = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);

				while (strNewRandomTerritory.equals(strSourceRandomNumber)
						|| strNewRandomTerritory.equals(strSelectedSourceTerritory)) {

					strNewRandomTerritory = selectRandomNumberFromList(TestDataHelpers.twoDigitNumberList);
				}

				setupBCT.enterTerritory(strNewRandomTerritory);

				setupBCT.clickOnSearchButton();
			}

			String strTerritoryName = setupBCT.getTerritoryName();

			setupBCT.clickOnTerritoryRadioButton(strTerritoryName);

			Thread.sleep(2000);

			setupBCT.clickOnAcceptButton();

			switchToParentWindow(strParentWindow);

			setupBCT.clickOnAddCustomerToListButton();

			setupBCT.clickOnSearchButton();
		}

		List<WebElement> listOFCustomerID = setupBCT.getListOfCustomerIDs();
		System.out.println("List size is : " + listOFCustomerID.size());

		int noOfCustomer;
		// Selecting 4 customer
		if (listOFCustomerID.size() < 4) {

			noOfCustomer = listOFCustomerID.size();
		} else {
			noOfCustomer = 4;
		}

		ArrayList<String> customerIDs = new ArrayList<String>();

		for (int i = 0; i < noOfCustomer; i++) {
			customerIDs.add(listOFCustomerID.get(i).getText());
		}

		for (String strCustomerID : customerIDs) {

			setupBCT.selectCustomerCheckBoxOfSpecifiedCustomerID(strCustomerID);
		}

		Thread.sleep(3000);

		return customerIDs;
	}

	/*
	 * selectTodaysDate() : This method is used to select Today's date on calendar :
	 */
	public String getTodaysDate() throws InterruptedException {

		Date date = new Date();
		SimpleDateFormat oDate = new SimpleDateFormat("dd/MM/yyyy");
		String strFromDate = oDate.format(date);
		System.out.println("Today's Date is : " + strFromDate);
		return strFromDate;
	}

	/*
	 * logoutFromApplication() : This is used to logout from application
	 */
	public void logoutFromApplication() {

		driver.findElement(By.linkText("Logout")).click();
	}

	/*
	 * loginToApplication() : This is used to Login to application
	 */
	public void loginToApplication() {

		driver.findElement(By.linkText("Login")).click();
	}

	/*
	 * selectFutureDateFromCalendar(WebElement element) : This method is used to
	 * select calendar and then select future date
	 */

	public void selectFutureDateFromCalendar(WebElement element) throws InterruptedException {

		element.click();

		Thread.sleep(1000);

		getDriver().findElement(By.xpath("//td[@ttip='Next month (hold for menu)']")).click();

		Thread.sleep(2000);

		getDriver()
				.findElement(By.xpath("//div[@class='calendar']/table/tbody/tr[contains(@class,'daysrow')][3]/td[3]"))
				.click();

		Thread.sleep(2000);

	}

	public void switchToFrame(String strFrameName) throws InterruptedException {

		driver.switchTo().frame(strFrameName);
		Thread.sleep(2000);
	}
	
	// New Code-----------------------------> Rajesh Beg
	@BeforeSuite
    public void setUp1()
    {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
         
        extent.setSystemInfo("OS", "Mac Sierra");
        extent.setSystemInfo("Host Name", "Krishna");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Krishna Sakinala");
         
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
        htmlReporter.config().setReportName("My Own Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }
     
    @AfterMethod
    public void getResult(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
     
    @AfterSuite
    public void tearDown()
    {
        extent.flush();
    }
}

	
	
	