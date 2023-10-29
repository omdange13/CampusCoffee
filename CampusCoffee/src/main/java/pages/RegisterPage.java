package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.WebTestBase;
import utlity.DriverUtlity;

public class RegisterPage extends WebTestBase {
    @FindBy(id="reg_email")
    WebElement registrationEmail;
    @FindBy(name="password")
    WebElement registartionPassword;
    @FindBy(name="register")
    WebElement registrationBtn;
    public RegisterPage(){
        PageFactory.initElements(webDriver, this);
    }
    public void registration(String email1,String password1){
        registrationEmail.sendKeys(email1);
        registartionPassword.sendKeys(password1);
        DriverUtlity.waitUntilElementToBeClickable(registrationBtn);
    }


}
