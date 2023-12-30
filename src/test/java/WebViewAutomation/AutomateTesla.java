package WebViewAutomation;

import CreateDriverSession_pack.CreateBrowserSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public class AutomateTesla {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateBrowserSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        driver.get("https://www.tesla.com/");
        driver.findElement(AppiumBy.xpath("//span[text()='Menu']")).click();
        driver.findElement(AppiumBy.xpath("//span[text()='Vehicles']")).click();

        driver.findElement(AppiumBy.xpath("//h3[text()='Model X']/../div//a[text()='Order']")).click();
        // scroll down
        //ScrollOnElement(driver,driver.findElement(AppiumBy.xpath("//button[text()='Probable Savings*']")));
        WebElement element = driver.findElement(AppiumBy.xpath("//span[text()='Paint']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);


        Thread.sleep(2000);
        element = driver.findElement(AppiumBy.xpath("//span[text()='Interior']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(2000);

        element = driver.findElement(AppiumBy.xpath("//h2[text()='Charging']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(2000);

        driver.findElement(AppiumBy.xpath("//span[text()='Continue']")).click();

        element = driver.findElement(AppiumBy.xpath("//button[text()='Order with Card']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(2000);
        //scroll
        driver.findElement(AppiumBy.xpath("//button[text()='Order with Card']")).click();

        element = driver.findElement(AppiumBy.xpath("//input[@id='FIRST_NAME']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        driver.findElement(AppiumBy.xpath("//input[@id='FIRST_NAME']")).sendKeys("Ravi Teja");
        // Close the driver after the test is finished
        //driver.quit();
    }

    public  static void ScrollOnElement(AppiumDriver driver,WebElement element)
    {

        boolean canScroll = true;
        while(canScroll){
            canScroll  = (Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//                "elementId",((RemoteWebElement)element).getId(),
                    "left",100, "top",100, "width",600, "height",600,
                    "direction","down",
                    "percent",1.0
            ));
        }

    }
}
