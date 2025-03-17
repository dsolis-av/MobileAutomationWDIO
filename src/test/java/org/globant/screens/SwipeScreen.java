package org.globant.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.globant.base.BaseScreen;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "description(\"Swipe-screen\")")
    private WebElement swipeScrollView;

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean swipeScrollViewisVisible(){
        return swipeScrollView.isDisplayed();
    }
}
