package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;

   WebDriverWait wait;
    By addToCartLink= By.xpath("//*[@id=\"ec_add_to_cart_4\"]");

    By viewCart=By.xpath("//*[@id=\"ec_product_page\"]/div[2]/a");

    By selectDenimOption=By.xpath("//*[@id=\"ec_product_image_4381370\"]/div[3]/div[2]/span/a");

    By selectFullSuit=By.xpath("//*[@id=\"ec_product_image_4781370\"]/div[3]/div[2]/span/a");

    public ProductPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickAddToCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartLink));
        driver.findElement(addToCartLink).click();
    }

    public void clickViewCartButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCart));
        driver.findElement(viewCart).click();
    }
    public By getViewCartLink(){
        return viewCart;
    }

    public void clickSelectDenimOption(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectDenimOption));
        driver.findElement(selectDenimOption).click();
    }

    public void clickSelectProfessionalSuitOption(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectFullSuit));
        driver.findElement(selectFullSuit).click();
    }

}
