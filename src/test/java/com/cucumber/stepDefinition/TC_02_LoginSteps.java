package com.cucumber.stepDefinition;

import java.util.List;
import java.util.Map;

import com.cucumber.base.TestBase;
import com.cucumber.data.ReadExcelFile;
import com.cucumber.pages.HomePage;
import com.cucumber.pages.LoginPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC_02_LoginSteps {
	
	TestBase base;
	HomePage home;
	LoginPage login;
	
	@When("^Navigate to Login page$")
	public void navigate_to_Login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   home= new HomePage();
	   home.clickLogin();
	}

	@When("^Enter valid login details given in sheetname \"([^\"]*)\" and rownumber (\\d+)$")
	public void enter_valid_login_details_given_in_sheetname_and_rownumber(String sheetName, int rowNumber) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		ReadExcelFile reader = new ReadExcelFile();
		List<Map<String,String>> testData = 
				reader.getData("C:\\Users\\vitha\\eclipse-workspace-1\\Cucumber_Group_Assessment\\ExcelData\\ExcelData.xlsx", sheetName);
		
		String email = testData.get(rowNumber).get("Username");
		
		String password = testData.get(rowNumber).get("Password");
		
		login = new LoginPage();
		login.validLogin(email, password);
	}

	@When("^Click on Login$")
	public void click_on_Login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		login = new LoginPage();
		login.clickLogin();
	}

	@Then("^validate that page$")
	public void validate_that_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   base = new TestBase();
	   base.getTitle();
	}

}
