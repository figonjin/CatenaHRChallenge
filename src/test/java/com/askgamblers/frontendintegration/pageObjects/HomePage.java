package com.askgamblers.frontendintegration.pageObjects;

import com.askgamblers.frontendintegration.pageObjects.common.AGHeader;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage extends AGHeader {

    String expectedHomeTitle = "AskGamblers - Best Online Gambling Website in " + new SimpleDateFormat("yyyy").format(new Date());

    public HomePage(WebDriver driver) throws IllegalStateException {
        this.driver = driver;
        if (!driver.getTitle().equals(expectedHomeTitle)) {
            if(driver.getTitle().equals("Attention Required! | Cloudflare")) {
                throw new IllegalStateException("Cloudflare triggered. Did you run in headless mode?");
            }
            else {
                throw new IllegalStateException("Current website is: " + driver.getCurrentUrl() + "\n" +
                        "Expecting: https://www.askgamblers.com/");
            }
        }
    }

}
