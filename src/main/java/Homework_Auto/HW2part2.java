package Homework_Auto;

import DefaultSetup.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HW2part2 {
    public static void dragNDrop (int x, int y, WebDriver driver){
        Actions action = new Actions(driver);
        WebElement circleElement = driver.findElement(By.cssSelector("[r='40']"));
        WebElement dropZoneElement = driver.findElement(By.cssSelector("[r='8']"));
        action.moveToElement(circleElement).clickAndHold()
                .moveToElement(dropZoneElement,x,y)
                .release().build().perform();
    }
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverSetup.setupDriver();
        driver.get("http://www.ashortjourney.com/");
        Thread.sleep(12000);
        dragNDrop(0,20, driver);
        Thread.sleep(7000);
        dragNDrop(0,-20, driver);
        Thread.sleep(7000);
        dragNDrop(0,-20, driver);
        Thread.sleep(7000);
        dragNDrop(0,-50, driver);
        Thread.sleep(7000);
        dragNDrop(10,80,driver);
        Thread.sleep(7000);
        dragNDrop(30,120,driver);
        Thread.sleep(7000);
        dragNDrop(0,-50, driver);
        Thread.sleep(7000);
        driver.findElement(By.cssSelector("textarea")).sendKeys("ЗАДАНИЕ ВЫПОЛНЕНО!");
        driver.quit();


    }
}
