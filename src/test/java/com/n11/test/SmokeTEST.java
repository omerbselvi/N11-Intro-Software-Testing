package com.n11.test;

import com.n11.test.pages.HomePage;
import com.n11.test.pages.LoginPage;
import com.n11.test.pages.RegisterPage;
import com.n11.test.pages.SearchResultPage;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SmokeTEST extends BaseTest {
    @Test
    public void shouldRegisterToWebsite(){
        HomePage homePage = new HomePage(driver);
        homePage.clickToRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register();

        assertThat("Register Not Succesfull", homePage.getUserName(), equalTo("Nameee Surnameee")); //For better logging
        //assertTrue(homePage.getUserName().equals("Nameee Surnameee"));
    }

    @Test
    public void shouldSearch(){
        HomePage homePage = new HomePage(driver);
        homePage.clickToSearchInput( "Red Dead Redemption 2");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        assertThat("Search Not Successful", searchResultPage.getProductName(), containsString("Red Dead Redemption 2")); //For better logging
        //assertTrue(searchResultPage.getProductName().contains("Red Dead Redemption 2"));
    }

    @Test
    public void shouldNotLoginToHomePage(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickToLogin();
        loginPage.login("asddsa123");
        assertThat(true, equalTo(loginPage.isErrorDisplayed("password"))); //For better logging
    }

    @Test
    public void shouldLogin() {

        HomePage homePage = new HomePage(driver);
        homePage.clickToLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        assertThat("Login Not Successful", homePage.getUserName(), equalTo("Test Bau")); //For better logging
        //assertTrue(homePage.getUserName().equals("Test Bau"));
    }
}
