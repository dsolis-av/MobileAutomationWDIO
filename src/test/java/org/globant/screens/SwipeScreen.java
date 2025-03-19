package org.globant.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.globant.base.BaseScreen;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "description(\"Swipe-screen\")")
    private WebElement swipeScrollView;

    @AndroidFindBy(uiAutomator = "resourceId(\"__CAROUSEL_ITEM_0_READY__\")")
    private WebElement card1;

    @AndroidFindBy(uiAutomator = "resourceId(\"__CAROUSEL_ITEM_1_READY__\")")
    private WebElement card2;

    @AndroidFindBy(uiAutomator = "resourceId(\"__CAROUSEL_ITEM_2_READY__\")")
    private WebElement card3;

    @AndroidFindBy(uiAutomator = "resourceId(\"__CAROUSEL_ITEM_3_READY__\")")
    private WebElement card4;

    @AndroidFindBy(uiAutomator = "resourceId(\"__CAROUSEL_ITEM_4_READY__\")")
    private WebElement card5;

    @AndroidFindBy(uiAutomator = "resourceId(\"__CAROUSEL_ITEM_5_READY__\")")
    private WebElement card6;

    @AndroidFindBy(uiAutomator = "text(\"You found me!!!\")")
    private WebElement textYouFoundMe;

    @AndroidFindBy(uiAutomator = "description(\"Carousel\")")
    private WebElement cardCarousel;

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean swipeScrollViewisVisible(){
        return swipeScrollView.isDisplayed();
    }

    public boolean isCard1Visible() {
        try {
            return card1.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isCard2Visible() {
        try {
            return card2.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isCard3Visible() {
        try {
            return card3.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isCard4Visible() {
        try {
            return card4.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isCard5Visible() {
        try {
            return card5.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isCard6Visible() {
        try {
            return card6.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean onlyFinalCardIsVisible() {
        return isCard6Visible()
                && !isCard1Visible()
                && !isCard2Visible()
                && !isCard3Visible()
                && !isCard4Visible()
                && !isCard5Visible();
    }

    public boolean textYouFoundMeIsVisible() {
        try {
            return textYouFoundMe.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void swipeUpFromCardsCarousel() {
        swipeFromElementEdge(cardCarousel, Direction.UP,-5, 600);
    }

    public void swipeCard(){
        swipeFromElementEdge(cardCarousel, Direction.LEFT,0, 600);
    }
}
