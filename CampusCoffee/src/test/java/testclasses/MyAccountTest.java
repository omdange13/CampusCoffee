package testclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testBase.WebTestBase;

public class MyAccountTest extends WebTestBase {
    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public MyAccountTest() {
        super();
    }
    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
    }
    @Test
    public  void scrollDown() throws InterruptedException {
       // SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAdd();
        homePage.clickOnLoginButton();
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        //String myAccountPageText = myAccountPage.textMyAccount();
        myAccountPage.emailSubmit();
        Thread.sleep(3000);
        //softAssert.assertEquals(myAccountPageText, "MY ACCOUNT", "Text should be matched here");
        //softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown() {
        webDriver.close();
    }
}
