package com.epam.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.automation.model.Constants;

/**
 * This Class invokes the GIT HUB Landing Page   
 */
public class StartPage {

    @FindBy(xpath = "//a[text()='Sign in']")
    private WebElement signInButton;   
    private WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openGitHubURL() {
        driver.get(Constants.GITHUB_BASE_URL);
    }

    public SignInPage invokeSignIn() {
    	signInButton.click();
        return new SignInPage(driver);
    }
}
