package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.commons.lang3.RandomStringUtils;

public class RegistrationPage extends Base_Class {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    private final By Firstname = By.xpath("//input[@id='input-firstname']");
    private final By Failedfirstname = By.xpath(" //div[@id='error-firstname']");
    private final By LastName = By.xpath("//input[@id='input-lastname']");
    private final By Failedlastname = By.xpath("//div[@id='error-lastname']");
    private final By Email = By.xpath("//input[@id='input-email']");
    private final By FailedEmail = By.xpath("//div[@id='error-email']");
    private final By Password = By.xpath("//input[@id='input-password']");
    private final By FailedPassword = By.xpath("//div[@id='error-password']");
    private final By NewsletterYes = By.xpath("//input[@id='input-newsletter-yes']");
    private final By Newsletterno = By.xpath("//input[@id='input-newsletter-no']");
    private final By Termsandcondtion = By.xpath("//input[@name='agree']");
    private final By RegisterSubmit = By.xpath("//button[@class='btn btn-primary']");
    private final By SuccesRegister = By.xpath("//h1[contains(text(),'Your Account Has Been']");


    public Boolean Success () {
        Boolean Successisvisable =   driver.findElement(SuccesRegister).isDisplayed();
        return  Successisvisable;
    }
    public String gettitle() {
        String current_title = driver.getTitle();
        return current_title;
    }
    public String Expected_title() {
       String Expected_title = "Register Account";
       return Expected_title;
    }

    public void Entername(String Name) {;
        driver.findElement(Firstname).sendKeys(Name);
    }

        public String enterFirstName() {
            String randomFirstname = RandomStringUtils.randomNumeric(10);
            driver.findElement(Firstname).sendKeys(randomFirstname);
            return randomFirstname;
    }

    public Boolean firstNameBlank() {
     Boolean Blanknameisvisable =   driver.findElement(Failedfirstname).isDisplayed();
    return  Blanknameisvisable;
    }


    public String enterLastName() {
        String randomLastname = RandomStringUtils.randomNumeric(10);
        driver.findElement(LastName).sendKeys(randomLastname);
        return randomLastname;
    }

    public Boolean LastNameBlank() {
      Boolean Blanklastnameisvisable =  driver.findElement(Failedlastname).isDisplayed();
     return Blanklastnameisvisable;
    }

    public void enterEmail() {
        String randomEmail = RandomStringUtils.randomAlphabetic(4) + "@bob.com"; // Change "example.com" to your desired domain
        driver.findElement(Email).sendKeys(randomEmail);
    }

    public Boolean emailBlank() {
     Boolean Blankemailisvisable =   driver.findElement(FailedEmail).isDisplayed();
        return Blankemailisvisable;
    }

    public void enterPassword(String PasswordDetails) {
        driver.findElement(Password).sendKeys(PasswordDetails);
    }

    public Boolean passwordBlank() {
        Boolean BlankPasswordisvisable = driver.findElement(FailedPassword).isDisplayed();
    return BlankPasswordisvisable;
    }

    public void ClickNewsletterYes() {
        driver.findElement(NewsletterYes).click();
    }

    public void ClickNewsletterNo() {
        driver.findElement(Newsletterno).click();
    }

    public void ClickTermsandConditions() {
        driver.findElement(Termsandcondtion).click();
    }

    public void ClickSubmit() {
        driver.findElement(RegisterSubmit).click();
    }
}

                    // You should have your test methods here

