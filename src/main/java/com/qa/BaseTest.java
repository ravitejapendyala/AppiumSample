package com.qa;

import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.tethering.Tethering;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;
import io.appium.java_client.screenrecording.CanRecordScreen;

public class BaseTest {

    protected static AppiumDriver driver;
    protected static Properties prop;
    protected static String dateTime;
    InputStream inputStream;
    TestUtils utils;

    public BaseTest(){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AfterTest
    public void AfterTest(){

        driver.quit();

    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("super before method");
        ((CanRecordScreen) driver).startRecordingScreen();
    }
    @AfterMethod
    public void afterMethod(ITestResult result) throws FileNotFoundException {
        System.out.println("super after method");
        String media = ((CanRecordScreen) driver).stopRecordingScreen();
        Map<String,String> params =  result.getTestContext().getCurrentXmlTest().getAllParameters();
        String dir = "videos"+File.separator+params.get("platformName")+"_"+params.get("platformVersion")+"_"+params.get("deviceName")+File.separator+dateTime+File.separator+result.getTestClass().getRealClass().getSimpleName();
    File videoDir = new File(dir);
    if(!videoDir.exists()){
        videoDir.mkdirs();
    }
        FileOutputStream stream = new FileOutputStream(videoDir+File.separator+result.getName()+".mp4");
        try {
            stream.write(Base64.decodeBase64(media));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Parameters({"platformName","platformVersion","deviceName"})
    @BeforeTest
    public void BeforeTest(String platformName,String platformVersion,String deviceName) throws MalformedURLException {

        try{

            utils = new TestUtils();
            dateTime = utils.dateTime();
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

    public WebElement scrollToElement() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()" +".scrollable(true)).scrollIntoView("
                        + "new UiSelector().description(\"test-Price\"));"));
    }

    public AppiumDriver getDriver(){
        return driver;
    }
    public String getDateTime(){
        return dateTime;
    }
}
