package pageobjects.cap;

 

import java.util.List;

import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

 

import utilities.ExcelUtilities;

 

public class SearchCustomer {

 

                WebDriver driver;

    WebDriverWait wait;

 

                public SearchCustomer(WebDriver driver)

                {

        this.driver = driver;

        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        wait = new WebDriverWait(this.driver, 15);

                                //PageFactory.initElements( driver, this);

                                PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);

                }

 

                @FindBy(linkText="Customer")

                public WebElement Customer;

               

                @FindBy(linkText="Staff")

                public WebElement Staff;

 

    @FindBy(xpath="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/b")

                public WebElement SearchCustomer;

 

               

                @FindBy(linkText="Search Customer")

                public WebElement CustSearch;

               

                @FindBy(id="filterCustomerBean.customerID")

                public WebElement CustID;

               

                @FindBy(id="filterCustomerBean.firstName")

                public WebElement CustFirstName;

               

                @FindBy(id="filterCustomerBean.lastName")

                public WebElement CustSurname;

               

                @FindBy(id="filterCustomerBean.addressBean.postCode")

                public WebElement CustPostCode;

               

                @FindBy(id="filterCustomerBean.niNumber")

                public WebElement CustNINumber;

               

                @FindBy(id="filterCustomerBean.businessUnitName")

                public WebElement CustTerritoryName;

               

                @FindBy(id="filterCustomerBean.paymentCardNo")

                public WebElement PaymentCard;

               

                @FindBy(id="filterCustomerBean.liveOnly")

                public WebElement LiveOnlyCheckbox;

               

                @FindBy(id="filterCustomerBean.addressBean.flatNo")

                public WebElement FlatNumber;

               

                @FindBy(id="filterCustomerBean.addressBean.houseNo")

                public WebElement HouseNo;

               

                @FindBy(id="filterCustomerBean.addressBean.address1")

                public WebElement HouseName;

               

                @FindBy(id="filterCustomerBean.addressBean.address2")

                public WebElement StreetName;

               

                @FindBy(id="filterCustomerBean.addressBean.town")

                public WebElement Town_City;

               

                @FindBy(linkText="Search")

                public WebElement SearchButton;

               

                @FindBy(linkText="New Search")

                public WebElement NewSearch;

               

                @FindBy(xpath="//td[contains(text(),'Live')]")

                public WebElement Status;

                String a = ExcelUtilities.getKeyValueFromExcelWithPosition("TestCaseData.xlsx", "CustomerSearch", "2", 1);

