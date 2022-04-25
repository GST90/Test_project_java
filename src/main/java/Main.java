import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


// Build 3 tests for Java+WebDriver+TestNg
// Use page object model (as base) - https://www.toolsqa.com/selenium-webdriver/page-object-model/]
// Should contain 3 page object classes
// Chrome -Driver
//* try to configure Chrome Capabilities or Options
//* Test ng - Use @BeforeClass, @BeforeTest, After - //- || https://habr.com/ru/company/otus/blog/450872/
// Do not use static driver
// Till thursday 21 12.00





public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.findElement(By.xpath(""));

        System.out.println("Hello");
    }

    @Test
    public void TestMethod(){

    }

}