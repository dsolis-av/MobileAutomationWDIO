package org.globant.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.globant.base.BaseScreen;
import org.openqa.selenium.WebElement;

public class SignUpScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "description(\"button-login-container\")")
    private WebElement loginSectionButton;

    @AndroidFindBy(uiAutomator = "description(\"button-sign-up-container\")")
    private WebElement signUpSectionButton;

    @AndroidFindBy(uiAutomator = "description(\"input-email\")")
    private WebElement emailInput;

    @AndroidFindBy(uiAutomator = "description(\"input-password\")")
    private WebElement passwordInput;

    @AndroidFindBy(uiAutomator = "description(\"input-repeat-password\")")
    private WebElement repeatPasswordInput;

    @AndroidFindBy(uiAutomator = "description(\"button-SIGN UP\")")
    private WebElement signUpButton;

    @AndroidFindBy(uiAutomator = "resourceId(\"android:id/alertTitle\")")
    private WebElement successfulSignUpAlert;

    public SignUpScreen(AndroidDriver driver) {
        super(driver);
    }

    public void fillSignForm(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        repeatPasswordInput.sendKeys(password);
    }

    public void tapSignUpButton(){
        tap(signUpButton);
    }

    public boolean successfulSignUpAlertIsVisible(){
        return successfulSignUpAlert.isDisplayed();
    }
}
