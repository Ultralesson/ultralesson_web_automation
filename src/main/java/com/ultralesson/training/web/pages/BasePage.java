package com.ultralesson.training.web.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected PageWaits waits;
    protected WebDriver webDriver;
    protected PageActions actions;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.waits = new PageWaits(webDriver);
        this.actions = new PageActions(webDriver);
    }
}
