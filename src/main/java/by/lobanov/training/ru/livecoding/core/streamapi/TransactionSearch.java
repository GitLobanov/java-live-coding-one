package by.lobanov.training.ru.livecoding.core.streamapi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
Найти клиентов, совершивших покупки во ВСЕХ категориях за указанный период.
Пример:
Вход: Транзакции [
	{ClientA, "Electronics", 2023-01-01},
	{ClientA, "Books", 2023-01-02},
	{ClientB, "Electronics", 2023-01-03},
	{ClientB, "Books", 2023-01-04}
], категории - ["Electronics", "Books"]
Выход: ["ClientA"]
*/
public class TransactionSearch {

    private record Transaction(String clientId, String category, LocalDateTime timestamp) {}

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("ClientA", "Electronics", LocalDateTime.of(2023, 1, 1, 0,0)));
        transactions.add(new Transaction("ClientA", "Books", LocalDateTime.of(2023, 1, 2, 0,0)));
        transactions.add(new Transaction("ClientB", "Electronics", LocalDateTime.of(2023, 1, 3, 0,0)));
        transactions.add(new Transaction("ClientB", "Books", LocalDateTime.of(2023, 1, 4, 0,0)));

        Set<String> categoriesSearched = new HashSet<>();
        categoriesSearched.add("Electronics");
        categoriesSearched.add("Books");
        System.out.println(findClientsWithAllCategories(transactions,
                categoriesSearched,
                LocalDateTime.of(2023, 1, 1, 0, 0),
                LocalDateTime.of(2023, 1, 3, 0, 0)));
    }

    public static List<String> findClientsWithAllCategories(
            List<Transaction> transactions,
            Set<String> requiredCategories,
            LocalDateTime start,
            LocalDateTime end) {
        return transactions.stream()
                .filter(transaction -> transaction.timestamp.isAfter(start.minusNanos(1)) &&
                        transaction.timestamp().isBefore(end.plusNanos(1)))
                .collect(Collectors.toMap(
                        Transaction::clientId,
                        p -> new HashSet<>(Collections.singleton(p.category)),
                        (set1, set2) -> {set1.addAll(set2); return set1;}
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue().containsAll(requiredCategories))
                .map(Map.Entry::getKey)
                .toList();
    }
}
