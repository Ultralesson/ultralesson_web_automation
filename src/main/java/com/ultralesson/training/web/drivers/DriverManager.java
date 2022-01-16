package com.ultralesson.training.web.drivers;

import org.openqa.selenium.WebDriver;

public interface DriverManager<Driver> {

    /**
     * Create a new driver
     * @return
     */
     Driver create();
}
