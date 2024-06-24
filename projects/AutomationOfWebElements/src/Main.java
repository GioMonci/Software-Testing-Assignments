import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // setting up chrome driver
        System.setProperty("webdriver.chrome.driver", "[driverPath]");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        // open browser and go to webpage
        driver.manage().window().maximize();
        driver.get("https://artoftesting.com/samplesiteforselenium");
        Thread.sleep(4000);
        //scroll down
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(3000);

        //Enter text in text and search Button
            //Finds the text box and put my name in it
        driver.findElement(By.id("fname")).sendKeys("Hello World!");
        Thread.sleep(2000);
        //Finds the button under the text box and clicks it
            //The button changes color when clicked
        WebElement button1 = driver.findElement(By.id("idOfButton"));
        button1.click();

        Thread.sleep(4000);

        //HyperLinks
        //Finds the hyperLink and clicks on it
        WebElement hyperLink = driver.findElement(By.linkText("This is a link"));
        hyperLink.click();
        Thread.sleep(4000);

        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(1000);

        //Checkboxes and Radio Buttons
            //Radio Button
                //Clicks the Male Option for radio button
        WebElement radioButton = driver.findElement(By.id("male"));
        radioButton.click();
                //Clicks the Female Option for radio button
        WebElement radioButton1 = driver.findElement(By.id("female"));
        radioButton1.click();
        Thread.sleep(4000);
            //Checkboxes
                //Clicks the Automation Option for the checkbox
        WebElement checkBoxes = driver.findElement(By.className("Automation"));
        checkBoxes.click();
                //Clicks the Performance Option for the checkbox
        WebElement checkBoxes1 = driver.findElement(By.className("Performance"));
        checkBoxes1.click();
        Thread.sleep(4000);

        //Drop Down Menus
            //Finds the dropdown and selects the 3rd option in dropdown
        WebElement dropDownElement = driver.findElement(By.id("testingDropdown"));
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByIndex(3);
        Thread.sleep(4000);

        js.executeScript("window.scrollBy(0,750)");
        Thread.sleep(5000);

        //Drag and Drop
            // Locate the source element to be dragged
        WebElement sourceElement = driver.findElement(By.id("myImage"));
            // Locate the target element to drop onto
        WebElement targetElement = driver.findElement(By.id("targetDiv"));
            // Create an Actions object
        Actions dragActions = new Actions(driver);
            // Perform drag and drop
        dragActions.dragAndDrop(sourceElement, targetElement).build().perform();
        Thread.sleep(4000);

        //Get the title
        String pageTitle = driver.getTitle();
        System.out.println("Title: " + pageTitle);
        Thread.sleep(4000);

        //Get the current url of selected Webpage
        String getUrl = driver.getCurrentUrl();
        System.out.println("URL: " + getUrl);
        Thread.sleep(4000);

        System.out.println("------------------------------------------");
        System.out.println("Getting size of Web Elements");
        System.out.println("******************************************");

        //List the size of web elements
        List<WebElement> link = driver.findElements(By.tagName("a"));
            //gets the size of links
        System.out.println("Element size: " + link.size());
            //gets the name of links
        for(WebElement l:link){
            System.out.println(l.getText());
        }
        Thread.sleep(4000);

        System.out.println("------------------------------------------");
        System.out.println("Displaying all Web Elements");
        System.out.println("******************************************");

        //Display all the web Elements present in the current webpage
        List<WebElement> allElements = driver.findElements(By.xpath("//*"));
        for(WebElement element: allElements){
            System.out.println("TagName: " + element.getTagName());
            System.out.println("Text: " + element.getText());
            System.out.println("----------------------------------");

        }
        Thread.sleep(4000);

        // closing webpage
        driver.close();

    }
}
