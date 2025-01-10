package by.lobanov.training.demos.demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableCollections {

    public static void main(String[] args) {
        // Различия между Collections.unmodifiable... и List.of()/Set.of() и их применение.
        List<String> simplList = new ArrayList<>();
        simplList.add("object");

        List<String> list1 = List.copyOf(simplList);
        System.out.println("unmodifiableList before: " + list1);
        simplList.add("newObject");
        System.out.println("unmodifiableList after: " + list1);

        List<String> list2 = Collections.unmodifiableList(simplList);
        System.out.println("unmodifiableList before: " + list2);
        simplList.add("newObject2");
        System.out.println("unmodifiableList after: " + list2);
    }
}
