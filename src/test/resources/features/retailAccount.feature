@regrassion
Feature: Retail Account Page

  Background: 
    Given User is on retail website home page
    And User click on sign in link button
    Given User enter email 'azimilaw420@gmail.com' and password 'Habib123@'
    And User click on login button
    Then User should be logged in into account

  @updatePI
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'firstName' and Phone 'PhoneValue'
    And User click on Update button
    Then user profile information should be updated

  @addPaymentMethod
  Scenario: Verify User can add a payment method
    When User click on Account options
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber | nameOnCard    | expirationMonth | expirationYear | securityCode |
      | card       | fullnameValue |              10 |           2024 |          254 |
    And User click on Add your card button
    Then a message should be displayed 'Payment Method added sucessfully'

  @changeCard
  Scenario: Verify User can edit Debit or Credit card
    When User click on Account option
    And User click on Edit option of card section
    And User click on Edit button of card section
    And User edit information with below data
      | cardNumber | nameOnCard    | expirationMonth | expirationYear | securityCode |
      | card       | fullnameValue |              11 |           2027 |          166 |
    And User click on Update Your card button
    Then a message should be displayed 'Payment Method updated Successfully'

  @removePayment
  Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And User click on Card option
    And User click on remove option of card section
    Then payment details should be removed

  @addAddress1
  Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill new address form with below information
      | country      | fullName      | phoneNumber | streetAddress | apt      | city      | state      | zipCode      |
      | countryValue | fullnameValue | PhoneValue  | stAddress     | aptValue | cityValue | stateValue | zipCodeValue |
    And User click Add Your Address button
    Then a message should be displayed 'Address Added Successfully'

  @addressEdit
  Scenario: Verify User can edit an Address added on account
    When User click on Account option
    And User click on edit address option
    And user fill new address form with below informations
      | country       | fullName   | phoneNumber | streetAddress    | apt | city       | state | zipCode |
      | United States | fullnameValue |  PhoneValue |stAddress| aptValue| cityValue |stateValue| zipCodeValue |
    And User click update Your Address button
    Then a message should be displayed ‘Address Updated Successfully’

  @removeAddress
  Scenario: Verify User can remove Address from Account
    When User click on Account option
    And User click on remove option of Address section
    Then Address details should be removed
