package com.n11.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    WebDriver driver;

    @Before
    public void startUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        ChromeOptions options = new ChromeOptions();
//        try {
//            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        driver.get("https://www.n11.com");
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
