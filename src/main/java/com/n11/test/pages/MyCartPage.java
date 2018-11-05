package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyCartPage extends BasePage{
    public MyCartPage(WebDriver driver) {
        super(driver);
    }

        By prodDescription = By.className("prodDescription");
        public String getProductName() {
            return driver.findElement(prodDescription).getText();
        }
}
