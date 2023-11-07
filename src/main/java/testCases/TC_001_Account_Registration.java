package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_Account_Registration extends BaseClass {

    Homepage home;
    RegistrationPage register;

    @Test(groups = {"Main"})
    void Register() throws InterruptedException {
        try {
            home = new Homepage(driver);
            home.ClickMyAccount();
            home.RegisterAccount();
            Thread.sleep(2000);
            register = new RegistrationPage(driver);
            register.enterFirstName();
            register.enterLastName();
            register.enterPassword("Monkey");
            register.enterEmail();
            register.ClickNewsletterYes();
            register.ClickTermsandConditions();
            register.ClickSubmit();
            Assert.assertTrue(true);

        } catch (Exception e) {
            System.out.println("Registration failed with an exception: " + e.getMessage());
            Assert.fail("Registration failed: " + e.getMessage());
        }
    }
}