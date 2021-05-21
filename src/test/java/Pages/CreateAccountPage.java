package Pages;

import Runner.UtilityMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

public class CreateAccountPage extends UtilityMethods {
    ExcelDB ExcelDb;
    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public  WebElement selectGender(String gender){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        if (gender.toLowerCase() == "mr") {
            return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"))));
        }else {
            return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='uniform-id_gender2']"))));
        }
    }

    public WebElement firstName(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='customer_firstname']"))));
    }

    public WebElement lastName(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='customer_lastname']"))));
    }

    public WebElement password(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='passwd']"))));
    }

    public WebElement FirstNameAddress(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='firstname']"))));
    }

    public WebElement LastNameAddress(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='lastname']"))));
    }

    public WebElement Address(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='address1']"))));
    }

    public WebElement City(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='city']"))));
    }

    public Select State(){
//        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement State = driver.findElement(By.id("id_state"));
        Select drpState = new Select(State);
        return drpState;
    }

    public WebElement PostCode(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='postcode']"))));
    }

    public Select Country(){
//        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement Country = driver.findElement(By.xpath("//select[@id='id_country']"));
        Select drpCountry = new Select(Country);
        return drpCountry;
    }

    public WebElement MobilePhone(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='phone_mobile']"))));
    }

    public WebElement AddressAlias(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='alias']"))));
    }

    public WebElement RigisterButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@id='submitAccount']"))));
    }

    public WebElement LogOutButton(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Log me out']"))));
    }
}
