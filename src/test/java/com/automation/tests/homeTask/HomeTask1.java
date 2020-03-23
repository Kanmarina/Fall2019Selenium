package com.automation.tests.homeTask;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTask1 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();

        driver.get(" https://practice-cybertekschool.herokuapp.com ");
        driver.manage().window().maximize();
        BrowserUtils.wait(5);
        driver.findElement(By.linkText("Registration Form")).click();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    //  Test case #1 Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    //  Step 2. Click on “Registration Form”
    //  Step 3. Enter “wrong_dob” into date of birth input box.
    //  Step 4. Verify that warning message is displayed: “The date of birth is not valid”

    @Test
    public void wrongInput() {

        driver.findElement(By.name("birthday")).sendKeys("wrong_dob", Keys.ENTER);
        BrowserUtils.wait(5);
        String expected = "The date of birth is not valid";
        String actual = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/small[2]")).getText();

        Assert.assertEquals(actual, expected);
    }
//Test case #2 Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
// Step 2. Click on “Registration Form”
// Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript

    @Test
    public void displayedLanguages() {
        WebElement c = driver.findElement(By.xpath("//label[text()='C++']/preceding-sibling::input"));
        BrowserUtils.wait(5);
        Assert.assertTrue(c.isDisplayed());
        WebElement java = driver.findElement(By.xpath("//label[text()='Java']/preceding-sibling::input"));
        BrowserUtils.wait(5);
        Assert.assertTrue(java.isDisplayed());
        WebElement js = driver.findElement(By.xpath("//label[text()='JavaScript']/preceding-sibling::input"));
        BrowserUtils.wait(5);
        Assert.assertTrue(js.isDisplayed());
    }

    //Test case #3 Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
// Step 2. Click on “Registration Form”
// Step 3. Enter only one alphabetic character into first name input box.
// Step 4. Verify that warning message is displayed:
// “first name must be more than 2 and less than 64 characters long”
    @Test
    public void verifyFirstNameAlphabetic() {
        driver.findElement(By.name("firstname")).sendKeys("A", Keys.ENTER);
        BrowserUtils.wait(5);
        //Xpath=//td[text()='UserID']
        WebElement wrong = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        BrowserUtils.wait(5);
        Assert.assertTrue(wrong.isDisplayed());
    }

    //Test case #4 Step 1. Go to https://practice-cybertekschool.herokuapp.com
    // Step 2. Click on “Registration Form”
    // Step 3. Enter only one alphabetic character into last name input box.
    // Step 4. Verify that warning message is displayed:
    // “The last name must be more than 2 and less than 64 characters long”
    @Test
    public void verifyLastNameAlphabetic() {
        driver.findElement(By.name("lastname")).sendKeys("A", Keys.ENTER);
        BrowserUtils.wait(5);
        //Xpath=//td[text()='UserID']
        WebElement wrong = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));
        BrowserUtils.wait(5);
        Assert.assertTrue(wrong.isDisplayed());
    }


// Note: for using dropdown, please refer to the documentation:
// https://selenium.dev/selenium/docs/api/java/org/openqa/selenium/
// support/ui/Select.html or, please watch short video about
// drop-downs that is posted on canvas.

    @Test

    public void EnterSteps() {
        //Test case #5 Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
// Step 2. Click on “Registration Form”
// Step 3. Enter any valid first name.
// Step 4. Enter any valid last name.
// Step 5. Enter any valid user name.
// Step 6. Enter any valid password.
// Step 7. Enter any valid phone number.

        driver.findElement(By.name("firstname")).sendKeys("Marina", Keys.ENTER);
        driver.findElement(By.name("lastname")).sendKeys("Kan", Keys.ENTER);
        driver.findElement(By.name("username")).sendKeys("kanmarina", Keys.ENTER);
        driver.findElement(By.name("email")).sendKeys("kanmarina.coach@yahoo.com", Keys.ENTER);
        driver.findElement(By.name("password")).sendKeys("mypassword", Keys.ENTER);
        driver.findElement(By.name("phone")).sendKeys("832-661-2553", Keys.ENTER);
        BrowserUtils.wait(3);

        // Step 8. Select gender.
        List<WebElement> genders = driver.findElements(By.name("gender"));
        genders.get(1).click();
        BrowserUtils.wait(3);

        // Step 9. Enter any valid date of birth.
        driver.findElement(By.name("birthday")).sendKeys("10/05/1978");
        BrowserUtils.wait(5);

        // Step 10. Select any department.
        Select depSelect = new Select(driver.findElement(By.name("department")));
        depSelect.selectByVisibleText("Mayor's Office");
        BrowserUtils.wait(5);


        //step 11. Enter any job title.
        Select job = new Select(driver.findElement(By.name("job_title")));
        job.selectByVisibleText("SDET");
        BrowserUtils.wait(5);

        // Step 12. Select java as a programming language.
        driver.findElement(By.xpath("//label[text()='Java']/preceding-sibling::input")).click();


        // Step 13. Click Sign up.
        // Step 14. Verify that following success message is displayed:
// “You've successfully completed registration!”

        driver.findElement(By.id("wooden_spoon")).click();

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(actual, expected);

    }

}

