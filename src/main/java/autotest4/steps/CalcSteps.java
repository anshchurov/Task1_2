package autotest4.steps;

import autotest4.pages.CalcPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class CalcSteps {

    @Step("Заполнить {0} поле значением {1}")
    public void fillField(String field, String value) {
        try {
            new CalcPage().fillFields(field, value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Заполнить все поля")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach(this::fillField);
    }

    @Step("Проверить поле {0} на значение {1}")
    public void checkCurrentField(String field, String value){
        try {
            new CalcPage().checkField(field, value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Проверить все поля")
    public void checkAllFields(HashMap<String, String> fields){
        fields.forEach(this::checkCurrentField);
    }

    @Step("Согласиться на обработку перс. данных")
    public void pressAgree(){
        try {
            new CalcPage().pressAgree();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Нажать на Рассчиатть КАСКО")
    public void calcKasko(){
        new CalcPage().calcKasko();
    }

    @Step("Проверка ошибки заполнения")
    public void checkError(){
        new CalcPage().checkErrorMessage();
    }

}
