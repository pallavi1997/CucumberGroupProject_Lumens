package com.cucumber.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(id="dwfrm_login_username")
	WebElement emailTxt;
	
	@FindBy(id="dwfrm_login_password")
	WebElement passwordTxt;
	
	@FindBy(id="dwfrm_login_rememberme")
	WebElement remeberMeBox;
	
	
	@FindBy(name="dwfrm_login_login")
	WebElement loginBtn;
	
	public LoginPage()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public void validLogin(String email, String password) {
		emailTxt.sendKeys(email);
		passwordTxt.sendKeys(password);
		
		//remeberMeBox.click();
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	

}
