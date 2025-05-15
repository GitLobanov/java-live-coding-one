package by.lobanov.training.ru.livecoding.bycompany.hhru.light;

import java.util.StringJoiner;

/**
 * Входные данные:
 * 5 -2 0 0 7 8 -1
 * Выходные данные:
 * выше нуля: 3, ниже нуля: 2, равна нулю: 2
 **/
public class LC_SummaryPositiveNegativeZero {

    public static void main(String[] args) {
        System.out.println(calculateStats("-5 2 -4 3 3 0"));
    }

    private static String calculateStats(String input) {
        int toNegative = 0;
        int toPositive = 0;
        int toZero = 0;

        for (String st : input.split(" ")) {
            Integer num = Integer.parseInt(st);
            if (num == 0) {
                toZero++;
            } else if (num < 0) {
                toNegative++;
            } else {
                toPositive++;
            }
        }

        StringJoiner sj = new StringJoiner(", ");
        sj.add("выше нуля: " + toPositive);
        sj.add("ниже нуля: " + toNegative);
        sj.add("равна нулю " + toZero);

        return sj.toString();
    }
}
