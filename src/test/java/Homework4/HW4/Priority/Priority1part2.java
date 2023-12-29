package Homework4.HW4.Priority;

import driverFactory.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ActionsClass;


    public class Priority1part2 {
        static WebDriver driver;
        static ActionsClass actionsClass;

        @Test(dependsOnMethods = {"b"})
        public void a() {
            Assert.assertTrue(true);        }

        @Test(dependsOnMethods = {"c"})
        public void b() {
            Assert.assertTrue(true);        }

        @Test(dependsOnMethods = {"d"})
        public void c() {
            Assert.assertTrue(true);        }

        @Test(dependsOnMethods = {"e"})
        public void d() {
            Assert.assertTrue(true);        }

        @Test(dependsOnMethods = {"f"})
        public void e() {
            Assert.assertTrue(true);        }
        @Test(dependsOnMethods ={"g"} )
        public void f() {
            Assert.assertTrue(true);        }
        @Test
        public void g() {
            Assert.assertTrue(true);        }

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
