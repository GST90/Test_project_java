package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertTrue;

public class ContactPage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//a[@title=\"Contact Us\"]")
    WebElement contactUs;
    @FindBy(xpath = "//select[@id=\"id_contact\"]")
    WebElement Select;
    @FindBy(xpath = "//input[@id=\"email\"]")
    WebElement email;
    @FindBy(xpath = "//input[@id=\"id_order\"]")
    WebElement orderReference;
    @FindBy(xpath = "//textarea[@name=\"message\"]")
    WebElement text;
    @FindBy(xpath = "//button[@id=\"submitMessage\"]")
    WebElement submitButton;
    @FindBy(xpath = "//p[text()=\"Your message has been successfully sent to our team.\"]")
    WebElement successMessage;

    public ContactPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void clickContact() {
        contactUs.click();
    }

    public void selectSubject() {
        WebElement sort = Select;
        Select sel = new Select(sort);
        sel.selectByVisibleText("Customer service");
    }

    public void typeEmail(String value) {
        email.sendKeys(value);
    }

    public void typeOrder(String value) {
        orderReference.sendKeys(value);
    }

    public void typeMessage(String value) {
        text.sendKeys(value);
    }

    public void pressSubmit() {
        submitButton.click();
    }

    public void checkMessageSuccess(String result) {
        String actualString = successMessage.getText();
        assertTrue(actualString.contains(result));
    }

}
