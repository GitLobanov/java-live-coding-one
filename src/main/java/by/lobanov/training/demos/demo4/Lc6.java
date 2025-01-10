package by.lobanov.training.demos.demo4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Lc6 {

    // Какой будет вывод?

//Stream.of(1,2,3,4)
//        .filter(i -> i % 2 == 0);
//        .peek(sout);
//
//===============================================================================
//// Определить все ли числа в стриме положительные
//
//    List<Integer> numbers = Arrays.asList(1,2,3,4,5);
//
//    numbers.stream.
//      .allMatch(number -> number > 0)
//
//===============================================================================
//// Получить список городов, начинающихся с "A", в UpperCase и отсортированном порядке
//
//    List<String> towns = Arrays.asList("Москва", "Архангельск", "Астрахань", "Минск", "Антверпен");
//
//towns.stream()
//        .filter(word -> word.startsWith("A"))
//            .map(word -> word.toUpperCase())
//            .sorted()
//    .toList()
//
//===============================================================================
//// Что будет выведено
//
//    // Задача 1
//    public static void task1() {
//        Stream.of("d2", "a2", "b1", "b3", "c", "b1")
//                .map(s -> {
//                    System.out.println("map: " + s);
//                    return s.toUpperCase();
//                })
//                .distinct()
//                .anyMatch(s -> {
//                    System.out.println("anyMatch: " + s);
//                    return s.startsWith("A2");
//                });
//    }
//    // d2 D2 a2 A2
//    // d2 a2 b1 b3 c A2
//    // d2 D2 a2 A2
//
//    // Задача 2
//    public static void task2() {
//        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5)
//                .filter(i -> i % 2 != 0);
//
//        System.out.println(stream.reduce(5, Integer::sum));
//
//        // 14
//    }
//===============================================================================
//
//    //        Что будет выведено в консоль?
//    List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//    var unmodifiableList = Collections.unmodifiableList(list);
//        list.add(4);
//        System.out.println(unmodifiableList);
//    // 1, 2, 3, 4
//===============================================================================
//    // Найти сумму всех четных чисел с помощью Stream API
//    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
//
//
//numbers.stream()
//        .filter(num -> num % 2 == 0)
//            .mapToInt(Integer::intValue)
//    .sum();
//    .reduce(0, Integer::sum);
//
//===============================================================================
//    // Сгруппировать строки по длине
//
//    List<String> strings = List.of("cat", "dog", "apple", "bat");
//
//    Map<Integer, List<String>>= strings.stream()
//            .collect(Collectors.groupingBy(word -> word.length()));
//
//
//===============================================================================
//
//    //      Реализовать метод remove
//    List<String> list = new ArrayList<>(
//            List.of("hello", "abc1", "ab", "abc2Hello")
//    );
//    remove(list);
//
//}
//
//Удалить из коллекции все строки, начиющиеся на abc.
//Нельзя использовать Java 8 и создавать новую коллекцию
//        эталонное решения
    public static void removeHaveToFromCollection(Collection<String> strings) {
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.startsWith("abc")) {
                iterator.remove();
            }
        }
    }
//
//
//
//// Реализовать метод, который проверяет строку на Палиндром
////
////Character.isLetterOrDigit()
////Character.toLowerCase()
//
//public static boolean isPalindrome(String s) {
//
//    int leftIndex = 0;
//    int rightIndex = s.length()-1;
//
//
//    while(leftIndex < rightIndex){
//        char right = Character.toLowerCase(s.charAt(leftIndex));
//        char left = Character.toLowerCase(s.charAt(rightIndex));
//
//        if (!Character.isLetterOrDigit(right)) {
//            rightIndex--;
//            continue;
//        } else if (!Character.isLetterOrDigit(left)) {
//            leftIndex++;
//            continue;
//        }
//
//        if(!right.equals(left) {
//            return false;
//        } else else {
//            leftIndex++;
//            rightIndex--;
//        }
//    }
//    return true;
//}
}
