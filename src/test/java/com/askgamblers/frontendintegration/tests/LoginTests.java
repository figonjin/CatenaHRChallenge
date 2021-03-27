package com.askgamblers.frontendintegration.tests;

import com.askgamblers.frontendintegration.pageObjects.HomePage;
import com.askgamblers.frontendintegration.pageObjects.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginTests extends TestManager {

    @Test
    public void loginAndLogoutValidUser() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.openSignIn();
        wait.waitForVisible(driver,60,By.name("_username"));
        loginPage.loginUser(testProperties.getProperty("test.username"), testProperties.getProperty("test.password"), true);
        homePage.logoutUser();
    }

    @Test
    public void loginAndLogoutInvalidUser() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.openSignIn();
        wait.waitForVisible(driver,60,By.name("_username"));
        loginPage.loginUser("wrongUser", "wrongPassword", false);
        loginPage.checkLoginErrorMessage();
    }

    @Test
    public void loginAndLogoutEmptyCredentials() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.openSignIn();
        wait.waitForVisible(driver,60,By.name("_username"));
        loginPage.loginUser("", "", false);
        loginPage.checkLoginErrorMessage();
    }
}
