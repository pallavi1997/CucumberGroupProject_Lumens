package com.cucumber.stepDefinition;


import java.util.List;
import java.util.Map;

import com.cucumber.base.TestBase;
import com.cucumber.data.ReadExcelFile;
import com.cucumber.pages.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MainTestSteps {
	
	TestBase base;
	HomePage home;
	
	@Given("^Launch chrome browser$")
	public void launch_chrome_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		base = new TestBase();
	    base.launchBrowser();
	}

	@When("^Launch website with valid url$")
	public void launch_website_with_valid_url() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		base = new TestBase();
		base.launchURL();
		
		 home = new HomePage();
		 home.clickCross();
	}

	@Then("^validate user landed in homepage$")
	public void validate_user_landed_in_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//		base = new TestBase();
//		base.closeBrowser();
	}
	
	
	
	
//	
//	TestBase base;
//	HomePage home;
//	
//	@Given("^Launch chrome browser$")
//	public void launch_chrome_browser() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		base = new TestBase();
//		   base.launchBrowser();
//	}
//
//	// when condition with reading excel data
//	@When("^Launch website with valid url in sheetname \"([^\"]*)\" and rownumber (\\d+)$")
//	public void launch_website_with_valid_url_given_in_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		
//		//Getting data from Excel Sample code.... For understanding purpose
//		// Starting 
//		ReadExcelFile reader = new ReadExcelFile();
//		List<Map<String,String>> testData = 
//				reader.getData("C:\\Users\\vitha\\eclipse-workspace-1\\Cucumber_Group_Assessment\\ExcelData\\ExcelData.xlsx", sheetName);
//		String username = testData.get(rowNumber).get("Username");
//		String password = testData.get(rowNumber).get("Password");
//		
//		System.out.println(rowNumber);
//		System.out.println("Details are ");
//		System.out.println("username "+username);
//		System.out.println("Password "+password);
//		
//		// ending 
//		base = new TestBase();
//		   base.launchURL();
//		   
//		   home = new HomePage();
//		   home.clickCross();
//	}
//
//	@Then("^validate user landed in homepage$")
//	public void validate_user_landed_in_homepage() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		base = new TestBase();
////		   base.getTitle();
//		   base.closeBrowser();
//	}
//
}
