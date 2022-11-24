package com.ebebek.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSuccessTest implements ITest {

    String mEmail;
    String mPassword;
    WebDriver mDriver;
    public LoginSuccessTest(String email,String password,WebDriver driver)
    {
        mEmail = email;
        mPassword = password;
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
        Thread.sleep(2000);
        
        WebElement pswTxt = mDriver.findElement(By.id("txtPassword"));
        pswTxt.sendKeys(mPassword);
        Thread.sleep(10000);
    
        WebElement pswBtn = mDriver.findElement(By.id("btnSubmitPassword"));
        pswBtn.click();
        

        if(mDriver.getCurrentUrl().equals("https://www.e-bebek.com"))
        {
            System.out.println("Successfully logined"); 
            return true;   
        }
        else
        {
            System.out.println("Test Case Didn't Work");   
            return false; 
        }
    }
    
}
