package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasePage{

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    public String getProductName() {
        return driver
                .findElement(By.className("productName"))
                .getText();
    }
}
