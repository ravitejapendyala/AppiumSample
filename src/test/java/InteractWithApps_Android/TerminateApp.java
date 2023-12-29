package InteractWithApps_Android;

import CreateDriverSession_pack.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class TerminateApp {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        By view = AppiumBy.accessibilityId("Views");


        driver.findElement(view).click();
        Thread.sleep(5000);

        ((AndroidDriver)driver).terminateApp("io.appium.android.apis");
    }
}
