package Framework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    // Create object of Webdriver
    WebDriver ldriver;

    // Constructor
    public IndexPage(WebDriver rdriver) {

        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }

    // Identify Elements
    @FindBy(xpath = "//a[text()=' Signup / Login']")
    WebElement signup;

    // Click on sign up
    public void ClickOnSignup() {
        signup.click();
    }

}
