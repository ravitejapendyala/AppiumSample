package WebViewAutomation;

import CreateDriverSession_pack.CreateDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class AutomateHybridApp {
    static WebDriverWait wait;
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By views = AppiumBy.accessibilityId("Views");
        By WebView = AppiumBy.accessibilityId("WebView");
        driver.findElement(views).click();
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        ((JavascriptExecutor)driver).executeScript("mobile:swipeGesture", ImmutableMap.of(
                        "elementId",((RemoteWebElement)element).getId(),
//                "left",900, "top",2700, "width",600, "height",600,
                "direction","up",
                "percent",1
        ));
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(WebView)).click();
        Thread.sleep(3000);
        Set<String> contextHandles = ((AndroidDriver)driver).getContextHandles();
        //System.out.println("Text is : "+driver.findElement(AppiumBy.xpath("//android.webkit.WebView/android.widget.TextView[1]")).getText());
        //((AndroidDriver)driver).hideKeyboard();

        for(String context: contextHandles){
            System.out.println(context);
        }

        ((AndroidDriver)driver).context("WEBVIEW_io.appium.android.apis");
        Thread.sleep(3000);
        System.out.println("cssSelector Text: "+driver.findElement(By.cssSelector("body > h1")).getText());
        System.out.println("i_am_a_textbox Text: "+driver.findElement(By.id("i_am_a_textbox")).getText());
        ((AndroidDriver)driver).context("NATIVE_APP");

    }
}
