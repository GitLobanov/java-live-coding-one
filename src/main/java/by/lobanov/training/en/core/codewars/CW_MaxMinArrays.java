package by.lobanov.training.en.core.codewars;

import by.lobanov.training.util.MeasureTime;

import java.util.Arrays;

public class CW_MaxMinArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{15, 11, 10, 7, 12})));
    }

    public static int[] solve(int[] arr) {
        bubbleSorting(arr); // or Arrays.sort(arr)
        int left = 0;
        int right = arr.length - 1;
        int[] newArr = new int[arr.length];
        int i = 0;

        while (left <= right) {
            if (i % 2 != 0) {
                newArr[i] = arr[left];
                left++;
            } else {
                newArr[i] = arr[right];
                right--;
            }
            i++;
        }

        return newArr;
    }

    public static void bubbleSorting (int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }
}
