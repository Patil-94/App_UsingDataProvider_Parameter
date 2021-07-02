package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseClass {

    /* @Description - Using FindBy for locating elements */
    @FindBy(id = "email")
    WebElement emailid;

    @FindBy(name="pass")
    WebElement userPassword;

    @FindBy(xpath ="//button[@type='submit']")
    WebElement loginBtn;

    /*create a parameterized constuctor.
    initialization*/
    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void login (String userName, String passWord) throws InterruptedException
    {
            emailid.sendKeys(userName);
            userPassword.sendKeys(passWord);
            loginBtn.click();
            Thread.sleep(200);

        }
    }

