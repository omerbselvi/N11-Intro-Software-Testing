package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {


    public String getProductName(WebDriver driver) {
        return driver
                .findElement(By.className("productName"))
                .getText();
    }
}
