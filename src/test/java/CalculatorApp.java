import POM.CalculationScreen;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorApp extends AppiumTest_Hoooks {

    ExtentTest test;
    CalculationScreen calculationScreen;

/*
    public static void main(String[] args) throws MalformedURLException, InterruptedException {


        String appUrl = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"Calculator.apk";
        UiAutomator2Options opt = new UiAutomator2Options().
                setDeviceName("pixel_7_pro").
                setAutomationName("UiAutomator2").
                setApp(appUrl);

        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new AndroidDriver(url,opt);
        //Addition of two numbers

        Thread.sleep(5000);
        WebElement seven = driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
        seven.click();
        Thread.sleep(3000);
        WebElement plus = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        plus.click();
        Thread.sleep(3000);
        WebElement three = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        three.click();
        Thread.sleep(3000);
        WebElement equalTo = driver.findElement(By.id("com.google.android.calculator:id/eq"));

        equalTo.click();
        Thread.sleep(3000);
        // locate the edit box
        WebElement results = driver.findElement(By.id("com.google.android.calculator:id/formula_scroll_view"));

        if(results.getText().equals("10"))
        {
            System.out.println("Test Passed...");
        }
        else
        {
            System.out.println("Test Failed...");
        }


    }
*/
    //@Test
    public void AddtionTest() throws InterruptedException {

        test = extent
                .createTest("AdditionTest","Calculator automation using Appium")
                .info("This is a info msg")
                .addScreenCaptureFromBase64String(getScreenshot(),"");
        WebElement clearAll = driver.findElement(By.id("com.google.android.calculator:id/clr"));
        clearAll.click();
        test.log(Status.INFO,"Enter 7");
        WebElement seven = driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
        seven.click();
        Thread.sleep(3000);
        WebElement plus = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        plus.click();
        Thread.sleep(3000);
        WebElement three = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        three.click();
        Thread.sleep(3000);
        WebElement equalTo = driver.findElement(By.id("com.google.android.calculator:id/eq"));

        equalTo.click();

        Thread.sleep(3000);
        // locate the edit box
        WebElement results = driver.findElement(By.id("com.google.android.calculator:id/result_final"));

        if(results.getText().equals("10"))
        {
            System.out.println("Test Passed...");
            test.pass("Addition Pass");
        }
        else
        {
            System.out.println("Test Failed...");
            test.fail("Addition Failure");
        }

    }

    @Test(priority = 1)
    public void VerifyAddition() throws InterruptedException {
        calculationScreen=new CalculationScreen(driver);
        calculationScreen.doSum();
        test = extent
                .createTest("Addition Test","Addition Test using Appium")
                //.info("This is a info msg")
                .addScreenCaptureFromBase64String(getScreenshot(),"");
        calculationScreen.btnEqual.click();
        String result = calculationScreen.FinalResult.getText();
        Assert.assertEquals(result,"12");
    }
    @Test(priority = 2)
    public void VerifySubtraction() throws InterruptedException {
        calculationScreen=new CalculationScreen(driver);
        calculationScreen.doMinus();
        test = extent
                .createTest("Subtraction Test","Subtraction Test using Appium")
                .info("This is a info msg")
                .addScreenCaptureFromBase64String(getScreenshot(),"");
        calculationScreen.btnEqual.click();
        String result = calculationScreen.FinalResult.getText();
        Assert.assertEquals(result,"4");
    }
    @Test(priority = 3)
    public void VerifyMultiplication() throws InterruptedException {
        calculationScreen=new CalculationScreen(driver);
        calculationScreen.doMultiplication();
        test = extent
                .createTest("Multiplication Test","Multiplication Test using Appium")
                .info("This is a info msg")
                .addScreenCaptureFromBase64String(getScreenshot(),"");
        calculationScreen.btnEqual.click();
        String result = calculationScreen.FinalResult.getText();
        Assert.assertEquals(result,"32");
    }
    @Test(priority = 4)
    public void VerifyDivision() throws InterruptedException {
        calculationScreen=new CalculationScreen(driver);
        calculationScreen.doDivision();
        test = extent
                .createTest("Division Test","Division Test using Appium")
                .info("This is a info msg")
                .addScreenCaptureFromBase64String(getScreenshot(),"");
        calculationScreen.btnEqual.click();
        String result = calculationScreen.FinalResult.getText();
        Assert.assertEquals(result,"2");
    }

}
