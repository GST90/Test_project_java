package tests;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.BasePage;
import page.MainPage;

public class MainPageTest {

    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        BasePage bs = new BasePage();
        driver = bs.initialize_driver();
    }


    @Severity(SeverityLevel.NORMAL)
    @Description("In this test we will select the cheapest dress from catalog. When the dress will selected there" +
            " will be assertions of dress we need and its condition.")
    @Story(value = "Test for selection the cheapest dress from catalog and to ensure we select we need")
    @Test
    public void checkDressCard() {
        MainPage main = new MainPage(driver);
        String dressTitle = "Printed Chiffon Dress";
        String dressCondition = "New";
        main.checkSearch(dressTitle);
        main.checkSortBy();
        main.clickMore();
        main.dressAssert(dressCondition);
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("In this test we check the message after typing nonexistent dress in the search input.")
    @Story(value = "Test to ensure we have the message we need")
    @Test
    public void checkSearchInputNone() {
        MainPage main = new MainPage(driver);
        String result = "0 results have been found.";
        main.checkSearch("random word");
        main.searchResultAssert(result);
    }

    @AfterClass
    public void closeUp() {
        driver.quit();
    }

}