package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }


    @Test
    public void shouldNotAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }


    @Test
    public void balancShouldNotChange() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(1_000, account.getBalance());
    }


    @Test
    public void negativeInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-3000, 5_000, 15);
        });
    }


    @Test
    public void negativeCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1_000, -5_000, 15);
        });
    }


    @Test
    public void negativeRate() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1_000, 5_000, -15);
        });
    }


    @Test
    public void negativePayment1() {
        CreditAccount account = new CreditAccount(
                3000,
                5_000,
                15
        );
        account.pay(-2_000);

        Assertions.assertEquals(3000, account.getBalance());
    }


    @Test
    public void negativePayment0() {
        CreditAccount account = new CreditAccount(
                3000,
                5_000,
                15
        );
        account.pay(0);

        Assertions.assertEquals(3000, account.getBalance());
    }


    @Test
    public void balanceAbovePaymentAmount() {
        CreditAccount account = new CreditAccount(
                3000,
                5_000,
                15
        );
        account.pay(2_000);

        Assertions.assertEquals(1000, account.getBalance());
    }


    @Test
    public void balanceEqualsPaymentAmount() {
        CreditAccount account = new CreditAccount(
                3000,
                5_000,
                15
        );
        account.pay(3_000);

        Assertions.assertEquals(0, account.getBalance());
    }


    @Test
    public void balanceBelowPaymentAmount() {
        CreditAccount account = new CreditAccount(
                3000,
                5_000,
                15
        );
        account.pay(5_000);

        Assertions.assertEquals(-2000, account.getBalance());
    }


    @Test
    public void balancePlusCreditLimitEqualsPaymentAmount() {
        CreditAccount account = new CreditAccount(
                3000,
                5_000,
                15
        );
        account.pay(8_000);

        Assertions.assertEquals(-5000, account.getBalance());
    }


    @Test
    public void balancePlusCreditLimitBelowPaymentAmount() {
        CreditAccount account = new CreditAccount(
                3000,
                5_000,
                15
        );
        account.pay(10_000);

        Assertions.assertEquals(3000, account.getBalance());
    }


    @Test
    public void annualLoanDebt() {
        CreditAccount account = new CreditAccount(
                3000,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(-450, account.yearChange());
    }


    @Test
    public void annualLoanDebt1() {
        CreditAccount account = new CreditAccount(
                3000,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(0, account.yearChange());
    }


    @Test
    public void annualLoanDebt2() {
        CreditAccount account = new CreditAccount(
                3000,
                5_000,
                15
        );

        account.pay(1_000);

        Assertions.assertEquals(0, account.yearChange());
    }

    //Bank
    @Test
    public void transferToSavingAccount1() {
        CreditAccount accountCredit = new CreditAccount(
                3000,
                5_000,
                15
        );
        SavingAccount accountSaving = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(accountCredit, accountSaving, 1_000);

        Assertions.assertEquals(2_000, accountCredit.getBalance());
        Assertions.assertEquals(6_000, accountSaving.getBalance());
    }


    @Test
    public void transferToSavingAccount2() {
        CreditAccount accountCredit = new CreditAccount(
                3000,
                5_000,
                15
        );
        SavingAccount accountSaving = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(accountCredit, accountSaving, 7_000);

        Assertions.assertEquals(-4_000, accountCredit.getBalance());
        Assertions.assertEquals(12_000, accountSaving.getBalance());
    }


    @Test
    public void NegativeTransferToSavingAccount() {
        CreditAccount accountCredit = new CreditAccount(
                3000,
                5_000,
                15
        );
        SavingAccount accountSaving = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(accountCredit, accountSaving, -1_000);

        Assertions.assertEquals(3_000, accountCredit.getBalance());
        Assertions.assertEquals(5_000, accountSaving.getBalance());
    }


    @Test
    public void transferToSavingAccountShouldNotWork1() {
        CreditAccount accountCredit = new CreditAccount(
                3000,
                5_000,
                15
        );
        SavingAccount accountSaving = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(accountCredit, accountSaving, 8_000);

        Assertions.assertEquals(3_000, accountCredit.getBalance());
        Assertions.assertEquals(5_000, accountSaving.getBalance());
    }


    @Test
    public void transferToSavingAccountShouldNotWork2() {
        CreditAccount accountCredit = new CreditAccount(
                3000,
                5_000,
                15
        );
        SavingAccount accountSaving = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(accountCredit, accountSaving, 10_000);

        Assertions.assertEquals(3_000, accountCredit.getBalance());
        Assertions.assertEquals(5_000, accountSaving.getBalance());
    }


    @Test
    public void savingAccountOverflow() {
        CreditAccount accountCredit = new CreditAccount(
                3000,
                5_000,
                15
        );
        SavingAccount accountSaving = new SavingAccount(
                19_000,
                500,
                20_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(accountCredit, accountSaving, 5_000);

        Assertions.assertEquals(3_000, accountCredit.getBalance());
        Assertions.assertEquals(19_000, accountSaving.getBalance());
    }
}
