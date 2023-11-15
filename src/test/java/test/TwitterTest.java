package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.Base;
import page.ProductPage;
import page.StorePage;

public class TwitterTest extends Base {
    @Test(priority = 1)
    public void clickTwitterButtonTest(){
        ProductPage productPage=new ProductPage(driver);
        StorePage storePage=new StorePage(driver);
        productPage.clickSelectDenimOption();
        Assert.assertTrue(storePage.clickTwitterButton(), "The twitter share button shows an error page");

    }
}
