package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testBase.WebTestBase;
import java.util.List;
import org.openqa.selenium.support.PageFactory;
import utlity.DriverUtlity;

public class LoginPage extends WebTestBase {
    @FindBy(id = "username")
    WebElement userNameTextBox;
    @FindBy(id = "password")
    WebElement passwordTextBox;
    @FindBy(name = "login")
    WebElement loginButton;
    @FindBy(linkText = "Click here")
    WebElement registrationLink;
    // @FindBy(xpath = "")
    //List<WebElement> allElements;
    public LoginPage() {
        PageFactory.initElements(webDriver, this);
    }
    public void login(String username, String password) {
        userNameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        DriverUtlity.waitUntilElementToBeClickable(loginButton);
    }
    public void link() {
        DriverUtlity.waitUntilElementToBeClickable(registrationLink);
    }
}
