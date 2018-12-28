package pageobjects.cap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListProduct {
	WebDriver driver;
    WebDriverWait wait;
    public static String add;
	public ListProduct(WebDriver driver)
	{
			this.driver = driver;
	        this.driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
	        wait = new WebDriverWait(this.driver, 200);
			//PageFactory.initElements( driver, this);
			 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 200), this);
	}
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/table")
	public WebElement table;
	
	@FindBy(id="btSaveID")
	public WebElement Amend;
	
	@FindBy(id="spanNext")
	public WebElement Next;
	
	@FindBy(name="term")
	public WebElement Term;
	
	@FindBy(linkText="Save")
	public WebElement Save;
	
	@FindBy(xpath="//td[contains(text(),'weeks')]")
	public WebElement TermRs;
	
//	@FindBy(xpath="/HTML/BODY/TABLE/TBODY/TR[2]/TD/FORM[1]/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[1]/TD[1]/TABLE/TBODY/TR[9]/TD[3]")
//	public WebElement TermRs;
	
	
	
	
	public ListProduct productclick()
	{
		for(int i=0;i<=10;i++)
		{
		if(table.getText().contains("243308"))
		{
			driver.findElement(By.xpath("//*[contains(text(), '243308')]")).click();
			break;
		}
		else
		{
			Next.click();
			
		}
		}
		return new ListProduct(driver);
		
	}
	public ListProduct AmendProduct()
	{
		Amend.click();
		return new ListProduct(driver);
	}
	
	public ListProduct AmendTerm()
	{
//		System.out.println(Term.isDisplayed());
//		String s = driver.findElement(By.name("term")).getText();
//		System.out.println(s);
		int incr=Integer.valueOf(Term.getAttribute("value"))+1;
//		System.out.println(incr);
		add = String.valueOf(incr);
//		System.out.println(add);
		Term.sendKeys(Keys.BACK_SPACE);
		Term.sendKeys(Keys.BACK_SPACE);
		Term.sendKeys(Keys.BACK_SPACE);
		Term.sendKeys(add);
		return new ListProduct(driver);
	}
	public ListProduct SaveButton()
	{
		Save.click();
		return new ListProduct(driver);
	}
	
	public String Termresult()
	{
		return TermRs.getText();
		
	}
	
}
