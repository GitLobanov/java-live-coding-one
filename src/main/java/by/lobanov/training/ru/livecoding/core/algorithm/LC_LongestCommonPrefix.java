package by.lobanov.training.ru.livecoding.core.algorithm;

/**
 * Есть массив слов
 * Написать функцию, которая определяет самый длинный общий префикс
 * Пример:
 * Массив array{"flower", "flow", "flight"}
 * Самый длинный общий префикс -> "fl"
 * Массив array {"dog","racecar","car"}
 * Самый длинный общий префикс -> ""
 */
public class LC_LongestCommonPrefix {

    private static String solution(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"flower", "flow", "flight"}));
    }
}
