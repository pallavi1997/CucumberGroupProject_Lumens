package com.cucumber.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//div[@id='ltkpopup-close-button']")
	WebElement popUpCross;
	
	@FindBy(xpath ="//span[@class='text']")
	WebElement accountLnk;
	
	@FindBy(id="my_account_hdr_link")
	WebElement myAccountLnk;
	
	@FindBy(xpath="//a[@class='userlogin']")
	WebElement signinLnk;
	
	@FindBy(xpath="//a[@class='logout']")
	WebElement logoutLnk;
	
	public HomePage()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}

	public void clickCross() {
		popUpCross.click();
	}
	
	public void clickAccount() {
		accountLnk.click();
		myAccountLnk.click();
	}
	
	public void clickLogin() {
		accountLnk.click();
		signinLnk.click();
	}
	
	public void clickLogout() {
		accountLnk.click();
		logoutLnk.click();
	}
	
}
