package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.Base;
import page.CartPage;
import page.ProductPage;

public class CartTest extends Base {

    @Test(priority = 1)
    public void checkGrandTotal() {
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        productPage.clickViewCartButton();
        CartPage cartpage = new CartPage(driver);
        double expectedGrandTotal = cartpage.calculateCartTotal();
        Assert.assertEquals(cartpage.getCartGrandTotal() , expectedGrandTotal ,
                "Grand total in the cart and Actual total value of cart are not matched");
    }
}