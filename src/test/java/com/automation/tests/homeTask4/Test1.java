package com.automation.tests.homeTask4;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Test1 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void teardown() {

        driver.quit();
    }
     @Test
        public void days() {

         //DAYS
         //1. go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
         driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
         BrowserUtils.wait(5);
         driver.manage().window().maximize();
         BrowserUtils.wait(3);

         //2. Randomly select a checkbox. As soon as you check any day, print the name of the day
         //and uncheck immediately.

         //After you check and uncheck Friday for the third time, exit the program.
         //NOTE: Remember some checkboxes are not selectable. You need to find a way to ignore them
         //when they are randomly selected. It has to be dynamic. Do not hard code Saturday and Sunday.
         //Use values of certain attributes.

         List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
         BrowserUtils.wait(2);

         for (int i = 0; i < checkBoxes.size(); i++) {
             //       if visible,                            eligible to click  and         not clicked yet
             if (checkBoxes.get(i).isDisplayed() && checkBoxes.get(i).isEnabled() && (!checkBoxes.get(i).isSelected())) {
                 //if checkbox is not selected, click on it
                 checkBoxes.get(i).click(); // click on the checkbox
                 System.out.println(i + 1 + " checkbox clicked!");
             } else {
                 System.out.println(i + 1 + " checkbox wasn't clicked!");
             }
         }
     }    }