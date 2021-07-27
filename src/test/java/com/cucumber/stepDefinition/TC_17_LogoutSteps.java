package com.cucumber.stepDefinition;

import java.util.List;
import java.util.Map;

import com.cucumber.base.TestBase;
import com.cucumber.data.ReadExcelFile;
import com.cucumber.pages.HomePage;
import com.cucumber.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class TC_17_LogoutSteps {
	
	HomePage home;
	TestBase base;

	
	@When("^Click on Logout$")
	public void click_on_Logout() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    home = new HomePage();
//	    home.clickLogout();
		
		base = new TestBase();
		base.closeBrowser();
	}

}
