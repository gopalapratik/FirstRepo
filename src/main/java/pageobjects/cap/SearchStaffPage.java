package pageobjects.cap;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testscripts.cap.CAPSearchStaffScripts;
//import testscripts.cap.Amend;
import utilities.ExcelUtilities;

public class SearchStaffPage {

	WebDriver driver;
    WebDriverWait wait;
    public  String add;
	public SearchStaffPage(WebDriver driver)
	{
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
        wait = new WebDriverWait(this.driver, 200);
		//PageFactory.initElements( driver, this);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 200), this);
	}
	
	
	@FindBy(linkText="Staff")
	public WebElement Staff;
	
	
	@FindBy(linkText="Search Staff")
	public WebElement SearchStaff;
	
	@FindBy(xpath="/html/body/table/tbody/tr[2]/td/form/table/tbody/tr[3]/td[2]/table/tbody/tr[1]/td[1]")
	public WebElement StaffID;
//	public  String d = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "42", 1);
//	public final String g = "//*[contains(text(), "+"'"+ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "SearchStaff", "42", 1)+"')]";
//	//public static final String newStr=d+g;
//	@FindBy(xpath=g)
//	public WebElement StaffID1;
	
	@FindBy(id="staffBean.staffId")
	public WebElement SearStaffID;
	
	
	@FindBy(id="staffBean.firstName")
	public WebElement FirstName;
	
	@FindBy(id="staffBean.lastName")
	public WebElement LastName;
	
	@FindBy(xpath="/HTML/BODY/TABLE/TBODY/TR[2]/TD/FORM[1]/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[2]/TD[1]/A")
	public WebElement StaffIDLink; 
	
	@FindBy(id="staffBean.status")
	public WebElement Status;
	
	@FindBy(linkText="Search")
	public WebElement Search;
	
	@FindBy(xpath="/html/body/table/tbody/tr[2]/td/form[1]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table/tbody/tr[2]/td[3]")
	public WebElement Result;
	
	@FindBy(id="error")
	public WebElement Error;
	
	@FindBy(xpath="/html/body/form[1]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/table/tbody/tr/td[6]/a")
	public WebElement SearchStaffCommScheme;
	
	@FindBy(xpath="//TABLE[@id='tblHeader']/TBODY/TR/TD[2]/A")
	public WebElement SchemeName;
	
	@FindBy(linkText="Amend Staff")
	public WebElement Amend;
	
	@FindBy(name="startDate")
	public WebElement SDate;
	
	@FindBy(linkText="Save Staff")
	public WebElement Save;
	
	@FindBy(linkText="Business Unit")
	public WebElement BU;
	
	@FindBy(xpath="//td[contains(text(),'4900')]//preceding-sibling::td/input[@type='checkbox']")
	public WebElement checkbox;
	
	@FindBy(name="selectedItemId")
	public WebElement checkboxCreatestaff;
	
	@FindBy(linkText="Amend Unit")
	public WebElement AU;
	
	@FindBy(xpath="//td[contains(text(),'4900')]//following-sibling::td[5]")
	public WebElement BUDate;
	
	@FindBy(linkText="Add Unit")
	public WebElement AddU;
	
	@FindBy(xpath="//input[contains(@name, 'selectedItemId') and contains(@value, '908')]")
	public WebElement checkboxadd;
	
	@FindBy(xpath="//DIV[@id='tbl-container']/TABLE/TBODY/TR[2]/TD[2]")
	public WebElement ResultAdd;
	
	@FindBy(css="#tbl-container > table")
	public WebElement ResultTable;
	
	@FindBy(linkText="Delete Unit")
	public WebElement DeleteUnit;
	
	@FindBy(linkText="Cash Reconciliation")
	public WebElement CashRecon;
	
	@FindBy(linkText="Amend")
	public WebElement AmendCashRecon;
	///HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[4]/TD[2]/TABLE/TBODY/TR[3]/TD/TABLE/TBODY/TR[8]/TD[2]
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[4]/TD[2]/TABLE/TBODY/TR[3]/TD/TABLE/TBODY/TR[8]/TD[2]")
	public WebElement CashReconLoan;
	
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[4]/TD[2]/TABLE/TBODY/TR[3]/TD/TABLE/TBODY/TR[5]/TD[2]")
	public WebElement CashReconCollection;
	
