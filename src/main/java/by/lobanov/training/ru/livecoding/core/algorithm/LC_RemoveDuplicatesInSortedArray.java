package by.lobanov.training.ru.livecoding.core.algorithm;

import java.util.Arrays;

/**
 * Преобразовать отсортированный массив неуникальных чисел вида [1,1,2,2,3,3,6,7]
 * в массив отсортированных по возрастанию уникальных чисел - [1,2,3,6,7,0,0,0]
 *
 * - без использования коллекций и стримов
 */
public class LC_RemoveDuplicatesInSortedArray {

    public void removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }

        int count = 1;
        int previous = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[previous]){
                nums[count++] = nums[i];
                previous = i;
            }
        }

        for(int j = count; j < nums.length; j++){
            nums[j] = 0;
        }
    }

    public void removeDuplicatesWhile(int[] nums) {
        // счет уникальных
        // счет неуникальных

        int iUnique = 1;
        int iNotUnique = 1;
        int previous = 0;

        while (iNotUnique < nums.length) {
            if (nums[previous] != nums[iNotUnique]) {
                nums[iUnique++] = nums[iNotUnique];
                previous = iNotUnique;
            }

            iNotUnique++;
        }

        for(int j = iUnique; j < nums.length; j++){
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        LC_RemoveDuplicatesInSortedArray remove = new LC_RemoveDuplicatesInSortedArray();
        int [] array1 = new int[]{1,1,2,2,3,3,6,7};
        int [] array2 = new int[]{1,1,2,2,3,3,6,7};
        remove.removeDuplicates(array1);
        remove.removeDuplicatesWhile(array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }
}
