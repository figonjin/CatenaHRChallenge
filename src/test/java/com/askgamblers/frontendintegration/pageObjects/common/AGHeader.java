package com.askgamblers.frontendintegration.pageObjects.common;

import com.askgamblers.frontendintegration.pageObjects.HomePage;
import com.askgamblers.frontendintegration.pageObjects.LoginPage;
import com.askgamblers.frontendintegration.pageObjects.QuickSearchPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;

public class AGHeader {

    protected WebDriver driver;
    protected By userOptionsAndSignInButton = By.xpath("//div[contains(@class, 'ag-header-navigation-user-login-profile')]");
    protected By userOptionsLogout = By.cssSelector("a[href='/logout']");
    protected By searchInput = By.id("ag-header-search--body");
    protected By agHeaderLogo = By.className("ag-header-logo");

    public LoginPage openSignIn() {
        driver.findElement(userOptionsAndSignInButton).click();
        return new LoginPage(driver);
    }

    public void logoutUser() {
        driver.findElement(userOptionsAndSignInButton).click();
        driver.findElement(userOptionsLogout).click();
        Assertions.assertEquals("Sign in or Join", driver.findElement(userOptionsAndSignInButton).getText());
    }

    //TODO: Make search entry dynamically decide between the frontpage search bar and the Header search bar
    public QuickSearchPage searchEntry(String keyword) {
        driver.findElement(searchInput).sendKeys(keyword);
        driver.findElement(searchInput).sendKeys(Keys.RETURN);
        return new QuickSearchPage(driver);
    }

    public HomePage navigateToHome() {
        driver.findElement(agHeaderLogo).click();
        return new HomePage(driver);
    }
}