package Framework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {

    // Create object of Webdriver
    WebDriver ldriver;

    // Constructor
    public MyAccount(WebDriver rdriver) {

        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }

    // Identify Elements for signup
    @FindBy(name = "name")
    WebElement Name;

    @FindBy(name = "email")
    WebElement EnterEamil;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement sinupBtn;

    public void EnterName(String UName) {
        Name.sendKeys(UName);
    }

    public void EnterEmailID(String Email) {
        EnterEamil.sendKeys(Email);
    }

    public void SignupButton() {
        sinupBtn.click();
    }

}
