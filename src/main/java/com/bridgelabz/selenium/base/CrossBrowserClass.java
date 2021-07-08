package com.bridgelabz.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class CrossBrowserClass {

    public static WebDriver crossDriver;
    @BeforeTest

    @Parameters("browserName")
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("Edge")) {
            // If the browser is Firefox, then do this

            WebDriverManager.firefoxdriver().setup();
            WebDriverManager.edgedriver().setup();
            crossDriver = new EdgeDriver();
            crossDriver.get("https://www.facebook.com/");
            crossDriver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("Chrome")) {

            //handle browser level show notification pop window
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            WebDriverManager.chromedriver().setup();
            crossDriver = new ChromeDriver(options);
            crossDriver.get("https://www.facebook.com/");
            crossDriver.manage().window().maximize();
        } else {

            System.out.println("Incorrect browser value passed");
        }
    }

    @AfterTest
    public void closeBrowser() {
        crossDriver.quit();
    }
}

