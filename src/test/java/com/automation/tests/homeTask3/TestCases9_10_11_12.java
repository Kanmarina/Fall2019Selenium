package com.automation.tests.homeTask3;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases9_10_11_12 {
    //Optional: If you want to to be a real selenium hero,
    //use @DataProvider for for tests cases from 9
    //through 12.
    //Please use following documentation: https://
    //testng.org/doc/documentationmain.html#parameters-dataproviders


      private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(5);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        //Step 2. And click on “Status Codes”.
        driver.findElement(By.linkText("Status Codes")).click();
    }

    @AfterMethod
    public void teardown() {

        driver.quit();
    }

    @Test
    public void statusCodes9() {
        //Step 3. Then click on “200”.
        driver.findElement(By.linkText("200")).click();
        //Step 4. Verify that following message is displayed:
        //“This page returned a 200 status code”
        String expectedMessage = "This page returned a 200 status code";
        WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
        String actualMessage = displayedMessageElement.getText();

    }
        //Test case #10
        @Test
        public void statusCodes10() {
            //Step 3. Then click on “301”.
            driver.findElement(By.linkText("301")).click();
            //Step 4. Verify that following message is displayed:
            //“This page returned a 301 status code”
            String expectedMessage = "This page returned a 301 status code";
            WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
            String actualMessage = displayedMessageElement.getText();

        }

        //Test case #11
        @Test
        public void statusCodes11() {
            //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
            //Step 3. And click on “Status Codes”.
            //Step 4. Then click on “404”.
            driver.findElement(By.linkText("404")).click();
            //Step 5. Verify that following message is displayed:
            //“This page returned a 404 status code”
            String expectedMessage = "This page returned a 404 status code";
            WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
            String actualMessage = displayedMessageElement.getText();
        }


        //Test case #12
        @Test
        public void statusCodes12() {
            //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
            //Step 3. And click on “Status Codes”.
            //Step 4. Then click on “500”.
            driver.findElement(By.linkText("500")).click();
            //Step 5. Verify that following message is displayed:
            //“This page returned a 500 status code”
            String expectedMessage = "This page returned a 404 status code";
            WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
            String actualMessage = displayedMessageElement.getText();
        }
    }
