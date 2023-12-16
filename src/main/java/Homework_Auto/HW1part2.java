package Homework_Auto;

import DefaultSetup.DriverSetup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.Set;

public class HW1part2 {
    public static void openNewTab(WebDriver driver, String url){
        driver.get(url);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Set<String> set1 = driver.getWindowHandles();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> set2 = driver.getWindowHandles();
        set2.removeAll(set1);
        String newDescr = set2.iterator().next();
        driver.switchTo().window(newDescr);

    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetup.setupDriver();
        openNewTab(driver,"https://zoo.kiev.ua/" );
        openNewTab(driver,"https://www.w3schools.com/");
        openNewTab(driver, "https://taxi838.ua/ru/dnepr/");
        openNewTab(driver, "https://klopotenko.com/");
        Set<String> tabs = driver.getWindowHandles();
        for (String handlers: tabs) {
            driver.switchTo().window(handlers);
            if (driver.getTitle().contains("зоопарк")){
                driver.close();
            }
        }
        Thread.sleep(2000);
        driver.quit();

    }
}
