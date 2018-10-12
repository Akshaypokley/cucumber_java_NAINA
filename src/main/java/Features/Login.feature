Feature: NAINA Application Login Action

  Scenario: NAINA Appliction login Test
  #using hardcoded inputs
    #Given User is already on  login page
    #When  Title of login page NAINA
    #Then  User Enter login name And User enter password
    #And   User click on login page
    #And   User is on Home page

  Scenario: NAINA Appliction login Test
  #Simpal Data Driven without Exampal
    #Given User is already on  login page
    #When  Title of login page NAINA
    #Then  User Enters "ARP3" And User enters "Autodcr@123"
    #And   User click on login page
    #And   User is on Home page

    # What is differens between Scenario and Scenario outline
# Inacse of data driven with example we used Scenario outline

# Inacse of data driven without example we used Scenario simpale

  Scenario Outline: NAINA Appliction login Test
#Simpal Data Driven With Outline Keyword
    Given User is already on  login page
    When  Title of login page NAINA
    #below line is parametarised
    Then  User Enters "<Username>" And User enters "<Password>"
    And   User click on login page
    And   User is on Home page
    And   Close Browser
  Examples:
  |Username|Password   |
  |ARP3    |Autodcr@123|
  |ToM     | test1234  |