import CreateDriverSession_pack.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class AndroidFindElements {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        WebElement accessibility = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println("Text by accessibilityId : "+accessibility.getText());

        accessibility = driver.findElements(AppiumBy.id("android:id/text1")).get(1);
        System.out.println("Text by id : "+accessibility.getText());

        accessibility = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
        System.out.println("Text by xpath : "+accessibility.getText());

        accessibility = driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
        System.out.println("Text by className : "+accessibility.getText());
    }
}
