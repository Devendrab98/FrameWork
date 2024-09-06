package Framework.TestCases;


import Framework.Utilitize.ReadConfig;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

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

        // for logging
        logger = LogManager.getLogger("FrameworkDemo");

    }

    @AfterClass
    public void teardown() {
        driver.close();
        driver.quit();

    }


}
