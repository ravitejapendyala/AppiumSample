package WebViewAutomation;

import CreateDriverSession_pack.CreateDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebViewInspectionUsingAI {
    static WebDriverWait wait;
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By views = AppiumBy.accessibilityId("Views");
        By WebView2 = AppiumBy.accessibilityId("WebView2");
        driver.findElement(views).click();
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        ((JavascriptExecutor)driver).executeScript("mobile:swipeGesture", ImmutableMap.of(
                        "elementId",((RemoteWebElement)element).getId(),
//                "left",900, "top",2700, "width",600, "height",600,
                "direction","up",
                "percent",1
        ));
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(WebView2)).click();
        Thread.sleep(3000);
        System.out.println("Text is : "+driver.findElement(AppiumBy.xpath("//android.webkit.WebView/android.widget.TextView[1]")).getText());
        //((AndroidDriver)driver).hideKeyboard();

    }
}
