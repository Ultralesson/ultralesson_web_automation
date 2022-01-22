package com.ultralesson.training.web.pages;

import com.ultralesson.training.web.models.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    By searchIcon = By.cssSelector("summary[aria-label='Search']");
    By searchBar = By.id("Search-In-Modal");
    By searchResults = By.cssSelector("li[id^='predictive-search-option'] a");

    By productName = By.cssSelector(".predictive-search__item-heading");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage search(String searchItem) {
        actions.click(searchIcon);
        actions.type(searchBar, searchItem);
        return this;
    }

    public List<Item> getSearchItems() {
        List<WebElement> elements = waits.waitUntilAllElementsAreVisible(searchResults);
        List<Item> items = new ArrayList<>();
        for(WebElement element : elements) {
            String name = actions.getChildText(element, productName);
            Item item = new Item();
            item.setName(name);
            items.add(item);
        }
        return items;
    }
}
