package by.lobanov.training.demos.demo18;

import java.util.Arrays;

public class SortedArray {

    /*
Дан отсортированный по возрастанию массив целых чисел,
необходимо вернуть индексы двух чисел, сумма которых равна заданному числу.
Решить с помощью двух указателей. Нельзя использовать одно и то же число дважды.
Для примера: такой вызов должен вывести на экран [4, 8]:
System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 14)));
*/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2)));
    }

    public static int[] twoSum(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;

        while (left < right) {
            int sum = sortedArray[left] + sortedArray[right];
            if (sum == target) {
                return new int[]{left, right};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }

}
