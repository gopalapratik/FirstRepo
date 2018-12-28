
package pageobjects.cap;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import org.openqa.selenium.Alert;

import helpers.CommonFunctions;
import utilities.ExcelUtilities;

public class CreditControlSchemes {
	WebDriverWait wait;
	static WebDriver driver;

	//public static String ScehemeName="AutoTest"+CommonFunctions.InsertTime();
	public static String MAxrate;
	public CreditControlSchemes(WebDriver driver)
	{
		this.driver=driver;
		this.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(this.driver, 15);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	@FindBy(linkText="Finance")
	public WebElement Finance;

	@FindBy(linkText="Credit Control Schemes")
	public WebElement CCS;

	@FindBy(xpath="/HTML/BODY/FORM/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[1]")
	public WebElement Header;

	@FindBy(linkText="Delete")
	public WebElement Delete;

	@FindBy(xpath="//td[@class='selected']//b[contains(text(),'Setup Scheme')]")
	public WebElement Schemeclick;

	@FindBy(linkText="Amend")
	public WebElement Amend;

	@FindBy(xpath="/HTML/BODY/FORM/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[1]/TD[2]/B/FONT")
	public WebElement Msg;

	@FindBy(xpath="//*[@id='spanNext']//a[contains(text(),'Next')]")
	public WebElement Next;

	public CreditControlSchemes FinanceLink()
	{
		Finance.click();
		return new CreditControlSchemes(driver);
	}
	public CreditControlSchemes CCSchemesLink()
	{
		CCS.click();
		return new CreditControlSchemes(driver);
	}
	public String HeaderDeatils()
	{
		return Header.getText();

	}
	public String DeleteText()
	{
		return Delete.getText();

	}
	public CreditControlSchemes SchemeClick(String data)
	{
		String xpath ="'"+data+"'";
		driver.findElement(By.xpath("//a[contains(text(),"+xpath+")]")).click();
		return new CreditControlSchemes(driver);

	}
	public String SchemeclickText()
	{
		return Schemeclick.getText();

	}
	public CreditControlSchemes AmendLink()
	{
		Amend.click();
		return new CreditControlSchemes(driver);
	}
	public CreditControlSchemes ScehemeNameSelect(String data) throws InterruptedException
	{
		System.out.println(data);
		String xpath= "'"+data+"'";
		String xpath1="//td/a[text()="+xpath+"]//preceding::input[1]";
		String xpath3="//td/a[text()="+xpath+"]";
		//driver.findElement(By.xpath("//tr[td[contains(text(),'bhagya')]]/td/input[@name='schemeIds']")).click();

		//		WebElement wo =driver.findElement(By.xpath("//td/a[contains(text(),'AutoTest')]/preceding-sibling::td/input[@type='checkbox']"));
		//		WebElement wo =driver.findElement(By.xpath("//td/a[text()="+xpath+"]//preceding::input[1]"));
		// Experiment
		//		while(tabData.) {
		//			Next.click();


		//		}
		
		// Maximum page number of the table ----------------------------------------------------------------> Changed by Rajesh
	String pagenumber=	driver.findElement(By.xpath(".//input[@name='maxPageNum']")).getAttribute("Value");
	
	// now convert the String to Integer-----------------------------------------------------------------------> changed by Rajesh
	int MaximumPage=Integer.parseInt(pagenumber);
	System.out.println(MaximumPage);
	
		// Find The element in which page test is displayed --------------------------------------------->
		for (int i=0;i<=MaximumPage;i++) {
			List<WebElement>Names=driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]"));
			System.out.println(Names.size());

			for(int j=0;j<=Names.size()-1;j++) {
//				System.out.println(Names.get(j).getText());
				if(Names.get(j).getText().equals(data))
				{
					Thread.sleep(3000);
					WebElement wo =driver.findElement(By.xpath(xpath1));
					wo.click();
					
					return null;
				}
				
			}
			Next.click();
		}

		//		List<WebElement>Names=driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]"));
		//		System.out.println(Names.size());
		//		for(int i=0;i<Names.size()-1;i++) {
		//			if (Names.get(i).getText().equals(data)) {
		//				WebElement wo =driver.findElement(By.xpath(xpath1));
		//				wo.click();
		//			}
		//		}

		System.out.println("xpath1>>>>"+xpath1);
		//		WebElement wo =driver.findElement(By.xpath(xpath1));
		//		if(driver.findElement(By.xpath(xpath1)).isDisplayed()) {
		//		wo.click();
		//		}else {
		//			Next.click();
		//		}


		return new CreditControlSchemes(driver);
	}
	public CreditControlSchemes AmendINcr()
	{
		WebElement max = driver.findElement(By.name("newMaxSale"));
		String val =max.getAttribute("value");
		System.out.println("AutoTest?????///"+val);
		MAxrate =String.valueOf(Double.valueOf(val)+1);
		System.out.println("MAxrate"+MAxrate);

		for(int i =0;i<=val.length();i++)
		{
			max.sendKeys(Keys.BACK_SPACE);
		}
		max.sendKeys(MAxrate);




		return new CreditControlSchemes(driver);
	}
	public CreditControlSchemes DeleteLink() throws InterruptedException
	{
		Delete.click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return new CreditControlSchemes(driver);
	}
	public String message()
	{
		return Msg.getText();

	}
	public CreditControlSchemes Alert() throws InterruptedException
	{
		Thread.sleep(10000);
		Alert alert = driver.switchTo().alert();
		alert.getText();
		Thread.sleep(5000);
		alert.accept();

		return new CreditControlSchemes(driver);

	}

