
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
import org.openqa.selenium.support.ui.WebDriverWait;


import utilities.ExcelUtilities;

public class SearchCustmerSUMMARY {

	WebDriver driver;
    WebDriverWait wait;

	public SearchCustmerSUMMARY(WebDriver driver)
	{
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(this.driver, 15);
		//PageFactory.initElements( driver, this);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

	
	

	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[1]/TD[1]/TABLE/TBODY")
	public WebElement Result;
	

	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[1]/TD[3]/TABLE/TBODY/TR[5]/TD[2]")
	public WebElement Bal;
	
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[1]/TD[3]/TABLE/TBODY/TR[6]/TD[2]")
	public WebElement HouseholdBal;
	
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[1]/TD[3]/TABLE/TBODY/TR[20]/TD[4]")
	public WebElement date;
	
	
	@FindBy(name="showAllAccounts")
	public WebElement ShowallBal;
	
	@FindBy(xpath="//DIV[@id='tbl-container2']/TABLE/TBODY/TR[1]/TD[1]/A")
	public WebElement acno1;
	
	@FindBy(xpath="//DIV[@id='tbl-container2']/TABLE/TBODY/TR[2]/TD[1]/A")
	public WebElement acno2;
	
	@FindBy(xpath="//DIV[@id='tbl-container2']/TABLE/TBODY/TR[2]/TD[1]/A")
	public WebElement Account;
	
//	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[2]/TD[2]/TABLE/TBODY/TR/TD[14]")
//	public WebElement Sresult;
	
	@FindBy(className="selected")
	public WebElement Sresult;
	
	@FindBy(linkText="Amend")
	public WebElement Amend;
	
	@FindBy(name="territoryName")
	public WebElement TTN;
	
	@FindBy(name="customerBean.firstName")
	public WebElement FN;
	
	@FindBy(name="customerCode")
	public WebElement CID;
	
	@FindBy(name="customerBean.salutation")
	public WebElement Title;
	
	@FindBy(name="customerBean.status")
	public WebElement Status;
	
	@FindBy(name="customerBean.lastName")
	public WebElement LastN;
	
	@FindBy(linkText="New Search")
	public WebElement NewSearch;
	
	@FindBy(name="dummySave")
	public WebElement save;
	
	@FindBy(name="customerBean.homePhone")
	public WebElement HPhone;
	
	@FindBy(name="customerBean.mobilePhone")
	public WebElement Mphone;
	
	@FindBy(xpath="//a[contains(text(),'17')]")
	public WebElement CustIDlink;
	
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[1]/TD[1]/TABLE/TBODY/TR[4]/TD[2]")
	public WebElement RAmend;
	
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[1]/TD[1]/TABLE/TBODY/TR[1]/TH/B")
	public WebElement Presult;
	
	/*
	 destinationTerritoryTextBox : Contains Destination Territory TextBox locator
	 */
	@FindBy(xpath="//input[@id='territoryName']/../a")
	public WebElement territorySearchButton;
	
	/*
	 errorMessage : Contains 'Error Message' locator
	 */
	@FindBy(id="error")
   public WebElement errorMessage;
	
	
	public SearchCustmerSUMMARY clickOnTerritorySearchButton() {
		territorySearchButton.click();
		return new SearchCustmerSUMMARY(driver);
	}
	
	public String Result1() {
		return Result.getText();
	}
	
	public String Balance() {
		return Bal.getText();
	}
	public String HBalance() {
		return HouseholdBal.getText();
	}
	
	public String ACdate() {
		return date.getText();
	}
			
	public String ACNO1() {
		return acno1.getText();
	}
	public String ACNO2() {
		return acno2.getText();
	}
	
	public SearchCustmerSUMMARY AccountLink() {
		Account.click();
		return new SearchCustmerSUMMARY(driver);
	}
	public String ScreenResult() {
		return Sresult.getText();
	}
	
	public SearchCustmerSUMMARY showBal() {
		ShowallBal.click();
		return new SearchCustmerSUMMARY(driver);
	}
	
	public SearchCustmerSUMMARY AmendButton() {
		Amend.click();
		return new SearchCustmerSUMMARY(driver);
	}
	public SearchCustmerSUMMARY CLink() {
		CustIDlink.click();
		return new SearchCustmerSUMMARY(driver);
	}
	
	public String getTerritorName() {
		return TTN.getAttribute("value");
	}
	
	public SearchCustmerSUMMARY setTTN(String territory) {
		
		for(int i = 0; i<=6; i++)
		{
		if(TTN.getText().equals(null))
		{}
		else
		{TTN.sendKeys(Keys.BACK_SPACE);}}
		
		TTN.sendKeys(territory);
		return new SearchCustmerSUMMARY(driver);
		
		}
		
	public SearchCustmerSUMMARY setFirstN(String firstname) {
		//FN.clear();
		int name=FN.getAttribute("value").length();
		if(FN.getAttribute("value").length()!=0)
		{
			for(int i=0;i<name;i++)
			{
				FN.sendKeys(Keys.BACK_SPACE);
				
			}
		}
		FN.sendKeys(firstname);
		return new SearchCustmerSUMMARY(driver);
	}
	
	public SearchCustmerSUMMARY setTitle(String Stitle) {
		Title.sendKeys(Stitle);
		return new SearchCustmerSUMMARY(driver);
	}
	
	public SearchCustmerSUMMARY setStatus(String Sstatus) {
		Status.sendKeys(Sstatus);
		return new SearchCustmerSUMMARY(driver);
	}
	
	public SearchCustmerSUMMARY setLastN(String LastName) {
		//LastN.clear();
	//	LastN.sendKeys(LastName);
		
		int name=LastN.getAttribute("value").length();
		System.out.println("name"+name);
		if(LastN.getAttribute("value").length()!=0)
		{
			for(int i=0;i<name;i++)
			{
				LastN.sendKeys(Keys.BACK_SPACE);
				
			}
		}
		
		LastN.sendKeys(LastName);
		return new SearchCustmerSUMMARY(driver);
	}
	public SearchCustmerSUMMARY setHP(String HomePhone) throws InterruptedException {
		
		for(int i = 0; i<=10; i++)
		{
		if(HPhone.getText().equals(null))
		{}
		else
		{HPhone.sendKeys(Keys.BACK_SPACE);}}
		
		HPhone.sendKeys(HomePhone);
		return new SearchCustmerSUMMARY(driver);
	}
	public SearchCustmerSUMMARY setMP(String MobilePhone) {
		for(int i = 0; i<=10; i++)
		{
		if(Mphone.getText().equals(null))
		{}
		else
		{Mphone.sendKeys(Keys.BACK_SPACE);}}
		
		Mphone.sendKeys(MobilePhone);
		return new SearchCustmerSUMMARY(driver);
	}
	
	public String AmendResult() {
		return RAmend.getText();
	}
	
	public String PersonalResult() {
		return Presult.getText();
	}
	
	public SearchCustmerSUMMARY SaveButton() {
		save.click();
		return new SearchCustmerSUMMARY(driver);
	}
	public String custID( ) {
		 
		String readonly = CID.getAttribute("readonly");
		return readonly; 
		
	}
	public SearchCustmerSUMMARY NeSearch() {
		NewSearch.click();
		return new SearchCustmerSUMMARY(driver);
	}
	
	public String getErrorMessage()
    {
    	return errorMessage.getText();
    }
	
}