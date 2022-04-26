package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.BasePage;
import page.EmptyCartPage;

public class EmptyCartPageTest extends BasePage {

    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        BasePage bs = new BasePage();
        driver = bs.initialize_driver();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("In this test we check the card is empty until something added")
    @Story(value = "Test to ensure card is empty until something added")
    @Test
    public void checkCardEmpty() {
        EmptyCartPage Cart = new EmptyCartPage(driver);
        String message = "Your shopping cart is empty.";
        Cart.clickCard();
        Cart.checkEmptyMessage(message);
    }

    @AfterClass
    public void closeUp() {
        driver.quit();
    }

}