	@FindBy(linkText="Confirm")
	public WebElement ConfirmCashRecon;
	
	@FindBy(id="period")
	public WebElement SelectPeriod;
	
	@FindBy(name="reconciliation")
	public WebElement SelectPeriodRange;
	
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[4]/TD[2]/TABLE/TBODY/TR[3]/TD/TABLE/TBODY/TR[3]/TD[2]")
	public WebElement OpeningFCash;
	
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[4]/TD[2]/TABLE/TBODY/TR[3]/TD/TABLE/TBODY/TR[16]/TD[2]")
	public WebElement ClosingFCash;
	
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[4]/TD[2]/TABLE/TBODY/TR[3]/TD/TABLE/TBODY/TR[4]/TD[2]")
	public WebElement OpeningFCheque;
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[4]/TD[2]/TABLE/TBODY/TR[3]/TD/TABLE/TBODY/TR[11]/TD[2]")
	public WebElement FCheque;
	
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[4]/TD[2]/TABLE/TBODY/TR[3]/TD/TABLE/TBODY/TR[17]/TD[2]")
	public WebElement ClosingFCheque;
	
	@FindBy(xpath="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR/TD[3]/TABLE[2]/TBODY/TR[8]/TD[3]")
	public WebElement FloatLimit;
	
	@FindBy(xpath="//TD[@id='amountToBankID']")
	public WebElement AmountToBankCash;
	
	
	
	
	
	
	

	
	
	
	public SearchStaffPage Staff() {
		Staff.click();
		return new SearchStaffPage(driver);
	}
	public SearchStaffPage StaffLink() {
		StaffIDLink.click();
		return new SearchStaffPage(driver);
	}
	
	public String staffID() {
		return StaffID.getText();
		
	}
	public SearchStaffPage Staffid(String staffid)
	{
		SearStaffID.sendKeys(staffid);
		return new SearchStaffPage(driver);
	}
	public SearchStaffPage FirstName(String firstname)
	{
		FirstName.sendKeys(firstname);
		return new SearchStaffPage(driver);
	}
	
	public SearchStaffPage LastName(String lastname)
	{
		LastName.sendKeys(lastname);
		return new SearchStaffPage(driver);
	}
	public SearchStaffPage SearchStaff() {
		SearchStaff.click();
		return new SearchStaffPage(driver);
	}
	public SearchStaffPage Status(String staffStatus)
	{
		Select status = new Select(Status);
		status.selectByVisibleText(staffStatus);
		return new SearchStaffPage(driver);
	}
	
	public SearchStaffPage Search() {
		Search.click();
		return new SearchStaffPage(driver);
	}
	
	
	
	public String Result() {
		String res= null;
		if(Error.isDisplayed()==false)
		{
			res = Result.getText();
		}
		else
		{
			res =	Error.getText();
		}
		return res;
	}
	
	public String ResultRecon() {
		WebElement f = driver.findElement(By.id("error"));
		//System.out.println(f.getText());
		return f.getText();
	}
	
	public SearchStaffPage CommiScheme() {
		SearchStaffCommScheme.click();
		return new SearchStaffPage(driver);
	}
	public String SchemeNam() {
		SchemeName.getText();
		String s = null;
		if(SchemeName.getText()!=null)
		{
			s = "true";
		}
		return s;
	}
	
	
	
	
	public SearchStaffPage AmendstaffButton() {
		Amend.click();
		return new SearchStaffPage(driver);
	}
	public SearchStaffPage Amendstaff() {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String dateformat = dateFormat.format(date);
		//System.out.println(dateFormat.format(date));
		for(int i=0;i<=10;i++)
		{
		SDate.sendKeys(Keys.BACK_SPACE);
		}
		SDate.sendKeys(dateformat);
		//Date.sendKeys(dateformat);
		return new SearchStaffPage(driver);
	}
	public SearchStaffPage SavestaffButton() {
		Save.click();
		return new SearchStaffPage(driver);
	}
	public SearchStaffPage BussUnit() {
		BU.click();
		return new SearchStaffPage(driver);
	}
	public SearchStaffPage Check() {
		checkbox.click();
		return new SearchStaffPage(driver);
	}
	public SearchStaffPage AmendUNIT() {
		AU.click();
		return new SearchStaffPage(driver);
	}
	
