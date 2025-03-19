package org.globant.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.globant.base.BaseScreen;
import org.openqa.selenium.WebElement;

public class DragScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "description(\"Drag-drop-screen\")")
    private WebElement dragScrollView;

    public DragScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean dragScrollViewIsVisible() {
        try {
            return dragScrollView.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
