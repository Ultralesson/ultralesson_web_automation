package com.ultralesson.training.web.pages;

import com.ultralesson.training.web.pages.BasePage;
import com.ultralesson.training.web.pages.CreateAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

  By createAccount = By.cssSelector("a[href='/account/register']");

  public LoginPage(WebDriver webDriver) {
    super(webDriver);
  }


  public CreateAccountPage navigateToCreateAccountPage() {
    actions.click(createAccount);
    return new CreateAccountPage(webDriver);
  }
}
