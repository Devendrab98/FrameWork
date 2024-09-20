package Framework.TestCases;

import Framework.PageObject.AccountCreationDetails;
import Framework.PageObject.IndexPage;
import Framework.PageObject.MyAccount;
import Framework.PageObject.RegisterUserAccount;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class TC_MyAccountPageTest extends BaseClass {

    @Test(enabled = false)
    public void VerifyRegAndLogin() throws InterruptedException {

        IndexPage pg = new IndexPage(driver);
        pg.ClickOnSignup();

        MyAccount My = new MyAccount(driver);
        My.EnterName("Viru");
        My.EnterEmailID("viru34@yopmail.com");
        My.SignupButton();
        logger.info("Signup successfully");

        AccountCreationDetails ACCD = new AccountCreationDetails(driver);
        ACCD.SelectTitleMr();
        ACCD.EnterPassword("123456");
        ACCD.EnterAddFName("Viru");
        ACCD.EnterAddLName("Kumar");
        ACCD.EnterAddress("Pune");
        ACCD.SelectCountryName("India");
        ACCD.EnterStateName("MH");
        ACCD.EnterCityName("Pune");
        ACCD.EnterZipCode("1234");
        ACCD.EnterMobileNumber("9876432123");
        ACCD.ClickOnRegistration();

        logger.info("Registration successfully");

    }

    @Test
    public void VerifyLogin() throws IOException {

        IndexPage pg = new IndexPage(driver);
        pg.ClickOnSignup();

        MyAccount My = new MyAccount(driver);
        My.EnterLoginEmail("viru34@yopmail.com");
        My.EnterLoginPassword("123456");
        My.ClickOnLoginButton();
        logger.info("Log in successfully");

        RegisterUserAccount rgUser = new RegisterUserAccount(driver);
        String LoginUser = rgUser.verifyname();

        if (LoginUser.equals("Viru")) {
            logger.info("User name is correct");
            Assert.assertTrue(true);
        } else {
            logger.info("User name is Incorrect");
            CaptureScreenShot(driver, "VerifyLogin");
            Assert.assertTrue(false);
        }
    }
}
