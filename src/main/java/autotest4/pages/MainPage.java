package autotest4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//A[@href='#'][contains(text(), 'Страхование')]")
    private WebElement dataToggleInsuranse;

    @FindBy(xpath = "//li[@class='adv-analytics-navigation-line3-link']/a[text()='Каско']")
    private WebElement kaskoInsurance;

    public KaskoPage openKasko(){
        wait = new WebDriverWait(driver, 5, 1000);
        click(dataToggleInsuranse);
        click(kaskoInsurance);
        return new KaskoPage(driver);
    }
}
