package by.lobanov.training.ru.core.string;

import java.util.TreeMap;

/**
 * Найти самую длинную подстроку
 */
public class TC16_ru_LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
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
}
