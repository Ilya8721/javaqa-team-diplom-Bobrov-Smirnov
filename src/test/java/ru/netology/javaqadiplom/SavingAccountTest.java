package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {


    //                                             <<<PAY>>>
    @Test
    public void testPayWhenAmountMoreThanBalance_TF() {  // Платеж > Баланса true / false
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        boolean expected = false;
        boolean actual = account.pay(6_000);

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testPayWhenAmountLessThanBalance_TF() {  // Мин баланс > Платеж < Баланс   true / false
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        boolean expected = true;
        boolean actual = account.pay(3_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPayWhenAmountMoreThanMinBalance_TF() {  // Мин баланс < Платеж < Баланс   true / false
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        boolean expected = false;
        boolean actual = account.pay(4_600);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPayWhenAmountExactMinBalance_TF() {  // Мин баланс = Платеж < Баланс  true / false
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        boolean expected = true;
        boolean actual = account.pay(4_500);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPayWhenAmount0_TF() {  // Платеж = 0    true / false
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        boolean expected = false;
        boolean actual = account.pay(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPayWhenAmountUnder0_TF() {  // Платеж < 0    true / false
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        boolean expected = false;
        boolean actual = account.pay(-2_500);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPayWhenAmountMoreThanMaxBalance_TF() {  // Платеж > Макс Баланса    true / false
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        boolean expected = false;
        boolean actual = account.pay(30000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testBalanceAfterCorrectPay() {  // Корректный платеж
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        account.pay(3_000);
        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testBalanceAfterPayMoreThanBalance() {  // Платеж больше баланса на счете
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        account.pay(6_000);
        int expected = 5_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testBalanceAfterPayMoreThanMinBalance() {  // Баланс становится меньше минимального
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        account.pay(4_600);
        int expected = 5_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testBalanceAfterPayEqualsMinBalance_Amount() {  // Баланс становится равен минимальному
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        account.pay(4_500);
        int expected = 500;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testBalanceAfterPayMoreThanMaxBalance_Amount() {  // Сумма платежа больше maxBalance
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        account.pay(30_000);
        int expected = 5_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }



//                        <<<ADD>>>


    @Test
    public void testAddWhenAllCorrect() {            // Тест при корректных данных
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        account.add(8_000);

        int expected = 13_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAddWhenUnder0() {            // Тест при сумме < 0
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        account.add(-8_000);

        int expected = 5_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAddWhen0() {            // Тест при сумме = 0
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        account.add(0);

        int expected = 5_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAddWhenMoreThanMaxBalance() {         // Тест при сумме когда сумма становиться больше maxBalance
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        account.add(30_000);

        int expected = 5_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAddWhenAllCorrect_TF() {            // Тест при корректных данных true / false
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        boolean expected = true;
        boolean actual = account.add(8_000);;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAddWhenUnder0_TF() {            // Тест при сумме < 0  true / false
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        boolean expected = false;
        boolean actual = account.add(-8_000);;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAddWhen0_TF() {            // Тест при сумме = 0 true / false
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        boolean expected = false;
        boolean actual = account.add(0);;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAddWhenMoreThanMaxBalance_TF() {   // Тест при сумме когда сумма становиться больше maxBalance
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        boolean expected = false;
        boolean actual = account.add(30_000);;

        Assertions.assertEquals(expected, actual);
    }

//                                <<YEAR CHANGE>>>

    @Test
    public void testYearChange() {   // Тест YearChange при корректных данных
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        int expected = 500;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testYearChangeWhenRate0() {   // Тест YearChange 0
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                0
        );

        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }




    //                                       <<<SAVING ACCOUNT>>>
    @Test
    public void testSavingAccountWhenRateUnder0() {            // Тест при вворде отрицательной ставки

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    5_000,
                    500,
                    20_000,
                    -5
            );
        });
    }

    @Test
    public void testSavingAccountWhenMinBalanceMoreThanMaxBalance() {            // Тест при minBalance > maxBalance

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    11_000,
                    10_000,
                    5_000,
                    5
            );
        });
    }

    @Test
    public void testSavingAccountWhenInitialBalanceLessThanMinBalance() {   // Тест при initialBalance < minBalance

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1_000,
                    2_000,
                    5_000,
                    5
            );
        });
    }

    @Test
    public void testSavingAccountWhenMaxBalanceUnder0() {   // Тест при maxBalance < 0

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    5_000,
                    2_000,
                    -100,
                    5
            );
        });
    }

    @Test
    public void testSavingAccountWhenMinBalanceUnder0() {   // Тест при minBalance < 0

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1_000,
                    -500,
                    5_000,
                    5
            );
        });
    }

    @Test
    public void testSavingAccountWhenInitialBalanceUnder0() {   // Тест при initialBalance < 0

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    -100,
                    500,
                    5_000,
                    5
            );
        });
    }



}
