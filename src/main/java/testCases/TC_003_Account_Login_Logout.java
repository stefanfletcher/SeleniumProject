package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_003_Account_Login_Logout extends BaseClass {

    Homepage home;
    LoginPage login;
    MyAccountPage account;

    @Test(groups = {"Main"})
    void Login() throws InterruptedException {
        try {

            home = new Homepage(driver);
            home.ClickMyAccount();
            home.LogintoAccount();
            login = new LoginPage(driver);
            login.EnterEmail(config.getString("Email"));
            login.EnterPassword(config.getString("Password"));
            login.ClickLoginSubmit();
            account = new MyAccountPage(driver);
            if (account.AccountPageExists()) {
                Assert.assertTrue(true);
            }
            else if (!account.AccountPageExists()){
                Assert.assertTrue(false);
            }
        } catch (Exception e) {
            // Proper logging
            logger.error("Login test case failed due to " + e.getMessage());
            Assert.fail("Login test case failed: " + e.getMessage());
        }

    }

    @Test( dependsOnMethods = "Login")
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


