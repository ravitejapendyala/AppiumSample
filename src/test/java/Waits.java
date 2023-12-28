import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Waits {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By App = AppiumBy.accessibilityId("App");
        By alertDiaog = AppiumBy.accessibilityId("Alert Dialogs");
        By OkCancel_shortDiaog = AppiumBy.accessibilityId("OK Cancel dialog with a message");
        By ok_button1 = AppiumBy.id("android:id/button1");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(App).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertDiaog)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(OkCancel_shortDiaog)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ok_button1)).click();




        Thread.sleep(3000);

    }
}
