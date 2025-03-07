package by.lobanov.training.ru.review;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LC12 {

    public static void main(String[] args) {

//        foo();

        //что выведет следующий код
        Stream.of(0, 3, 0, 0, 5)
                .peek(x -> System.out.format("before distinct: %d%n", x))
                .distinct()
                .peek(x -> System.out.format("after distinct: %d%n", x))
                .map(x -> x * x)
                .forEach(x -> System.out.format("after map: %d%n", x));

        //
    }

    static void foo() {
        String m = "Hello";
        System.out.print(m);
        bar(m);
        System.out.print(m);
    }
    //

    static void bar(String m) {
        m += " World!";
    }


}
