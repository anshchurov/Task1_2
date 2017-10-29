package autotest4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class BasePage {


    public static WebDriver driver;
    public static Wait<WebDriver> wait;

    public static WebDriver getDriver() {
        return driver;
    }

    public void waiting(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    protected void fillField(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    protected void click(WebElement element){
        waiting(element);
        element.click();
    }

    protected void checkField(WebElement element, String text){
        String expectedText = element.getText();
        if (expectedText.equals("")){
            expectedText = element.getAttribute("value");
        }
        assertEquals(String.format("В поле %s наодится %s, а не %s",element.getLocation(), expectedText, text),
                expectedText, text);
    }

    protected void checkAttribute(WebElement element, String attr, String text){
        assertTrue(String.format("Поле %s поломалось",element.getLocation()),
                element.getAttribute(attr).contains(text));
    }


}
