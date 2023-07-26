
@tag
Feature: CustomerRegistration
  I want to use this template for my feature file

  @positive
  Scenario Outline: Add a new Customer 
    Given User is in Managers page
    Then User Clicks the New Customer button
    When User is in new Customer Entry Page
    Then User enters <Name>, <Gender>, <Address>, <City>, <State>, <PIN>, <MobileNumber>, <Email>, <Password>
    And User Clicks submit button
    Then User lands on Sucessful Customer Registration page
     
    Examples: 
      | Name  | Gender | Address  | City | State  | PIN  | MobileNumber | Email  | Password  |
      | Gino |     Male | aaaaa |  Nagercoil |   TamilNadu | 629163 	| 123456789 |     dbhph@hjs.com | Test9355 | 
      #| Vije |     Male | bbbbbb |  Nagercoil |   TamilNadu | 629163 	| 123498889 |     dssh@hjs.com | Test5362 | 
  @positive
  Scenario: Edit the Customer Phone number
    Given User is in Managers page
    Then User clicks on edit Customer buttton
    When User is in Edit Customer Page
    And User enters Customer id and click submit
    Then User edit the Phone number and Click submit button
    Then User get a Changes made sucessfully message
    
    @negative
  Scenario: Create a savings account without initial deposit
    Given User is in Managers page
    Then User clicks on new account buttton
    When User is in add new account page
    Then User enters customer id, account type and click submit button
    Then User get Please fill all fields message
    
    @positive
  Scenario: Create  account for a customer
    Given User is in Managers page
    Then User clicks on new account buttton
    When User is in add new account page
    Then User enters customer id, account type and initial amount and click submit button
    Then User get Account Generated Successfully!!! text
    
    
    @negative
  Scenario: Delete the customer without removing the Customer account
    Given User is in Managers page
    Then User clicks on Delete Customer buttton
    When User is in delete Customer page
    Then User Enters the customer id and clicks submit
    Then User gets an alert meassage on customer deletion confirmation
    Then User gets a alert message saying Customer could not be deleted!!. First delete all accounts of this customer then delete the customer
    
    
  