package by.lobanov.training.demos.demo16;

import java.util.Arrays;

public class LC22 {

    public static void main(String[] args) {

    }

    /* Дан список целых чисел. Найти среднее всех нечётных чисел, делящихся на 5
Пример: [23, 15, 10, 5, 22, 98, 24, 86, 50]  -> 10  */

    public static int avg(int[] numbers) {
        return (int) Arrays.stream(numbers)
                .filter(num -> num % 2 != 0 && num % 5 == 0)
                .average()
                .orElse(0.0);
    }

}
