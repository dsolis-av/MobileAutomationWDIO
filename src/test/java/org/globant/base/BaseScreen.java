package org.globant.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class BaseScreen {
    protected AndroidDriver driver;

    public enum Direction {
        UP, LEFT
    }

    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    //Method to tap the center of an element
    public void tap(WebElement element) {
        int X = (element.getSize().width / 2) + element.getRect().getX();
        int Y = (element.getSize().height / 2) + element.getRect().getY();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 0)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), X, Y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(100)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        this.driver.perform(List.of(sequence));
    }

    //Method to swipe from starting X,Y to ending X,Y
    public void swipe(int percentageStartX, int percentageStartY, int percentageEndX, int percentageEndY, int speedInMills) {
        int width = this.driver.manage().window().getSize().getWidth();
        int height = this.driver.manage().window().getSize().getHeight();

        int startPositionX = (int) (width * (percentageStartX / 100.0));
        int endPositionX = (int) (width * (percentageEndX / 100.0));
        int startPositionY = (int) (height * (percentageStartY / 100.0));
        int endPositionY = (int) (height * (percentageEndY / 100.0));

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 0)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startPositionX, startPositionY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(speedInMills), PointerInput.Origin.viewport(), endPositionX, endPositionY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(1000)));

        this.driver.perform(List.of(sequence));
    }

    //Method to swipe up or left starting from the middle top border of an element.
    //offsetY indicates how far from the top border the swipe is gonna start
    public void swipeFromElementEdge(WebElement element, Direction direction, int offsetY, int speedInMillis) {
        Rectangle rect = element.getRect();
        int startX, startY, endX, endY;

        //Start at middle top edge of the element + offset in y axis
        startX = rect.getX() + (rect.getWidth() / 2);
        startY = rect.getY() + offsetY;

        switch (direction) {
            case UP:
                endX = startX;
                endY = 0; //Swipe up to the top of the screen
                break;
            case LEFT:
                endX = 0; //Swipe left to the edge
                endY = startY;
                break;
            default:
                throw new IllegalArgumentException("Unsupported swipe direction");
        }

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 0)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(speedInMillis), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        this.driver.perform(List.of(sequence));
    }


}
