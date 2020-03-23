package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {
    public static void main(String[] args) {
        String expected = "cba";
        String toRevers = "abc";
        String actual = reverseString(toRevers);
        verifyEquals(expected, actual);
    }
    //annotation
    //description - is not working for JUNIT
    @Test (description = "Verify if method can reverse a string")
    public void test(){
        String expected ="elppa";
        String actual = reverseString("apple");

    //to verify if expected result is equals to actual
        Assert.assertEquals(actual,expected);


    }
    @Test (description = "Verify if method can reverse a string")
    public void test2(){
        String expected ="rac";
        String actual = reverseString("cat");
        Assert.assertEquals(actual,expected);
    }



    public static boolean verifyEquals(String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("TEST PASSED");
            return true;
        } else {
            System.out.println("Test failed!!!");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            return false;
        }
        }
    /**
     * This method stands for reversing strings.
     *
     * @param str to reverse
     * @return reversed string
     */
        public static String reverseString(String str){
            String reverse = "";
            for (int i = str.length()-1; i >=0; i--) {
                reverse+= str.charAt(i);
            }
            return reverse;
}}