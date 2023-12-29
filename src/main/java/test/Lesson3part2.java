package test;

import DefaultSetup.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Lesson3part2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetup.setupDriver();
        driver.get("http://www.automationpractice.pl");
        String lookFor = "Iphone 11";
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(lookFor);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String resultSearch = driver.findElement(By.xpath("//p[@class ='alert alert-warning']")).getText();
        Thread.sleep(3000);
        boolean contains = resultSearch.contains(lookFor);
        if (contains){
            System.out.println("Test works");
        }else {
            System.out.println("Test doesn't work");
        }
        driver.quit();
    }
}

