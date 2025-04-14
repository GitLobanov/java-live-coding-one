package by.lobanov.training.ru.review.streamapi;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiCore {

    public static void main(String[] args) {
        iterate();
    }

    private static void summarizingInt() {
        IntSummaryStatistics stats = Arrays.asList(1, 3, 5, 7, 9)
                .stream()
                .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Минимум: " + stats.getMin());
        System.out.println("Максимум: " + stats.getMax());
        System.out.println("Сумма: " + stats.getSum());
        System.out.println("Среднее: " + stats.getAverage());
        System.out.println("Количество элементов: " + stats.getCount());
    }

    private static void iterate () {
        Stream.iterate(0, n -> n + 1)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 10)
                .sorted()
                .limit(3)
                .forEach(System.out::println);
    }

}
