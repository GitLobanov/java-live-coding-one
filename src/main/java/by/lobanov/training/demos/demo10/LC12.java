package by.lobanov.training.demos.demo10;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LC12 {

    public static void main(String[] args) {

//        IntStream.range(0,10)
//                .boxed()
//                .map(i -> {
//                    String word;
//                    try {
//                        word = "word";
//                    } catch (Exception e) {
//                        System.out.println("error in parsing: " + e.getMessage());
//                    }
//                    return word;
//                })
//                .filter(word -> !word.isBlank())
//                .limit(10)
//                .forEach(System.out::println);

//        foo();

        //что выведет следующий код
        Stream.of(0, 3, 0, 0, 5)
                .peek(x -> System.out.format("before distinct: %d%n", x))
                .distinct()
                .peek(x -> System.out.format("after distinct: %d%n", x))
                .map(x -> x * x)
                .forEach(x -> System.out.format("after map: %d%n", x));

        // 0 0 0 3 3 9 0 0 5 5 25
    }

    static void foo() {
        String m = "Hello";
        System.out.print(m);
        bar(m);
        System.out.print(m);
    }
    // Hello Hello World!

    static void bar(String m) {
        m += " World!";
    }


}
