package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory 
	
	@FindBy(xpath="//input[@id='txtUsername']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[normalize-space()='Forgot your password?']")
	WebElement forgotPassBtn;
	
	@FindBy(xpath="//div[@id='divLogo']//img")
	WebElement crmLogo;
	
	//constructor
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//actions
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCrmLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String uname, String pass) {
		
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginBtn.click();
		
		return new HomePage();
	}
}
