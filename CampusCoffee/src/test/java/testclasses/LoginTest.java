package testclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import testBase.WebTestBase;

public class LoginTest extends WebTestBase {
    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public AccountDetailsPage accountDetailsPage;
    public RegisterPage registerPage;
    LoginTest()
    {
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        homePage =  new HomePage();
        loginPage = new LoginPage();
        myAccountPage =  new MyAccountPage();
    }
    @Test
    public void verifyLoginWithValidData(){
        SoftAssert softAssert = new SoftAssert();
        //homePage.claoseButtonSymbol();
        homePage.closeFirstAdd();
        homePage.clickOnLoginButton();
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        String myAccountPageText=myAccountPage.textMyAccount();
        softAssert.assertEquals(myAccountPageText, "MY ACCOUNT", "Text should be matched here");
        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown() {
        webDriver.close();
        }
    }

