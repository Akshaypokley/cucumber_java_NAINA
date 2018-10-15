package com.java.pages.main;

import com.Testclass.TestbaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by akshay.pokley on 10/15/2018.
 */
public class loginbaseclass extends TestbaseClass {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='img1']")
    WebElement Applicationlogo;

    @FindBy(xpath = ".//*[@id='txtUN']")
    WebElement LoginID;

    @FindBy(xpath = ".//*[@id='txtPW']")
    WebElement Pass;

    @FindBy(xpath = ".//*[@id='btnLog']")

    WebElement Submit;


    public loginbaseclass(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!Applicationlogo.isDisplayed())
            throw  new IllegalStateException("This is not login page");

    }


    public WebElement getApplicationlogo()
    {
        return  Applicationlogo;
    }

    public  void setPass(String pass)
    {
        Pass.sendKeys(pass);
    }

    public void setLoginID(String loginID)
    {
        LoginID.sendKeys(loginID);
    }

    public void clickSubmit()
    {
        Submit.click();
    }

    public void clearPass()
    {
        Pass.clear();
    }

    public void clearLoginID()
    {
        LoginID.clear();
    }
}
