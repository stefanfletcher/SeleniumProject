package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SearchPage;
import pageObjects.ShopifyPaginationPage;
import testBase.BaseClass;
import testBase.BaseClass_Test;
import utilities.DataProviders;

public class TC_006_Shopify_Pagination extends BaseClass_Test {

    ShopifyPaginationPage shop;


    // Search for Items until we get success Page
    @Test(priority = 1)
    void ClickthroughPages() throws InterruptedException {
        try {
            shop = new ShopifyPaginationPage(driver);
            shop.NumberofResults();
            shop.LoopthroughPages();
            Assert.assertTrue(true);
        } catch (Exception e) {
            // Use a logging framework to handle exceptions
            System.out.println("No Pages Found " + e.getMessage());
            Assert.fail("Unable to click pages' failed");
        }
    }
}



