package by.lobanov.training.ru.livecoding.core.algorithm;

import java.util.TreeMap;

/**
 * Данa строка s, найте длину самой длинной подстроки (substring)
 * без повторяющихся символов
 * <p>
 * Пример 1:
 * Входные данные: s = "abcabcbb"
 * Выходные данные: 3
 * Объяснение: правильный ответ - "abc", с длиной равной 3.
 * <p>
 * Пример 2:
 * Входные данные: s = "bbbbb"
 * Выходные данные: 1
 * Объяснение: правильный ответ - "b", с длиной равной 1.
 * <p>
 * Пример 3:
 * Входные данные: s = "pwwkew"
 * Выходные данные: 3
 * Объяснение: правильный ответ - "wke", с длиной равной 3.
 * <p>
 * Учтите, что ответ должен быть подстрокой(substring), "pwke" является subsequence, а не подстрокой.
 */
public class LC_LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(solve("abcabcbb"));
        System.out.println(solve("bbbbb"));
        System.out.println(solve("pwwkew"));
    }

    private static int solve(String s) {
        TreeMap<Integer, String> map = new TreeMap();
        String[] array = s.split("");
        StringBuilder substr = new StringBuilder();

        for (String string : array) {
            if (!substr.toString().contains(string)) {
                substr.append(string);
            } else {
                map.put(substr.length(), substr.toString());
                substr = new StringBuilder(string);
            }
        }

        return map.floorKey(Integer.MAX_VALUE);
    }
}


