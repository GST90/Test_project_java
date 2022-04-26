package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainPage extends BasePage {

    By InputSearch = By.xpath("//input[@name=\"search_query\"]");
    By SortBy = By.xpath("//select[@id=\"selectProductSort\"]");
    By moreButton = By.xpath("//img[@itemprop=\"image\"]");
    By dressTitle = By.xpath("//h1[text()=\"Printed Chiffon Dress\"]");
    By dressCondition = By.xpath("//span[text()=\"New\"]");
    By nothingFound = By.xpath("//span[@class=\"heading-counter\"]");

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver=driver;
    }

    public void checkSearch(String value) {
        driver.findElement(InputSearch).sendKeys(value);
        driver.findElement(InputSearch).sendKeys(Keys.ENTER);
    }

    public void checkSortBy() {
        WebElement sort = driver.findElement(SortBy);
        Select sel = new Select(sort);
        sel.selectByVisibleText("Price: Lowest first");
    }

    public void clickMore() {
        driver.findElement(moreButton).click();
    }

    public void dressAssert(String condition) {
        String actualDress = driver.findElement(dressTitle).getText();
        String actualCondition = driver.findElement(dressCondition).getText();
        assertThat(actualDress).contains("Printed", "Chiffon", "Dress");
//        assertEquals(title, actualDress);
        assertEquals(condition, actualCondition);
    }

    public void searchResultAssert(String result) {
        String actualString = driver.findElement(nothingFound).getText();
        assertTrue(actualString.contains(result));
    }
}
