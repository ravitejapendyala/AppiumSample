import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class webAppDemo {
    public static void main(String[] args) {
        // Set the desired capabilities for the Android emulator
        String chromeDriver = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"chromedriver.exe";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        //caps.setCapability("deviceName", "emulator-5554"); // Replace with the appropriate device name
        caps.setCapability("udid", "emulator-5554"); // Replace with the appropriate device name
        caps.setCapability("browserName", "chrome");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("autoGrantPermissions",true);
        caps.setCapability("chromedriverExecutable",chromeDriver);

        // Set the Appium server URL
        URL appiumURL = null;
        try {
            appiumURL = new URL("http://localhost:4723");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create the Appium driver with the desired capabilities
        AppiumDriver driver = new AndroidDriver(appiumURL, caps);
        System.out.println(((AndroidDriver) driver).getContextHandles());
        // Perform your test actions here
        // For example, navigating to a website
        driver.get("https://www.moneycontrol.com/");

        // Close the driver after the test is finished
        //driver.quit();
    }
}
