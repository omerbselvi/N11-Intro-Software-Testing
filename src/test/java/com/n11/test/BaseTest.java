package com.n11.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    WebDriver driver;

    @Before
    public void startUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/omerbselvi/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.n11.com");
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
