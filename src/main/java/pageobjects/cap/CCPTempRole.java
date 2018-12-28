package pageobjects.cap;

//import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.expression.spel.ast.BooleanLiteral;
import org.openqa.selenium.Alert;

import helpers.CommonFunctions;
import utilities.ExcelUtilities;

public class CCPTempRole {
	WebDriverWait wait;
	WebDriver driver;
	
	//public static String ScehemeName="AutoTest"+CommonFunctions.InsertTime();
	public static String StatusInExceptnScreen;
	public static String CustomerID;
	public CCPTempRole(WebDriver driver)
	{
		this.driver=driver;
		this.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		 wait = new WebDriverWait(this.driver, 30);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
	}
	@FindBy(linkText="Assign Staff Temporary Role")
	public WebElement TempRole;
	
	@FindBy(id="staffBean.staffId")
	public WebElement StaffID;
	
	@FindBy(linkText="Search")
	public WebElement Search;
	
	@FindBy(name="startDateStr")
	public WebElement StartDate;
	
	@FindBy(name="endDateStr")
	public WebElement EndDate;
	
	@FindBy(name="tempUserGroupId")
	public WebElement AssignRole;
	
	@FindBy(xpath="//*[starts-with(@id,'proposedAmountPlain')]")
	public List<WebElement> ProposedAMT;
	

	
	public CCPTempRole TempRoleLink()
	{
		TempRole.click();
		return new CCPTempRole(driver);
	}
	
	public CCPTempRole setStaffID(String id)
	{
		StaffID.sendKeys(id);
		return new CCPTempRole(driver);
	}
	public CCPTempRole SearchButton()
	{
		Search.click();
		return new CCPTempRole(driver);
	}
	public CCPTempRole StaffIDclick(String id)
	{
		
		driver.findElement(By.xpath("//td/a[contains(text(),'"+id+"')]")).click();
		return new CCPTempRole(driver);
	}
	public CCPSPLScreen Roleassigned(String role) throws InterruptedException
	{
		
		Thread.sleep(2000);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
		    if(!windowHandle.equals(parentWindow))
		   {	
		     driver.switchTo().window(windowHandle);
		     System.out.println("IN CHILLD1");
		     driver.getTitle();
		     System.out.println(driver.getTitle());
		     driver.findElement(By.id("btStartDate")).click();
		     driver.findElement(By.id("btStartDate")).sendKeys(Keys.ENTER);
		     driver.findElement(By.id("btEndDate")).click();
		     driver.findElement(By.id("btEndDate")).sendKeys(Keys.ARROW_RIGHT);
		     driver.findElement(By.id("btEndDate")).sendKeys(Keys.ENTER);
//		     EndDate.sendKeys(CommonFunctions.NowDate());
		     AssignRole.sendKeys(role);
		     driver.findElement(By.linkText("Save")).click();
//		     //driver.quit();
//		     driver.close(); //closing child window
		     driver.switchTo().window(parentWindow); //cntrl to parent window
		    }
		
		}
		return new CCPSPLScreen(driver);
	}
	
	public CCPTempRole checkbox(String id) throws InterruptedException
	{
		System.out.println("ProposedAMT.size()");
		//List<WebElement> ProposedAMT = driver.findElement(By.xpath("//*[starts-with(@id,'proposedAmountPlain')]"));
		System.out.println(ProposedAMT.size());
		for (WebElement element : ProposedAMT) {
			//System.out.println("in temp for");
			if (element.getText().equalsIgnoreCase("14.00")) {

				//System.out.println("Lanuage setlanguage" + setlanguage);
				String id1 = element.getAttribute("id");
				System.out.println("Lanuage setlanguage" + id1);
				String split=id1.substring(19,20);
				Thread.sleep(2000);
				driver.findElement(By.id("checkBoxId"+split)).click();
				
				System.out.println("Split   "+split);
				String val= String.valueOf(Integer.valueOf(split)+2);
						//substring(0,10)
				System.out.println("id of element "+val);
				CustomerID=driver.findElement(By.xpath("/HTML/BODY/FORM/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR["+val+"]/TD[4]")).getText();
				System.out.println(CustomerID);
				
				break;
			}
		}
		return new CCPTempRole(driver);
	}

	
}
