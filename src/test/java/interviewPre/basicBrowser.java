package interviewPre;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class basicBrowser {
    WebDriver driver;

    private By tool = By.xpath("//option[text()='Select Tool']//parent::select");

    @Test
    public void test() throws IOException {
        driver = new ChromeDriver();
        driver.get("https://www.leafground.com/select.xhtml");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebElement menu = driver.findElement(tool);
        List<WebElement> ele = menu.findElements(By.tagName("option"));

        for (WebElement el : ele) {
            System.out.println(el.getText());

        }

        int listSize = ele.size();
        for (int i = 2; i <= listSize; i++) {
            String mytext = driver.findElement(By.xpath("//option[text()='Select Tool']//parent::select//option[" + i + "]")).getText();
            System.out.println("using for loop= " + mytext);
        }


/*        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(menu));

        Wait<WebDriver> wait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(ElementNotInteractableException.class);

        wait1.until(ExpectedConditions.visibilityOf(menu));*/


       File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(src, new File("./newScreenshot.png"));

       driver.quit();

    }



// Explicit Wait



}
