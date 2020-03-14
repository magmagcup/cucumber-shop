Feature: Buy products
    As a customer
    I want to buy products

Background:
    Given a product Bread price 20.50 exists with amount of 4
    And a product Jam price 80.00 exists with amount of 3

Scenario: Buy one product
    When I buy Bread with quantity 2
    Then total should be 41.00

Scenario: Buy multiple products
    When I buy Bread with quantity 2
    And I buy Jam with quantity 1
    Then total should be 121.00

Scenario: Buy products exceed it amount
    When I buy Bread with quantity 10
    And I buy Jam with quantity 8
    But There aren't enough item in stock
