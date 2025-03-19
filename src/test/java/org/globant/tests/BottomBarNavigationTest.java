package org.globant.tests;

import org.globant.base.BaseTest;
import org.globant.screens.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BottomBarNavigationTest extends BaseTest {

    //Precondition: User is at the Home screen
    @Test(testName = "Navigating through the bottom bar options and verifying the matching screen displays correctly")
    public void navigationTest(){
        SoftAssert softAssert = new SoftAssert();
        BottomBar bottomBar = new BottomBar(driver);
        //Go to Home screen and assert home scroll view is visible
        HomeScreen homeScreen = bottomBar.tapHomeButton();
        softAssert.assertTrue(homeScreen.homeScrollViewIsVisible(), "Home element is not visible");
        //Go to Webview screen and assert webview header is visible
        WebviewScreen webviewScreen = bottomBar.tapWebviewButton();
        softAssert.assertTrue(webviewScreen.webviewHeaderIsVisible(), "Webview element is not visible");
        //Go to Login screen and assert login scroll view is visible
        LoginScreen loginScreen = bottomBar.tapLoginButton();
        softAssert.assertTrue(loginScreen.loginScrollViewIsVisible(), "Login element is not visible");
        //Go to Forms screen and assert forms scroll view is visible
        FormsScreen formsScreen = bottomBar.tapFormsButton();
        softAssert.assertTrue(formsScreen.formsScrollViewIsVisible(), "Forms element is not visible");
        //Go to Swipe screen and assert swipe scroll view is visible
        SwipeScreen swipeScreen = bottomBar.tapSwipeButton();
        softAssert.assertTrue(swipeScreen.swipeScrollViewisVisible(), "Swipe element is not visible");
        //Go to Drag screen and assert drag scroll view is visible
        DragScreen dragScreen = bottomBar.tapDragButton();
        softAssert.assertTrue(dragScreen.dragScrollViewIsVisible(), "Drag element is not visible");
        //Check all assertions to check if anything failed
        softAssert.assertAll();
    }
}
