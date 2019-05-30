package com.gmail;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    static WebDriver driver;

    @Before
    public void setup() {
        Configuration.loadProperties();
        System.setProperty(Configuration.NAME_DRIVER, Configuration.PATH_DRIVER);
        driver = new ChromeDriver();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
