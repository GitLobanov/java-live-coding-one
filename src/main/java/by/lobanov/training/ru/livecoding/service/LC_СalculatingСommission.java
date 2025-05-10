package by.lobanov.training.ru.livecoding.service;

import java.math.BigDecimal;

/*
Необходимо реализовать метод, который будет возвращать итоговую сумму списания с банковского счета с учетом комиссии за перевод средств.
Необходимо избегать конструкции выбора (if-else, switch-case, filter и Т.д.).
Известно что на вход приходят валидные данные. Сумма не может быть меньше 0, но может быть 0.
Комиссии за суммы:
... < 1_000р - 0%
1 000р - 1%
10 000р - 2%
100 000р < ... - 5%
*/
public class LC_СalculatingСommission {

    public static void main(String[] args) {
        System.out.println(countTotalSum(BigDecimal.valueOf(999)));
        System.out.println(countTotalSum(BigDecimal.valueOf(1000)));
        System.out.println(countTotalSum(BigDecimal.valueOf(10_000)));
        System.out.println(countTotalSum(BigDecimal.valueOf(100_000)));
        System.out.println(countTotalSum(BigDecimal.valueOf(100_000_000)));
    }

    public static BigDecimal countTotalSum(BigDecimal transferSum) {
        if (transferSum == null || transferSum.compareTo(BigDecimal.ZERO) < 0) {
            return BigDecimal.ZERO;
        }

        boolean isLessThan1000 = transferSum.compareTo(new BigDecimal("1000")) < 0;
        boolean isLessThan10000 = transferSum.compareTo(new BigDecimal("10000")) < 0;
        boolean isLessThan100000 = transferSum.compareTo(new BigDecimal("100000")) < 0;

        BigDecimal feeRate =
                isLessThan1000 ? BigDecimal.ZERO :
                    isLessThan10000 ? new BigDecimal("0.01") :
                        isLessThan100000 ? new BigDecimal("0.02") :
                            new BigDecimal("0.05");

        return transferSum.add(transferSum.multiply(feeRate));
    }
}
