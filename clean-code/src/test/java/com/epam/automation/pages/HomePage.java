package com.epam.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * This Class Initializes the Git Hub Home Page Elements
 */
public class HomePage {   

    @FindBy(xpath = "//button[@aria-label='Switch account context']/span")
    private WebElement linkLoggedInUser;

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public String getLoggedInUserName() {
        return linkLoggedInUser.getText();
    }

    public Integer hasUserLoggedIn(){
        if (linkLoggedInUser.getText() != ""){
            return 1;
        }
        else{
            return -1;
        }
    }

	public WebDriver getDriver() {
		return driver;
	}
}
