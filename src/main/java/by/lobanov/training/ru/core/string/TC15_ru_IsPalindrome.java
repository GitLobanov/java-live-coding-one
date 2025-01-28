package by.lobanov.training.ru.core.string;

public class TC15_ru_IsPalindrome {

    public static void main(String[] args) {
        String str = "A man a plan a canal Panama";
        System.out.println("Is palindrome: " + isPalindrome(str));
        System.out.println("Is palindrome: " + isPalindromeMy(str));
    }

    public static boolean isPalindrome(String str) {
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
    public static boolean isPalindromeMy(String strOriginal) {
        strOriginal = strOriginal.replaceAll("\\s+", "").toLowerCase();

        String strReversed = new StringBuilder(strOriginal).reverse().toString();
        return strReversed.equals(strOriginal);
    }
}
