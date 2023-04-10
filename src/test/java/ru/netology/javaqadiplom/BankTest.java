package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

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
        bank.transfer(accountCredit, accountSaving, 8_001);

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


    @Test
    public void transferToCreditAccount1() {
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
        bank.transfer(accountSaving, accountCredit, 1_000);

        Assertions.assertEquals(4_000, accountCredit.getBalance());
        Assertions.assertEquals(4_000, accountSaving.getBalance());
    }


    @Test
    public void transferToCreditAccount2() {
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
        bank.transfer(accountSaving, accountCredit, 4_500);

        Assertions.assertEquals(7_500, accountCredit.getBalance());
        Assertions.assertEquals(500, accountSaving.getBalance());
    }


    @Test
    public void NegativeTransferToCreditAccount() {
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
        bank.transfer(accountSaving, accountCredit, -1_000);

        Assertions.assertEquals(3_000, accountCredit.getBalance());
        Assertions.assertEquals(5_000, accountSaving.getBalance());
    }


    @Test
    public void transferToCreditAccountShouldNotWork() {
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
        bank.transfer(accountSaving, accountCredit, 6_000);

        Assertions.assertEquals(3_000, accountCredit.getBalance());
        Assertions.assertEquals(5_000, accountSaving.getBalance());
    }


}
