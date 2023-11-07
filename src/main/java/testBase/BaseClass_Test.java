package testBase;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

public class BaseClass_Test {

	public ResourceBundle config;// to read config.properties
	public Logger logger;// for Logging
	public static WebDriver driver;  // make it static so that you can use same instance in Extent report manager


	@BeforeClass //Step8 groups added
	@Parameters("Browser")   // getting browser parameter from testng.xml
	public void setup(String Browser)
	{
		config = ResourceBundle.getBundle("config");// Load config.properties
		logger = LogManager.getLogger(this.getClass());// for Logger

		//launch right browser based on parameter
		if (Browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://community.shopify.com/c/forums/searchpage/tab/message?filter=location&q=dd&location=forum-board:ecommerce-design&collapse_discussion=true"); // get url from config.properties file
		driver.manage().window().maximize();
	}

	@AfterClass//Step8 groups added
	public void teadDown() {
		driver.quit();
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}
