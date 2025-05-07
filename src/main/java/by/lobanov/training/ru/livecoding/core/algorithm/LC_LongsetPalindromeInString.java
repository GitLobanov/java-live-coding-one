package by.lobanov.training.ru.livecoding.core.algorithm;

public class LC_LongsetPalindromeInString {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("sout"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("levelbabad"));
        System.out.println(longestPalindrome("levelbabadrotator"));
    }

    private static String longestPalindrome(String s) {
        String longestPalindrome = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String currentWord = String.valueOf(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                currentWord = currentWord.concat(String.valueOf(s.charAt(j)));

                if (isStringPalindrome(currentWord) && longestPalindrome.length() < currentWord.length()) {
                    longestPalindrome = currentWord;
                }
            }
        }

        return longestPalindrome.isEmpty() ? "Not found" : longestPalindrome;
    }

    private static boolean isStringPalindrome(String toCheck) {
        int left = 0;
        int right = toCheck.length() - 1;

        while (left <= right) {
            if (toCheck.charAt(left) != toCheck.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
