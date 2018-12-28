
package testscripts.cap;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import org.testng.annotations.Listeners;
import browsersetup.BaseClass;
//import reporting.ListenerClass;
import pageobjects.*;
import pageobjects.cap.CustomerHistoryRefresh;
import pageobjects.cap.SearchCustomer;
import pageobjects.cap.SearchCustomerTransaction;
import pageobjects.cap.SearchStaffPage;
import reporting.ListenerClass;
import utilities.ExcelUtilities;
import verify.Verify;

@Listeners(ListenerClass.class)
public class CAPSearchCustTransactionScripts extends BaseClass {

                @Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity", "CAP", "Customer" })
                @Parameters({ "environment", "clientName" })
                public void SearchCustTransactionTC22(String environment, String clientName) throws InterruptedException {
                	Thread.sleep(1000);
                                SearchCustomer Scustomer = new SearchCustomer(getDriver());
                                Scustomer = Scustomer.Customer();
                                if (Scustomer.SCust().equals("Search Customer"))
                                                setAssertMessage("1 By default Search Customer page is displayed", 1);
                                Scustomer = Scustomer.setCID(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "22", 1));
                                Scustomer = Scustomer.Search();
                                Scustomer = Scustomer.CustIDtransaction();
                                Scustomer = Scustomer.CustSearchTransaction();
                                Scustomer = Scustomer.SelectProductType();
                                Thread.sleep(2000);
                                Scustomer = Scustomer.setProduct(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "22", 2));
                                Thread.sleep(2000);
                                Scustomer = Scustomer.setValue(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "22", 3));
                                Thread.sleep(2000);
                                Scustomer = Scustomer.setaggnum();
                                Thread.sleep(2000);
                                Scustomer = Scustomer.ConfirmSale();

                                // assertEquals(Scustomer.resultmessege(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx",
                                // "CustomerSearch", "22", 5));

                                if (Scustomer.resultmessege().equals(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "22", 5)))
                                                setAssertMessage("2 System displayed a message >>>>>" + Scustomer.resultmessege(), 2);
                                Verify.verifyEquals(Scustomer.resultmessege(),
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "22", 5));

                                Scustomer = Scustomer.Save();
                                // assertEquals(Scustomer.resultmessege(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx",
                                // "CustomerSearch", "22", 6));
                                if (Scustomer.resultmessege().equals(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "22", 6)))
                                                setAssertMessage("3 System displayed a message >>>>>" + Scustomer.resultmessege(), 3);
                                Verify.verifyEquals(Scustomer.resultmessege(),
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "22", 6));
                                Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
                }

                @Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity", "CAP", "Customer" })
                @Parameters({ "environment", "clientName" })
                public void SearchCustTransactionTC23(String environment, String clientName) throws InterruptedException {
                	Thread.sleep(1000);
                                SearchCustomer Scustomer = new SearchCustomer(getDriver());
                                SearchCustomerTransaction Scusttrxn = new SearchCustomerTransaction(getDriver());
                                Scustomer = Scustomer.Customer();
                                if (Scustomer.SCust().equals("Search Customer"))
                                                setAssertMessage("1 By default Search Customer page is displayed", 1);
                                Scustomer = Scustomer.setCID(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "23", 1));
                                Scustomer = Scustomer.Search();
                                Scustomer = Scustomer.CustIDtransaction();
                                Scustomer = Scustomer.CustSearchTransaction();
                                Scustomer = Scustomer.SelectProductType();
                                Thread.sleep(2000);
                                Scustomer = Scustomer.setProduct(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "23", 2));
                                Thread.sleep(2000);
                                Scustomer = Scustomer.setValue(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "23", 3));
                                Thread.sleep(2000);
                                Scustomer = Scustomer.setaggnum();
                                Thread.sleep(2000);
                                String Account = Scusttrxn.ExisACCount();

                                Scustomer = Scustomer.ConfirmSale();

                                // assertEquals(Scustomer.resultmessege(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx",
                                // "CustomerSearch", "22", 5));

                                if (Scustomer.resultmessege().equals(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "23", 5)))
                                                setAssertMessage("2 System displayed a message >>>>>" + Scustomer.resultmessege(), 2);
                                Verify.verifyEquals(Scustomer.resultmessege(),
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "23", 5));

                                Scustomer = Scustomer.Save();
                                // assertEquals(Scustomer.resultmessege(),ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx",
                                // "CustomerSearch", "22", 6));
                                if (Scustomer.resultmessege().equals(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "23", 6)))
                                                setAssertMessage("3 System displayed a message >>>>>" + Scustomer.resultmessege(), 3);
                                Verify.verifyEquals(Scustomer.resultmessege(),
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "23", 6));
                                CustomerHistoryRefresh Refresh = new CustomerHistoryRefresh(getDriver());
                                if (Refresh.NewACCount().equals(Account))
                                                setAssertMessage("4 New details are displayed ", 4);
                                Verify.verifyEquals(Refresh.NewACCount(), Account);

                                Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

                }

                @Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity", "CAP", "Customer" })
                @Parameters({ "environment", "clientName" })
                public void SearchCustTransactionTC24(String environment, String clientName) throws InterruptedException {
                	Thread.sleep(1000);
                                SearchCustomer Scustomer = new SearchCustomer(getDriver());
                                SearchCustomerTransaction Scusttrxn = new SearchCustomerTransaction(getDriver());
                                Scustomer = Scustomer.Customer();
                                if (Scustomer.SCust().equals("Search Customer"))
                                                setAssertMessage("1 By default Search Customer page is displayed", 1);
                                Scustomer = Scustomer.setCID(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "24", 1));
                                Scustomer = Scustomer.Search();
                                Scustomer = Scustomer.CustIDtransaction();
                                Scustomer = Scustomer.CustSearchTransaction();
                                if (Scusttrxn.PerCustID().equals(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "24", 1)))
                                                setAssertMessage("2 Customer ID is displayed Properly", 2);
                                Verify.verifyEquals(Scusttrxn.PerCustID(),
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "24", 1));
                                if (Scusttrxn.PerStatus().equals(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "24", 2)))
                                                setAssertMessage("3 Status is >>>>>" + Scusttrxn.PerStatus(), 3);
                                Verify.verifyEquals(Scusttrxn.PerStatus(),
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "24", 2));
                                if (Scusttrxn.PerName().equals(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "24", 3)))
                                                setAssertMessage("4 Customer name is >>>>>" + Scusttrxn.PerName(), 4);
                                Verify.verifyEquals(Scusttrxn.PerName(),
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "24", 3));
                                if (Scusttrxn.PerAddress().equals(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "24", 4)))
                                                setAssertMessage("5 Address is >>>>>" + Scusttrxn.PerAddress(), 5);
                                Verify.verifyEquals(Scusttrxn.PerAddress(),
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "24", 4));
                                Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

                }

                @Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity", "CAP", "Customer" })
                @Parameters({ "environment", "clientName" })
                public void SearchCustTransactionTC25(String environment, String clientName) throws InterruptedException {
                	Thread.sleep(1000);
                                SearchCustomer Scustomer = new SearchCustomer(getDriver());
                                SearchCustomerTransaction Scusttrxn = new SearchCustomerTransaction(getDriver());
                                Scustomer = Scustomer.Customer();
                                if (Scustomer.SCust().equals("Search Customer"))
                                                setAssertMessage("1 By default Search Customer page is displayed", 1);
                                Scustomer = Scustomer.setCID(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "25", 1));
                                Scustomer = Scustomer.Search();
                                Thread.sleep(10000);
                                Scustomer = Scustomer.CustIDtransaction();
                                Scustomer = Scustomer.CustSearchTransaction();
                                Thread.sleep(10000);
                                System.out.println("uuuuu");
                                if (Scusttrxn.Transaction().equals(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "25", 2)))
                                                setAssertMessage("2 Transaction field is displayed Properly", 2);
                                Verify.verifyEquals(Scusttrxn.Transaction(),
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "25", 2));
                                if (Scusttrxn.ProductType().equals(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "25", 3)))
                                                setAssertMessage("3 Product Type field is displayed Properly", 3);
                                Verify.verifyEquals(Scusttrxn.ProductType(),
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "25", 3));
                                if (Scusttrxn.Prod().equals(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "25", 4)))
                                                setAssertMessage("4 Product field is displayed Properly", 4);
                                Verify.verifyEquals(Scusttrxn.Prod(),
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "25", 4));
                                if (Scusttrxn.SaleValue().equals(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "25", 5)))
                                                setAssertMessage("5 Sale Value field is displayed Properly", 5);
                                Verify.verifyEquals(Scusttrxn.SaleValue(),
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "25", 5));
                                if (Scusttrxn.AggNumber().equals(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "25", 6)))
                                                setAssertMessage("6 Aggrement Number field is displayed Properly", 6);
                                Verify.verifyEquals(Scusttrxn.AggNumber(),
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "25", 6));
                                if (Scusttrxn.SaleDate().equals(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "25", 7)))
                                                setAssertMessage("7 SaleDate field is displayed Properly", 7);
                                Verify.verifyEquals(Scusttrxn.SaleDate(),
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "25", 7));
                                Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

                }

                @Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity", "CAP", "Customer" })
                @Parameters({ "environment", "clientName" })
                public void SearchCustTransactionTC26(String environment, String clientName) throws InterruptedException {
                	Thread.sleep(1000);
                                SearchCustomer Scustomer = new SearchCustomer(getDriver());
                                SearchCustomerTransaction Scusttrxn = new SearchCustomerTransaction(getDriver());
                                // Scustomer = Scustomer.Customer();
                                SearchStaffPage SStaff = new SearchStaffPage(getDriver());
                                SStaff = SStaff.Staff();
                                // SStaff = SStaff.SearchStaff();
                                SStaff = SStaff.Staffid(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "26", 1));
                                SStaff = SStaff.FirstName(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "26", 2));
                                SStaff = SStaff.LastName(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "26", 3));
                                SStaff = SStaff.Search();
                                SStaff = SStaff.StaffLink();
                                SStaff = SStaff.CommiScheme();
                                if (SStaff.SchemeNam().equals(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "26", 4)))
                                                setAssertMessage("Scheme is attached to customer under Commission schemes section", 1);
                                Verify.verifyEquals(SStaff.SchemeNam(),
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "26", 4));
                                Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

                }

                @Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity", "CAP", "Customer" })
                @Parameters({ "environment", "clientName" })
                public void SearchCustTransactionTC27(String environment, String clientName) throws InterruptedException {

                                SearchCustomer Scustomer = new SearchCustomer(getDriver());
                                Scustomer = Scustomer.Customer();
                                if (Scustomer.SCust().equals("Search Customer"))
                                                setAssertMessage("1 By default Search Customer page is displayed", 1);
                                Scustomer = Scustomer.setCID(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "27", 1));
                                Scustomer = Scustomer.Search();
                                SearchCustomerTransaction Scusttrxn = new SearchCustomerTransaction(getDriver());
                                Scusttrxn = Scusttrxn.CustomerLink();
                                Scustomer = Scustomer.CustSearchTransaction();

                                Scusttrxn = Scusttrxn.trasaction();
                                Thread.sleep(2000);
                                Scusttrxn = Scusttrxn.setPaymentValue(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "27", 2));
                            //    Scusttrxn = Scusttrxn.setPayment(ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "27", 3));
                                                                
                               
                                Thread.sleep(3000);
                                
                                Scusttrxn = Scusttrxn.Allocate();
                               // Thread.sleep(2000);
                               // Scusttrxn = Scusttrxn.Alert();
                                // WaitForPageToLoad(getDriver());
                                Thread.sleep(5000);
                                if (Scustomer.resultmessege().equals(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "27", 4)))
                                                setAssertMessage("System displayed a message <<<<<<" + Scustomer.resultmessege(), 1);
                                Verify.verifyEquals(Scustomer.resultmessege(),
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "27", 4));
                                Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

                }

                @Test(enabled=true,retryAnalyzer = helpers.RetryMechanism.class, groups = { "Sanity", "CAP", "Customer" })
                @Parameters({ "environment", "clientName" })
                public void SearchCustTransactionTC28(String environment, String clientName) throws InterruptedException {
                	Thread.sleep(1000);
                                SearchCustomer Scustomer = new SearchCustomer(getDriver());
                                Scustomer = Scustomer.Customer();
                                if (Scustomer.SCust().equals("Search Customer"))
                                                setAssertMessage("1 By default Search Customer page is displayed", 1);
                                Scustomer = Scustomer.setCID(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "28", 1));
                                Scustomer = Scustomer.Search();
                                SearchCustomerTransaction Scusttrxn = new SearchCustomerTransaction(getDriver());
                                Scusttrxn = Scusttrxn.CustomerLink();
                                Scustomer = Scustomer.CustSearchTransaction();

                                if (Scusttrxn.setTitle().equals(
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "28", 2)))
                                                setAssertMessage("System displayed details of  RECORD TRANSACTIONS - PAYMENT properly", 1);
                                Verify.verifyEquals(Scusttrxn.setTitle(),
                                                                ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "28", 2));
                                Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");

                }

}
