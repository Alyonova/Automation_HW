package Homework4.HW4.Priority;

import driverFactory.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ActionsClass;

public class Priority1 {
    static WebDriver driver;
    static ActionsClass actionsClass;

    @Test(priority = 6)
    public void a() {
        Assert.assertTrue(true);    }

    @Test(priority = 5)
    public void b() {
        Assert.assertTrue(true);    }

    @Test(priority = 4)
    public void c() {
        Assert.assertTrue(true);    }

    @Test(priority = 3)
    public void d() {
        Assert.assertTrue(true);    }

    @Test(priority = 2)
    public void e() {
        Assert.assertTrue(true);
    }
    @Test(priority = 1)
    public void f() {
        Assert.assertTrue(true);    }
    @Test(priority = 0)
    public void g() {
        Assert.assertTrue(true);    }

    @BeforeClass
    public void precondition() {
        driver = DriverSetUp.setUpDriver();
        actionsClass = new ActionsClass(driver);
    }

    @AfterClass
    public void postConditions() {
        driver.quit();
    }
}