package by.lobanov.training.ru.livecoding.core.bycompany.tinkoff.math;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <br>Формат входных данных
 * В первой строке находится число 2 < n <= 1000 — количество учеников в шеренге.
 * В следующей строке находится a(i) натуральных чисел a(i) — рост учеников.
 * <br>Формат выходных данных
 * В единственной строке выведите i и j — номера элементов, которые нужно поменять местами, чтобы добиться заданного условия. Если ответов несколько — разрешается вывести любой.
 * Если не существует способа поменять два элемента местами — выведите -1 -1.
 * <br> Пример 1
 * Input:
 * 4
 * 2 1 4 6
 * Output: -1 -1
 * <br> Пример 2
 * Input:
 * 2
 * 2 1
 * Output:
 * 1 2
 */
public class TC6_ru_TeamSortingChecker_Tinkoff {

    public static void main(String[] args) {
//        System.out.println(getSwappedStudents(4 , new int[]{2,1,4,6})); // -1 -1
//        System.out.println(getSwappedStudents(2 , new int[]{1,2})); // -1 -1
//        System.out.println(getSwappedStudents(2 , new int[]{2,1})); // 1 2
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] heights = Arrays.stream(sc.next().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(
                getSwappedStudents(n, heights)
        );
    }

    public static String getSwappedStudents (int n, int [] height) {
        for (int i = 0; i < height.length; i++) {
            for (int j = 1; j < height.length; j++) {
                boolean left = height[i] % 2 == 0;
                boolean right = height[j] % 2 == 0;
                if (left && !right) return (i+1) + " " + (j+1);
            }
        }
        return "-1 -1";
    }
}
