package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainPage extends BasePage {

    By InputSearch = By.xpath("//input[@name=\"search_query\"]");
    By SortBy = By.xpath("//select[@id=\"selectProductSort\"]");
    By moreButton = By.xpath("//img[@itemprop=\"image\"]");
    By dressTitle = By.xpath("//h1[text()=\"Printed Chiffon Dress\"]");
    By dressCondition = By.xpath("//span[text()=\"New\"]");
    By nothingFound = By.xpath("//span[@class=\"heading-counter\"]");
    By wishList = By.linkText("Add to Wishlist");

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver=driver;
    }

    public void Search(String value) {
        driver.findElement(InputSearch).sendKeys(value);
    }

    public void clickSearch() {
        driver.findElement(InputSearch).sendKeys(Keys.ENTER);
    }

//    public void checkWishList(String title) {
//        String actualTitles = driver.findElements(wishList).getText();
//        assertTrue(actualTitles.contains(title));
//    }

    public void sortBy() {
        WebElement sort = driver.findElement(SortBy);
        Select sel = new Select(sort);
        sel.selectByVisibleText("Price: Lowest first");
    }

    public void clickMore() {
        driver.findElement(moreButton).click();
    }

    public void dressAssert(String text, String text2) {
        String actualDress = driver.findElement(dressTitle).getText();
        String actualCondition = driver.findElement(dressCondition).getText();
        assertEquals(text, actualDress);
        assertEquals(text2, actualCondition);
    }

    public void searchResultAssert(String result) {
        String actualString = driver.findElement(nothingFound).getText();
        assertTrue(actualString.contains(result));
    }
}
