package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    public void register(WebDriver driver){
        WebElement nameInput = driver.findElement(By.id("firstName"));
        WebElement surnameInput = driver.findElement(By.id("lastName"));
        WebElement registrationEmailInput = driver.findElement(By.id("registrationEmail"));
        WebElement passwordInput = driver.findElement(By.id("registrationPassword"));
        WebElement passwordAgainInput = driver.findElement(By.id("passwordAgain"));
        WebElement genderMaleInput = driver.findElement(By.id("genderMale"));
        WebElement acceptContractInput = driver.findElement(By.id("acceptContract"));
        WebElement submitBtn = driver.findElement(By.id("submitButton"));

        nameInput.sendKeys("Nameee");
        surnameInput.sendKeys("Surnameee");
        registrationEmailInput.sendKeys("testforregister321@mailinator.com");
        passwordInput.sendKeys("123qwe");
        passwordAgainInput.sendKeys("123qwe");
        genderMaleInput.click();
        acceptContractInput.click();
        submitBtn.click();
    }
}
