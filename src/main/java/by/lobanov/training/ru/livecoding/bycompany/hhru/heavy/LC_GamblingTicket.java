package by.lobanov.training.ru.livecoding.bycompany.hhru.heavy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Вы работаете над сервисом для проведения лотерей.
 * Ваша программа предназначена для обработки последовательности цифр в лотерейном билете и основана на подсчете этих цифр.
 * На основе этого подсчета оценивается сумма выигрыша конкретного билета.
 * <p>
 * Программа должна подсчитать количество каждой цифры в последовательности,
 * увеличить это количество на один и вернуть результат в виде строки.
 * <p>
 * Формат ввода:
 * Одна строка с цифрами.
 * <p>
 * Формат вывода:
 * Одна строка, в которой выводится подсчет цифр по заданному алгоритму. Порядок цифр при этом сохраняется.
 * <p>
 * Пример 1
 * Входные данные:
 * 13133
 * Выходные данные:
 * 1:3,3:4
 * <p>
 * Пример 2
 * Входные данные:
 * 99999
 * Выходные данные:
 * 9:6
 * <p>
 * Пример 3
 * Входные данные:
 * 99
 * Выходные данные:
 * 9:3
 * <p>
 * Пример 4
 * Входные данные:
 * 13123
 * Выходные данные:
 * 1:3,3:3,2:2
 */
public class LC_GamblingTicket {

    public static void main(String[] args) {

        System.out.println(countDigits("13133")); // Output: 1:3,3:4
        System.out.println(countDigits("99999")); // Output: 9:6
        System.out.println(countDigits("99"));    // Output: 9:3
        System.out.println(countDigits("13123"));// Output: 1:3,3:3,2:2
    }

    public static String countDigits(String digits) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character ch : digits.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringJoiner sj = new StringJoiner(",");
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            sj.add(String.format("%s:%s", entry.getKey(), entry.getValue()));
        }
        return sj.toString();
    }
}
