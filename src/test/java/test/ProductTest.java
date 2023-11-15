package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.Base;
import page.CartPage;
import page.ProductPage;

import java.time.Duration;

public class ProductTest extends Base {

    @Test(priority = 1)
    public void addItemToCartTest() {
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productPage.clickViewCartButton();
        Assert.assertNotNull(productPage.getViewCartLink(), "View Cart link not found.");
    }

    @Test(priority = 2)
    public void updateCartTest(){
        CartPage cartpage = new CartPage(driver);
        cartpage.clickPlusButton(3);
        cartpage.clickUpdateButton();
        int timeoutInSeconds = 20;
        int pollingInterval = 1;
        int expectedQuantity = 4;
        boolean isQuantityUpdated = false;
        for (int i = 0; i < timeoutInSeconds / pollingInterval; i++) {
            int actualQuantity = cartpage.getQuantityValue();
            if (actualQuantity == expectedQuantity) {
                isQuantityUpdated = true;
                break;
            } else {
                try {
                    Thread.sleep(Duration.ofSeconds(pollingInterval).toMillis());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        Assert.assertTrue(isQuantityUpdated, "Actual quantity is not updated as expected.");
    }

}
