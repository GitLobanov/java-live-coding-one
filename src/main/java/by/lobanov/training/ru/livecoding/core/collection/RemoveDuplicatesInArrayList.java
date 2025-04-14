package by.lobanov.training.ru.livecoding.core.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicatesInArrayList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Banana");
        list.add("Apple");
        list.add("Apple");
        list.add("Watermelon");
        list.add("Watermelon");

        System.out.println(s1(list));
    }

    private static List<String> s1 (List<String> list){
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    private static List<String> s2 (List<String> list){
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
