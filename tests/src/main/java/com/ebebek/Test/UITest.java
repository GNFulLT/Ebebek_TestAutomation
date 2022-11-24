package com.ebebek.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UITest implements ITest{

    WebDriver mDriver;
    String mSearchText;
    public UITest(String searchText,WebDriver driver)
    {
        mDriver = driver;
        mSearchText = searchText;
    }
    

    @Override
    public boolean run() throws InterruptedException {
        mDriver.get("https://www.e-bebek.com/");

        WebDriverWait wait = new WebDriverWait(mDriver,Duration.ofSeconds(10));

        mDriver.manage().window().maximize();

        //!: Get SearchBox
        WebElement searchBox = mDriver.findElement(By.id("txtSearchBox"));
        searchBox.sendKeys(mSearchText);
        Thread.sleep(2000);
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        List<WebElement> findedProducts = mDriver.findElements(By.tagName("eb-product-list-item"));
        System.out.println(findedProducts.size());
        if(findedProducts.isEmpty())
        {
            System.out.println("Couldn't find anything about the given search text");
            return false;
        }

        int maxIter = Math.min(3,findedProducts.size());

        for(int i = 0;i<maxIter-1;i++)
        {
            WebElement addCart = findedProducts.get(i).findElement(By.id("addToCartBtn"));
            ((JavascriptExecutor)mDriver).executeScript("arguments[0].scrollIntoView(true);",
            addCart);
            wait.until(ExpectedConditions.elementToBeClickable(addCart));
            addCart.click();
            Thread.sleep(5000);
            try
            {
                WebElement continueAdd = mDriver.findElement(By.id("btnContinueShopping"));
                continueAdd.click();
                Thread.sleep(5000);
            }
            catch(Exception e)
            {

            }
        }

        WebElement addCart = findedProducts.get(maxIter-1).findElement(By.id("addToCartBtn"));
        ((JavascriptExecutor)mDriver).executeScript("arguments[0].scrollIntoView(true);",
        addCart);
            wait.until(ExpectedConditions.elementToBeClickable(addCart));

        addCart.click();
        Thread.sleep(2000);
        try
        {
            WebElement gotoCart = mDriver.findElement(By.id("btnShowCart"));
            gotoCart.click();
            Thread.sleep(5000);
        }
        catch(Exception ex)
        {

        }

        try
        {
            WebElement completeShopping = mDriver.findElement(By.id("btnGoToShippingAddress"));

            List<WebElement> productItems = mDriver.findElements(By.className("basket-product-item"));
            if(productItems.size() != maxIter)
            {
                System.out.println("Test Didn't work, Basket item product didn't equals");
                return false;
            }

            System.out.println("Test Case Successed");
            return true;
        }
        catch(Exception ex)
        {
            System.out.println("Test Didn't work");
            return false;
        }

    }
    
}
