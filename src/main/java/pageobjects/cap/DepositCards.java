
package pageobjects.cap;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.LineListener;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.html.applets.AppletClassLoader;

import helpers.CommonFunctions;
import utilities.ExcelUtilities;

public class DepositCards {
	WebDriverWait wait;
	WebDriver driver;
	public static String CardNO="MCL"+CommonFunctions.InsertTime();
	
	public static String Resultmsg=null;
	public static boolean available=true;
	public DepositCards(WebDriver driver)
	{
		this.driver=driver;
		this.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		 wait = new WebDriverWait(this.driver, 15);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	@FindBy(linkText="Business Administration")
	public WebElement BusAdministration;
	
	@FindBy(linkText="Deposit Cards")
	public WebElement DepositCards;
	
	@FindBy(linkText="Add")
	public WebElement Add;
	
	@FindBy(name="searchFirstName")
	public WebElement FirstNAme;
	
	@FindBy(name="searchLastName")
	public WebElement LAstName;
	
	@FindBy(linkText="Search")
	public WebElement Search;
	
	@FindBy(name="selectedStaffId")
	public WebElement Checkbox;
	
	@FindBy(id="cardNo")
	public WebElement cardNo;
	
	@FindBy(name="startDate")
	public WebElement startDate;
	
	@FindBy(linkText="Apply")
	public WebElement Apply;
	
	@FindBy(linkText="Start Date")
	public WebElement StDate;
	
	@FindBy(name="endDate")
	public WebElement EndDate;
	
	@FindBy(linkText="Delete")
	public WebElement Delete;
	
	@FindBy(linkText="End Date")
	public WebElement EndDatelink;
	
	@FindBy(id="error")
	public WebElement Result;
	
	@FindBy(linkText="Cancel")
	public WebElement CancelLink;

	@FindBy(id="staffBean.lastName")
    public WebElement SN;
	
	 @FindBy(id="staffBean.userName")
	    public WebElement UN;
	
	 public SetupStaff setUN(String str)
	    {
		 //UN.sendKeys(str+"."+SurName);
	    	UN.sendKeys(str);
	    	return new SetupStaff(driver);
	    }
	public SetupStaff setSN(String surname)
	{
	    	SN.sendKeys(surname);
	    	return new SetupStaff(driver);
	   }
	public DepositCards BusAdministrationLink()
	{
		BusAdministration.click();
		return new DepositCards(driver);
	}
	public DepositCards DepositCardsLink()
	{
		DepositCards.click();
		return new DepositCards(driver);
	}
	public DepositCards AddLink()
	{
		Add.click();
		return new DepositCards(driver);
	}
	public DepositCards SwitchWindow(String Firstname,String Surname,boolean b,String result,String cardno) throws InterruptedException
	{
		Thread.sleep(2000);
		String validate=null;
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
		    if(!windowHandle.equals(parentWindow))
		   {
		    	
		     driver.switchTo().window(windowHandle);
		     FirstNAme.sendKeys(Firstname);
		     LAstName.sendKeys(Surname);
		     Search.click();
		     Checkbox.click();
		     if(cardno.equalsIgnoreCase("yes"))
		     {
		    	
		    	cardNo.sendKeys("MCL"+CommonFunctions.InsertTime()); 
		     }
		     else
		     {
		    	 
		    	 //cardNo.sendKeys("MCL58825608");
		    	 cardNo.sendKeys(CardNO);
		    	 validate="Same Card No";
		     }
		    
		     startDate.sendKeys(CommonFunctions.NowDate());
		     if(b==true) 
		     {
		    	 EndDate.sendKeys(CommonFunctions.NowDate()); 
		     }
		     System.out.println("in child");
		     Thread.sleep(4000);
		     System.out.println(Apply.isDisplayed());
		     Actions builder = new Actions(driver);
		     builder.moveToElement(Apply).click(Apply).perform();
		     Apply.sendKeys(Keys.ENTER);
		  
		     System.out.println("in child");
		     Thread.sleep(9000);
		     if(result.equalsIgnoreCase("yes"))
		     {
		    	 
		    	 Resultmsg=Result.getText();
		    	 Actions builder1 = new Actions(driver);
		    	 builder1.moveToElement(CancelLink).click(CancelLink).perform();
		    	 CancelLink.sendKeys(Keys.ENTER);
		    	 

		     }
		     driver.switchTo().window(parentWindow); //cntrl to parent window
		     System.out.println("out child");
		     
		    }
		   
		}
		return new DepositCards(driver);
	}
	public String Result() throws InterruptedException
	{
		StDate.click();
		Thread.sleep(4000);
		StDate.click();
		Thread.sleep(4000);
		//String xpath = "//td[contains(text(),'Auto')]";
		String xpath = "//td/a[contains(text(),'"+CardNO+"')]";
		String s = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(s);
		
		return s;
	}
	public String Search(String delete) throws InterruptedException
	{
		StDate.click();
		Thread.sleep(4000);
		StDate.click();
		Thread.sleep(4000);
	
		System.out.println("Cardno........"+CardNO);
		//String xpath = "//td[contains(text(),'Auto')]";
		//String xpath = "//td/a[contains(text(),'MCL54916473')]";
		if(delete.equalsIgnoreCase("true"))
		{
			String xpath = "//td/a[contains(text(),'"+CardNO+"')]";
			String  s = driver.findElement(By.xpath(xpath)).getText();
			System.out.println("card no...."+s);
			String xpath1="//td/a[text()='"+s+"']//preceding::input[1]";
			WebElement wo =driver.findElement(By.xpath(xpath1));
			wo.click();
			System.out.println(s);
			
			Delete.click();
		}
		if(delete.equalsIgnoreCase("Pastdate"))
		{
			String xpath = "//td/a[contains(text(),'MCL70482427')]";
			String  s = driver.findElement(By.xpath(xpath)).getText();
			System.out.println("card no...."+s);
			String xpath1="//td/a[text()='"+s+"']//preceding::input[1]";
			WebElement wo =driver.findElement(By.xpath(xpath1));
			available =wo.isDisplayed();
			System.out.println(available);
			
			
		}
		
		return String.valueOf(available);
	}
	public DepositCards DeleteActiveCard(String Card,boolean b) throws InterruptedException
	{
		if(b==true)
		{
			System.out.println("in boolean");
			EndDatelink.click();
			Thread.sleep(4000);
		}
		Thread.sleep(15000);
		String xpath1="//td/a[text()='"+Card+"']//preceding::input[1]";
		WebElement wo =driver.findElement(By.xpath(xpath1));
		wo.click();
		Delete.click();
		
		return new DepositCards(driver);
	}
	
	
}