package officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

public class  ExamplesHomeWorks {
    @Test (priority =100 , description = "Verify that the following message is displayed : 'This page returned a 500 status code'")
    public void testCase12() {
        //Test Case #12
     /*
     Step 1. Go to "https://practice-cybertekschool.herokuapp.com"
     Step 2. And click on "Status Codes".
     Step 3. Then click on "500".
     Step 4. Verify that following message is displayed: "This page returned a 500 status code"
      */
        //Step 1
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2
     /*
       xpath :
          //a[text()='Status Codes']
          //a[contains(text(),'Status Codes')]
          //ul/li[46]
          //a[@href="/status_codes"]
       linkText :
          lintText("Status Codes")
       partialLinkText:
          partialLintText("Status Codes")
          partiallinkText("Status")
          partiallinkText("Codes")
          CssSelector
          [href="/status_codes"]
      */
        WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
        statusCodeLink.click();
        //Step 3
        WebElement statusCode = driver.findElement(By.linkText("500"));
        statusCode.click();
        // Step 4
        String expectedMessage ="This page returned a 500 status code";
        WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
        String actualMessage = displayedMessageElement.getText();
        //System.out.println(actualMessage);
        if(actualMessage.contains(expectedMessage)){
            System.out.println("Passed");
        }else{
            System.out.println("FAILED");
        }
        driver.close();
    }
    /*
    Step 1. Go to "https://practice-cybertekschool.herokuapp.com"
    Step 2. And click on "Status Codes".
    Step 3. Then click on "404".
    Step 4. Verify that following message is displayed: "This page returned a 404 status code"
     */
    @Test(priority = 1, description = "Verify that the following message is displayed : 'This page returned a 404 status code'")
    public void testCase11() throws InterruptedException {
        //Step 1
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2
        WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
        statusCodeLink.click();
        //Step 3
        WebElement statusCode = driver.findElement(By.linkText("404"));
        statusCode.click();
        Thread.sleep(3000);
        //Step 4
        String expectedMessage ="This page returned a 404 status code";
        WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
        String actualMessage = displayedMessageElement.getText();
        if(actualMessage.contains(expectedMessage)){
            System.out.println("Passed");
        }else{
            System.out.println("FAILED");
        }
        driver.close();
    }}

//    public static void main(String[] args) {
//        private WebDriver driver;
//        @BeforeMethod
//        public void setUp(){
//            driver = BrowserFactory.getDriver("chrome");
//            driver.get("https://practice-cybertekschool.herokuapp.com");
//        }
////
//        @DataProvider(name ="testData")
//        public static Object [] testData(){
//            return new Object [] {"404","500","301","200"};
//        }
//   /*
//        DataProvider returns data in form of single dimensional Object array (Object [])or 2 dimensional object array (Object [] [])
//        Object [] --> When you have only 1 parameter
//        Object [] [] --> When you have 2+ parameters
//        cannot carry primitive data (int, byte) but it can carry
//        wrapper class objects(Integer, Byte)
//        statusCode("404") --> run,
//        statusCode("500")--> run,
//     */
//        @Test (dataProvider = "testData")
//        public void statusCodes(String code ){
//            //Step 2
//            WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
//            statusCodeLink.click();
//            //Step 3
//            WebElement statusCode = driver.findElement(By.linkText(code));
//            statusCode.click();
//            String expectedMessage ="This page returned a "+code+" status code";
//            WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
//            String actualMessage = displayedMessageElement.getText();
//       /*
//            The following is a HARD assertion and contains a message that is displayed only if the assertion fails.
//            When a HARD assertion fails the rest of the script is skipped
//        */
//            Assert.assertTrue(actualMessage.contains(expectedMessage),"The status code does not exist");
//        }
//        @AfterMethod
//        public void tearDown(){
//            driver.close();
//        }
//    }