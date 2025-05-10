package by.lobanov.training.ru.livecoding.core.algorithm;


import java.util.Arrays;
import java.util.TreeSet;

/*
Написать метод поиска в массиве ближайшего к 10 числа
*/
public class LC_FindClosestToTen {

    public static void main(String[] args) {
        System.out.println(findClosestToTenByStructure(new int[]{-15, -35, 200, 29, 78}));  // -15
        System.out.println(findClosestToTenByStructure(new int[]{9, 12}));                  // 9
        System.out.println(findClosestToTenByStructure(new int[]{10, 11, 9}));              // 10
        System.out.println(findClosestToTenByStructure(new int[]{}));                       // 0
        System.out.println("-".repeat(10));
        System.out.println(findClosestToTenStream(new int[]{-15, -35, 200, 29, 78}));  // -15
        System.out.println(findClosestToTenStream(new int[]{9, 12}));                  // 9
        System.out.println(findClosestToTenStream(new int[]{10, 11, 9}));              // 10
        System.out.println(findClosestToTenStream(new int[]{}));                       // 0
        System.out.println("-".repeat(10));
        System.out.println(findClosestToTenByImperative(new int[]{-15, -35, 200, 29, 78}));  // -15
        System.out.println(findClosestToTenByImperative(new int[]{9, 12}));                  // 9
        System.out.println(findClosestToTenByImperative(new int[]{10, 11, 9}));              // 10
        System.out.println(findClosestToTenByImperative(new int[]{}));                       // 0
    }

    /**
     * Используя возможности структур данных
     */
    private static int findClosestToTenByStructure(int[] array) {
        if (array == null || array.length == 0) return 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : array) {
            treeSet.add(num);
        }
        int digitSearched = 10;

        Integer floor = treeSet.floor(digitSearched); // <= 10
        Integer ceiling = treeSet.ceiling(digitSearched); // 10 <=

        if (floor == null) return ceiling != null ? ceiling : 0;
        if (ceiling == null) return floor;

        int floorDiff = Math.abs(floor - digitSearched);
        int ceilingDiff = Math.abs(ceiling - digitSearched);

        return floorDiff <= ceilingDiff ? floor : ceiling;
    }

    /**
     * Используя возможности стримов
     */
    private static int findClosestToTenStream(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .reduce((a, b) -> Math.abs(a - 10) <= Math.abs(b - 10) ? a : b)
                .orElse(0);
    }


    /**
     * Без стримов, дополнительных структур
     */
    private static int findClosestToTenByImperative(int[] array) {
        if (array == null || array.length == 0) return 0;
        int target = 10;
        int closetElement = array[0];
        int minDistance = Math.abs(closetElement - target);

        for (int i = 1; i < array.length; i++) {
            int currentDistance = Math.abs(array[i] - target);
            if (currentDistance <= minDistance) {
                minDistance = Math.abs(array[i]);
                closetElement = array[i];
            }
        }
        return closetElement;
    }

}
