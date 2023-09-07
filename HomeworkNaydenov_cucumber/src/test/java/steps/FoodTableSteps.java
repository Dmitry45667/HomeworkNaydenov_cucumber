package steps;

import config.Configs;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import page.ProductPage;

import java.util.List;
import java.util.Map;


public class FoodTableSteps {

    ProductPage productPage = new ProductPage(Hooks.driver);


    @И("нажимаю кнопку Добавить")
    public void нажимаю_кнопку_добавить() {
        productPage.pressAddButton();
    }


    @И("ввожу наименование продукта {string}")
    public void ввожу_наименование_продукта(String наименование) {

        productPage.enterGoodName(наименование);
    }

    @И("выбираю тип {string}")
    public void выбираю_тип(String тип) {

        productPage.selectGoodType(тип);
    }

    @И("заполняю поля наименование и тип")
    public void заполняю_поля_Наименование_и_Тип(DataTable table) {


        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        String name = data.get(0).get("наименование");
        String type = data.get(0).get("тип");

        productPage.enterGoodName(name).selectGoodType(type);
    }

    @И("активирую чекбокс «Экзотический»")
    public void активирию_чекбокс() {

        productPage.activeExoticCheckBox();
    }

    @И("нажимаю кнопку Сохранить")
    public void нажимаю_кнопку_Сохранить() {

        productPage.pressSaveBtn();
    }

    @И("добавленный продукт {string} с типом {string} и экзотичностью {string} отображается в таблице")
    public void добавленныйПродуктДолженОтображатьсяВТаблице(String наименование, String тип, String экзотичность) {

        productPage.checkGoodAdd(наименование, тип, экзотичность);
    }

    @И("добавленный продукт отображается в таблице со следующими параметрами")
    public void добавленный_продукт_отображается_в_таблице_со_следующими_параметрами(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        String goodName = rows.get(0).get("наименование");
        String goodType = rows.get(0).get("тип");
        String Exotic = rows.get(0).get("экзотический");

        productPage.checkGoodAdd(goodName, goodType, Exotic);
    }
}