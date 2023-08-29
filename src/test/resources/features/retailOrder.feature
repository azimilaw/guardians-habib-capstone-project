@regrassion
Feature: Retail Order Page

  Background: 
    Given User is on retail website home page
    And User click on sign in link button
    Given User enter email 'azimilaw420@gmail.com' and password 'Habib123@'
    And User click on login button
    Then User should be logged in into account

  @addItemToCart
  Scenario: Verify User can add an item to cart
    And User change the category to 'Smart Home'
    And User search for an item 'kasa outdoor smart plug'
    And User click on Search icon
    And User click on item
    And User select quantity '2'
    And User click add to Cart button
    Then the cart icon quantity should change to '2'

  #------------------------------------------------------
  @addItemToCartAndCheckout
  Scenario: Verify User can place an order with Shipping address and payment Method on file
    And User change the category to 'Electronics' Apex Legends
    And User search for an item 'Apex Legends' Apex Legends
    And User click on Search icon
    And User click on item Apex Legends
    And User select quantity '5' for Apex Legends
    And User click add to Cart button
    Then the cart icon quantity should change to '5' Apex Legends
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User click on Place Your Order
    Then a message should be displayed 'Order Placed Successfully'

  #------------------------------------------------------
  @cancelOrder
  Scenario: Verify User can cancel the order
    And User click on Order sections
    And User click on first order in lists
    And User click on Cancel The Order button
    And User select the cancelation Reason 'Bought wrong item'
    And User click on Cancel Order button
    Then an order of cancelation message should be displayed 'Your Order Has Been Cancelled'

  #------------------------------------------------------
  @returnOrder
  Scenario: Verify User can Return the order
    And User click on Orders section
    And User click on first order in list
    And User click on Return Items button
    And User select the Return Reason 'Item damaged'
    And User select the drop off service 'FedEx'
    And User click on Return Order button
    Then a cancelation message should be displayed 'Return was successfull'

  @writeReview
  Scenario: Verify User can write a review on order placed
    Given User click on Order sections
    And User click on first order in return list
    And User click on Review button
    And User write Review headline 'Product' and 'This Product is beoutiful'
    And User click Add your Review button
    Then a review message should be displayed 'Your review was added successfully'
