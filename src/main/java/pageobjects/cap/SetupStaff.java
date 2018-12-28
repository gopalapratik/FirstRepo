
package pageobjects.cap;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.graphbuilder.math.func.LgFunction;

import helpers.CommonFunctions;
import utilities.ExcelUtilities;


public class SetupStaff {
	
	WebDriver driver;
    WebDriverWait wait;
    String parentHandle =null;
    public static String SurName="Test"+CommonFunctions.InsertTime();
    public SetupStaff(WebDriver driver)
    {
    	this.driver = driver;
    	this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    	new WebDriverWait(this.driver, 15);
    	PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }
    @FindBy(linkText="Staff")
    public WebElement Staff;
    
    @FindBy(linkText="Setup Staff")
    public WebElement SetupStaff;
    
    @FindBy(id="staffBean.salutation")
    public WebElement Salu;
    
    @FindBy(id="staffBean.firstName")
    public WebElement FN;
    
    @FindBy(id="staffBean.lastName")
    public WebElement SN;
    
    @FindBy(id="staffBean.addressBean.address1")
    public WebElement HN;
    
    @FindBy(id="staffBean.addressBean.address2")
    public WebElement Strt;
    
    @FindBy(id="staffBean.addressBean.locality")
    public WebElement Loclty;
    
    @FindBy(id="staffBean.addressBean.town")
    public WebElement tn;
    
    @FindBy(id="staffBean.addressBean.county")
    public WebElement cntry;
    
    @FindBy(id="staffBean.addressBean.postCode")
    public WebElement PC;
    
    @FindBy(id="staffBean.homePhone")
    public WebElement HP;
    
    @FindBy(id="staffBean.mobilePhone")
    public WebElement MP;
    
    @FindBy(id="startDate")
    public WebElement SD;
    
    @FindBy(id="staffBean.currentUgBean.userGroupId")
    public WebElement Usergrp;
    
    @FindBy(name="staffBean.staffType")
    public WebElement SType;
    
    @FindBy(id="staffBean.userName")
    public WebElement UN;
    
    @FindBy(id="staffBean.jobTitleBean.jobTitleId")
    public WebElement JobId;
    
    @FindBy(id="staffBean.pmtMethod")
    public WebElement pmt;
    
    @FindBy(id="staffBean.atmNo")
    public WebElement AtmN;
    
    @FindBy(id="atmLimit")
    public WebElement Alimit;
    
    @FindBy(id="floatLimit")
    public WebElement FL;
    
    @FindBy(linkText="Save Staff")
    public WebElement Save;
    
    @FindBy(linkText="Add Scheme")
    public WebElement AddSchme;
    
    @FindBy(name="selectedItemIds('1')")
    public WebElement Item;
    
    @FindBy(id="error")
    public WebElement Msg;
    
 
    
    public SetupStaff StaffLink()
    {
    	Staff.click();
    	return new SetupStaff(driver);
    }
    
    public SetupStaff SetupStaffLink()
    {
    	SetupStaff.click();
    	return new SetupStaff(driver);
    }
    //
    public SetupStaff setSalutation(String str)
    {
//    	Select s = new Select(Salu);
//    	s.selectByVisibleText(str);		
    	Salu.sendKeys(str);
    	return new SetupStaff(driver);
    }
    
    public SetupStaff setFN(String str)
    {
    	FN.sendKeys(str);
    	return new SetupStaff(driver);
    }
    public SetupStaff setSN()
    {
    	SN.sendKeys(SurName);
    	return new SetupStaff(driver);
    }
    public SetupStaff setHN(String str)
    {
    	HN.sendKeys(str);
    	return new SetupStaff(driver);
    }
    public SetupStaff setStrt(String str)
    {
    	
    	Strt.sendKeys(str);
    	return new SetupStaff(driver);
    }
    public SetupStaff setLoclty(String str)
    {
    	Loclty.sendKeys(str);
    	return new SetupStaff(driver);
    }
    
