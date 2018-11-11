package com.n11.test.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BasePage {
    WebDriver driver;

    By cookieUsagePopIn = By.id("cookieUsagePopIn");
    By closeCookiePopup = By.className("closeBtn");

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void waitElementClickable(By by){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(elementToBeClickable(by));
    }

    public void waitElementVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(visibilityOf(element));
    }

    public void waitElementInvisible(By by){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(invisibilityOfElementLocated(by));
    }

    public void  jsClick(String id){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById("+id+")");
    }

    public void write(By by, String value){
        findElement(by).sendKeys(value);
    }

    public void clickTo(By by){
        try {
            findElement(by).click();
        } catch (WebDriverException ex) {
            if (ex.getMessage().contains("is not clickable at point")) {
                findElement(closeCookiePopup).click();
                waitElementInvisible(cookieUsagePopIn);
                findElement(by).click();
            }
        }
    }

    public WebElement findElement(By by){
        waitElementClickable(by);
        return driver.findElement(by);
    }
}
