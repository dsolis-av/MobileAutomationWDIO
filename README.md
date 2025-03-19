# Automated Mobile Testing - WDIO Dummy App

This project is an automated mobile testing suite developed in Java to validate the [WDIO Dummy App](https://github.com/webdriverio/native-demo-app/releases). It uses TestNG, Appium and the Page Object Model design pattern to enhance the maintainability and reusability of test code, as well as empowering the separation of concerns. The goal is to ensure the correct functionality of the application under different scenarios.

## What It Does

The test suite covers the following scenarios:
- Navigating through the bottom bar options and verifying the matching screen displays correctly.
- Successful login with already existing and valid credentials.
- Successful sign up test with random email and password.
- Verifying correct visibility of the cards in the carousel after swiping in the Swipe screen.
- Verify visibility of the "You found me!!!" text after swiping to the bottom of the screen in the Swipe screen.

## How to run with IntelliJ - Considerations

1. Clone the repository.
2. Make sure you have **Java 17+** and **Maven** installed.
3. Navigate to the project root directory.
4. Install dependencies using:
```bash
mvn clean install
```
5. You can run the tests on a device matching at least the following capabilities:
```json
{
  "appium:platformVersion": "15",
  "appium:platformName": "Android",
  "appium:automationName": "UiAutomator2"
}
```
6. Before attempting to run any test, make sure you are running the **appium** server.
7. With IntelliJ, open the project and execute each test class to validate scenarios individually, or run the suite.xml file to execute the whole suite.