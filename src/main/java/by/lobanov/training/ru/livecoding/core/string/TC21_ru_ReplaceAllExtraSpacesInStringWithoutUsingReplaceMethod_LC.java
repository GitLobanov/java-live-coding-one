package by.lobanov.training.ru.livecoding.core.string;

// Напишите программу для удаления всех (лишних) пробелов из строки без использования replace().
public class TC21_ru_ReplaceAllExtraSpacesInStringWithoutUsingReplaceMethod_LC {

    public static void main(String[] args) {
        String str="   Hello   world   !   ";
        System.out.println(replaceSpaces(str));
    }

    private static String replaceSpaces (String sentence) {
        StringBuilder newString = new StringBuilder();
        String nullable = " ";
        sentence.trim();
        String[] array = sentence.split("");
        for (int i = 0; i < array.length-1; i++) {
            if (!(array[i+1].equals(nullable) && array[i].equals(nullable))) {
                newString.append(array[i]);
            }
        }

        return newString.toString();
    }
}
