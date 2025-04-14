package by.lobanov.training.ru.livecoding.core.streamapi;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

public class BookStream {

    @Data
    @AllArgsConstructor
    public static class Book {
        private String name;
        private List<String> authors;
        private Double price;
    }

    // 1. Получить список дорогих книг стоимостью более 500.0
    // 2. Получить список всех уникальных авторов в дорогих книгах
    // 3. Рассчитать общую стоимость всех дорогих книг
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Book1", List.of("Author1", "Author2"), 800.0),
                new Book("Book2", List.of("Author1", "Author2"), 600.0),
                new Book("Book3", List. of("Author3"), 200.0)
        );

        List<Book> expansiveBooks = books.stream()
                .filter(book -> book.price > 500).toList();

        List<String> authorsWithExpansiveBooks = expansiveBooks.stream()
                .flatMap(book -> book.authors.stream())
                .distinct()
                .toList();

        // first way
        Double costAllExpansiveBooks = expansiveBooks.stream()
                .reduce(0.0, (sum, book) -> sum + book.getPrice(), Double::sum);

        // second way
        Double costAllExpansiveBooks2 = expansiveBooks.stream()
                        .mapToDouble(Book::getPrice)
                        .sum();

        System.out.println(expansiveBooks);
        System.out.println(authorsWithExpansiveBooks);
        System.out.println(costAllExpansiveBooks);
        System.out.println(costAllExpansiveBooks2);
    }
}
