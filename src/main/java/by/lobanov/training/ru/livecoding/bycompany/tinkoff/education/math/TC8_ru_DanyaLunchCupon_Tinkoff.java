package by.lobanov.training.ru.livecoding.bycompany.tinkoff.education.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Формат входных данных
 * В первой строке дается натуральное число
 * В каждой из n строк записана стоимость обеда в каждой из дней (неотрицательное целое число, не больше, чем 300).
 * <br>
 * Формат выходных данных
 * В первой строке выдайте минимально возможную суммарную стоимость обедов.
 * <br>
 * Пример
 * <pre>
 *     Input   Output
 *     5       235
 *     35
 *     40
 *     101
 *     59
 *     63
 * </pre>
 */
public class TC8_ru_DanyaLunchCupon_Tinkoff {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String lunch = "";
        lunch = IntStream.rangeClosed(1, n)
                .mapToObj(d -> {
                    try {
                        return bf.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.joining(" "));

        int[] lunchPays = Arrays.stream(lunch.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(calculateNeedMoneyForLunch(lunchPays));
    }

    public static int calculateNeedMoneyForLunch(int[] lunchPays) {
        int cuponRequirements = 100;
        int payd = 0;

        for (int i = 0; i < lunchPays.length; i++) {
            payd = payd + lunchPays[i];
            if (payd >= cuponRequirements) {
                lunchPays[lunchPays.length - 1] = 0;
            }
        }

        return payd;
    }
}
