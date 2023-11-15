package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
   public static WebDriver driver;
   ApiEndPoints addApiEndpoint=new ApiEndPoints();
   String url= addApiEndpoint.getFindBugsEndPoint();


    @BeforeClass
    public void setUp(ITestContext context) {
        System.getProperty("webdriver.chrome.driver","src/drivers/chrome.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        context.setAttribute("WebDriver",driver);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
