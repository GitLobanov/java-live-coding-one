package by.lobanov.training.en.core.math;

/**
 * Example 1:
 * <br>
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 * <br>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <br>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class TC4_en_PalindromeNumber_LeetCode {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
        System.out.println(anotherIsPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        String strOrigin = String.valueOf(x);
        String strReversed = new StringBuilder(strOrigin).reverse().toString();
        return strReversed.equals(strOrigin);
    }

    public static boolean anotherIsPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int reverse = 0;
        int xcopy = x;

        while (x > 0) {
            reverse = (reverse * 10) + (x % 10);
            x /= 10;
        }

        return reverse == xcopy;
    }
}
