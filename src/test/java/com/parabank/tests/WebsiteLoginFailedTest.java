package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.parabank.pages.LoginPage;
import com.parabank.testComponents.BaseTest;

public class WebsiteLoginFailedTest extends BaseTest{

	@Test
	@Parameters({ "uName", "password" })
	public void loginFailed(String uName, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(uName, password);
		Assert.assertEquals(lp.returnErrorMessage(), "Please enter a username and password.");
	}
	
}
