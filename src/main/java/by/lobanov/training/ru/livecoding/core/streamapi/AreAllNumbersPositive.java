package by.lobanov.training.ru.livecoding.core.streamapi;

import java.util.Arrays;
import java.util.List;

/*
Определить все ли числа в списке положительные
 */
public class AreAllNumbersPositive {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> numbers1 = Arrays.asList(1,2,-3,4,5);
        System.out.println(allPositive(numbers));
        System.out.println(allPositive(numbers1));
    }

    private static boolean allPositive (List<Integer> list) {
        return list.stream()
                .allMatch(d -> d > 0);
    }
}
