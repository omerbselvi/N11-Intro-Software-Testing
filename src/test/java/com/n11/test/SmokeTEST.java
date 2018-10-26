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
        HomePage homePage = new HomePage();
        homePage.clickToRegister(driver);

        RegisterPage registerPage = new RegisterPage();
        registerPage.register(driver);

        assertTrue(homePage.getUserName(driver).equals("Nameee Surnameee"));
    }

    @Test
    public void shouldSearch(){
        HomePage homePage = new HomePage();
        homePage.clickToSearchInput(driver, "Red dead redemption 2");
        SearchResultPage searchResultPage = new SearchResultPage();
        assertTrue(searchResultPage.getProductName(driver).contains("Red Dead Redemption 2"));
    }

    @Test
    public void shouldNotLoginToHomePage(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.clickToLogin(driver);
        loginPage.login(driver, "asddsa123");
    }

    @Test
    public void shouldLogin() {

        HomePage homePage = new HomePage();
        homePage.clickToLogin(driver);

        LoginPage loginPage = new LoginPage();
        loginPage.login(driver);

        assertTrue(homePage.getUserName(driver).equals("Test Bau"));
    }
}
