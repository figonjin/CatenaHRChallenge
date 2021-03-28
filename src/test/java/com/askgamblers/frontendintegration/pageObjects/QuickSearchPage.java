package com.askgamblers.frontendintegration.pageObjects;

import com.askgamblers.frontendintegration.pageObjects.common.AGHeader;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuickSearchPage extends AGHeader {

    protected WebDriver driver;

    protected By mostRelevantCasinoResult = By.cssSelector("li[data-type=casinos]");
    protected By mostRelevantCasinoName = By.cssSelector("a[class*=card__desc-title]");
    protected By noMatchingResultsMessage = By.cssSelector("h3[class='msg large']");

    public QuickSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateRelevantCasinoResult() {
        Assertions.assertEquals("CosmicSlot Casino", driver.findElement(mostRelevantCasinoName).getText());
    }

    public void validateNoMatchingResults() {
        Assertions.assertEquals("There are no results matching your search.", driver.findElement(noMatchingResultsMessage).getText());
    }


}
