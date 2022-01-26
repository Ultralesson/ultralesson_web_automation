package com.ultralesson.training.web.pages;

import com.ultralesson.training.web.models.Cart;
import com.ultralesson.training.web.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

  By cartItemName = By.cssSelector("a[class^='cart-item__name']");
  By productSize =
      By.xpath("//div[@class='product-option']/dt[text()='Size: ']/following-sibling::dd");
  By productColor =
      By.xpath("//div[@class='product-option']/dt[text()='Color: ']/following-sibling::dd");
  By productPrice = By.cssSelector("span[class^='price price--end']");

  By cartItems = By.className("cart-item");
  By subtotal = By.cssSelector("p[class$='totals__subtotal-value']");
  By checkout = By.cssSelector("button[id='checkout']");

  public CartPage(WebDriver webDriver) {
    super(webDriver);
  }

  public Cart getCartDetails() {

    return Cart.builder().products(getProductsInCart()).subTotal(actions.getText(subtotal)).build();
  }

  private List<Product> getProductsInCart() {
    List<Product> productsInCart = new ArrayList<>();
    waits
        .waitUntilAllElementsAreVisible(cartItems)
        .forEach(
            webElement -> {
              Product product =
                  Product.builder()
                      .name(actions.getChildText(webElement, cartItemName))
                      .size(actions.getChildText(webElement, productSize))
                      .color(actions.getChildText(webElement, productColor))
                      .price(actions.getChildText(webElement, productPrice))
                      .build();
              productsInCart.add(product);
            });
    return productsInCart;
  }

  public CheckoutPage checkout() {
    actions.click(checkout);
    return new CheckoutPage(webDriver);
  }
}
