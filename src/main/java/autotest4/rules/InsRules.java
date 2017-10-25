package autotest4.rules;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import autotest4.TestProperties;

public class InsRules extends ExternalResource {

    private WebDriver driver;
    public static Properties properties = TestProperties.getInstance().getProperties();

    public void before() throws Exception {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void after() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
