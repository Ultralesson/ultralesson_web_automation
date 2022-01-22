package com.ultralesson.training.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageActions {

    private WebDriver webDriver;
    private PageWaits waits;

    public PageActions(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.waits = new PageWaits(webDriver);
    }

    public void click(By by) {
        waits.waitForElementToBePresent(by).click();
    }

    public void type(By by, String value) {
        waits.waitForElementToBePresent(by).sendKeys(value);
    }

    public String getText(By by) {
        return waits.waitForElementToBePresent(by).getText();
    }

    public String getChildText(WebElement parent, By by) {
        return parent.findElement(by).getText();
    }
}
