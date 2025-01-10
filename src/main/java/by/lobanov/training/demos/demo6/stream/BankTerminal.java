package by.lobanov.training.demos.demo6.stream;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Data
public class BankTerminal {
    private List<Transaction> transactions; // Все транзакции, проведенные через терминал

    // Транзакция
    @Data
    @RequiredArgsConstructor
    public static class Transaction {
        private final String accountId;   // Идентификатор счета
        private final double amount;      // Сумма транзакции
        private final String type;        // Тип транзакции (например, "DEPOSIT", "WITHDRAW")
        private final Date timestamp;     // Время транзакции
    }

    public BankTerminal(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * 1. Найти общее количество транзакций каждого типа.
     * Условие: Использовать Stream API и `groupingBy` + `counting`.
     */
    public Map<String, Long> getTransactionCountByType() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 2. Найти топ-3 счета по общей сумме снятий (транзакции с типом "WITHDRAW").
     * Условие: Использовать Stream API, `filter`, `groupingBy`, и `sorted`.
     */
    public List<String> getTop3AccountsByWithdrawals() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 3. Найти аккаунт с наибольшим остатком средств.
     * Условие: Использовать Stream API, `collectingAndThen`, `groupingBy`, и `reducing`.
     * Остаток = сумма всех DEPOSIT - сумма всех WITHDRAW.
     */
    public Optional<String> getAccountWithHighestBalance() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 4. Разделить все счета на группы: с положительным остатком и с отрицательным или нулевым.
     * Условие: Использовать Stream API, `partitioningBy` и кастомный сборщик.
     */
    public Map<Boolean, List<String>> partitionAccountsByBalance() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 5. Получить список транзакций за последние N дней.
     * Условие: Использовать Stream API и метод `filter`.
     */
    public List<Transaction> getTransactionsInLastDays(int days) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 6. Найти транзакции с максимальной и минимальной суммой.
     * Условие: Использовать Stream API, комбинированные операции `collect` с `Collectors.of`.
     */
    public Map<String, Transaction> getMinMaxTransactions() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 7. Подсчитать сумму транзакций для каждого аккаунта, сгруппированную по типу (DEPOSIT, WITHDRAW).
     * Условие: Использовать Stream API, `groupingBy` + `mapping`.
     */
    public Map<String, Map<String, Double>> getAccountTransactionSummary() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 8. Создать отчет с описанием счета: количество транзакций, общая сумма и средняя сумма.
     * Условие: Использовать Stream API, `groupingBy` и комбинированные сборщики.
     */
    public Map<String, AccountReport> generateAccountReport() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    // Вспомогательный класс для отчетов
    @Data
    @RequiredArgsConstructor
    public static class AccountReport {
        private final long transactionCount;
        private final double totalAmount;
        private final double averageAmount;

        @Override
        public String toString() {
            return "AccountReport{" +
                    "transactionCount=" + transactionCount +
                    ", totalAmount=" + totalAmount +
                    ", averageAmount=" + averageAmount +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<BankTerminal.Transaction> transactions = Arrays.asList(
                new BankTerminal.Transaction("A001", 500.0, "DEPOSIT", new Date(System.currentTimeMillis() - 2 * 24 * 60 * 60 * 1000)),
                new BankTerminal.Transaction("A002", 200.0, "WITHDRAW", new Date(System.currentTimeMillis() - 5 * 24 * 60 * 60 * 1000)),
                new BankTerminal.Transaction("A001", 300.0, "WITHDRAW", new Date(System.currentTimeMillis() - 1 * 24 * 60 * 60 * 1000)),
                new BankTerminal.Transaction("A003", 1000.0, "DEPOSIT", new Date(System.currentTimeMillis() - 10 * 24 * 60 * 60 * 1000)),
                new BankTerminal.Transaction("A003", 400.0, "WITHDRAW", new Date(System.currentTimeMillis() - 3 * 24 * 60 * 60 * 1000)),
                new BankTerminal.Transaction("A002", 600.0, "DEPOSIT", new Date(System.currentTimeMillis() - 4 * 24 * 60 * 60 * 1000))
        );

        BankTerminal terminal = new BankTerminal(transactions);

        System.out.println(terminal.getTransactionCountByType()); // {DEPOSIT=3, WITHDRAW=3}
        System.out.println(terminal.getTop3AccountsByWithdrawals()); // [A001, A003, A002]
        System.out.println(terminal.getAccountWithHighestBalance()); // Optional[A003]
        System.out.println(terminal.partitionAccountsByBalance()); // {true=[A003, A002], false=[A001]}
        System.out.println(terminal.getTransactionsInLastDays(7)); // [T1, T3]
        System.out.println(terminal.getMinMaxTransactions()); // {max=T4, min=T2}
        System.out.println(terminal.getAccountTransactionSummary()); // {A001={DEPOSIT=500, WITHDRAW=300}, ...}
        System.out.println(terminal.generateAccountReport()); // {A001=AccountReport{...}, ...}
    }
}
