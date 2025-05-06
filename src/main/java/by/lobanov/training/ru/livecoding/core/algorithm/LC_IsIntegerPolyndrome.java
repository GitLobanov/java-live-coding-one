package by.lobanov.training.ru.livecoding.core.algorithm;

/**
 * Дано целое число x, вернуть true если x является палиндромом, и false в ином случае.
 */

/**
 * Пример 1:
 * Входные данные: x = 121
 * Выходные данные: true
 * Объяснение: 121 читается как 121 слева направо и справа налево.
 *
 * Пример 2:
 * Входные данные: x = -121
 * Выходные данные: false
 * Объяснение: Слева направо читается как -121.
 * Справа налево превращается в 121-. И поэтому это не является палиндромом.
 *
 * Пример 3:
 * Входные данные: x = 10
 * Выходные данные: false
 * Объяснение: Представляет собой 01 справа налево. И поэтому не является палиндромом.
 */
public class LC_IsIntegerPolyndrome {

    public static void main(String[] args) {
        LC_IsIntegerPolyndrome lc = new LC_IsIntegerPolyndrome();
        System.out.println(lc.isIntegerPalindrome(323));
        System.out.println(lc.isIntegerPalindrome(-323));
        System.out.println(lc.isIntegerPalindrome(3223));
        System.out.println(lc.isIntegerPalindrome(3213));
        System.out.println(lc.isIntegerPalindrome(32113));
    }

    public boolean isIntegerPalindrome(int x) {
        if (x <= 10) return false;
        String str  = String.valueOf(x);
        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
