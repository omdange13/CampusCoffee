package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.WebTestBase;
import utlity.DriverUtlity;

public class AccountDetailsPage extends WebTestBase {

    @FindBy(xpath = "//a[text()='Account details']")
    WebElement accountclick;

    @FindBy(name = "account_last_name")
    WebElement firstName;

    @FindBy(xpath = "//input[@class='woocommerce-Input woocommerce-Input--text input-text']")
    WebElement lastName;

    @FindBy(name = "save_account_details")
    WebElement saveChanges;

    public AccountDetailsPage(){
        PageFactory.initElements(webDriver, this );
    }
    public void accountDetails(String firstname, String lastname){

        DriverUtlity.waitUntilElementToBeClickable(accountclick);
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        DriverUtlity.waitUntilElementToBeClickable(saveChanges);
        //DriverUtlity.TakesScreenshot();
    }

}
