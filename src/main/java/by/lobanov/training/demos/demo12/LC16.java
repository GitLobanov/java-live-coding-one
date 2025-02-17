package by.lobanov.training.demos.demo12;

/**
 * Перемножить числа в строке на заданное число
 */
public class LC16 {

    public static void main(String[] args) {
        System.out.println(12345 * 9);
        System.out.println(test("12345",9));
    }

    private static String test(String stringNum, int digit) {
        char[] digits = stringNum.toCharArray();
        StringBuilder result = new StringBuilder();
        int firstDigit = 0;
        for (int i = digits.length - 1; i >= 0;i--){
            char charDigit = digits[i];
            int numericValue = Character.getNumericValue(charDigit);
            int pr = numericValue * digit + firstDigit;
            int lastDigit = pr % 10;
            firstDigit = pr/10;
            result.append(lastDigit);
        }
        if (firstDigit != 0) {
            result.append(firstDigit);
        }
        return result.reverse().toString();

    }
}
