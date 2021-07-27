package com.cucumber.stepDefinition;

import java.util.List;
import java.util.Map;

import com.cucumber.base.TestBase;
import com.cucumber.data.ReadExcelFile;
import com.cucumber.pages.AccountPage;
import com.cucumber.pages.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC_01_AccountSteps {
	
	TestBase base;
	HomePage home;
	AccountPage account;
	
	
	@Given("^User Should be in Homepage$")
	public void user_Should_be_in_Homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    base = new TestBase();
	    base.launchBrowser();
	    base.launchURL();
	    
	    home = new HomePage();
	    home.clickCross();
	}

	@When("^Navigate to Accounts page$")
	public void navigate_to_Accounts_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		home = new HomePage();
		home.clickAccount();
	}

	@When("^Enter valid details given in sheetname \"([^\"]*)\" and rownumber (\\d+)$")
	public void enter_valid_details_given_in_sheetname_and_rownumber(String sheetName, int rowNumber) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ReadExcelFile reader = new ReadExcelFile();
		List<Map<String,String>> testData = 
				reader.getData("C:\\Users\\vitha\\eclipse-workspace-1\\Cucumber_Group_Assessment\\ExcelData\\ExcelData.xlsx", sheetName);
		String firstname = testData.get(rowNumber).get("FirstName");
		String lastname = testData.get(rowNumber).get("LastName");
		
		String email = testData.get(rowNumber).get("Email");
		String confirmEmail = testData.get(rowNumber).get("Confirm Email");
		
		String password = testData.get(rowNumber).get("Password");
		String confirmPassword = testData.get(rowNumber).get("Confirm Password");
		
		//System.out.println(rowNumber);
//		System.out.println("Details are ");
//		System.out.println("username "+username);
//		System.out.println("Password "+password);
		
		account = new AccountPage();
		account.accountDetails(firstname, lastname, email, confirmEmail, password, confirmPassword);
		
	}

	@When("^Click on Create Account$")
	public void click_on_Create_Account() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		account = new AccountPage();
		account.clickCreateAccount();
	}

	@Then("^validate the page$")
	public void validate_the_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		base = new TestBase();
		base.getTitle();
	}


}
