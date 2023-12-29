package Homework4.HW4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class DataProvider extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(DataProvider.class);


    @Test(dataProvider = "searchWords")
    public void CheckSearchField(String search) {
        logger.info("Открываю сайт");
        driver.get("https://www.foxtrot.com.ua/");
        logger.info("ввожу слово " + search);
        actionsClass.sendKeys(By.xpath("//input[@type='search']"), search);
        actionsClass.click(By.xpath("//input[@type='button']"));
        WebElement option = driver.findElement(By.xpath("//div[@class ='page__title']/h1"));
        logger.info("нашел текст " + option.getText());
        if (option.getText().contains("Найдено по запросу")) {

            Assert.assertTrue(option.getText().contains(search), "Expected text not found on the page");
            logger.info("Слово " + search + " есть в строке " + option.getText());

        } else {
            WebElement option2 = driver.findElement(By.xpath("//div[@class = 'search-page__box-title']"));
            assertTrue(option2.getText().toLowerCase().contains(search));
           logger.info("слово " + search + " есть в строке " + option2.getText());
        }
    }
    @org.testng.annotations.DataProvider(name = "searchWords")
    public Object[][] dataEntry() {
        return new Object[][]{
                {"машина" },
                {"input" },
                {"смысл" },
        };
    }
}