
package pageobjects.cap;

import java.util.ArrayList;
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

public class CCPSPLScreen {
	WebDriverWait wait;
	WebDriver driver;
	
	//public static String ScehemeName="AutoTest"+CommonFunctions.InsertTime();
	public static String StatusInExceptnScreen;
	public static String CustomerID;
	public CCPSPLScreen(WebDriver driver)
	{
		this.driver=driver;
		this.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		 wait = new WebDriverWait(this.driver, 30);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
	}
	@FindBy(linkText="Credit Control Policy")
	public WebElement CCP;
	
	@FindBy(id="salesPotentilListBean.status")
	public WebElement SALESStatus;
	
	@FindBy(linkText="Search")
	public WebElement Search;
	
	@FindBy(id="ButtonAmend1")
	public WebElement Amend;
	
	@FindBy(id="edit0")
	public WebElement TermIcon;
	
	@FindBy(id="readonly0")
	public WebElement TermIconValue;

	@FindBy(id="amount")
	public WebElement amount;
	
	@FindBy(id="tdCheckBoxId0")
	public WebElement Checkbox;
	
	@FindBy(id="ButtonApprove1")
	public WebElement Accept;
	
	@FindBy(id="salesPotentilListBean.customerId")
	public WebElement customerID;
	
	@FindBy(xpath="/HTML/BODY/FORM/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[2]/TD[10]")
	//@FindBy(xpath="//td[contains(text(),'APPROVED')]")
	public WebElement Statusdisplay;
	
	@FindBy(linkText="EXCEPTION REQUEST")
	public WebElement Exceptionscreen;
	
	@FindBy(xpath="/HTML/BODY/FORM/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[2]/TD[2]/A")
	public WebElement IDtext;
	
	@FindBy(linkText="Pending Approval List")
	public WebElement PAL;
	
	@FindBy(id="ButtonAccept")
	public WebElement PALAccept;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public CCPSPLScreen CCPLink()
	{
		CCP.click();
		return new CCPSPLScreen(driver);
	}
	
