package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    WebDriver driver;
    Scanner scanner = new Scanner(System.in);


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
        System.out.println("Beginning of Test Suite");
        System.out.println("This Test Suite will go through 6 tests.\n");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
        System.out.println("Test 1: Reverse Number Check");
        System.out.println("Test 2: Factorial Check");
        System.out.println("Test 3: Prime Number Check");
        System.out.println("Test 4: Webpage Title Check");
        System.out.println("Test 5: URL Check");
        System.out.println("Test 6: Web Elements Check \n");
    }

    @BeforeClass
    public void setUp(){

        System.out.println("Before Class");
        System.out.println("Now Testing Main Class \n");
        driver = new ChromeDriver();
        driver.manage().window().minimize();
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
        System.out.println("Method is now starting \n");
    }

    @Test(priority = 1, description = "Test if the given number and its reversed are equal")
    public void reversedNumber(){
        System.out.println("Test 1 - Reverse Number Check");
        System.out.println("Enter a number: ");
        // get number input
        int number = scanner.nextInt();
        // sends number to reverse function to get its reversed
        int reversed = reverseTheNumber(number);
        // Assert Equals
        Assert.assertEquals(number, reversed, "Inputted Number and its reverse are not equal \n" );
    }

    private int reverseTheNumber(int number){
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }

    @Test(priority = 2, description = "Test to see if the factorial of the number given is correct")
    public void isFactorial(){
        System.out.println("Test 2 - Factorial Check");
        // get number from user
        System.out.print("Enter a number to find its factorial: ");
        int number = scanner.nextInt();
        // get what that factorial of the number they inputted  is
        long expectedFactorial = getFactorial(number);
        // ask the user what they find the factorial of the number is
        System.out.print("Guess the factorial of " + number + ": ");
        long guessedFactorial = scanner.nextLong();
        // Assert Equals
        Assert.assertEquals(guessedFactorial, expectedFactorial, "Factorial calculation is incorrect \n");
    }

    private long getFactorial(int number){

        // simple get factorial function
        if (number == 0)
            return 1;
        long factorial = 1;
        for (int i = 1; i <= number; ++i) {
            factorial *= i;
        }
        return factorial;
    }

    @Test(priority = 3, description = "Tests if the given number is a prime number or not")
    public void primeNumberCheck(){

        System.out.println("Test 3 - Prime Number Check");
        System.out.print("Enter a number to check if it's prime: ");

        // Get input number
        int number = scanner.nextInt();

        // Check if the number is prime
        boolean isPrime = checkIfPrime(number);

        // Assert True
        Assert.assertTrue(isPrime, number + " is not a prime number \n"); // Assert prime
    }

    private boolean checkIfPrime(int number) {
        if (number <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    @Test(priority = 4, description = "Test if the title of a webpage is not equal to the expected title page of a web page")
    public void webpageTitle(){
        System.out.println("Test 4 - Webpage Title Check");

        // get the actual title of website
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        System.out.println("The actual title of the webpage " + actualTitle);

        // Expected Title
        String expectedTitle = "Amazon";
        System.out.println("The expected title of the webpage " + expectedTitle);

        //Assert Not Equal
        Assert.assertNotEquals(actualTitle, expectedTitle, "Page title matches the expected title\n");

    }
    @Test(priority = 5, description = "Tests to see if the actual url is the same as the expected url")
    public void urlMatch(){

        System.out.println("Test 5 - Page URL");

        // get website url
        driver.get("https://www.selenium.dev/");
        String actualURL = driver.getCurrentUrl();
        System.out.println("The actual url of the page " + actualURL);

        // expected url
        String expectedURL = "https://www.selenium.dev/";
        System.out.println("The expected url of the page " + expectedURL);

        //Assert Equals
        Assert.assertEquals(actualURL, expectedURL, "Page URL does not match the expected URL\n");
    }

    @Test(priority = 6, description = "Tests to see if size of elements on webpage is not equal to size we expect")
    public void sizeOfElements(){

        System.out.println("Test 6 - Element Size");
        // got to website
        driver.get("https://www.oracle.com/java/");

        // get size of Web Elements
        List<WebElement> elementSize = driver.findElements(By.tagName("a"));
        //gets the size of links
        System.out.println("Element size: " + elementSize.size());

        // expected Web Element size
        int expectedSize = 50;

        System.out.println("The expected size of the webpage " + expectedSize);

        // Assert False
        Assert.assertFalse(elementSize.size() == expectedSize, "Element size is equal to the expected size\n");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("After Method");
        System.out.println("Method is now ending \n");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class \n");
        driver.quit();
    }
    @AfterTest
    public void afterTest(){

        System.out.println("After Test");
        System.out.println("Test 1: Done");
        System.out.println("Test 2: Done");
        System.out.println("Test 3: Done");
        System.out.println("Test 4: Done");
        System.out.println("Test 5: Done");
        System.out.println("Test 6: Done \n");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
        System.out.println("End of Test Suite");
        System.out.println("All test complete, check for passes or fails \n");
    }

}