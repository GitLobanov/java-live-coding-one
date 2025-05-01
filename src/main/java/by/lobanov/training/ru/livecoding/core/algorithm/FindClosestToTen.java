package by.lobanov.training.ru.livecoding.core.algorithm;


import java.util.TreeSet;

public class FindClosestToTen {

    public static void main(String[] args) {
        System.out.println(findClosestToTen(new int[]{-15, -35, 200, 29, 78}));
    }

    private static int findClosestToTen(int[] array) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : array) {
            treeSet.add(num);
        }
        int digitSearched = 10;

        return treeSet.floor(digitSearched);
    }
}
