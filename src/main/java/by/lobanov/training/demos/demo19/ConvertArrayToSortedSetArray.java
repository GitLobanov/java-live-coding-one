package by.lobanov.training.demos.demo19;

import java.util.Arrays;

public class ConvertArrayToSortedSetArray {

    /**
     * Преобразовать отсортированный массив неуникальных чисел вида [1,1,2,2,3,3,6,7]
     * в массив отсортированных по возрастанию уникальных чисел - [1,2,3,6,7,_,_,_]
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(s1(new int[]{1, 1, 2, 2, 3, 3, 3, 6, 7})));
    }

    private static int[] s1(int[] array) {
        if (array.length == 0) {
            return array;
        }

        int uniqueIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[uniqueIndex] != array[i]) {
                uniqueIndex++;
                array[uniqueIndex] = array[i];
            }
        }

//        for (int i = uniqueIndex + 1; i < array.length; i++) {
//            array[i] = 0;
//        }

        return array;
    }

}
