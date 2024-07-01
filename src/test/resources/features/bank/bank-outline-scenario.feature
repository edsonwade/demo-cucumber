@balance-check
Feature: Bank Check Balance Using Outline Scenario
  @deposit @example
  Scenario Outline: Checking Account Balance after Deposit
    Given my checking account has balance of $<balance>
    And I have recently made a deposit of $<deposit>
    When I check my account balance
    Then I should see $<expectedBalance> as the balance
    But there is an overdraft fee of $<fee>
    And the available balances should be $<expectedAvailableBalances>
    Examples:
      | balance | deposit | expectedBalance | fee | expectedAvailableBalances |
      | 500     | 100     | 600             | 50  | 550                       |
      | 1000    | 200     | 1200            | 30  | 1170                      |
      | 2000    | 500     | 2500            | 100 | 2400                      |

    @csv
    Scenario: Checking Account Balance after Deposit CSV
      Given I have following account details from CSV file "data/testdata.csv"