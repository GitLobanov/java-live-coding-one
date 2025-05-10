package by.lobanov.training.ru.livecoding.core.regex;

public class LC_IsAllLetters {

    public static void main(String[] args) {
        System.out.println(isAllLetters("rotator"));
        System.out.println(isAllLetters("rotator1"));
        System.out.println(isAllLetters("1evel"));
        System.out.println(isAllLetters("ba b ab"));
    }

    private static boolean isAllLetters (String string) {
        return string.matches("[a-zA-Z]+");
    }
}
