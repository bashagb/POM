package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class MyInfoPage extends TestBase{
	
	@FindBy(xpath="//h1[normalize-space()='Personal Details']")
	WebElement personalDetails;
	
	@FindBy(xpath="//input[@id='attachmentsCheckAll']")
	WebElement checkBox;
	
	//Editbtn update details
	
	@FindBy(xpath="//input[@id='personal_txtEmpFirstName']")
	WebElement editFname;
	
	@FindBy(xpath="//input[@id='personal_txtEmpMiddleName']")
	WebElement editMname;
	
	@FindBy(xpath="//input[@id='personal_txtEmpLastName']")
	WebElement editLname;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement saveBtn;
	
	
	//constructor
	public MyInfoPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validatePersonalDetails() {
		return personalDetails.isDisplayed();
	}
	
	public void clickOnCheckBox() {
		checkBox.click();
		
	}
	
	public void updateMyInfoEditBtn(String fname, String mname, String lname) {
		editFname.clear();
		editFname.sendKeys(fname);
		editMname.clear();
		editMname.sendKeys(mname);
		editLname.clear();
		editLname.sendKeys(lname);
		saveBtn.click();
	}

}
