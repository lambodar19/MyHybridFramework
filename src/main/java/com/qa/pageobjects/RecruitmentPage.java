package com.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {

    WebDriver driver;

    @FindBy(xpath = "//a[text()='Candidates']")
    private WebElement candidatesLabel;
    public RecruitmentPage(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verifyCandidateLabel()
    {
        boolean flag = candidatesLabel.isDisplayed();
        return flag;

    }
}
