package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Checkout;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_008_Attempt_To_Buy_Featured_Product extends BaseClass {

    Homepage home;
    Checkout checkout;

    // Search for Items until we get success Page
    @Test(priority = 1)
    public void BuyFeaturedProduct() throws InterruptedException {
        try {
            home = new Homepage(driver);
            home.AddMactoCart();
            Thread.sleep(5000);
            if (home.MacFeaturedProductPrice().equals(home.MacinBasketPrice())) {
                logger.info("Basket Price and Featured Price Match");
            } else {
                logger.info("No match, test ending");
                Assert.assertTrue(false);
            }
            home.SelectCart();
            home.ClickBasketCheckout();
            checkout = new Checkout(driver);
            if (checkout.PageisDisplayed()) {
                // Click the disabled button and check it doesn't proceed
                checkout.Clickdisabledcheckout();
                logger.info("Clicked a disabled Checkout button");
                if (driver.getTitle().equals("Checkout")) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
        } catch (Exception e) {
            // Use a logging framework to handle exceptions
            System.out.println("Unable to Match: " + e.getMessage());
            Assert.fail("Unable to add to Wishlist.");
        }
    }
}