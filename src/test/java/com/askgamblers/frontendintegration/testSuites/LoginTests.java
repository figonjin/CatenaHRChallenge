package com.askgamblers.frontendintegration.testSuites;

import com.askgamblers.frontendintegration.pageObjects.HomePage;
import com.askgamblers.frontendintegration.pageObjects.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.*;

public class LoginTests extends TestManager {

    @Feature("Login")
    @Test
    @DisplayName("Logging in with valid credentials")
    public void loginAndLogoutValidUser() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.openSignIn();
        loginPage.loginUser(
                testProperties.getProperty("test.username"),
                testProperties.getProperty("test.password"),
                true);
        homePage.logoutUser();
    }

    @Feature("Login")
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
