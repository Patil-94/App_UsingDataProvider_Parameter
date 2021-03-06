package com.bridgelabz.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
    public static WebDriver driver;
    //execute before test
    @BeforeTest
    public void setup() throws InterruptedException
    {
        //Handling browser level show notification popup window
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");

        //launch cromedriver
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(chromeOptions);

      /*  launch facebook url and maximaize windows */
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(500);
    }
    //execute after test
    @AfterTest
   /* teardown method for close the browser*/
    public void tearDown()
    {
        driver.close();
    }

}
