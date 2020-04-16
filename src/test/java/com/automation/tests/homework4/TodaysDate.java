package com.automation.tests.homework4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TodaysDate {
    //TODAYS DATE1.go to http://practice.cybertekschool.com/dropdown
    // 2.verify that dropdowns under
    // Select your date of birth display current year, month,day
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
        driver.quit();
    }

    @Test
    public void todaysDate() {
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select yearSelect = new Select(driver.findElement(By.id("year")));
        Select monthSelect = new Select(driver.findElement(By.id("month")));
        Select daySelect = new Select(driver.findElement(By.id("day")));


        String year = yearSelect.getFirstSelectedOption().getText();
        String month = monthSelect.getFirstSelectedOption().getText();
        String day = daySelect.getFirstSelectedOption().getText();

        Assert.assertEquals(year, "2020");
        Assert.assertEquals(month, "April");
        Assert.assertEquals(day, "8");

    }

    //    YEARS, MONTHS, DAYS
//1. go to http://practice.cybertekschool.com/dropdown
//2. select a random year under Select your date of birth
//3. select month January
//4. verify that days dropdown has current number of days
//5. repeat steps 3, 4 for all the months
//NOTE: if you randomly select a leap year, verify February has 29 days

    @Test
    public void yearsMonthsDays() {
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select year = new Select(driver.findElement(By.id("year")));
        Select month = new Select(driver.findElement(By.id("month")));
        Select day = new Select(driver.findElement(By.id("day")));

    }
}