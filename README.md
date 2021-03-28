# Catena HackerRank Challenge
## _Summary_
This repository hosts a Selenium/JUnit based test suite dedicated to functional tests of the english version of the [AskGamblers](https://www.askgamblers.com) website.

## Test Coverage
The tests in this suite focus on checking the functionality of the Login and Quicksearch modules.
The reasoning behind this coverage is that as a link aggregator/lead generator site, the two major components offered to the user are the database of the casinos and offers, as well as the option to retain their findings and be notified of future events.

Furthermore, due to fairly aggressive CloudFront policies regarding ddos prevention, manual user input is needed to solve the hCaptcha every time a new test method starts. If somehow this issue is circumvented (through IP whitelisting or policy change) the tests should automatically adapt and not add any extra execution time that is otherwise present.

## Tech Stack
This test suite uses the following projects/tools to work properly:
- [Maven](https://maven.apache.org) - Fantastic project management tool
- [JUnit5](https://junit.org/junit5/) - One of the better test management frameworks out there
- [Selenium](https://www.selenium.dev) - The de-facto web application testing framework
- [Allure](https://docs.qameta.io/allure/) - Lighweight multi-language test report tool

## Installation
This project requires [Java version 11.x](https://adoptopenjdk.net/), [Maven](https://maven.apache.org) 
and a [ChromeDriver](http://chromedriver.chromium.org/downloads) appropriate to your browser's version to build correctly.
(Please note that the provided webdriver executable is for Chrome version 89)

Once the dependencies are met, navigate to the root folder of the project and run:
```
mvn clean install
```
Once maven finishes downloading the dependencies and building the project, you can run:
```
mvn test
```
to run all of the available suites, or
```
mvn -Dtest=testSuiteName test
```
to run a test suite of your choice.

----
Once the tests are done, run
```
mvn allure:serve
```
to have allure create a temporary web server for hosting the report, and open it in your default browser.

----
Make sure to solve the hCaptcha during execution if not whitelisted on Cloudflare!

## Configuration
You can set some properties in the `.properties` files found in `/src/test/resources`

| Property     | Description | Default Value |
| ------------ | ----------- | ------------- |
| homepage.url | The base URL for tests | https://www.askgamblers.com/ |
| webdriver.chrome.driver | The path to the webdriver | chromedriver.exe |
| test.username | Username used for login tests | fitest |
| test.password | Password used for login tests | Pa55word |
| allure.results.directory | Directory for allure reports | target/allure-results |

## Potential Improvements
- Dynamic Webdriver manager for easier switching between browsers
- A docker container setup for easier environment replication
- Proper autocomplete, quicksearch and user notification API tests (preferably in a separate project)
- CI
- Better report handling/report archiving
- More tests!
