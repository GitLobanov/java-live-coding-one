package by.lobanov.training.demos.demo18;

public class BinarySearch {

    /*
Бинарный поиск - дан отсортированный по возрастанию массив чисел, вернуть индекс искомого числа или -1, если этого числа нет.
Пример:
Input: nums = [-1,0,3,5,9,12], target = 9    Output: 4 (индекс)
int[] nums = new int[]{-1,0,3,5,9,12};

Пример 2:
Input: nums = [-1,0,3,5,9,12], target = 2    Output: -1 (т.к. числа 2 нет в массиве)
*/
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 12));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // (10 + 20) / 2 = 15
            // left + (right - left) / 2
            // 10 + (20 - 10) / 2
//            int middle = (left + right) / 2;
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }

        return -1;
    }

}
