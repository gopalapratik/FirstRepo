package testscripts.map;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import reporting.ListenerClass;
import testdata.ConfigurationData;
import verify.Verify;
import browsersetup.BaseClass;
import helpers.MAPFunctions;
import pageobjects.map.MAPLoginPage;
import pageobjects.map.MAPClientList;

//@Listeners(ListenerClass.class)
public class MAPLogINScripts extends BaseClass {

                @Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "LogIN" }, priority = 1)
//            @Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "LogIN" })
                @Parameters({ "environment", "clientName" })
                public void logInToMAPAppTC201(String environment, String clientName) throws InterruptedException {
                                MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
                                
                                String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
                                String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");

                                MAPLoginPage.EnterLoginID(userName);
                                MAPLoginPage.EnterPassword(password);
                                MAPLoginPage.clickLogIn();
                                Thread.sleep(20000);

                                MAPLoginPage.SearchTerritory();

                                Thread.sleep(10000);
                                Thread.sleep(10000);
                                Thread.sleep(10000);
                                
                                MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
                                MAPClientList.clickHamburger();

                                MAPClientList.clickLogout();
                                System.out.println("Login Successful");
                                Thread.sleep(20000);
                                Thread.sleep(20000);
                }

                
                
                @Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "LogIN" }, priority = 2)
                @Parameters({ "environment", "clientName" })
                public void logInToMAPAppInvalidUserPassTC202(String environment, String clientName) throws InterruptedException {
                                MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
                                MAPLoginPage.EnterLoginID("PAUL.ALLEN1");
                                MAPLoginPage.EnterPassword("Password!235");
                                MAPLoginPage.clickLogIn();
                                Thread.sleep(10000);
                                
                                MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
                                MAPfunctions.switchContext("WEBVIEW");
                                Thread.sleep(10000);
                                
                                System.out.println(MAPLoginPage.verifyErrorMsg());

                                Thread.sleep(10000);
                                if (MAPLoginPage.verifyErrorMsg().equals("Wrong username and/or password.\nPlease try again."))
                                                setAssertMessage("Error Message " + MAPLoginPage.verifyErrorMsg(), 1);
                                Verify.verifyEquals(MAPLoginPage.verifyErrorMsg(), "Wrong username and/or password.\nPlease try again.");
                                Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
                                Thread.sleep(20000);
                                Thread.sleep(20000);

                }

                
                @Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "LogIN" }, priority = 3)
                @Parameters({ "environment", "clientName" })
                public void logInToMAPAppwithoutUserPassTC203(String environment, String clientName) throws InterruptedException {
                                MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
                                MAPLoginPage.clickLogIn();
                                Thread.sleep(10000);
                                Thread.sleep(10000);
                                
                                System.out.println(MAPLoginPage.verifyErrorMsgOnLoginButton());
                                
                                if (MAPLoginPage.verifyErrorMsgOnLoginButton().equals("Please fill in both username and password fields."))
                                                setAssertMessage("Error Message " + MAPLoginPage.verifyErrorMsgOnLoginButton(), 1);
                                Verify.verifyEquals(MAPLoginPage.verifyErrorMsgOnLoginButton(), "Please fill in both username and password fields.");
                                Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
                                Thread.sleep(10000);
                                Thread.sleep(20000);
                }
                

                
                @Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "LogIN" }, priority = 4)
                @Parameters({ "environment", "clientName" })
                public void logInToMAPAppInvalidPassTC204(String environment, String clientName) throws InterruptedException {
                                MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
                                String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
                                Thread.sleep(10000);
                                MAPLoginPage.EnterLoginID(userName);
                                MAPLoginPage.EnterPassword("Password!235");
                                MAPLoginPage.clickLogIn();
                                Thread.sleep(10000);
                                
                                MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
                                MAPfunctions.switchContext("WEBVIEW");
                                Thread.sleep(10000);
                                
                                System.out.println(MAPLoginPage.verifyErrorMsg());

                                Thread.sleep(10000);
                                if (MAPLoginPage.verifyErrorMsg().equals("Wrong username and/or password.\nPlease try again."))
                                                setAssertMessage("Error Message " + MAPLoginPage.verifyErrorMsg(), 1);
                                Thread.sleep(10000);
                                Verify.verifyEquals(MAPLoginPage.verifyErrorMsg(), "Wrong username and/or password.\nPlease try again.");
                                Thread.sleep(1000);
                                Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
                                Thread.sleep(10000);
                                Thread.sleep(20000);
                }
                
                
                @Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "LogIN" }, priority = 5)
                @Parameters({ "environment", "clientName" })
                public void logInForgotPassTC205(String environment, String clientName) throws InterruptedException {
                                MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
                                Thread.sleep(10000);
                                
                                MAPLoginPage.clickForgotPassword();
                                Thread.sleep(10000);
                                
                                MAPFunctions MAPfunctions = new MAPFunctions(getAndroidDriver());
                                MAPfunctions.switchContext("WEBVIEW");
                                Thread.sleep(10000);
                                
                                MAPLoginPage.ForgotPasswordOK();
                                Thread.sleep(10000);
                                Thread.sleep(20000);
                }
                

                @Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "LogIN" }, priority = 6)
                @Parameters({ "environment", "clientName" })
                public void logInToMAPAppwithoutPassTC206(String environment, String clientName) throws InterruptedException {
                                MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
                                String userName = ConfigurationData.getUserDetails(environment, clientName, "Automation Username 1");
                                MAPLoginPage.EnterLoginID(userName);
                                MAPLoginPage.clickLogIn();
                                
                                Thread.sleep(10000);
                                
                                System.out.println(MAPLoginPage.verifyErrorMsgOnLoginButton());
                                Thread.sleep(10000);
                                if (MAPLoginPage.verifyErrorMsgOnLoginButton().equals("Please fill in both username and password fields."))
                                                setAssertMessage("Error Message " + MAPLoginPage.verifyErrorMsgOnLoginButton(), 1);
                                Verify.verifyEquals(MAPLoginPage.verifyErrorMsgOnLoginButton(), "Please fill in both username and password fields.");
                                Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
                                Thread.sleep(20000);
                                Thread.sleep(20000);
                }
                
                

                @Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "LogIN" }, priority = 7)
                @Parameters({ "environment", "clientName" })
                public void logInToMAPAppwithoutUserTC207(String environment, String clientName) throws InterruptedException {
                                MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
                                String password = ConfigurationData.getUserDetails(environment, clientName, "Automation Password 1");
                                MAPLoginPage.EnterPassword(password);
                                MAPLoginPage.clickLogIn();
                                Thread.sleep(10000);
                                
                                System.out.println(MAPLoginPage.verifyErrorMsgOnLoginButton());
                                Thread.sleep(10000);
                                if (MAPLoginPage.verifyErrorMsgOnLoginButton().equals("Please fill in both username and password fields."))
                                                setAssertMessage("Error Message " + MAPLoginPage.verifyErrorMsgOnLoginButton(), 1);
                                Verify.verifyEquals(MAPLoginPage.verifyErrorMsgOnLoginButton(), "Please fill in both username and password fields.");
                                Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
                                Thread.sleep(20000);
                                Thread.sleep(20000);
                }
                

