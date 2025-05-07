package by.lobanov.training.ru.livecoding.core.algorithm.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class LC_BubbleSort {

    private static Random random = new Random();

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 56, 13, 721, 0};
        System.out.println(String.format("Was : %s", Arrays.toString(arr)));
        System.out.println(String.format("Sorted array : %s", Arrays.toString(sort(arr))));
    }

    public static int[] sort(int[] arr) {
        int[] nArr = Arrays.copyOf(arr, arr.length);
        int n = nArr.length - 1;
        boolean swapped;

        for (int i = 0; i < n; i++) {
            // нужно отсекать пошагово правую часть, считая ее уже отсортированной
            swapped = false;
            for (int j = 0; j < n - i; j++) {
                if (nArr[j] > nArr[j + 1]) {
                    int temp = nArr[j];
                    nArr[j] = nArr[j + 1];
                    nArr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
        return nArr;
    }

    private static void checkDifficalty () {
        int[] arr = IntStream.generate(() -> random.nextInt(200)).limit(100_000).toArray();
        System.out.println(System.currentTimeMillis());
        sort(arr);
//        Arrays.sort(arr);
        System.out.println(System.currentTimeMillis());
    }
}
