package Gestures_Android_Automation;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CreateDriverSession_pack.CreateDriverSession;
import java.time.Duration;

public class LongClickGesture {
    public static void main(String[] args) throws Exception {

       AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By views = AppiumBy.accessibilityId("Views");
        By drag_and_drop = AppiumBy.accessibilityId("Drag and Drop");

        By ok_button1 = AppiumBy.id("android:id/button1");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(views).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(drag_and_drop)).click();
        //longClickByElementId(driver);
        longClickByOffSets(driver);



        Thread.sleep(3000);

    }

    public  static void longClickByElementId(AppiumDriver driver)
    {
        By bubble1 = AppiumBy.id("io.appium.android.apis:id/drag_dot_1");
        WebElement bubble1_we = driver.findElement(bubble1);
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) bubble1_we).getId(),"duration",1000
        ));
    }
    public  static void longClickByOffSets(AppiumDriver driver)
    {
        By bubble1 = AppiumBy.id("io.appium.android.apis:id/drag_dot_1");
        WebElement bubble1_we = driver.findElement(bubble1);
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x",177,
                "y",701,
                "duration",1000
        ));
    }

}
