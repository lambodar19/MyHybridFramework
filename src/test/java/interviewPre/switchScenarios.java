package interviewPre;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class switchScenarios {

    WebDriver driver;


    @Test
    public void myTest()
    {
        driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.switchTo().alert();

       String currentWindow =  driver.getWindowHandle();


    }
}
