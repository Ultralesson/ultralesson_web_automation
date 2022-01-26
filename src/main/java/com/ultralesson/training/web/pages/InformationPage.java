package com.ultralesson.training.web.pages;

import com.ultralesson.training.web.models.Address;
import com.ultralesson.training.web.models.Cart;
import com.ultralesson.training.web.models.Customer;
import org.openqa.selenium.WebDriver;

public class InformationPage extends BasePage {

    public InformationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillShippingAddress(Address shippingAddress) {

    }

    public Customer getContactInformation() {
        return new Customer();
    }

    public Cart getCartDetails() {
        return new Cart();
    }

    public ShippingPage continueToShipping() {
        return new ShippingPage(webDriver);
    }
}
