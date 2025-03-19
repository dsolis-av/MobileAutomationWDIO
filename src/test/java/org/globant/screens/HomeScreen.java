package org.globant.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.globant.base.BaseScreen;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "description(\"Home-screen\")")
    private WebElement homeScrollView;

    public HomeScreen(AndroidDriver driver){
        super(driver);
    }

    public boolean homeScrollViewIsVisible() {
        try {
            return homeScrollView.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
