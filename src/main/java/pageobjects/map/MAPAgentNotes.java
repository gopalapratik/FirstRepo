
package pageobjects.map;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import browsersetup.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import utilities.ExcelUtilities;

public class MAPAgentNotes extends BaseClass {
	// WebDriver driver;
	// AndroidDriver androiddriver;

	public MAPAgentNotes(AndroidDriver androiddriver) {
		setAndroidDriver(androiddriver);
		PageFactory.initElements(new AjaxElementLocatorFactory(getAndroidDriver(), 60), this);
	}

	@FindBy(xpath = "//ion-item[@id='main.agentNotes']")
	public WebElement AgentNotes;
	
	@FindBy(xpath = "//a[@id='newActionPlanNoteButton']")
	public WebElement CreateNote;
	
	@FindBy(xpath = "//select[contains(@name,'staffId')]")
	public WebElement Agent;
	
	@FindBy(xpath = "//div/textarea[contains(@class,'titleInput greyTxt ng-pristine ng-untouched ng-valid ng-valid-maxlength')]")
	public WebElement Title;
	
	
	@FindBy(xpath = "//div/textarea[contains(@class,'contentInput greyTxt ng-pristine ng-untouched ng-valid ng-valid-maxlength')]")
	public WebElement ActionPlan;
	
	
	@FindBy(xpath = "//div/textarea[contains(@class,'contentInput greyTxt ng-valid ng-valid-maxlength ng-dirty ng-valid-parse ng-touched')]")
	public WebElement ActionPlan1;
	
	@FindBy(xpath = "//button[contains(@class,'button button-light modal-confirm-button border-left')]")
	public WebElement Confirm;
	
	
	
	@FindBy(xpath = "//li[@id='viewActionPlanNoteButton']")
	public WebElement ActionPlanButton;
	
	@FindBy(xpath = "//div[contains(@class,'row textHeight greyTxt')]")
	public WebElement ViewNoteText;

	@FindBy(xpath = "//li[@id='editActionPandNoteButton']")
	public WebElement EditActionPlanButton;
	
	@FindBy(xpath = "//div[@id='APBody2']")
	public WebElement EditActionPlanNote;
	
	@FindBy(xpath="//*[@id='actionPlanNote']/ion-content/div[1]/div/div[3]/button[2]")
	//@FindBy(xpath = "//div/button[@class='button button-light modal-confirm-button border-left']")
	public WebElement Update;
	
	@FindBy(xpath = "//li[@id='closeActionPlanNoteButton']")
	public WebElement Close; 
	
	@FindBy(xpath="//div/button[contains(text(),'COMPLETE')]")
	//@FindBy(xpath = "//div/button[@class='button button-light modal-confirm-button']")
	public WebElement Complete;
	
	@FindBy(xpath = "//*[@id='agentNotes']/div[1]/div/div/div[4]")
	public WebElement ResultStatus;
	
	@FindBy(xpath="//div[contains(@class,'col-15 leads-item-button')]")
	public WebElement HamBurger;
	
	@FindBy(xpath="//div/button[contains(@class,'button modal-confirm-button')]")
	public WebElement closeAlert;

	public MAPAgentNotes clickTerritory(String ter) {
		System.out.println("in terrr");
		getAndroidDriver().findElement(By.xpath("//div[contains(text(),'"+ter+"')]")).click();
		//getAndroidDriver().findElement(By.xpath("//div[contains(text(),'5705')]")).click();
		return new MAPAgentNotes(getAndroidDriver());
	}
	
	public MAPAgentNotes clickAgentNotes() {
		AgentNotes.click();
		return new MAPAgentNotes(getAndroidDriver());
	}
	
	public MAPAgentNotes clickCreateNoteButton() {
		CreateNote.click();
		return new MAPAgentNotes(getAndroidDriver());
	}
	
	public MAPAgentNotes clickAgent(String val) {
		//Agent.click();
		
		Select se= new Select(Agent);
		se.selectByValue(val);
		System.out.println("in agenttttttttttt");
		
		return new MAPAgentNotes(getAndroidDriver());
	}
	
