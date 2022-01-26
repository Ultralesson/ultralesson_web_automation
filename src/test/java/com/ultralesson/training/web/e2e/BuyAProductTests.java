package com.ultralesson.training.web.e2e;

import com.ultralesson.training.web.drivers.DriverCreator;
import com.ultralesson.training.web.models.Cart;
import com.ultralesson.training.web.models.Customer;
import com.ultralesson.training.web.models.OrderDetails;
import com.ultralesson.training.web.models.Product;
import com.ultralesson.training.web.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BuyAProductTests {

    @Test(groups = "wip")
    public void verifyThatFirstTimeUserIsAbleToBuyAProduct() {
       //Arrange
        Customer newCustomer = new Customer().init();
        Product productToBuy = new Product().init();
        WebDriver driver = new DriverCreator().createDriverContext("chrome").create();
        new LauncherPage(driver).navigateTo("https://web-playground.ultralesson.com/");

        //Act
        HomePage homePage = new HomePage(driver);
        ProductDetailsPage productDetailsPage = homePage.search(productToBuy.getSearchKeyword())
                .selectProduct(productToBuy.getName());

        CartQuickSummaryPage cartQuickSummaryPage = productDetailsPage
                .selectSize(productToBuy.getSize())
                .selectColor(productToBuy.getColor())
                .selectQuantity(productToBuy.getQuantity())
                .addToCart();

        Product productAddedToCart = cartQuickSummaryPage.getItemAddedToCart();


        //Assert
        Assert.assertEquals(productAddedToCart.getName(), productToBuy.getName());
        Assert.assertEquals(productAddedToCart.getSize(), productToBuy.getSize());
        Assert.assertEquals(productAddedToCart.getColor(), productToBuy.getColor());

        //Act
        CartPage cartPage = cartQuickSummaryPage.viewMyCart();
        Cart cartDetails = cartPage.getCartDetails();
        List<Product> productsInCart = cartDetails.getProducts();

        //Assert
        Assert.assertEquals(1, productsInCart.size());
        Product productInCart = productsInCart.get(0);
        Assert.assertEquals(productInCart.getName(), productToBuy.getName());
        Assert.assertEquals(productInCart.getSize(), productToBuy.getSize());
        Assert.assertEquals(productInCart.getColor(), productToBuy.getColor());

        //Act
        cartPage.checkout();
        CreateAccountPage createAccountPage = new LoginPage(driver).navigateToCreateAccountPage();
        createAccountPage.createAccount(newCustomer);

        // TODO: Complete the code from here as a challenge.
        InformationPage informationPage = new InformationPage(driver);
        informationPage.fillShippingAddress(newCustomer.getShippingAddress());
        Customer customerContactInformation = informationPage.getContactInformation();
        Cart cartDetailsInInformationPage = informationPage.getCartDetails();

        //Assert
        Assert.assertEquals(customerContactInformation.getFirstName(), newCustomer.getFirstName());
        Assert.assertEquals(customerContactInformation.getLastName(), newCustomer.getLastName());
        Assert.assertEquals(customerContactInformation.getEmail(), newCustomer.getEmail());

        Assert.assertEquals(cartDetailsInInformationPage.getSubTotal(), cartDetails.getSubTotal());
        Assert.assertEquals(cartDetailsInInformationPage.getCoupon(), cartDetails.getCoupon());
        Assert.assertEquals(cartDetailsInInformationPage.getCouponDiscount(), cartDetails.getCouponDiscount());
        Assert.assertEquals(cartDetailsInInformationPage.getTotal(), cartDetails.getTotal());


        //Act
        ShippingPage shippingPage = informationPage.continueToShipping();
        Cart cartDetailsInShippingPage = shippingPage.getUpdatedCartDetails();

        //Assert
        Assert.assertEquals(cartDetailsInShippingPage.getTaxes(), "₹51.24");

        //Act
        PaymentPage paymentPage = shippingPage.continueToPayment();
        OrderConfirmationPage orderConfirmationPage = paymentPage
                .enterCardDetails(newCustomer.getCardDetails())
                .payNow();
        OrderDetails orderDetails = orderConfirmationPage.getOrderDetails();

        //Assert
        Assert.assertFalse(orderDetails.getOrderId().isEmpty());
        Assert.assertEquals(orderDetails.getCustomerDetails(), newCustomer);
        Assert.assertEquals(orderDetails.getCartSummary(), cartDetailsInShippingPage);
    }
}
