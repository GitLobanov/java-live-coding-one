package by.lobanov.training.ru.livecoding.core.algorithm;

import java.util.Arrays;

/**
 * Преобразовать отсортированный массив неуникальных чисел вида [1,1,2,2,3,3,6,7]
 * в массив отсортированных по возрастанию уникальных чисел - [1,2,3,6,7,0,0,0]
 */
public class RemoveDuplicatesInSortedArray {

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

    public static void main(String[] args) {
        RemoveDuplicatesInSortedArray remove = new RemoveDuplicatesInSortedArray();
        int [] array = new int[]{1,1,2,2,3,3,6,7};
        remove.removeDuplicates(array);
        System.out.println(Arrays.toString(array));
    }
}
