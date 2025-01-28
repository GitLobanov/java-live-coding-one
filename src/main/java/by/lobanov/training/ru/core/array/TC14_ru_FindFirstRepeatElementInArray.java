package by.lobanov.training.ru.core.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

public class TC14_ru_FindFirstRepeatElementInArray {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 3, 5, 4};
        int[] nums1 = {2, 3, 1, 4, 5, 2, 3, 5, 4};
        int[] nums2 = {2, 3, 4, 7, 7, 5, 2, 3, 5, 4};
        System.out.println(findElement(nums));
        System.out.println(findElement(nums1));
        System.out.println(findElement(nums2));
    }

    public static int findElement(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(groupingBy(d -> d, counting()))
                .entrySet().stream()
                .filter(k -> k.getValue() == 1)
                .mapToInt(Map.Entry::getKey)
                .findFirst()
                    .orElse(-1);
    }
}
