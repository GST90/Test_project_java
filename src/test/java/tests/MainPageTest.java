package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.BasePage;
import page.MainPage;

public class MainPageTest extends BasePage {

    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        BasePage bs = new BasePage();
        driver = bs.initialize_driver();
    }

    @Test
    public void checkDressCard() {
        MainPage main = new MainPage(driver);
        String dressTitle = "Printed Chiffon Dress";
        String dressCondition = "New";
        main.Search("Printed Dress");
        main.clickSearch();
        main.sortBy();
        main.clickMore();
        main.dressAssert(dressTitle, dressCondition);
    }

    @Test
    public void checkSearchInputNone() {
        MainPage main = new MainPage(driver);
        String result = "0 results have been found.";
        main.Search("random word");
        main.clickSearch();
        main.searchResultAssert(result);
    }

    @AfterClass
    public void closeUp() {
        driver.quit();
    }

}