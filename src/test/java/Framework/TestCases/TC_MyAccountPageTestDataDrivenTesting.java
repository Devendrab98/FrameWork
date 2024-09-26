package Framework.TestCases;

import Framework.PageObject.AccountCreationDetails;
import Framework.PageObject.IndexPage;
import Framework.PageObject.MyAccount;
import Framework.PageObject.RegisterUserAccount;
import Framework.Utilitize.ReadExcelFile;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_MyAccountPageTestDataDrivenTesting extends BaseClass {

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

    @Test(dataProvider = "LoginDataProvider")
    public void VerifyLogin(String userEml, String passWrd, String ExpUserName) throws IOException {

        IndexPage pg = new IndexPage(driver);
        pg.ClickOnSignup();
        logger.info("Successfully click on the sing up link");

        MyAccount My = new MyAccount(driver);
        My.EnterLoginEmail(userEml);
        logger.info("Enter Email successfully");
        My.EnterLoginPassword(passWrd);
        logger.info("Enter Password successfully");
        My.ClickOnLoginButton();
        logger.info("Button clicked successfully");
        logger.info("Log in Successfully");

        RegisterUserAccount rgUser = new RegisterUserAccount(driver);
        String LoginUser = rgUser.verifyname();

        if (LoginUser.equals(ExpUserName)) {
            logger.info("User name is correct");
            Assert.assertTrue(true);
//            System.out.println("Log file path: " + System.getProperty("user.dir") + "/logs/mylog.log");
//            logger.debug("This is a debug message");
//            logger.info("This is an info message");
            rgUser.logout();
        } else {
            logger.info("User name is Incorrect");
            CaptureScreenShot(driver, "VerifyLogin");
            Assert.assertTrue(false);
        }


    }

    @DataProvider(name = "LoginDataProvider")
    public String [][] LoginDataProvider() {

        System.out.println(System.getProperty("user.dir"));
        String fileName = System.getProperty("user.dir") + "\\TestData\\Test Data.xlsx";

        // Using Apache POI's DataFormatter to read different types of data
        DataFormatter dataFormatter = new DataFormatter();

        int TotalRow = ReadExcelFile.getRowCount(fileName, "Sheet1");
        int TotalColumn = ReadExcelFile.getColCount(fileName, "Sheet1");

        String[][] data= new String[TotalRow -1][TotalColumn];

        for (int i=1; i<TotalRow; i++)
        {
            for (int j=0; j<TotalColumn;j++)
            {
                data[i -1][j] = ReadExcelFile.getCellValue(fileName, "Sheet1", i,j, dataFormatter );
                System.out.println( data[i -1][j]);
            }
        } logger.info("Data is successfully fetch from Excel file");
        return data;

    }
}
