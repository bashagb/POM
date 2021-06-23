package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MyInfoPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	MyInfoPage myInfo;
	
	public HomePageTest() {
		super();
	}
	

	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage= new LoginPage();
		myInfo=new MyInfoPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		String homePageTitle=homePage.verifyHomePage();
		Assert.assertEquals(homePageTitle, "OrangeHRM", "HomePage title not matched");
	}
	
	@Test(priority=2)
	public void verifyCorrectUserName() {
		Assert.assertTrue(homePage.verifyName());
	}
	
	@Test(priority=3)
	public void verifyMyInfoPage() {
		myInfo = homePage.clicOnMyInfo();
	}
	@AfterMethod 
	public void tearDown(){
		driver.quit();
	}

}
