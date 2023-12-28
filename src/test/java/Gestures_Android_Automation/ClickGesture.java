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

public class ClickGesture {
    public static void main(String[] args) throws Exception {

       AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ClickByElementIdAndOffset(driver);
        Thread.sleep(3000);

    }

    public  static void ClickByElementId(AppiumDriver driver)
    {
        By views = AppiumBy.accessibilityId("Views");
        WebElement views_we = driver.findElement(views);
        ((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) views_we).getId()
        ));
    }
    public  static void ClickByElementIdAndOffset(AppiumDriver driver)
    {
        By views = AppiumBy.accessibilityId("Views");
        WebElement views_we = driver.findElement(views);
        ((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of(
                //"elementId", ((RemoteWebElement) views_we).getId(),
                "x",1217,
                "y",2314
        ));
    }


}
