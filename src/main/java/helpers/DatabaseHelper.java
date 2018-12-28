package helpers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import testdata.ConfigurationData;


public class DatabaseHelper 
{
	static String hostautomationdb = ConfigurationData.databaseHostNameautomationdb;
	static String userNameautomationdb = ConfigurationData.databaseUserNameautomationdb;
	static String passwordautomationdb = ConfigurationData.databasePasswordautomationdb;	

	/*
	 * Execute a DDL Query
	 */
	/*
	public static void executeDDLQuery(String query,String schemaName) throws InterruptedException, SQLException
	{
		Thread.sleep(2000);
		Statement stm = createDBConnection(schemaName);
		try
		{        
			stm.executeUpdate(query);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			stm.close();
		}
	}
	 */

	/*
	 * Updates a Table
	 */
	public static void updateQuery(String query,String schemaName,String environment) throws InterruptedException, SQLException
	{
		Thread.sleep(2000);
		Statement stm = createDBConnection(schemaName,environment);
		try
		{        
			stm.executeUpdate(query);
		}

		finally
		{
			stm.close();
		}
	}


	/*
	 * Returns a list of value for the database rows for the specified column (Multiple Rows & Single Column)
	 */
	public static List<String> CreateDataListForAListOfRows(String query,String tablecolumnname,String schemaName,String environment) throws InterruptedException, SQLException
	{
		List<String> dataList = new ArrayList<String>();
		Thread.sleep(2000);

		Statement stm = createDBConnection(schemaName,environment);

		try
		{        
			ResultSet rst;
			rst = stm.executeQuery(query);
			while (rst.next()) 
			{
				dataList.add(rst.getString(tablecolumnname));
			}
		}

		finally
		{
			stm.close();
		}
		return dataList;
	}

	/*
	 * Returns a List of value for the database columns specified in the List (Single Row & Multiple Columns)
	 */
	public static List<String> CreateDataListForAListOfColumns(String query,List<String> tablecolumnnames,String schemaName, String environment) throws InterruptedException, SQLException
	{
		List<String> dataList = new ArrayList<String>();
		Thread.sleep(2000);       

		Statement stm = createDBConnection(schemaName,environment);

		try
		{        
			ResultSet rst;
			rst = stm.executeQuery(query);
			while (rst.next()) 
			{
				for(String eachString : tablecolumnnames)
				{
					dataList.add(rst.getString(eachString));
				}
			}
		}

		finally
		{
			stm.close();
		}
		return dataList;
	}

	/*
	 * Returns a List of value for the database columns specified in the List (Multiple Rows & Multiple Columns)
	 */
	public static List<ArrayList<String>> createMulipleColumnDataListForMultipleRowsInDB(String query,List<String> tablecolumnnames,String schemaName, String environment) throws InterruptedException, SQLException
	{
		List<ArrayList<String>> dataListMultipleRow = new ArrayList<ArrayList<String>>();
		Thread.sleep(2000);       

		Statement stm = createDBConnection(schemaName,environment);

		try
		{        
			ResultSet rst;
			rst = stm.executeQuery(query);
			while (rst.next()) 
			{
				ArrayList<String> dataListSingleRow = new ArrayList<String>();
				for(String eachString : tablecolumnnames)
				{
					dataListSingleRow.add(rst.getString(eachString));
				}
				dataListMultipleRow.add(dataListSingleRow);
			}
		}

		finally
		{
			stm.close();
		}
		return dataListMultipleRow;
	}

	private static Statement createDBConnection(String schemaName,String environment) throws SQLException
	{
		Connection connection = null;
		if(environment.contains("Local"))
		{
			try
			{
				connection = DriverManager.getConnection(hostautomationdb,userNameautomationdb,passwordautomationdb);
			}
			catch(Exception e)
			{
				System.out.println("There was a problem while establish a connection : " + e);
			}
		}
		return connection.createStatement();
	}
	
	/*
	 executeBCTQuery(String strCustomerRequestID) : This method is used to execute Bulk Customer Transfer batch for specified Customer Request
	 */
	public static void executeBCTQuery(String strCustomerRequestID, String environment) throws ClassNotFoundException, SQLException, InterruptedException {
		
		String strOracleDBURL = null;
		String strOracleDBUsername = ConfigurationData.MCL_Oracle_DataBase_Usaername;
		String strOracleDBPassword = ConfigurationData.MCL_Oracle_DataBase_Password;
			
		switch (environment.toUpperCase()) {
		case "TEST 1":
			strOracleDBURL = ConfigurationData.MCL_Test1_DataBase_URL;
			break;
		case "TEST 2":
			strOracleDBURL = ConfigurationData.MCL_Test2_DataBase_URL;
			break;
		case "TEST 3":
			strOracleDBURL = ConfigurationData.MCL_Test3_DataBase_URL;
			break;
		default:
			Assert.fail(environment + "dosen't exsists");
		}
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.253.12:1521:MCLTEST1", "morse", "m0rs3");
		Connection con = DriverManager.getConnection(strOracleDBURL, strOracleDBUsername, strOracleDBPassword);
		
		Statement stmt1 = con.createStatement();
		try {
			try {
				// In this query--> we are updating specified customer request id's effective as current system date
				
				stmt1.executeUpdate("UPDATE bct_request_hdr SET effective_date = trunc(sysdate) WHERE bct_request_hdr_id = '"+ Integer.valueOf(strCustomerRequestID)+"'");

				stmt1.close();
			} catch (SQLException se) {

				se.printStackTrace();
				System.out.println("Error while excuting Bulk Customer Batch ");
			} finally {
				try {
					if (stmt1 != null)
						stmt1.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

			// This logic is used to handle Batch Execution Query
			CallableStatement storedProc = con.prepareCall("{call dba_util.pk_bulk_cust_transfer.prc_do_move}");
			try {

				storedProc.execute();

				con.close();

				System.out.println("Executed Bulk Customer Batch successfully");
				Thread.sleep(5000);

			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println("Error while excuting Bulk Customer Batch ");
			} finally {

				try {
					if (storedProc != null) {
						storedProc.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}

				try {
					if (con != null) {
						con.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}

			}
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
