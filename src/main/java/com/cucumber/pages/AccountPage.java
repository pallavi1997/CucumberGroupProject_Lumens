package com.cucumber.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.base.TestBase;

public class AccountPage extends TestBase {

	@FindBy(id="dwfrm_profile_customer_firstname")
	WebElement firstNameTxt;
	@FindBy(id="dwfrm_profile_customer_lastname")
	WebElement lastNameTxt;
	
	@FindBy(id="dwfrm_profile_customer_email")
	WebElement emailTxt;
	@FindBy(id="dwfrm_profile_customer_emailconfirm")
	WebElement confirmEmailTxt;
	
	@FindBy(id="dwfrm_profile_login_password")
	WebElement passwordTxt;
	@FindBy(id="dwfrm_profile_login_passwordconfirm")
	WebElement confirmPasswordTxt;
	
	@FindBy(xpath= "//button[@name='dwfrm_profile_confirm']")
	WebElement createAccountBtn;
	
	@FindBy(xpath="//div[@class='welcomemessage']")
	WebElement validateAccountMsg;
	
	public AccountPage()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public void accountDetails(String firstName, String lastName, String email, String confirmEmail, String password, String confirmPassword){
		
		firstNameTxt.sendKeys(firstName);
		lastNameTxt.sendKeys(lastName);
		
		emailTxt.sendKeys(email);
		confirmEmailTxt.sendKeys(confirmEmail);
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", passwordTxt);
		passwordTxt.sendKeys(password);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", confirmPasswordTxt);
		confirmPasswordTxt.sendKeys(confirmPassword);
	}
	
	public void clickCreateAccount() {
		Actions action = new Actions(driver);
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", createAccountBtn);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(createAccountBtn));
		
		action.moveToElement(createAccountBtn).click().perform();
		//action.doubleClick(createAccountBtn).perform();
		//createAccountBtn.click();
		
	}
	
	public void validateAccountCreation() {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(createAccountBtn));
		
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", createAccountBtn);
//		createAccountBtn.click();
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", createAccountBtn);
		
		wait.until(ExpectedConditions.visibilityOf(validateAccountMsg));

		
		String actualMsg = validateAccountMsg.getText();
		
		System.out.println(actualMsg);
	}
}
