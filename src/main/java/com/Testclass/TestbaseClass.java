package com.Testclass;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by akshay.pokley on 10/15/2018.
 */
public class TestbaseClass {
   public static Properties properties;

    public static WebDriver driver;
    public TestbaseClass()
    {
        try{
           properties=new Properties();
            FileInputStream fileInputStream=new FileInputStream("");
            properties.load(fileInputStream);

        }catch (Throwable g)
        {
            System.out.println(g.getMessage());
        }
    }

    public static void Inisalization()
    {
        String Brwsername=properties.getProperty("browser");

        if(Brwsername.equals("Chrome"))
        {

        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(String.valueOf(properties.get("url")));


    }
}
