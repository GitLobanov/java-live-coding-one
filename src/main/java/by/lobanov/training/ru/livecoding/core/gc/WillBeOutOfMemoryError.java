package by.lobanov.training.ru.livecoding.core.gc;

import org.apache.tomcat.util.collections.ManagedConcurrentWeakHashMap;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class WillBeOutOfMemoryError {

    static final long GB_IN_BYTES = 1024 * 1024 * 1024; // 1 ГБ = 2³⁰ байт
    static final long THRESHOLD = 4 * GB_IN_BYTES;      // 4 ГБ

    public static void main(String[] args) {
//        s1();
//        s2();
//        s3();
        s4();
//        parallel();
    }

    private static void s1 () {
        for (long i = 0; i < 1_000_000_000_000_000_000L; i++) {
            new Object();
        }
    }


    private static void s2 () {
        for (long i = 0; i < 1_000_000_000L; i++) {
            var o = new Object();
        }
    }

    private static void s3 () {
        Map<Long, Object> innnerMap = new HashMap<>();
        for (long i = 0; i < 1_000_000_000_0L; i++) {
            innnerMap.put(i, new Object());
        }
    }

    /*
    max heap = ram / 4
    min heap = ram / 64
     */
    private static final Map<Long, Object> outerMap = new HashMap<>();
    private static void s4 () {
        for (long i = 0; i < 1_000_000_000_0L; i++) {
            long totalMemory = Runtime.getRuntime().totalMemory();
            long freeMemory = Runtime.getRuntime().freeMemory();
            long usedMemory = totalMemory - freeMemory;
            if (usedMemory >= THRESHOLD) {
                System.out.println("⚠️ Достигнут порог в 4 ГБ!");
                Runtime.getRuntime().gc();
            }
            outerMap.put(i, new Object());
        }
    }

    private static void iterate () {
        Stream.iterate(0, n -> n + 1)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 10)
                .sorted()
                .limit(3)
                .forEach(System.out::println);
    }

    private static void parallel () {
        Map<Long, Object> innnerMap = new HashMap<>();
        LongStream.range(0, 1_000_000_000_0L)
                .parallel()
                .forEach(i -> {
                    innnerMap.put(i, new Object());
                    System.out.println(Thread.currentThread());
                    if (i % 99999L == 0) {
                        System.gc();
                    }
                });
    }
}
