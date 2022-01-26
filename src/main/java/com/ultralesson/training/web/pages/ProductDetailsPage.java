package com.ultralesson.training.web.pages;

import com.ultralesson.training.web.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    String sizeDynamicLocator = "input[name='Size'][value='%s'] + label";
    String colorDynamicLocator = "input[name='Color'][value='%s'] + label";

    By quantityBy = By.name("quantity");
    By addToCart = By.name("add");

    public ProductDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductDetailsPage selectSize(String size) {
        By sizeBy = By.cssSelector(String.format(sizeDynamicLocator, size));
        actions.click(sizeBy);
        return this;
    }

    public ProductDetailsPage selectColor(String color) {
        By colorBy = By.cssSelector(String.format(colorDynamicLocator, color));
        actions.click(colorBy);
        return this;
    }

    public ProductDetailsPage selectQuantity(String quantity) {
        actions.clear(quantityBy).type(quantityBy, quantity);
        return this;
    }

    public ProductDetailsPage updateAddtionalProductDetails(Product productToBuy) {
        return this;
    }

    public CartQuickSummaryPage addToCart() {
        actions.click(addToCart);
        return new CartQuickSummaryPage(webDriver);
    }
}
