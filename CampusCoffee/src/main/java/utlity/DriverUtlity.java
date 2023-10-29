package utlity;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.WebTestBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DriverUtlity  extends WebTestBase {
    public static final long PAGE_LODE_TIME = 30;
    public static final long IMPLICIT_WAIT = 30;
    public static final long EXPLICT_WAIT = 30;
    public static WebDriverWait wait;
    public static Actions actions;
    public static JavascriptExecutor javascriptExecutor;
    public static Select select;
    public static TakesScreenshot takesScreenshot;
    public static void waitUntilElementToBeClickable(WebElement element){

        wait= new WebDriverWait(webDriver,Duration.ofSeconds(EXPLICT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public static String getTextElement(WebElement element)
    {
        return element.getText();
    }
    public static void actionMoveToElement(WebElement element){
        actions=new Actions(webDriver);
        actions.moveToElement(element).perform();
    }
    public static void ScrollDownByVisibleElement(WebElement element){
        javascriptExecutor  = (JavascriptExecutor)webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",element);
    }
    public static String dropdownSelection(String visibleText ,WebElement element){
        select = new Select(element);
        select.selectByVisibleText(visibleText);
        return visibleText;
    }
    public static void TakesScreenshot() throws IOException {
        File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(file,new File(System.getProperty("user.dir") + "/src/main/resources/Screenshot/Screenshot.png"));
    }
}
