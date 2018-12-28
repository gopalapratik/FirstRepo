package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import browsersetup.BaseClass;
import testdata.ConfigurationData;
import pageobjects.cap.CCPSPLScreen;
import pageobjects.cap.SearchStaffPage;
import testscripts.cap.CAPCCPSPLScreenScripts;
import utilities.ExcelUtilities;

public class CommonFunctions  extends BaseClass {
	public static WebDriver driver;
	WebDriverWait wait;
	//WebDriver driver;
	static String configurationFileName = "ConfigurationDetails.xlsx";
    static String driverPathIE = ConfigurationData.driverPathIE;
    public static String baseurlEnvironmentOne = ExcelUtilities.getKeyValueFromExcel(configurationFileName, "Config", "TEST 1");
	public static String BUNAme="AutoTestBU"+CommonFunctions.InsertTime();
	public  String strTime ;
	
	public CommonFunctions(WebDriver driver)
	{
		this.driver=driver;
		this.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		 wait = new WebDriverWait(this.driver, 15);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	public static String generateDtTimeStamp()
	{
		
		String newStr = new SimpleDateFormat("MMddyyyyHHmm").format(new Date());
		/*Date now = new java.util.Date(); 
		Timestamp current = new java.sql.Timestamp(now.getTime());
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(current);
		String newStr = str.concat(timeStamp);	*/
		
		return newStr;
	}
	public static String InsertTime()
	{
		
		String add;
		long b =System.currentTimeMillis();
		String h = String.valueOf(b);
		//System.out.println("kkkkkkk"+h);
		int index = 5;
		char[] chs = h.toCharArray();
		//String part1 = new String(chs, 0, index);
		add = new String(chs, index, chs.length - index);
		//System.out.println("part2  "+aggnum);
		
		return add;
	}
	public static String NowDate()
	{
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	public static String roll(String Query)
	{
		try{  
			
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@172.16.253.12:1521:MCLTEST1","morse","m0rs3");  
			
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			  
			//step4 execute query
			if(Query.equalsIgnoreCase("BM"))
			{
				System.out.println("in BMMMMMMM");
			ResultSet rs=stmt.executeQuery("UPDATE MORSE.STAFF_USER_GROUP SET USER_GROUP_ID = 15 WHERE STAFF_ID =1");
			}
			if(Query.equalsIgnoreCase("AM"))
			{
				System.out.println("in AMMMMMMM");
			ResultSet rs=stmt.executeQuery("UPDATE MORSE.STAFF_USER_GROUP SET USER_GROUP_ID = 6 WHERE STAFF_ID =1");
			}
			if(Query.equalsIgnoreCase("RM"))
			{
				System.out.println("in RMMMMMMM");
			ResultSet rs=stmt.executeQuery("UPDATE MORSE.STAFF_USER_GROUP SET USER_GROUP_ID = 12 WHERE STAFF_ID =1");
			}
			if(Query.equalsIgnoreCase("DM"))
			{
				System.out.println("in DMMMMMMM");
			ResultSet rs=stmt.executeQuery("UPDATE MORSE.STAFF_USER_GROUP SET USER_GROUP_ID = 11 WHERE STAFF_ID =1");
			}
			if(Query.equalsIgnoreCase("DO"))
			{
				System.out.println("in DOOOOOO");
			ResultSet rs=stmt.executeQuery("UPDATE MORSE.STAFF_USER_GROUP SET USER_GROUP_ID = 45040 WHERE STAFF_ID =1");
			}
			if(Query.equalsIgnoreCase("Administrator Business"))
			{
				System.out.println("in BAAAAAA");
			ResultSet rs=stmt.executeQuery("UPDATE MORSE.STAFF_USER_GROUP SET USER_GROUP_ID = 10 WHERE STAFF_ID =1");
			}
			if(Query.equalsIgnoreCase("DateRollBack"))
			{
				System.out.println("in daterollback");
			ResultSet rs=stmt.executeQuery("update MORSE.staff_user_group_tmp set end_date=sysdate-1,start_date=sysdate-1 where staff_id=1");
			}
			if(Query.equalsIgnoreCase("ClearAgentNote"))
			{
				//System.out.println("in daterollback");
			ResultSet rs=stmt.executeQuery("delete from agent_event where created_by='ELIZABETH.DAY'");
			}
			
			
			//while(rs.next())  
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.commit();
			//step5 close the connection object  
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
		return Query;
		
	}
	public static CommonFunctions Browser()
	{
			System.setProperty("webdriver.ie.driver", driverPathIE);
	        //System.setProperty("webdriver.ie.driver", "C:\\Users\\bhagyas13829\\Desktop\\IEDriverServer.exe");
	        DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
	        dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	        driver = new InternetExplorerDriver(dc);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get(baseurlEnvironmentOne);
	        driver.manage().window().maximize();
	        return new CommonFunctions(driver);
	}


	public static String CurrentTimeFormatar(String Value)
	{
		
	SimpleDateFormat sdfTime = new SimpleDateFormat(Value);
    Date now = new Date();
    String strTime = sdfTime.format(now);
    System.out.println("Time: " + strTime);
    return strTime;
	}


}
