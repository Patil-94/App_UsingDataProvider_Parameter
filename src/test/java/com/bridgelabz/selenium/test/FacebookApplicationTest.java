package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.pages.Login;
import com.bridgelabz.selenium.pages.Logout;
import com.bridgelabz.selenium.utility.Dataprovider;
import org.testng.Assert;

import org.testng.annotations.Test;

public class FacebookApplicationTest extends BaseClass
{
    //mention data provider method name in test method
    @Test (dataProvider = "LoginDetails", dataProviderClass = Dataprovider.class)

    public void loginTo_Application_with_valid_credentials (String userName, String passWord) throws InterruptedException
    {
        //create object of Login Class
        Login login=new Login(driver);
        login.login(userName,passWord);

        //validation
        String actualUrl= driver.getCurrentUrl();
        String expected="https://www.facebook.com/";
        System.out.println(actualUrl);
        Assert.assertEquals(actualUrl,expected);
    }

    @Test (dataProvider = "LoginDetails", dataProviderClass = Dataprovider.class)
    public void logoutTo_Application(String userName, String passWord) throws InterruptedException {
        Login login=new Login(driver);
        login.login(userName,passWord);

        String actualUrl= driver.getCurrentUrl();
        System.out.println("url:"+actualUrl);

        //create object of logout class
        Logout logout =new Logout(driver) ;
        logout.logoutApplication();

        //validation
        String expectedUsername="latikakhairnar10@gmail.com";
        Assert.assertEquals(userName,expectedUsername);
    }
}
