package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	//Homepage
	
	@FindBy(xpath="//a[normalize-space()='Welcome Suma']")
	WebElement userName;

	@FindBy(xpath="//b[normalize-space()='Leave']")
	WebElement leave;
	
	@FindBy(xpath="//b[normalize-space()='My Info']")
	WebElement myInfo;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement myInfoEditBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyName() {
		return userName.isDisplayed();
		
	}
	
	public String verifyHomePage() {
		return driver.getTitle();
	}
	
	public MyInfoPage clicOnMyInfo() {
		 myInfo.click();
		 return new MyInfoPage();
	}
	public LeavePage clicOnLeave() {
		leave.click();
		return new LeavePage();
	}
	public TimePage clicOnTime() {
		leave.click();
		return new TimePage();
	}
	
	public void clickOnMyInfoEdit() {
		myInfo.click();
		myInfoEditBtn.click();
	}
}