	public static void SwitchWindow() {
		for (String windowName : driver.getWindowHandles()) {
			driver.switchTo().window(windowName);

		}
	}

	public CreditControlSchemes DialogAlert() throws InterruptedException
	{
		String parent = driver.getWindowHandle();
		if (driver.getWindowHandles().size() == 2) {
			for (String window : driver.getWindowHandles()) {
				if (!window.equals(parent)) {
					driver.switchTo().window(window);
					System.out.println("Modal dialog found");
					Thread.sleep(10000);
				}}}
		return new CreditControlSchemes(driver);}




	public CreditControlSchemes ModalWindowHandle() throws InterruptedException
	{
		String parent = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement push_to_create = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Push To Create']")));
		push_to_create.click();
		waitForWindow(driver);
		switchToModalDialog(driver, parent);

		return new CreditControlSchemes(driver);
	}

	public static void waitForWindow(WebDriver driver)
			throws InterruptedException {
		//wait until number of window handles become 2 or until 6 seconds are completed.
		int timecount = 1;
		do {
			driver.getWindowHandles();
			Thread.sleep(200);
			timecount++;
			if (timecount > 30) {
				break;
			}
		} while (driver.getWindowHandles().size() != 2);

	}



	public static void switchToModalDialog(WebDriver driver, String parent) { 
		//Switch to Modal dialog
		if (driver.getWindowHandles().size() == 2) {
			for (String window : driver.getWindowHandles()) {
				if (!window.equals(parent)) {
					driver.switchTo().window(window);
					System.out.println("Modal dialog found");
					break;
				}

			}

		}}

	public static boolean tabData(String data) throws InterruptedException {
		boolean result = false;
		String xpath= "'"+data+"'";
		String xpath1="//td/a[text()="+xpath+"]//preceding::input[1]";
		List<WebElement>Names3=driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]"));
		System.out.println(Names3.size());
		for(int i=0;i<Names3.size()-1;i++) {
			if (Names3.get(i).getText().equals(data)) {
				WebElement wo =driver.findElement(By.xpath(xpath1));
				Thread.sleep(2000);
				wo.click();
				result= true;

			}
		}
		return result;
	}


}