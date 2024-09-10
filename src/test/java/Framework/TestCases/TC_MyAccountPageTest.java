package Framework.TestCases;

import Framework.PageObject.AccountCreationDetails;
import Framework.PageObject.IndexPage;
import Framework.PageObject.MyAccount;
import org.testng.annotations.*;

public class TC_MyAccountPageTest extends BaseClass {

    @Test
    public void VerifyRegAndLogin() throws InterruptedException {
        driver.get(url);

        logger.info("Website Opened");

        IndexPage pg = new IndexPage(driver);
        pg.ClickOnSignup();

        MyAccount My = new MyAccount(driver);
        My.EnterName("Viru92");
        My.EnterEmailID("viru6@yopmail.com");
        My.SignupButton();

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
    }
}
