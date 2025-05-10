package by.lobanov.training.ru.livecoding.core.streamapi;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LC_TransformByGrouping {

    public static void main(String[] args) {
        Integer[] input = {1, 2, 5, 4, 4, 5, 2, 3, 6, 5};
        System.out.println(transformMoreEffective(input));
        System.out.println(transformMoreEffective(null));
    }

    /**
     * Преобразует массив чисел в мапу, где ключ — число с суффиксом "-hello",
     * а значение — количество вхождений этого числа в массиве.
     *
     * Пример:
     *   Вход: [1, 2, 2, 3]
     *   Выход: {"1-hello": 1, "2-hello": 2, "3-hello": 1}
     *
     * @param nums Массив чисел (может содержать null, они будут проигнорированы)
     */
    public static Map<String, Integer> transformStupidWay (final Integer... nums) {
        return Arrays.stream(nums)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(entry -> Map.entry(entry.getKey() + "-hello", entry.getValue().intValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, Integer> transformMoreEffective(final Integer... nums) {
        return Arrays.stream(nums)
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(
                        num -> num + "-hello",
                        num -> 1,
                        Integer::sum
                ));
    }
}
