package com.cucumber.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cucumber.base.TestBase;

public class LiveChatPage extends TestBase{
	
	@FindBy(id="LP_DIV_1374273120044")
	WebElement liveChatLnk;
	
	@FindBy(id="txt_4616424")
	WebElement nameTxt;
	
	@FindBy(id="txt_4616425")
	WebElement emailTxt;
	
	@FindBy(xpath="//button[@class='lp_submit_button lpc_survey-area__submit-button lpc_desktop']")
	WebElement submitBtn;
	
	@FindBy(id="err_4616425")
	WebElement errMsg;
	
	
	public LiveChatPage() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}

	public void clickLiveChat() {
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOf(liveChatLnk));
		
		liveChatLnk.click();
	}
	
	public void liveChatDetails(String name, String email) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(nameTxt));
		
		nameTxt.sendKeys(name);
		emailTxt.sendKeys(email);
		
		submitBtn.click();
	}
	
	public void validateChat() {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(errMsg));
		
		String actualErrMsg = errMsg.getText();
		//System.out.println(actualErrMsg);
		
		Assert.assertEquals(actualErrMsg, "Enter a valid email address. Format: you@domain.com");
	}
}
