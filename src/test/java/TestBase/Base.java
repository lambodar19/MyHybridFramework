package TestBase;

import helpers.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class Base {

    WebDriver driver;
    Properties properties;
    public WebDriver launchURL(String browserName)
    {

        properties = ConfigReader.loadProperty();
        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
       // driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.get(properties.getProperty("url"));

        return driver;
    }

    public void waitForElement(WebElement ele)
    {
        try {

                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
                wait.until(ExpectedConditions.visibilityOf(ele));
                System.out.println("Waited for element to be visible");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
