package interviewPre;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BrowserNavigation {

   WebDriver driver;


@Test
    public void launch()
    {
        driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        Wait <WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Wait <WebDriver> wait1 =  new FluentWait<> (driver).
            withTimeout(Duration.ofMillis(20)).
            pollingEvery(Duration.ofSeconds(5)).
            ignoring(ElementNotInteractableException.class);

        List<WebElement> ele = driver.findElements(By.xpath("test"));

    }

}
