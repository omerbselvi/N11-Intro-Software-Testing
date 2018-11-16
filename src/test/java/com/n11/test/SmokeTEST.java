package com.n11.test;

import com.n11.test.pages.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SmokeTest extends BaseTest {

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

    @Test
    //For exam
    public void login(){
        By signIn = By.className("btnSignIn");
        driver.findElement(signIn).click();
        By email = By.xpath("//*[@id='email']");
        driver.findElement(email).sendKeys("testbau@mailinator.com");
        By password = By.xpath("//*[@id='password']");
        driver.findElement(password).sendKeys("123qwe");
        By signInBtn = By.cssSelector("#loginButton");
        driver.findElement(signInBtn).click();
        By username = By.className("user");
        String usernameString =  driver.findElement(username).getText();
        assertThat("login not succesfull", usernameString, is(equalTo("Test Bau")));
        By searchData = By.id("searchData");
        driver.findElement(searchData).sendKeys("playstation");
        driver.findElement(By.className("searchBtn")).click();
        List<WebElement> pages = driver.findElements(By.cssSelector(".pagination a"));
        Random rand = new Random();
        pages.get(rand.nextInt(pages.size())).click();
        List<WebElement> products = driver.findElements(By.cssSelector(".columnContent .pro a"));
        products.get(rand.nextInt(products.size())).click();
        BasePage basePage = new BasePage(driver);
        basePage.clickTo(By.className("btnAddBasket"));
        basePage.clickTo(By.className("myBasket"));
        List<WebElement> basketProducts = driver.findElements(By.cssSelector(".productGroup .prod"));
        if (basketProducts.size() > 0){
            System.out.println("YOU DID IT PAL");
        }
    }

}
