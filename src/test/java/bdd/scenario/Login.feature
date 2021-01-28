
@tag
Feature: Login
  As a user I want to Login

  @tag1
  Scenario: User login
    Given I am on home page
    When I am loggining using my credentials
    Then I will redirect to home page
