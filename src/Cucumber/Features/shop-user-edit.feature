@shop
Feature: Change user information after login

  Scenario Outline: Create user new address
    Given I'm on the shop authentication page
    When I login using email "k.cholerka@test.pl" and password "hasłoPassword"
    And I go to "Your addresses" page
    Then I click "Create new address" button
   When I enter new data alias <alias> Address <Address> City <City> PostalCode <PostalCode> Country <Country> Phone <Phone>
    Then I can click "Save" button
    And I can see new address.
    Then I delete new address
    And I can see that address is deleted
    Then I close the browser

        Examples:
      | alias          | Address   | City   | PostalCode | Country        | Phone     |
      | KrakenCholera | Zielistki | Rybnik | 00-007     | United Kingdom | 123456789 |




