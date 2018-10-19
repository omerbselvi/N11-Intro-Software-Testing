package com.n11.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmokeTEST {

    @Test
    public void openWebsite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/omerbselvi/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.n11.com");
    }
    @Test
    public void loginToWebsite(){
        System.setProperty("webdriver.chrome.driver", "/Users/omerbselvi/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.n11.com");
        WebElement signInBtn = driver.findElement(By.cssSelector(".btnSignIn"));
        signInBtn.click();
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("loginButton"));

        emailInput.sendKeys("testbau@mailinator.com");
        passwordInput.sendKeys("123qwe");
        loginBtn.click();
        WebElement userElement = driver.findElement(By.className("user"));

        Assert.assertTrue(userElement.getText().equals("Test Bau"));
        //Assert.assertEquals("Test Bau", userElement.getText());
    }
    @Test
    public void registerToWebsite(){
        System.setProperty("webdriver.chrome.driver", "/Users/omerbselvi/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.n11.com");
        WebElement regBtn = driver.findElement(By.cssSelector(".btnSignUp"));
        regBtn.click();
        WebElement nameInput = driver.findElement(By.id("firstName"));
        WebElement surnameInput = driver.findElement(By.id("lastName"));
        WebElement registrationEmailInput = driver.findElement(By.id("registrationEmail"));
        WebElement passwordInput = driver.findElement(By.id("registrationPassword"));
        WebElement passwordAgainInput = driver.findElement(By.id("passwordAgain"));
        WebElement genderMaleInput = driver.findElement(By.id("genderMale"));
        WebElement acceptContractInput = driver.findElement(By.id("acceptContract"));
        WebElement submitBtn = driver.findElement(By.id("submitButton"));

        nameInput.sendKeys("Name");
        surnameInput.sendKeys("Surname");
        registrationEmailInput.sendKeys("testforregister@mailinator.com");
        passwordInput.sendKeys("123");
        passwordAgainInput.sendKeys("123");
        genderMaleInput.click();
        acceptContractInput.click();
        submitBtn.click();
        WebElement userElement = driver.findElement(By.className("user"));
        Assert.assertTrue(userElement.getText().equals("Name Surname"));
    }
}
