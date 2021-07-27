package com.cucumber.stepDefinition;

import java.util.List;
import java.util.Map;

import com.cucumber.data.ReadExcelFile;
import com.cucumber.pages.LiveChatPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC_10_LiveChat {

	LiveChatPage live;
	
	@When("^Navigate to Live Chat$")
	public void navigate_to_Live_Chat() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    live = new LiveChatPage();
	    live.clickLiveChat();
	}

	@When("^Enter details from sheetname \"([^\"]*)\" and rownumber (\\d+) and click submit$")
	public void enter_details_from_sheetname_and_rownumber_and_click_submit(String sheetName, int rowNumber) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ReadExcelFile reader = new ReadExcelFile();
		List<Map<String,String>> testData = 
				reader.getData("C:\\Users\\vitha\\eclipse-workspace-1\\Cucumber_Group_Assessment\\ExcelData\\ExcelData.xlsx", sheetName);
		
		String name = testData.get(rowNumber).get("Name");
		
		String email = testData.get(rowNumber).get("Email");
		
		 live = new LiveChatPage();
		    live.liveChatDetails(name, email);
		
	}

	@Then("^validate that error message$")
	public void validate_that_error_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		 live = new LiveChatPage();
		 live.validateChat();
	}
}
