package com.ultralesson.training.web.pages;

import com.ultralesson.training.web.models.Card;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

    public PaymentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PaymentPage enterCardDetails(Card cardDetails) {
        return this;
    }

    public OrderConfirmationPage payNow() {
        return new OrderConfirmationPage(webDriver);
    }
}
