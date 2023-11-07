package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base_Class {

    // Instantiate
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Elements

    private final By Login_Email = By.xpath("//input[@id='input-email']");
    private final By Login_Password = By.xpath("//input[@id='input-password']");
    private final By Login_Submit = By.xpath("//button[@type='submit']");


    public void EnterEmail(String Email) {
        driver.findElement(Login_Email).sendKeys(Email);
    }

    public Boolean LoginBoxAppeared() {
        Boolean Blanknameisvisable =   driver.findElement(Login_Email).isDisplayed();
        return  Blanknameisvisable;
    }


    public void EnterPassword(String Pass) {
        driver.findElement(Login_Password).sendKeys(Pass);
    }
    public void ClickLoginSubmit()
    {driver.findElement(Login_Submit).click();}

    }


