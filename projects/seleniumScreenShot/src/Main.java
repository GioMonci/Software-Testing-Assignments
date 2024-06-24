
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver","[driverPath]");
        WebDriver driver=new ChromeDriver();
        driver.get("https://github.com/GioMonci");
        driver.manage().window().maximize();
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        File src=screenshot.getScreenshotAs(OutputType.FILE);
        File des=new File("[createA-FilePath]");
        FileHandler.copy(src,des);
    }
}
