package com.automation.tests.homework4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Days {
    //DAYS1.go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
    // 2.Randomly select a checkbox.
    // As soon as you check any day, print the name of the day and uncheck immediately.
    // After you check and uncheck  for the third time, exit the program.
    // NOTE: Remember some checkboxes are not selectable.
    // You need to find a way to ignore them when they are randomly selected.
    // It has to be dynamic. Do not hard code Saturday and Sunday.
    // Use values of certain attributes.

    public WebDriver driver;

@BeforeMethod
    public void setup(){
     driver= DriverFactory.createDriver("chrome");
     driver.manage().window().maximize();

     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}
@AfterMethod
    public void teardown(){
    BrowserUtils.wait(2);
    driver.quit();
}
@Test
    public void days(){
    driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

    String day="";
    int count =0;

    while (count<3) {
        BrowserUtils.wait(2);
        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".gwt-CheckBox>label"));

        Random random = new Random();
        int randomNumber= random.nextInt(checkboxes.size());

        if (checkboxes.get(randomNumber).isEnabled()){
            checkboxes.get(randomNumber).click();

            day=checkboxes.get(randomNumber).getText();
            if (day.equals("Friday")){
                count++;

            }
            checkboxes.get(randomNumber).click();
        }

    }

}
}
