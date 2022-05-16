Feature: Add To Chart Without Login Feature
Scenario: Scenario1: Add To Chart Test
    Given Search on "https://www.hepsiburada.com/"
    When Select first product wl
    And Add To Chart wl
    And Add To Chart From Another Seller wl
    Then I have seen all products were added to basket wl