	public CCPSPLScreen setSALESStatus(String status)
	{
		SALESStatus.click();
		SALESStatus.sendKeys(status);
//		Select select=new Select(SALESStatus);
//		select.selectByVisibleText(status);
		return new CCPSPLScreen(driver);
	}
	public CCPSPLScreen SearchLink()
	{
		Search.click();
		return new CCPSPLScreen(driver);
	}
	public CCPSPLScreen AmendLink()
	{
		Amend.click();
		return new CCPSPLScreen(driver);
	}
	public String IDTextdisplay()
	{
		CustomerID=IDtext.getText();
		return CustomerID;
	}
	public CCPSPLScreen TermIconwindow(String termLimit,String productLimit) throws InterruptedException
	{
		System.out.println("perfet");
		System.out.println("term value"+TermIconValue.getText());
		System.out.println("term limit"+termLimit);
		if(!TermIconValue.getText().equals(termLimit))
		{
			
			//System.out.println("Anser is"+TermIconValue.getText()!=termLimit);
		TermIcon.click();
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
		    
		     amount.sendKeys(Keys.BACK_SPACE);
		     amount.sendKeys(Keys.BACK_SPACE);
		     amount.sendKeys(Keys.BACK_SPACE);
		     amount.sendKeys(Keys.BACK_SPACE);
		     amount.sendKeys(Keys.BACK_SPACE);
		     amount.sendKeys(Keys.BACK_SPACE);
		     Thread.sleep(2000);
		     driver.findElement(By.id("amount")).sendKeys(termLimit);
		     driver.findElement(By.id("termType")).sendKeys(productLimit);
		     driver.findElement(By.id("recommendation")).sendKeys("Done");
		     driver.findElement(By.linkText("Save")).click();
//		     //driver.quit();
//		     driver.close(); //closing child window
		     driver.switchTo().window(parentWindow); //cntrl to parent window
		    }
		}
		}
		return new CCPSPLScreen(driver);
	}
	public CCPSPLScreen TermIconwindowProduct(String termLimit,String productLimit) throws InterruptedException
	{
		System.out.println("perfet");
		System.out.println("term value"+TermIconValue.getText());
		//System.out.println("term limit"+termLimit);
		
			
			//System.out.println("Anser is"+TermIconValue.getText()!=termLimit);
		TermIcon.click();
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
		    if(!termLimit.equalsIgnoreCase("true"))
		    {
		    	amount.sendKeys(Keys.BACK_SPACE);
			     amount.sendKeys(Keys.BACK_SPACE);
			     amount.sendKeys(Keys.BACK_SPACE);
			     amount.sendKeys(Keys.BACK_SPACE);
			     amount.sendKeys(Keys.BACK_SPACE);
			     amount.sendKeys(Keys.BACK_SPACE);
			     Thread.sleep(2000);
			     driver.findElement(By.id("amount")).sendKeys(termLimit);
		    }
		    
		     driver.findElement(By.id("termType")).sendKeys(productLimit);
		     driver.findElement(By.id("recommendation")).sendKeys("Done");
		     driver.findElement(By.linkText("Save")).click();
//		     //driver.quit();
//		     driver.close(); //closing child window
		     driver.switchTo().window(parentWindow); //cntrl to parent window
		    }
		
		}
		return new CCPSPLScreen(driver);
	}
	
	public CCPSPLScreen Checkboxclick() throws InterruptedException
	{
		Thread.sleep(2000);
		Checkbox.click();
		return new CCPSPLScreen(driver);
	}
	public CCPSPLScreen Acceptbutton()
	{
		Accept.click();
		return new CCPSPLScreen(driver);
	}
	public CCPSPLScreen Alert() throws InterruptedException
	{
		Thread.sleep(2000);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
		    if(!windowHandle.equals(parentWindow))
		   {
		    	
		     driver.switchTo().window(windowHandle);
		     System.out.println("IN CHILLD alert");
		     driver.getTitle();
		     System.out.println(driver.getTitle());
		    
		     driver.findElement(By.xpath("//*[contains(text(),'Confirm')]")).click();
//		     //driver.quit();
//		     driver.close(); //closing child window
		     driver.switchTo().window(parentWindow); //cntrl to parent window
		    }
		}
		
		return new CCPSPLScreen(driver);
	}
	public CCPSPLScreen setcustomerID(String ID)
	{
		customerID.sendKeys(ID);
		return new CCPSPLScreen(driver);
	}
	public String Status()
	{
		return Statusdisplay.getText();
	}
	public CCPSPLScreen Exceptionscreenlink() throws InterruptedException
	{
		Exceptionscreen.click();
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
		    
		     driver.findElement(By.linkText("Additional Loan")).click();
		     StatusInExceptnScreen = driver.findElement(By.xpath("//*[contains(text(),'APPROVED')]")).getText();
		     Thread.sleep(2000);
		     driver.findElement(By.linkText("Close")).click();
//		     //driver.quit();
		     //driver.close(); //closing child window
		     driver.switchTo().window(parentWindow); //cntrl to parent window
		    }
		}
		return new CCPSPLScreen(driver);
	}
	
	public CCPSPLScreen PALLink()
	{
		PAL.click();
		return new CCPSPLScreen(driver);
	}
	public CCPSPLScreen PALAcceptbutton()
	{
		PALAccept.click();
		return new CCPSPLScreen(driver);
	}
	public String CheckApprovalONPAL(String header,String Rowval)
	{
		String status = null;
		Boolean status1;
		
		String FirstHeader="/HTML/BODY/FORM/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[1]/TH[";
		String FirstRow ="/HTML/BODY/FORM/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[2]/TD[";
		String Last="]";
		for(int i=1;i<=13;i++)
		{
			String textHeader=driver.findElement(By.xpath(FirstHeader+i+Last)).getText();
			String textRows=driver.findElement(By.xpath(FirstRow+i+Last)).getText();
			if(textHeader.equalsIgnoreCase(header)&&textRows.equalsIgnoreCase(Rowval))
			{
				status1=true;
				System.out.println();
				status =String.valueOf(status1);
			}
		}
		return status;
	}
	public CCPSPLScreen ExceptionscreenlinkDO() throws InterruptedException
	{
		Exceptionscreen.click();
		Thread.sleep(2000);
		/*String parent=driver.getWindowHandle(); 
		Set<String>s1=driver.getWindowHandles();
		Iterator<String> I1= s1.iterator(); 
		while(I1.hasNext())
		{    
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window); 
				System.out.println(driver.switchTo().window(child_window).getTitle());
				 System.out.println(driver.getTitle());
				    
			     driver.findElement(By.linkText("Additional Loan")).click();
			     WebElement f = driver.findElement(By.id("customerCreditLimitBean.proposedLimit"));
			     f.sendKeys(Keys.BACK_SPACE);
			     f.sendKeys(Keys.BACK_SPACE);
			     f.sendKeys(Keys.BACK_SPACE);
			     f.sendKeys(Keys.BACK_SPACE);
			     f.sendKeys(Keys.BACK_SPACE);
			     f.sendKeys("40.00");
			     driver.findElement(By.id("prevRecommendations")).sendKeys("save");
			     
			}
			if(!parent.equals(driver.switchTo().window(childWindow).getTitle().equals))
			{
		}*/
		String mainWindowHanhle=driver.getWindowHandle();

		//Do/Click something to open child window

		Set<String> childParentHandles=driver.getWindowHandles();

		childParentHandles.remove(mainWindowHanhle);   //removing main window handle from Set

		driver.switchTo().window((String) childParentHandles.toArray()[0]); //switching the control to child window

		 driver.findElement(By.linkText("Additional Loan")).click();
	     WebElement f = driver.findElement(By.id("customerCreditLimitBean.proposedLimit"));
	     f.sendKeys(Keys.BACK_SPACE);
	     f.sendKeys(Keys.BACK_SPACE);
	     f.sendKeys(Keys.BACK_SPACE);
	     f.sendKeys(Keys.BACK_SPACE);
	     f.sendKeys(Keys.BACK_SPACE);
	     f.sendKeys("40.00");
	     driver.findElement(By.id("recommendation")).sendKeys("save");
	     driver.findElement(By.linkText("Save")).click();
       Thread.sleep(3000);
		Set<String> grandChild_Child_ParentHandles=driver.getWindowHandles();
      
		grandChild_Child_ParentHandles.remove(mainWindowHanhle);
		grandChild_Child_ParentHandles.remove(childParentHandles);  //remove parent,child window handle from set
        System.out.println("out main and child");
		//Now switch the control to grand_Child window
		driver.switchTo().window((String) grandChild_Child_ParentHandles.toArray()[1]);
		 System.out.println("Switching to child2 window");
		System.out.println(driver.getTitle());
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[contains(text(),'Confirm')]")).click();
		Thread.sleep(10000);
		driver.switchTo().window((String) grandChild_Child_ParentHandles.toArray()[0]);
		driver.findElement(By.linkText("Close")).click();
		driver.switchTo().window(mainWindowHanhle);
		return new CCPSPLScreen(driver);
	}
	
	
}