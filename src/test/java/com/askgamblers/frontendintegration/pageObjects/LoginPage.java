package com.askgamblers.frontendintegration.pageObjects;

import com.askgamblers.frontendintegration.pageObjects.common.AGHeader;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AGHeader {

    protected WebDriver driver;

    private By usernameField = By.name("_username");
    private By passwordField = By.name("_password");
    private By loginButton = By.name("login");
    private By badCredentialsMessage = By.cssSelector("span[class='error__text']");



    public LoginPage(WebDriver driver) throws IllegalStateException {
        this.driver = driver;
    }

    public AGHeader loginUser(String username, String password, boolean validLogin) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        if (!validLogin) {
            Assertions.assertEquals("Invalid username/email or password.", driver.findElement(badCredentialsMessage).getText());
            return new LoginPage(driver);
        }
        else {
            return new HomePage(driver);
        }
    }

    public void checkLoginErrorMessage() {
        wait.waitForVisible(driver, 3, badCredentialsMessage);
        driver.findElement(badCredentialsMessage).isDisplayed();
    }

}
