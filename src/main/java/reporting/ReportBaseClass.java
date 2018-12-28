package reporting;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import browsersetup.BaseClass;
import helpers.MAPFunctions;
import io.appium.java_client.android.AndroidDriver;

public class ReportBaseClass 
{
	
	/*
    static WebDriver driver;
    
    public static WebDriver getDriver(){
 
        if(driver==null){
 
            
 
            driver = new FirefoxDriver();
 
        }
 
        return driver;
 
    }
    */
 
    
 
    /**
 
     * This function will take screenshot
 
     * @param webdriver
 
     * @param fileWithPath
 
     * @throws Exception
 
     */
 
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception
    {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }

	public static void takeSnapShot(String fileWithPath) throws Exception
	{
		Robot robot = new Robot();
		BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(screenShot, "JPG", new File(fileWithPath));
	}
	
	public static void takeSnapShotMAP(AndroidDriver androiddriver,String fileWithPath) throws Exception
    {
		MAPFunctions MAPfunctions = new MAPFunctions(androiddriver);
		MAPfunctions.switchContext("NATIVE");
        //Convert web driver object to TakeScreenshot
		//androiddriver.context("NATIVE_APP");
        TakesScreenshot scrShot =((TakesScreenshot)androiddriver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
       MAPfunctions.switchContext("WEBVIEW");
        //androiddriver.context("WEBVIEW_com.MorsesUAT2");
    }
}