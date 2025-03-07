package by.lobanov.training.ru.core.livecoding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Удалить из коллекции все строки, начинающиеся с abc, без создания новой коллекции и без java8, без предикаторов
 */
public class LC_ru_RemoveStartsWithAbcFromList {

    public static void main(String[] args) {
        System.out.println(foo(Stream.of("1", "abc2", "3", "abc7").collect(Collectors.toList())));
    }

    public static List<String> foo (List<String> strings) {
        Iterator<String> iterator = strings.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().startsWith("abc")) {
                iterator.remove();
            }
        }

        return strings;
    }
}
