package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    By email = By.id("email");
    By password = By.id("password");
    By loginButton = By.id("loginButton");

    public void login() {
        login("123qwe");
    }

    public void login(String wrongPass) {
        write(email, "testbau@mailinator.com");
        write(password, wrongPass);
        clickTo(loginButton);
    }

    public boolean isErrorDisplayed(String warning) {
        return driver.findElement(By.cssSelector("[data-errormessagefor=" + warning + "]")).isDisplayed();
    }
}
