package steps;

import config.Configs;
import io.cucumber.java.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static ChromeDriver driver = Configs.driverInit();

    @BeforeAll
    public static void setUp() {
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/food");

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
