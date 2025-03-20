package by.lobanov.training.ru.core.livecoding.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Дан массив целых чисел, вернуть индексы двух
 * чисел, сумма которых равна заданному числу.
 * Вы не можете использовать один и тот же элемент дважды.
 * Пример:
 * Given nums - [2, 7, 11, 15], target - 9.
 * The output should be [0, 1].
 * Because nums[0]+nums[1] 2+7=9.
 */
public class LC_FindTwoSumInArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTwoSum(new int[]{2, 1, 4, 2, 6}, 6)));
    }

    private static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{};
    }
}
