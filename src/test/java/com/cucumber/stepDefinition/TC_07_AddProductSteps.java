package com.cucumber.stepDefinition;

import com.cucumber.pages.AddProductPage;

import cucumber.api.java.en.When;

public class TC_07_AddProductSteps {

	AddProductPage add;
	
	@When("^Navigate to Bulbs$")
	public void navigate_to_Bulbs() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    add = new AddProductPage();
	    add.selectProduct();
	}

	@When("^Click on Add to cart button$")
	public void click_on_Add_to_cart_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 add = new AddProductPage();
		 add.addProduct();
	}

	@When("^Click on View cart$")
	public void click_on_View_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 add = new AddProductPage();
		 add.viewCart();
	}

	
}
