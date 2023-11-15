package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.Base;
import page.ProductPage;
import page.StorePage;

public class ManufacturerTest extends Base {
    @Test(priority = 1)
    public void checkManufacturerTest()
    {
        ProductPage productPage = new ProductPage(driver);
        productPage.clickSelectProfessionalSuitOption();
        StorePage storePage=new StorePage(driver);
        Assert.assertTrue(storePage.clickingManufacturer(), "The manufacturer link opens an error page");
    }
}
