# Catena HackerRank Challenge
## _Summary_
This repository hosts a Selenium/JUnit based test suite dedicated to functional tests of the english version of the [AskGamblers](https://www.askgamblers.com) website.

## Test Coverage
The tests in this suite focus on checking the functionality of the Login and Quicksearch modules.
The reasoning behind this coverage is that as a link aggregator/lead generator site, the two major components offered to the user are the database of the casinos and offers, as well as the option to retain their findings and be notified of future offers.

Furthermore, due to fairly aggressive CloudFront policies regarding ddos prevention, manual user input is needed to solve the hCaptcha every time a new test method starts. If somehow this issue is circumvented (through IP whitelisting or policy change) the tests should automatically adapt and not add any extra execution time that is otherwise present.

## Tech Stack
This test suite uses the following projects/tools to work properly:
- [Maven](https://maven.apache.org) - Fantastic project management tool
- [JUnit5](https://junit.org/junit5/) - One of the better test management frameworks out there
- [Selenium](https://www.selenium.dev) - The de-facto web application testing framework-

## Installation
This project requires [Java version 11.x](https://adoptopenjdk.net/) and [Maven](https://maven.apache.org) to build correctly.

Once the dependencies are met, navigate to the root folder of the project and run:
```
mvn clean install
```
Once maven finishes downloading the dependencies and building the project, you can run:
```
mvn test
```

Make sure to solve the hCaptcha during execution if not whitelisted on Cloudflare!

## Potential Improvements
- Dynamic Webdriver manager for easier switching between browsers
- A docker container for easier environment replication
- Proper autocomplete, quicksearch and user notification API tests (preferably in a separate project)
- More tests!