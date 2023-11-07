package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DataProviders;

import java.util.ArrayList;
import java.util.List;

public class TC_005_Search_Item extends BaseClass {

    SearchPage search;


    // Search for Items until we get success Page
    @Test(dataProvider = "searchItem", dataProviderClass = DataProviders.class, groups = {"Main"})
    void SearchUntilResultIsFound(String itemName, String detailedDescription, String price) throws InterruptedException {
        try {
            search = new SearchPage(driver);

            do {
                search.Entersearch(itemName);
                search.ClickSearch();

                if (search.FailedSearchScreen()) {
                    System.out.println("No results found for: " + itemName);
                    System.out.println(driver.getTitle());
                    driver.navigate().back();
                    Thread.sleep(1000);
                    search.ClearSearch();
                    Assert.assertTrue(false);
                } else if (search.SearchResults()) {
                    System.out.println("Results found for: " + itemName);
                    System.out.println(driver.getTitle());
                }
            } while (!search.SearchResults());

        } catch (Exception e) {
            // Use a logging framework to handle exceptions
            System.out.println("Test 'SearchUntilResultIsFound' failed due to " + e.getMessage());
            Assert.fail("Test 'SearchUntilResultIsFound' failed");
        }
    }
}



