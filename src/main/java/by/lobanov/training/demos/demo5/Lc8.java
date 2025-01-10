package by.lobanov.training.demos.demo5;

import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Lc8 {


    // Дана коллекция интов. Найти второй самый маленький элемент в коллекции.
//    public static void main(String[] args) {
//        List< Integer > nums = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);
//
//        Optional<Integer> first = nums.stream()
//                .sorted(Comparator.reverseOrder())
//                .skip(1)
//                .findFirst();
//
//        System.out.println(first.orElse(null));
//
//    }

    //Расшифровать и вывести в одну строку разделенную запятыми. Алгоритм шифрования Base 6
    public static void main(String[] args) {
//        Base64.getDecoder().decode(String s) || return byte[] val)
        List<List<String>> lists =
                List.of(
                        List.of("SGUxMTExbC0tMGxvMjEyMy4uLi8v", "dzBvcjFsZA=="),
                        List.of("aW4=", "dGgxMTExMjMyaXM="),
                        List.of("YmVhdXQxMjNpZjMxMnVs", "ZGF5")
                );

        String str3 = lists.stream()
                .flatMap(Collection::stream)
                .map(str -> new String(Base64.getDecoder().decode(str)))
                .collect(Collectors.joining(", "));
//                .reduce((str1, str2) -> str1 + ", " + str2)
//                .ifPresent(System.out::println);

        System.out.println(str3);

    }


}
