package helpers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import utilities.ExcelUtilities;

public class TestDataHelpers {
		
	public static List<String> twoDigitNumberList = Arrays.asList("11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37"
			,"38","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73",
			"74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99");
	
	
	public static enum Day {
	    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY 
	}
	
	public static void main (String args[]) throws IOException {
		
		/*public String getEffectiveMondayDate() {
			
			String strEffectiveMondayDate = null;
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
			Date date = new Date();
			System.out.println(date.toString());
			String strCurrentDate = date.toString();
			//String strCurrentDateNumber = 
			String strCurrentDay = dateFormat.format(date).toUpperCase();
			System.out.println(strCurrentDay);
			
			/*switch(strCurrentDay) {
			
			//case MONDAY :
				
			}*/
		//}
		
		ArrayList<String> listOfSelectedCustomerIDs = new ArrayList<String>();
		listOfSelectedCustomerIDs.add("CD1");
		listOfSelectedCustomerIDs.add("CD2");
		listOfSelectedCustomerIDs.add("CD3");
		listOfSelectedCustomerIDs.add("CD4");
		ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", 0, 1,"65");
		ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", 1, 1,"26/06/2018");
		ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", 2, 1,"0012");
		ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", 3, 1,"8914");
		int i=4;
		for(int j=0; j<listOfSelectedCustomerIDs.size(); j++){
		//for(int i=4 ; i<4+listOfSelectedCustomerIDs.size(); i++) {
			do {
			
				
			ExcelUtilities.setCellValue("TestCaseData.xlsx", "BulkCustomerTransfer", i, 1,listOfSelectedCustomerIDs.get(j));
			System.out.println(i);
			//int newI = ++i;
			//System.out.println(newI);
			}while(i>++i);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
}
