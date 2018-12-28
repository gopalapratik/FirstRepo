package browsersetup;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import testdata.ConfigurationData;

public class Setup extends BaseClass {
	static String baseurlEnvironmentOne = ConfigurationData.baseurlEnvironmentOne;
	static String baseurlEnvironmentTwo = ConfigurationData.baseurlEnvironmentTwo;
	static String baseurlEnvironmentThree = ConfigurationData.baseurlEnvironmentThree;
	static String baseurlEnvironmentFour = ConfigurationData.baseurlEnvironmentFour;

	// Mobile Application : Configuration Data
	static String nodeJSPath = ConfigurationData.nodeJSPath;
	static String mobileDeviceName = ConfigurationData.mobileDeviceName;
	static String mobilePlatformVersion = ConfigurationData.mobilePlatformVersion;
	static String appPackageUAT1 = ConfigurationData.appPackageUAT1;
	static String appActivityUAT1 = ConfigurationData.appActivityUAT1;
	static String appPackageUAT2 = ConfigurationData.appPackageUAT2;
	static String appActivityUAT2 = ConfigurationData.appActivityUAT2;
	static String appPackageTEST1 = ConfigurationData.appPackageTEST1;
	static String appActivityTEST1 = ConfigurationData.appActivityTEST1;
	static String appPackageTEST3 = ConfigurationData.appPackageTEST3;
	static String appActivityTEST3 = ConfigurationData.appActivityTEST3;

	private WebDriver driver = null;
	private AndroidDriver androidDriver = null;
	// static String driverPath = System.getProperty("user.dir");
	static String driverPathIE = ConfigurationData.driverPathIE;
	static String driverPathChrome = ConfigurationData.driverPathChrome;
	static String driverPathFirefox = ConfigurationData.driverPathFirefox;

	public WebDriver setupBrowser(String browser, String environment, String clientName)
			throws InterruptedException, MalformedURLException {
		if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", driverPathFirefox);
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);

			File pathToFirefoxBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			FirefoxBinary firefoxbin = new FirefoxBinary(pathToFirefoxBinary);
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			firefoxProfile.setPreference("browser.startup.homepage", "about:blank");
			firefoxProfile.setPreference("startup.homepage_welcome_url", "about:blank");
			firefoxProfile.setPreference("startup.homepage_welcome_url.additional", "about:blank");
			firefoxProfile.setEnableNativeEvents(true);

			capabilities.setCapability(FirefoxDriver.BINARY, firefoxbin);
			capabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);

			// driver = new FirefoxDriver(firefoxbin, firefoxProfile,
			// capabilities);
			//// driver = new FirefoxDriver(firefoxbin, firefoxProfile);
			driver = new RemoteWebDriver(new URL("http://172.16.206.62:5566/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-notifications");
			HashMap<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			System.setProperty("webdriver.chrome.driver", driverPathChrome);
			// driver = new ChromeDriver(options);
			driver = new RemoteWebDriver(new URL("http://172.16.206.62:5566/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("Internet Explorer")) {
			System.setProperty("webdriver.ie.driver","D:\\Pratik\\Autom@tix\\Automation_Project\\exe\\IEDriverServer.exe" );
			//System.setProperty("webdriver.ie.driver", "C:\\Users\\bhagyas13829\\Desktop\\IEDriverServer.exe");
			DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			/*			
			dc.setCapability("nativeEvents", false);    
			dc.setCapability("unexpectedAlertBehaviour", "accept");
			dc.setCapability("ignoreProtectedModeSettings", true);
			dc.setCapability("disable-popup-blocking", true);
			dc.setCapability("enablePersistentHover", true);
			 */
			//If IE fail to work, please remove this line and remove enable protected mode for all the 4 zones from Internet options

			driver = new InternetExplorerDriver(dc);


			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		/*
		 * //System.setProperty("webdriver.ie.driver", driverPath
		 * +"\\exe\\IEDriverServer.exe");
		 * System.setProperty("webdriver.ie.driver", driverPath); driver = new
		 * Internet ExplorerDriver();
		 * //System.setProperty("webdriver.chrome.driver", driverPath); //driver
		 * = new ChromeDriver(); //driver = new FirefoxDriver();
		 */
		switch (environment.toUpperCase()) {
		case "TEST 1":
			driver.navigate().to(baseurlEnvironmentOne);
			break;
		case "TEST 2":
			driver.navigate().to(baseurlEnvironmentTwo);
			break;
		case "TEST 3":
			driver.navigate().to(baseurlEnvironmentThree);
			break;
		case "MOBILE APP UAT1":
			break;
		case "MOBILE APP UAT2":
			break;
		default:
			Assert.fail(environment + "dosen't exsists");
		}
		

		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AndroidDriver setupAndroidDevice(String browser, String environment, String clientName)
			throws InterruptedException {

		if (browser.equalsIgnoreCase("Android")) {




			/*
			 * AppiumDriverLocalService appiumDriverLocalService =
			 * AppiumDriverLocalService .buildService(new
			 * AppiumServiceBuilder().usingPort(4723) .usingDriverExecutable(new
			 * File("C:/Program Files/nodejs/node.exe")) .withLogFile(new
			 * File("target/test.log")));
			 */
			setAppiumDriverLocalService(AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(4723)
					.usingDriverExecutable(new File(nodeJSPath)).withLogFile(new File("target/test.log"))));
			getAppiumDriverLocalService().start();

			DesiredCapabilities capabilities = new DesiredCapabilities();

			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, mobileDeviceName);
			// capabilities.setCapability(MobileCapabilityType.PLATFORM,
			// "Windows");
			// capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
			// "Android");

			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
			capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);

			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, mobilePlatformVersion);
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.Morses");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.Morses.Morses");

			capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
			capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

			try 
			{

				androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				// driver.manage().timeouts().implicitlyWait(10,
				// TimeUnit.SECONDS);
				androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} 
			catch (Exception me) 
			{
				me.printStackTrace();
			}

			/*
			 * //System.setProperty("webdriver.ie.driver", driverPath
			 * +"\\exe\\IEDriverServer.exe");
			 * System.setProperty("webdriver.ie.driver", driverPath); driver = new
			 * Internet ExplorerDriver();
			 * //System.setProperty("webdriver.chrome.driver", driverPath); //driver
			 * = new ChromeDriver(); //driver = new FirefoxDriver();
			 */
			/*
			 * if(environment.contains("Environment 1"))
			 * driver.navigate().to("Environment 1 URL"); else
			 * if(environment.contains("Environment 2"))
			 * driver.navigate().to("Environment 2 URL"); else
			 * if(environment.contains("Environment 3"))
			 * driver.navigate().to("Environment 3 URL"); else
			 * if(environment.contains("Environment 4"))
			 * driver.navigate().to("Environment 4 URL"); else
			 * driver.navigate().to("Default URL");
			 */

			// androidDriver.manage().timeouts().pageLoadTimeout(300,
			// TimeUnit.SECONDS);
			// androidDriver.manage().window().maximize();
			
		}
		return androidDriver;
	}
}

