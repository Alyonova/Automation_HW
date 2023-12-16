package Homework_Auto;

import DefaultSetup.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW1part4 {
    public class Info {
        public static void getInfo(WebElement element) {
            String idInfo = element.getAttribute("id");
            System.out.println(idInfo);
            String tagInfo = element.getTagName();
            System.out.println(tagInfo);
            String classInfo = element.getAttribute("class");
            System.out.println(classInfo);
            String nameInfo = element.getAttribute("name");
            System.out.println(nameInfo);
            String textInfo = element.getText();
            System.out.println(textInfo);
            int centreCoordinates = (element.getLocation().x + element.getSize().width / 2)
                    + (element.getLocation().y + element.getSize().height / 2);
            System.out.println(centreCoordinates);

        }
    }
    public static void main(String[] args) {
        WebDriver driver = DriverSetup.setupDriver();
        driver.get("https://ru.wikipedia.org/wiki/%D0%A1%D0%B0%D0%B9%D1%82");
        WebElement web = driver.findElement(By.xpath("//a[@class = 'mw-wiki-logo']"));
        Info.getInfo(web);
        driver.quit();

    }}
