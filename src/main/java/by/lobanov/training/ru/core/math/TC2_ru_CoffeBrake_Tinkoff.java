package by.lobanov.training.ru.core.math;

import java.util.Scanner;

/**
 * Ваня принес на кухню рулет, который он хочет разделить с коллегами. Для этого он хочет разрезать рулет на  равных частей.
 * Разумеется, рулет можно резать только поперек.
 * Соотвественно, Костя сделает разрез ножом через равные промежутки.
 * <br/>
 * По возвращению с кофе-брейка Ваня задумался — а можно ли было обойтись меньшим числом движений,
 * будь нож Вани бесконечно длинным (иначе говоря, если он мог бы сделать сколько угодно разрезов за раз, если эти разрезы лежат на одной прямой)?
 * Считается, что места для разрезов намечены заранее, и все разрезы делаются с ювелирной точностью.
 * Оказывается, что можно. Например, если Ваня хотел бы разделить рулет на части,
 * он мог бы обойтись двумя разрезами — сначала он разделил бы рулет на две половинки, а потом совместил бы две половинки и разрезал обе пополам одновременно.
 * Вам дано число, требуется сказать, каким минимальным числом разрезов можно обойтись.
 * <br/>
 * Пример 1
 * 6 3
 * Приме 2
 * 5 3
 */
public class TC2_ru_CoffeBrake_Tinkoff {

    public static void main(String[] args) {
        System.out.println(calculateNumberOfCutsV1(new Scanner(System.in).nextInt()));
        System.out.println(calculateNumberOfCutsV2(new Scanner(System.in).nextInt()));
    }

    public static int calculateNumberOfCutsV1 (int n) {
        int cuts = (int) Math.ceil((double) n / 2);
        return cuts;
    }

    public static int calculateNumberOfCutsV2 (int n) {
        int halves = 1;
        int cuts = 0;
        while (halves <= n) {
            halves += 2;
            cuts += 1;
        }
        return cuts;
    }
}


