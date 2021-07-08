package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.CrossBrowserClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends CrossBrowserClass {

    /* @Description - Using FindBy for locating elements */
    @FindBy(id = "email")
    WebElement emailid;

    @FindBy(name = "pass")
    WebElement userPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    /*create a parameterized constuctor.
    initialization*/
    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) throws InterruptedException {
        Thread.sleep(300);
        emailid.sendKeys(username);
        Thread.sleep(200);
        System.out.println("email is : " + username);
        userPassword.sendKeys(password);
        System.out.println("email is : " + password);
        Thread.sleep(200);
        loginBtn.click();
        Thread.sleep(200);

    }
}

