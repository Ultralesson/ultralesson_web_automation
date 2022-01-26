package com.ultralesson.training.web;

import com.ultralesson.training.web.drivers.DriverCreator;
import com.ultralesson.training.web.internal.DriverStore;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.ultralesson.training.web.internal.DriverStore.getTestUniqueName;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public synchronized void setup(ITestResult iTestResult) {
        WebDriver webDriver = new DriverCreator().createDriverContext().create();
        iTestResult.setAttribute(getTestUniqueName(iTestResult), webDriver);
    }

    @AfterMethod(alwaysRun = true)
    public synchronized void teardown(ITestResult iTestResult) {
        WebDriver driver = (WebDriver) iTestResult.getAttribute(getTestUniqueName(iTestResult));
        driver.quit();
    }

    protected synchronized WebDriver getDriver() {
        return new DriverStore().getWebDriver();
    }
}
