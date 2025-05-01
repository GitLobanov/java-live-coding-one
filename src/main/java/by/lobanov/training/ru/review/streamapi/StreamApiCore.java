package by.lobanov.training.ru.review.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiCore {

    public static void main(String[] args) {
//        task();
//        task1();
//        task2();
        task3();
    }

    private static void task1() {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5).map(i -> ++i);
        Stream<Integer> stream2 = stream1.peek(System.out::println);
        List<Integer> result = stream1.toList();
    }

    private static void task2() {
        IntStream.rangeClosed(1, 4)
                .peek(System.out::println)
                .skip(2)
                .forEach(System.out::println);
    }

    private static void task3() {
        List<Integer> list = new ArrayList<>(java.util.List.of(1, 2, 3));
        List<Integer> result = list.stream()
                .peek(list::add)
                .toList();
        System.out.println(result);
    }

    private static void task() {
        Stream.iterate(0, n -> n + 1)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 10)
                .sorted()
                .limit(3)
                .forEach(System.out::println);
    }

}
