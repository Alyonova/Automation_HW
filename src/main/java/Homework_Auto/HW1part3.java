package Homework_Auto;

import DefaultSetup.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW1part3 {
    public class CompareElements {

        public static void getSize(WebElement element1, WebElement element2) {
            int x1 = element1.getLocation().getX();
            int y1 = element1.getLocation().getY();
            int width1 = element1.getSize().getWidth();
            int height1 = element1.getSize().getHeight();

            int x2 = element2.getLocation().getX();
            int y2 = element2.getLocation().getY();
            int width2 = element2.getSize().getWidth();
            int height2 = element2.getSize().getHeight();
            System.out.println(x1);
            System.out.println(x2);
            System.out.println(y1);
            System.out.println(y2);
            System.out.println(width1);
            System.out.println(width2);
            System.out.println(height1);
            System.out.println(height2);

            if (y1 < y2) {
                System.out.println(element1 + " располагается выше, чем" + element2);
            } else if (y1 > y2) {
                System.out.println(element2 + " располагается выше, чем " + element1);
            } else {
                System.out.println("Элементы находятся на одном уровне по вертикали");
            }

            if (x1 < x2) {
                System.out.println(element1 + " располагается левее " + element2);
            } else if (x1 > x2) {
                System.out.println(element2 + " располагается левее " + element1);
            }

            int area1 = width1 * height1;
            int area2 = width2 * height2;
            if (area1 > area2) {
                System.out.println(element1 + " занимает большую площадь");
            } else if (area1 < area2) {
                System.out.println(element2 + " занимает большую площадь");
            } else {
                System.out.println("Элементы занимают одинаковую площадь");
            }
        }
    }
    public static void main(String[] args) {
        WebDriver driver = DriverSetup.setupDriver();
        driver.get("http://www.automationpractice.pl/index.php");
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"header_logo\"]/a/img"));
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]//div[3]/div/a"));
        CompareElements.getSize(element1,element2);
        driver.quit();

    }
}
