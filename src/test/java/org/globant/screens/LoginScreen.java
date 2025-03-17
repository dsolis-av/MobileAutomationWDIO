package org.globant.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.globant.base.BaseScreen;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "description(\"Login-screen\")")
    private WebElement loginScrollView;

    @AndroidFindBy(uiAutomator = "description(\"button-login-container\")")
    private WebElement loginSectionButton;

    @AndroidFindBy(uiAutomator = "description(\"button-sign-up-container\")")
    private WebElement signUpSectionButton;

    @AndroidFindBy(uiAutomator = "description(\"input-email\")")
    protected WebElement emailInput;

    @AndroidFindBy(uiAutomator = "description(\"input-password\")")
    protected WebElement passwordInput;

    @AndroidFindBy(uiAutomator = "description(\"button-LOGIN\")")
    private WebElement loginButton;

    @AndroidFindBy(uiAutomator = "resourceId(\"android:id/alertTitle\")")
    private WebElement successfulLoginAlert;


    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean loginScrollViewIsVisible(){
        return loginScrollView.isDisplayed();
    }

    public SignUpScreen tapSignUpSectionButton(){
        tap(signUpSectionButton);
        return new SignUpScreen(driver);
    }

    public void tapLoginSectionButton(){
        tap(loginSectionButton);
    }

    public void fillLoginForm(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public void tapLoginButton(){
        tap(loginButton);
    }

    public boolean successfulLoginAlertIsVisible(){
        return successfulLoginAlert.isDisplayed();
    }
}
