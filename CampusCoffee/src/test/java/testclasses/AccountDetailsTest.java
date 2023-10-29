package testclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import testBase.WebTestBase;
import utlity.DriverUtlity;
public class AccountDetailsTest extends WebTestBase {
    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public AccountDetailsPage accountDetailsPage;
    AccountDetailsTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
            initialization();
            homePage =  new HomePage();
            loginPage = new LoginPage();
            myAccountPage =  new MyAccountPage();
            accountDetailsPage=new AccountDetailsPage();
        }
    @Test
    public void  verifyAccountDetails(){
        SoftAssert softAssert = new SoftAssert();
        homePage.claoseButtonSymbol();
        homePage.closeFirstAdd();
        homePage.clickOnLoginButton();
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        accountDetailsPage.accountDetails(properties.getProperty("firstname"), properties.getProperty("lastname"));
        String myAccountPageText=myAccountPage.textMyAccount();
        softAssert.assertEquals(myAccountPageText, "MY ACCOUNT", "Text should be matched here");
        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown() {
        webDriver.close();
    }
}
