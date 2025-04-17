package by.lobanov.training.ru.livecoding.core.regex;

public class MaskingConfidentialData {

    public static void main(String[] args) {
        // "IBAN: DE91 1000 0000 0123 4567 89, сумма: 1000"
        // (?<=\b[A-Z]{2}\d{2}\s(?:\d{4}\s?){3})\d{4}\s\d{4}(?=\s\d{2}\b)
    }
}
