package restAssured;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumConceptsPractice {

	// 1. Hover - Actions
	//@Test
	public void hoverAction() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("header-addons"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"header-addons\"]/ul/li[2]/a")).click();

	}

	// 2. DragandDrop - Actions and Frames

	 //@Test

	public void dragAndDrop() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(0);

		// Frames can have index or/and Name. To find out whether a frame is present
		// or not right click on top of the element you want to click and see if Frame
		// is present
		// NOSuchElement Exception is observed when an element is present inside the
		// frame

		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.clickAndHold(drag).moveToElement(drop).release().build().perform();

		String dropped = driver.findElement(By.xpath("//div[@id ='droppable']//p")).getText();
		System.out.println(dropped);

	}

	// 3. Locators in Selenium and DropDown Selection Using Select Class

	@Test

	public void differentLocators() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.cssSelector("li[id='header-addons']n")).click();

		
		
		
		
		// 1 . id, name, tagname and ClassName
		// 2. xpath and CSSSelector
		// 3. LinkText and Partial LinkText(Not Much Used) - Especially for Links

		// If id is there --> #<id>
		// If class is there ---> .<class>
//		driver.findElement(By.cssSelector("#header-addons")).click(); // CSS Selector Example
//		Select select = new Select(driver.findElement(By.id("")));
//		select.selectByVisibleText("");
//		select.selectByValue("1");
//		select.selectByIndex(0);
	}

	// 4 PopUp - Alert API to handle JavaScript Alert Pop ups

	// @Test
	public void javaScriptpopUps() {

		// Javascript pop up
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");

		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.dismiss();// To cancel the popup
		alert.accept();// To click on OK button
		driver.close();
	}

	// 5. PopUp - Window PopUp - Use Sendkeys to send the path of the file

	// @Test
	public void windowPopUps() {
		// Windows pop up

		WebDriverManager.chromedriver().setup();
		WebDriver driver2 = new ChromeDriver();
		driver2.get("https://html.com/input-type-file/");
		driver2.findElement(By.id("fileupload")).sendKeys(
				"C:\\Users\\pratik13961\\Desktop\\" + "Steps to Upload Photo in Office 365 and Blood Group.pdf");
		driver2.findElement(By.xpath("//input[@value='submit']")).submit();

	}

	// 6 Browser - Window Pop Up - GetWinwowHandles of window Handler API

	// @Test

	public void browserWindowPopUps() throws InterruptedException {
		// Browser Windows pop up
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.findElement(By.linkText("Good PopUp #1")).click();
		List<String> list = new ArrayList<>();
		Set<String> handler = driver.getWindowHandles();

		for (String h : handler) {
			System.out.println(h);
			list.add(h);
		}

		String parentWindow = driver.getTitle();

		System.out.println("parentWindow" + parentWindow);

		driver.switchTo().window(list.get(1));
		Thread.sleep(2000);

		String childWindow = driver.getTitle();

		System.out.println("childwindow" + childWindow);

		driver.close();

		driver.switchTo().window(list.get(0));

		Assert.assertEquals(driver.getTitle(), parentWindow);

	}

	// 7 Frames

	//@Test

	public void frames() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.freecrm.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("Prt123");
		driver.findElement(By.name("password")).sendKeys("Pratik");
		driver.findElement(By.xpath("//input[@value='Login']")).submit();
		Thread.sleep(5000);
		 List frameNames = new ArrayList();
		// To get number of frames on a page
		List<WebElement> framesInPage = driver.findElements(By.tagName("frame"));
		int framesize = framesInPage.size();
		System.out.println(framesize);
		// OR By XPTAH - int framesize =
		// driver.findElements(By.xpath("//frame")).size();
		for (WebElement a:framesInPage) {
		System.out.println(a.getAttribute("name"));
		frameNames.add(a.getAttribute("name"));
		}
		System.out.println("frameNames are :" + frameNames);
		
		String a = frameNames.get(1).toString();
		driver.switchTo().frame(a);
		
		driver.findElement(By.xpath("//div[@id ='navmenu']//li[4]//a[@title ='Contacts']")).click();
		
		//driver.close();

	}
}
