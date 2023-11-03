package com.parabank.tests;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;
import com.parabank.pages.LoginPage;
import com.parabank.pages.RegisterPage;
import com.parabank.testComponents.BaseTest;

public class RegistrationTest extends BaseTest {

	@Test
	@Parameters({ "fName", "lName", "street", "city", "state", "zip", "phone", "ssn", "uName", "password" })
	public void register(String fName, String lName, String street, String city, String state, String zip, String phone,
			String ssn, String uName, String password) {

		int int_random = ThreadLocalRandom.current().nextInt();
		
		LoginPage lp = new LoginPage(driver);
		RegisterPage rp = lp.goToRegister();
		HomePage hp = rp.registerPerson(fName, lName, street, city, state, zip, phone, ssn, uName+int_random, password);
		Assert.assertEquals(hp.returnMessage(), "Your account was created successfully. You are now logged in.");

	}

}
