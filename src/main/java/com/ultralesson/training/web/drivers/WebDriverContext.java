package com.ultralesson.training.web.drivers;

import org.openqa.selenium.WebDriver;

public class WebDriverContext {

  private DriverManager<WebDriver> driverManager;

  public WebDriverContext(DriverManager<WebDriver> driverManager) {
    setWebDriver(driverManager);
  }

  public WebDriver create() {
    return driverManager.create();
  }

  public void setWebDriver(DriverManager<WebDriver> driverManager) {
    this.driverManager = driverManager;
  }
}
