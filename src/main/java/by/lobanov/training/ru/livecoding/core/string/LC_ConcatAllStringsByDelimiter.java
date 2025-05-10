package by.lobanov.training.ru.livecoding.core.string;

/**
 * Объеденить слова в одну строку с делиметром
 */
public class LC_ConcatAllStringsByDelimiter {

    public static void main(String[] args) {
        System.out.println(concatAll("-", "Goodbye", "Java", "!"));
    }

    public static String concatAll (String delimiter, String... strings) {
        return String.join(delimiter, strings);
    }
}
