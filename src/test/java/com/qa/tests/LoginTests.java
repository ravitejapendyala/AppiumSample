package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.ProductsPage;
import com.qa.pages.loginPage;
import io.appium.java_client.AppiumBy;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

public class LoginTests extends BaseTest {

    loginPage login;
    ProductsPage productsPage;

    InputStream datais;
    JSONObject loginUsers;
    @BeforeMethod
    public  void beforeMethod(Method m) throws IOException {
        try{
            String dataFileName = "data/loginUsers.json";
            datais=getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener =  new JSONTokener(datais);
            loginUsers = new JSONObject(tokener);

        }
        catch (Exception e){
    e.printStackTrace();
    throw e;
        }
        finally {
            if(datais!=null){
                datais.close();
            }

        }



        login = new loginPage();
        System.out.println("\n" +"********* Starting test : "+m.getName()+ "*********" + "\n" );

    }
    @Test(priority=1)
    public  void invalidPassword(){

            login.enterUserName(loginUsers.getJSONObject("invalidPassword").getString("username"));
            login.enterPassword(loginUsers.getJSONObject("invalidPassword").getString("password"));
            login.ClickLogin();
            String ActualerrorMessage = login.getErrorMessage();
            String expecteMessage = "Username and password do not match any user in this service.";
            System.out.println("Actuall error message : "+ActualerrorMessage);
            Assert.assertEquals(ActualerrorMessage,expecteMessage);


    }
    @Test(priority=2)
    public  void invalidUserName(){
        login.enterUserName(loginUsers.getJSONObject("invalidUser").getString("username"));
        login.enterUserName(loginUsers.getJSONObject("invalidUser").getString("password"));

        login.ClickLogin();
        String ActualerrorMessage = login.getErrorMessage();
        String expecteMessage = "Username and password do not match any user in this service.";
        System.out.println("Actuall error message : "+ActualerrorMessage);
        Assert.assertEquals(ActualerrorMessage,expecteMessage);

    }

    @Test(priority=3)
    public  void LoginSuccess(){
        login.enterUserName(loginUsers.getJSONObject("validuser").getString("username"));
        login.enterUserName(loginUsers.getJSONObject("validuser").getString("password"));
        productsPage =  login.ClickLogin();
        String ActualMessage = productsPage.getTitle();
        String expecteMessage = "PRODUCTS";
        System.out.println("Actuall  message : "+ActualMessage);
        Assert.assertEquals(ActualMessage,expecteMessage);

    }



}
