package org.globant.tests;

import org.globant.base.BaseTest;
import org.globant.screens.LoginScreen;
import org.globant.screens.SignUpScreen;
import org.globant.utils.RandomCredentialGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulSignUpTest extends BaseTest {

    //Precondition: User is at the Login screen
    @Test(testName = "Successful sign up test with random email and password")
    public void signUpTest(){
        LoginScreen loginScreen = new LoginScreen(driver);
        //First we define our random credentials to test
        String randomEmail = RandomCredentialGenerator.generateRandomEmail();
        String randomPassword = RandomCredentialGenerator.generateRandomPassword();
        //Now we tap the Sign Up section button
        SignUpScreen signUpScreen = loginScreen.tapSignUpSectionButton();
        //Now we fill up our Sign Up form
        signUpScreen.fillSignForm(randomEmail, randomPassword);
        //Finally we complete the Sign Up by tapping the Sign Up button
        signUpScreen.tapSignUpButton();
        //We need to validate if the successful sign up alert is being displayed
        //If it is, then we have a successful sign up
        Assert.assertTrue(signUpScreen.successfulSignUpAlertIsVisible(), "Successful sign up alert is not displaying");

    }
}
