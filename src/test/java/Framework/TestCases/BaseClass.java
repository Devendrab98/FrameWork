package Framework.TestCases;


import Framework.Utilitize.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class BaseClass {

    ReadConfig readConfig;

    {
        try {
            readConfig = new ReadConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String url = readConfig.getbaseURl();
    String Browser = readConfig.getBrowser();

    public static WebDriver driver;
    public static Logger logger;

    @BeforeClass
    public void steup() {

        // launch Browser
        switch (Browser.toLowerCase()) {

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;
        }

        // implicitly wait for 10 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        // for logging
        logger= LogManager.getLogger("FrameworkDemo");

        // Open URL
        driver.get(url);
        logger.info("Website Opened");

    }

    @AfterClass
    public void teardown() {
        driver.quit();

    }

    public void CaptureScreenShot(WebDriver driver, String testName) throws IOException {
        // step 1: Convert the webdriver object to Take Screenshot interface
        TakesScreenshot screenshot = ((TakesScreenshot) driver);

        // step 2: call the get screenshot method to create image file

        File src = screenshot.getScreenshotAs(OutputType.FILE);

        File des= new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");

        // step copy image file destination
        FileUtils.copyFile(src ,des);

        logger.info("ScreenShot Taken Successfully!");
    }

}
