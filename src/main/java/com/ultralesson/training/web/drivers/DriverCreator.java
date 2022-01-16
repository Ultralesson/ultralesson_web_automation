package com.ultralesson.training.web.drivers;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DriverCreator {

    public WebDriver create(String browser) {
        browser = setDefaultBrowser(browser);
        switch (browser.toLowerCase()) {
            case "firefox":
                return new FirefoxDriverManager().create();
            case "edge":
                return new EdgeDriverManager().create();
            default:
                WebDriver webDriver = new ChromeDriverManager().create();
                return webDriver;
        }
    }


    public WebDriverContext createDriverContext(String browser) {
        browser = setDefaultBrowser(browser);
        DriverManager<WebDriver> webDriverDriverManager = getBrowserManagers().get(browser);
        return new WebDriverContext(webDriverDriverManager);
    }


    public Map<String, DriverManager<WebDriver>> getBrowserManagers() {
        Map<String,DriverManager<WebDriver>> driverManagerMap = new HashMap<>();
        driverManagerMap.put("chrome", new com.ultralesson.training.web.drivers.managers.ChromeDriverManager());
        driverManagerMap.put("firefox", new com.ultralesson.training.web.drivers.managers.FirefoxDriverManager());
        driverManagerMap.put("edge", new com.ultralesson.training.web.drivers.managers.EdgeDriverManager());
        return driverManagerMap;
    }

    private String setDefaultBrowser(String browser) {
        if(Objects.isNull(browser) || browser.isEmpty()) {
            browser = "chrome";
        }
        return browser;
    }
}
