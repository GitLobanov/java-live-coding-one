package by.lobanov.training.demos.demo8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LC11 {

    /**
     * Необходимо отсортировать заданную строку.
     * Каждое слово в строке будет содержать одно число.
     * Это число обозначает позицию, которую слово должно занимать в результате.
     *
     * Примечание. Числа могут быть от 1 до 9.
     * Таким образом, первым словом будет 1 (а не 0).
     *
     * Если входная строка пуста, верните пустую строку.
     *
     *
     * Пример:
     * "is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
     * "4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
     */

    public static void main(String[] args) {
        System.out.println(order3("4of Fo1r pe6ople g3ood th5e the2"));
    }

    public static String order(String words) {
        String [] wordsArray = words.split(" ");
        Map<Integer, String> wordsMap = new HashMap<>();

        for (int i = 0; i < wordsArray.length; i++) {
            char[] chars = wordsArray[i].toCharArray();
            for (int j  = 0; j < chars.length; j++) {
                if (Character.isDigit(chars[j])) {
                    String digit = String.valueOf(chars[j]);
                    wordsMap.put(Integer.valueOf(digit), wordsArray[i]);
                }
            }
        }

        Set<Map.Entry<Integer, String>> entries = wordsMap.entrySet();
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer,String> entry : entries) {
            result.append(entry.getValue());
            result.append(" ");
        }

        return result.toString();
    }

    public static String order2(String words) {
        String [] array = words.split(" ");

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= array.length; i++) {

            for (String word : array) {
                if (word.contains(String.valueOf(i))) {
                    builder.append(word);
                    builder.append(" ");
                }
            }
        }

        return builder.toString();
    }

    public static String order3(String words) {

        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(s -> s.replaceAll("\\D+", "")))
                .collect(Collectors.joining(" "));
    }
}
