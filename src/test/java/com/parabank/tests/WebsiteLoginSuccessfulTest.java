package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.parabank.pages.LoginPage;
import com.parabank.testComponents.BaseTest;

public class WebsiteLoginSuccessfulTest extends BaseTest {

	@Test
	@Parameters({ "uName", "password" })
	public void loginSuccessful(String uName, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(uName, password);
		Assert.assertEquals(lp.returnTitle(), "Accounts Overview","Cannot login into the account");
	}

}
