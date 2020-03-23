package com.automation.tests.day8;


import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {

    @Test
    public  void  test1(){
        System.out.println("TEST 1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual,expected);
    }

    @BeforeMethod
    public void setup(){
        System.out.println("Before method");

    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
        int num1 =5;
        int num2= 10;
         Assert.assertTrue(num1< num2);
    }
}
