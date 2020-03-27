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

import java.util.List;

public class TestCase6 {


    @Test
    public void emailManage() {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

//    Step 1. Go to "https://www.tempmailaddress.com/"
        driver.get("https://www.tempmailaddress.com");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
//Step 2. Copy and save email as a string.
        String email = driver.findElement(By.className("animace")).getText();
        //Step3 “https://practice-cybertekschool.herokuapp.com”")
         driver.navigate().to("“https://practice-cybertekschool.herokuapp.com”");
        BrowserUtils.wait(5);
 //Step 4. And click on “Sign Up For Mailing List".
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
 //Step 5. Enter any valid name.
         driver.findElement(By.name("full_name")).sendKeys("Javante", Keys.ENTER);
        BrowserUtils.wait(5);
 //Step 6. Enter email from the Step 2.
        driver.findElement(By.name("email")).sendKeys("yves.adarien@aallaa.org", Keys.ENTER);
 //Step 7. Click Sign Up
         driver.findElement(By.id("wooden_spoon")).click();
         BrowserUtils.wait(5);
 //Step 8. Verify that following message is displayed:
 //“Thank you for signing up. Click the button below to
 //return to the home page.”
        WebElement actual = driver.findElement(By.name("signup_message"));
        Assert.assertTrue(actual.isDisplayed());
         BrowserUtils.wait(5);
 //Step 9. Navigate back to the “https://
 //www.tempmailaddress.com/”
        driver.navigate().back();
         BrowserUtils.wait(5);
 //Step 10. Verify that you’ve received an email from
 //“do-not-reply@practice.cybertekschool.com”
        WebElement emailAd = driver.findElement(By.xpath("//table/tbody/tr[1]/td"));
         System.out.println("displayed :" + emailAd.isDisplayed());
         System.out.println("emailAd :" + emailAd.getText());
         String displayedEmail = emailAd.getText().trim();
       Assert.assertEquals(displayedEmail, "do-not-reply@practice.cybertekschool.com");

         BrowserUtils.wait(5);
 //Step 11. Click on that email to open it.
         driver.findElement(By.xpath("//*[@id=\"schranka\"]")).click();
 //Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
         String expected2 = "do-notreply@practice.cybertekschool.com ";
        String actual2 = driver.findElement(By.id("odesilatel")).getText();
       Assert.assertEquals(actual2, expected2);
         BrowserUtils.wait(5);
 //Step 13. Verify that subject is: “Thanks for
////subscribing to practice.cybertekschool.com!”

        String expected3 = "Thanks for subscribing to practice.cybertekschool.com!";
        String actual3 = driver.findElement(By.id("predmet")).getText();
      Assert.assertEquals(actual3, expected3);

         driver.manage().window().maximize();
         BrowserUtils.wait(5);


        driver.quit();
     }

 }