	 public SearchStaffPage Addwindow() throws InterruptedException
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
			  /*   System.out.println(driver.getTitle());
			    String datetext = driver.findElement(By.name("assignToDateStr")).getText();
			    System.out.println(datetext);
			    String[] datetextsplit = datetext.split("/");
			    String day = null;
			    for(int i=0;i<=datetextsplit.length;i++)
			    {
			    	day= datetextsplit[0];
			    	System.out.println(day);
			    	
			    	
			    }
			    int o = Integer.valueOf(day)+1;
			    System.out.println(o);
			    add = String.valueOf(o)+"/12/2019";*/
			     for(int j = 0;j<=10;j++)
			     {
			    	 driver.findElement(By.name("assignToDateStr")).sendKeys(Keys.BACK_SPACE);
			     }
			    driver.findElement(By.name("assignToDateStr")).sendKeys("02/12/2019");
			    driver.findElement(By.linkText("Save")).click();
//			     //driver.quit();
//			     driver.close(); //closing child window
			    System.out.println("OUT CHILLD");
			     driver.switchTo().window(parentWindow); //cntrl to parent window
			    }
			   
			}
			return new SearchStaffPage(driver);
		}
	 public String BUDate1()
	 {
		 return BUDate.getText();
	 }
	 	public SearchStaffPage AddUNIT() {
		 	AddU.click();
			return new SearchStaffPage(driver);
		}
	 	
	 	public SearchStaffPage AddwindowUnit() throws InterruptedException
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
			  
			    checkboxadd.click();
			    driver.findElement(By.linkText("Select")).click();
//			     //driver.quit();
//			     driver.close(); //closing child window
			    System.out.println("OUT CHILLD");
			     driver.switchTo().window(parentWindow); //cntrl to parent window
			    }
			   
			}
			return new SearchStaffPage(driver);
		}
	 	public SearchStaffPage AddUnitDeletewindow() throws InterruptedException
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
			  
			    checkboxadd.click();
			    for(int j = 0;j<=10;j++)
			     {
			    	 driver.findElement(By.name("assignFromDateStr")).sendKeys(Keys.BACK_SPACE);
			     }
			    DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			    Date date = new Date();
			    String d = dateFormat.format(date);
			    String[] d1 = d.split("/");
			    String g = null;
			    String g1 = null;
			    String g2 = null;
			    for(int k = 0;k<=d1.length;k++)
			    {
			    	g = d1[0];
			    	g1 = d1[1];
			    	g2 = d1[2];
			    	
			    }
			    int w = Integer.parseInt(g)+1;
			    String e = w+"/"+g1+"/"+g2;
			    System.out.println(e);
			    System.out.println(dateFormat.format(date));
			    driver.findElement(By.name("assignFromDateStr")).sendKeys(e);
			    driver.findElement(By.linkText("Select")).click();
