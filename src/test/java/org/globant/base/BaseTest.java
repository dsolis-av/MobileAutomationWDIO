package org.globant.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected static AndroidDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = createAndroidDriver();
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

    private AndroidDriver createAndroidDriver(){
        try {
            URL url = new URL("http://127.0.0.1:4723");
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setPlatformVersion("11")
                    .setAutomationName("UiAutomator2");
            AndroidDriver androidDriver = new AndroidDriver(url, options);
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return androidDriver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
