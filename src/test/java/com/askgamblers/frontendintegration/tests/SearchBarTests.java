package com.askgamblers.frontendintegration.tests;

import com.askgamblers.frontendintegration.pageObjects.HomePage;
import com.askgamblers.frontendintegration.pageObjects.QuickSearchPage;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class SearchBarTests extends TestManager {

    @TestFactory
    Collection<DynamicTest> searchKeywords() {
        HomePage homePage = new HomePage(driver);
        return Arrays.asList(
                DynamicTest.dynamicTest("Searching for CosmicSlot", () -> {
                    QuickSearchPage quickSearchPage = homePage.searchEntry("CosmicSlot");
                    quickSearchPage.validateRelevantCasinoResult();
                    homePage.navigateToHome();
                }),
                DynamicTest.dynamicTest("Searching for ABC1234", () -> {

                    QuickSearchPage quickSearchPage = homePage.searchEntry("ABC1234");
                    quickSearchPage.validateNoMatchingResults();
                    homePage.navigateToHome();
                })
        );
    }

    @TestFactory
    Stream<DynamicTest> searchSpecialCharacters() {

        List<String> inputList = Arrays.asList(
                "!!!", "@@@", "###", "$$$", "%%%", "^^^", "&&&", "***", "(((",
                ")))", "---", "___", "===", "+++"
        );

        Iterator<String> inputIterator = inputList.iterator();
        Function<String, String> displayNameGenerator = (input) -> "Searching for " + input;
        ThrowingConsumer<String> testExecutor = (input) -> {
          HomePage homePage = new HomePage(driver);
          int index = inputList.indexOf(input);
          QuickSearchPage quickSearchPage = homePage.searchEntry(inputList.get(index));
          quickSearchPage.validateNoMatchingResults();
          homePage.navigateToHome();
        };

        return DynamicTest.stream(
                inputIterator, displayNameGenerator, testExecutor
        );
    }
}
