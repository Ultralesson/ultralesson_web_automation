package com.ultralesson.training.web.drivers.managers;

import com.ultralesson.training.web.drivers.DriverManager;
import org.openqa.selenium.WebDriver;

public class FirefoxDriverManager implements DriverManager<WebDriver> {
    @Override
    public WebDriver create() {
        return new io.github.bonigarcia.wdm.managers.FirefoxDriverManager().create();
    }
}
