package interviewPre;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class switchAndWindows {

    WebDriver driver;

    private By open = By.xpath("//span[text()='Open']");

    @Test
    public void test() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.leafground.com/window.xhtml");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent: " + parentWindow);
        System.out.println("Parent page title- " + driver.getTitle());
        driver.findElement(open).click();
       /* driver.switchTo().newWindow(WindowType.WINDOW);
        String secondWin = driver.getWindowHandle();
        System.out.println("Second Window: "+secondWin);
        Thread.sleep(4000);
        System.out.println("Second page title- "+driver.getTitle());*/

        Set<String> allWindows = driver.getWindowHandles();
        System.out.println("Number of windows: " + allWindows.size());

        for (String win : allWindows) {
            driver.switchTo().window(win);
            if (driver.getTitle().contains("Dashboard")) {
                System.out.println("This is second window");
                driver.close();
                break;
            } else {
                System.out.println("This is not second window");
            }
        }

        driver.quit();

    }
}
