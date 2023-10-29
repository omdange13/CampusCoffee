package testclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import testBase.WebTestBase;

public class HomeTest  extends WebTestBase {
    public HomePage homePage;
    public HomeTest(){
        super();
    }
    @BeforeMethod

    public void setUp(){
        initialization();
        homePage =  new HomePage();
    }
    @Test
    public  void  selectOption() throws InterruptedException {
        //homePage.claoseButtonSymbol();
        homePage.closeFirstAdd();
        homePage.clickonShopoption();
        //Thread.sleep(3000);
        homePage.closeFirstAdd();
        homePage.dropdown();
        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDown() {
        webDriver.close();
    }

}
