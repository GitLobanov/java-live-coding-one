package by.lobanov.training.demos.demo18;

import java.util.Arrays;

public class ArraysSetAll {

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3};

        Arrays.setAll(arr, i -> arr[i] + 2);

        System.out.println(Arrays.toString(arr));
    }
}
