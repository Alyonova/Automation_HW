package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://google.com/");
        try {
            chromeDriver.findElement(By.xpath("//div[text()='Accept all']")).click();
        } catch (Exception e){
            e.printStackTrace();
        }
        Thread.sleep(3000);
//        chromeDriver.quit();
    }
}
