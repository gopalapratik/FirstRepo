package pageobjects.map;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import browsersetup.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class MAPAffordability extends BaseClass {
	// WebDriver driver;
	// AndroidDriver androiddriver;

	public MAPAffordability(AndroidDriver androiddriver) {
		setAndroidDriver(androiddriver);
		PageFactory.initElements(new AjaxElementLocatorFactory(getAndroidDriver(), 60), this);
	}

	@FindBy(xpath = "//a[@id='notesTab']")
	public WebElement NotesTab;
	
	@FindBy(xpath = "//span[@id='show-new-arrreas-note-button']")
	public WebElement newArreasContact;
	
	//@FindBy(xpath = "//div[@label = 'Wages']//input[@name='entry-value']")
	@FindBy(xpath = "//div[@label = 'Wages']//input[@name='Wages0']")
	public WebElement Wages;

	//@FindBy(xpath = "//div[@label = 'Wages']//div[@class='checkbox-container']")
	@FindBy(xpath = "//div[@label = 'Wages']//div[@class='checkbox-container']/i")
	public WebElement WagesEvidence;

	@FindBy(xpath = "//div[@label = 'Wages']//select[@ng-model = 'entry.evidence.evidenceId']")
	public WebElement WagesDocument;

	@FindBy(xpath = "//div[@label = 'Wages']//input[@ng-model = 'entry.evidence.reference']")
	public WebElement WagesReference;

	@FindBy(xpath = "//div[@label = 'Rent']//div[@class='checkbox-container']/i")
	public List<WebElement> Rent_Check;

	//@FindBy(xpath = "//div[@label = 'Rent']//input[@name='entry-value']")
	@FindBy(xpath = "//div[@label = 'Rent']//input[@name='Rent0']")
	public WebElement RentAmmount;

	@FindBy(xpath = "//div[@label = 'Rent']//div[@class='checkbox-container'][2]")
	public WebElement RentEvidence;

	@FindBy(xpath = "//div[@label = 'Rent']//select[@ng-model = 'entry.evidence.evidenceId']")
	public WebElement RentDocument;

	@FindBy(xpath = "//div[@label = 'Rent']//input[@ng-model = 'entry.evidence.reference']")
	public WebElement RentReference;

	// @FindBy(xpath = "//slider[@ng-model =
	// 'customer.affordability.affordability']")
	@FindBy(xpath = "//slider[@ng-model = 'customer.affordability.affordability']//div[@class='handle low']")
	public WebElement AffSlider;
	
	@FindBy(xpath = "//textarea[contains(@ng-model,'problem')]")
	public WebElement problem;
	
	@FindBy(xpath = "//textarea[contains(@ng-model,'solution')]")
	public WebElement solution;
	
	@FindBy(xpath = "//textarea[contains(@ng-model,'arrangement')]")
	public WebElement arrangement;
	
	@FindBy(xpath = "//button[@id='confirm-new-arreas-note-afford-button']")
	public WebElement confirmNewArreas;

	public MAPAffordability clickNotesTab() {
		NotesTab.click();
		return new MAPAffordability(getAndroidDriver());
	}

	public MAPAffordability clicknewArreasContact() {
		newArreasContact.click();
		return new MAPAffordability(getAndroidDriver());
	}

	public MAPAffordability enterWages(String doc) {
		Wages.clear();
		Wages.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPAffordability(getAndroidDriver());
	}

	public MAPAffordability enterWagesEvidence() {
		WagesEvidence.getAttribute("class");
		/*if (!(WagesEvidence.isSelected())) {
			WagesEvidence.click();
		}*/
		if (WagesEvidence.getAttribute("class").contains("blank")) {
			WagesEvidence.click();
		}
		return new MAPAffordability(getAndroidDriver());
	}

	public MAPAffordability selectWagesDocument(String doc) {
		Select s1 = new Select(WagesDocument);
		s1.selectByVisibleText(doc);

		return new MAPAffordability(getAndroidDriver());
	}

	public MAPAffordability enterWagesReference(String doc) {
		WagesReference.clear();
		WagesReference.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPAffordability(getAndroidDriver());
	}

	public MAPAffordability clickRentPaid() {
		for (int i = 1; i <= Rent_Check.size(); i++) {
			
			/*if (!Rent_Check.get(0).isSelected()) {
				Rent_Check.get(0).click();
				return new MAPAffordability(getAndroidDriver());
			}*/
			Rent_Check.get(0).getAttribute("class");
			if(Rent_Check.get(0).getAttribute("class").contains("blank"))
			{
				Rent_Check.get(0).click();
			}
		}

		return new MAPAffordability(getAndroidDriver());
	}

	public MAPAffordability enterRentAmmount(String ammount) {
		RentAmmount.clear();
		RentAmmount.sendKeys(ammount);
		getAndroidDriver().hideKeyboard();
		return new MAPAffordability(getAndroidDriver());
	}

	public MAPAffordability enterRentEvidence() {
		for (int i = 1; i <= Rent_Check.size(); i++) {
			/*if (!Rent_Check.get(1).isSelected()) {
				Rent_Check.get(1).click();
				return new MAPAffordability(getAndroidDriver());
			}*/
			Rent_Check.get(1).getAttribute("class");
			if(Rent_Check.get(1).getAttribute("class").contains("blank"))
			{
				Rent_Check.get(1).click();
			}
		}
		return new MAPAffordability(getAndroidDriver());
	}

	public MAPAffordability selectRentDocument(String doc) {
		Select s1 = new Select(RentDocument);
		s1.selectByVisibleText(doc);

		return new MAPAffordability(getAndroidDriver());
	}

	public MAPAffordability enterRentReference(String doc) {
		RentReference.clear();
		RentReference.sendKeys(doc);
		getAndroidDriver().hideKeyboard();
		return new MAPAffordability(getAndroidDriver());
	}

	public MAPAffordability slider(int xoffset, int yoffset) {
		Actions builder = new Actions(getAndroidDriver());
		builder.moveToElement(AffSlider).click().dragAndDropBy(AffSlider, AffSlider.getLocation().getY() + 50, 0)
				.build().perform();

		return new MAPAffordability(getAndroidDriver());
	}

	public MAPAffordability enterProblem(String doc) {
		//problem.clear();
		problem.click();
		problem.sendKeys(doc);
		try{
		getAndroidDriver().hideKeyboard();
		}catch (Exception e) {
			System.out.println("Keyboard Invisible");
		}
		return new MAPAffordability(getAndroidDriver());
	}
	
	public MAPAffordability enterSolution(String doc) {
		//solution.clear();
		solution.click();
		solution.sendKeys(doc);
		try{
			getAndroidDriver().hideKeyboard();
			}catch (Exception e) {
				System.out.println("Keyboard Invisible");
			}
		return new MAPAffordability(getAndroidDriver());
	}
	
	public MAPAffordability enterArrangement(String doc) {
		//arrangement.clear();
		arrangement.click();
		arrangement.sendKeys(doc);
		try{
			getAndroidDriver().hideKeyboard();
			}catch (Exception e) {
				System.out.println("Keyboard Invisible");
			}
		return new MAPAffordability(getAndroidDriver());
	}
	
	public MAPAffordability clickConfirmNewArreas() {
		confirmNewArreas.click();
		return new MAPAffordability(getAndroidDriver());
	}
}

