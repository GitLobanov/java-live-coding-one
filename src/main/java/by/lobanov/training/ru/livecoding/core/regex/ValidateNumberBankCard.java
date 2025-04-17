package by.lobanov.training.ru.livecoding.core.regex;

/*
Валидировать номер банковской карты
Валидно:
"1234567890123456"
"1234-5678-9012-3456"
"1234 5678 9012 3456"
 Невалидно:
"1234-5678-9012-345" // меньше 16 цифр
"1234 5678 9012 3456 7890" // больше 16 цифр
"1234_5678_9012_3456" // неверный разделитель
 */
public class ValidateNumberBankCard {

    public static void main(String[] args) {
        // have to true
        System.out.println(validateNumber("1234567890123456"));
        System.out.println(validateNumber("1234-5678-9012-3456"));
        System.out.println(validateNumber("1234 5678 9012 3456"));

        // have to false
        System.out.println(validateNumber("1234-5678-9012-345"));
        System.out.println(validateNumber("1234 5678 9012 3456 7890"));
        System.out.println(validateNumber("1234_5678_9012_3456"));
    }

    private static boolean validateNumber (String number) {
        String regexAlt1 = "^(?:\\d{4}[ -]?){3}\\d{4}$";
        String regexAlt2 = "^(\\d{4}[-|\\s]?\\d{4}[-|\\s]?\\d{4}[-|\\s]?\\d{4})$";
        return number.matches(regexAlt2);
    }
}
