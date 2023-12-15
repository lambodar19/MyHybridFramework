package helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class QaListeners implements ITestListener {
    ExtentReports extentReports;
    ExtentTest extentTest;
    String tcName;


    @Override
    public void onStart(ITestContext context) {

        System.out.println("Execution of project test started");
        extentReports=  ExtentReporter.generateReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        tcName =result.getName();
         extentTest= extentReports.createTest(tcName);
         extentTest.log(Status.INFO, "The Testcase "+tcName+" is executing");
        //System.out.println("The Testcase "+tcName+" is executing");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        tcName =result.getName();
        extentTest.log(Status.PASS,"The Testcase "+tcName+" is Passed");
        //System.out.println("The Testcase "+tcName+" is Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        tcName =result.getName();
        WebDriver driver=null;
        String dest=null;

        try {
             driver= (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
            /*File src= ( (TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            dest = System.getProperty("user.dir") + "/Screenshots/OpenTest.png";
            FileHandler.copy(src, new File(dest));
             FileHandler.copy(src, new File(dest));*/


        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
         dest =  Utilities.captureScreenshot(driver,result.getName());
        //extentTest.addScreenCaptureFromPath(dest);
        // Attach the screenshot to the extent report
        extentTest.fail("The test case " + tcName + " is failed",
                MediaEntityBuilder.createScreenCaptureFromPath(dest).build());

        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.FAIL,"The test case "+tcName+" is failed");
        System.out.println("The Testcase "+tcName+" is Failed");
       // System.out.println(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        tcName =result.getName();
        extentTest.log(Status.INFO,result.getThrowable());
        System.out.println("The Testcase "+tcName+" is Skipped");
        //System.out.println(result.getThrowable());
    }


    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();

        System.out.println("Execution of project test completed");

    }

}
