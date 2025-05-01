package by.lobanov.training.ru.livecoding.core.streamapi;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
    Есть список целых чисел, которые встречаются более 2 раз,
    Необходимо вывести пары чисел:
    <число из списка> –< сколько раз число встречается>
    Пример : int mas= [10,15,23,10,15,10,66,10,66,15] -->
    10 ->4
    15 ->3
 */
public class HowMuchNumberMeetsInArray {

    public static void main(String[] args) {
        System.out.println(makeSummary(new int[]{10, 15, 23, 10, 15, 10, 66, 10, 66, 15}));
    }

    private static Map<Integer, Long> makeSummary (int[] mas ) {
        return Arrays.stream(mas)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
