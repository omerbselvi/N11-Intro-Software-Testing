package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    By email = By.id("email");
    By password = By.id("password");
    By loginButton = By.id("loginButton");

    public void login(WebDriver driver) {
        login(driver, "123qwe");
    }

    public void login(WebDriver driver, String wrongPass) {
        driver.findElement(email).sendKeys("testbau@mailinator.com");
        driver.findElement(password).sendKeys(wrongPass);
        driver.findElement(loginButton).click();
    }

    public boolean isErrorDisplayed(WebDriver driver, String warning) {
        return driver.findElement(By.cssSelector("[data-errormessagefor=" + warning + "]")).isDisplayed();
    }
}
