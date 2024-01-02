package qa.mobile;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class test1 {

    AppiumDriver driver;
    @Test(priority=2)
    public  void invalidUserName(){
         WebElement userName_txt =  driver.findElement(AppiumBy.accessibilityId("test-Username"));
         WebElement Password_txt =  driver.findElement(AppiumBy.accessibilityId("test-Password"));
         WebElement login_btn =  driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));
         userName_txt.sendKeys("InvalidUsername");
        Password_txt.sendKeys("InvalidUsername");
        login_btn.click();
        WebElement error_txt =  driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView"));
        String ActualerrorMessage = error_txt.getText();
        String expecteMessage = "Username and password do not match any user in this service.";
        System.out.println("Actuall error message : "+ActualerrorMessage);
        Assert.assertEquals(ActualerrorMessage,expecteMessage);

    }
    @Test(priority=1)
    public  void invalidPassword(){
         WebElement userName_txt =  driver.findElement(AppiumBy.accessibilityId("test-Username"));
         WebElement Password_txt =  driver.findElement(AppiumBy.accessibilityId("test-Password"));
         WebElement login_btn =  driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

         userName_txt.sendKeys("standard_user");
        Password_txt.sendKeys("InvalidUsername");
        login_btn.click();
        WebElement error_txt =  driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView"));
        String ActualerrorMessage = error_txt.getText();
        String expecteMessage = "Username and password do not match any user in this service.";
        System.out.println("Actuall error message : "+ActualerrorMessage);
        Assert.assertEquals(ActualerrorMessage,expecteMessage);

    }
    @Test(priority=3)
    public  void LoginSuccess(){
         WebElement userName_txt =  driver.findElement(AppiumBy.accessibilityId("test-Username"));
         WebElement Password_txt =  driver.findElement(AppiumBy.accessibilityId("test-Password"));
         WebElement login_btn =  driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

         userName_txt.sendKeys("standard_user");
        Password_txt.sendKeys("secret_sauce");
        login_btn.click();
        WebElement products_message =  driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView"));
        String ActualMessage = products_message.getText();
        System.out.println("Actuall message : "+ActualMessage);
        String expecteMessage = "PRODUCTS";
        Assert.assertEquals(ActualMessage,expecteMessage);

    }

    @BeforeClass
    public  void  beforeClass() throws MalformedURLException {
        String chromeDriver = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"chromedriver.exe";
        String andAppUrl = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName","Android");
        dc.setCapability("automationName","UiAutomator2");
        dc.setCapability("appPackage","com.swaglabsmobileapp");
        dc.setCapability("appActivity","com.swaglabsmobileapp.SplashActivity");
        //dc.setCapability("app",andAppUrl);

        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"pixel_7_pro");
        dc.setCapability("avd","Pixel_7_Pro");
        dc.setCapability("avdLaunchTimeout",180000);
        dc.setCapability("readyTimeout",180000);
        dc.setCapability("unlockType","pin");
        dc.setCapability("unlockKey","1256");
        dc.setCapability("chromedriverExecutable",chromeDriver);
        
        
        URL url = new URL("http://0.0.0.0:4723");
        driver = new AndroidDriver(url,dc);
        String sessionId = driver.getSessionId().toString();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        

    }

    @AfterClass
    public  void afterClass(){

        driver.quit();

    }


}
