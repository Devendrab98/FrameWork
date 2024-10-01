package Framework.PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    WebDriver ldriver;

    public SearchResultPage(WebDriver rdriver){
        ldriver= rdriver;

        PageFactory.initElements(rdriver, this);
    }

//    @FindBy(xpath = "//p[text()='GRAPHIC DESIGN MEN T SHIRT - BLUE']")
//    WebElement SearchResult;
    @FindBy(xpath = "//div[@class='features_items']")
    WebElement SearchResult;

    // View Product Element
    @FindBy(xpath = "//a[text()='View Product']" )
    WebElement ViewProductBtn;

    // Change Quantity Element
    @FindBy(id = "quantity")
    WebElement ChangeQuantity;

    // Click on Add TO Cart Button Element
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement AddTOCartBtn;

    // Confirmation Pop-up Element
    @FindBy(xpath = "//button[text()='Continue Shopping']")
    WebElement ConfirmationPop_up;

    // Click on Cart option Element
    @FindBy(xpath = "//a[text()=' Cart']")
    WebElement CartOption;


    public String SearchResultProductName(){
        return  (SearchResult.getText());
    }

    public void ClickOnViewProduct(){
        ViewProductBtn.click();
    }


    public void ClickOnQuantity(){
        ChangeQuantity.click();
        ChangeQuantity.sendKeys(Keys.BACK_SPACE);
        ChangeQuantity.sendKeys("2");
    }

    public void ClickOnAddToCartButton(){
        AddTOCartBtn.click();
    }

    public void ClickOnPop_up(){
        ConfirmationPop_up.click();
    }

    public void ClickOnCartLink(){
        CartOption.click();
    }
}
