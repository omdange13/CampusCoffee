package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.WebTestBase;
import utlity.DriverUtlity;

import static utlity.DriverUtlity.actions;

public class HomePage  extends WebTestBase {
    @FindBy(xpath ="//a[@class='user-controls__ul__li__a']")
    WebElement loginElement;

    @FindBy(xpath ="//button[@title='Close']")
    WebElement claoseButtonSymbol;

    @FindBy(xpath ="//a[@class='newsletter__close newsletter__trigger']")
    WebElement cloaseFirstAdd;
    @FindBy(xpath="//a[text()='Shop']")
    WebElement toShop;
    @FindBy(xpath = "//li[@id='menu-item-435387']")
    WebElement capsule;
    @FindBy(id="sort")
    WebElement sortDropdown;

    public  HomePage(){
        PageFactory.initElements(webDriver, this );
    }
    public void closeFirstAdd(){
        DriverUtlity.waitUntilElementToBeClickable(cloaseFirstAdd);
    }
    public void claoseButtonSymbol(){
        DriverUtlity.waitUntilElementToBeClickable(claoseButtonSymbol);
    }
    public void clickOnLoginButton(){
        DriverUtlity.waitUntilElementToBeClickable(loginElement);
    }
    public void clickonShopoption(){
        DriverUtlity.actionMoveToElement(toShop);
        actions.perform();
        DriverUtlity.waitUntilElementToBeClickable(capsule);
    }
    public void dropdown(){
        DriverUtlity.dropdownSelection("Latest",sortDropdown);
    }

}
