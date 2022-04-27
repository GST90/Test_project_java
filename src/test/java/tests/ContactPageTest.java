package tests;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.BaseClass;
import page.ContactPage;
public class ContactPageTest{

    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        BaseClass bs = new BaseClass();
        driver = bs.initialize_driver();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("In this test we check the message sent to 'CUSTOMER SERVICE'")
    @Story(value = "Test to ensure message sent")
    @Test
    public void checkMessageSent() {
        ContactPage contact = new ContactPage(driver);
        String email = "test@test.com";
        String order = "66";
        String text = "Random TEXT";
        String message = "Your message has been successfully sent to our team.";
        contact.clickContact();
        contact.selectSubject();
        contact.typeEmail(email);
        contact.typeOrder(order);
        contact.typeMessage(text);
        contact.pressSubmit();
        contact.checkMessageSuccess(message);
    }

    @AfterClass
    public void closeUp() {
        driver.quit();
    }

}