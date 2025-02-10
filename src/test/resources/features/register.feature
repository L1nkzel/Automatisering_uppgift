Feature: Register a new user
Background:
  Given I'm on the registration form page "https://membership.basketballengland.co.uk/NewSupporterAccount"

  Scenario: Register a new user
    Given I fill all the required fields on the registration form
    When I click the register button
    Then I should be redirected to the success page

  Scenario: Register a new user with lastname missing
    Given I fill all the required fields except lastname
    When I click the register button
    Then Error message appears for the missing field lastname

  Scenario: Register a new user with mismatched passwords
    Given I fill all the required fields with mismatched passwords
    When I click the register button
    Then Error message appears for the password mismatch

    Scenario: Register a new user with terms and conditions not checked
      Given I fill all the required fields except terms and conditions
      When I click the register button
      Then I get this error message "You must confirm that you have read and accepted our Terms and Conditions"
