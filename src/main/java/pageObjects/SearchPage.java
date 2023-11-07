package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends Base_Class {

    // Instantiate
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    //Elements

    private final By Search = By.xpath("//input[@name='search']");
    private final By ClickSearch = By.xpath("//button[@class='btn btn-light btn-lg']");
    private final By FailedSearch = By.xpath("//h5[normalize-space()='Internal Server Error!']");
    private final By SearchResults = By.xpath("//a[normalize-space()='Apple Cinema 30\"']");


    public void Entersearch(String itemName) {
        driver.findElement(Search).sendKeys(itemName);
    }

    public void ClickSearch() {
        driver.findElement(ClickSearch).click();
    }

    public void ClearSearch() {
        driver.findElement(Search).clear();
    }


    public Boolean SearchResults() {
        try {
            return (driver.findElement(SearchResults).isDisplayed());
        } catch (Exception e) {
            return (false);
        }
    }

        public Boolean FailedSearchScreen () {
            try {
                return (driver.findElement(FailedSearch).isDisplayed());
            } catch (Exception e) {
                return (false);
            }

        }
    }




