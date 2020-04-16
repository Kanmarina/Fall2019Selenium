package com.automation.tests.homeTask3;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


//TestCase8
public class TestCase8 {

    private WebDriver driver;

    @Test
    public void autocomplete() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(5);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        //Step 2. And click on “Autocomplete”.
        driver.findElement(By.linkText("Autocomplete")).click();
        //Step 3. Enter “United States of America” into
        //country input box.
        driver.findElement(By.id("myCountry")).sendKeys("United States of America", Keys.ENTER);
        //Step 4. Verify that following message is displayed:
        //“You selected: United States of America”
        WebElement msg = driver.findElement(By.id("result"));
        BrowserUtils.wait(5);
        Assert.assertTrue(msg.isDisplayed());

        driver.quit();
    }
}