package by.lobanov.training.demos.demo15;

/**
 * Найти уникально число, не используя какие-то структуры данных
 * tags: xsor, unique in array
 */
public class LC20 {

    public static void main(String[] args) {
        int[] nums = {1000, 1000, 2000, 3000, 3000, 4000, 4000, 8000, 8000};
        solutionWithXsor(nums);
        //solutionStupidWay(nums);
    }

    public static void solutionWithXsor (int [] nums) {
        int unique = 0;
        for (int num : nums) {
            unique ^= num;
        }

        System.out.println(unique);
    }

    public static void solutionStupidWay (int [] nums) {
        Integer n = 0;

        for (int i = 0; i < nums.length; i ++) {
            if (n == 0) {
                n = nums[i];
            } else if (n == nums[i]) {
                n = 0;
            }
        }

        System.out.println(n);
    }
}
