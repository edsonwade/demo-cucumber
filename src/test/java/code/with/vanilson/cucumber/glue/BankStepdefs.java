package code.with.vanilson.cucumber.glue;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BankStepdefs
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-07-01
 */
public class BankStepdefs {
    private int checkingAccountBalance;
    private int depositAmount;
    private int actualBalance;
    private int overDraftFee;

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
        actualBalance = checkingAccountBalance + depositAmount;

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
        var availableBalance = checkingAccountBalance + depositAmount - overDraftFee;
        assertEquals(expectedAvailableBalances, availableBalance);

    }
}