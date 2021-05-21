package Pages;

import Runner.UtilityMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends UtilityMethods {

    ExcelDB ExcelDb;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void SearchFor(String SearchForWhat){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='search_query_top']")))).sendKeys(SearchForWhat);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@name='submit_search']")))).click();

    }

    public WebElement SearchResult(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='product-image-container']"))));
    }

    public WebElement AddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='box-cart-bottom']/div/p"))));
    }


    public WebElement ProceedToCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Proceed to checkout']"))));
    }


}
