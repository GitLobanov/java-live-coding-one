package by.lobanov.training.ru.livecoding.core.array;

import java.util.Arrays;

/*
Найти 2 элемента упорядоченного массива, сумма которых равна заданному числу
 */
public class LC_FindSumOfTwoInSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSumOfTwo(new int[]{0, 1, 3, 4, 5, 6}, 5)));
    }

    private static int[] findSumOfTwo(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target){
                return new int[]{left, right};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{0,0};
    }
}
