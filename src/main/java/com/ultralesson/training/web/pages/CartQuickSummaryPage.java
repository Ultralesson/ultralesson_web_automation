package com.ultralesson.training.web.pages;

import com.ultralesson.training.web.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartQuickSummaryPage extends BasePage{

    By productName = By.cssSelector("h3[class^='cart-notification-product__name']");
    By productSize = By.xpath("//div[@class='product-option']/dt[text()='Size: ']/following-sibling::dd");
    By productColor = By.xpath("//div[@class='product-option']/dt[text()='Color: ']/following-sibling::dd");

    By viewMyCart = By.id("cart-notification-button");

    public CartQuickSummaryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public Product getItemAddedToCart() {
        return Product
                .builder()
                .name(actions.getText(productName))
                .size(actions.getText(productSize))
                .color(actions.getText(productColor))
                .build();
    }

    public CartPage viewMyCart() {
        actions.click(viewMyCart);
        return new CartPage(webDriver);
    }
}
