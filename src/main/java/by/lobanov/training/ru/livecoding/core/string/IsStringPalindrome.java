package by.lobanov.training.ru.livecoding.core.string;

public class IsStringPalindrome {

    public static void main(String[] args) {
        String str = "A man a plan a canal Panama";
        System.out.println("Is palindrome: " + isPalindromeTwoPointers(str));
        System.out.println("Is palindrome: " + isPalindromeByStringBuilder(str));
    }

    public static boolean isPalindromeTwoPointers(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // часто запрещают использовать
    public static boolean isPalindromeByStringBuilder(String strOriginal) {
        strOriginal = strOriginal.replaceAll("\\s+", "").toLowerCase();

        String strReversed = new StringBuilder(strOriginal).reverse().toString();
        return strReversed.equals(strOriginal);
    }
}
