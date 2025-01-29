package by.lobanov.training.ru.core.math;

import java.util.Arrays;
import java.util.Scanner;

public class TC4_ru_SwapDigitsAndCompareSum_Tinkoff {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int[] canSwap = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] canSwap = Arrays.stream("5 2".split(" ")).mapToInt(Integer::parseInt).toArray();
//        int[] chainDigits = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] chainDigits = Arrays.stream("1 2 1 3 5".split(" ")).mapToInt(Integer::parseInt).toArray();
        int originSwap = getDigitsSumFromArrays(chainDigits);
        int[] swappedDigits = getSwappedDigits(canSwap, chainDigits);
        int afterSwapSum = getDigitsSumFromArrays(swappedDigits);
        System.out.println(compareSum(originSwap,afterSwapSum));
    }

    public static int [] getSwappedDigits (int [] canSwap, int [] chainDigits) {
        int n = canSwap[0];
        int swappedAllowed = canSwap[1];
        Integer swapped = 0;
        // отсекать те что нельзя свапнуть
        // искать возможности среди больших цифр
        // искать минимальные
        Arrays.sort(chainDigits);
        for (int i = 0; i < chainDigits.length; i++) {
            if (containsOnly(String.valueOf(chainDigits[i]), "9")) continue;
            chainDigits[i] = swapDigits(chainDigits[i], swapped, swappedAllowed);
            if (swapped >= swappedAllowed) break;
        }
        return chainDigits;
    }

    private static int swapDigits(int el, Integer swapped, int canTimesSwap) {
        String [] arr = String.valueOf(el).split("");
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("9")) {
                arr[i] = "9";
                swapped++;
            }
            if (swapped >= canTimesSwap) break;
        }
        return Integer.parseInt(String.join("", arr));
    }

    public static int compareSum (int originSum, int afterSwapSum) {
        return afterSwapSum - originSum;
    }

    public static int getDigitsSumFromArrays (int [] arr) {
        int sum = 0;
        for (int el : arr) {
            sum = sum + el;
        }
        return sum;
    }

    public static boolean containsOnly (String str, String symbol) {
        for (String el : str.split("")){
            if (!el.equals(symbol)) {
                return false;
            }
        }
        return true;
    }
}
