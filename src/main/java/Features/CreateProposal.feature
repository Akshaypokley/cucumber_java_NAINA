Feature: Create Proposal for NAINA Application

  Scenario Outline: Create new Proposl by User

    Given User is already on  login page
    When  Title of login page NAINA
    #below line is parametarised
    Then  User Enters "<Username>" And User enters "<Password>"
    And   User click on login page
    And   User is on Home page
    Then  User Apply for "<PermissionType>"
    And   User Fill "<Case_Type>","<PermisssionType2>","<Location>","<City>","<Tahsil>","<Village>","<SurveyNo>","<OwnerCategory>","<OwnerName>","<Email>","<Mobile>","<PAN_Card>","<Address1>","<City>","<State>","<PIN_Code>"
    And   User click on save Button
    Then  User Accept Alert
    And   Close Browser

  Examples:
  |Username|Password   |PermissionType|Case_Type|PermisssionType2|Location|City|Tahsil|Village|SurveyNo|OwnerCategory|OwnerName|Email|Mobile|PAN_Card|Address1|City|State|PIN_Code|
  |ARP3    |Autodcr@123|Building Permission|New|Development in Urban Village|Other 201 villages|Raigad|Khalapur|Anjrun|12212|Joint|Akshay Pokley|Akshay@gmail.com|8983675455|CBXPP5367H|Plot 002|Ramtek|Nagpur|441106|
  |ARP3    |Autodcr@123|Building Permission|New|Town Planning Scheme (TPS)|IDP 23 villages|Raigad|Khalapur|Anjrun|12212|Individual|Rahjesh|Rajesh@gmail.com|8983675455|CBXPP5367H|Plot 002|Ramtek|Nagpur|441106|
  |ARP3    |Autodcr@123|Building Permission|New|General Development in IDP (23 Villages)|Other 201 villages|Raigad|Khalapur|Anjrun|12212|Power of Attorney (POA)|Sneha|Sneha@gmail.com|8983675455|CBXPP5367H|Plot 002|Ramtek|Nagpur|441106|
  |ARP3    |Autodcr@123|Building Permission|New|Core Gaonthan|IDP 23 villages|Raigad|Khalapur|Anjrun|12212|Company|Akshay|Akshay@gmail.com|8983675455|CBXPP5367H|Plot 002|Ramtek|Nagpur|441106|
