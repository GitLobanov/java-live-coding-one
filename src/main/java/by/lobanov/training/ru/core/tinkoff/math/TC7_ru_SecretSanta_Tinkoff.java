package by.lobanov.training.ru.core.tinkoff.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Формат входных данных
 * В первой строке находится натуральное число n — количество школьников.
 * В следующей строке находится n натуральных чисел — ученик, который достался Тайному Санте с номером 1 < i < n.
 * <br>
 * Формат выходных данных
 * В первой строке выведите два числа 1 <= x, y <= n, x != y — номер ученика (x), которому нужно изменить число, и новое значение (y).
 * Должно выполняться условие a(x) != y. Если ответов несколько — выведите любой.
 * Если сделать это невозможно — выведите -1 -1
 */
public class TC7_ru_SecretSanta_Tinkoff {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int amountStudents = sc.nextInt();
        int [] givePresentTo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getChangedSendingToKid(amountStudents, givePresentTo));
    }

    public static String getChangedSendingToKid (int amountStudents, int [] givePresentTo) {
        String res = "-1 -1";
        int needChanges = 0;
        for (int i = 0; i < amountStudents; i++) {
            int expectedStudent = ((i + 1) == amountStudents) ? 1 : (i + 2);
            if (givePresentTo[i] != expectedStudent) {
                givePresentTo[i] = expectedStudent;
                res = (i + 1) + " " + expectedStudent;
                needChanges++;
            }
            if (needChanges > 1)  {
                res = "-1 -1";
                break;
            }
        }
        return res;
    }
}
