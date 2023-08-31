import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class StartDriverSession {


    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"pixel_7_pro");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID,"emulator-5554");
        String appUrl = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"ApiDemos-debug.apk";
        //caps.setCapability(MobileCapabilityType.APP,appUrl);
        caps.setCapability("appPackage","io.appium.android.apis");
        caps.setCapability("appActivity","io.appium.android.apis.accessibility.CustomViewAccessibilityActivity");

        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new AndroidDriver(url,caps);

    }

}
