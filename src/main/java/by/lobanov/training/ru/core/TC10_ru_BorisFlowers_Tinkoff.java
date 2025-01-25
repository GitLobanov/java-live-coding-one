package by.lobanov.training.ru.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <br>
 * Формат входных данных
 * Первая строка содержит число n — количество дней, в течение которых Борис планирует покупать букеты.
 * i-я из следующих  строк содержит число ai — количество бурлей, которое есть у Бориса в i-й день.
 * <br>
 * Формат выходных данных
 * Для каждого ai в отдельной строке выведите, сколько бурлей
 * Борис потратит на букет в i-й день, или -1, если он не может купить никакой букет ровно из трех цветов.
 * Input
 * 3
 * 15
 * 67
 * 5
 * Output
 * 14
 * 67
 * -1
 */
public class TC10_ru_BorisFlowers_Tinkoff {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        long[] money = new long[n];
        for (int i = 0; i < n; i++) {
            money[i] = Long.parseLong(bf.readLine());
        }

        for (long ai : money) {
            long res = findMinCost(ai);
            System.out.println(res);
        }
    }

    public static long findMinCost(double moneyHave) {
        TreeMap<Double, Double> priceMap = IntStream.rangeClosed(0, 12)
                .mapToDouble(d -> (double) d)
                .boxed()
                .collect(Collectors.toMap(
                        d -> Math.pow(2, d),
                        d -> d,
                        (existing, replacement) -> existing,
                        TreeMap::new
                ));

        int flowersPack = 3;
        double minCost = 0;
        while (flowersPack > 0) {
            if (moneyHave <= 0) {
                minCost = -1;
                break;
            }

            Double closestPrice = priceMap.floorKey(moneyHave);
            moneyHave = moneyHave - closestPrice;
            minCost = minCost + closestPrice;
            flowersPack--;
        }
        return (long) minCost;
    }
}
