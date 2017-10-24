import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.rules.ExternalResource;

import java.util.concurrent.TimeUnit;

public class RuleAllTest extends ExternalResource {

    private WebDriver driver;

    RuleAllTest(WebDriver driver){
        this.driver = driver;
    }

    public void before() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

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
