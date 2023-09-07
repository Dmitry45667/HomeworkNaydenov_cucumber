package page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class ProductPage {

    ChromeDriver driver;

    By AddBtn = By.xpath("//*[text()='Добавить']");
    By nameInput = By.xpath("//*[@id='name']");
    By goodType = By.xpath("//*[@id='type']");
    By checkBoxExotic = By.xpath("//*[@id='exotic']");
    By saveBtn = By.xpath("//*[@id='save']");

    public ProductPage(ChromeDriver driver) {
        this.driver = driver;
    }


    //Нажимаем кнопку «Добавить»
    public ProductPage pressAddButton() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AddBtn));

        WebElement addButton = driver.findElement(AddBtn);
        addButton.click();

        return this;
    }

    // Вводим наименование товара
    // Проверяем, что введенное наименование отображается в поле «Наименование»
    public ProductPage enterGoodName(String name) {

        WebElement inputName = driver.findElement(nameInput);
        inputName.sendKeys(name);

        Assertions.assertEquals(name, inputName.getAttribute("value"),
                "Наименование не отображается в поле");

        return this;
    }

    // Выбираем тип товара
    // Проверяем, что выбранный тип отображается в поле «Тип»
    public ProductPage selectGoodType(String type) {

        WebElement typeInput = driver.findElement(goodType);
        typeInput.click();
        WebElement typeOption = driver.findElement(By.xpath("//*[@value='" + type + "']"));
        typeOption.click();

        Assertions.assertEquals(type, typeInput.getAttribute("value"),
                "Выбраный тип не отображается в поле");

        return this;
    }

    // Активируем чекбокс «Экзотический»
    // Проверяем, что чекбокс активен
    public ProductPage activeExoticCheckBox() {

        WebElement checkBox = driver.findElement(checkBoxExotic);
        checkBox.click();
        Assertions.assertTrue(checkBox.isSelected(), "Чекбокс не активен");

        return this;
    }

    // Кликаем по кнопке сохранить
    // Проверяем, что окно для ввода данных закрылось
    public ProductPage pressSaveBtn() {

        WebElement saveButton = driver.findElement(saveBtn);
        saveButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        boolean isInvisible = wait.until(ExpectedConditions
                .invisibilityOfElementLocated(By.xpath("//*[@class=\"modal-content\"]")));
        Assertions.assertTrue(isInvisible,"Окно ввода данных не закрылось");

        return this;
    }

    // Проверяем отображение добаленной позиции в таблице
    public ProductPage checkGoodAdd(String goodName, String goodType, String Exotic) {

        String Name = goodName;
        String Type = goodType;
        String isExotic = Exotic;

        WebElement tableRowUF = driver.findElement(By.xpath(
                "//tr[contains(., '" + Name + "') " +
                        "and contains(., '" + Type + "') " +
                        "and contains(., '" + isExotic + "')]"));

        Assertions.assertNotNull(tableRowUF);

        return this;
    }

}