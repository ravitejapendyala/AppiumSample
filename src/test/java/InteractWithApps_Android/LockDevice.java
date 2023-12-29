package InteractWithApps_Android;

import CreateDriverSession_pack.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LockDevice {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //((AndroidDriver)driver).lockDevice(Duration.ofSeconds(5));
        ((AndroidDriver)driver).lockDevice();
        System.out.println("Locked state : "+((AndroidDriver)driver).isDeviceLocked());
        ((AndroidDriver)driver).unlockDevice();
        System.out.println("Locked state : "+((AndroidDriver)driver).isDeviceLocked());


    }
}
