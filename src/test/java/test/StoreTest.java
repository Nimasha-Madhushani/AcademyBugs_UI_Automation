package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.Base;
import page.ProductPage;
import page.StorePage;

public class StoreTest extends Base {
    @Test(priority = 1)
    public void selectOptionAddToCartTest() {
        ProductPage productPage = new ProductPage(driver);
        productPage.clickSelectDenimOption();
    }
    @Test(priority = 2)
    public void selectColorOptionTest()
    {
        StorePage storePage = new StorePage(driver);
        storePage.clickOnYellowSquare();
        String expectedYellowColor = "Yellow";
        Assert.assertEquals(storePage.checkYellowColorSpelling(), expectedYellowColor, "Yellow color is misspelled.");
    }

    @Test(priority = 3)
    public void sortItemsTest(){
        StorePage storePage=new StorePage(driver);
        Assert.assertFalse(storePage.sortItems(), "Sorting by price resulted in a page reload.");
    }

}
