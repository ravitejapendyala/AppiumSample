package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.ProductsDetailsPage;
import com.qa.pages.ProductsPage;
import com.qa.pages.SettingsPage;
import com.qa.pages.loginPage;
import org.checkerframework.checker.units.qual.m;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class ProductsTests extends BaseTest {

    loginPage login;
    ProductsPage productsPage;

    InputStream datais;
    JSONObject loginUsers;
    SettingsPage settingsPage;
    ProductsDetailsPage productsDetailsPage;
    @BeforeClass
    public  void beforeClass() throws IOException {
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
        CloseApp();
        LaunchApp();

    }

    @BeforeMethod
    public void beforeMethod(Method m){
        login = new loginPage();
        System.out.println("\n" +"********* Starting test : "+ m.getName()+ "*********" + "\n" );
    }
    @Test(priority=1)
    public  void ValidateProductOnProductsPage(){
        SoftAssert sa = new SoftAssert();
        productsPage = login.login(loginUsers.getJSONObject("validuser").getString("username"),loginUsers.getJSONObject("validuser").getString("password"));
        String slbTitle = productsPage.getSLBTitle();
        System.out.println("slbTitle is : "+slbTitle);
        String slbTitle_expected = "Sauce Labs Backpack";
        String slbPrice = productsPage.getSLBPrice();
        System.out.println("slbPrice is : "+slbPrice);
        String slbPrice_expected = "$29.99";
        sa.assertEquals(slbTitle,slbTitle_expected);
        sa.assertEquals(slbPrice,slbPrice_expected);

        settingsPage =  productsPage.clickSettings();
        login = settingsPage.clickLogout();
        sa.assertAll();
    }
    @Test(priority=2)
    public  void ValidateProductOnProductDetailsPage(){
        SoftAssert sa = new SoftAssert();
        productsPage = login.login(loginUsers.getJSONObject("validuser").getString("username"),loginUsers.getJSONObject("validuser").getString("password"));
        productsDetailsPage =  productsPage.ClickSLBTitle();
        String slbTitle = productsDetailsPage.getSLBTitle();
        System.out.println("slbTitle is : "+slbTitle);
        String slbTitle_expected = "Sauce Labs Backpack";
        sa.assertEquals(slbTitle,slbTitle_expected);

        String slbPrice = productsDetailsPage.getSLBPrice();
        System.out.println("slbPrice is : "+slbPrice);
        String slbPrice_expected = "$29.99";
        sa.assertEquals(slbPrice,slbPrice_expected);

        String slbText = productsDetailsPage.getSLBText();
        System.out.println("slbText is : "+slbText);
        String slbText_expected = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        sa.assertEquals(slbText,slbText_expected);
        sa.assertAll();
        productsPage = productsDetailsPage.ClickBackToProducts();
        settingsPage =  productsPage.clickSettings();
        login = settingsPage.clickLogout();
    }




}
