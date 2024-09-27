package Framework.PageObject;

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

    public String SearchResultProductName(){
        return  (SearchResult.getText());
    }
}
