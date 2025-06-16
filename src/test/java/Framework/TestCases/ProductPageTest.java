package Framework.TestCases;

import Framework.PageObject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductPageTest extends BaseClass {

    @Test(enabled = false)
    public void VerifyProduct() {

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
    }


    @Test(enabled = true)
    public void CheckOutProduct() throws InterruptedException {

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
        Thread.sleep(200);
        result.ClickOnViewProduct();

        ViewProductPage View = new ViewProductPage(driver);
        View.ClickOnQuantity();
        View.ClickOnAddToCartButton();
        View.ClickOnPop_up();
        View.ClickOnCartLink();

        CartPage cp = new CartPage(driver);
        String QuntNumber = cp.ProQuantity();
        System.out.println("Quantity Of Product is: "+ QuntNumber);

        cp.ClickOnCheckOutBtn();
        cp.ClickOnPlaceOrder();
        cp.EnterCartName("Viru");
        cp.EnterCartNumber("4242424242424242");
        cp.EnterCVC("123");
        cp.EnterMonth("02");
        cp.EnterYear("2025");
        cp.ClickOnSubmit();

        String SuccessMessage = cp.OrderPlaceMessage();

        if (SuccessMessage.equals("Congratulations! Your order has been confirmed!")){
            System.out.println("Check out product - Pass");
            Assert.assertTrue(true);
        } else {
            System.out.println("Check out product - fail");
            Assert.assertFalse(false);
        }
    }
}