package com.ultralesson.training.web;

import com.ultralesson.training.web.models.Item;
import com.ultralesson.training.web.pages.HomePage;
import com.ultralesson.training.web.pages.LauncherPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {
    @Test
    public void verifyIfSearchTermShowsRelevantResults() {
        //Arrange
        String searchItem = "Jeans";
        String searchKey = "Jean";
        WebDriver webDriver = null;
        LauncherPage launcherPage = new LauncherPage(webDriver); // Assume webdriver is created and handy
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

        //Act
        HomePage homepage = new HomePage(webDriver);
        homepage.search(searchItem);
        List<Item> searchItems = homepage.getSearchItems();

        //Assert
        Assert.assertEquals(4, searchItems.size());
        Assert.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains("Jean")));
    }
}
