package com.qa.pages;

import com.qa.BaseTest;
import com.qa.MenuPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductsPage extends MenuPage {


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    private WebElement products_info;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]")
    private WebElement SLB_title;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Price\"])[1]")
    private WebElement SLB_price;


    public String getSLBTitle(){

        return getAttribute(SLB_title,"text");
    }
    public ProductsDetailsPage ClickSLBTitle(){

        Click(SLB_title);
        return  new ProductsDetailsPage();
    }
    public String getSLBPrice(){

        return getAttribute(SLB_price,"text");
    }


public String getTitle(){

    return getAttribute(products_info,"text");
}

}
