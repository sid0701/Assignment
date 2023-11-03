package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[name='username']")
	private WebElement username;
	
	@FindBy(css="input[name='password']")
	private WebElement password;
	
	@FindBy(css="input.button")
	private WebElement loginBttn;
	
	@FindBy(css="a[href*='register']")
	private WebElement registerLink;
	
	@FindBy(css="p.error")
	private WebElement errorMsg;
	
	@FindBy(css="h1.title")
	private WebElement title;
	
	public void loginToApp(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBttn.click();
	}
	
	public RegisterPage goToRegister() {
		registerLink.click();
		return new RegisterPage(driver);
	}
	
	public String returnErrorMessage() {
		return errorMsg.getText();
	}
	
	public String returnTitle() {
		return title.getText();
	}

}
