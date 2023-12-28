import CreateDriverSession_pack.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DifferentWaysofDefiningElements {

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Access'ibility\"]")
    @iOSXCUITFindBy(accessibility = "Access'ibility")
    private static WebElement myElement4;

    public DifferentWaysofDefiningElements(AppiumDriver driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        DifferentWaysofDefiningElements differentWaysofDefiningElements = new DifferentWaysofDefiningElements(driver);

        By myElement2 = By.xpath("//android.widget.TextView[@content-desc=\"Access'ibility\"]");
        By myElement3 = AppiumBy.accessibilityId("Access'ibility");




//        System.out.println("Text by accessibilityId : "+driver.findElement(myElement3).getText());
        System.out.println("Text by accessibilityId : "+myElement4.getText());
        //driver.findElement(myElement3).click();
       myElement4.click();
        Thread.sleep(5000);
/*
        WebElement accessibility = driver.findElement(AppiumBy.accessibilityId("Accessibility"));


        accessibility = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
        System.out.println("Text by xpath : "+accessibility.getText());

        accessibility = driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
        System.out.println("Text by className : "+accessibility.getText());*/
    }
}
