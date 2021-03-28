package com.askgamblers.frontendintegration.pageObjects;

import com.askgamblers.frontendintegration.pageObjects.common.AGHeader;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage extends AGHeader {

    public HomePage(WebDriver driver) throws IllegalStateException {
        this.driver = driver;
        if(driver.getTitle().equals("Attention Required! | Cloudflare")) {
                throw new IllegalStateException("Cloudflare triggered. Did you run in headless mode?");
        }
    }
}
