package by.lobanov.training.demos.demo16;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LC26 {

    public static void main(String[] args) {
        System.out.println(numberStream(List.of("a", "b", "c")));
    }

    // Пронумеровать элементы списка - каждому задать его порядковый номер, начиная с 1.
    // Пример:
    // [] --> []
    // ["a", "b", "c"] --> ["1: a", "2: b", "3: c"]
    public static List<String> number(List<String> lines) {

        List<String> newList = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            newList.add(String.format("%d: %s", i + 1, lines.get(i)));
        }

        return newList;
    }

    public static List<String> numberStream(List<String> lines) {
        return IntStream.range(0, lines.size())
                .mapToObj(i -> String.format("%d: %s", i + 1, lines.get(i)))
                .toList();
    }

}
