package by.lobanov.training.demos.demo17;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class LC28 {

    public static void main(String[] args) {

        //o(1)
        //

        List<String> strList = new ArrayList<>();
        Iterator<String> iterator = strList.iterator();

        //
        // String ([8] * 2)

        strList.forEach(
                el -> System.out.println(el)
        );

        while(iterator.hasNext()) {
            iterator.next();
        }

        for (int i = 0; i < strList.size(); i++) {
            strList.get(i);
        }

        strList.forEach(System.out::println);




    }

}
