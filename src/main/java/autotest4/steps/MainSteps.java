package autotest4.steps;

import autotest4.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps {

    @Step("Открыть список страхования")
    public void selectInsurance(){
        new MainPage().selectInsurance();
    }

    @Step("Выбрать КАСКО")
    public void selectKasko(){
        new MainPage().selectKasko();
    }
}
