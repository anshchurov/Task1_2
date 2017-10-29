package autotest4.pages;

import autotest4.steps.BaseStep;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalcPage extends BasePage {

    public CalcPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CalcPage() {

        driver = BaseStep.getDriver();
        PageFactory.initElements(driver, this);
    }

    // check text 'calc online'
    @FindBy(xpath = "//div[@class='container container-rgs-app-title']/h1")
    private WebElement textWithCalcText;

    // info processing agreement
    @FindBy(xpath = "//input[@data-test-name='Agreed']")
    private WebElement agreeIn;

    // calc insurance
    @FindBy(xpath = "(//button[@data-test-name='NextButton'])[1]")
    private WebElement calBtn;

    // not robot text
    @FindBy(xpath = "//h4[@class='modal-title']")
    private WebElement checkingHumanityText;

/*
    //
    @FindBy(xpath = )
    private WebElement ;
*/

    // CAR PART ---------------------------------------------------------

    // region
    @FindBy(xpath = "//input[@data-test-name='ContractRegion']")
    private WebElement regionField;

    // mark of car
    @FindBy(xpath = "//input[@data-test-name='VehicleModel']")
    private WebElement markCarField;

    // year field
    @FindBy(xpath = "//input[@data-test-name='ProductionYear']")
    private WebElement prodYearField;

    // VIN
    @FindBy(xpath = "//input[@data-test-name='VIN']")
    private WebElement vinField;

    // mileage
    @FindBy(xpath = "//input[@data-test-name='Mileage']")
    private WebElement mieageField;

    // list of cars
    @FindBy(xpath = "//input[@data-test-name='VehicleModel']/parent::span/div")
    private WebElement carList;

    // params of car
    @FindBy(xpath = "(//span[@class='text-uppercase'])[1]")
    private WebElement paramsOfCarWindow;

    // V1.6 input
    @FindBy(xpath = "//input[@name='ko_unique_2']/parent::label/span")
    private WebElement v1_6InListIn;

    //input for V1/6 for checking
    @FindBy(xpath = "//input[@name='ko_unique_2']")
    private WebElement v1_engine;
    // input of transmission
    @FindBy(xpath = "//input[@name='ko_unique_20']")
    private WebElement transmissionIn;

    // modification of car
    @FindBy(xpath = "//input[@name='ko_unique_21']")
    private WebElement mod1_6In;


    // MAN PART-----------------------------------------------

    // FIO of car
    @FindBy(xpath = "(//input[@data-test-name='FullName'])[1]")
    private WebElement fioFieldForCar;

    // birth day of car
    @FindBy(xpath = "(//input[@data-test-name='BirthDate'])[1]")
    private WebElement birthDayField;

    // driver license
    @FindBy(xpath = "//input[@data-test-name='DriverLicense']")
    private WebElement driverLicenseField;

    // driving EXP start day
    @FindBy(xpath = "//input[@data-test-name='DrivingExperienceStartDate']")
    private WebElement drivingExpStartDayField;

    // passport
    @FindBy(xpath = "//input[@data-test-name='Passport']")
    private WebElement passportField;

    // is Owner
    @FindBy(xpath = "//input[@data-test-name='IsOwner']")
    private WebElement isOwnerIn;

    // fioIns
    @FindBy(xpath = "(//input[@data-test-name='FullName'])[2]")
    private WebElement fioFieldForCarIns;

    // birthIns
    @FindBy(xpath = "(//input[@data-test-name='BirthDate'])[2]")
    private WebElement birthDayFieldIns;

    public void fillFields(String fieldName, String value) throws InterruptedException {
        switch (fieldName) {
            case "Регион проживания":
                fillField(regionField, value);
                Thread.sleep(500);
                click(prodYearField);
                break;
            case "Марка и модель":
                fillField(markCarField, value);
                wait.until(ExpectedConditions.attributeToBe(
                        carList, "class", "tt-menu tt-open"));
                Thread.sleep(500);
                break;
            case "Год выпуска":
                fillField(prodYearField, value);
                break;
            case "VIN":
                fillField(vinField, value);
                break;
            case "Пробег":
                fillField(mieageField, value);
                break;
            case "Двигатель":
                if (value.equals("1"))
                    click(v1_6InListIn);
                break;
            case "ФИО владельца":
                waiting(fioFieldForCar);
                fillField(fioFieldForCar, value);
                break;
            case "Дата рождения":
                fillField(birthDayField, value);
                break;
            case "Водительское удостоверение":
                fillField(driverLicenseField, value);
                break;
            case "Дата начала стажа":
                fillField(drivingExpStartDayField, value);
                break;
            case "Серия и номер":
                fillField(passportField, value);
                break;
            case "является страхователем":
                if (value.equals("1"))
                    isOwnerIn.click();
                break;
            case "ФИО страхователя":
                fillField(fioFieldForCarIns, "Кто То Непонятный");
                break;
            case "Дата рождения страхователся":
                fillField(birthDayFieldIns, "09.09.1980");
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public String getFieldValue(String fieldName) throws InterruptedException {
        switch (fieldName) {
            case "Регион проживания":
                return regionField.getAttribute("value");
            case "Марка и модель":
                return markCarField.getAttribute("value");
            case "Год выпуска":
                return prodYearField.getAttribute("value");
            case "VIN":
                return vinField.getAttribute("value");
            case "Пробег":
                return mieageField.getAttribute("value");
            case "Двигатель":
                return v1_6InListIn.getText().contains("1.6")
                        ? "1" : "0";
            case "Коробка":
                return transmissionIn.getText().contains("автоматическая")
                        ? "1" : "0";
            case "Модификация":
                return mod1_6In.getText().contains("1.6i Active")
                        ? "checked" : "unchecked";
            case "ФИО владельца":
                return fioFieldForCar.getAttribute("value");
            case "Дата рождения":
                return birthDayField.getAttribute("value");
            case "Водительское удостоверение":
                return driverLicenseField.getAttribute("value");
            case "Дата начала стажа":
                return drivingExpStartDayField.getAttribute("value");
            case "Серия и номер":
                return passportField.getAttribute("value");
            case "является страхователем":
                return isOwnerIn.getAttribute("data-bind").contains("unchecked")
                        ? "0" : "1";
            case "ФИО страхователя":
                return fioFieldForCarIns.getAttribute("value");
            case "Дата рождения страхователся":
                return birthDayFieldIns.getAttribute("value");
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public void checkField(String fieldName, String value) throws InterruptedException {
        assertEquals(String.format("Поле %s заполнено неверно!", fieldName),
                getFieldValue(fieldName), value);
    }

    public void pressAgree() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agreeIn);
        Thread.sleep(500);
        agreeIn.click();
    }

    public void calcKasko() {
        click(calBtn);
    }

    public void checkErrorMessage() {
        waiting(checkingHumanityText);
        checkField(checkingHumanityText, "Подтвердите, что вы не робот");
    }





  /*
    public CalcPage fillCarFields() throws InterruptedException {
        wait = new WebDriverWait(driver, 5, 1000);
        waiting(regionField);
        fillField(regionField, "Москва и область");
        Thread.sleep(500);
        fillField(markCarField, "Mazda 3");
        wait.until(ExpectedConditions.attributeToBe(
                carList, "class", "tt-menu tt-open"));
        Thread.sleep(500);
        fillField(prodYearField, "2017");
        fillField(vinField, "12345678901234567");
        fillField(mieageField, "100000");
        //checking params
        click(v1_6InListIn);
        return this;
    }

    public CalcPage checkCarFields() {
        checkField(regionField, "Москва и область");
        checkField(markCarField, "Mazda 3");
        checkField(prodYearField, "2017");
        checkField(vinField, "12345678901234567");
        checkField(mieageField, "100000");
        checkAttribute(transmissionIn, "data-bind", "checked: checked");
        checkAttribute(mod1_6In, "data-bind", "checked: checked");
        return this;
    }

    public CalcPage fillDriverFields() {
        waiting(fioFieldForCar);
        fillField(fioFieldForCar, "Человеков Обыкновений Ездячев");
        fillField(birthDayField, "10.10.1981");
        fillField(driverLicenseField, "0102 001259");
        fillField(drivingExpStartDayField, "11.11.1999");
        //is insurances
        isOwnerIn.click();
        fillField(passportField, "1214 153657");
        return this;
    }

    public CalcPage checkDriverFields() {
        checkField(fioFieldForCar, "Человеков Обыкновений Ездячев");
        checkField(birthDayField, "10.10.1981");
        checkField(driverLicenseField, "0102 001259");
        checkField(drivingExpStartDayField, "11.11.1999");
        checkField(passportField, "1214 153657");
        checkField(fioFieldForCar, fioFieldForCarIns.getAttribute("value"));
        checkField(birthDayField, birthDayFieldIns.getAttribute("value"));
        return this;
    }

    public CalcPage lastSteps() throws InterruptedException {
        // согласие на обработку перс. данных
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agreeIn);
        Thread.sleep(500);
        agreeIn.click();

        // рассчитать
        click(calBtn);

        // Проверить что появилось сообщение - Подтвердите что вы не робот
        waiting(checkingHumanityText);
        checkField(checkingHumanityText, "Подтвердите, что вы не робот");
        return this;
    }
*/

}
