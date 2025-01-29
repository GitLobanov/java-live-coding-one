package by.lobanov.training.ru.core.math;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Во время разработки некоторой задачи Саша решил сгенерировать несколько новых тестов.
 * Каждый тест Саши должен представлять собой натуральное число, не меньшее l и не большее r.
 * Кроме того, натуральное число в тесте обязательно должно состоять из одинаковых цифр.
 * <br>
 * Формат входных данных
 * В единственной строке вводятся два натуральных числа l, r — ограничения на тесты Саши.
 * Формат выходных данных
 * Выведите одно число — количество тестов, которое может сделать Саша.
 * <br> Пример 1
 * In: 4 7
 * Out: 4 (4,5,6,7)
 * <br> Пример 2
 * In: 10, 100
 * Out: 9 (11..55..99)
 */
public class TC5_ru_NaturalNumberTest_Tinkoff {

    public static void main(String[] args) {
        String [] str  = new Scanner(System.in).nextLine().split(" ");
        long res = getCountNaturalNumbers(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        System.out.println(res);
    }

    public static long getCountNaturalNumbers(int bottom, int up) {
        return IntStream.rangeClosed(bottom, up)
                .mapToObj(String::valueOf)
                .filter(TC5_ru_NaturalNumberTest_Tinkoff::allSymbolsEquals)
                .count();
    }

     public static boolean allSymbolsEquals (String str) {
        if (str.length() == 1) return true;
        String [] arr = str.split("");
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals(arr[i-1])) return false;
        }
        return true;
     }
}
