package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;


public class EmptyCartPage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//a[@title=\"View my shopping cart\"]")
    WebElement Cart;
    @FindBy(xpath = "//p[text()=\"Your shopping cart is empty.\"]")
    WebElement Empty;

    public EmptyCartPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCard(){
        Cart.click();
    }

    public void checkEmptyMessage(String message) {
        String actualString = Empty.getText();
        assertTrue(actualString.contains(message));
    }

}
