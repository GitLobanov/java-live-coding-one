package by.lobanov.training.demos.demo20;

import org.apache.logging.log4j.util.PropertySource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestMain {

    public static void main(String[] args) {
        Random randomizer = new Random();
        List<Integer> list = IntStream.generate(() -> randomizer.nextInt(100))
                .filter(n -> n % 2 == 0)
                .distinct()
                .boxed()
                .peek(System.out::println)
                .limit(30)
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(list);
    }
}
