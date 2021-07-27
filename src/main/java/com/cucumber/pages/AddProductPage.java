package com.cucumber.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.base.TestBase;

public class AddProductPage extends TestBase {
	
	
	@FindBy(xpath="//span[@title='Lighting']")
	WebElement lightingLnk;
	
	@FindBy(xpath="//img[@alt='Light Bulbs']")
	WebElement lightBulbLnk;
	
	@FindBy(xpath="//img[@alt='Light Bulbs Incandescent']")
	WebElement bulbLnk;
	
	@FindBy(xpath="//a[@title='Click to Refine By Bulbrite']")
	WebElement checkBulb;
	
	@FindBy(xpath="//*[@id=\"bcMDoiaaiTC1caaadrxikBi2rG\"]/div[1]/div[1]/a")
	WebElement wattBulbLnk;
	
	@FindBy(xpath="//button[@id='add-to-cart']")
	WebElement addBtn;
	
	@FindBy(xpath="//button[@class='close mt-n3 mr-n2']")
	WebElement closePopUp;
	
	@FindBy(xpath="//a[@id='mcBookMark']")
	WebElement viewBtn;
	
	@FindBy(id="Quantity")
	WebElement quantityTxt;
	
	public AddProductPage()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public void selectProduct() throws InterruptedException {
		lightingLnk.click();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", lightBulbLnk);
		lightBulbLnk.click();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", bulbLnk);
		bulbLnk.click();
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", checkBulb);
		checkBulb.click();
		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(wattBulbLnk));
		
		action.moveToElement(wattBulbLnk).perform();
		Thread.sleep(3000);
		wattBulbLnk.click();
	
	}
	
	public void addProduct() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(addBtn));
		addBtn.click();
		
		closePopUp.click();
	}
	
	public void addQty() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(quantityTxt));
		quantityTxt.clear();
		quantityTxt.sendKeys("3");
	}
	
	public void viewCart() {
		viewBtn.click();
	}

}
