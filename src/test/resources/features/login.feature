@regrassion
Feature: Login

  Background: 
    Given User is on retail website home page
    And User click on sign in link button

  @login
  Scenario: Verify user is able to sign in to retail website
    Given User enter email 'azimilaw420@gmail.com' and password 'Habib123@'
    And User click on login button
    Then User should be logged in into account

  @register
  Scenario: Verify user is able to create account in retail website
    Given User click on create new account button
    And User fill the signUp information with below data
      | name  | email                 | password  | confirmPassword |
      | firstName | email| Habib123@ | Habib123@       |
    And User click on SignUP button
    Then User account should be created into retail page