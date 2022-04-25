package tests;

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