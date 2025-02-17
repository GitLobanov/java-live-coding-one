package by.lobanov.training.demos.demo14;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Прогон на МосБиржу
 */
public class LC18 {

    public static void main(String[] args) {
        List<Author> authors = java.util.List.of(
                Author.of("Достоевский Федор Михайлович",
                        java.util.List.of(
                                Book.of("Преступление и наказание", 1866),
                                Book.of("HOT", 1869),
                                Book.of("Братья Карамазовы", 1886),
                                Book.of("Бесы", 1872)
                        )
                ),
                Author.of("Лев Николаевич Толстой",
                        java.util.List.of(
                                Book.of("Boйна и Mир", 1869),
                                Book.of("Анна Каренина", 1877),
                                Book.of("Воскресение", 1899),
                                Book.of("Крейцерова соната", 1889)
                        )),
                Author.of("Hил Геймaн",
                        java.util.List.of(
                                Book.of("Песочный человек", 1997),
                                Book.of("Кладбище домашних животных", 1989),
                                Book.of("Коралловый мальчик", 2002),
                                Book.of("Американские боги", 2001))),
                Author.of("Иванов Иван Иванович",
                        java.util.List.of())
        );

        completion1(authors, 1990);

    }

    /*
     EASY: Необходимо получить List названий книг всех авторов, которые были выпущены до/после указанного года
     */
    public static void completion1(List<Author> authors, Integer targetYear) {
        authors.stream()
                .flatMap(author -> author.books.stream())
                .filter(book -> book.year > targetYear)
                .map(book -> book.title)
                .forEach(System.out::println);
    }
    /*
     EASY: Необходимо собрать в List имена авторов, у которых есть более 1 книги
     */
    public static void completion(List<Author> authors) {
        authors.stream()
                .filter(author -> author.books.size() > 1)
                .map(author -> author.name)
                .forEach(System.out::println);
    }

        @AllArgsConstructor(staticName = "of")
        @Data
        static class Author {
            private String name;
            private List<Book> books;
        }

        @AllArgsConstructor(staticName = "of")
        @Data
        static class Book {
            private String title;
            private Integer year;
        }
}

