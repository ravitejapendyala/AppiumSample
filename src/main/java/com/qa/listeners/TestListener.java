package com.qa.listeners;

import com.qa.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestListener implements ITestListener {
    public void onTestFailure(ITestResult result) {
        if(result.getThrowable()!=null) {
            //System.out.println("onFailure triggered");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            result.getThrowable().printStackTrace(pw);
            System.out.println(sw.toString());
        }
        BaseTest base = new BaseTest();
        Map<String,String> params = new HashMap<String, String>();
        params = result.getTestContext().getCurrentXmlTest().getAllParameters();
        String imagePath = "Screenshots"+File.separator+params.get("platformName")+"_"+params.get("platformVersion")+"_"+params.get("deviceName")+
                File.separator+base.getDateTime()+File.separator+result.getTestClass().getRealClass().getSimpleName()+
                File.separator+result.getName()+".png";
        File file = base.getDriver().getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File(imagePath));
            Reporter.log("This is the sample screenshot");
            String completeImagePath = System.getProperty("user.dir")+File.separator+imagePath;
            Reporter.log("<a href='"+ completeImagePath + "'> <img src='"+ completeImagePath + "' height='100' width='100'/> </a>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
