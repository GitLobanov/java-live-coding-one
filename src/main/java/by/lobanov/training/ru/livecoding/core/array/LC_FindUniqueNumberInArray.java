package by.lobanov.training.ru.livecoding.core.array;

import java.util.Arrays;

/**
 * Найти уникальное число
 * Решить без использования других структур данных, минимум за O(n)
 * int[] nums = {1, 1, 1, 2, 3, 3, 4, 4, 8, 8}; // 2
 * int[] nums = {1, 1, 1, 2, 2, 3, 3, 4, 4, 8, 8, 9}; // 9
 * int[] {1} // 1
 * int[] {1,2} // 1
 * null // 0
 * int[] {} // 0
 */
public class LC_FindUniqueNumberInArray {

    public static void main(String[] args) {
        System.out.println(findUniqueStupidWay(new int[]{1, 1, 1, 2, 3, 3, 4, 4, 8, 8})); // 2
        System.out.println(findUniqueStupidWay(new int[]{1, 1, 1, 2, 2, 3, 3, 4, 4, 8, 8, 9})); // 9
        System.out.println(findUniqueStupidWay(new int[]{1})); // 1
        System.out.println(findUniqueStupidWay(new int[]{1, 2})); // 1
        System.out.println(findUniqueStupidWay(new int[]{1, 2, 2})); // 1
        System.out.println(findUniqueStupidWay(null)); // 0
        System.out.println(findUniqueStupidWay(new int[]{})); // 0
    }

    private static int findUniqueStupidWay(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 3) return nums[0];

        Arrays.sort(nums);
        int left = 0;
        int right = 1;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] != nums[left] && nums[i] != nums[right])) {
                return nums[i];
            } else if (left == i && nums[i] != nums[right]) {
                return nums[i];
            } else if (right == i && nums[i] != nums[left]) {
                return nums[i];
            }

            left++;
            right++;
            if (i < left) {
                left = i;
            }

            if (nums.length == right) {
                right--;
            }
        }

        return 0;
    }

    // good, but works only for 2 in row like 1 1 2 3 3, but not for 1 1 1 2 3 3
    private static int findUniqueOptimalXORWay(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int unique = 0;
        for (int num : nums) {
            unique ^= num;
        }
        return unique;
    }
}
