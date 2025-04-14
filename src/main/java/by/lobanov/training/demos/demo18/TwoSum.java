package by.lobanov.training.demos.demo18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*
Дан массив чисел и число target - найти в массиве два числа, которые в сумме дают target.
Вернуть массив с их индексами. Будем считать, что в каждом переданном массиве есть такие числа

Input: nums = [2,11,7,15], target = 9
Output: [0,2]    <--- nums[0] + nums[2] == 9

Input: nums = [3,2,4], target = 6
Output: [1,2]

Input: nums = [3,3], target = 6
Output: [0,1]
*/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 11, 7, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                return new int[]{map.get(difference), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }


}
