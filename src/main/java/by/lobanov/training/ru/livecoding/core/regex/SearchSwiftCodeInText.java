package by.lobanov.training.ru.livecoding.core.regex;

public class SearchSwiftCodeInText {

    /*
    Требования:
    SWIFT-код состоит из 8 или 11 символов.
    Первые 4 символа — буквы (код банка).
    Следующие 2 символа — буквы (код страны).
    Следующие 2 символа — буквы или цифры (код локации).
    Последние 3 символа (опционально) — буквы или цифры (код филиала).
     */
    public static void main(String[] args) {
        System.out.println(validateSwift("DEUTDEFF"));
        System.out.println(validateSwift("DEUTDEFF500"));
        System.out.println(validateSwift("COBADEFFXXX"));

        System.out.println(validateSwift("DEUT123FF")); // неверный формат
        System.out.println(validateSwift("DEUTDEFF5")); // некорректная длина
        System.out.println(validateSwift("DEUTDEFF5!!")); // запрещённые символы
    }

    private static boolean validateSwift (String swift) {
        return swift.matches("^[A-Z]{4}[A-Z]{2}[A-Z\\d]{2}(?:[A-Z\\d]{3})?$");
    }

}