    public SetupStaff settn(String str)
    {
    	tn.sendKeys(str);
    	return new SetupStaff(driver);
    }
    public SetupStaff setcntry(String str)
    {
    	cntry.sendKeys(str);
    	return new SetupStaff(driver);
    }
    public SetupStaff setPC(String str)
    {
    	PC.sendKeys(str);
    	return new SetupStaff(driver);
    }
    public SetupStaff setHP(String str)
    {
    	HP.sendKeys(str);
    	return new SetupStaff(driver);
    }
    public SetupStaff setMP(String str)
    {
    	MP.sendKeys(str);
    	return new SetupStaff(driver);
    }
    public SetupStaff setSD()
    {
    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String dateformat = dateFormat.format(date);
    	SD.sendKeys(dateformat);
    	return new SetupStaff(driver);
    }
    public void FinishDate() throws ParseException
    {
    	Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate= formatter.format(date); 
	    final java.util.Calendar cal = GregorianCalendar.getInstance();
	  Date date1=formatter.parse(strDate);
	    cal.setTime( date1 );
	    cal.add( GregorianCalendar.MONTH, 1 );
	    String RevDate= formatter.format( cal.getTime());
	    System.out.println("Finish Date: "+RevDate);
	    driver.findElement(By.name("endDate")).sendKeys(RevDate);
		
    }
    
    public SetupStaff setUsergrp(String str)
    {
    	Usergrp.sendKeys(str);
    	return new SetupStaff(driver);
    }
    public SetupStaff setSType(String str)
    {
    	SType.sendKeys(str);
    	return new SetupStaff(driver);
    }
    public SetupStaff setUN(String str)
    {
    	
    	UN.sendKeys(str+"."+SurName);
    	return new SetupStaff(driver);
    }
    public SetupStaff setJobId(String str)
    {
    	JobId.sendKeys(str);
    	return new SetupStaff(driver);
    }
    public SetupStaff setpmt(String str)
    {
    	pmt.sendKeys(str);
    	return new SetupStaff(driver);
    }
    public SetupStaff setAtmN(String str)
    {
    	AtmN.sendKeys(str);
    	return new SetupStaff(driver);
    }
    public SetupStaff setAlimit(String str)
    {
    	Alimit.sendKeys(str);
    	return new SetupStaff(driver);
    }
    public SetupStaff setFL(String str)
    {
    	FL.sendKeys(str);
    	return new SetupStaff(driver);
    }
    public SetupStaff Savebutton()
    {
    	Save.click();
    	return new SetupStaff(driver);
    }
    public SetupStaff AddSchmebutton()
    {
    	AddSchme.click();
    	return new SetupStaff(driver);
    }
    public SetupStaff Addwindow() throws InterruptedException, ParseException
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
		     System.out.println(driver.getTitle());
		    driver.findElement(By.name("commissionSchemeId")).click();
		    Date date = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		    String strDate= formatter.format(date); 
		    final java.util.Calendar cal = GregorianCalendar.getInstance();
		  Date date1=formatter.parse(strDate);
		    cal.setTime( date1 );
		    cal.add( GregorianCalendar.MONTH, 2 );
		    String futuredate= formatter.format( cal.getTime());
		    System.out.println("Future Date; "+futuredate);

			SD.sendKeys(futuredate);
			Thread.sleep(5000);
		    driver.findElement(By.linkText("Apply")).click();
//		     //driver.quit();
//		     driver.close(); //closing child window
		     driver.switchTo().window(parentWindow); //Switch  to parent window
		    }
		   
		}
		return new SetupStaff(driver);
	}
    public SetupStaff AddItem()
    {
    	Item.click();
    	return new SetupStaff(driver);
    }
    public String Result()
    {
    	return Msg.getText();
    	//return new SetupStaff(driver);
    }
    
    
    
    
}
    