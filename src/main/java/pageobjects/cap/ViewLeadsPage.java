

package pageobjects.cap;

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

import utilities.ExcelUtilities;

public class ViewLeadsPage {

	WebDriver driver;
    WebDriverWait wait;
    public static String FirNme;
    public static String LastNme;
    public static String Asiigned;
    
	public ViewLeadsPage(WebDriver driver)
	{
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(this.driver, 15);
		//PageFactory.initElements( driver, this);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	
	@FindBy(linkText="Customer")
	public WebElement VLCustomer;
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/b")
	public WebElement SearchCustomer;
	
	@FindBy(linkText="View Leads")
	public WebElement ViewLead;
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/table[2]/tbody/tr[1]")
	public WebElement Veiwleadtabel;
	
	@FindBy(name="searchStatus")
	public WebElement LStatus;
	
	@FindBy(name="searchFirstName")
	public WebElement Fname;
	@FindBy(name="searchLastName")
	public WebElement Sname;
	
	@FindBy(name="searchFirstName")
	public WebElement FirstName;
	
	@FindBy(name="searchLastName")
	public WebElement LastName;
	
	@FindBy(name="searchStaffId")
	public WebElement AssignedTo;
	
	@FindBy(linkText="Search")
	public WebElement Search;
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/table/tbody/tr[2]/td[4]")
	public WebElement Result;
	
	@FindBy(xpath="/HTML/BODY/FORM/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[5]/TD[2]/TABLE/TBODY/TR[2]/TD[1]")
	public WebElement StaResult;
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/table/tbody/tr[2]/td[12]/a")
	public WebElement ConvertLead;
	
//	@FindBy(id="territoryName")
//	public WebElement terName;
	
	@FindBy(linkText="Save")
	public WebElement Save;
	
	@FindBy(linkText="Close")
	public WebElement close;
	
	@FindBy(xpath="/HTML/BODY/FORM/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[5]/TD[2]/TABLE/TBODY/TR[2]/TD[4]")
	public WebElement CustName;
	
	@FindBy(name="convertAction")
	public WebElement action;
	
	@FindBy(xpath="/HTML/BODY/FORM/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[5]/TD[2]/TABLE/TBODY/TR[2]/TD[13]")
	public WebElement RejectLead;
	
	@FindBy(xpath="/HTML/BODY/FORM/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[5]/TD[2]/TABLE/TBODY/TR[2]/TD[14]")
	public WebElement HoldLead;
	
	@FindBy(id="error")
	public WebElement Msg;
	// status 
	@FindBy(name="searchStatus")
	public WebElement status;
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/table/tbody/tr[2]/td[6]/select")
	public WebElement AssignedTos;
	
	
	
	
	
	
	public ViewLeadsPage Customer() {
		VLCustomer.click();
		return new ViewLeadsPage(driver);
	}
	public ViewLeadsPage setHeld() {
		Select s = new Select(driver.findElement(By.name("searchStatus")));
		s.selectByValue("Held");
		return new ViewLeadsPage(driver);
	}
	public String SCust() {
		return SearchCustomer.getText();
	}

	
	public ViewLeadsPage VeiwLead() {
		ViewLead.click();
		return new ViewLeadsPage(driver);
	}
	
	public String VLtabel() {
		return Veiwleadtabel.getText();
	}
	
	public String Status() {
		Select select = new Select(LStatus);
		String dropdown = select.getFirstSelectedOption().getText();
		
		return dropdown;
		
	}
	public ViewLeadsPage setStatus(String Status) {
//		Select select = new Select(LStatus);
//		select.selectByVisibleText(Status);
		LStatus.sendKeys(Status);
		
		return new ViewLeadsPage(driver);
		
	}
	// Change By Rajesh
	public ViewLeadsPage setFname() {
		Fname.sendKeys("a");
		return new ViewLeadsPage(driver);
		
	}
	// Change by Rajesh 
	public ViewLeadsPage ClrFname() throws InterruptedException {
		Fname.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		return new ViewLeadsPage(driver);
		
	}
	//Change By Rajesh 
	public ViewLeadsPage CLRSname() throws InterruptedException {
		Sname.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		return new ViewLeadsPage(driver);
		
	}
	public ViewLeadsPage setSname() {
//		Select select = new Select(LStatus);
//		select.selectByVisibleText(Status);
		Sname.sendKeys("a");
		return new ViewLeadsPage(driver);
		
	}
	public ViewLeadsPage setFirstName(String firstname) {
		FirstName.sendKeys(firstname);
		return new ViewLeadsPage(driver);
		
	}
	
	public ViewLeadsPage setLastName(String lastname) {
		LastName.sendKeys(lastname);
		return new ViewLeadsPage(driver);
		
	}
	
	public ViewLeadsPage Assigned(String assigned) {
		AssignedTo.click();
		Select staff = new Select(AssignedTo);
		staff.selectByVisibleText(assigned);
		return new ViewLeadsPage(driver);
	}
	
	public ViewLeadsPage Search() {
		Search.click();
		Select select = new Select(LStatus);
		String dropdown1 = select.getFirstSelectedOption().getText();
		if(dropdown1.equalsIgnoreCase("Held")||dropdown1.equalsIgnoreCase("New"))
		{
		String name = CustName.getText();
		String[] CusName = name.split(" ");
		for(int i=0;i<=CusName.length;i++)
		{
			String a =CusName[0];
			FirNme =CusName[1];
			LastNme =CusName[2];
			
		}
		System.out.println("FirNme"+FirNme);
		System.out.println("LastNme"+LastNme);
		Select select1 = new Select(AssignedTos);
		 Asiigned = select1.getFirstSelectedOption().getText();
		 System.out.println(">>>>>>>>>>>>>>>>>>>>>"+Asiigned);
		}
		return new ViewLeadsPage(driver);
		
	}
	public ViewLeadsPage Searchhold() {
		Search.click();
		Select select = new Select(LStatus);
		String dropdown1 = select.getFirstSelectedOption().getText();
		if(dropdown1.equalsIgnoreCase("Held")||dropdown1.equalsIgnoreCase("New"))
		{
		String name = CustName.getText();
		String[] CusName = name.split(" ");
		for(int i=0;i<=CusName.length;i++)
		{
			String a =CusName[0];
			FirNme =CusName[1];
			LastNme =CusName[2];
			
		}
		System.out.println("FirNme"+FirNme);
		System.out.println("LastNme"+LastNme);
		
		}
		return new ViewLeadsPage(driver);
		
	}
	
	
	
	public String Result() {
		return Result.getText();
	}
	
	public String StatusResult() {
		return StaResult.getText();
	}
	public ViewLeadsPage EnterDetails() {
		System.out.println("In enter detail");
		LStatus.click();
		Select f = new Select(LStatus);
		f.selectByVisibleText("");
		
	   
		FirstName.sendKeys(FirNme);
		LastName.sendKeys(LastNme);
		AssignedTo.click();
		Select a = new Select(AssignedTo);
		a.selectByVisibleText(Asiigned);
		
		
		return new ViewLeadsPage(driver);
	}
	// Change By Rajesh
	public ViewLeadsPage EnterDetails38() {
		System.out.println("In enter detail");
		LStatus.click();
		Select f = new Select(LStatus);
		f.selectByVisibleText("Converted");
		
	   
		FirstName.sendKeys(FirNme);
		LastName.sendKeys(LastNme);
		AssignedTo.click();
		Select a = new Select(AssignedTo);
		a.selectByVisibleText(Asiigned);
		
		
		return new ViewLeadsPage(driver);
	}
	
	public ViewLeadsPage EnterDetails39() {
		System.out.println("In enter detail");
		LStatus.click();
		Select f = new Select(LStatus);
		f.selectByVisibleText("Rejected");
		
	   
		FirstName.sendKeys(FirNme);
		LastName.sendKeys(LastNme);
		AssignedTo.click();
		Select a = new Select(AssignedTo);
		a.selectByVisibleText(Asiigned);
		
		
		return new ViewLeadsPage(driver);
	}
	
	public ViewLeadsPage EnterDetailsHold() {
		System.out.println("In enter detail");
		LStatus.click();
		Select f = new Select(LStatus);
		f.selectByVisibleText("Held");
	   
		FirstName.sendKeys(FirNme);
		LastName.sendKeys(LastNme);
		
		
		
		return new ViewLeadsPage(driver);
	}
	
	public ViewLeadsPage CovertLd() {
		ConvertLead.click();
		return new ViewLeadsPage(driver);
	}
	
	public ViewLeadsPage RejectLd() {
		RejectLead.click();
		return new ViewLeadsPage(driver);
	}
	public ViewLeadsPage HoldLd() {
		System.out.println("in hold");
		HoldLead.click();
		return new ViewLeadsPage(driver);
	}
	public ViewLeadsPage window() throws InterruptedException
	{
		//ConvertLead.click();
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
		     if(action.isDisplayed()==true)
		     {
		    	 System.out.println("hhhhhhhhh");
		    	 Select se = new Select(action);
		    	 action.sendKeys("Create new customer");
		     }
		    
		 	WebElement terName = driver.findElement(By.id("territoryName"));
		     terName.sendKeys("1111");
		     Save.click();
		     Thread.sleep(4000);
		     close.click();
		     Thread.sleep(1000);
//		     //driver.quit();
//		     driver.close(); //closing child window
		     driver.switchTo().window(parentWindow); //cntrl to parent window
		    }
		   
		}
		return new ViewLeadsPage(driver);
	}
	public ViewLeadsPage windowReject() throws InterruptedException
	{
		//ConvertLead.click();
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
		    
		  
		     Save.click();
		     Thread.sleep(6000);
		     close.click();
		     Thread.sleep(1000);
//		     //driver.quit();
//		     driver.close(); //closing child window
		     driver.switchTo().window(parentWindow); //cntrl to parent window
		    }
		   
		}
		return new ViewLeadsPage(driver);
	}

	public String Message() {
		return Msg.getText();
	}
	public ViewLeadsPage setStatusblank(String Status) {

//      Select select = new Select(LStatus);

//      select.selectByVisibleText(Status);

        LStatus.click();

        Select select = new Select(LStatus);

        select.selectByVisibleText("");

       

        return new ViewLeadsPage(driver);

       

 }
	
	
}