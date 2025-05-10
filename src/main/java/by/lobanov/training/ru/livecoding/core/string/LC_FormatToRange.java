package by.lobanov.training.ru.livecoding.core.string;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Дана последовательность чисел. Нужно её схлопнуть в строку.
 * {6,1,2,3, 7,0, 9} => "0-3, 6-7, 9". Числа неотрицательные.
 */

public class LC_FormatToRange {

    public static void main(String[] args) {
        System.out.println(getRange(new int[]{6, 1, 2, 3, 7, 0, 9}));  // "0-3, 6-7, 9"
        System.out.println(getRange(new int[]{1, 3, 5, 7}));           // "1, 3, 5, 7"
        System.out.println(getRange(new int[]{1, 2, 3, 5, 6, 8}));     // "1-3, 5-6, 8"
        System.out.println(getRange(new int[]{1, 2, 3, 5, 6, 7}));     // "1-3, 5-7"
    }

    private static String getRange(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }

        Arrays.sort(numbers);
        StringJoiner sj = new StringJoiner(", ");
        int beginRange = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[i - 1] + 1) {
                if (beginRange == numbers[i - 1]) {
                    sj.add(String.valueOf(beginRange));
                } else {
                    sj.add(beginRange + "-" + numbers[i - 1]);
                }
                beginRange = numbers[i];
            }
        }

        if (beginRange == numbers[numbers.length - 1]) {
            sj.add(String.valueOf(beginRange));
        } else {
            sj.add(beginRange + "-" + numbers[numbers.length - 1]);
        }

        return sj.toString();
    }

    // not works good
    private static String getRange2(int[] numbers) {
        if(numbers==null || numbers.length<2){
            return "";
        }
        Arrays.sort(numbers);
        StringBuilder result = new StringBuilder();

        int start = numbers[0];
        int finish = start;

        for(int i = 1; i<numbers.length; i++){

            if (numbers[i]==finish+1){
                finish = numbers[i];
            } else {
                result.append(start).append("-").append(finish);

                start=numbers[i];
                finish=start;

                if (i<numbers.length-1){
                    result.append(", ");
                } else{
                    result.append(finish);
                }

            }

        }

        return result.toString();
    }
}
