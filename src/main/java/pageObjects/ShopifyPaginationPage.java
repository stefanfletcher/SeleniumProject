package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopifyPaginationPage extends Base_Class {

    public ShopifyPaginationPage(WebDriver driver) {
        super(driver);
    }

    //Elements

    private final By NextButton = By.xpath("//span[normalize-space()='Next']");
    private final By NumberofResults = By.xpath("//div[@class='search-result-count']");

    public void NumberofResults() throws InterruptedException {
        String Results = driver.findElement(NumberofResults).getText();
        Results = Results.replace(" results", "");
        int ResultTotal = Integer.parseInt(Results);
        System.out.println(ResultTotal);

    }
    public void LoopthroughPages() throws InterruptedException {
        String Results = driver.findElement(NumberofResults).getText();
        Results = Results.replace(" results", "");
        int ResultTotal = Integer.parseInt(Results);
        System.out.println(ResultTotal);
        if (ResultTotal >= 1) {
            for (int r = 1; r <= 12; r++) {
                WebElement activePage = driver.findElement(By.xpath("/html/body/div[2]/center/div/div/div/div/div[1]/div[2]/div/div/div/div/div[2]/div/div/div/div[4]/ul/li[2]/ul/li//*[text()='" + r + "']"));
                System.out.println(activePage.getText());
                activePage.click();
                Thread.sleep(2000);
            }
        } else{
                System.out.println("No pages found.");
            }
        }
    }