package autotest4.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseStep {

    public static WebDriver driver;
    //public Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void before() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");//properties.getProperty("webdriver.chrome.driver"));

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //driver.get(properties.getProperty("app.url"));
        driver.get("https://www.rgs.ru");
    }
    @After
    public void after() {
        driver.quit();
    }
}
