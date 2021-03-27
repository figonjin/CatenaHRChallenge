package com.askgamblers.frontendintegration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class quickTest {

    @Test
    public void quickRun() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--window-size=1920,1080", "--disable-gpu", "--disable-extensions");
        WebDriver browser = new ChromeDriver(options);
        browser.get("https://www.askgamblers.com");
        browser.close();
    }
}
