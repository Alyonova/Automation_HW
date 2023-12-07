package Homework_Auto;

import DefaultSetup.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HW1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetup.setupDriver();
        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.id("search_query_top")).sendKeys("printed chiffon dress");
        driver.findElement(By.cssSelector("#searchbox > button")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")).click();
        driver.findElement(By.xpath("//button[@class ='exclusive']")).click();
        Thread.sleep(1500);
        driver.findElement(By.cssSelector("[title='Continue shopping']")).click();
        driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.id("search_query_top")).sendKeys("Faded short sleeve t-shirts");
        driver.findElement(By.cssSelector("div.right-block > h5 >a")).click();
        driver.findElement(By.xpath("//button[@class='exclusive']")).click();
        Thread.sleep(1500);
        driver.findElement(By.cssSelector("[title='Continue shopping']")).click();
        driver.findElement(By.cssSelector("div > a > b")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(1500);
        driver.quit();


    }
}
