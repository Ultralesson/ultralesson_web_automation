package com.ultralesson.training.web;

import com.ultralesson.training.web.drivers.DriverCreator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected  WebDriver webDriver;
    @BeforeMethod
    public void setup(ITestContext iTestContext) {
        String browser = "chrome";
        webDriver = new DriverCreator().createDriverContext(browser).create();
        iTestContext.setAttribute("driver", webDriver);
    }
}
