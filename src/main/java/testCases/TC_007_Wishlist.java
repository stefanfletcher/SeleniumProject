package testCases;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DataProviders;


import java.util.logging.Logger;

public class TC_007_Wishlist extends BaseClass {

    Homepage home;
    LoginPage login;
    // Search for Items until we get success Page
    @Test(priority = 1)
    void SelectWishlistNotloggedIn() throws InterruptedException {
        try {
            home = new Homepage(driver);
            home.ClickLogo();
            logger.info("Clicked Logo");
            home.ClickMacWishlist();
            logger.info("Clicked MacWishlist");
            home.ClickWishlistnotloggedin();
            logger.info("Clicked MacWishlist Without being Logged in");
            login = new LoginPage(driver);
            if (login.LoginBoxAppeared()) {
                Assert.assertTrue(true);
                logger.info("Made it to Wishlist Page");
            }
            else {
                Assert.assertTrue(false);
            }

        } catch (Exception e) {
            // Use a logging framework to handle exceptions
            System.out.println("Unable to select" + e.getMessage());
            Assert.fail("Unable to add to Wishlist.");
        }
    }
}



