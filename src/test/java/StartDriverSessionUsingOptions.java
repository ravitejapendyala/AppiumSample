import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class StartDriverSessionUsingOptions {


    public static void main(String[] args) throws MalformedURLException {

        String appUrl = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"ApiDemos-debug.apk";
        UiAutomator2Options opt = new UiAutomator2Options().
                setDeviceName("pixel_7_pro").
                setAutomationName("UiAutomator2").
                setApp(appUrl);

        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new AndroidDriver(url,opt);

    }

}
