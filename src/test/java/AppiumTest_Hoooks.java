import Utilities.ConfigFileReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class AppiumTest_Hoooks {
    ExtentSparkReporter htmlReporter;
    public AndroidDriver driver;

    ExtentReports extent;
    ConfigFileReader configFileReader;

    public AppiumTest_Hoooks(){
        htmlReporter = new ExtentSparkReporter("extentReport.html");
        extent  = new ExtentReports();
        configFileReader = new ConfigFileReader();
    }

    /*
    @BeforeClass(alwaysRun=true)
    public void setUp() throws Exception {
        String appUrl = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"Apps"+ File.separator+"Calculator.apk";
        UiAutomator2Options opt = new UiAutomator2Options().
                setDeviceName("pixel_7_pro").
                setAutomationName("UiAutomator2").
                setApp(appUrl);

        URL url = new URL("http://0.0.0.0:4723");
        driver = new AndroidDriver(url,opt);
        htmlReporter.loadXMLConfig("spark-config.xml");
        extent.attachReporter(htmlReporter);
    }
    */

    @BeforeClass(alwaysRun = true)
    public void Setup() throws IOException {
        String Device = configFileReader.getPropertyValue("AVD");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        caps.setCapability("avd",Device);
        caps.setCapability("avdLaunchTimeout",180000);
        caps.setCapability("readyTimeout",180000);
        String appUrl = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"Apps"+ File.separator+"Calculator.apk";
        caps.setCapability(MobileCapabilityType.APP,appUrl);
        URL url = new URL("http://0.0.0.0:4723");
        driver = new AndroidDriver(url,caps);
        htmlReporter.loadXMLConfig("spark-config.xml");
        extent.attachReporter(htmlReporter);
    }

    @AfterClass(alwaysRun=true)
    public void tearDown() throws Exception {
        driver.quit();
        extent.flush();
    }

    public String getScreenshotInLocal(AndroidDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;

        File src = ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") + "/Screenshot/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            System.out.println("Capture Failed " + e.getMessage());
        }
        return path;
    }
    public String getScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String base64_code = ts.getScreenshotAs(OutputType.BASE64);
        return base64_code;
    }


}
