package by.lobanov.training.ru.livecoding.core.math;

/**
 * Напишите программу, меняющую местами значения двух переменных, без использования третьей переменной.
 */
public class LC_SwapValueBetweenTwoVariablesWithoutThirdValue {

    public static void main(String[] args) {
        simple();
    }

    private static void simple() {
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

    private static void javaXor() {
        // binary of 7=0111
        int a = 7;
        // binary of 8=1000
        int b = 8;
        // swapping using java XOR operator
        // now a is 1111 15 and b is 8
        a = a ^ b;
        //now a is 1111 15 but b is 7 (original value of a)
        b = a ^ b;
        // now a is 8 and b is 7, numbers are swapped
        a = a ^ b;
        System.out.println("a: " + a + " b: " + b);
    }
}
