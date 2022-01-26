package com.ultralesson.training.web.internal;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

public class DriverStore {

    public WebDriver getWebDriver() {
        return (WebDriver) Reporter.getCurrentTestResult().getAttribute(getTestUniqueName(Reporter.getCurrentTestResult()));
    }


    public static String getTestUniqueName(ITestResult testResult) {
        return String.format("%s_%s", testResult.getMethod().getTestClass().getName(), testResult.getMethod().getMethodName());
    }
}
