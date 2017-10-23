import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task2 extends BaseTest {

    @Test
    public void insuranceTask() throws Exception {
        driver.get(baseUrl + "/");
        wait = new WebDriverWait(driver, 5, 1000);

        // Открытие списка областей
        driver.findElement(By.xpath("(//span[@class='region-list__name'])[1]")).click();

        // Выбор Нижегородской области
        waiting(By.xpath("//A[contains(text(), 'Нижегородская область')]"));
        driver.findElement(By.xpath("//A[contains(text(), 'Нижегородская область')]")).click();

        // Прокрутка до footer объекта на главной странице
        WebElement webElem = driver.findElement(By.xpath("//ul[@class='social__list']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", webElem);

        // Проверка наличия значков соц. сетей
        assertTrue("Иконка facebook отсутствует!", isElementPresent(By.xpath("//span[contains(@class, 'social__icon_type_fb')]")));
        assertTrue("Иконка twitter отсутствует!", isElementPresent(By.xpath("//span[contains(@class, 'social__icon_type_tw')]")));
        assertTrue("Иконка youtube отсутствует!", isElementPresent(By.xpath("//span[contains(@class, 'social__icon_type_yt')]")));
        assertTrue("Иконка instagram отсутствует!", isElementPresent(By.xpath("//span[contains(@class, 'social__icon_type_ins')]")));
        assertTrue("Иконка vk отсутствует!", isElementPresent(By.xpath("//span[contains(@class, 'social__icon_type_vk')]")));
        assertTrue("Иконка ok отсутствует!", isElementPresent(By.xpath("//span[contains(@class, 'social__icon_type_ok')]")));

        System.out.println("COMPLETED");

    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
