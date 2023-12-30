package WebViewAutomation;

import CreateDriverSession_pack.CreateBrowserSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.time.Duration;

public class CreateNewChromeDriverSession {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateBrowserSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        driver.get("https://www.tesla.com/");

        // Close the driver after the test is finished
        //driver.quit();
    }
}
