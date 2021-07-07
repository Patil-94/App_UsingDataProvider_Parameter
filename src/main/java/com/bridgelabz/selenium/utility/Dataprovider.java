package com.bridgelabz.selenium.utility;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class Dataprovider
{
    //A dataprovider method with return type as 2D Array
    @DataProvider(name = "LoginDetails")
    public  Object[][] getDataFromProvider() throws IOException {

       Object data[][]= ExcelUtil.getTestData("sheet1");
       return data;
    }
}

