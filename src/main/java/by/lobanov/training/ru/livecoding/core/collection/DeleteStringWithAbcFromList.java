package by.lobanov.training.ru.livecoding.core.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
// удалить из коллекции все строки, начинающиеся на абс, без создания новой коллекции и без java 8, без предикатов
public static List<String> foo(List<String> strings) {

}
 */
public class DeleteStringWithAbcFromList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc1");
        list.add("abc9");
        list.add("abc2");
        list.add("abc4");
        list.add("6");
        System.out.println(foo(list));
    }

    public static List<String> foo(List<String> strings) {
//        for (int i = strings.size() - 1; i >= 0; i--) {
//            if (strings.get(i).startsWith("abc")) {
//                strings.remove(i);
//            }
//        }

        // Когда вы удаляете элемент, например, с индексом i, все элементы с индексами, большими i, сдвигаются на одну позицию влево.
        // Однако переменная i увеличивается после каждой итерации цикла,
        // что приводит к тому, что следующий элемент (который сдвигается на текущую позицию i) пропускается.
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).startsWith("abc")) {
                strings.remove(i);
            }
        }

//        Iterator<String> iterator = strings.iterator();
//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            if (item.startsWith("abc")) {
//                iterator.remove();
//            }
//        }

//        here is error
//        Iterator<String> iterator = strings.iterator();
//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            if (item.startsWith("abc")) {
//                strings.remove(item);
//            }
//        }

//        for (String str : strings) {
//            if (str.startsWith("abc")) {
//                strings.remove(str);
//            }
//        }
        return strings;
    }
}


