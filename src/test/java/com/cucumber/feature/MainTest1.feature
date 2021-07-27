
Feature: Cucumber Framework 
  
  @Tag1
  Scenario: Launch 
    Given Launch chrome browser
    When Launch website with valid url
    Then validate user landed in homepage

@Tag2
 Scenario Outline: TC_01 Account Creation 
    Given User Should be in Homepage
    When Navigate to Accounts page
    And Enter valid details given in sheetname "<SheetName>" and rownumber <RowNumber>
    And Click on Create Account
    Then validate the page
    
    Examples:
|SheetName|RowNumber|
|AccountData|0|

@Tag3
 Scenario Outline: TC_02 Login 
    Given User Should be in Homepage
    When Navigate to Login page
    And Enter valid login details given in sheetname "<SheetName>" and rownumber <RowNumber>
    And Click on Login
    Then validate that page
Examples:
|SheetName|RowNumber|
|LoginData|0|

@Tag4
 Scenario: TC_07 Add Product 
    Given User Should be in Homepage
    When Navigate to Bulbs
    And Click on Add to cart button
    And Click on View cart
    Then validate that page
    
    
    @Tag5
 Scenario Outline: TC_10 Live Chat 
    Given User Should be in Homepage
    When Navigate to Live Chat
    And Enter details from sheetname "<SheetName>" and rownumber <RowNumber> and click submit
    Then validate that error message
Examples:
|SheetName|RowNumber|
|LiveChatData|0| 
 
    
    @Tag6
 Scenario: TC_16 Increase Quantity 
    Given User Should be in Homepage
    When Navigate to Bulbs
    And Click on Qty
    And Click on Add to cart button
    And Click on View cart
    Then validate that page

  @Tag7
  Scenario: TC_17 Logout 
   Given User Should be in Homepage
    When Click on Logout

