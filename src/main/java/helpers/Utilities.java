package helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Utilities {
    WebDriver driver;
    public static String captureScreenshot(WebDriver driver, String TcName)
    {
        File src= ( (TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       String dest = System.getProperty("user.dir") + "/Screenshots/OpenTest.png";
        try {
            FileHandler.copy(src, new File(dest));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            return dest;
    }

}
