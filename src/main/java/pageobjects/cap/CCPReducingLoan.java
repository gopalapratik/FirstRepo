
package pageobjects.cap;

//import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.expression.spel.ast.BooleanLiteral;
import org.openqa.selenium.Alert;

import helpers.CommonFunctions;
import utilities.ExcelUtilities;

public class CCPReducingLoan {
	WebDriverWait wait;
	WebDriver driver;
	
	//public static String ScehemeName="AutoTest"+CommonFunctions.InsertTime();
	public static String StatusInExceptnScreen;
	public static String CustomerID;
	public CCPReducingLoan(WebDriver driver)
	{
		this.driver=driver;
		this.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		 wait = new WebDriverWait(this.driver, 30);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
	}
	@FindBy(linkText="Assign Staff Temporary Role")
	public WebElement TempRole;
}