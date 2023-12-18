package Homework_Auto;

import DefaultSetup.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;

public class HW2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetup.setupDriver();
        driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");
        WebElement vehicles = driver.findElement(By.id("Carlist"));
        Select cars = new Select(vehicles);
        cars.selectByValue("Renault Car");
        Thread.sleep(2000);
        List<WebElement> carsOptions = cars.getOptions();
        System.out.println("Автомобили доступные для выбора: ");
        for (WebElement carList : carsOptions) {
            System.out.print(carList.getText() + " ");
        }
        System.out.println();

        WebElement countries = driver.findElement(By.xpath("//select[@name='FromLB']"));
        Select chooseCountries = new Select(countries);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).perform();
        chooseCountries.selectByVisibleText("France");
        chooseCountries.selectByValue("Germany");
        chooseCountries.selectByValue("Italy");
        chooseCountries.selectByValue("Spain");
        driver.findElement(By.xpath("//input[@type='button'][1]")).click();
        List<WebElement> countriesOptions1 = chooseCountries.getOptions();
        System.out.println("первая колонка");
        for (WebElement countriesList : countriesOptions1) {
            System.out.print(countriesList.getText() + " ");
        }
        WebElement column2 = driver.findElement(By.xpath("//select[@name='ToLB']"));
        Select countries2 = new Select(column2);
        List <WebElement>countriesOptions2 = countries2.getOptions();
        System.out.println();
        System.out.println("вторая колонка");
        for (WebElement countriesList2 : countriesOptions2){
            System.out.print(countriesList2.getText() + " ");
        }
        driver.quit();

}}
