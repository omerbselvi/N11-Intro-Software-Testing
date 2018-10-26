package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    By btnSignUp = By.cssSelector(".btnSignUp");
    By btnSignIn = By.cssSelector(".btnSignIn");

    public LoginPage clickToLogin() {
        clickTo(btnSignIn);
        return new LoginPage(driver);
    }

    public void clickToRegister() {
        clickTo(btnSignUp);
    }
    public void clickToSearchInput(String searchValue){
        WebElement searchInput = driver.findElement(By.id("searchData"));
        searchInput.sendKeys(searchValue);
        WebElement searchButton = driver.findElement(By.cssSelector(".searchBtn"));
        searchButton.click();
    }

    public String getUserName() {
        return driver
                .findElement(By.className("user"))
                .getText();
    }

}
