package by.lobanov.training.ru.livecoding.core.algorithm;

import java.util.Map;
import java.util.TreeMap;

/**
 * Данa строка s, найте длину самой длинной подстроки (substring)
 * без повторяющихся символов
 */
public class LengthOfLongestSubstring {

    private static int solve(String s) {
        TreeMap<Integer, String> map = new TreeMap();
        String[] array = s.split("");
        String substr = "";
        Integer subcount = 0;
        for (int i = 0; i < array.length; i++) {
            if (!substr.contains(array[i])) {
                substr = substr + array[i];
                subcount++;
            } else {
                map.put(subcount, substr);
                subcount = 1;
                substr = array[i];
            }
        }

        return map.floorKey(Integer.MAX_VALUE);

    }

    public static void main(String[] args) {
        System.out.println(solve("abcabcbb"));
        System.out.println(solve("bbbbb"));
        System.out.println(solve("pwwkew"));
    }
    /**
     * Пример 1:
     * Входные данные: s = "abcabcbb"
     * Выходные данные: 3
     * Объяснение: правильный ответ - "abc", с длиной равной 3.
     *
     * Пример 2:
     * Входные данные: s = "bbbbb"
     * Выходные данные: 1
     * Объяснение: правильный ответ - "b", с длиной равной 1.
     *
     * Пример 3:
     * Входные данные: s = "pwwkew"
     * Выходные данные: 3
     * Объяснение: правильный ответ - "wke", с длиной равной 3.
     *
     * Учтите, что ответ должен быть подстрокой(substring), "pwke" является subsequence, а не подстрокой.
     */
}


