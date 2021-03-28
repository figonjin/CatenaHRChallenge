package com.askgamblers.frontendintegration.tests;

import com.askgamblers.frontendintegration.pageObjects.HomePage;
import com.askgamblers.frontendintegration.pageObjects.LoginPage;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.*;

public class LoginTests extends TestManager {

    @Test
    public void loginAndLogoutValidUser() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.openSignIn();
        loginPage.loginUser(testProperties.getProperty("test.username"), testProperties.getProperty("test.password"), true);
        homePage.logoutUser();
    }

    @TestFactory
    Collection<DynamicTest> loginAndLogoutInvalidCredentials() {
        HomePage homePage = new HomePage(driver);
        return Arrays.asList(
                DynamicTest.dynamicTest("Logging in as wrongUser", () -> {
                    LoginPage loginPage = homePage.openSignIn();
                    loginPage.loginUser("wrongUser", "wrongPassword", false);
                    loginPage.checkLoginErrorMessage();
                }),
                DynamicTest.dynamicTest("Logging in with blank credentials", () -> {
                    LoginPage loginPage = homePage.openSignIn();
                    loginPage.loginUser("", "", false);
                    loginPage.checkLoginErrorMessage();
                })
        );
    }
}
