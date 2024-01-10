package com.qa.pages;

import com.qa.MenuPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductsDetailsPage extends MenuPage {



    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
    private WebElement SLB_title;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]")
    private WebElement SLB_text;
    @AndroidFindBy(accessibility = "test-BACK TO PRODUCTS")
    private WebElement backToProducts_btn;

    @AndroidFindBy(accessibility = "test-Price")
    private WebElement SLB_price;



public String getSLBText(){

    return getAttribute(SLB_text,"text");
}
public String getSLBPrice(){

    return getAttribute(SLB_price,"text");
}
public String getSLBTitle(){

    return getAttribute(SLB_title,"text");
}
public ProductsPage ClickBackToProducts(){
    Click(backToProducts_btn);
    return new ProductsPage();
}

}
