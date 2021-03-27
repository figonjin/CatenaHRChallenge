package com.askgamblers.frontendintegration.tests;

import com.askgamblers.frontendintegration.helpers.Pause;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestManager {

    protected static Properties testProperties = new Properties();
    protected static WebDriver driver;
    protected static Pause wait = new Pause();
    protected static ChromeOptions options = new ChromeOptions();

    //TODO: Dynamic driver manager
    @BeforeAll
    public static void driverSetUp() throws IOException {
        testProperties.load(new FileInputStream("src/test/resources/test.properties"));
        System.setProperty("webdriver.chrome.driver", testProperties.getProperty("webdriver.chrome.driver"));
        options.addArguments("--disable-extensions", "start-maximized");
    }

    @BeforeEach
    public void testSetUp() {
        driver = new ChromeDriver(options);
        driver.get(testProperties.getProperty("homepage.url"));
        driver.navigate().refresh();
        wait.waitForVisible(driver, 60,By.id("ag-header-search--body"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
