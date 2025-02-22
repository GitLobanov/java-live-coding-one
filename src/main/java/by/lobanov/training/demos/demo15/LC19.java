package by.lobanov.training.demos.demo15;

public class LC19 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("level"));
    }

    public static boolean isPalindrome(String text) {
        String [] array = text.split("");
        String strReverse = "";

        for (int i = (array.length - 1); i >= 0; i--) {
            strReverse = strReverse + array[i];
        }

        return strReverse.equals(text);
    }
}
