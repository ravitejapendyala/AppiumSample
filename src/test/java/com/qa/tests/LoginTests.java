package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.ProductsPage;
import com.qa.pages.loginPage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LoginTests extends BaseTest {

    loginPage login;
    ProductsPage productsPage;

    @BeforeMethod
    public  void beforeMethod(Method m)
    {
        login = new loginPage();
        System.out.println("\n" +"********* Starting test : "+m.getName()+ "*********" + "\n" );

    }
    @Test(priority=1)
    public  void invalidPassword(){
        login.enterUserName("invalidusername");
        login.enterPassword("wrongPassword");
        login.ClickLogin();
        String ActualerrorMessage = login.getErrorMessage();
        String expecteMessage = "Username and password do not match any user in this service.";
        System.out.println("Actuall error message : "+ActualerrorMessage);
        Assert.assertEquals(ActualerrorMessage,expecteMessage);

    }
    @Test(priority=2)
    public  void invalidUserName(){
        login.enterUserName("invalidusername");
        login.enterPassword("secret_sauce");
        login.ClickLogin();
        String ActualerrorMessage = login.getErrorMessage();
        String expecteMessage = "Username and password do not match any user in this service.";
        System.out.println("Actuall error message : "+ActualerrorMessage);
        Assert.assertEquals(ActualerrorMessage,expecteMessage);

    }

    @Test(priority=3)
    public  void LoginSuccess(){
        login.enterUserName("standard_user");
        login.enterPassword("secret_sauce");
        productsPage =  login.ClickLogin();
        String ActualMessage = productsPage.getTitle();
        String expecteMessage = "PRODUCTS";
        System.out.println("Actuall  message : "+ActualMessage);
        Assert.assertEquals(ActualMessage,expecteMessage);

    }



}
