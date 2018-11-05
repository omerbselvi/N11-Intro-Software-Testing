package com.n11.test;

import com.n11.test.pages.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SmokeTEST extends BaseTest {

    @Test
    public void shouldRegisterToWebsite(){
        HomePage homePage = new HomePage(driver);
        homePage.clickToRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register();

        assertThat("Register Not Succesfull", homePage.getUserName(), equalTo("Nameee Surnameee"));
    }

    @Test
    public void shouldSearch(){
        HomePage homePage = new HomePage(driver);
        homePage.clickToSearchInput( "Red Dead Redemption 2");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        assertThat("Search Not Successful", searchResultPage.getProductName(), containsString("Red Dead Redemption 2"));
    }

    @Test
    public void shouldNotLoginToHomePage(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickToLogin();
        loginPage.login("asddsa1234");
        assertThat(true, equalTo(loginPage.isErrorDisplayed("password")));
    }

    @Test
    public void shouldLogin() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickToLogin();
        loginPage.login();

        assertThat("Login Not Successful", homePage.getUserName(), equalTo("Test Bau"));
    }

    @Test
    public void isSearchedElementEqual(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickToLogin();
        loginPage.login();
        homePage.clickToSearchInput( "Red Dead Redemption 2");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        assertThat("Search Not Successful", searchResultPage.productNameElement(), equalTo("Red Dead Redemption 2"));
    }

    @Test
    public void shouldAddToCart() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.getFirstProduct();
        String productName = productPage.getProductName();
        productPage.addToCart();
        MyCartPage myCartPage = productPage.goToCart();
        assertThat("When a buyer adds a product to cart, ", myCartPage.getProductName(), is(equalTo(productName)));
    }
}
