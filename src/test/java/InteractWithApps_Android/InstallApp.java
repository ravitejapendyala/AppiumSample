package InteractWithApps_Android;

import CreateDriverSession_pack.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import org.openqa.selenium.By;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class InstallApp {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        By view = AppiumBy.accessibilityId("Views");


        driver.findElement(view).click();
        Thread.sleep(5000);
        String andAppUrl = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"ApiDemos-debug.apk";
        ((AndroidDriver)driver).installApp(andAppUrl,new AndroidInstallApplicationOptions().withReplaceEnabled());
    }
}
