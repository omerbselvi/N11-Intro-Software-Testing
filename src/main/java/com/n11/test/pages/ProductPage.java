package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    By addToCartButton = By.className("btnAddBasket");
    By productTitle = By.className("proName");
    By cartIcon = By.className("myBasket");

    public void addToCart() {
        clickTo(addToCartButton);
    }
    public String getProductName() {
        return driver.findElement(productTitle).getText();
    }
    public MyCartPage goToCart() {
        clickTo(cartIcon);
        return new MyCartPage(driver);
    }
}
