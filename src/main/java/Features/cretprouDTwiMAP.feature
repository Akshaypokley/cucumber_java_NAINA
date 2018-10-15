Feature: Create Proposal for NAINA Application Using Data table

  Scenario: Create new Proposl by User Using Data table

    Given User is already on login Window
    When  Title of login screen is NAINA
    #below line is parametarised
    Then  User Enter username And User enter password
      |Username|Password|
      |ARP3|Autodcr@123|
      |ARP3|Autodcr@123|
    And   User click on Signup Button
    And   User should have on home Screen
    Then  User Click on Type of work
      |Type_of_Work|
      |Building Permission|
    And   User Fill Genral and Applicant details
      |Case_Type|PermisssionType2|Location|City|Tahsil|Village|SurveyNo|OwnerCategory|OwnerName|Email|Mobile|PAN_Card|Address1|City2|State|PIN_Code|
      |New|Development in Urban Village|Other 201 villages|Raigad|Khalapur|Anjrun|12212|Joint|Akshay Pokley|Akshay@gmail.com|8983675455|CBXPP5367H|Plot 002|Ramtek|Nagpur|441106|
    And   User Save Genral and Applicant details
    Then  User Accept Alert Window
    Then  Close Test Browser

