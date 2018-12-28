package pageobjects.map;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import browsersetup.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MAPLoginPage extends BaseClass {

                WebDriver driver;

                AndroidDriver driver1;

                public MAPLoginPage(AndroidDriver androiddriver) {
                                setAndroidDriver(androiddriver);
                                PageFactory.initElements(new AjaxElementLocatorFactory(getAndroidDriver(), 20), this);
                }

//            @FindBy(xpath = "//div[@class='logo']")
                @FindBy(xpath = "//android.widget.Image[@index='0']")
                public WebElement logo;

                @FindBy(xpath = "//android.widget.EditText[@resource-id='loginData.username']")
                //@FindBy(xpath = "//*[@id='loginData.username']")
                WebElement UserName;
                
                //*[@id="loginData.username"]
                //*[@id="loginData.password"]
                
                

                @FindBy(xpath = "//android.widget.EditText[@resource-id='loginData.password']")
                //@FindBy(xpath = "//*[@id='loginData.password']")
                WebElement Password;

                @FindBy(xpath = "//android.widget.Button[@resource-id='submitCredentials']")
                //@FindBy(xpath = "//*[@id='submitCredentials']")
                WebElement MAloginbutton;

                @FindBy(xpath = "//android.view.View[@text='1117']")
                WebElement TerritoryOption;
                
                @FindBy(xpath = "//android.view.View[@text='1519']")
                WebElement SearchTerritory;

                @FindBy(xpath = "//android.view.View[@text='Client list']")
                WebElement TabSelect;
                
                @FindBy(xpath = "//android.view.View[@text='ATM Withdrawal']")
                WebElement SelectOptionfromTerritoryList;
                
                @FindBy(xpath = "//android.view.View[@text='View All Sales']")
                WebElement GreenOptionTerritoryList;
                
                
                @FindBy(xpath = "//*[@id='clientListContent']/div[1]/div[2]/div[2]")
                WebElement SelectFromList;
                

                
                //*[@id="clientListContent"]/div[1]/div[2]/div[2]

                @FindBy(xpath = "//android.view.View[@resource-id='open-loan-sale-customers-details']")
                WebElement TabOnLoanSale;
                
                @FindBy(linkText = "MCL-mastek@mastek.com")
                WebElement EmailId;
                
                
                @FindBy(xpath = "//*[@id='open-loan-sale-customers-details']/span")
                WebElement TabOnUniqueLoanSale;
                
                @FindBy(xpath = "//img[@src='images/fl3.png']")
                WebElement TabOnEligibleLoanSale;
                
                
                @FindBy(xpath = "//span[@class='loanSaleBtn-customer-details']")
                WebElement LoanSaleTab;

                @FindBy(xpath = "//android.view.View[@text='Affordability Check']")
                WebElement AffordabilityCheck;
                
                @FindBy(xpath = "//*[@id='detailsWrapper']/form/span/div[4]/div/div/div/div[2]/label/span/i[2]")
                WebElement RadioButton;
                

                @FindBy(xpath = "//android.widget.EditText[@resource-id='netIncomeJson.enteredIncome']")
                WebElement NetIncome;

                @FindBy(xpath = "//android.view.View[@text='SUBMIT']")
                WebElement SubmitButtonNetIncome;
                
                
                @FindBy(xpath = "//android.view.View[@text='PAYMENT']")
                WebElement PaymentButton;
                
                @FindBy(xpath = "//android.widget.EditText[@index='1']")
                WebElement CashPaymentAmmount;
                
                @FindBy(xpath = "//android.view.View[@text='CONFIRM']")
                WebElement ConfirmButton;
                
                @FindBy(xpath = "//android.widget.EditText[@resource-id='payAccount_0']")
                WebElement AmmountLabel;
                
                
                
                
                
                

                ///////////////////////////////////////////

                // Loan Sale Entry//
                @FindBy(xpath = "//android.widget.Spinner[@index='8'])")
                WebElement TabDocumentWages;

                // Loan Sale Entry//
                @FindBy(xpath = "//android.widget.EditText[@index='7']")
                WebElement Wages;
                
                @FindBy(xpath = "//android.widget.EditText[@index='8']")
    public WebElement WagesDocument;
                
                @FindBy(xpath = "//android.widget.EditText[@index='9']")
    public WebElement WageReference;
                
                
             

                @FindBy(xpath = "//android.widget.EditText[@index='12']")
                WebElement Benefits;

                @FindBy(xpath = "//android.widget.EditText[@index='17']")
                WebElement Pension;

                @FindBy(xpath = "//android.widget.EditText[@index='22']")
                WebElement Others;

                //////////////
                @FindBy(xpath = "//android.widget.Spinner[@index='8']")
                WebElement wagesdocumentdropdownoption;

                @FindBy(xpath = "//android.view.View[@text='HMRC Letter'] and @index='3'")
                WebElement ValueSelection;

                @FindBy(xpath = "//android.widget.Spinner[@index='13']")
                WebElement benefitsdocumentdropdownoption;

                @FindBy(xpath = "//android.widget.Spinner[@index='18']")
                WebElement pensiondocumentdropdownoption;

                @FindBy(xpath = "//android.widget.Spinner[@index='23']")
                WebElement Otherdocumentdropdownoption;

                //////////////////////
                @FindBy(xpath = "//android.widget.EditText[@index='9']")
                WebElement wagesreferenceTextBox;

                @FindBy(xpath = "//android.widget.EditText[@index='14']")
                WebElement benefitsreferenceTextBox;

                @FindBy(xpath = "//android.widget.EditText[@index='19']")
                WebElement pensionreferenceTextBox;

                @FindBy(xpath = "//android.widget.EditText[@index='24']")
                WebElement OtherreferenceTextBox;

                /////////////////////////////////////////////////////////

                @FindBy(xpath = "//div[@id='errorMessage']")
                WebElement errorMsg;
                
                @FindBy(xpath = "//android.view.View[@text='Please fill in both username and password fields.']")
                WebElement ErrorMsgOnLoginButton;

//            @FindBy(id = "//*[@id='forgotCredentialsButton']")
                @FindBy(xpath = "//android.view.View[@text='Forgot password?']")
                WebElement forgotPassword;
                

//            @FindBy(xpath = "//android.widget.Button[@text='OK']")
                @FindBy(xpath = "//button[@class='button button-full button-positive full-width']")
                WebElement forgotPasswordOK;

                @FindBy(xpath = "//android.widget.EditText[@resource-id='loginData.username']")
                WebElement forgotPasswordMessage;

                // @FindBy(xpath = "//div[@class='modal-message-two']")
                // WebElement forgotPasswordMessage2;


                @FindBy(xpath = "//android.view.View[@index='1']")
                WebElement selectedTerritory;

                @FindBy(xpath = "//a[contains(text(),'Logout')]")
                public WebElement LogoutTerritory;

                public MAPLoginPage EnterLoginID(String username) throws InterruptedException {
                                UserName.sendKeys(username);
                                System.out.println("Username Entered");
                                Thread.sleep(10000);
                                Password.click();
                                return new MAPLoginPage(getAndroidDriver());
                }

                public MAPLoginPage EnterPassword(String password) throws InterruptedException {
                                Password.sendKeys(password);
                                System.out.println("Password Entered");
                                Thread.sleep(1000);
                                return new MAPLoginPage(getAndroidDriver());
                }

                public MAPLoginPage clickLogIn() throws InterruptedException {
                                MAloginbutton.click();
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());

                }

                public MAPLoginPage TabLoggedInButton() throws InterruptedException {
                                MAloginbutton.click();
                                System.out.println("Logged In button clicked");

                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());

                }

                public MAPLoginPage SelectTerritory() throws InterruptedException {
                                TerritoryOption.click();
                                System.out.println("Territory Selected");
                                Thread.sleep(1000);
                                return new MAPLoginPage(getAndroidDriver());
                }
                
                public MAPLoginPage SelectOptionfromTerritoryList() throws InterruptedException {
                                SelectOptionfromTerritoryList.click();
                                System.out.println("Territory Selected");
                                Thread.sleep(1000);
                                return new MAPLoginPage(getAndroidDriver());
                }
                
                
                
                
                
                public MAPLoginPage SearchTerritory() throws InterruptedException {
                                TerritoryOption.click();
                                System.out.println("Territory Selected");
                                Thread.sleep(1000);
                                return new MAPLoginPage(getAndroidDriver());

                }
                
                
                
                private final By yourElement = By.xpath("//android.view.View[@text='ATM Withdrawal']");
                public void isLoaded() throws Error {
                    new FluentWait<WebDriver>(driver)
                            .withTimeout(60, TimeUnit.SECONDS)
                            .pollingEvery(1, TimeUnit.SECONDS)
                            .ignoring(NoSuchElementException.class)
                            .ignoring(StaleElementReferenceException.class)
                            .until(new Function<WebDriver, Boolean>() {
                               
                                public Boolean apply(WebDriver webDriver) {
                                    WebElement element = driver.findElement(yourElement);
                                    return element != null && element.isDisplayed();
                                }
                            });
                }
                
                public MAPLoginPage ScrollTillElementVisilble() throws InterruptedException {
                                WebElement Element = driver.findElement(By.xpath("//android.widget.EditText[@index='68']"));
                                ((JavascriptExecutor) driver).executeScript(
                            "arguments[0].scrollIntoView();", Element);
                                System.out.println("Territory Selected");
                                Thread.sleep(10000);
                                Thread.sleep(10000);
                                return new MAPLoginPage(getAndroidDriver());
                }
                
                ////Code By Amit Chatterjee///////
                public MAPLoginPage ScrollToElementVisilble() throws InterruptedException {
                                try {
                                                WebElement element = driver.findElement(By.xpath("//android.view.View[@text='View All Sales']"));
                                                System.out.println("Printing the data:" + element);
                                                
                                                                if (element.isEnabled() && element.isDisplayed()) {
                                                                                System.out.println("Clicking on element with using java script click");
                                                                                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
                                                                                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                                                                } else {
                                                                                System.out.println("Unable to click on element");
                                                                }
                                                } catch (StaleElementReferenceException e) {
                                                                System.out.println("Element is not attached to the page document "+ e.getStackTrace());
                                                } catch (NoSuchElementException e) {
                                                                System.out.println("Element was not found in DOM "+ e.getStackTrace());
                                                } catch (Exception e) {
                                                                System.out.println("Unable to click on element "+ e.getStackTrace());     
}
                                return new MAPLoginPage(getAndroidDriver());
                }
                
                
                
                
                
                
                

                public MAPLoginPage TabSelect() throws InterruptedException {
                                GreenOptionTerritoryList.click();
                                Thread.sleep(1000);
                                System.out.println("Selected Option from Territory List successfull");
                                Thread.sleep(1000);
                                return new MAPLoginPage(getAndroidDriver());
                }
                

                public MAPLoginPage SelectFromList() throws InterruptedException {
                                SelectOptionfromTerritoryList.click();
                                Thread.sleep(1000);
                                System.out.println("Selected Option from Territory List successfull");
                                Thread.sleep(1000);
                                return new MAPLoginPage(getAndroidDriver());
                }
                
                
                
                
                public MAPLoginPage PaymentButton() throws InterruptedException {
                                PaymentButton.click();
                                System.out.println("User clicked On Payment Button");
                                Thread.sleep(1000);
                                return new MAPLoginPage(getAndroidDriver());
                }
                
                public MAPLoginPage CashPaymentAmmount() throws InterruptedException {
                                CashPaymentAmmount.sendKeys("200");
                                System.out.println("User entered Cash Payment");
                                getAndroidDriver().hideKeyboard();
                //            CashPaymentAmmount.sendKeys(Keys.ENTER);
                                Thread.sleep(10000);
                                return new MAPLoginPage(getAndroidDriver());
                }
                
                public MAPLoginPage ConfirmButton() throws InterruptedException {
                                ConfirmButton.click();
                                System.out.println("User clicked on Confirmation button");
                                Thread.sleep(1000);
                                return new MAPLoginPage(getAndroidDriver());
                }
                
                public MAPLoginPage AmmountLabel() throws InterruptedException {
                                AmmountLabel.click();
                                System.out.println("User clicked on Ammount Label");
                                Thread.sleep(1000);
                                return new MAPLoginPage(getAndroidDriver());
                }
                
                

                public MAPLoginPage TabOnLoanSale() throws InterruptedException {
                                TabOnLoanSale.click();
                                System.out.println("User clicked On Loan Sale Tab");
                                Thread.sleep(1000);
                                return new MAPLoginPage(getAndroidDriver());
                }
                
                
                public MAPLoginPage DisplayEmailId() throws InterruptedException {
                                
                //            System.out.println(EmailId);
                                System.out.println("Email Display as: " + EmailId.getText());
                                Thread.sleep(1000);
                                return new MAPLoginPage(getAndroidDriver());
                }
                
                
                public MAPLoginPage TabOnUniqueLoanSale() throws InterruptedException {
                                TabOnUniqueLoanSale.click();
                                System.out.println("User clicked On Loan Sale Tab");
                                Thread.sleep(1000);
                                return new MAPLoginPage(getAndroidDriver());
                }
                
                
                
                
                
                public MAPLoginPage TabOnEligibleLoanSale() throws InterruptedException {
                                TabOnEligibleLoanSale.click();
                                System.out.println("User clicked On Loan Sale Tab");
                                Thread.sleep(1000);
                                return new MAPLoginPage(getAndroidDriver());
                }
                
                
                
                
                
                
                
                
                public MAPLoginPage LoanSaleButton() throws InterruptedException {
                                LoanSaleTab.click();
                                System.out.println("User clicked On Loan Sale Tab");
                                Thread.sleep(1000);
                                return new MAPLoginPage(getAndroidDriver());
                }
                
                
                

                public MAPLoginPage AffordabilityCheck() throws InterruptedException {
                                AffordabilityCheck.click();
                                System.out.println("User clicked on Affordability Check Tab");
                                Thread.sleep(1000);
                                return new MAPLoginPage(getAndroidDriver());
                }
                
                public MAPLoginPage RadioButton() throws InterruptedException {
                                RadioButton.click();
                                System.out.println("User clicked on Radio Button");
                                Thread.sleep(1000);
                                return new MAPLoginPage(getAndroidDriver());
                }

                public MAPLoginPage NetIncomeTextBox() throws InterruptedException {
                                AffordabilityCheck.click();
                                System.out.println("User clicked on Affordability Check Tab");
                                Thread.sleep(1000);
                                return new MAPLoginPage(getAndroidDriver());
                }

                public MAPLoginPage NetIncome() throws InterruptedException {
                                NetIncome.click();
                                Thread.sleep(2000);
                                NetIncome.sendKeys("2000");
                                System.out.println("Data entered on Affordability Check Text Box ");
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());

                }

                public MAPLoginPage SubmitButtonNetIncome() throws InterruptedException {
                                SubmitButtonNetIncome.click();
                                Thread.sleep(2000);
                                System.out.println("Click on submit button");
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());

                }

                public MAPLoginPage ListOfWages() throws InterruptedException {

                                List<WebElement> count = driver.findElements(By.xpath("//android.widget.Spinner[@index='8'])"));
                                System.out.println("Count of Webelements inside Wages Document Dropdown:" + count.size());
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());

                }

                public MAPLoginPage TabonWagesDocuments() throws InterruptedException {

                                TabDocumentWages.click();
                                System.out.println("Document Wages clicked");
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());

                }

                public MAPLoginPage Wages() throws InterruptedException {
                                Wages.click();
                                Thread.sleep(2000);
                                Wages.sendKeys("100");
                                System.out.println("Data entered on Wages Text Box");
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());

                }
                
                public MAPLoginPage WageDocument() throws InterruptedException {
                                WagesDocument.click();
                                Thread.sleep(2000);
                                WagesDocument.sendKeys("Wage Slip");
                                System.out.println("Selecting Wage Slip Text Box");
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());

                }
                
                public MAPLoginPage WageReference() throws InterruptedException {
                                WageReference.click();
                                Thread.sleep(2000);
                                WageReference.sendKeys("ABCD");
                                System.out.println("Selecting Wage Slip Text Box");
                                getAndroidDriver().hideKeyboard();
                                
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());

                }
                
                
                
                
                @FindBy(xpath = "//android.widget.EditText[@index='68']")
                static
                WebElement scrollToElement;
                
                public static void scrollTo(WebDriver driver) {
                                WebElement element = driver.findElement(By.xpath("//android.widget.EditText[@index='68']"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
        scrollToElement.click();
    }
                
                
                public void tap(AndroidElement elementToTap) {
                                   new WebDriverWait(driver, 30)
                                .until(ExpectedConditions.visibilityOf(elementToTap))
                                .click();
                                }
                
                

                public MAPLoginPage Benefits() throws InterruptedException {
                                Benefits.click();
                                Thread.sleep(2000);
                                Benefits.sendKeys("200");
                                System.out.println("Data entered on Benefits Text Box ");
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());

                }

                public MAPLoginPage Pension() throws InterruptedException {
                                Pension.click();
                                Thread.sleep(2000);
                                Pension.sendKeys("300");
                                System.out.println("Data entered on Pension Text Box ");
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());

                }

                public MAPLoginPage Others() throws InterruptedException {
                                Others.click();
                                Thread.sleep(2000);
                                Others.sendKeys("400");
                                System.out.println("Data entered on Others Text Box ");
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());

                }

                
                public MAPLoginPage ListsShow() throws InterruptedException {
                                List<WebElement> list = driver.findElements(By.xpath("//android.view.View[@index='4'])"));
                                System.out.println("Count" + list.size());
                                
                                for(int i=0; i<list.size();i++) 
                                {
                                                System.out.println("Display Text:" + list.get(i).getText());
                                }
                                System.out.println("Data entered on Others Text Box ");
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());

                }
                
                
                public MAPLoginPage WagesScrollDown() throws InterruptedException {
                                wagesdocumentdropdownoption.click();
                                Thread.sleep(1000);

                                Select select1 = new Select(driver.findElement(By.name("document-dropdown")));
                                                                select1.selectByIndex(3);
                                
                                
//                            driver.findElements(By.xpath("//*[@class='android.view.View']")).get(3).click();
//                            Thread.sleep(1000);
//                            // Find element using ClassName property
//                            List<MobileElement> elements = driver.findElements(By.className("android.view.View"));
//                            for (MobileElement element : elements) {
//                                            if (element.getAttribute("text").equals("HMRC Letter")) {
//                                                            element.click();
//                                                            break;
//                                            }
                                

                                // android.view.View[@index=0]
                                // *[@class="className"]
                                // driver.findElement(By.className("android.view.View")).getAttribute("");
                                // driver.findElements(By.xpath("//button[@id='menu_id']/..//li")).get(1).click();
                                //
                                //
                                //
                                // Select select1 = new
                                // Select(driver.findElement(By.className("android.view.View")));
                                // select1.selectByIndex(3);
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());
                }
                
                
                
                public void SearchPageDisplay() {
                                WebElement element = driver.findElement(By.xpath("//android.view.View[@text='HMRC Letter' and @index='3'"));
                                JavascriptExecutor executor = (JavascriptExecutor) driver;
                                executor.executeScript("arguments[0].click();", element);
                                System.out.println("Login Button clicked");
                }

                // wagesdocumentdropdownoption.sendKeys(Keys.ARROW_UP);
                // Thread.sleep(1000);
                // benefitsdocumentdropdownoption.sendKeys(Keys.ARROW_UP);
                // Thread.sleep(1000);
                // benefitsdocumentdropdownoption.sendKeys(Keys.ENTER);
                // Thread.sleep(1000);

                public MAPLoginPage ValueSelection() throws InterruptedException {
                                ValueSelection.click();
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());
                }

                public MAPLoginPage ListOfWagesDropdown() throws InterruptedException {

                                Thread.sleep(10000);
                                List<WebElement> count = driver.findElements(By.className("//android.widget.Spinner"));
                                Thread.sleep(10000);
                                System.out.println(count.size());
                                Thread.sleep(10000);
                                for (WebElement ele : count) {
                                                System.out.println("Values" + ele.getAttribute("innerHTML"));

                                                if (ele.getAttribute("innerHTML").contains("HMRC Letter")) {
                                                                ele.click();
                                                                break;
                                                }
                                }

                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());
                }

                public MAPLoginPage WagesReference() throws InterruptedException {
                                wagesreferenceTextBox.click();
                                Thread.sleep(2000);
                                wagesreferenceTextBox.sendKeys("ABCD");
                                System.out.println("Data entered on Wages Reference Text Box ");
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());

                }

                ///////////////////////////////

                public MAPLoginPage BenefitsScrollDown() throws InterruptedException {
                                // benefitsdocumentdropdownoption.click();
                                Select select1 = new Select(driver.findElement(By.className("//android.widget.Spinner")));
                                select1.selectByIndex(3);
                                // driver.findElement(By.xpath("//android.widget.Spinner[@index='23'")).click();
                                // driver.findElement(By.xpath("//android.widget.Spinner[@text='HMRC
                                // letter'")).click();
                                // benefitsdocumentdropdownoption.sendKeys(Keys.ARROW_DOWN);
                                // benefitsdocumentdropdownoption.sendKeys(Keys.ARROW_DOWN);
                                // benefitsdocumentdropdownoption.sendKeys(Keys.ENTER);
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());
                }

                public MAPLoginPage BenifitsReference() throws InterruptedException {
                                benefitsreferenceTextBox.click();
                                Thread.sleep(2000);
                                benefitsreferenceTextBox.sendKeys("ABCD");
                                System.out.println("Data entered on benefits Reference Text Box ");
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());

                }

                ////////////////////////////////////////

                public MAPLoginPage MouseHover() throws InterruptedException {
                                Actions action = new Actions(driver);
                                WebElement mainMenu = driver
                                                                .findElement(By.xpath("//android.widget.Spinner[@text='All Today's Calls'] and @resource-id='s2']"));
                              action.moveToElement(mainMenu).moveToElement(driver.findElement(By.xpath(""))).click().build().perform();
                                Thread.sleep(5000);
                                return new MAPLoginPage(getAndroidDriver());

                }

                public void MobileApplicationLoggedInButton() {
                                WebElement element = driver
                                                                .findElement(By.xpath("//android.widget.Button[@resource-id='submitCredentials' and @text='LOGIN']"));
                                JavascriptExecutor executor = (JavascriptExecutor) driver;
                                executor.executeScript("arguments[0].click();", element);
                                System.out.println("Login Button clicked");
                }

                public String verifyErrorMsg() {
                                return errorMsg.getText();
                }

                public String verifyErrorMsgOnLoginButton() {
                                return ErrorMsgOnLoginButton.getText();
                }
                
                public MAPLoginPage clickForgotPassword() throws InterruptedException {
                                forgotPassword.click();
                                Thread.sleep(10000);
                                System.out.println("Clicking on Forgot Button");
                                return new MAPLoginPage(getAndroidDriver());
                }
                
                public MAPLoginPage clickForgotPassOK() throws InterruptedException {
                                forgotPasswordOK.click();
                                Thread.sleep(10000);
                                System.out.println("Clicking on OK Button");
                                return new MAPLoginPage(getAndroidDriver());
                }

                public String verifyForgotPassMsg() {
                                String msg1 = forgotPasswordMessage.getText();
                                String msg2 = forgotPasswordMessage.getText();
                                String msg;
                                msg = msg1 + "\n" + msg2;
                                return msg;
                }

                public String ForgotPassMessage() {
                                return forgotPasswordMessage.getText();
                }

                

                public MAPLoginPage clickTerritoryNo(String territoryNo) {
                                getAndroidDriver().findElement(By.xpath("//div[contains(text(),'" + territoryNo + "')]")).click();
                                return new MAPLoginPage(getAndroidDriver());
                }

                
                public MAPLoginPage ForgotPasswordOK() throws InterruptedException {
                                forgotPasswordOK.click();
                                Thread.sleep(10000);
                                System.out.println("Clicking on OK Button");
                                return new MAPLoginPage(getAndroidDriver());
                }
}

/*
* public String verifyTerritoryNo() { Select s1 = new
* Select(selectedTerritory); String
* territory=s1.getFirstSelectedOption().getText(); return territory; }
*/
