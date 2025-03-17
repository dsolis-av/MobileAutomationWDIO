package org.globant.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.globant.base.BaseScreen;
import org.openqa.selenium.WebElement;

public class WebviewScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "text(\"Next-gen browser and mobile automation test framework for Node.js\")")
    private WebElement webviewHeader;

    public WebviewScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean webviewHeaderIsVisible(){
        return webviewHeader.isDisplayed();
    }
}
