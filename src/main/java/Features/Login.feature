Feature: NAINA Application Login Action

  Scenario: NAINA Appliction login Test
     #using hardcoded inputs
    Given User is already on  login page
    When  Title of login page NAINA
    Then  User Enter login name And User enter password
    And   User click on login page
    And   User is on Home page

  Scenario: NAINA Appliction login Test
  #Simpal Data Driven without Exampal
    Given User is already on  login page
    When  Title of login page NAINA
    Then  User Enters "ARP3" And User enters "Autodcr@123"
    And   User click on login page
    And   User is on Home page
