package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_004_Account_Login_With_Excel extends BaseClass {

    Homepage home;
    LoginPage login;
    MyAccountPage account;

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = {"Main"})
    void Login(String Email, String Password, String Expected) throws InterruptedException {
        try {
            home = new Homepage(driver);
            home.ClickMyAccount();
            home.LogintoAccount();
            login = new LoginPage(driver);
            login.EnterEmail(Email);
            login.EnterPassword(Password);
            login.ClickLoginSubmit();
            account = new MyAccountPage(driver);
            boolean targetPage = account.AccountPageExists();
            // If valid and we see the next page assert the test as passed
            if(Expected.equals("Valid") && targetPage==true) {
                Assert.assertTrue(true);
            }
            // If invalid, fail and logout
            else if (Expected.equals("Invalid") && targetPage==true) {
                Assert.assertTrue(false);
                account = new MyAccountPage(driver);
                account.ClickLogout();
              }
            else if (Expected.equals("Valid") && targetPage==false) {
                Assert.assertTrue(targetPage, "Account validation failed.");
            }
        } catch (Exception e) {
            // Use proper logging here instead of System.out.println()
            System.out.println("Test 'LoginAndVerifyAccountPage' failed due to " + e.getMessage());
        }

    }

    @Test(priority = 2, dependsOnMethods = "Login")
    void Logout() {
        try {
            account = new MyAccountPage(driver);
            account.ClickLogout();
            boolean accountLogoutTarget = account.ValidateSuccessfulLogout();
            Assert.assertTrue(accountLogoutTarget, "Account logout validation failed.");
        } catch (Exception e) {
            System.out.println("Test 'ValidateAccountLogout' failed due to: " + e.getMessage());
        }
    }
}

