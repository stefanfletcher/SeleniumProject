package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

public class MyAccountPage extends Base_Class {

    // Instantiate
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    //Elements

    private final By SelectMyAccount = By.xpath("//a[normalize-space()='Edit your account information']");
    private final By Logout = By.xpath("//a[@class='dropdown-item'][normalize-space()='Logout']");
    private final By Logoutsuccess = By.xpath("//h1[normalize-space()='Account Logout']");


    public Boolean AccountPageExists() {
        try {
            return (driver.findElement(SelectMyAccount).isDisplayed());
        } catch (Exception e) {
            return (false);
        }

    }

    public void ClickLogout()
    {driver.findElement(Logout).click();}

    public Boolean ValidateSuccessfulLogout() {
        try {
            return (driver.findElement(Logoutsuccess).isDisplayed());
        } catch (Exception e) {
            return (false);
        }

    }
}



