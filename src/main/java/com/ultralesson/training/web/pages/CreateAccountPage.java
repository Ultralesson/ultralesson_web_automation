package com.ultralesson.training.web.pages;

import com.ultralesson.training.web.models.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends BasePage {

  By firstName = By.id("RegisterForm-FirstName");
  By lastName = By.id("RegisterForm-LastName");
  By email = By.id("RegisterForm-email");
  By password = By.id("RegisterForm-password");
  By create = By.xpath("//button[contains(text(), 'Create')]");

  public CreateAccountPage(WebDriver webDriver) {
    super(webDriver);
  }

  public void createAccount(Customer newCustomer) {
      actions.type(firstName, newCustomer.getFirstName())
              .type(lastName, newCustomer.getLastName())
              .type(email, newCustomer.getEmail())
              .type(password, newCustomer.getPassword())
              .click(create);
  }
}
