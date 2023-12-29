package Gestures_Android_Automation;

import CreateDriverSession_pack.CreateDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScrollGesture {
    static WebDriverWait wait;
    public static void main(String[] args) throws Exception {

       AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        By views = AppiumBy.accessibilityId("Views");
        By Gallery = AppiumBy.accessibilityId("Gallery");

        By drag_and_drop = AppiumBy.accessibilityId("Drag and Drop");
        driver.findElement(views).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(Gallery)).click();
        Thread.sleep(3000);
//        SwipeByElement(driver);
        //ScrollByCoordinates(driver);
        SwipeByElement(driver);
//        ScrollToEndHorizontally(driver,"right");
//        Thread.sleep(3000);
//        ScrollToEndHorizontally(driver,"left");


    }

    public  static void ScrollByCoordinates(AppiumDriver driver)
    {
        boolean canScroll  = (Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left",100, "top",100, "width",600, "height",600,
                "direction","down",
                "percent",1.0
        ));
    }
    public  static void SwipeByElement(AppiumDriver driver)
    {
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        boolean canScroll  = (Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                //"left",100, "top",100, "width",600, "height",600,
                "direction","down",
                "percent",1.0
        ));

//        By photos = AppiumBy.accessibilityId("1. Photos");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(photos)).click();
//        WebElement element = driver.findElement(AppiumBy.xpath("//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]"));
//        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//                //"left",701, "top",1600, "width",700, "height",1100,
//                "elementId",((RemoteWebElement)element).getId(),
//                "direction","left",
//                "percent",0.75
//        ));
    }

    public  static void ScrollToEndHorizontally(AppiumDriver driver,String scrollDirection)
    {

        By photos = AppiumBy.accessibilityId("1. Photos");
        wait.until(ExpectedConditions.visibilityOfElementLocated(photos)).click();
        By imageLocator = (AppiumBy.xpath("//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView"));
        List<WebElement> elementList = driver.findElements(imageLocator);
        List<String> elementListIds = elementList.stream().map(e1->((RemoteWebElement)e1).getId()).collect(Collectors.toList());
        List<String> currentElementListIds = new ArrayList<String> (elementListIds);

        do{
            elementListIds.clear();
            elementListIds.addAll(currentElementListIds);
            ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "left",100, "top",400, "width",700, "height",50,
                    //"elementId",((RemoteWebElement)element).getId(),
                    "direction",scrollDirection,
                    "percent",1
            ));
            currentElementListIds.clear();
            elementList = driver.findElements(imageLocator);
            currentElementListIds= elementList.stream().map(e1->((RemoteWebElement)e1).getId()).collect(Collectors.toList());
        }while (!elementListIds.containsAll(currentElementListIds));

    }





}
