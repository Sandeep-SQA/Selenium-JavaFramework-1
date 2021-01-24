package com.Banking_Project.testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.Banking_Project.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() {
	
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered User Name");
				
		lp.setPassword(password); 
		logger.info("Entered Password");
				
		lp.clickSubmit();
		logger.info("clicked on login button");
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test SUPER PASSED passed");
			} 
		else {
			Assert.assertTrue(false);
			logger.info("Login test failed");
			}
	}

}
