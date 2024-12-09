package by.lobanov.training.december.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class D1_Stream {

    /**
     * <a href="https://habr.com/ru/companies/otus/articles/862134/">Мастерство работы с Java Stream</a>
     */
    public static void main(String[] args) {
        // START PIPELINE
        List<Integer> list1 = Stream.generate(() -> new Random().nextInt(10)).limit(10).toList();
        Stream stream1 = Stream.of("Str1", "Str3");
        Stream.builder().add("Str2").build();
        list1.stream();
        list1.stream().parallel();
        list1.parallelStream();

        // Intermediate Pipeline
        // STATE LESS

        stream1
                .map((str) -> str.toString().replaceAll("Str", "String str"))
                .map(Object::toString)
                .peek((str) -> System.out.println(str));

        stream1
                .flatMap(object -> object.toString().split(""));



        // STATE FULL

        stream1
                .sorted()
                .distinct()
                .skip(1)
                .limit(1);


        // Terminate Pipeline

        boolean anyMatchStr2 = stream1.anyMatch((str) -> str.equals("Str2"));
        stream1.forEach(System.out::println);
        stream1.allMatch((str) -> str.toString().contains("Str"));
        stream1.noneMatch(str -> str.toString().contains("String"));
        long countStrs = stream1.count();
        Optional<String> foundAnyStr = stream1.map(str -> str.toString())
                .findAny();
        Optional<String> gotFirstStr = stream1.findFirst();
        stream1.iterator().forEachRemaining(System.out::println);
        stream1.collect(Collectors.toCollection(ArrayList::new));
        stream1.collect(Collectors.toSet());
        stream1.toList();
        stream1.toArray();
        stream1.collect(Collectors.toList());
        stream1.collect(Collectors.groupingBy(object -> object, Collectors.counting()));


    }

}
