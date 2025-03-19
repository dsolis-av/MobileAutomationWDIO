package org.globant.tests;

import org.globant.base.BaseTest;
import org.globant.screens.BottomBar;
import org.globant.screens.LoginScreen;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SuccessfulLoginTest extends BaseTest {

    @DataProvider(name = "Existing credentials to test login")
    public Object[][] loginData() {
        return new Object[][] {
                {"testemail@gmail.com", "12345678"}
        };
    }

    //Precondition: User is at the Login screen
    @Test(testName = "Successful login test with already existing credentials", dataProvider = "Existing credentials to test login")
    public void loginTest(String email, String password){
        BottomBar bottomBar = new BottomBar(driver);
        //First we need to go to the Login screen
        LoginScreen loginScreen = bottomBar.tapLoginButton();
        //First we tap the Login section button
        loginScreen.tapLoginSectionButton();
        //Now we fill the login form with the already existing credentials
        loginScreen.fillLoginForm(email, password);
        //Now we can tap the Login button
        loginScreen.tapLoginButton();
        //We need to validate if the successful login alert is being displayed
        //If it is, then we have a successful login
        Assert.assertTrue(loginScreen.successfulLoginAlertIsVisible(), "Successful login alert is not displaying");
        loginScreen.tapAlertOkButton();
    }
}
