package by.lobanov.training.ru.review.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ArrayListFromArraysIterator {

    public static void main(String[] args) {
        v1();
//        v2();
//        v3();
    }

    private static void v1 () {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ListIterator<Integer> it = list.listIterator();

        while (it.hasNext()) {
            Integer next = it.next();

            if (next == 2) {
                it.remove();
            }
        }
    }

    private static void v2 () {
        List<Integer> list = List.of(1,2,3);
        ListIterator<Integer> it = list.listIterator();

        while (it.hasNext()) {
            Integer next = it.next();

            if (next == 2) {
                it.remove();
            }
        }

        System.out.println();
    }

    private static void v3 () {
        Integer[] array = new Integer[] { 1, 2, 3 };
        List<Integer> list = Arrays.asList(array);
        ListIterator<Integer> it = list.listIterator();

        while (it.hasNext()) {
            Integer next = it.next();

            if (next == 2) {
                it.remove();
            }
        }
    }
}
