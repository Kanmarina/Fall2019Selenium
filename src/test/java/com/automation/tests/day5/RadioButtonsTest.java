package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonsTest {
    public static void main(String[] args) {
        //if DriverFActory doesn't work use it:
//         WebDriverManager.chromedriver().version("79").setup();
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);

        WebElement blackButton = driver.findElement(By.id("black"));
        //id always unique
        if(blackButton.isDisplayed() && blackButton.isEnabled()) {
            //isDisplayed - returns true if the element is visible
            System.out.println("Clicked in black button");
            blackButton.click();
            //how do we verify that button clicked
        } else{
            System.out.println("failed to click on black button");
        }
        if (blackButton.isSelected()){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }


    }
}
