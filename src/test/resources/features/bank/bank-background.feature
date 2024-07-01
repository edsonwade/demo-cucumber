Feature: Bank Check Balance - background

  Background:
    Given my checking account has balance of $500

  Scenario: Checking Account Balance after Deposit
    Given I have recently made a deposit of $100
    When I check my account balance
    Then I should see $600 as the balance
    But there is an overdraft fee of $50
    And the available balances should be $550

  Scenario: Checking Account Balance after Withdrawal
    Given I have recently made a withdrawal of $100
    When I check my account balance
    Then I should see $400 as the balance
    But there is an credit interest  of $50
    And the available balances should be $450

  Scenario: Checking Account Balance after Withdrawal In-Sufficient Balance
    When I request to withdraw of $700
    Then I should see an Error
    And the available balances should be $500

