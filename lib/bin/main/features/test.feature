
@tag
Feature: CustomerRegistration
  I want to use this template for my feature file

  @positive
  Scenario: Add a new Customer 
    Given User is in Managers page
    Then User Clicks the New Customer button
    When User is in new Customer Entry Page
    Then  User enters all the Customer details
    And User Clicks submit button
    Then User lands on Sucessful Customer Registration page
    
    @positive
  Scenario: Edit the Customer Phone number
    Given User is in Managers page
    Then User clicks on edit Customer buttton
    When User is in Edit Customer Page
    And User enters Customer id and click submit
    When User is in Edit Customer Page
    Then User edit the Phone number and Click submit button
    Then User get a Changes made sucessfully message
    #
    #@negative
  #Scenario: Create a savings account without initial deposit
    #Given User is in Managers page
    #Then User clicks on new account buttton
    #When User is in add new account page
    #Then User enters customer id, account type and click submit button
    #Then User get Please fill all fields message
    #
    #@positive
  #Scenario: Create  account for a customer
    #Given User is in Managers page
    #Then User clicks on new account buttton
    #When User is in add new account page
    #Then User enters customer id, account type and initial amount and click submit button
    #Then User get Account Generated Successfully!!! text
    #
    #
    #@negative
  #Scenario: Delete the customer without removing the Customer account
    #Given User is in Managers page
    #Then User clicks on Delete Customer buttton
    #When User is in delete Customer page
    #Then User Enters the customer id and clicks submit
    #Then User an alert meassage on customer deletion confirmation
    #Then User Acepts the alert meassge
    #Then User gets a alert message saying Customer could not be deleted!!. First delete all accounts of this customer then delete the customer
    #
    #
    #@positive
  #Scenario: Delete the customer  account
    #Given User is in Managers page
    #Then User clicks on Delete account buttton
    #When User is in delete account page
    #Then User Enters the account number and clicks submit
    #Then User an alert meassage on account deletion confirmation
    #Then User Acepts the alert meassge
    #Then User gets a Account deleted Sucessfully message
    #
    #


  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
