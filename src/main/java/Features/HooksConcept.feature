Feature: Create Proposal in NAINA Application

  @FIRST
  Scenario: Proposal creation Test

    Given User on Application home page
    Then  User Apply "<WorkType>"
    And   User Fill proposal details  "<Case_Type>","<PermisssionType2>","<Location>","<City>","<Tahsil>","<Village>","<SurveyNo>","<OwnerCategory>","<OwnerName>","<Email>","<Mobile>","<PAN_Card>","<Address1>","<City>","<State>","<PIN_Code>"
    And   User click on SaveB
    Then  Accept Alert by user
    And   Closed Browser

  @Second
  Scenario: Proposal creation Test

    Given User on Application home page
    Then  User Apply "<WorkType>"
    And   User Fill proposal details  "<Case_Type>","<PermisssionType2>","<Location>","<City>","<Tahsil>","<Village>","<SurveyNo>","<OwnerCategory>","<OwnerName>","<Email>","<Mobile>","<PAN_Card>","<Address1>","<City>","<State>","<PIN_Code>"
    And   User click on SaveB
    Then  Accept Alert by user
    And   Closed Browser