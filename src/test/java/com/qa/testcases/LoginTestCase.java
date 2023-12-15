/*
package com.qa.testcases;

import TestBase.Base;
import helpers.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.Properties;

@Test
public class LoginTestCase extends Base {

    private By userName = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By dahboardIcon = By.xpath("//span[@class='oxd-topbar-header-breadcrumb']" +
                                                    "//h6[text()='Dashboard']");
    WebDriver driver;


    public void myTest() throws InterruptedException {

        Assert.assertTrue(driver.findElement(dahboardIcon).isDisplayed());

    }

    @BeforeMethod
    public void setUp() {
       // Properties properties = ConfigReader.loadProperty();
        Properties properties= ConfigReader.loadProperty();
        driver= launchURL(properties.getProperty("browser"));
        driver.findElement(userName).sendKeys(properties.getProperty("username"));
        driver.findElement(password).sendKeys(properties.getProperty("password"));
        driver.findElement(loginButton).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
*/
