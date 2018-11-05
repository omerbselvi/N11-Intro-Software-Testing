package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage{

    By productName = By.cssSelector(".productName");
    By productNameRDR = By.cssSelector(".resultText > h1");

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    public String getProductName() {
        return driver
                .findElement(productName)
                .getText();
    }
    public String productNameElement() {
        return driver
                .findElement(productNameRDR)
                .getText();
    }
}
