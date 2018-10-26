package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void write(By by, String value){
        driver.findElement(by).sendKeys(value);
    }

    public void clickTo(By by){
        driver.findElement(by).click();
    }
}
