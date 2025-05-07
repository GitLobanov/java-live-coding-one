package by.lobanov.training.ru.livecoding.core.array;

import org.apache.logging.log4j.util.PropertySource;

import java.util.Arrays;
import java.util.Comparator;

/*
Дан массив, нужно преобразовать в формат:
- макс число, мин число, второе макс число, второе мин число
Пример: solve([15,11,10,7,12]) = [15,7,12,10,11]
Доп* - не использовать готовые реализации сортировки
*/
public class LC_MaxMinArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{15, 11, 10, 7, 12})));
        System.out.println(Arrays.toString(solve1(new int[]{15, 11, 10, 7, 12})));
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

    public static void bubbleSorting(int[] arr) {
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

    public static int[] solve1(int[] arr) {
        int[] cArr = Arrays.copyOf(arr, arr.length);
        int[] rArr = new int[cArr.length];
        Arrays.sort(cArr);

        int left = 0;
        int right = cArr.length - 1;
        int i = 0;

        while (left <= right) {
            if (i % 2 == 0) {
                rArr[i] = cArr[right];
                right--;
            } else {
                rArr[i] = cArr[left];
                left++;
            }

            i++;
        }

        return rArr;
    }
}
