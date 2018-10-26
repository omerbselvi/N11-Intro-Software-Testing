package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public LoginPage clickToLogin(WebDriver driver) {
        driver.findElement(By.cssSelector(".btnSignIn")).click();
        return new LoginPage();
    }

    public void clickToRegister(WebDriver driver) {
        WebElement regBtn = driver.findElement(By.cssSelector(".btnSignUp"));
        regBtn.click();
    }
    public void clickToSearchInput(WebDriver driver, String searchValue){
        WebElement searchInput = driver.findElement(By.id("searchData"));
        searchInput.sendKeys(searchValue);
        WebElement searchButton = driver.findElement(By.cssSelector(".searchBtn"));
        searchButton.click();
    }

    public String getUserName(WebDriver driver) {
        return driver
                .findElement(By.className("user"))
                .getText();
    }

}
