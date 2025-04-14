package by.lobanov.training.ru.livecoding.reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCR1 {

    public record Document(String id, String title, String status, LocalDate createdAt) {}

    public static final List<Document> DOCUMENTS = List.of(
            new Document("1", "Contract A", "DRAFT", LocalDate.of(2023, 10, 1)),
            new Document("2", "Report Q3", "APPROVED", LocalDate.of(2023, 9, 15)),
            new Document("3", "Invoice #123", "REJECTED", LocalDate.of(2023, 8, 20)),
            new Document("4", "Proposal B", "DRAFT", LocalDate.of(2023, 10, 5)),
            new Document("5", "Meeting Notes", "APPROVED", LocalDate.of(2023, 9, 25))
    );

    public static void main(String[] args) {
        // Напишите метод, который возвращает все документы со статусом "DRAFT".
        // findDraftDocuments().subscribe(System.out::println);

        // Напишите метод, который возвращает первый документ со статусом "APPROVED". Если таких документов нет, верните пустой результат.
        // findFirstApprovedDocument().subscribe(System.out::println);

        // Напишите метод, который принимает дату и возвращает все документы, созданные после этой даты.
        //findDocumentsCreatedAfter(LocalDate.of(2023, 10, 1)).subscribe(System.out::println);

        // Напишите метод, который подсчитывает количество документов для каждого уникального статуса и возвращает результат как Map<String, Long>.
        countDocumentsByStatus().subscribe(System.out::println);
    }

    // Напишите метод, который подсчитывает количество документов для каждого уникального статуса и возвращает результат как Map<String, Long>.
    public static Mono<Map<String, Long>> countDocumentsByStatus() {
        return Flux.fromIterable(DOCUMENTS)
                .groupBy(document -> document.status)
                .flatMap(group -> group.count()
                        .map(count -> Map.entry(group.key(), count)))
                .collectMap(Map.Entry::getKey, Map.Entry::getValue);
    }

    // Напишите метод, который принимает дату и возвращает все документы, созданные после этой даты.
    public static Flux<Document> findDocumentsCreatedAfter(LocalDate date) {
        return Flux.fromIterable(DOCUMENTS)
                .filter(document -> document.createdAt.isAfter(date));
    }

    // Напишите метод, который возвращает первый документ со статусом "APPROVED". Если таких документов нет, верните пустой результат.
    public static Mono<Document> findFirstApprovedDocument() {
        return Flux.fromIterable(DOCUMENTS)
                //.skipWhile(document -> document.status.equals("APPROVED"))
                //.skip(2)
                .filter(document -> document.status.equals("APPROVED"))
                .next();
    }

    // Напишите метод, который возвращает все документы со статусом "DRAFT".
    public static Flux<Document> findDraftDocuments() {
        return Flux.fromIterable(DOCUMENTS)
                .filter(document -> document.status.equals("DRAFT"));
    }
}
