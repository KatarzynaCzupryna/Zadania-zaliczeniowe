@shopping
Feature: Buying items at https://mystore-testlab.coderslab.pl/index.php

  Scenario: Purchase of Sweater
    Given I'm on the MyStore
    When I login my email "k.cholerka@test.pl" and password "hasłoPassword"
    Then I click on "clothes" category
    And I choice "Hummingbird Printed Sweater"
    Then I choice size and number of items
    And I add the product to cart
    Then I go to option "Proceed to checkout" and I click "Proceed to Checkout" button
    Then I confirm address
    Then I choice shopping method "Self pick up"
    And I choice payment option "Pay by check"
    Then I click on "Place order" button
    And I'm doing screenshot with order confirmation
    Then I quit
