package Gestures_Android_Automation;

import CreateDriverSession_pack.CreateDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwipeGesture {
    public static void main(String[] args) throws Exception {

       AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        By views = AppiumBy.accessibilityId("Views");
        By drag_and_drop = AppiumBy.accessibilityId("Drag and Drop");
        driver.findElement(views).click();
        Thread.sleep(3000);
        SwipeByCoordinates(driver);
        Thread.sleep(3000);


    }

    public  static void SwipeByCoordinates(AppiumDriver driver)
    {

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left",701, "top",1600, "width",700, "height",1100,
                "direction","up",
                "percent",0.75
        ));
    }





}
