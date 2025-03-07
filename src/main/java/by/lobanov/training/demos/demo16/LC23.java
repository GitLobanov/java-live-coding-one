package by.lobanov.training.demos.demo16;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LC23 {

    public static void main(String[] args) {

    }

    /*
Проверить, есть ли в массивах дубликаты чисел, вернуть true, если есть

Input: nums = [1,2,3,1]
Output: true

Input: nums = [1,2,3,4]
Output: false

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
*/
    public static boolean containsDuplicate(int[] nums) {
        return nums.length > Arrays.stream(nums)
                .distinct()
                .count();
    }

}
