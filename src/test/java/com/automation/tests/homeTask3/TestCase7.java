package com.automation.tests.homeTask3;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//Note: use element.sendKeys(“/file/path”) with
//specifying path to the file for uploading. Run this
//method against “Choose File” button.
public class TestCase7 {
    private WebDriver driver;

    @Test
    public void verifyFileUploaded() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(5);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
       //Step 2. And click on “File Upload".
        driver.findElement(By.linkText("File Upload")).click();
        BrowserUtils.wait(3);
        //Step 3. Upload any file with .txt extension from your computer.
         driver.findElement(By.id("file-upload")).sendKeys("C:/Users/Simzi/Desktop/Muhtar notes/class note-1.txt");
         //Step 4: click Upload button
        driver.findElement(By.id("file-submit")).click();
        //Step 5. Verify that subject is: “File Uploaded!”
        String expected = "File Uploaded!";
        String actual = driver.findElement(By.xpath("//div/h3")).getText();
        Assert.assertEquals(actual, expected);
        //Step 6. Verify that uploaded file name is displayed.
        String expectedFileName = "class note-1.txt";
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName, expectedFileName);

        driver.quit();

    }

    }
