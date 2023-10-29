package testclasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.MyAccountPage;
import testBase.WebTestBase;

import java.io.IOException;

public class LogoutTest extends WebTestBase {
    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public LogoutPage logoutPage;
    LogoutTest(){
        super();
    }
    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
        logoutPage = new LogoutPage();
    }
    @Test
    public void verifyLogout() throws IOException {
        SoftAssert softAssert = new SoftAssert();
        //homePage.claoseButtonSymbol();
        homePage.closeFirstAdd();
        homePage.clickOnLoginButton();
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        String myAccountPageText=myAccountPage.textMyAccount();
        softAssert.assertEquals(myAccountPageText, "MY ACCOUNT", "Text should be matched here");
        softAssert.assertAll();
        logoutPage.logoutClick();
        logoutPage.CaptureScreenshot();
    }
}


