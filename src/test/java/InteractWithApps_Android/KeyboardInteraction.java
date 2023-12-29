package InteractWithApps_Android;

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
import java.util.concurrent.TimeUnit;

public class KeyboardInteraction {
    static WebDriverWait wait;
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By views = AppiumBy.accessibilityId("Views");
        By TextFields = AppiumBy.accessibilityId("TextFields");
        driver.findElement(views).click();
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        ((JavascriptExecutor)driver).executeScript("mobile:swipeGesture", ImmutableMap.of(
                        "elementId",((RemoteWebElement)element).getId(),
//                "left",900, "top",2700, "width",600, "height",600,
                "direction","up",
                "percent",0.75
        ));
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TextFields)).click();
        System.out.println("Keyboard shown  : "+((AndroidDriver)driver).isKeyboardShown());

        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.C));
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.HOME));
        //((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.T));
        Thread.sleep(3000);
        //((AndroidDriver)driver).hideKeyboard();

    }
}
