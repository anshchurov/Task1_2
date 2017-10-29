package autotest4.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    KaskoSteps kaskoSteps = new KaskoSteps();
    CalcSteps calcSteps = new CalcSteps();

    @When("^Выбрано страхование$")
    public void selectInsuranse(){
        mainSteps.selectInsurance();
    }

    @When("^Выбрано КАСКО$")
    public void selectKasko(){
        mainSteps.selectKasko();
    }

    @Then("^Кнопка присутствует$")
    public void checkCalcBtn(){
        kaskoSteps.checkCalc();
    }

    @When("^Нажать на 'Калькулятор КАСКО'$")
    public void clickAtKASKO(){
        kaskoSteps.chooseCalc();
    }

    @When("^Заполняются поля:$")
    public void fillFrom(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> calcSteps.fillField(field, value));
    }

    @Then("^Значения полей равны:$")
    public void checkfillFrom(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> calcSteps.checkCurrentField(field, value));
    }

    @When("^Согласиться на обработку персональных данных$")
    public void applyPersDataProc(){
        calcSteps.pressAgree();
    }

    @When("Нажать на Рассчиатть КАСКО")
    public void calcKasko(){
        calcSteps.calcKasko();
    }

    @When("Проверка ошибки заполнения")
    public void checkError(){
        calcSteps.checkError();
    }

}
