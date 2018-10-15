
#Functional Test
Feature: NNINA Application Testing

  @SmokeTest @RegressionTest
  Scenario: Login with correct username and password
    Given This is a vaild login test
  @RegressionTest
  Scenario: Login with In-correct username and password
    Given This is a In-vaild login test
  @SmokeTest
  Scenario: Create the proposal
    Given This is a create proposal test
  @SmokeTest @RegressionTest
  Scenario: Find the proposal in list
    Given This is a find proposal test
  @EndToEndTest
  Scenario: Verify left panel link
    Given Click on left panel link
  @SmokeTest
  Scenario: Find out the Approved Proposal
    Given This a Find out the Approved Proposal Test
  @SmokeTest
  Scenario: Validated a Report
    Given This a report test
  @EndToEndTest
  Scenario: Application Logout
    Given This a logout Test