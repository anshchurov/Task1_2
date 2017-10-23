import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class Task3 extends BaseTest{
    private Map<String, String> pathAndFieldOfCar = new HashMap<String, String>();
    private Map<String, String> pathAndFieldOfDriver = new HashMap<String, String>();

    @Test
    public void kaskoInsuranse() throws Exception {
        driver.get("https://www.rgs.ru/");
        wait = new WebDriverWait(driver, 5, 1000);

        // Выбрать пункт меню - Страхование
        waiting(By.xpath("//A[@href='#'][contains(text(), 'Страхование')]"));
        clickAt(By.xpath("//A[@href='#'][contains(text(), 'Страхование')]"));

        // KACKO
        waiting(By.xpath("//li[@class='adv-analytics-navigation-line3-link']/a[text()='Каско']"));
        clickAt(By.xpath("//li[@class='adv-analytics-navigation-line3-link']/a[text()='Каско']"));

        // калькулятор
        waiting(By.xpath("//a[@class='btn btn-brand text-uppercase']"));
        clickAt(By.xpath("//a[@class='btn btn-brand text-uppercase']"));

        waiting(By.xpath("//div[@class='container container-rgs-app-title']/h1"));

        // наличие текста - Калькулятор каско онлайн
        assertEquals("Калькулятор отсутствует", driver.findElement(By.xpath("//div[@class='container container-rgs-app-title']/h1")).getText(),
                "Калькулятор каско онлайн");

        // создание коллекций для полей
        createFields();

        // заполнение полей авто
        fillCarFields();

        // Проверка введённых полей для авто
        checkingCarFields();

        // Проверка автоматического заполнения полей Коробка (автоматическая) и Модификация (1,6i Active+) (иных совпадений по заданию нету)
        assertTrue(driver.findElement(By.xpath("//input[@name='ko_unique_20']")).getAttribute("data-bind") == "Checked");
        assertTrue(driver.findElement(By.xpath("//input[@name='ko_unique_21']")).getAttribute("data-bind") == "Checked");

        // заполнение полей водителя
        fillDriverFields();

        // Является страхователем
        clickAt(By.xpath("IsOwner"));


        // проверка автозаполнения страхователя
        assertEquals("Автоматическое заполнение неверно!", pathAndFieldOfDriver.get("//input[@data-test-name='FullName'][1]"),
                driver.findElement(By.xpath("//input[@data-test-name='FullName'][2]")));
        assertEquals("Автоматическое заполнение неверно!", pathAndFieldOfDriver.get("//input[@data-test-name='BirthDate'][1]"),
                driver.findElement(By.xpath("//input[@data-test-name='BirthDate'][2]")));

        // заполнение паспортных данных
        fillField(By.xpath("//input[@data-test-name='Passport']"), "1214 153657");

        // Проверка ааедённых полей для водителя
        checkingDriverFields();

        // согласие на обработку перс. данных
        clickAt(By.xpath("//input[@data-test-name='Agreed']"));

        // рассчитать
        clickAt(By.xpath("//input[@data-test-name='NextButton']"));

        // Проверить что появилось сообщение - Подтвердите что вы не робот
        waiting(By.xpath("//h4[@class='modal-title']"));
        assertEquals("Ввод неверен", " Подтвердите, что вы не робот ", driver.findElement(By.xpath("//h4[@class='modal-title']")).getText());

        Thread.sleep(10000);
    }

    private void clickAt(By locator){
        driver.findElement(locator).click();
    }

    public void createFields(){
        pathAndFieldOfCar.put("//input[@data-test-name='ContractRegion']", "Москва и область");
        pathAndFieldOfCar.put("//input[@data-test-name='VehicleModel']", "Mazda 3");
        pathAndFieldOfCar.put("//input[@data-test-name='ProductionYear']", "2017");
        pathAndFieldOfCar.put("//input[@data-test-name='VIN']", "12345678901234567");
        pathAndFieldOfCar.put("//input[@data-test-name='Mileage']", "100000");

        pathAndFieldOfDriver.put("//input[@data-test-name='FullName'][1]", "Человеков Обыкновений Ездячев");
        pathAndFieldOfDriver.put("//input[@data-test-name='BirthDate'][1]", "10.10.1981");
        pathAndFieldOfDriver.put("//input[@data-test-name='DriverLicense']", "0102001259");
        pathAndFieldOfDriver.put("//input[@data-test-name='DrivingExperienceStartDate']", "11.11.1999");
    }

    public void fillCarFields(){
        for(Map.Entry<String, String> entry : pathAndFieldOfCar.entrySet()){
            fillField(By.xpath(entry.getKey()), entry.getValue());
            // симуляция ентер
            // вейт
            // //div[@role='option']/strong[contains(@class, 'tttt')]

        }
        waiting(By.xpath("//input[@name='ko_unique_2']"));
        clickAt(By.xpath("//input[@name='ko_unique_2']"));
    }

    public void fillDriverFields(){
        for(Map.Entry<String, String> entry : pathAndFieldOfDriver.entrySet())
            fillField(By.xpath(entry.getKey()), entry.getValue());
    }

    // метод проверки введёных значений для авто
    private void checkingCarFields(){
        for(Map.Entry<String, String> entry : pathAndFieldOfCar.entrySet())
            assertEquals(entry.getValue(), driver.findElement(By.name(entry.getKey())).getAttribute("value"));
    }

    // метод проверки введёных значений для авто
    private void checkingDriverFields(){
        for(Map.Entry<String, String> entry : pathAndFieldOfDriver.entrySet())
            assertEquals(entry.getValue(), driver.findElement(By.name(entry.getKey())).getAttribute("value"));
        assertEquals(driver.findElement(By.xpath("//input[@data-test-name='Passport']")).getAttribute("value"), "1214 153657");
    }

}
