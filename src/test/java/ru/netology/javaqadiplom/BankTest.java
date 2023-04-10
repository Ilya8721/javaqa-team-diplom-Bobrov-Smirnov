package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    //  Credit  --> Saving

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
        bank.transfer(accountCredit, accountSaving, 8_000);

        Assertions.assertEquals(-5_000, accountCredit.getBalance());
        Assertions.assertEquals(13_000, accountSaving.getBalance());
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

    //  Savng --> Credit


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

    //  Credit --> Credit

    @Test
    public void testTransferFromCreditToCreditCorrect() {    //  Кредит кредит корректные данные
        CreditAccount accountCreditFrom = new CreditAccount(
                3000,
                5_000,
                15
        );
        CreditAccount accountCreditTo = new CreditAccount(
                5_000,
                10_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(accountCreditFrom, accountCreditTo, 6_000);

        Assertions.assertEquals(-3_000, accountCreditFrom.getBalance());
        Assertions.assertEquals(11_000, accountCreditTo.getBalance());
    }

    @Test
    public void testTransferFromCreditToCreditUnder0() {    //  Кредит кредит отриц сумма перевода
        CreditAccount accountCreditFrom = new CreditAccount(
                3000,
                5_000,
                15
        );
        CreditAccount accountCreditTo = new CreditAccount(
                5_000,
                10_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(accountCreditFrom, accountCreditTo, -5_000);

        Assertions.assertEquals(3_000, accountCreditFrom.getBalance());
        Assertions.assertEquals(5_000, accountCreditTo.getBalance());
    }

    @Test
    public void testTransferFromCreditToCredit0() {    //  Кредит кредит сумма = 0
        CreditAccount accountCreditFrom = new CreditAccount(
                3000,
                5_000,
                15
        );
        CreditAccount accountCreditTo = new CreditAccount(
                5_000,
                10_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(accountCreditFrom, accountCreditTo, 0);

        Assertions.assertEquals(3_000, accountCreditFrom.getBalance());
        Assertions.assertEquals(5_000, accountCreditTo.getBalance());
    }

    @Test
    public void testTransferFromCreditToCreditEqualsLimit() {    //  Кредит кредит остаток = лимит
        CreditAccount accountCreditFrom = new CreditAccount(
                3000,
                5_000,
                15
        );
        CreditAccount accountCreditTo = new CreditAccount(
                5_000,
                10_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(accountCreditFrom, accountCreditTo, 8_000);

        Assertions.assertEquals(-5_000, accountCreditFrom.getBalance());
        Assertions.assertEquals(13_000, accountCreditTo.getBalance());
    }

    @Test
    public void testTransferFromCreditToCreditUnderLimit() {    //  Кредит кредит остаток < лимит
        CreditAccount accountCreditFrom = new CreditAccount(
                3000,
                5_000,
                15
        );
        CreditAccount accountCreditTo = new CreditAccount(
                5_000,
                10_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(accountCreditFrom, accountCreditTo, 8_001);

        Assertions.assertEquals(3_000, accountCreditFrom.getBalance());
        Assertions.assertEquals(5_000, accountCreditTo.getBalance());
    }

    // Saving --> Saving

    @Test
    public void testTransferFromSavingToSavingCorrect() {    //  Сейвинг сейвинг корректные данные
        SavingAccount accountSavingFrom = new SavingAccount(
                3000,
                500,
                15_000,
                5
        );
        SavingAccount accountSavingTo = new SavingAccount(
                6000,
                1000,
                10_000,
                6
        );
        Bank bank = new Bank();
        bank.transfer(accountSavingFrom, accountSavingTo, 1000);

        Assertions.assertEquals(2000, accountSavingFrom.getBalance());
        Assertions.assertEquals(7000, accountSavingTo.getBalance());
    }

    @Test
    public void testTransferFromSavingToSavingUnder0() {    //  Сейвинг сейвинг сумма <0
        SavingAccount accountSavingFrom = new SavingAccount(
                3000,
                500,
                15_000,
                5
        );
        SavingAccount accountSavingTo = new SavingAccount(
                6000,
                1000,
                10_000,
                6
        );
        Bank bank = new Bank();
        bank.transfer(accountSavingFrom, accountSavingTo, -1000);

        Assertions.assertEquals(3000, accountSavingFrom.getBalance());
        Assertions.assertEquals(6000, accountSavingTo.getBalance());
    }

    @Test
    public void testTransferFromSavingToSaving0() {    //  Сейвинг сейвинг сумма = 0
        SavingAccount accountSavingFrom = new SavingAccount(
                3000,
                500,
                15_000,
                5
        );
        SavingAccount accountSavingTo = new SavingAccount(
                6000,
                1000,
                10_000,
                6
        );
        Bank bank = new Bank();
        bank.transfer(accountSavingFrom, accountSavingTo, 0);

        Assertions.assertEquals(3000, accountSavingFrom.getBalance());
        Assertions.assertEquals(6000, accountSavingTo.getBalance());
    }

    @Test
    public void testTransferFromSavingToSavingEqualsMinBalance() {    //  Сейвинг сейвинг сумма = minBal
        SavingAccount accountSavingFrom = new SavingAccount(
                3000,
                500,
                15_000,
                5
        );
        SavingAccount accountSavingTo = new SavingAccount(
                6000,
                1000,
                10_000,
                6
        );
        Bank bank = new Bank();
        bank.transfer(accountSavingFrom, accountSavingTo, 2500);

        Assertions.assertEquals(500, accountSavingFrom.getBalance());
        Assertions.assertEquals(8500, accountSavingTo.getBalance());
    }

    @Test
    public void testTransferFromSavingToSavingEqualsMinBalAndMoreThanMaxBal() {    //Сейвинг сейвинг manBal = сумма > maxBal
        SavingAccount accountSavingFrom = new SavingAccount(
                3000,
                500,
                15_000,
                5
        );
        SavingAccount accountSavingTo = new SavingAccount(
                6000,
                1000,
                7000,
                6
        );
        Bank bank = new Bank();
        bank.transfer(accountSavingFrom, accountSavingTo, 2500);

        Assertions.assertEquals(3000, accountSavingFrom.getBalance());
        Assertions.assertEquals(6000, accountSavingTo.getBalance());
    }

    @Test
    public void testTransferFromSavingToSavingUnderMinBal() {    //  Сейвинг сейвинг сумма < minBal
        SavingAccount accountSavingFrom = new SavingAccount(
                3000,
                500,
                15_000,
                5
        );
        SavingAccount accountSavingTo = new SavingAccount(
                6000,
                1000,
                10_000,
                6
        );
        Bank bank = new Bank();
        bank.transfer(accountSavingFrom, accountSavingTo, 2501);

        Assertions.assertEquals(3000, accountSavingFrom.getBalance());
        Assertions.assertEquals(6000, accountSavingTo.getBalance());
    }

    @Test
    public void testTransferFromSavingToSavingEqualsMaxBal() {    //  Сейвинг сейвинг сумма = maxBal
        SavingAccount accountSavingFrom = new SavingAccount(
                3000,
                500,
                15_000,
                5
        );
        SavingAccount accountSavingTo = new SavingAccount(
                6000,
                1000,
                8000,
                6
        );
        Bank bank = new Bank();
        bank.transfer(accountSavingFrom, accountSavingTo, 2000);

        Assertions.assertEquals(1000, accountSavingFrom.getBalance());
        Assertions.assertEquals(8000, accountSavingTo.getBalance());
    }

    @Test
    public void testTransferFromSavingToSavingMoreThanMaxBal() {    //  Сейвинг сейвинг сумма = maxBal
        SavingAccount accountSavingFrom = new SavingAccount(
                3000,
                500,
                15_000,
                5
        );
        SavingAccount accountSavingTo = new SavingAccount(
                6000,
                1000,
                8000,
                6
        );
        Bank bank = new Bank();
        bank.transfer(accountSavingFrom, accountSavingTo, 2001);

        Assertions.assertEquals(3000, accountSavingFrom.getBalance());
        Assertions.assertEquals(6000, accountSavingTo.getBalance());
    }


}
