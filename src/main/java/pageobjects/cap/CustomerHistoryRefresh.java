
package pageobjects.cap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerHistoryRefresh {

	WebDriver driver;
    WebDriverWait wait;
    	String FirNme;
    	String LastNme;
	public CustomerHistoryRefresh(WebDriver driver)
	{
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(this.driver, 15);
		//PageFactory.initElements( driver, this);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	

//////

	@FindBy(xpath="//DIV[@id='tbl-container']/TABLE/TBODY/TR[1]/TD[2]")
    public WebElement NewACC;
	
	@FindBy(xpath="/HTML/BODY/FORM/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[5]/TD[2]/TABLE/TBODY/TR[2]/TD[4]")
	public WebElement CustName;
	
	@FindBy(name="searchFirstName")
	public WebElement FirstName;
	
	@FindBy(name="searchLastName")
	public WebElement LastName;
	
	@FindBy(name="searchStatus")
	public WebElement LStatus;

	public String NewACCount()
    {
  
    	return NewACC.getText();
    }
    
	public CustomerHistoryRefresh EnterDetails() {
		LStatus.click();
		Select f = new Select(LStatus);
		f.selectByVisibleText("");
		String name = CustName.getText();
		String[] CusName = name.split(" ");
		for(int i=0;i<=CusName.length;i++)
		{
			String a =CusName[0];
			FirNme =CusName[1];
			LastNme =CusName[2];
			
		}
		FirstName.sendKeys(FirNme);
		LastName.sendKeys(LastNme);
		
		
		return new CustomerHistoryRefresh(driver);
	}
	
}

	