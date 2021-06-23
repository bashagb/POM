package com.crm.qa.testcases;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MyInfoPage;
import com.crm.qa.util.TestUtil;

public class MyInfoPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	MyInfoPage myInfo;
	TestUtil testUtil;
	String sheetName= "data";
	public MyInfoPageTest() {
		super();
	
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage= new LoginPage();
		homePage=new HomePage();
		myInfo=new MyInfoPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clicOnMyInfo();
	}
	
	@Test(priority=1)
	public void verifyPersonalDetails() {
		boolean personalLable=myInfo.validatePersonalDetails();
		Assert.assertTrue(personalLable);
	}
	
	@Test(priority=2)
	public void verifyCheckBox() {
		myInfo.clickOnCheckBox();
			}
	
	
	//Excel dataprovider
	@DataProvider
	public Object[][] getHRMTestData() throws InvalidFormatException {
		
		Object data[][]=testUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider="getHRMTestData")
	public void validateEditBtn(String fname, String mname, String lname) {
		homePage.clickOnMyInfoEdit();
		myInfo.updateMyInfoEditBtn(fname,mname,lname);
	}
	@AfterMethod 
	public void tearDown(){
		driver.quit();
	}
	
}
