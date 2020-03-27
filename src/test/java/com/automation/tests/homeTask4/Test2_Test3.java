package com.automation.tests.homeTask4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2_Test3 {


    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(" http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void teardown() {

        driver.quit();
    }

    @Test
    public void todayDate() {
        //TODAYS DATE
        //1. go to http://practice.cybertekschool.com/dropdown
        //2. verify that dropdowns under Select your date of birth display current year, month, day
        driver.findElement(By.id("year")).sendKeys("2020", Keys.ENTER);
        driver.findElement(By.id("month")).sendKeys("March", Keys.ENTER);
        driver.findElement(By.id("day")).sendKeys("25", Keys.ENTER);

//        String expected1 ="2020";
//        String actual1 = driver.findElement(By.id("year")) .getText();
//        Assert.assertEquals(actual1,expected1);
//
//        String expected2 ="March";
//        String actual2 =  driver.findElement(By.id("month")) .getText();
//        Assert.assertEquals(actual2,expected2);
//
//        String expected3 ="25";
//        String actual3 = driver.findElement(By.id("day")) .getText();
//        Assert.assertEquals(actual3,expected3);
    }

    @Test
    public void selectDate() {


        //YEARS, MONTHS, DAYS
        //1. go to http://practice.cybertekschool.com/dropdown
        //2. select a random year under Select your date of birth
        driver.findElement(By.id("year")).sendKeys("2020", Keys.ENTER);
        //3. select month January
        driver.findElement(By.id("month")).sendKeys("January", Keys.ENTER);
        //4. verify that days dropdown has current number of days
        driver.findElement(By.id("day")).sendKeys("25", Keys.ENTER);

        //5. repeat steps 3, 4 for all the months
        //NOTE: if you randomly select a leap year, verify February has 29 days

    }

}