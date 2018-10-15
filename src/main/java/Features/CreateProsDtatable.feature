Feature: Create Proposal for NAINA Application Using Data table

  Scenario: Create new Proposl by User Using Data table

    Given User is already on login Screen
    When  Title of login page  is NAINA
    #below line is parametarised
    Then  User Enters username And User enters password
    |ARP3|Autodcr@123|
    And   User click on login Button
    And   User should have on home page
    Then  User Apply for Type of work
    |Building Permission|
    And   User Fill Genral details and Applicant details
    |New|Development in Urban Village|Other 201 villages|Raigad|Khalapur|Anjrun|12212|Joint|Akshay Pokley|Akshay@gmail.com|8983675455|CBXPP5367H|Plot 002|Ramtek|Nagpur|441106|
    And   User click on Submit Button
    Then  User Accept Alert message
    And   Close The Browser

