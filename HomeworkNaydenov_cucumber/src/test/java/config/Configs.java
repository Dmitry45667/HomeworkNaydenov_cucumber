package config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Configs {
    public static ChromeDriver driver;
    public static JdbcTemplate jdbcTemplate;

    public static ChromeDriver driverInit() {
       System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
       driver = new  ChromeDriver();
       return driver;
    }



    public static JdbcTemplate getJdbcTemplate() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/dbconfig.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(properties.getProperty("db.url"));
        dataSource.setUsername(properties.getProperty("db.user"));
        dataSource.setPassword(properties.getProperty("db.password"));

        jdbcTemplate = new JdbcTemplate(dataSource);

        return jdbcTemplate;
    }
}
