package DefaultSetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetup {
     public static WebDriver setupDriver(){
         WebDriverManager.chromedriver().setup();
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--disable notifications");
         WebDriver chromeDriver = new ChromeDriver(options);
         chromeDriver.manage().window().maximize();
         return chromeDriver;
     }
}
