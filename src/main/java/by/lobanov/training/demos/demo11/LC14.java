package by.lobanov.training.demos.demo11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 29.01.2025
 */
public class LC14 {

    public static void main(String[] args) {
        System.out.println(reverse(120));
        System.out.println(reverse(351));
        System.out.println(reverse(400003010));
    }
    public static int reverse(int i){
        StringBuilder number = new StringBuilder(String.valueOf(Math.abs(i)));
        return Integer.parseInt(number.reverse().toString());
    }

    // перевернуть ключ и валуе
    public static void flipValuteAndKey () {
        Map<Integer, List<Long>> input = new HashMap<>();
        input.put(1, Arrays.asList(0l, 1l, 2l));
        input.put(2, Arrays.asList(3l, 4l));

        Map<Long, Integer> output = input.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream().map(value -> new long []{entry.getKey(), value}))
                .collect(Collectors.toMap(array -> array[1], array -> (int) array[0]));

        System.out.println(output);// 0=1, 1=1, 2=1, 3=2, 4=2
    }

//    public static void flipValuteAndKey () {
//        Map<Integer, List<Long>> input = new HashMap<>();
//        input.put(1, Arrays.asList(0l, 1l, 2l));
//        input.put(2, Arrays.asList(3l, 4l));
//
//        Map<Long, Integer> output = input.entrySet().stream()
//                .flatMap(entry -> entry.getValue().stream().map(value -> Map.entry(entry.getKey(), value))))
//                .collect(Collectors.toMap(array -> array[1], array -> (int) array[0]));
//
//        System.out.println(output);// 0=1, 1=1, 2=1, 3=2, 4=2
//    }
}
