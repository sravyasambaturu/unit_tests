package edu.hawaii.ics.peruma;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

public class ATMTest {

    private ATM atm;
    private Customer customer1;
    private Customer customer2;

    @Before
    public void setUp() {
        // Initialize customers
        customer1 = new Customer(123, 1234, 5000);
        customer2 = new Customer(124, 5678, 3000);
        atm = new ATM(Arrays.asList(customer1, customer2)); // Initialize ATM with the customers
    }

    //  verifying a customer with valid credentials
    @Test
    public void verifyCustomerSuccess() {
        boolean isVerified = atm.verifyCustomer(123, 1234); // Correct account and pin
        assertTrue("customer should be verified", isVerified);
    }

    // Test for verifying a customer with invalid credentials
    @Test
    public void verifyCustomerFailure() {
        boolean isVerified = atm.verifyCustomer(123, 9999); // Incorrect pin
        assertFalse("Customer not with wrong credentials", isVerified);
    }

    // Test for getting a customer's balance when valid credentials are provided
    @Test
    public void getCustomerBalanceSuccess() throws Exception {
        float balance = atm.getCustomerBalance(123, 1234); // Valid customer
        assertEquals("balance should be correct", 5000.0f, balance, 0.0f);
    }

    // Test for getting a customer's balance with invalid credentials
    @Test(expected = Exception.class)
    public void testGetCustomerBalanceFailure() throws Exception {
        atm.getCustomerBalance(123, 9999); // Invalid pin
    }

    // Test for depositing money successfully
    @Test
    public void depositMoneySuccess() {
        ProcessStatus status = atm.depositMoney(123, 1234, 1000); // Valid deposit
        assertTrue("Deposit should be successful", status.isSuccess());
        assertEquals("balance should be updated after deposit", 6000.0f, customer1.getBalance(), 0.0f);
    }

    // Test for depositing money with invalid account or pin
    @Test
    public void depositMoneyFailure() {
        ProcessStatus status = atm.depositMoney(123, 9999, 1000); // Invalid pin
        assertFalse("Deposit should fail with invalid credentials", status.isSuccess());
    }

    // Test for withdrawing money successfully
    @Test
    public void withdrawMoneySuccess() {
        ProcessStatus status = atm.withdrawMoney(123, 1234, 1000); // Valid withdrawal
        assertTrue("Withdrawal should be successful", status.isSuccess());
        assertEquals("balance should be updated after withdrawal", 4000.0f, customer1.getBalance(), 0.0f);
    }

    // Test for withdrawing money with insufficient funds
    @Test
    public void withdrawMoneyInsufficientFunds() {
        ProcessStatus status = atm.withdrawMoney(123, 1234, 6000); // Trying to withdraw more than balance
        assertFalse("withdrawal should fail due to insufficient funds", status.isSuccess());
    }

    // Test for withdrawing money with invalid account or pin
    @Test
    public void withdrawMoneyFailure() {
        ProcessStatus status = atm.withdrawMoney(123, 9999, 1000); // Invalid pin
        assertFalse("withdrawal should fail with invalid credentials", status.isSuccess());
    }

    // Test for changing a customer's PIN with the same PIN (failure case)
    @Test
    public void changePINFailureSamePin() {
        ProcessStatus status = atm.changePIN(123, 1234, 1234); // Trying to change to the same PIN
        assertFalse("PIN changing should fail if new PIN is the same as old PIN", status.isSuccess());
    }

    // Test for changing a customer's PIN with invalid credentials
    @Test
    public void changePINFailureInvalidAccount() {
        ProcessStatus status = atm.changePIN(123, 9999, 5678); // Invalid old PIN
        assertFalse("PIN changing should fail with incorrect credentials", status.isSuccess());
    }

    // for transferring funds with insufficient funds
    @Test
    public void transferFundsInsufficientFunds() {
        ProcessStatus status = atm.transferFunds(123, 124, 1234, 6000); // Insufficient funds for transfer
        assertFalse("transfer should fail due to insufficient funds", status.isSuccess());
    }

    @Test
    public void depositMoneyFailureInvalidAmount() {
        ProcessStatus status = atm.depositMoney(123, 1234, 0); // Invalid amount (0)
        assertFalse("deposit fails if the amount is less than or equal to zero", status.isSuccess());
    }

    @Test
    public void transferFundsFailureInvalidOriginAccount() {
        ProcessStatus status = atm.transferFunds(999, 124, 1234, 1000); // Invalid origin account
        assertFalse("transfer should fail with invalid origin account", status.isSuccess());
    }

    @Test
    public void changePINFailureInvalidNewPin() {
        ProcessStatus status = atm.changePIN(123, 1234, 99); // New PIN below valid range
        assertFalse("Pin change fails if the new PIN is less than 100", status.isSuccess());

        status = atm.changePIN(123, 1234, 1000); // New PIN above valid range
        assertFalse("Pin change fail if the new PIN is greater than 999", status.isSuccess());
    }

}

