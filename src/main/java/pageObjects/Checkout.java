package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout extends Base_Class {

    // Instantiate
    public Checkout(WebDriver driver) {
        super(driver);
    }

    //Elements
    private final By CheckoutButtondisabled = By.xpath("//*[@id=\"checkout-payment\"]/div/button");



    public void Clickdisabledcheckout() {
        driver.findElement(CheckoutButtondisabled).click();

    }

    public Boolean PageisDisplayed () {
        try {
            return (driver.findElement(CheckoutButtondisabled).isDisplayed());
        } catch (Exception e) {
            return (false);
        }
    }


}
