package com.qa.testcases;

import TestBase.Base;
import com.qa.pageobjects.HomePage;
import com.qa.pageobjects.LoginPage;
import helpers.ConfigReader;
import org.checkerframework.checker.signature.qual.ClassGetName;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class TC_001_LoginTest extends Base {
public WebDriver driver;
public Properties properties= ConfigReader.loadProperty();
//LoginPage loginPage;

HomePage homePage;
    @BeforeMethod
    public void setUp() {

        driver= launchURL(properties.getProperty("browser"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginVerification() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
       // HomePage homePage = new HomePage(driver);
        loginPage.enterUsername(properties.getProperty("username"));
        loginPage.enterPassword(properties.getProperty("password"));
         homePage = loginPage.clickOnLogin();
        Thread.sleep(10000);
        Assert.assertTrue(homePage.verifyDashboardHeader(),"Not available");
    }
}



