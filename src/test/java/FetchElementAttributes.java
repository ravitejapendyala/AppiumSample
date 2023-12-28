import CreateDriverSession_pack.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class FetchElementAttributes {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        By Preference = AppiumBy.accessibilityId("Preference");
        By switch_control = AppiumBy.accessibilityId("9. Switch");
        By editText = AppiumBy.id("io.appium.android.apis:id/edit");
        driver.findElement(Preference).click();
        driver.findElement(switch_control).click();
        By switchPref = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Switch\")");
        By switchPref_text = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")");


        System.out.println("text by text: "+driver.findElement(switchPref_text).getText());
        System.out.println("text by attribute: "+driver.findElement(switchPref_text).getAttribute("text"));
        System.out.println("checked status of pref1: "+driver.findElements(switchPref).get(0).getAttribute("checked"));
        System.out.println("checked status of pref1: "+driver.findElements(switchPref).get(1).getAttribute("checked"));
        /*
        System.out.println("enabled status: "+driver.findElement(Preference).getAttribute("enabled"));
        System.out.println("selected status: "+driver.findElement(Preference).getAttribute("selected"));
        System.out.println("displayed status: "+driver.findElement(Preference).getAttribute("displayed"));
        System.out.println("isEnabled status: "+driver.findElement(Preference).isEnabled());
*/

    }
}
