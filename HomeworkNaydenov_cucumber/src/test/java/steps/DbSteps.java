package steps;


import io.cucumber.java.bg.И;
import page.FoodDB;

public class DbSteps {
    FoodDB foodDB = new FoodDB();
    @И("Отправить SQL запрос на добавление товара")
    public void Отправить_SQL_запрос_на_добавление_товара(){
       foodDB.insertFood("Манго", "FRUIT", 1);
    }

    @И("Отправить SQL запрос для просмотра содержимого таблицы")
    public void Отправить_SQL_для_просмотра_содержимого_тоблицы(){
        foodDB.displayFoodTable();
    }

    @И("Удалить добавленый товар")
    public void Удалить_добавленый_товар(){
        foodDB.deleteFoodByName("Манго");
    }
}
