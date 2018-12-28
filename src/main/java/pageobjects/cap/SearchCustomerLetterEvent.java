package pageobjects.cap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

import utilities.ExcelUtilities;


public class SearchCustomerLetterEvent {
	
	WebDriver driver;
    WebDriverWait wait;
    String parentHandle =null;
    public static String ErrorMsg=null;
    public SearchCustomerLetterEvent(WebDriver driver)
    {
    	this.driver = driver;
    	this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    	new WebDriverWait(this.driver, 15);
    	PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }
    
   ///////////////////////////// Declaration///////////////////////////////
    
    @FindBy(linkText="Letters/Event Logs")
    public WebElement LetterEvent;
    
    @FindBy(id="history")
    public WebElement Veiw;
    // changed the data
    @FindBy(xpath="//td[contains(text(),'23/08/2018 12:10:20')]")
    public WebElement LResult;
   
    @FindBy(name="eventType")
    public WebElement logtype;
    
    @FindBy(xpath="//DIV[@id='dvData']/TABLE/TBODY/TR[1]/TD[2]")
    public WebElement LogTypeValue;
    
    @FindBy(linkText="Create New Log Entry")
    public WebElement Create;
    
    @FindBy(id="eventReason")
    public WebElement RType;
    
    @FindBy(id="eventDesc")
    public WebElement Des;
    
    @FindBy(linkText="Save")
    public WebElement save;
    
  /*  @FindBy(xpath="//td[contains(text(),'08/02/2012')]")
    public WebElement NewLResult;*/
    ////////////////////////////Implementation////////////////////////////////
    
    public SearchCustomerLetterEvent LetterEventclick()
    {
    	LetterEvent.click();
    	return new SearchCustomerLetterEvent(driver);
    }
    public SearchCustomerLetterEvent LogTypeselect(String lgType)
    {
//    	Select select = new Select(logtype);
//    	 select.selectByIndex(lgType);;
//    	 return new SearchCustomerLetterEvent(driver);
    	logtype.sendKeys(lgType);
    	return new SearchCustomerLetterEvent(driver);
    	
    }
    
    public String LogType()
    {
    	return logtype.getText();
    }
    public SearchCustomerLetterEvent VeiwHistory()
    {
    	Veiw.click();
    	return new SearchCustomerLetterEvent(driver);
    }
    public String LogResult()
    {
    	return LResult.getText();
    }
    public String LogResLogType()
    {
    	return LogTypeValue.getAttribute("alt");
    }
    public SearchCustomerLetterEvent CreateNewLog()
    {
    	Create.click();
    	return new SearchCustomerLetterEvent(driver);
    }
    public SearchCustomerLetterEvent NewWindowOpen(String data,String blankDes) throws InterruptedException
    {
    	Thread.sleep(2000);
    	String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
		    if(!windowHandle.equals(parentWindow))
		   {	
		    	 driver.switchTo().window(windowHandle);
	    	    // switch focus of WebDriver to the next found window handle (that's your newly opened window)
	    	    driver.getTitle();
	        	System.out.println("Pagetitle "+driver.getTitle());
	        	Thread.sleep(2000);
	        	
	        	if(blankDes.equalsIgnoreCase("true"))
	        	{
	        		save.click();
	        		ErrorMsg=driver.findElement(By.id("error")).getText();
	        	}
	        	else
	        	{
	        		Des.sendKeys(data);
	        		driver.findElement(By.xpath(".//textarea[@name='eventLogs']")).sendKeys("Save");
	        		save.click();
	        	}
	        		        	
		   }
    	
		    driver.switchTo().window(parentWindow);
    	
    /*	//Create.sendKeys(Keys.RETURN);
    	Thread.sleep(2000);
    	String parentHandle = driver.getWindowHandle(); 
    	//CreateNewLog();
    	
    	//Thread.sleep(5000);
    	//driver.switchTo().window("Log Entry");
    	for (String winHandle : driver.getWindowHandles()) {
    	    driver.switchTo().window(winHandle); 
    	    // switch focus of WebDriver to the next found window handle (that's your newly opened window)
    	    driver.getTitle();
        	System.out.println("Pagetitle "+driver.getTitle());
        	Thread.sleep(2000);
        	Des.sendKeys(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "19", 4));
        	save.click();
        	driver.switchTo().window(parentHandle);
        	
    	}*/
		}
    	return new SearchCustomerLetterEvent(driver);
    	  
    }
    public SearchCustomerLetterEvent ReasonType(String resn)
    {
    	RType.sendKeys(resn);
    	return new SearchCustomerLetterEvent(driver);
    	
    }
    public SearchCustomerLetterEvent Description(String des)
    {
    	Des.sendKeys(des);
    	return new SearchCustomerLetterEvent(driver);
    	
    }
    public SearchCustomerLetterEvent SaveButton()
    {
    	save.click();
    	driver.switchTo().window(parentHandle);
    	return new SearchCustomerLetterEvent(driver);
    }
    public String NewlogResult()
    {
    	String res= driver.findElement(By.xpath("//DIV[@id='dvData']/TABLE/TBODY/TR[1]/TD[3]")).getText();
    	System.out.println(res);
    	String split = res.substring(0, 16);
    	System.out.println("split     "+split);
    	return split;
    }
    // get the current Date and time
    public String currentDate() {
    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    	   LocalDateTime now = LocalDateTime.now();  
    	   System.out.println(dtf.format(now));
		return currentDate();  
    	
    }
    
    
   

}
