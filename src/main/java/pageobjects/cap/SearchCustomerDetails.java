package pageobjects.cap;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtilities;

public class SearchCustomerDetails {

	WebDriver driver;
    WebDriverWait wait;

	public SearchCustomerDetails(WebDriver driver)
	{
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(this.driver, 15);
		//PageFactory.initElements( driver, this);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

	@FindBy(linkText="Customer Details")
	public WebElement CustDetails;
	// /HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[2]/TD[2]/TABLE/TBODY/TR/TD[6]/A
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[2]/TD[1]")
	public WebElement CustLink;
	@FindBy(xpath="//td[contains(text(),'N.I Number')]")
	public WebElement AggNINO;
	@FindBy(xpath="//td[contains(text(),'Email')]")
	public WebElement AggEmail;
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[1]/TD[3]/TABLE[1]/TBODY/TR[4]/TD[2]")
	public WebElement AggEmailData;
	@FindBy(xpath="//td[contains(text(),'Home Visit Form')]")
	public WebElement AggHomeVisit;
	@FindBy(xpath="//td[contains(text(),'Proof of Address')]")
	public WebElement AggProofAddress;
	@FindBy(xpath="//td[contains(text(),'Business Stream')]")
	public WebElement AggBusinessStream;
	@FindBy(xpath="//td[contains(text(),'Collection Frequency')]")
	public WebElement AggCollFrequency;
	@FindBy(xpath="//td[contains(text(),'Collected On')]")
	public WebElement AggCollectedON;
	@FindBy(name="customerBean.customerMktPrefBean.documentByEmail")
	public WebElement MarkEmailApptedOn;
	@FindBy(linkText="Amend")
	public WebElement Amend;
	@FindBy(name="customerBean.email")
	public WebElement AmendAggEmail;
	@FindBy(name="customerBean.customerMktPrefBean.sms_comm")
	public WebElement MCheckSMStext;
	@FindBy(name="customerBean.customerMktPrefBean.email_comm")
	public WebElement MCheckemail;
	@FindBy(name="customerBean.customerMktPrefBean.phone_comm")
	public WebElement MCheckTelephone;
	@FindBy(name="customerBean.customerMktPrefBean.letter_comm")
	public WebElement MCheckLetter;
	@FindBy(name="customerBean.customerMktPrefBean.mkt_research")
	public WebElement MCheckMarReasearch;
	@FindBy(linkText="Save")
	public WebElement Save;
	@FindBy(id="error")
	public WebElement MResult;
	
	
	
	
	////////Implementation///////////////////////////////////
	
	public SearchCustomerDetails CustDetail()
	{
		CustDetails.click();
		return new SearchCustomerDetails(driver);
	}
	public SearchCustomerDetails CustomerLink()
	{
		CustLink.click();
		return new SearchCustomerDetails(driver);
	}
	public String AGGNINO()
	{
		return AggNINO.getText();
	}
	public String AGGEmail()
	{
		return AggEmail.getText();
	}
	public String AGGHomeVisit()
	{
		return AggHomeVisit.getText();
	}
	public String AGGPD()
	{
		return AggProofAddress.getText();
	}
	public String AGGBusStream()
	{
		return AggBusinessStream.getText();
	}
	public String AGGcollfreq()
	{
		return AggCollFrequency.getText();
	}
	public String AGGcollectedon()
	{
		return AggCollectedON.getText();
	}
	public String AGGEmailData()
	{
		return AggEmailData.getText();
	}
	public Boolean MEmailAppted()
	{
		return MarkEmailApptedOn.isSelected();
	}
	public SearchCustomerDetails MarCheckSMStext()
	{
		if(!MCheckSMStext.isSelected())
		{
		MCheckSMStext.click();
		}
		return new SearchCustomerDetails(driver);
	}
	public boolean AmendCheckSMStext()
	{
		return MCheckSMStext.isSelected();
	}
	
	public SearchCustomerDetails MarCheckemail()
	{
		MCheckemail.click();
		return new SearchCustomerDetails(driver);
	}
	public SearchCustomerDetails MarCheckTelephone()
	{
		MCheckTelephone.click();
		return new SearchCustomerDetails(driver);
	}
	public SearchCustomerDetails MarCheckLetter()
	{
		MCheckLetter.click();
		return new SearchCustomerDetails(driver);
	}
	public SearchCustomerDetails MarCheckMarReasearch()
	{
		MCheckMarReasearch.click();
		return new SearchCustomerDetails(driver);
	}
	public SearchCustomerDetails AmendButton()
	{
		Amend.click();
		return new SearchCustomerDetails(driver);
	}
	public SearchCustomerDetails SaveButton()
	{
		Save.click();
		return new SearchCustomerDetails(driver);
	}
	public String ResultMesage()
	{
		return MResult.getText();
	}
	//AmendAggEmail
	public SearchCustomerDetails setAGGEmail(String email)
	{
		//AmendAggEmail.clear();
		for(int i = 0; i<=15; i++)
		{
		if(AmendAggEmail.getText().equals(null))
		{}
		else
		{AmendAggEmail.sendKeys(Keys.BACK_SPACE);}}
		AmendAggEmail.sendKeys(email);
		return new SearchCustomerDetails(driver);
	}
	
	
	
}