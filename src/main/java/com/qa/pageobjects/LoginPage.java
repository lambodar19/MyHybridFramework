package com.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement login;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public void enterUsername(String usernameText)
    {
        username.sendKeys(usernameText);
    }

    public void enterPassword(String passwordText)
    {
        password.sendKeys(passwordText);
    }

    public HomePage clickOnLogin()
    {
        login.click();
        return new HomePage(driver);
    }





}
