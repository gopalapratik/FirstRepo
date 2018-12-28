package pageobjects.map;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import browsersetup.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class MAPViewAllSales extends BaseClass {

	public MAPViewAllSales(AndroidDriver androiddriver) {
		setAndroidDriver(androiddriver);
		PageFactory.initElements(new AjaxElementLocatorFactory(getAndroidDriver(), 60), this);
	}

	String viewAllSalesTable="//table[@class='pure-table table-customer-details']/tbody/tr";
	
	
	public String getLoanSalesCustomerID(String Customer)
	{
		String customerid= getAndroidDriver().findElement(By.xpath(viewAllSalesTable+"/td[contains(text(),'"+Customer+"')]//following-sibling::td[1]")).getText();
		return customerid;
	}
	
	public String getLoanSalesIssueDate(String Customer)
	{
		String customerid= getAndroidDriver().findElement(By.xpath(viewAllSalesTable+"/td[contains(text(),"+Customer+")]//following-sibling::td[5]")).getText();
		return customerid;
	}
}

//table[@class='pure-table table-customer-details']/tbody/tr/td[contains(text(),'KIAN KNOT')]//following-sibling::td[1]