package com.ebebek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ebebek.Test.EmailWrongTest;
import com.ebebek.Test.ITest;
import com.ebebek.Test.LoginSuccessTest;
import com.ebebek.Test.PasswordWrongTest;
import com.ebebek.Test.UITest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        //#: Params

        String email;
        


        //!: My chromedriver path. First step get the site
        System.setProperty("webdriver.chrome.driver", "C:\\QA\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        ITest test = new UITest("biberon",driver);
        boolean isSuccessed = test.run();
       
    }
}
