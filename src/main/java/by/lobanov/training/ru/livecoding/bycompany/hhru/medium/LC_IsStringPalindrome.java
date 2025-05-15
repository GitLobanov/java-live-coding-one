package by.lobanov.training.ru.livecoding.bycompany.hhru.medium;

public class LC_IsStringPalindrome {

    public static void main(String[] args) {
        System.out.println(checkPalindrome("Тут как тут"));
        System.out.println(checkPalindrome("Программист"));
    }

    private static String checkPalindrome (String input) {
        String isTrue = "Палиндром";
        String isFalse = "Не палиндром";

        input = input.toLowerCase().replaceAll("\\s", "");
        String reversed = new StringBuilder(input).reverse().toString();
        if (reversed.equals(input)) {
            return isTrue;
        } else {
            return isFalse;
        }
    }
}
