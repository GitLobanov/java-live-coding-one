package by.lobanov.training.en.core.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Example 1:
 * <br>
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 * <br>
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 * <br>
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <pre>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * </pre>
 */
public class TC5_en_RomanToInteger_Leetcode {

    public static void main(String[] args) {
        System.out.println(testRomanToInt("III", 3));       // 3
        System.out.println(testRomanToInt("IV", 4));        // 4
        System.out.println(testRomanToInt("IX", 9));        // 9
        System.out.println(testRomanToInt("LVIII", 58));    // 58
        System.out.println(testRomanToInt("MCMXCIV", 1994));// 1994
        System.out.println(testRomanToInt("XLII", 42));     // 42
        System.out.println(testRomanToInt("XC", 90));       // 90
        System.out.println(testRomanToInt("D", 500));       // 500
        System.out.println(testRomanToInt("CM", 900));      // 900
        System.out.println(testRomanToInt("MMM", 3000));    // 3000
    }

    private static Map<Character, Integer> romanToIntegerMap = new HashMap<>();
    static {
        romanToIntegerMap.put('I', 1);
        romanToIntegerMap.put('V', 5);
        romanToIntegerMap.put('X', 10);
        romanToIntegerMap.put('L', 50);
        romanToIntegerMap.put('C', 100);
        romanToIntegerMap.put('D', 500);
        romanToIntegerMap.put('M', 1000);
    }

    // iteration from end
    // "MCMXCIV"
    private static int romanToInt(String s) {
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        char [] chars = str.toString().toCharArray();

        int digit = romanToIntegerMap.get(chars[0]);
        int lastNumber = romanToIntegerMap.get(chars[0]);
        for (int i = 1; i < chars.length; i++) {
             int currentNumber = romanToIntegerMap.get(chars[i]);
             if (currentNumber >= lastNumber) {
                 digit += currentNumber;
             } else {
                 digit -= currentNumber;
             }
            lastNumber = romanToIntegerMap.get(chars[i]);
        }

        return digit;
    }

    // iteration from start
    private static int moreSimpleRomanToInt(String s) {
        char [] chars = s.toCharArray();

        int digit = 0;
        for (int i = 0; i + 1 < chars.length; i++) {
            int currentNumber = romanToIntegerMap.get(chars[i]);
            int nextNumber = romanToIntegerMap.get(chars[i+1]);
            if (currentNumber < nextNumber) {
                digit -= currentNumber;
            } else {
                digit += currentNumber;
            }
        }
        return digit + romanToIntegerMap.get(chars[chars.length-1]);
    }

    private static boolean testRomanToInt(String roman, int expected) {
        int result = moreSimpleRomanToInt(roman);
        System.out.println("Римское число: " + roman + ", результат: " + result + ", ожидалось: " + expected);
        return result == expected;
    }
}
