package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	private WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name*='firstName']")
	private WebElement firstName;

	@FindBy(css = "input[name*='lastName']")
	private WebElement lastName;

	@FindBy(css = "input[name*='street']")
	private WebElement street;

	@FindBy(css = "input[name*='city']")
	private WebElement city;

	@FindBy(css = "input[name*='state']")
	private WebElement state;

	@FindBy(css = "input[name*='zip']")
	private WebElement zip;

	@FindBy(css = "input[name*='phone']")
	private WebElement phone;

	@FindBy(css = "input[name*='ssn']")
	private WebElement ssn;

	@FindBy(css = "td input[name*='username']")
	private WebElement username;

	@FindBy(css = "td input[name*='password']")
	private WebElement password;

	@FindBy(css = "td input[name*='repeatedPassword']")
	private WebElement repeatedPassword;

	@FindBy(css = "td input.button")
	private WebElement registerBttn;

	public HomePage registerPerson(String fName, String lName, String streetName, String cityName, String stateName,
			String zipCode, String ph, String socialSec, String uName, String pwd) {

		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		street.sendKeys(streetName);
		city.sendKeys(cityName);
		state.sendKeys(stateName);
		zip.sendKeys(zipCode);
		phone.sendKeys(ph);
		ssn.sendKeys(socialSec);
		username.sendKeys(uName);
		password.sendKeys(pwd);
		repeatedPassword.sendKeys(pwd);
		registerBttn.click();
		return new HomePage(driver);

	}
}
