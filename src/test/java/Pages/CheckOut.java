package Pages;

import Runner.UtilityMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOut extends UtilityMethods {

    ExcelDB ExcelDb;
    public CheckOut(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement ProceedToCheckout2(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']"))));
    }

    public WebElement ProceedToCheckout3(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@type='submit'][@name='processAddress']"))));
    }

    public WebElement AgreeTerms(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='cgv']"))));
    }

    public WebElement ProceedToCheckout4(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@type='submit'][@name='processCarrier']"))));
    }

    public WebElement PayByBankWire(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='bankwire']"))));
    }


    public WebElement ConfirmOrder(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='form-group']/button[@type='submit']"))));
    }

    public WebElement OrderIsConfirmed(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//strong[text()='Your order on My Store is complete.']"))));
    }
}
