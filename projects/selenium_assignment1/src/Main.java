import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Main {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "[driverPath]");
        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.get("https://www.fgcu.edu/canvas/");
        Thread.sleep(5000);
        driver1.close();


        System.setProperty("webdriver.edge.driver", "[driverPath]");
        WebDriver driver2 = new EdgeDriver();
        driver2.manage().window().maximize();
        driver2.get("https://www.youtube.com/");
        Thread.sleep(5000);
        driver2.close();

        System.setProperty("webdriver.gecko.driver", "[driverPath]");
        WebDriver drive3 = new FirefoxDriver();
        drive3.manage().window().maximize();
        drive3.get("https://www.amazon.com/");
        Thread.sleep(5000);
        drive3.close();

        }
}
