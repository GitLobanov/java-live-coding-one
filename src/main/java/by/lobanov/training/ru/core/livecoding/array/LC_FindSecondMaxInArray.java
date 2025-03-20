package by.lobanov.training.ru.core.livecoding.array;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Дан массив уникальных целых чисел найти
 * второе максимальное число в массиве.
 * Например
 * [3,9,4,0,8,1) Ответ 8
 * [1000,7,12,0,5,3) Ответ 12
 */
public class LC_FindSecondMaxInArray {

    public static void main(String[] args) {
        System.out.println(findSecondMaxTreeSet(new int[]{3, 9, 4, 0, 8, 1}));
        System.out.println(findSecondMaxTreeSet(new int[]{1000, 7, 12, 0, 5, 3}));
        System.out.println(findSecondMaxSimple(new int[]{3, 9, 4, 0, 8, 1}));
        System.out.println(findSecondMaxSimple(new int[]{1000, 7, 12, 0, 5, 3}));
    }

    public static int findSecondMaxTreeSet(int[] array) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        Arrays.stream(array).forEach(treeSet::add);

        Integer max = treeSet.floor(Integer.MAX_VALUE);
        Integer secondMax = treeSet.lower(max);

        return secondMax == null ? 0 : secondMax;
    }

    public static int findSecondMaxSimple(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }

        return secondMax;
    }
}
