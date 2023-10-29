package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utlity.DriverUtlity;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class WebTestBase {
    public  static Properties properties;
    public static WebDriver webDriver;
    public WebTestBase() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Config/config.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initialization(){
        String browserName = properties.getProperty("browserName");
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");
             webDriver =  new ChromeDriver();  //upcasting

        }else  if (browserName.equalsIgnoreCase("firefox")){


        }else  if (browserName.equalsIgnoreCase("edge")) {


        }else{
                throw new RuntimeException("Please select correct browser");

        }
        webDriver.get(properties.getProperty("url"));
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(DriverUtlity.PAGE_LODE_TIME));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DriverUtlity.IMPLICIT_WAIT));
    }

}
