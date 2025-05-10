package by.lobanov.training.ru.livecoding.core.algorithm;

import lombok.val;

import java.util.HashMap;
import java.util.Map;

public class LC_SummaryBySymbols {

    public static void main(String[] args) {
        System.out.println(getSummary("rotator"));
        System.out.println(getSummary("level"));
    }

    private static String getSummary (String string) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : string.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        val list = map.entrySet().stream().map(entry -> entry.getKey() + "-" + entry.getValue()).toList();
        return String.join(", ", list);
    }
}
