package Framework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterUserAccount {

    WebDriver ldriver;

   public RegisterUserAccount(WebDriver rdriver){
        ldriver= rdriver;

        PageFactory.initElements(rdriver, this);
    }

    // Identify login user name element
    @FindBy(xpath = "//b[text()='Viru']")
    WebElement LoginUser;

   @FindBy(xpath ="//a[text()=' Logout']")
   WebElement SignOut;

    public String verifyname(){

        String text= LoginUser.getText();

        return text;
    }
    public void logout(){
        SignOut.click();
    }
}

