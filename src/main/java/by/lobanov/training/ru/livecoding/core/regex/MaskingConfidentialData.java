package by.lobanov.training.ru.livecoding.core.regex;

/*
Найти номера счетов в формате IBAN (например, DE91 1000 0000 0123 4567 89).
Заменить все цифры, кроме последних 4, на *.
Пробелы должны сохраняться.
 */
public class MaskingConfidentialData {

    public static void main(String[] args) {
        System.out.println(maskingDigitsInIban("IBAN: DE91 1000 0000 0123 4567 89, сумма: 1000"));
    }

    private static String maskingDigitsInIban(String text) {
        return text.replaceAll("[\\d\\s?]{20}", "** **** **** **** **");
    }
}
