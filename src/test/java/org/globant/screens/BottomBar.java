package org.globant.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.globant.base.BaseScreen;
import org.openqa.selenium.WebElement;

public class BottomBar extends BaseScreen {

    @AndroidFindBy(uiAutomator = "description(\"Home\")")
    private WebElement homeButton;

    @AndroidFindBy(uiAutomator = "description(\"Webview\")")
    private WebElement webviewButton;

    @AndroidFindBy(uiAutomator = "description(\"Login\")")
    private WebElement loginButton;

    @AndroidFindBy(uiAutomator = "description(\"Forms\")")
    private WebElement formsButton;

    @AndroidFindBy(uiAutomator = "description(\"Swipe\")")
    private WebElement swipeButton;

    @AndroidFindBy(uiAutomator = "description(\"Drag\")")
    private WebElement dragButton;

    public BottomBar(AndroidDriver driver){
        super(driver);
    }

    public HomeScreen tapHomeButton(){
        tap(homeButton);
        return new HomeScreen(driver);
    }

    public WebviewScreen tapWebviewButton(){
        tap(webviewButton);
        return new WebviewScreen(driver);
    }

    public LoginScreen tapLoginButton(){
        tap(loginButton);
        return new LoginScreen(driver);
    }

    public FormsScreen tapFormsButton(){
        tap(formsButton);
        return new FormsScreen(driver);
    }

    public SwipeScreen tapSwipeButton(){
        tap(swipeButton);
        return new SwipeScreen(driver);
    }

    public DragScreen tapDragButton(){
        tap(dragButton);
        return new DragScreen(driver);
    }
}
