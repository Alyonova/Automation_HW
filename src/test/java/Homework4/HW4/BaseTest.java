package Homework4.HW4;

import driverFactory.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.WaiterClass;

public class BaseTest {
    static WebDriver driver;
    static utils.ActionsClass actionsClass;

    @BeforeClass
    public void precondition(){
        driver = DriverSetUp.setUpDriver();
        actionsClass = new utils.ActionsClass(driver);
    }

    @AfterClass
    public void postConditions(){
        driver.quit();
    }

}