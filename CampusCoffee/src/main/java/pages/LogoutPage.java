package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.WebTestBase;
import utlity.DriverUtlity;

import java.io.IOException;

public class LogoutPage  extends WebTestBase {
    @FindBy(xpath = "//a[@class='account-button']")
    WebElement logout;
    @FindBy(xpath = "//a[text()='Confirm and log out']")
    WebElement logoutBtn;
    public LogoutPage(){
        PageFactory.initElements(webDriver, this );
    }
    public void logoutClick(){
        DriverUtlity.waitUntilElementToBeClickable(logout);
        DriverUtlity.waitUntilElementToBeClickable(logoutBtn);
    }
    public void CaptureScreenshot() throws IOException {
        DriverUtlity.TakesScreenshot();
    }
}
