package autotest4.pages;

import autotest4.steps.BaseStep;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KaskoPage extends BasePage{

    public KaskoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public KaskoPage() {
        wait = new WebDriverWait(driver, 5, 1000);
        driver = BaseStep.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='btn btn-brand text-uppercase']")
    private WebElement calcBtn;

    public CalcPage enterCalc(){
        click(calcBtn);
        return new CalcPage(driver);
    }

    public void checkCalc(){
        waiting(calcBtn);
        Assert.assertEquals("Кнопка 'калькулятор' отсутствует!",
                calcBtn.getText(), "КАЛЬКУЛЯТОР КАСКО");
    }

    public void chooseCalc(){
        click(calcBtn);
    }
}
