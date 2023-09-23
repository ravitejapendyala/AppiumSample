package POM;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculationScreen {

    final String PACKAGE_ID = "com.google.android.calculator";

    @FindBy(id="com.google.android.calculator:id/digit_4")
    public WebElement digit_4;
    @FindBy(id=PACKAGE_ID+":id/digit_8")
    public WebElement digit_8;
    @FindBy(id=PACKAGE_ID+":id/op_add")
    public WebElement btnPlus;
    @FindBy(id = PACKAGE_ID+":id/eq")
    public  WebElement btnEqual;
    @FindBy(id = PACKAGE_ID+":id/clr")
    public WebElement btnClear;
    @FindBy(id = PACKAGE_ID+":id/op_sub")
    public WebElement btnMinus;
    @FindBy(id = PACKAGE_ID+":id/op_mul")
    public WebElement btnMultiplication;
    @FindBy(id = PACKAGE_ID+":id/op_div")
    public WebElement btnDivide;
    @FindBy(id=PACKAGE_ID+":id/result_final")
    public WebElement FinalResult;

    public CalculationScreen(AndroidDriver driver) throws InterruptedException {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

        public void doSum() throws InterruptedException {
            Thread.sleep(1000);
            digit_4.click();
            Thread.sleep(1000);
            btnPlus.click();
            Thread.sleep(1000);
            digit_8.click();
            Thread.sleep(1000);

        }
        public void doMinus() throws InterruptedException {
            Thread.sleep(1000);
            btnClear.click();
            Thread.sleep(1000);
            digit_8.click();
            Thread.sleep(1000);
            btnMinus.click();
            Thread.sleep(1000);
            digit_4.click();
            Thread.sleep(1000);

        }
        public void doMultiplication() throws InterruptedException {
            Thread.sleep(1000);
            btnClear.click();
            Thread.sleep(1000);
            digit_8.click();
            Thread.sleep(1000);
            btnMultiplication.click();
            Thread.sleep(1000);
            digit_4.click();
            Thread.sleep(1000);
        }
        public void doDivision() throws InterruptedException {
            Thread.sleep(1000);
            btnClear.click();
            Thread.sleep(1000);
            digit_8.click();
            Thread.sleep(1000);
            btnDivide.click();
            Thread.sleep(1000);
            digit_4.click();
            Thread.sleep(1000);

        }
    }

