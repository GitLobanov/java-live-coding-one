package by.lobanov.training.ru.livecoding.bycompany.hhru.heavy;

/**
 * Расшифровка методом Цезаря
 *
 * Вы разрабатываете программу для расшифровки текстовых сообщений, зашифрованных методом Цезаря.
 * Этот метод подразумевает сдвиг каждой буквы текста на фиксированное количество позиций в алфавите.
 * Например, при сдвиге на 3 позиции буква А становится Г, а Я становится В.
 * Соответственно, при расшифровке нужно двигаться в обратном порядке.
 *
 * Ваша задача — написать функцию, которая принимает на вход зашифрованную по методу Цезаря строку текста и целое число (сдвиг),
 * и возвращает расшифрованную версию. Алфавит уже задан в предкоде.
 *
 * Формат ввода:
 *
 * Входные данные состоят из двух строк:
 * Первая строка содержит произвольный зашифрованный текст (только строчные буквы русского алфавита и пробелы).
 * Вторая строка содержит целое число — величину сдвига (1 ≤ x ≤ 32).
 *
 * Формат вывода:
 * Выходные данные должны состоять из одной строки, содержащей расшифрованный текст. Пробел расшифровывать не нужно.
 * Пример 1
 *
 * Входные данные:
 * бвгдеё
 * 1
 *
 * Выходные данные:
 * абвгде
 *
 * Пример 2
 * Входные данные:
 * дщх ёзтхсх счжшфхл
 * 7
 *
 * Выходные данные:
 * это яблоко красное
 */
public class LC_DecodingByCaesarMethod {

    public static void main(String[] args) {
        System.out.println(decode1("бвгдеё", 1)); // "абвгде"
        System.out.println(decode1("дщх ёзтхсх счжшфхл", 7)); // "это яблоко красное"
        System.out.println(decode1("нбмэшйл йдсбёу г хфувпм", 1)); // "мальчик играет в футбол"
    }

    // Русский алфавит
    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static String decode1(String encryptedText, int shift) {
        StringBuilder result = new StringBuilder();
        int alphabetLength = ALPHABET.length();

        for (char c : encryptedText.toCharArray()) {
            if (c == ' ') {
                result.append(c); // Пробелы остаются неизменными
                continue;
            }

            int currentIndex = ALPHABET.indexOf(c);
            int newIndex = (currentIndex - shift + alphabetLength) % alphabetLength;
            result.append(ALPHABET.charAt(newIndex));
        }
        return result.toString();
    }

    public static String decode2(String encryptedText, int shift) {
        int begin = 1072; // 'а'
        int end = 1104;   // 'я' + 1

        StringBuilder decodedText = new StringBuilder();

        for (char c : encryptedText.toCharArray()) {
            if (c == ' ') {
                decodedText.append(' ');
                continue;
            }

            // Вычисляем позицию символа в алфавите
            int pos = c - begin;

            // Сдвигаем символ влево (расшифровка)
            int shiftedPos = (pos - shift + (end - begin)) % (end - begin);

            // Получаем новый символ
            char newChar = (char) (begin + shiftedPos);

            decodedText.append(newChar);
        }

        return decodedText.toString();
    }
}
