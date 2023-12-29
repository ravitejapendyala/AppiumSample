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

public class PinchGesture {
    public static void main(String[] args) throws Exception {

       AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        PinchOpenGesture(driver);
        Thread.sleep(3000);
        PinchCloseGesture(driver);


    }


    public static void PinchOpenGesture(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"SKIP\"]")).click();

        Thread.sleep(8000);
        ((JavascriptExecutor)driver).executeScript("mobile: pinchOpenGesture",ImmutableMap.of(
                "left",200,
                "top",470,
                "width",600,
                "height",600,
                "percent",0.75
        ));


    }
    public static void PinchCloseGesture(AppiumDriver driver) throws InterruptedException {

        System.out.println("Entered pinchCloseGesture");

        ((JavascriptExecutor)driver).executeScript("mobile: pinchCloseGesture",ImmutableMap.of(
                "left",200,
                "top",470,
                "width",600,
                "height",600,
                "percent",0.75
        ));
        Thread.sleep(5000);


    }



}
