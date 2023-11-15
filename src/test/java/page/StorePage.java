package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StorePage {
    WebDriver driver;

    WebDriverWait wait;
    public StorePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    By selectYellowColor=By.xpath("//img[@src='https://support.wpeasycart.com/sampledata/v4/products/swatches/yellow.jpg' and @title='Yelow']");

    By clickTwitterButton=By.xpath("//img[@alt='Twitter']");

    public void clickOnYellowSquare(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectYellowColor));
        driver.findElement(selectYellowColor).click();
    }

    public String checkYellowColorSpelling() {
        WebElement yellowColorElement = driver.findElement(By.xpath("//div[contains(@class, 'ec_details_option_label_selected') and text()='Yelow']\n"));
        String yellowColorText = yellowColorElement.getText();
        return yellowColorText;
    }

    public boolean sortItems() {
       String currentWebPageTitle= driver.getTitle();
       By priceSortOption = By.cssSelector("a.menu_link.academy-store-menu-link[href='https://academybugs.com/store/denim-coat/?&perpage=25&pricepoint=7']");
       wait.until(ExpectedConditions.visibilityOfElementLocated(priceSortOption));
       driver.findElement(priceSortOption).click();
       String webPageTitleAfterSorting = driver.getTitle();
       boolean isReloaded = currentWebPageTitle.equals(webPageTitleAfterSorting);
       return isReloaded;
    }

    public boolean clickingManufacturer() {
        ApiEndPoints apiEndPoints=new ApiEndPoints();
        String pageUrl=apiEndPoints.baseUrl;
        String regex = "https://(.*?)\\.com/";
        Pattern pattern = Pattern.compile(regex);
        Matcher checkCurrentDomainUrl = pattern.matcher(pageUrl);
        By clickManufacturer=By.xpath("//*[@id=\"manufacturer-bug\"]/a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickManufacturer));
        driver.findElement(clickManufacturer).click();
        String newPageUrl=driver.getCurrentUrl();
        Matcher checkNavigatedPageDomainUrl = pattern.matcher(newPageUrl);
        boolean isDomainEqual=true;
        if(checkCurrentDomainUrl!=checkNavigatedPageDomainUrl){
            isDomainEqual=false;
        }
        return isDomainEqual;
    }

    public boolean clickTwitterButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickTwitterButton));
        driver.findElement(clickTwitterButton).click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
        }
        return isValidTwitterURL(driver.getCurrentUrl());
    }

    public boolean isValidTwitterURL(String urlString) {
        String urlPattern = "^(https?|ftp)://[A-Za-z0-9.-]+(:[0-9]+)?(/[A-Za-z0-9_.-]+)*(/)?$";
        Pattern pattern = Pattern.compile(urlPattern);
        Matcher matcher = pattern.matcher(urlString);
        return matcher.matches();
    }
}
