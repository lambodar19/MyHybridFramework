package interviewPre;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class testAndroid {



    @Test
    public void test() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options= new UiAutomator2Options();
        options.setDeviceName("Pixel 7 Pro API 33");
        //options.setApp("C:/Users/91900/Downloads/app-qa-release.apk");
        options.setApp("C:/Users/91900/Downloads/SampleApp.apk");
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");

        AndroidDriver driver1=  new AndroidDriver(new URL("http://0.0.0.0:4723"),options);


    }
}
