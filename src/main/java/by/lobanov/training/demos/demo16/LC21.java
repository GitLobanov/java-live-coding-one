package by.lobanov.training.demos.demo16;

import java.util.Map;

public class LC21 {

    /*
Перевернуть строку, решить в одну строчку
*/
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        Map<String, Integer> map = Map.of(
                "a", 500,
                "b", 5874,
                "c", 560,
                "d", 400,
                "e", 5874,
                "f",  20);

        System.out.println(highestValue(map));
    }

    // [easy stream map dmdev]
    /* Найти максимальное значение в мапе

    */
    public static int highestValue(Map<String, Integer> map) {
        return map.values().stream()
                .max(Integer::compareTo)
                .orElse(0);
    }


}
