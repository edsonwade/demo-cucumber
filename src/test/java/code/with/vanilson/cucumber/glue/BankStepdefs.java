package code.with.vanilson.cucumber.glue;

import io.cucumber.java.en.*;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BankStepdefs
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-07-01
 */
@Slf4j
public class BankStepdefs {
    private int checkingAccountBalance;
    private int availableBalance;
    private int depositAmount;
    private int actualBalance;
    private int overDraftFee;
    @SuppressWarnings("unused")
    private int withdrawalAmount;
    private int creditInterest;

    @Given("my checking account has balance of ${int}")
    public void myCheckingAccountHasBalanceOf$(int balance) {
        checkingAccountBalance = balance;
    }

    @And("I have recently made a deposit of ${int}")
    public void iHaveRecentlyMadeADepositOf$(int deposit) {
        depositAmount = deposit;
    }

    @When("I check my account balance")
    public void iCheckMyAccountBalance() {
        actualBalance = checkingAccountBalance + depositAmount - withdrawalAmount;

    }

    @Then("I should see ${int} as the balance")
    public void iShouldSee$AsTheBalance(int expectedBalance) {
        assertEquals(expectedBalance, actualBalance);

    }

    @But("there is an overdraft fee of ${int}")
    public void thereIsAnOverdraftFeeOf$(int fee) {
        overDraftFee = fee;
    }

    @And("the available balances should be ${int}")
    public void theAvailableBalancesShouldBe$(int expectedAvailableBalances) {
        if (withdrawalAmount > 0 &&
                withdrawalAmount > checkingAccountBalance + depositAmount + creditInterest - overDraftFee) {
            availableBalance =
                    checkingAccountBalance + depositAmount - overDraftFee + creditInterest;
        } else {
            availableBalance =
                    checkingAccountBalance + depositAmount - overDraftFee + creditInterest - withdrawalAmount;
        }

        assertEquals(expectedAvailableBalances, availableBalance);

    }

    @And("I have recently made a withdrawal of ${int}")
    public void iHaveRecentlyMadeAWithdrawalOf$(int withdrawal) {
        withdrawalAmount = withdrawal;

    }

    @But("there is an credit interest  of ${int}")
    public void thereIsAnCreditInterestOf$(int interest) {
        creditInterest = interest;

    }

    @When("I request to withdraw of ${int}")
    public void iRequestToWithdrawOf$(int withdraw) {
        withdrawalAmount = withdraw;
    }

    @Then("I should see an Error")
    public void iShouldSeeAnError() {
        //For simplicity, assume that the withdrawal is not allowed, and an error message is showing
        var errorMessage = ">> Error: withdrawal not allowed due to insufficient funds. <<";
        log.error("withdrawal not allowed {}", errorMessage);

    }

    @Given("I have following account details from CSV file {string}")
    public void iHaveFollowingAccountDetailsFromCSVFile(String csvFilePath) {
        try {
            var br = new BufferedReader(new FileReader(csvFilePath));
            String line;
            var isFirstLineSkipped = false;
            while ((line = br.readLine()) != null) {
                if (!isFirstLineSkipped) {
                    isFirstLineSkipped = true;
                    continue;
                }
                String[] values = line.split(",");
                var balance = Integer.parseInt(values[0].trim());
                var deposit = Integer.parseInt(values[1].trim());
                var expectedBalance = Integer.parseInt(values[2].trim());
                var fee = Integer.parseInt(values[3].trim());
                var expectedAvailableBalance = Integer.parseInt(values[4].trim());
                myCheckingAccountHasBalanceOf$(balance);
                iHaveRecentlyMadeADepositOf$(deposit);
                iCheckMyAccountBalance();
                iShouldSee$AsTheBalance(expectedBalance);
                thereIsAnOverdraftFeeOf$(fee);
                theAvailableBalancesShouldBe$(expectedAvailableBalance);
            }

        } catch (IOException e) {
            log.error("file not found {}", e.getMessage());
        }
    }
}