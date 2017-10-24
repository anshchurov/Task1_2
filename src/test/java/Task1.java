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

public class Task1 extends BaseTest{
    private Map<String, String> pathAndField = new HashMap<String, String>();

    @Rule
    public RuleAllTest ruleForEach = new RuleAllTest(driver);

    @Test
    public void insuranceTask() throws Exception {
        driver = ruleForEach.getDriver();
        baseUrl = "http://www.sberbank.ru/ru/person/";
        driver.get(baseUrl + "/");
        wait = new WebDriverWait(driver, 5, 1000);
        driver.findElement(By.xpath("(//span[contains(text(), 'Застраховать себя')])[1]")).click();

        waiting(By.xpath("//a[contains(text(), 'Страхование путешественников')]"));
        driver.findElement(By.xpath("//a[contains(text(), 'Страхование путешественников')]")).click();

        // Проверка правильности титульника
        assertEquals(String.format("Заголовок не равен ожидаемому значению - «Сбербанк» - Страхование путешественников. Получен значение %s", driver.getTitle()),
                driver.getTitle(), "«Сбербанк» - Страхование путешественников");

        // Переходим на новую вкладку
        driver.get(driver.findElement(By.xpath("(//a[@target='_blank'])[1]")).getAttribute("href"));

        waiting(By.xpath("(//div[@class='b-form-prog-box'])[1]"));
        driver.findElement(By.xpath("(//div[@class='b-form-prog-box'])[1]")).click();
        driver.findElement(By.xpath("//span[@class='b-continue-btn']")).click();

        // заполняем поля
        createFieldValues();
        driver.findElement(By.xpath("//input[@name='female']")).click();

        // проверяем правильность ввода
        checkingFields();
        assertEquals("1", driver.findElement(By.xpath("//input[@name='female']")).getAttribute("value"));

        // нажимает проверить и изем сообщение об ошибке
        driver.findElement(By.xpath("//span[@class='b-continue-btn']")).click();
        assertEquals("Поля заполнены правильно! 0_о", "Заполнены не все обязательные поля", driver.findElement(By.xpath("//DIV[@ng-show='tryNext && myForm.$invalid']")).getText());


    }






    // метод для создания коллекции name - value
    private void createFieldValues(){
        pathAndField.put("insured0_surname", "AName");
        pathAndField.put("insured0_name", "BBB");
        pathAndField.put("insured0_birthDate", "19.07.1999");
        pathAndField.put("surname", "Йцукен");
        pathAndField.put("name", "Фывап");
        pathAndField.put("middlename", "Вапрол");
        pathAndField.put("birthDate", "19.10.1990");
        pathAndField.put("passport_series", "1123");
        pathAndField.put("passport_number", "456987");
        pathAndField.put("issueDate", "01.01.2014");
        pathAndField.put("issuePlace", "Ghkjhdcfvulhv");



        for (Map.Entry<String, String> entry : pathAndField.entrySet())
            fillField(By.name(entry.getKey()), entry.getValue());

    }

    // метод проверки введёных значений
    private void checkingFields(){

        for(Map.Entry<String, String> entry : pathAndField.entrySet())
            assertEquals(entry.getValue(), driver.findElement(By.name(entry.getKey())).getAttribute("value"));


    }
}
