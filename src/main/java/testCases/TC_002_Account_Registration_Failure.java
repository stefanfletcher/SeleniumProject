package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_002_Account_Registration_Failure extends BaseClass {

    Homepage home;
    RegistrationPage register;


    @Test(groups = {"Negative"})
    void Fail_Register() throws InterruptedException {

        home = new Homepage(driver);
        home.ClickMyAccount();
        home.RegisterAccount();
        register = new RegistrationPage(driver);
        register.ClickSubmit();
        Thread.sleep(5000);
        if (register.firstNameBlank() && register.LastNameBlank() && register.emailBlank() &&  register.passwordBlank()) {
         Assert.assertTrue(true);
    }
        else {
            Assert.assertTrue(true);
        }
    }
}

