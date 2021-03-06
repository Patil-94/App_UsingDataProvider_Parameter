package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.pages.Login;
import com.bridgelabz.selenium.pages.Logout;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParameterTest extends BaseClass {
    @Test
    @Parameters({"username","password"})
    public void loginToParameterTest(String userName, String passWord) throws InterruptedException
    {
        //create the object of Login class
        Login login = new Login(driver);
        login.login(userName,passWord);

        //create object of logout class
        Logout logout =new Logout(driver) ;
        logout.logoutApplication();

        String actualUrl= driver.getCurrentUrl();
        System.out.println(actualUrl);

        //validation
        String expectedUsername="latikakhairnar10@gmail.com";
        Assert.assertEquals(userName,expectedUsername);

    }
}
