package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    By btnSignUp = By.cssSelector(".btnSignUp");
    By btnSignIn = By.cssSelector(".btnSignIn");
    By searchData = By.id("searchData");
    By searchBtn = By.cssSelector(".searchBtn");
    By user = By.className("user");
    By firstProduct = By.cssSelector(".catGroup .tabPanel.active li");

    public LoginPage clickToLogin() {
        clickTo(btnSignIn);
        return new LoginPage(driver);
    }

    public void clickToRegister() {
        clickTo(btnSignUp);
    }
    public void clickToSearchInput(String searchValue){
        write(searchData, searchValue);
        clickTo(searchBtn);
    }

    public String getUserName() {
        return driver
                .findElement(user)
                .getText();
    }

    public ProductPage getFirstProduct() {
        driver.findElement(firstProduct).click();
        return new ProductPage(driver);
    }

}
