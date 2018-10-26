package com.n11.test;

import com.n11.test.pages.HomePage;
import com.n11.test.pages.LoginPage;
import com.n11.test.pages.RegisterPage;
import com.n11.test.pages.SearchResultPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class SmokeTEST extends BaseTest {
    @Test
    public void shouldRegisterToWebsite(){
        HomePage homePage = new HomePage(driver);
        homePage.clickToRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register();

        assertTrue(homePage.getUserName().equals("Nameee Surnameee"));
    }

    @Test
    public void shouldSearch(){
        HomePage homePage = new HomePage(driver);
        homePage.clickToSearchInput( "Red Dead Redemption 2");
        SearchResultPage searchResultPage = new SearchResultPage();
        assertTrue(searchResultPage.getProductName(driver).contains("Red Dead Redemption 2"));
    }

    @Test
    public void shouldNotLoginToHomePage(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickToLogin();
        loginPage.login("asddsa123");
    }

    @Test
    public void shouldLogin() {

        HomePage homePage = new HomePage(driver);
        homePage.clickToLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        assertTrue(homePage.getUserName().equals("Test Bau"));
    }
}