//            @FindBy(xpath="//a[contains(text(),'17729669')]")

                @FindBy(xpath="//a[contains(text(),'17')]")

                public WebElement CustIDlink;

               

               

                @FindBy(linkText="Transactions")

                public WebElement CustSearchTrxn;

               

                @FindBy(name="productTypeId")

                public WebElement ProductType;

               

                @FindBy(xpath="//select[@name='custPaymentBean.paymentType']")

                public WebElement PaymentType;

               

                @FindBy(name="productId1")

                public WebElement Product;

               

                @FindBy(name="saleValue1")

                public WebElement SetValue;

               

                @FindBy(name="accountBean.agreeFormNo1")

                public WebElement AggNum;

               

               

                @FindBy(id="btnCredit")

                public WebElement ConfirmSale;

               

                @FindBy(id="error")

                public WebElement ResultMsg;

               

                @FindBy(xpath="//a[contains(@href,'javascript:doViewEvent('C51327FF-0D61-1B32-3E6A-35B48E7F0616')']")

                public WebElement LogNotesMsg;

               

                //@FindBy(id="result-message")

                @FindBy(xpath="//span[@class='error']")

                public WebElement PaymentErrorMsg;

               

               

               

                @FindBy(xpath="//div[@class='error']/b")

                public WebElement DeclinedErrorMsg;

               

               

                @FindBy(css="#0000ff")

                public WebElement ResultSuccessMsg;

               

                @FindBy(id="spanButton")

                public WebElement Save;

               

                @FindBy(xpath="//td[contains(text(),'Closed')]")

                public WebElement Statusresult;

               

                @FindBy(xpath="//a[starts-with(text(),'17')]")

                public WebElement CusIDClink;

               

                @FindBy(xpath="//td[contains(@class,'selected') and contains(text(),'Summary')]")

                public WebElement ScreenDetailSummary;

               

               

                @FindBy(className="//a[(@class,'buttontop']")

                public List<WebElement> ScreenDetail;

               

               

               

                ////////Implementation///////////////////////////////////

               

                public String getResultMsg() {

                                return ResultSuccessMsg.getText();

                }

               

               

                public SearchCustomer Customer() {

                                Customer.click();

                                return new SearchCustomer(driver);

                }

                public SearchCustomer Staff() {

                                Staff.click();

                                return new SearchCustomer(driver);

                }

                public String SCust() {

                                return SearchCustomer.getText();

                }

               

                public SearchCustomer setCID(String tcustID) {

                                CustID.sendKeys(tcustID);

                                return new SearchCustomer(driver);

                               

                }

               

                public SearchCustomer setFN(String firstname) {

                                CustFirstName.sendKeys(firstname);

                                return new SearchCustomer(driver);

                               

                }

               

                public SearchCustomer setSN(String Lastname) {

                                CustSurname.sendKeys(Lastname);

                                return new SearchCustomer(driver);

                               

                }

                public SearchCustomer setPC(String postcode) {

                                CustPostCode.sendKeys(postcode);

                                return new SearchCustomer(driver);

                               

                }

                public SearchCustomer setNIN(String NIN) {

                                CustNINumber.sendKeys(NIN);

                                return new SearchCustomer(driver);

                               

                }

                public SearchCustomer setTN(String TerritoryName) {

                                CustTerritoryName.sendKeys(TerritoryName);

                                return new SearchCustomer(driver);

                               

                }

                public SearchCustomer setPaymentCardNo(String CardNo) {

                                PaymentCard.sendKeys(CardNo);

                                return new SearchCustomer(driver);

                               

                }

               

                public SearchCustomer LiveCheckbox() {

                                LiveOnlyCheckbox.click();

                                return new SearchCustomer(driver);

                }

                public SearchCustomer setFlat(String FlatNo) {

                                FlatNumber.sendKeys(FlatNo);

                                return new SearchCustomer(driver);

                               

                }

               

                public SearchCustomer setHN(String Houseno) {

                                HouseNo.sendKeys(Houseno);

                                return new SearchCustomer(driver);

                               

                }

               

                public SearchCustomer setHname(String HName) {

                                HouseName.sendKeys(HName);

                                return new SearchCustomer(driver);

                }             

               

                public SearchCustomer setStreetname(String Stname) {

                                StreetName.sendKeys(Stname);

                                return new SearchCustomer(driver);

                               

                }

                public SearchCustomer setTC(String Town) {

                                Town_City.sendKeys(Town);

                                return new SearchCustomer(driver);

                               

                }

               

               

                public SearchCustomer Search() {

                                SearchButton.click();

                                return new SearchCustomer(driver);

                }

               

                public String NSearch() {

                                return NewSearch.getText();

                }

               

                public String result() {

                                return Status.getText();

                }

               

                public SearchCustomer CustIDtransaction() {

                                CustIDlink.click();

                                return new SearchCustomer(driver);

                }

               

               

                public SearchCustomer CustSearchTransaction() {

                                CustSearchTrxn.click();

                                return new SearchCustomer(driver);

                }

               

                public SearchCustomer SelectProductType() {

 

                                ProductType.click();

                                ProductType.sendKeys(Keys.ARROW_DOWN);

                                ProductType.sendKeys(Keys.ARROW_DOWN);

                                //ProductType.sendKeys(Keys.ARROW_DOWN);

                                ProductType.sendKeys(Keys.ENTER);

                                return new SearchCustomer(driver);

 

                }

               

                public SearchCustomer setProduct(String product) {

                                Product.sendKeys(product);

                                return new SearchCustomer(driver);

                               

                }

               

                public SearchCustomer setValue(String sv) {

                                SetValue.sendKeys(sv);

                                return new SearchCustomer(driver);

                               

                }

               

                public SearchCustomer setaggnum_old(String aggnum) {

                                AggNum.sendKeys(aggnum);

                                return new SearchCustomer(driver);

                               

                }

                public SearchCustomer setaggnum() {

                                String aggnum;

                                long b =System.currentTimeMillis();

                                String h = String.valueOf(b);

                                //System.out.println("kkkkkkk"+h);

                                int index = 5;

                                char[] chs = h.toCharArray();

                                //String part1 = new String(chs, 0, index);

                                aggnum = new String(chs, index, chs.length - index);

                                //System.out.println("part2  "+aggnum);

                                //System.out.println("part2length   "+aggnum.length());

                                AggNum.sendKeys(aggnum);

                                return new SearchCustomer(driver);

                               

                }

               

                public SearchCustomer ConfirmSale() {

                                ConfirmSale.click();

                                return new SearchCustomer(driver);

                }

               

                public String resultmessege() {

                                return DeclinedErrorMsg.getText();

                }

               

                public String LogNotesMsg() {

                                return LogNotesMsg.getText();

                }

               

               

                public String Printresultmessege() {

                                return PaymentErrorMsg.getText();

                }

               

                public String DeclinedErrorMsg() {

                                return DeclinedErrorMsg.getText();

                }

               

 

               

                public SearchCustomer Save() {

                                Save.click();

                                return new SearchCustomer(driver);

                }

                public String Statusresult() {

                                return Statusresult.getText();

                }

               

                public SearchCustomer cusIDclick() {

                                CusIDClink.click();

                                return new SearchCustomer(driver);

                }

               

                public SearchCustomer cusIDclicklink() {

                                String id = driver.findElement(By.xpath("/HTML/BODY/FORM[1]/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[3]/TD[2]/TABLE/TBODY/TR[2]/TD[1]")).getText();

                                System.out.println("id"+id);

                                driver.findElement(By.xpath("//a[contains(text(),'"+id+"')]")).click();

                                //CusIDClink.click();

                                return new SearchCustomer(driver);

                }

                public String ScreenDetailSumm() {

                               

                                return ScreenDetailSummary.getText();

                }

 

                public List<WebElement> getAllData() {

        return ScreenDetail;

    }

               

                public String getPageTitle()

                {

                                return driver.getTitle();

                }

               

    public Boolean isCustomerIDSearched(String strCustomerID) {

                               

                                return driver.findElement(By.xpath("//a[contains(text(),'"+strCustomerID+"')]")).isDisplayed();

                               

                }

               

                public String getBusinessUnit(String strCustomerID) {

                               

                                return driver.findElement(By.xpath("//a[contains(text(),'"+strCustomerID+"')]/../../td[8]")).getText();

                               

                }

               

                /*

                * clickOnCustomerID(String strCustomerID) : This method is used click on Searched Customer ID Link

                */

    public SearchCustomerTransaction clickOnCustomerID(String strCustomerID) {

                               

                                driver.findElement(By.xpath("//a[contains(text(),'"+strCustomerID+"')]")).click();

                                return new SearchCustomerTransaction(driver);

                }

   

    public String PaymentType()

                {

                                return driver.getTitle();

                }

               

}