	public MAPAgentNotes enterTitle(String doc) {
		Title.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPAgentNotes(getAndroidDriver());
	}
	
	public MAPAgentNotes enterActionPlan(String doc) {
		ActionPlan.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPAgentNotes(getAndroidDriver());
	}
	
	public MAPAgentNotes clickConfirm() {
		Confirm.click();
		return new MAPAgentNotes(getAndroidDriver());
	}
	
	public String ResultCreateNote() {
		String AgentName = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "242", 4);
		List<WebElement> childs1=getAndroidDriver().findElements(By.xpath("//div[@class='pure-u-1-3 cel notes-name ng-binding' and contains(text(), '"+AgentName+"')]//following-sibling::div[2]"));
		String result=null;
		DateFormat dateformat= new SimpleDateFormat("dd.MM.YYYY");
		Date date = new Date();
		
		// = parent1.findElements(By.xpath(".//*"));
		for (WebElement option : childs1) { 
            if(option.getText().equals(dateformat.format(date)))
            	 result ="true";
            	System.out.println(result);
              break; 
             
          } 
		//String Date=getAndroidDriver().findElement(By.xpath("//div[@class='pure-u-1-3 cel notes-name ng-binding' and contains(text(), 'Barry Brady')]//following-sibling::div[2]")).getText();
		return result;
	}
	
	public MAPAgentNotes scroll() throws InterruptedException
	{
		//WebElement element = driver.findElement(By.id("id_of_element"));
		((JavascriptExecutor) getAndroidDriver()).executeScript("arguments[0].scrollIntoView(true);", Confirm);
		Thread.sleep(500);
		return new MAPAgentNotes(getAndroidDriver());
	}
	//div[contains(@class,'actionPlanStatus')]/span[contains(text(),'01.03.2018')]
	public MAPAgentNotes NotesClick(String text)
	{
		WebElement note= getAndroidDriver().findElement(By.xpath("//div[contains(@class,'actionPlanStatus')]/span[contains(text(),'"+text+"')]"));
		note.click();
				//div[contains(@class,'actionPlanStatus')]/span[contains(text(),'01.03.2018')]
		return new MAPAgentNotes(getAndroidDriver());
	}
	public MAPAgentNotes ActionPlanButtonClick()
	{
		ActionPlanButton.click();
		return new MAPAgentNotes(getAndroidDriver());
	}
	public MAPAgentNotes EditActionPlanButtonClick()
	{
		EditActionPlanButton.click();
		return new MAPAgentNotes(getAndroidDriver());
	}
	public String ResultViewNote()
	{
		String text =ViewNoteText.getText();
		return text;

	}
	public MAPAgentNotes editnote(String editnote) throws InterruptedException
	{
		ActionPlan.clear();
		Thread.sleep(2000);
		getAndroidDriver().hideKeyboard();
		Title.click();
		
		ActionPlan1.sendKeys(editnote);
		getAndroidDriver().hideKeyboard();
		return new MAPAgentNotes(getAndroidDriver());
	}
	public MAPAgentNotes UpdateButton() throws InterruptedException
	{
		((JavascriptExecutor) getAndroidDriver()).executeScript("arguments[0].scrollIntoView(true);", Update);
		Thread.sleep(500);
		Update.click();
		return new MAPAgentNotes(getAndroidDriver());
	}
	public MAPAgentNotes CloseButtonclick()
	{
		Close.click();
		return new MAPAgentNotes(getAndroidDriver());
	}
	public MAPAgentNotes CompleteButtonclick()
	{
		
		System.out.println("is displayed >>>>>>>>>>"+Complete.isDisplayed());
		Complete.click();
		return new MAPAgentNotes(getAndroidDriver());
	}
	public String ResultStatusText()
	{
		String result = ResultStatus.getText();
		return result;
	}
	

	public MAPAgentNotes Hamburgerclick()
	{
		HamBurger.click();
		return new MAPAgentNotes(getAndroidDriver());
	}
	public MAPAgentNotes closeAlertclick()
	{
		closeAlert.click();
		return new MAPAgentNotes(getAndroidDriver());
	}
}

