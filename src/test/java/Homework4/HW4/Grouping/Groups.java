package Homework4.HW4.Grouping;

import driverFactory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ActionsClass;

public class Groups {

        static WebDriver driver;
        static ActionsClass actionsClass;

        @Test(priority = 1, groups = {"first"})

        public void one() {
            Assert.assertTrue(true);        }

        @Test(priority = 2, groups = {"second"})
        public void two() {
            Assert.assertTrue(true);        }

        @Test(priority = 3, groups = {"first"})
        public void three() {
            Assert.assertTrue(true);        }

        @Test(priority = 4, groups = {"second"})
        public void four() {
            Assert.assertTrue(true);        }

        @Test(priority = 5, groups = {"first"})
        public void five() {
            Assert.assertTrue(true);        }
        @Test(priority = 6, groups = {"second"})
        public void six() {
            Assert.assertTrue(true);
        }

        @Test(priority = 7, groups = {"first"})
        public void seven() {
            Assert.assertTrue(true);
        }
        @Test(priority = 8, groups = {"second"})
        public void eight() {
            Assert.assertTrue(true);    }

        @BeforeClass(groups = {"first","second"})
        public void precondition() {
            driver = DriverSetUp.setUpDriver();
            actionsClass = new ActionsClass(driver);
        }

        @AfterClass(groups = {"first","second"})
        public void postConditions() {
            driver.quit();
        }
    }
