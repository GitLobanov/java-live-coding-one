package by.lobanov.training.ru.review.core;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementDifference {

    public static void main(String[] args) {
        Integer a = 0;
        int b = 0;
        AtomicInteger c = new AtomicInteger(0);
        String d = "0";
        increment(a);
        increment(b);
        increment(c);
        increment(d);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    public static void increment(Integer a) {
        ++a;
    }

    public static void increment(int b) {
        ++b;
    }

    public static void increment(AtomicInteger c) {
        c.incrementAndGet();
    }

    public static void increment(String d) {
        d = String.valueOf(
                Integer.parseInt(d) + 1
        );
    }

}
