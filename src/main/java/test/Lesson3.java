package test;

import DefaultSetup.DriverSetup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Lesson3 {
    public static void main(String[] args) throws InterruptedException {
      WebDriver chromeDriver = DriverSetup.setupDriver();
        chromeDriver.get("https://rozetka.com.ua/");
        try {
            chromeDriver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[3]/rz-user/button")).click();
            chromeDriver.findElement(By.xpath("//*[@id=\"auth_email\"]")).sendKeys("gfjdgjggrgad");
            chromeDriver.findElement(By.id("auth_pass")).sendKeys("dhdrkghkd");
            Thread.sleep(3000);
            chromeDriver.findElement(By.xpath("//label[@class ='auth-modal__remember-checkbox']")).click();
            System.out.println(chromeDriver.findElement(By.xpath("//button[@class = 'auth-modal__register-link button button--link ng-star-inserted']")).getText());
           chromeDriver.findElement(By.xpath("//button[@class = 'modal__close']")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        chromeDriver.quit();
    }
}