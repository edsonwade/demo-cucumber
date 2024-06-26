#@ignore_product_management
#Feature: Product Management
#
#  Scenario: Retrieve all products
#    Given the product service is up and running
#    When I request all products
#    Then I should receive a list of products
#
#  Scenario: Retrieve a product by ID
#    Given the product with ID 1 exists
#    When I request the product with ID 1
#    Then I should receive the product details
#
#  Scenario: Create a new product
#    Given I have a new product with name "New Product", quantity 10 and price 99.99
#    When I create the product
#    Then the product should be created
#
#  Scenario: Update an existing product
#    Given the product with ID 1 exists
#    When I update the product with ID 1 with new name "Updated Product", quantity 20 and price 109.99
#    Then the product should be updated
#
#  Scenario: Delete a product by ID
#    Given the product with ID 1 exists
#    When I delete the product with ID 1
#    Then the product should be deleted
