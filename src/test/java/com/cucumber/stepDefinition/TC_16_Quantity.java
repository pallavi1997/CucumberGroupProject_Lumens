package com.cucumber.stepDefinition;

import com.cucumber.pages.AddProductPage;

import cucumber.api.java.en.When;

public class TC_16_Quantity {

	AddProductPage add;
	
	@When("^Click on Qty$")
	public void click_on_Qty() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   add = new AddProductPage();
		add.addQty();
	}
	
}
