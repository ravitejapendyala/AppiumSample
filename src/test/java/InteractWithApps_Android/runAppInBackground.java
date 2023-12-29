package InteractWithApps_Android;

import CreateDriverSession_pack.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class runAppInBackground {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        By view = AppiumBy.accessibilityId("Views");


        driver.findElement(view).click();
        Thread.sleep(5000);
        ((AndroidDriver)driver).runAppInBackground(Duration.ofSeconds(5));
        //System.out.println(((AndroidDriver)driver).isAppInstalled("io.appium.android.apis"));
        //String andAppUrl = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"ApiDemos-debug.apk";
        //((AndroidDriver)driver).installApp(andAppUrl,new AndroidInstallApplicationOptions().withReplaceEnabled());
    }
}
