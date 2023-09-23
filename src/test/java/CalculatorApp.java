import POM.CalculationScreen;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorApp extends AppiumTest_Hoooks {

    ExtentTest test;
    CalculationScreen calculationScreen;

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
        try{
            Assert.assertEquals(result,"12");
            test.pass(MarkupHelper.createLabel("Addition Test Success", ExtentColor.GREEN));
        }
        catch (Exception ex){
            test.pass(MarkupHelper.createLabel("Addition Test Failure with exception : "+ex.getLocalizedMessage(), ExtentColor.RED));
        }
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
        try{
            Assert.assertEquals(result,"4");
            test.pass(MarkupHelper.createLabel("Subtraction Test Success", ExtentColor.GREEN));
        }
        catch (Exception ex){
            test.pass(MarkupHelper.createLabel("Subtraction Test Failure with exception : "+ex.getLocalizedMessage(), ExtentColor.RED));
        }

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

        try{
            Assert.assertEquals(result,"32");
            test.pass(MarkupHelper.createLabel("Multiplication Test Success", ExtentColor.GREEN));
        }
        catch (Exception ex){
            test.pass(MarkupHelper.createLabel("Multiplication Test Failure with exception : "+ex.getLocalizedMessage(), ExtentColor.RED));
        }
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

        try{
            Assert.assertEquals(result,"2");
            test.pass(MarkupHelper.createLabel("Division Test Success", ExtentColor.GREEN));
        }
        catch (Exception ex){
            test.pass(MarkupHelper.createLabel("Division Test Failure with exception : "+ex.getLocalizedMessage(), ExtentColor.RED));
        }
    }

}
