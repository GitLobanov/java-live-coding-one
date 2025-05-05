package by.lobanov.training.ru.livecoding.core.algorithm;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LC_DivideStreamDigitsToOddAndEven {

    public static void main(String[] args) {
        streamUseCaseOddsEvens();
    }

    private static void streamUseCaseOddsEvens () {
        Random randomizer = new Random();
        Stream<Integer> stream = randomizer.ints()
                .boxed()
                .limit(50);
        // 3AДAHME:
        // Нужно разделить числа в стриме на чётные и нечётные,
        // но таким образом, чтобы иметь возможность после этого
        // работать с обоими множествами

        Map<Boolean, List<Integer>> result = stream
                .collect(Collectors.groupingBy(i -> i % 2 == 0));

        result.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
