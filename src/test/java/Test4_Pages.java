import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import rules.InsRules;

import java.beans.Expression;
import java.util.HashMap;
import java.util.Map;

public class Test4_Pages {

    @Rule
    public InsRules rule = new InsRules();

@Test
    public void testKasko() throws InterruptedException {
    WebDriver driver = rule.getDriver();

    driver.get("https://www.rgs.ru/");

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
