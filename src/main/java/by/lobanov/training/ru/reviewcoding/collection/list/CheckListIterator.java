package by.lobanov.training.ru.reviewcoding.collection.list;

import java.util.*;

public class CheckListIterator {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
        ListIterator<Integer> listIterator = list.listIterator();
        System.out.println(listIterator.previous());
    }
}
