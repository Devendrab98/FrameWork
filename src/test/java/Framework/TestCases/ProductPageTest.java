package Framework.TestCases;

import Framework.PageObject.IndexPage;
import Framework.PageObject.MyAccount;
import Framework.PageObject.RegisterUserAccount_HomePage;
import Framework.PageObject.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductPageTest extends BaseClass {

    @Test
    public void VerifyProduct() throws IOException {

        String keyword = "jeans";

        IndexPage pg = new IndexPage(driver);
        pg.ClickOnSignup();

        MyAccount My = new MyAccount(driver);
        My.EnterLoginEmail("viru34@yopmail.com");
        My.EnterLoginPassword("123456");
        My.ClickOnLoginButton();
        logger.info("Log in successfully");

        RegisterUserAccount_HomePage Hm = new RegisterUserAccount_HomePage(driver);
        Hm.ClickOnProductLink();
        Hm.SearchBar(keyword);
        Hm.ClickOnSearchButton();

        SearchResultPage result = new SearchResultPage(driver);
        String searchRslt = result.SearchResultProductName();
//        System.out.println("Product Name:"+ searchRslt);

        if (searchRslt.toLowerCase().contains(keyword)) {
            System.out.println("Product search test case is pass");
            Assert.assertTrue(true);
        } else {
            System.out.println("Product search test case is fail");
            Assert.assertTrue(false);

        }
        result.ClickOnViewProduct();
        result.ClickOnQuantity();
        result.ClickOnAddToCartButton();
        result.ClickOnPop_up();
        result.ClickOnCartLink();

    }
}