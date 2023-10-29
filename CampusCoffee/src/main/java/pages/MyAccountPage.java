package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.WebTestBase;
import utlity.DriverUtlity;

public class MyAccountPage extends WebTestBase {
    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement myAccountText;
    @FindBy(xpath ="//div[text()='Campos Coffee']" )
    WebElement scrollTillEmail;
    public MyAccountPage(){
        PageFactory.initElements(webDriver, this );
    }
    public String textMyAccount(){
        return DriverUtlity.getTextElement(myAccountText);
    }
    public void emailSubmit(){
        DriverUtlity.ScrollDownByVisibleElement(scrollTillEmail);
    }
}


