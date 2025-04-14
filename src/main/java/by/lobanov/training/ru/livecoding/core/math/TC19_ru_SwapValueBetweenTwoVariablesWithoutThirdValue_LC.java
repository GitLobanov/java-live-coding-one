package by.lobanov.training.ru.livecoding.core.math;

/**
 * Напишите программу, меняющую местами значения двух переменных, без использования третьей переменной.
 */
public class TC19_ru_SwapValueBetweenTwoVariablesWithoutThirdValue_LC {

    public static void main(String[] args) {
        int a = 3;
        int b = 7;

        // first variant
        a = b - a; // 4
        b = b - a; // 3
        a = a + b; // 7

        // second variant
        // a = a + b; // 10
        // b = a - b; // 3
        // a = a - b; // 7

        System.out.println(a == 7 && b == 3);
    }
}
