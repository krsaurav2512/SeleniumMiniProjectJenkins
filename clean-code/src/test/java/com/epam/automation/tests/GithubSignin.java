package com.epam.automation.tests;

import com.epam.automation.model.Constants;
import com.epam.automation.pages.HomePage;
import com.epam.automation.pages.SignInPage;
import com.epam.automation.pages.StartPage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Validating the User Sign-In on GIT-HUB
 */
public class GithubSignin{

    WebDriver driver;
    
    @Before
    public void initialiseWebdriverInstance(){    
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testOneCanLoginGithub(){
        StartPage startPage = new StartPage(driver);
        startPage.openGitHubURL();
        SignInPage signInPage = startPage.invokeSignIn();
        HomePage homePage = signInPage.signInGitHub(Constants.USERNAME, Constants.PASSWORD);
        String loggedInUserName = homePage.getLoggedInUserName();
        Assert.assertEquals(Constants.USERNAME, loggedInUserName);
    }
    
    @After
    public void quitWebdriverInstance(){  
        driver.quit();
    }
}
