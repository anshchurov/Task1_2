package autotest4.steps;

import autotest4.pages.KaskoPage;
import ru.yandex.qatools.allure.annotations.Step;

public class KaskoSteps extends BaseStep {

    @Step("Проверить наличие кнопки калькулятор")
    public void checkCalc(){
        checkCalc();
    }

    @Step("Нажать на 'Калькулятор'")
    public void chooseCalc(){
        new KaskoPage().chooseCalc();
    }
}
