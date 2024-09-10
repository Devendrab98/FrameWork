package Framework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisterUserAccount {

    WebDriver ldriver;

    RegisterUserAccount(WebDriver rdriver){
        ldriver= rdriver;

        PageFactory.initElements(rdriver, this);
    }
}
