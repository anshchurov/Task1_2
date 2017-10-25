import autotest4.TestProperties;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import autotest4.pages.MainPage;
import autotest4.rules.InsRules;

import java.util.Properties;

public class Test4_Pages {

    public static Properties properties = TestProperties.getInstance().getProperties();

    @Rule
    public InsRules rule = new InsRules();

    @Test
    public void testKasko() throws InterruptedException {
    WebDriver driver = rule.getDriver();

    driver.get(properties.getProperty("app.url"));

    MainPage main = new MainPage(driver);
    main.openKasko()
            .enterCalc()
            .fillCarFields()
            .checkCarFields()
            .fillDriverFields()
            .checkDriverFields()
            .lastSteps();

}

}
