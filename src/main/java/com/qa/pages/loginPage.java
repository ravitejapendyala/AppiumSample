package com.qa.pages;

import com.qa.BaseTest;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class loginPage extends BaseTest {

    @AndroidFindBy(accessibility = "test-Username")
    private WebElement userName_txt;
    @AndroidFindBy(accessibility = "test-Password")
    private WebElement Password_txt;
    @AndroidFindBy(accessibility = "test-LOGIN")
    private WebElement login_btn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    private WebElement error_info;



    public loginPage enterUserName(String userName) {
        Sendkeys(userName_txt, userName);
        return this;
    }

    public loginPage enterPassword(String password) {
        Sendkeys(Password_txt, password);
        return this;
    }
    public ProductsPage ClickLogin () {
        login_btn.click();
        return new ProductsPage();
    }
    public String getErrorMessage () {
        return getAttribute(error_info,"text");
    }

}
