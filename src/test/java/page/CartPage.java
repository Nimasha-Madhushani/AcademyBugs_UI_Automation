package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    By quantityInputLocator = By.xpath("/html/body/div[3]/div/div/div[1]/main/article/div/section/div[3]/table/tbody/tr[3]/td[5]/table/tbody/tr[1]/td[2]/input");

    By plusButton = By.cssSelector("input[type='button'].ec_plus");

    By updateButton=By.cssSelector("[id*='ec_cartitem_update_']");

    By shippingLocator = By.xpath("//div[@class='ec_cart_price_row_total' and @id='ec_cart_shipping']");

    By subtotalLocator = By.xpath("//*[@id=\"ec_cart_subtotal\"]");

    By grandTotalOfCart = By.xpath("//*[@id=\"ec_cart_total\"]");

    public CartPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickPlusButton(int itemCount){
        wait.until(ExpectedConditions.visibilityOfElementLocated(plusButton));
        for (int i=0;i<itemCount;i++){
            driver.findElement(plusButton).click();
        }
    }

    public void clickUpdateButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(updateButton));
        driver.findElement(updateButton).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public int getQuantityValue() {

        wait.until(ExpectedConditions.presenceOfElementLocated(quantityInputLocator));
        String quantity = driver.findElement(quantityInputLocator).getAttribute("value");
        System.out.println(quantity);
        if (!quantity.isEmpty()) {
            String onlyNumbers = quantity.replaceAll("[^0-9]", "");
            if (!onlyNumbers.isEmpty()) {
                int actualQuantityInCart = Integer.parseInt(onlyNumbers);
                return actualQuantityInCart;
            }
        }
        return -1;
    }

    public double calculateCartTotal(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(subtotalLocator));
        WebElement subtotalElement = driver.findElement(subtotalLocator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(shippingLocator));
        WebElement shippingElement = driver.findElement(shippingLocator);
        double subtotalOfMyCart = parsePrice(subtotalElement.getText());
        double shippingCost = parsePrice(shippingElement.getText());
        return subtotalOfMyCart + shippingCost;
    }
    private double parsePrice(String priceText) {
        priceText = priceText.replaceAll("[^0-9.]", "");
        return Double.parseDouble(priceText);
    }
    public double getCartGrandTotal(){
        WebElement totalCostElement = driver.findElement(grandTotalOfCart);
        String total = totalCostElement.getText();
        total = total.replaceAll("[^0-9.]", "");
        double CartTotal = Double.parseDouble(total);

        return CartTotal;
    }
}
