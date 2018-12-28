package pageobjects.cap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;



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

import com.graphbuilder.math.func.LgFunction;

import utilities.ExcelUtilities;


public class SearchCustomerStatement {
	
	WebDriver driver;
    WebDriverWait wait;
    String parentHandle =null;
    public static String aggNo=null;
    
    public SearchCustomerStatement(WebDriver driver)
    {
    	this.driver = driver;
    	this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    	new WebDriverWait(this.driver, 15);
    	PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }
    
    @FindBy(linkText="Statement")
    public WebElement Stat;
    
    @FindBy(linkText="Letters/Event Logs")
    public WebElement LetterEvent;
    
    @FindBy(linkText="Create New Log Entry")
    public WebElement NewLogEntry;
    
    @FindBy(name="accountList")
    public WebElement Acc;
    
    @FindBy(linkText="Amend")
    public WebElement Amen;
    
    @FindBy(name="agreementNo")
    public WebElement AGGNO;
    
    @FindBy(id="save")
    public WebElement Save;
    
    @FindBy(id="error")
    public WebElement msg;
    
    @FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[1]/TD[3]/TABLE/TBODY/TR[4]/TD[2]")
    public WebElement Result;
    
    @FindBy(xpath="//TABLE[@id='tbl']/TBODY/TR[1]/TD[1]")
    public WebElement ResultDate;
    
    @FindBy(xpath="//TABLE[@id='tbl']/TBODY/TR[1]/TD[6]")
    public WebElement ResultCredit;
    
    @FindBy(xpath="//TABLE[@id='tbl']/TBODY/TR[1]/TD[3]")
    public WebElement AccountNumber;
    
    @FindBy(xpath="//Input[@name='strAgreeFromDate']")
    public WebElement AggDate;
    @FindBy(xpath="//Input[@name='strReduceRepayReviewDate']")
    public WebElement ReviewDate;
  
    
  //TABLE[@id='tbl']/TBODY/TR[1]/TD[6]
    
    ////////////////////////////Implementation////////////////////////////////
    
    public SearchCustomerStatement Statement()
    {
    	Stat.click();
    	return new SearchCustomerStatement(driver);
    }
    
    public SearchCustomerStatement LettersEventLog()
    {
    	LetterEvent.click();
    	return new SearchCustomerStatement(driver);
    }
    
    
    
    
    public SearchCustomerStatement NewLogEntry()
    {
    	NewLogEntry.click();
    	return new SearchCustomerStatement(driver);
    }
    public SearchCustomerStatement AggDate() throws InterruptedException
    {
    	Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate= formatter.format(date); 
	    System.out.println(strDate);
	    for(int i = 0; i<=20; i++)
		{
		if(AggDate.getText().equals(null))
		{}
		else
		{AggDate.sendKeys(Keys.BACK_SPACE);}}
    	Thread.sleep(2000);
    	AggDate.sendKeys(strDate);
    	return new SearchCustomerStatement(driver);
    }
    public SearchCustomerStatement ReviewDate() throws InterruptedException, ParseException
    {
    	// Current Date and Future Date
    	Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate= formatter.format(date); 
	    final java.util.Calendar cal = GregorianCalendar.getInstance();
	  Date date1=formatter.parse(strDate);
	    cal.setTime( date1 );
	    cal.add( GregorianCalendar.MONTH, 5 );
	    String RevDate= formatter.format( cal.getTime());
	    System.out.println(RevDate);
	    for(int i = 0; i<=20; i++)
		{
		if(ReviewDate.getText().equals(null))
		{}
		else
		{ReviewDate.sendKeys(Keys.BACK_SPACE);}}
    	Thread.sleep(2000);
    	ReviewDate.sendKeys(RevDate);
    	return new SearchCustomerStatement(driver);
    }
    
    public SearchCustomerStatement Account(String accNo)
    {
    	Acc.sendKeys(accNo);
    	return new SearchCustomerStatement(driver);
    }
    public SearchCustomerStatement Amend()
    {
    	Amen.click();
    	return new SearchCustomerStatement(driver);
    }
    public SearchCustomerStatement AggNumber(String aggnum)
    {
    	for(int i = 0; i<=20; i++)
		{
		if(AGGNO.getText().equals(null))
		{}
		else
		{AGGNO.sendKeys(Keys.BACK_SPACE);}}
    	//AGGNO.sendKeys(agg);
    	long b =System.currentTimeMillis();
		String h = String.valueOf(b);
		//System.out.println("kkkkkkk"+h);
		int index = 5;
		char[] chs = h.toCharArray();
		//String part1 = new String(chs, 0, index);
		aggNo = new String(chs, index, chs.length - index);
		//System.out.println("part2  "+aggnum);
		//System.out.println("part2length   "+aggnum.length());
		AGGNO.sendKeys(aggNo);
		return new SearchCustomerStatement(driver);
    	//return new SearchCustomerStatement(driver);
    }
    public SearchCustomerStatement SaveButton()
    {
    	Save.click();
    	return new SearchCustomerStatement(driver);
    }
    public String Message()
    {
    	return msg.getText();
    }
    public String StatResult()
    {
    	return Result.getText();
    }
    public String ResultE2E()
    {
    	return ResultDate.getText();
    }
    public String ResultE2ECredit()
    {
    	return ResultCredit.getText();
    }
    
    public String getAccountNumber()
    {
    	return AccountNumber.getText();
    }
    
    public String getCreditCadAmtForSpecificAccount(String strTransactionDate, String str)
    {
    	return driver.findElement(By.xpath("//td[@text='"+strTransactionDate+"']/../td[@text='"+str+"']/following-sibling::td[6]")).getText();
    	
    }
    
    
    
    
    public String getBalanceAmtForSpecificAccount(String str)
    {
    	return driver.findElement(By.xpath("//td[@text='"+str+"']/following-sibling::td[4]")).getText();
    }
    
      
}