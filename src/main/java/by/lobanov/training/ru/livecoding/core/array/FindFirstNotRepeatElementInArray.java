package by.lobanov.training.ru.livecoding.core.array;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/*
Найти первый неповторяющийся элемент в массиве
 */
public class FindFirstNotRepeatElementInArray {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 3, 5, 4};
        int[] nums1 = {2, 3, 1, 4, 5, 2, 3, 5, 4};
        int[] nums2 = {2, 3, 4, 7, 7, 5, 2, 3, 5, 4};
        int[] nums3 = {4, 5, 1, 2, 0, 4, 5, 2};
        System.out.println(findElementByImperative(nums));
        System.out.println(findElementByImperative(nums1));
        System.out.println(findElementByImperative(nums2));
        System.out.println(findElementByImperative(nums3));
    }

    public static int findElementByStream(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(groupingBy(d -> d, LinkedHashMap::new,  counting()))
                .entrySet().stream()
                .filter(k -> k.getValue() == 1)
                .mapToInt(Map.Entry::getKey)
                .findFirst()
                    .orElse(-1);
    }

    public static int findElementByImperative(int[] nums) {
        Map<Integer, Integer> countMap = new LinkedHashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (countMap.get(num) == 1) {
                return num;
            }
        }

        return -1;
    }
}
