import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AndroidUIAutomator {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        WebElement accessibility = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println("Text by UiSelector text : "+accessibility.getText());

        accessibility = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")).get(2);
        System.out.println("Text by UiSelector className : "+accessibility.getText());

        accessibility = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Accessibility\")"));
        System.out.println("Text by UiSelector description : "+accessibility.getText());

        accessibility = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")")).get(1);
        System.out.println("Text by UiSelector resourceId : "+accessibility.getText());

        //By element1 = AppiumBy.androidUIAutomator("");

//        WebElement accessibility = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
//        System.out.println("Text by accessibilityId : "+accessibility.getText());
//
//        accessibility = driver.findElements(AppiumBy.id("android:id/text1")).get(1);
//        System.out.println("Text by id : "+accessibility.getText());
//
//        accessibility = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
//        System.out.println("Text by xpath : "+accessibility.getText());
//
//        accessibility = driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
//        System.out.println("Text by className : "+accessibility.getText());
    }
}
