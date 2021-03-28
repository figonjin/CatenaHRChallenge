package com.askgamblers.frontendintegration.testSuites;

import com.askgamblers.frontendintegration.pageObjects.HomePage;
import com.askgamblers.frontendintegration.pageObjects.QuickSearchPage;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

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

    /*A parametrized test would be more suitable for general integration into the testing lifecycle, however due to
    the cloudfront issue, it is easier to carry over Headers/Cookies this way to avoid constant hCaptcha
    authentication requests. Unfortunately due to this choice, any test failing in the stream will
    stop the execution of any subsequent test, which is not ideal.
    */
    //Currently the test fails due to what I assume is a bug related to input sanitization
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
