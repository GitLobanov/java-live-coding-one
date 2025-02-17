package by.lobanov.training.demos.demo13;

import java.util.Arrays;
import java.util.stream.Stream;

/**
    Прогон на иннотех - 17.02.2025
 **/
public class LC17 {

  /*
    // task 1
    // Расшифровать и вывести в одну строку разделенную запятыми. Алгоритм шифрования Base 64 (Base64.getDecoder().decode(string s) || return byte[] val)
    List<List<String>> lists List.of (List.of("SGUXxMTExbcetMGxvMjEyMy4uLi8v", "dzBvcjFSZA=="),
    List.of("aw4-", "dGgxMTExMjMyaXM="),
    List.of("YmVhdxQxMjNpZjMxMnVs", "ZGF5"));
   */

    //Реализовать конвертер из арабских чисел в римские. Диапазон римских чисел от 1 до 3999.
    // в римских числах не может быть больше 3 одинаковых символов подряд
    // 1000, "M"
    // 900, "CM"
    // 500, "D"
    // 400, "CD"
    // 100, "C"
    // 90, "XC"
    // 50, "L"
    // 40, "XL"
    // 10, "X"
    // 9, "IX"
    // 5,"V"
    // 4, "IV"
    // 1, "II
    // 1986 - MCMLXXXVI
    public static String convert(int n) {
        return null;
    }

    //Дано: бесконечный стрим элементов от 0 до 255.
    // Задача: при помощи стримов посчитать количество вхождений каждого уникального проходящего через стрим числа, ограничив стрим на 600 элементах.
    //Нельзя использовать структуры ключ-значение. Можно создавать объекты и коллекции вне стрима
    // stream.iterate(1], i -> 1+ (int) (Math.random() * (2551) + 1))

    public void solution() {
        String[] array = new String[256];
        Stream.iterate(1, i -> 1 + (int) (Math.random() * (255 - 1) + 1))
                .forEach(d -> {
                    array[d] = array[d] + 1;
                });
    }


    /*
     Code review
     public class Service {
        @Autowired
        private final Repository rep;
        @Transactional
        public void updateUser(String name) {
        User user =rep.findUserById().get();
        setDefaultName(user, name);
        if (name != null) {
        rep.saveUser(user);
        }
        @Transactional
        public void setDefaultName(User user, string name) {
        user.setName(name);
     }
     */
}
