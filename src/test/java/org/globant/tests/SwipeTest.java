package org.globant.tests;

import org.globant.base.BaseTest;
import org.globant.screens.BottomBar;
import org.globant.screens.SwipeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SwipeTest extends BaseTest {

    //Precondition: User is at the Swipe screen
    //Test verifies all the cards from the first to the last
    @Test(testName = "Verify correct visibility of the cards in the carousel after swiping")
    public void swipeCardsTest(){
        SoftAssert softAssert = new SoftAssert();
        BottomBar bottomBar = new BottomBar(driver);
        //First we need to go to the Swipe screen
        SwipeScreen swipeScreen = bottomBar.tapSwipeButton();
        //We do the first swipe
        swipeScreen.swipeCard();
        //Card 1 shouldn't be visible any longer and Card 2 should be now visible
        softAssert.assertTrue(!swipeScreen.isCard1Visible() && swipeScreen.isCard2Visible(),"Card 1 shouldn't be visible any longer and Card 2 should be now visible. The condition is not being met");
        //We do the second swipe
        swipeScreen.swipeCard();
        //Card 2 shouldn't be visible any longer and Card 3 should be now visible
        softAssert.assertTrue(!swipeScreen.isCard2Visible() && swipeScreen.isCard3Visible(),"Card 2 shouldn't be visible any longer and Card 3 should be now visible. The condition is not being met");
        //We do the third swipe
        swipeScreen.swipeCard();
        //Card 3 shouldn't be visible any longer and Card 4 should be now visible
        softAssert.assertTrue(!swipeScreen.isCard3Visible()  && swipeScreen.isCard4Visible(),"Card 3 shouldn't be visible any longer and Card 4 should be now visible. The condition is not being met");
        //We do the fourth swipe
        swipeScreen.swipeCard();
        //Card 4 shouldn't be visible any longer and Card 5 should be now visible
        softAssert.assertTrue(!swipeScreen.isCard4Visible()  && swipeScreen.isCard5Visible(),"Card 4 shouldn't be visible any longer and Card 5 should be now visible. The condition is not being met");
        //We do the fifth swipe
        swipeScreen.swipeCard();
        //Now the only card visible should be Card 6
        softAssert.assertTrue(swipeScreen.onlyFinalCardIsVisible(),"The only card visible should be Card 6. The condition is not being met");
        //Check all assertions to check if anything failed
        softAssert.assertAll();
    }

    //Precondition: User is at the Swipe screen
    @Test(testName = "Verify visibility of the You Found Me text after swiping to the bottom of the screen")
    public void swipeUpTest(){
        BottomBar bottomBar = new BottomBar(driver);
        //First we need to go to the swipe screen
        SwipeScreen swipeScreen = bottomBar.tapSwipeButton();
        //We swipe up starting from the top border of the cards carousel
        //and ending at the top of the screen
        swipeScreen.swipeUpFromCardsCarousel();
        //We perform another swipe starting from the lower vertical end of the screen
        //and ending at the top of the screen
        swipeScreen.swipe(50,70,50,0,600);
        //Now the "You found me!!!" text should be visible
        Assert.assertTrue(swipeScreen.textYouFoundMeIsVisible());
    }
}
