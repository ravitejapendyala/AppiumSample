package CreateDriverSession_pack;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {


    public static void main(String[] args) throws MalformedURLException {



    }

    public static  AppiumDriver initializeDriver(String platformName) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
        caps.setCapability("newCommandTimeout",300000);
        URL url = new URL("http://0.0.0.0:4723");

        switch (platformName){
            case "Android":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME,"pixel_7_pro");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
                //caps.setCapability(MobileCapabilityType.UDID,"emulator-5554");
                caps.setCapability("avd","Pixel_7_Pro");
                caps.setCapability("avdLaunchTimeout",180000);
                caps.setCapability("readyTimeout",180000);

                //String andAppUrl = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"ApiDemos-debug.apk";

                //caps.setCapability(MobileCapabilityType.APP,appUrl);


                caps.setCapability("appPackage","io.appium.android.apis");
                caps.setCapability("appActivity","io.appium.android.apis.ApiDemos");
                /*
                caps.setCapability("appPackage","com.google.android.apps.maps");
                caps.setCapability("appActivity","com.google.android.maps.MapsActivity");
                */
                return  new AndroidDriver(url,caps);
            case "iOS":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 11");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
                //caps.setCapability(MobileCapabilityType.UDID,"emulator-5554");


                String iOSAppUrl = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"ApiDemos-debug.app";

                //caps.setCapability(MobileCapabilityType.APP,appUrl);

                caps.setCapability("simulatorStartupTimeout",180000);
                caps.setCapability("appActivity","com.example.apple-samplecode.UICatalog");
                return  new IOSDriver(url,caps);
            default:
                throw new Exception("invalid platform");
        }

    }

}
