package Runner;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Selenium_RunTest extends UtilityMethods {
    public static String TCsFile = "Test_data.xlsx";

    ExcelDB ExcelDb;
    LandingPage landingPage;
    CreateAccountPage createAccountPage;
    HomePage homePage;
    CheckOut checkOut;
    int CountTC;



    @Test(priority = 1)
    public void GetIterations() throws Exception {

        ExcelDb = new ExcelDB(driver);
        CountTC = ExcelDb.NumOfTestCases();
        System.out.println("Total Number of TCs: " + CountTC);

    }

    @Test(priority = 2)
    public void Registeration() throws Exception{
        ExcelDb = new ExcelDB(driver);
        landingPage = new LandingPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        init(BrowserEnum.Firefox);


        landingPage.GotoCreateAccountPage(1);
        Thread.sleep(500);
        Assert.assertFalse(landingPage.AlreadyRegisteredEmailMsg().isDisplayed(),"Email already registered");
        createAccountPage.selectGender("Mr").click();
        createAccountPage.firstName().sendKeys(ExcelDb.GetDataFromExcel("firstName",1));
        createAccountPage.lastName().sendKeys(ExcelDb.GetDataFromExcel("lastName",1));
        createAccountPage.password().sendKeys(ExcelDb.GetDataFromExcel("password",1));
        createAccountPage.Address().sendKeys(ExcelDb.GetDataFromExcel("Address",1));
        createAccountPage.City().sendKeys(ExcelDb.GetDataFromExcel("City",1));
        createAccountPage.State().selectByVisibleText(ExcelDb.GetDataFromExcel("State",1));
        createAccountPage.PostCode().sendKeys(ExcelDb.GetDataFromExcel("PostCode",1));
        createAccountPage.Country().selectByVisibleText(ExcelDb.GetDataFromExcel("Country",1));
        createAccountPage.MobilePhone().sendKeys(ExcelDb.GetDataFromExcel("MobilePhone",1));
        createAccountPage.AddressAlias().clear();
        createAccountPage.AddressAlias().sendKeys(ExcelDb.GetDataFromExcel("AddressAlias",1));
        createAccountPage.RigisterButton().click();
        Assert.assertTrue(createAccountPage.LogOutButton().isDisplayed(),"Registeration isn't completed");
//        driver.quit();
    }


//    @Test(priority = 3)
    public void Login() throws Exception {
        ExcelDb = new ExcelDB(driver);
        landingPage = new LandingPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        init(BrowserEnum.Firefox);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        landingPage.GotoLoginPage(1);
        landingPage.LoginEmail().sendKeys(ExcelDb.GetDataFromExcel("LoginEmail",1));
        landingPage.LoginPassword().sendKeys(ExcelDb.GetDataFromExcel("LoginPassword",1));
        landingPage.ComleteLoginButton().click();
        wait.until(ExpectedConditions.invisibilityOf(landingPage.ComleteLoginButton()));
        Assert.assertTrue(createAccountPage.LogOutButton().isDisplayed(), "Login failed, please review your inputs");


    }

//    @Test(priority = 4)
    public void SearchForProduct_AddToCart() throws Exception {
        ExcelDb = new ExcelDB(driver);
        homePage = new HomePage(driver);
        homePage.SearchFor(ExcelDb.GetDataFromExcel("SearchFor",1));
        homePage.SearchResult().click();
        homePage.AddToCart().click();
        homePage.ProceedToCheckout().click();

    }

//    @Test(priority = 5)
    public void CartCheckOut() throws Exception {
        ExcelDb = new ExcelDB(driver);
        checkOut = new CheckOut(driver);
        checkOut.ProceedToCheckout2().click();
        checkOut.ProceedToCheckout3().click();
        checkOut.AgreeTerms().click();
        checkOut.ProceedToCheckout4().click();
        checkOut.PayByBankWire().click();
        checkOut.ConfirmOrder().click();
        Assert.assertTrue(checkOut.OrderIsConfirmed().isDisplayed());

    }

//    @Test(priority = 6)
    public void TearDown(){
        driver.quit();
    }


}
