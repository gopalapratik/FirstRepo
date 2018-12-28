// Autor ===================>> Rajesh Beg ===========================================================================
// Date -25/09/2018

package pageobjects.cap;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgentAmend {

	WebDriver driver;
    WebDriverWait wait;
    public static String Message=null;
    public static String validcardNumber=null;
    public static String result=null;
	public AgentAmend(WebDriver driver)
	{
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(this.driver, 15);
		//PageFactory.initElements( driver, this);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	
	@FindBy(linkText="Business Administration")
	public WebElement BusinessAdministration;
	
	@FindBy(linkText="ATM Cards")
	public WebElement ATMcard;
	
	@FindBy(xpath="//*[@id=\"tbl-container\"]/table/tbody/tr[1]/td[2]/a")
	public WebElement CardNumber;
	
	
	// Check Box
	@FindBy(xpath="//*[@id=\"tbl-container\"]/table/tbody/tr[1]/td[1]/input")
	public WebElement ATMcheckbox;
	
	@FindBy(linkText="Amend")
	public WebElement Amend;
	
	// New Card Number
	@FindBy(xpath="//input[@name='newCardNo']")
	public WebElement NewCardNumber;
	
	

   @FindBy(linkText="Apply")
	public WebElement Apply;
	
   @FindBy(id="error")
	public WebElement Msg;
   
   
		
	
	// Started New From Here 
	public AgentAmend BusinessAdministrationclick()
	{
		BusinessAdministration.click();
		return new AgentAmend(driver);
	}
	public AgentAmend ATMclick()
	{
		ATMcard.click();
		return new AgentAmend(driver);
	}
	
	public AgentAmend selectCheckbox()
	{
		
		//check box checked 
		ATMcheckbox.click();
		return new AgentAmend(driver);
	}
	
	//AmendClick
	public AgentAmend AmendClick()
	{
		
		//click on Amend
		Amend.click();
		return new AgentAmend(driver);
	}
	
	public AgentAmend ValidATMcardNumber() throws InterruptedException
	{
		
		
		
		List<WebElement>Cardnumbers=driver.findElements(By.xpath("//*[@id=\"tbl-container\"]/table/tbody/tr/td[2]"));
		System.out.println(Cardnumbers.size());
		

		for(int j=0;j<=Cardnumbers.size()-1;j++) {
//			System.out.println(Names.get(j).getText());
			if(Cardnumbers.get(j).getText().equals(validcardNumber))
			{
				Thread.sleep(3000);
				// set the result ot Valid number 
				 result=validcardNumber;
				break;
			}
			
		}
		return new AgentAmend(driver);
	}
	
	public AgentAmend quiteWeb()
	{
		
		//click on Amend
		driver.quit();
		return new AgentAmend(driver);
	}
	
	// Enter Invalid card Number 5 digit )from Excel
	public AgentAmend EnterInvalidcardno(String str) throws InterruptedException
    {
		
		
		
		
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			
			
		    if(driver.switchTo().window(windowHandle).getTitle().equals("Amend ATM Card"))
		   {	
		     driver.switchTo().window(windowHandle);
		     System.out.println("IN CHILLD1");
		     NewCardNumber.sendKeys(str);
		     Thread.sleep(3000);
		     
		     // Click on Apply 
		     
		     Apply.click();
		     Thread.sleep(10000);
		     Message= Msg.getText();
		   
		   }
		}
		driver.switchTo().window(parentWindow);		
		
    	return new AgentAmend(driver);
    }
	
	public AgentAmend EnterValidCardNumber() throws InterruptedException
    {
		
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			
			
		    if(driver.switchTo().window(windowHandle).getTitle().equals("Amend ATM Card"))
		   {	
		     driver.switchTo().window(windowHandle);
		     System.out.println("IN CHILLD1");
		     Random rnd = new Random();
		     int n = 100000 + rnd.nextInt(900000);
		      validcardNumber=String.valueOf(n);
		     
		     NewCardNumber.sendKeys(validcardNumber);
		     Thread.sleep(3000);
		     
		     // Click on Apply 
		     
		     Apply.click();
		     Thread.sleep(10000);
		    
		   
		   }
		}
		driver.switchTo().window(parentWindow);		
		
    	return new AgentAmend(driver);
    }
	// Enter the existed Number 
	public AgentAmend EnterExistedNumber() throws InterruptedException
    {
		 String Cardnumber=CardNumber.getText();
	     System.out.println(Cardnumber);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			
			
		    if(driver.switchTo().window(windowHandle).getTitle().equals("Amend ATM Card"))
		   {	
		     driver.switchTo().window(windowHandle);
		     System.out.println("IN CHILLD1");
		    
		     NewCardNumber.sendKeys(Cardnumber);
		     Thread.sleep(3000);
		     
		     // Click on Apply 
		     
		     Apply.click();
		     Thread.sleep(10000);
		     Message= Msg.getText();
		   
		   }
		}
		driver.switchTo().window(parentWindow);		
		
    	return new AgentAmend(driver);
    }
	
	// return Valid card number
	public String validcardNumber()
	{
		return validcardNumber;
		
	}
	
	
	//Return Error Message string
	public String Message()
	{
		return Message;
		
	}
	
	// Enter the Valid Card Numkber 
	public AgentAmend ValidCardNumber()
	{
		
		//click on Amend
		Amend.click();
		return new AgentAmend(driver);
	}
	public String ExistedATM() {
		// TODO Auto-generated method stub
		return result;
	}
	
	
	
	/*
	
	
	public SearchCustAffordability setWages(String wag)
	{
	
		
		for(int i = 0; i<=20; i++)
		{
		if(Wages.getText().equals(null))
		{}
		else
		{Wages.sendKeys(Keys.BACK_SPACE);}}
		//Wages.clear();
		Wages.sendKeys(wag);
		return new SearchCustAffordability(driver);
		
		
	}
	public SearchCustAffordability SaveButton()
	{
		Save.click();
		return new SearchCustAffordability(driver);
	}
	public String AmendWages()
	{
		return FinalWages.getText();
	}
	public SearchCustAffordability sePeriod(String PD)
	{
		Wages.sendKeys(PD);
		return new SearchCustAffordability(driver);
	}
	public String CheckResultWages(String header)
	{
		String value=null;
		    int i=1;
			int j=i+1;
			String xpath1="//TABLE[@id='wagesTbl']/TBODY/TR/TD["+i+"]";
			String xpath2="//TABLE[@id='wagesTbl']/TBODY/TR/TD["+j+"]";
			if(driver.findElement(By.xpath(xpath1)).getText().equalsIgnoreCase(header))
			{
				value=driver.findElement(By.xpath(xpath2)).getText();
			}
			if(header.equalsIgnoreCase("Document"))
			{
				int k=4;
				String xpath3="//TABLE[@id='wagesTbl']/TBODY/TR/TD["+k+"]";
				value=driver.findElement(By.xpath(xpath3)).getText();
			}
			if(header.equalsIgnoreCase("Ref"))
			{
				
				int k=5;
				String xpath4="//TABLE[@id='wagesTbl']/TBODY/TR/TD["+k+"]";
				value=driver.findElement(By.xpath(xpath4)).getText();
			}
				
			
		
		return value;
	}
	
	public String CheckResultrent(String header)
	{
		String value=null;
			int i=1;
			int j=i+1;
			String xpath1="//TABLE[@id='rentTbl']/TBODY/TR/TD["+i+"]";
			String xpath2="//TABLE[@id='rentTbl']/TBODY/TR/TD["+j+"]";
			if(driver.findElement(By.xpath(xpath1)).getText().equalsIgnoreCase(header))
			{
				value=driver.findElement(By.xpath(xpath2)).getText();
			}
		
		return value;
	}*/
	
}

