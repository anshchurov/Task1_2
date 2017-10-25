package autotest4.pages;

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

    @FindBy(xpath = "//a[@class='btn btn-brand text-uppercase']")
    private WebElement calcBtn;

    public CalcPage enterCalc(){
        wait = new WebDriverWait(driver, 5, 1000);
        click(calcBtn);
        return new CalcPage(driver);
    }
}
