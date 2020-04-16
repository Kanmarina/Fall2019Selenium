package com.automation.tests.homework5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests1 {
    /*
    Test Case #1 1.Go to “https://qa1.vytrack.com/"
    2.Login as a store manager
    3.Navigate to “Activities -> Calendar Events”
    4.Hover on three dots “...” for “Testers meeting” calendar event
    5.Verify that “view”, “edit” and “delete” options are available
     */

    private WebDriver driver;
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
   // private By createCalendarEventBtnBy = By.cssSelector("a[title='Create Calendar event']");
    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        BrowserUtils.wait(3);
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(2);

//
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test1(){
        Actions actions = new Actions(driver);
        //hover over Activities
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();

        BrowserUtils.wait(5);
        actions.moveToElement(driver.findElement(By.className("action-cell grid-cell grid-body-cell"))).perform();
    }

    /*
    Test Case #2 1.Go to “https://qa1.vytrack.com/"
    2.Login as a store manager
    3.Navigate to “Activities -> Calendar Events”
    4.Click on “Grid Options” button
    5.Deselect all options except “Title”
    6.Verify that “Title” column still displayed
     */
 //   @Test
//    public void test2(){

}
