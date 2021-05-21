package Pages;

import Runner.UtilityMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends UtilityMethods {
    ExcelDB ExcelDb;
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }
    public static WebElement GoToLoginBtn(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='login']"))));
    }

    public static WebElement CreateAccountInput(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='email_create']"))));
    }

    public static WebElement CreateAccountButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@id='SubmitCreate']"))));
    }

    public  WebElement AlreadyRegisteredEmailMsg(){
//        WebDriverWait wait = new WebDriverWait(driver, 10);
        return driver.findElement(By.xpath("//div[@id='create_account_error']"));
    }

    public  WebElement LoginEmail(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='email']"))));
    }

    public  WebElement LoginPassword(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='passwd']"))));
    }

    public  WebElement ComleteLoginButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@id='SubmitLogin']"))));
    }

    public void GotoCreateAccountPage(int TCNumber) throws Exception {
        ExcelDb = new ExcelDB(driver);
        GoToLoginBtn().click();
        CreateAccountInput().sendKeys(ExcelDb.GetDataFromExcel("NewEmail",TCNumber));
        CreateAccountButton().click();
    }

    public void GotoLoginPage(int TCNumber) throws Exception {
        ExcelDb = new ExcelDB(driver);
        GoToLoginBtn().click();
    }



}
