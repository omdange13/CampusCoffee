package testclasses;

import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import testBase.WebTestBase;

public class RegisterTest extends WebTestBase {
    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public AccountDetailsPage accountDetailsPage;
    public RegisterPage registerPage;
    RegisterTest(){

        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        homePage =  new HomePage();
        loginPage = new LoginPage();
        myAccountPage =  new MyAccountPage();
        accountDetailsPage=new AccountDetailsPage();
        registerPage = new RegisterPage();
    }
    @Test
    public void verifyRegistrationFunctionality() {
        SoftAssert softAssert = new SoftAssert();
        //homePage.claoseButtonSymbol();
        homePage.closeFirstAdd();
        homePage.clickOnLoginButton();
        loginPage.link();
        registerPage.registration(properties.getProperty("email1"), properties.getProperty("password1"));
        String myAccountPageText = myAccountPage.textMyAccount();
        softAssert.assertEquals(myAccountPageText, "MY ACCOUNT", "Text should be matched here");
        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown() {
        webDriver.close();
    }
}
