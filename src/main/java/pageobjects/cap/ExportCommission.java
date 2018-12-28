package pageobjects.cap;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.CommonFunctions;
import utilities.ExcelUtilities;

public class ExportCommission {
	WebDriverWait wait;
	WebDriver driver;
	
	//public static String ScehemeName="AutoTest"+CommonFunctions.InsertTime();
	public static String MAxrate;
	public static String WindowName;
	public ExportCommission(WebDriver driver)
	{
		this.driver=driver;
		this.driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		 wait = new WebDriverWait(this.driver, 15);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	@FindBy(linkText="Export Commission")
	public WebElement Commission;
	
	@FindBy(xpath="//td[contains(text(),'2017 - 49')]//preceding-sibling::td/input[@type='radio']")
	public WebElement Radio;
	
	@FindBy(linkText="Create Payroll File")
	public WebElement PayrollCreate;
	
	
	
	public ExportCommission CommissionLink()
	{
		Commission.click();
		return new ExportCommission(driver);
	}
	public ExportCommission RadioLink() throws InterruptedException
	{
		WebElement element = driver.findElement(By.xpath("//td[contains(text(),'2017 - 52')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		Radio.click();
		return new ExportCommission(driver);
	}
	public ExportCommission PayrollCreateClick()
	{
		PayrollCreate.click();
		return new ExportCommission(driver);
	}
	public ExportCommission WindowSwitch() throws InterruptedException
	{
		//ConvertLead.click();
				Thread.sleep(2000);
				String parentWindow = driver.getWindowHandle();
				Set<String> handles =  driver.getWindowHandles();
				for(String windowHandle  : handles)
				{
				    if(!windowHandle.equals(parentWindow))
				   {
				    	
				     driver.switchTo().window(windowHandle);
				     System.out.println("IN CHILLD");
				     driver.getTitle();
				     WindowName = driver.getTitle();
				     System.out.println(driver.getTitle());
				     driver.findElement(By.linkText("Proceed")).click();
//				     //driver.quit();
//				     driver.close(); //closing child window
				     driver.switchTo().window(parentWindow); //cntrl to parent window
				    }
				    
	}
				return new ExportCommission(driver);
	}
}