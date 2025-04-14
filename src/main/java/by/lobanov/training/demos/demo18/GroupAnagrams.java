package by.lobanov.training.demos.demo18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {

    /*
Сгруппировать анаграмы
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Input: strs = [""]
Output: [[""]]

Input: strs = ["a"]
Output: [["a"]]
*/

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String sorted = str.chars()
                    .sorted()
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(""));

            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(str);
        }

        return map.values().stream().toList();
    }

}
