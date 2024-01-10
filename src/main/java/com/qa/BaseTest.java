package com.qa;

import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    protected static AppiumDriver driver;
    protected static Properties prop;
    InputStream inputStream;


    public BaseTest(){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AfterTest
    public void AfterTest(){

        driver.quit();

    }

    @Parameters({"platformName","platformVersion","deviceName"})
    @BeforeTest
    public void BeforeTest(String platformName,String platformVersion,String deviceName) throws MalformedURLException {

        try{

            prop = new Properties();
            String propFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            prop.load(inputStream);
            String chromeDriver = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"chromedriver.exe";

            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability("platformName",platformName);
            dc.setCapability("automationName",prop.getProperty("androidAutomationName"));
            dc.setCapability("appPackage",prop.getProperty("androidappPackage"));
            dc.setCapability("appActivity",prop.getProperty("androidappActivity"));
            //URL appURL = getClass().getClassLoader().getResource(prop.getProperty("androidAPPLocation"));
            String andAppUrl = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+prop.getProperty("androidAPPLocation");
            //dc.setCapability("app",appURL);
            dc.setCapability("app",andAppUrl);
            //androidDEVICE_NAME

            dc.setCapability("deviceName",deviceName);
            dc.setCapability("avd",deviceName);
            dc.setCapability("avdLaunchTimeout",180000);
            dc.setCapability("readyTimeout",180000);
            dc.setCapability("unlockType","pin");
            dc.setCapability("unlockKey","1256");
            dc.setCapability("chromedriverExecutable",chromeDriver);


            URL url = new URL(prop.getProperty("appiumURL"));
            driver = new AndroidDriver(url,dc);
            String sessionId = driver.getSessionId().toString();


        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    public void WaitForVisibility(WebElement element){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(TestUtils.wait));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public  void Click(WebElement element){
        WaitForVisibility(element);
        element.click();
    }
    public  void Sendkeys(WebElement element,String text){
        WaitForVisibility(element);
        element.sendKeys(text);
    }
    public  String getAttribute(WebElement element,String attribute){
        WaitForVisibility(element);
        return element.getAttribute(attribute);
    }

    public void CloseApp(){
        ((InteractsWithApps)driver).terminateApp(prop.getProperty("androidappPackage"));
    }
    public void LaunchApp(){
        ((InteractsWithApps)driver).activateApp(prop.getProperty("androidappPackage"));
    }
}
