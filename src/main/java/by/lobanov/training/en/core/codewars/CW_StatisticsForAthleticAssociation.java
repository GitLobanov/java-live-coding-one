package by.lobanov.training.en.core.codewars;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.TreeMap;

/*
Range : difference between the lowest and highest values. In {4, 6, 9, 3, 7} the lowest value is 3, and the highest is 9, so the range is 9 − 3 = 6.
Mean or Average : To calculate mean, add together all of the numbers and then divide the sum by the total count of numbers.
Median : The median of a finite list of numbers can be found by arranging all the observations from lowest value to highest value and
picking the middle one (e.g., the median of {3, 3, 5, 9, 11} is 5) when there is an odd number of observations.
If there is an even number of observations, then there is no single middle value;
the median is then defined to be the mean of the two middle values (the median of {3, 5, 6, 9} is (5 + 6) / 2 = 5.5).
 */
public class CW_StatisticsForAthleticAssociation {

    public static void main(String[] args) {
//        System.out.println(stat("01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17"));
        System.out.println(stat("02|15|59, 2|47|16, 02|17|20, 2|32|34, 2|17|17, 2|22|00, 2|31|41"));
    }

    public static String stat(String strg) {
        String[] strStats = strg.split(", ");
        TreeMap<LocalTime, String> timeStats = new TreeMap<>();
        for (int i = 0; i < strStats.length; i++) {
            int[] stat = Arrays.stream(strStats[i].split("\\|")).mapToInt(Integer::parseInt).toArray();
            LocalTime time = LocalTime.of(stat[0], stat[1], stat[2]);
            timeStats.put(time, strStats[i]);
        }

        String range = timeStats.lastKey().minusNanos(timeStats.firstKey().toNanoOfDay()).toString();
        long averageInNano = timeStats.keySet().stream()
                .mapToLong(LocalTime::toNanoOfDay)
                .sum() / timeStats.size();
        LocalTime averageInTime = LocalTime.ofNanoOfDay(averageInNano).truncatedTo(ChronoUnit.SECONDS);
        String average = averageInTime.toString();
        double medianInDouble = timeStats.size() / 2.0;
        String median = medianInDouble % 2 == 0 ? LocalTime.ofNanoOfDay(timeStats.keySet().stream()
                .skip((long) (medianInDouble - 1))
                .limit(2)
                .mapToLong(LocalTime::toNanoOfDay)
                .sum()).truncatedTo(ChronoUnit.SECONDS).toString() : timeStats.keySet().stream()
                .skip((long) Math.floor(medianInDouble))
                .limit(1)
                .findFirst().orElse(LocalTime.ofNanoOfDay(0l)).truncatedTo(ChronoUnit.SECONDS).toString();

        if (median.split(":").length < 3) median = median.concat(":00");

        return String.format("Range: %s Average: %s Median: %s", range.replaceAll(":", "|"),
                average.replaceAll(":", "|"),
                median.replaceAll(":", "|"));
    }
}
