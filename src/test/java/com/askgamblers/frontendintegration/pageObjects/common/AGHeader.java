package com.askgamblers.frontendintegration.pageObjects.common;

import com.askgamblers.frontendintegration.pageObjects.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AGHeader {

    protected WebDriver driver;
    protected By userOptionsAndSignInButton = By.xpath("//div[contains(@class, 'ag-header-navigation-user-login-profile')]");
    protected By userOptionsLogout = By.cssSelector("a[href='/logout'");

    public LoginPage openSignIn() {
        driver.findElement(userOptionsAndSignInButton).click();
        return new LoginPage(driver);
    }

    public void logoutUser() {
        driver.findElement(userOptionsAndSignInButton).click();
        driver.findElement(userOptionsLogout).click();
        Assertions.assertEquals(driver.findElement(userOptionsAndSignInButton).getText(), "Sign in or Join");
    }
}