//            @Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "LogIN" })
//            @Parameters({ "environment", "clientName" })
//            public void logInToMultiTerritoryMAPAppTC216(String environment, String clientName) throws InterruptedException {
//                            MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
//                            MAPLoginPage.EnterLoginID(
//                                                            ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "216", 1));
//                            MAPLoginPage.EnterPassword(
//                                                            ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "216", 2));
//                            MAPLoginPage.clickLogIn();
//                            Thread.sleep(30000);
//
//                            WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 120);
//                            MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
//                            
//                            wait.until(ExpectedConditions.elementToBeClickable(MAPLoginPage.LogoutTerritory));
//                            MAPLoginPage.clickTerritoryNo(
//                                                            ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "216", 3));
//                            wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
//                            if (MAPClientList.verifyTerritoryNo().equals(
//                                                            ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "216", 3)))
//                                            setAssertMessage("Territory No " + MAPClientList.verifyTerritoryNo(), 1);
//                            Verify.verifyEquals(MAPClientList.verifyTerritoryNo(),
//                                                            ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "216", 3));
//                            MAPClientList.clickHamburger();
//                            MAPClientList.clickLogout();
//                            Assert.assertFalse(Verify.verifyFailure(), "There were some Failures as shown above.");
//            }
//            
//            
//            @Test(retryAnalyzer = helpers.RetryMechanism.class, groups = { "Regression", "MAP", "LogIN" })
//            @Parameters({ "environment", "clientName" })
//            public void logInToMultiTerritoryMAPAppTC217(String environment, String clientName) throws InterruptedException {
//                            MAPLoginPage MAPLoginPage = new MAPLoginPage(getAndroidDriver());
//                            MAPLoginPage.EnterLoginID(
//                                                            ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "216", 1));
//                            MAPLoginPage.EnterPassword(
//                                                            ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "216", 2));
//                            MAPLoginPage.clickLogIn();
//                            Thread.sleep(30000);
//
//                            WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 120);
//                            MAPClientList MAPClientList = new MAPClientList(getAndroidDriver());
//                            
//                            wait.until(ExpectedConditions.elementToBeClickable(MAPLoginPage.LogoutTerritory));
//                            MAPLoginPage.clickTerritoryNo(
//                                                            ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseDataMap.xlsx", "MapTestData", "216", 3));
//                            wait.until(ExpectedConditions.invisibilityOf(MAPClientList.spinner));
//                            MAPClientList.clickHamburger();
//                            MAPClientList.clickChangeTerritory();
//                            wait.until(ExpectedConditions.elementToBeClickable(MAPLoginPage.LogoutTerritory));
//                            
//            }
}
