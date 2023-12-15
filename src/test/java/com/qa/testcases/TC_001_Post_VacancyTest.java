package com.qa.testcases;

import TestBase.Base;
import com.qa.pageobjects.HomePage;
import com.qa.pageobjects.LoginPage;
import com.qa.pageobjects.RecruitmentPage;
import helpers.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class TC_001_Post_VacancyTest extends Base
{
        public WebDriver driver;
        HomePage homePage;
        Properties properties= ConfigReader.loadProperty();

        @BeforeMethod
        public void openApp()
        {
                driver= launchURL(properties.getProperty("browser"));
                LoginPage loginPage = new LoginPage(driver);
                loginPage.enterUsername(properties.getProperty("username"));
                loginPage.enterPassword(properties.getProperty("password"));
                homePage = loginPage.clickOnLogin();


        }

        @Test
        public void test()
        {
                HomePage homePage = new HomePage(driver);
                homePage.clickOnRecruitmentMenu();
                RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
                Assert.assertTrue(recruitmentPage.verifyCandidateLabel(),"Vacancy Label is present");
        }
        @AfterMethod
        public void tearDown()
        {
                driver.quit();
        }

}
