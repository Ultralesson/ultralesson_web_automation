package com.ultralesson.training.web;

import com.ultralesson.training.web.drivers.DriverCreator;
import com.ultralesson.training.web.models.Product;
import com.ultralesson.training.web.pages.HomePage;
import com.ultralesson.training.web.pages.LauncherPage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Epic("Search")
@Feature("Relevant Search")
public class SearchTests extends BaseTest {
    @Test(description = "When a user searches with a keyword, " +
            "relevant results for the keyword should be displayed to the user.")
    @Story("Verify If Search Term Shows Relevant Results")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyIfSearchTermShowsRelevantResults() {
        //Arrange
        String searchItem = "Jeans";
        String searchKey = "Jean";
        String browser = "chrome";
        WebDriver webDriver = new DriverCreator().createDriverContext(browser).create();
        LauncherPage launcherPage = new LauncherPage(webDriver);
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

        //Act
        HomePage homepage = new HomePage(webDriver);
        homepage.search(searchItem);
        List<Product> searchProducts = homepage.getSearchItems();

        //Assert
        Assert.assertEquals(4, searchProducts.size());
        Assert.assertTrue(searchProducts.stream().allMatch(product -> product.getName().contains(searchKey)));
    }
}
