
package pageobjects.cap;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtilities;

public class SearchCustAffordability {

	WebDriver driver;
    WebDriverWait wait;

	public SearchCustAffordability(WebDriver driver)
	{
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(this.driver, 15);
		//PageFactory.initElements( driver, this);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	
	@FindBy(linkText="Affordability")
	public WebElement Affortability;
	
	@FindBy(id="amend")
	public WebElement Amend;
	
	@FindBy(id="wagesAmount")
	public WebElement Wages;
	
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[4]/TD[2]/TABLE/TBODY/TR[2]/TD[1]/TABLE/TBODY/TR[3]/TD[2]")
	public WebElement FinalWages;
	
	@FindBy(name="dummySave")
	public WebElement Save;
	
	@FindBy(id="period")
	public WebElement Period;
	
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[2]/TD[1]")
	public WebElement Cust;
	
	
	public SearchCustAffordability custclick()
	{
		System.out.println(Cust.getText());
		driver.findElement(By.xpath("//a[contains(text(),'"+Cust.getText()+"')]")).click();
		return new SearchCustAffordability(driver);
	}
	
	
	
	public SearchCustAffordability Affortability()
	{
		Affortability.click();
		return new SearchCustAffordability(driver);
	}
	public SearchCustAffordability AmendButton()
	{
		Amend.click();
		return new SearchCustAffordability(driver);
	}
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
	}
	
}