package org.globant.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.globant.base.BaseScreen;
import org.openqa.selenium.WebElement;

public class FormsScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "description(\"Forms-screen\")")
    private WebElement formsScrollView;

    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean formsScrollViewIsVisible(){
        return formsScrollView.isDisplayed();
    }
}
