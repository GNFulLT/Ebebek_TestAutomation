package com.ebebek.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailWrongTest implements ITest{

    String mEmail;
    WebDriver mDriver;

    public EmailWrongTest(String email,WebDriver driver)
    {
        mEmail = email;
        mDriver = driver;
    }

    @Override
    public boolean run() throws InterruptedException {
        mDriver.get("https://www.e-bebek.com/login");    
        //!: Goto login page
        WebElement btnWithLogin = mDriver.findElement(By.id("btnLoginWithEmail"));
        btnWithLogin.click();
        Thread.sleep(2000);
        //!: Get Email
        WebElement loginTxt = mDriver.findElement(By.id("txtEmail"));
        loginTxt.sendKeys(mEmail);
        Thread.sleep(2000);

        WebElement loginBtn = mDriver.findElement(By.id("btnSubmitLogin"));
        loginBtn.click();
        Thread.sleep(6000);        
        
        try
        {
            WebElement pswTxt = mDriver.findElement(By.id("txtPassword"));
        }
        catch(NoSuchElementException ex)
        {
            System.out.println("Test case successed");
            return true;
        }

        System.out.println("Test didn't work");
        return false;
        
    }
    
}
