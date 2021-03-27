package com.askgamblers.frontendintegration.tests;

import com.askgamblers.frontendintegration.helpers.Pause;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestManager {

    protected Properties testProperties = new Properties();
    protected WebDriver driver;
    protected Pause wait = new Pause();

    @BeforeEach
    public void setUp() throws IOException {
        testProperties.load(new FileInputStream("src/test/resources/test.properties"));
        System.setProperty("webdriver.chrome.driver", testProperties.getProperty("webdriver.chrome.driver"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions", "start-maximized");
        driver = new ChromeDriver(options);
        driver.get(testProperties.getProperty("homepage.url"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
