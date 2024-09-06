package Framework.TestCases;

import Framework.PageObject.IndexPage;
import Framework.PageObject.MyAccount;
import org.testng.annotations.*;

public class TC_MyAccountPageTest extends BaseClass {

    @Test
    public void VerifyRegAndLogin() {
        driver.get(url);

        logger.info("Website Opened");

        IndexPage pg = new IndexPage(driver);
        pg.ClickOnSignup();

        MyAccount My = new MyAccount(driver);
        My.EnterName("Viru");
        My.EnterEmailID("viru@yopmail.com");
        My.SignupButton();

    }
}
