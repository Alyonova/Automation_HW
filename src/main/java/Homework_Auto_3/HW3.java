package Homework_Auto_3;

import DefaultSetup.DriverSetup;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class HW3 {

    public static void sendKeys(WebDriver driver, String url) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("APjFqb"));
        element.sendKeys(url);
        actions.keyDown(Keys.ENTER).release().build().perform();
    }

    public static void openNewTab(WebDriver driver, By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).keyDown(Keys.CONTROL)
                .click().keyUp(Keys.CONTROL).build().perform();
    }
    public static void workInNewTab(WebDriver driver, String url){
        Set<String> set = driver.getWindowHandles();
        for (String handle : set) {
            driver.switchTo().window(handle);
            String link = driver.getCurrentUrl();
            if (link.equals(url)) {
                break;
            }
        }
    }
    public static void fillOutForm(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
        WebElement firstName =  driver.findElement(By.id("fname"));
        firstName.clear();
        firstName.sendKeys("Alona");
        WebElement lastName =  driver.findElement(By.id("lname"));
        lastName.clear();
        lastName.sendKeys("Kuziukova");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println(driver.findElement(By.xpath("/html/body/div[2]/p")).getText());
    }
    public static void GuinessForm(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("LastName"))).click()
                .sendKeys("Kuziukova").moveToElement(driver.findElement(By.id("FirstName"))).click().sendKeys("Alona")
                .moveToElement(driver.findElement(By.id("DateOfBirthDay"))).click().sendKeys("30").moveByOffset(30, 0).click()
                .sendKeys("01").moveByOffset(50, 0).click().sendKeys("1990").build().perform();

        Select countriesList = new Select(driver.findElement(By.id("Country")));
        countriesList.selectByVisibleText("United States");
        Thread.sleep(1500);
        Select region = new Select(driver.findElement(By.id("State")));
        region.selectByVisibleText("California");
        actions.moveToElement(driver.findElement(By.id("EmailAddress"))).click()
                .sendKeys("qwoeuryr@dkh.com").moveToElement(driver.findElement(By.id("ConfirmEmailAddress")))
                .click().sendKeys("qwoeuryr@dkh.com").moveToElement(driver.findElement(By.id("Password")))
                .click().sendKeys("12345678").moveToElement(driver.findElement(By.id("ConfirmPassword")))
                .click().sendKeys("98873980").keyDown(Keys.ENTER).release().build().perform();
        System.out.println(driver.findElement(By.xpath("//span[@class='field-validation-error']")).getText());

    }
    public static void Alerts(WebDriver driver){
        driver.findElement(By.id("alertBox")).click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        System.out.println(driver.findElement(By.id("output")).getText());
        driver.findElement(By.id("confirmBox")).click();
        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();
        System.out.println(driver.findElement(By.id("output")).getText());
        driver.findElement(By.id("promptBox")).click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Final step of this task");
        alert3.accept();
        System.out.println(driver.findElement(By.id("output")).getText());
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetup.setupDriver();
        driver.get("https://www.google.com/search");
        sendKeys(driver, "https://www.guinnessworldrecords.com/account/register?");
        openNewTab(driver, By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]"));
        sendKeys(driver, "https://www.hyrtutorials.com/p/alertsdemo.html");
        openNewTab(driver, By.xpath("//h3[text()='AlertsDemo']"));
        driver.findElement(By.id("APjFqb")).clear();
        sendKeys(driver, "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
        openNewTab(driver, By.xpath("//h3[text()='W3Schools Tryit Editor - HTML Forms']"));
        workInNewTab(driver, "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
        fillOutForm(driver);
        workInNewTab(driver, "https://www.guinnessworldrecords.com/account/register");
        // объясните, пожалуйста, почему этот код с ожиданием не работает

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='input-large create-application-name']")));

        GuinessForm(driver);
        workInNewTab(driver, "https://www.hyrtutorials.com/p/alertsdemo.html");
        Alerts(driver);
        driver.quit();

        }
    }


