package by.lobanov.training.en.core.codewars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class CW_ScrollingText {

    /*
    Your task is to complete the function which takes a string,
    and returns an array with all possible rotations of the given string, in uppercase.
    scrollingText("codewars") - should return:
    [ "CODEWARS",
      "ODEWARSC",
      "DEWARSCO",
      "EWARSCOD",
      "WARSCODE",
      "ARSCODEW"
      "RSCODEWA",
      "SCODEWAR" ]
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(scrollingTextInStream("codewars")));
    }

    private static String[] scrollingText (String text) {
        int textCapacity = text.length();
        String[] scrolledArray = new String[textCapacity];
        String scrolledText = text.toUpperCase();

        for (int i = 0; i < textCapacity; i++) {
            scrolledArray[i] = scrolledText;
            scrolledText = scrolledText.substring(1).concat(scrolledText.substring(0,1));
        }
        return scrolledArray;
    }

    private static String[] scrollingTextInStream (String text) {
        String textUpperCase = text.toUpperCase();
        return IntStream.range(0, text.length())
                .mapToObj(i -> textUpperCase.substring(i).concat(textUpperCase.substring(0,i)))
                .toArray(String[]::new);
    }
}
