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

public class DragAndDrop {
    public static void main(String[] args) throws Exception {

       AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        By views = AppiumBy.accessibilityId("Views");
        By drag_and_drop = AppiumBy.accessibilityId("Drag and Drop");
        driver.findElement(views).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(drag_and_drop)).click();
        DragGesture(driver);
        Thread.sleep(3000);
        VerifyDropped(driver);

    }

    public  static void DragGesture(AppiumDriver driver)
    {
        By drag_source_ball = AppiumBy.id("io.appium.android.apis:id/drag_dot_1");
        WebElement drag_source_ball_we = driver.findElement(drag_source_ball);
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) drag_source_ball_we).getId(),
                "endX",828,
                "endY",796
        ));
    }

    public static boolean VerifyDropped(AppiumDriver driver){
        By drag_result_text = AppiumBy.id("io.appium.android.apis:id/drag_result_text");
        String text = driver.findElement(drag_result_text).getText();
        return  (text=="Dropped!");

    }



}
