package helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.Properties;

public class ExtentReporter {
    public static Properties properties= ConfigReader.loadProperty();
    public static ExtentReports generateReport()

    {

        ExtentReports extentReports = new ExtentReports();
        String fileLoc = System.getProperty("user.dir")+"/Reports/extentreport.html";
        File extentReportFile = new File("./Reports/extentreport.html");
        //File extentReportFile =new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
        ExtentSparkReporter spark = new ExtentSparkReporter(extentReportFile);
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Test Automation Results");
        spark.config().setDocumentTitle("Test Automation COE");
        spark.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

        extentReports.attachReporter(spark);
        extentReports.setSystemInfo("Application URL",properties.getProperty("url"));
        extentReports.setSystemInfo("Browser Name",properties.getProperty("browser"));


        return extentReports;
    }
}