//			     //driver.quit();
//			     driver.close(); //closing child window
			    System.out.println("OUT CHILLD");
			     driver.switchTo().window(parentWindow); //cntrl to parent window
			    }
			   
			}
			return new SearchStaffPage(driver);
		}
	 	 public String ResultAddUNIT()
		 {
	 		String s = ResultTable.getText();
	 		Boolean b= s.contains(ResultAdd.getText());
	 		String f = String.valueOf(b);
			 return f;
		 }
	 	public SearchStaffPage Delete() {
	 		DeleteUnit.click();
			return new SearchStaffPage(driver);
		}
	 	public SearchStaffPage checkboxClick() {
	 		checkboxCreatestaff.click();
			return new SearchStaffPage(driver);
		}
		public SearchStaffPage CashReconClick() {
			CashRecon.click();
			return new SearchStaffPage(driver);
		}
		public String CashReconLoanClick() {
			String e =CashReconLoan.getText();
			System.out.println(e);
			String result=null;
			double val = Double.valueOf(e);
			System.out.println(val);
			if(val>0.00)
			{
				result="True";
				System.out.println(result);
			}
			return result;
		}
		public String CashReconcollectionClick() {
			String e =CashReconCollection.getText();
			System.out.println(e);
			String result=null;
			double val = Double.valueOf(e);
			System.out.println(val);
			if(val>0.00)
			{
				result="True";
				System.out.println(result);
			}
			return result;
		}
		public SearchStaffPage AmendCashReconClick() {
			AmendCashRecon.click();
			return new SearchStaffPage(driver);
		}
		public SearchStaffPage CashReconLoanWindow() throws InterruptedException {
			//CashReconLoan.click();
			Thread.sleep(4000);
			String Loanvalue =null;
			String parentWindow = driver.getWindowHandle();
			Set<String> handles =  driver.getWindowHandles();
			 System.out.println("OUT CHILLD");
			for(String windowHandle  : handles)
			{
			    if(!windowHandle.equals(parentWindow))
			   {
			    	System.out.println(driver.getTitle());
			    	System.out.println("OUT CHILLD");
			    	Loanvalue=driver.findElement(By.xpath("//*[contains(text(),'BRIAN BAGWELL')]")).getText();
		
//			     //driver.quit();
			     driver.close(); //closing child window
			 
			     driver.switchTo().window(parentWindow); //cntrl to parent window
			    }
			   
			}
			return new SearchStaffPage(driver);
		}
		public SearchStaffPage ConfirmCashReconClick() throws InterruptedException {
			ConfirmCashRecon.click();
			Thread.sleep(2000);
			Alert alert =driver.switchTo().alert();
			alert.accept();
			return new SearchStaffPage(driver);
		}
		
		public SearchStaffPage setSelectPeriodClick(String str) throws InterruptedException {
			
			SelectPeriod.sendKeys(str);
			return new SearchStaffPage(driver);
		}
		public SearchStaffPage SelectPeriodRangeClick() throws InterruptedException {
			SelectPeriodRange.click();
			SelectPeriodRange.sendKeys(Keys.ARROW_DOWN);
			SelectPeriodRange.sendKeys(Keys.ENTER);
			return new SearchStaffPage(driver);
		}
		public String FloatCash() {
			//String opening =OpeningFCash.getText();
			//String Closing =ClosingFCash.getText();
			String result=null;
			if(OpeningFCash.isDisplayed())
			{
				result="True";
				System.out.println(result);
			}
			return result;
		}
		public String FloatCheque() {
			
			String opening =OpeningFCheque.getText();
			String Closing =ClosingFCheque.getText();
			String result=null;
			if(FCheque.isDisplayed())
			{
				result="True";
				System.out.println(result);
			}
			return result;
		}
		String FloatLimitS;
		public String FloatLimitValue()
		{
			FloatLimitS=FloatLimit.getText();
			return FloatLimitS;
		}
		public String resultfloat()
		{
			System.out.println(FloatLimitS);
			double Fval = Double.valueOf(FloatLimitValue());
			double OpeningFloat =Double.valueOf(OpeningFCash.getText());
			System.out.println("Fval>>>>>"+Fval);
			System.out.println("OpeningFloat>>>>"+OpeningFloat);
			String result=null;
			if(Fval>=OpeningFloat)
			{
				result="True";
				System.out.println(result);
				
			}
			
			
			return result;
			
			
		}
		
		public String CheckResult(String header)
		{
			String value=null;
			for(int i=3;i<=19;i++)
			{
				String xpath1="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[4]/TD[2]/TABLE/TBODY/TR[3]/TD/TABLE/TBODY/TR["+i+"]/TD[1]";
				String xpath2="/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[4]/TD[2]/TABLE/TBODY/TR[3]/TD/TABLE/TBODY/TR["+i+"]/TD[2]";
				if(driver.findElement(By.xpath(xpath1)).getText().equalsIgnoreCase(header))
				{
					value=driver.findElement(By.xpath(xpath2)).getText();
				}
			}
			return value;
		}
		
		
}
